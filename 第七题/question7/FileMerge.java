package question7;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileMerge {
    public static void fileMerge(String targetDirPath, String originalFileName, String mergedFilePath)
            throws IOException {
        Path dir = Paths.get(targetDirPath);
        File[] parts = dir.toFile().listFiles(
                (d, name) -> name.startsWith(originalFileName + ".part"));
        if (parts == null || parts.length == 0) {
            System.out.println("未找到目标目录：" + targetDirPath);
            return;
        }
        Arrays.sort(parts, Comparator.comparingInt(f -> partIndex(f.getName())));
        for (File f : parts) System.out.println("  " + f.getName());
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(mergedFilePath))){
            for (File part : parts){
                try (InputStream in = new BufferedInputStream(new FileInputStream(part))){
                    byte[] buf = new byte[1024];
                    int n;
                    while ((n = in.read(buf)) != -1){
                        out.write(buf, 0, n);
                    }
                }
            }
        }
        long sizeTotalActual = Files.size(Paths.get(mergedFilePath));
        long sizeTotalExpected = 0;
        for (File part : parts) {
            sizeTotalExpected += Files.size(part.toPath());
        }
        if (sizeTotalActual == sizeTotalExpected){
            for (File part : parts) {
                Files.deleteIfExists(part.toPath());
            }
        }else {
            throw new IOException("Size mismatch: " + sizeTotalExpected + " != " + sizeTotalActual);
        }
    }
    private static int partIndex(String fileName) {
        int partIndex = fileName.lastIndexOf(".part");
        return Integer.parseInt(fileName.substring(partIndex + 5));
    }
}
