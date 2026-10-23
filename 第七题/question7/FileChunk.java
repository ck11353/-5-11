package question7;

import java.io.*;
import java.nio.file.*;

public class FileChunk {
    public static void fileChunk(String sourceFilePath, String outputDirPath, int chunkSize) throws IOException {
        long size = Files.size(Paths.get(sourceFilePath));
        int chunkCount = (int) (size + chunkSize - 1) / chunkSize;
        Files.createDirectories(Paths.get(outputDirPath));
        try (InputStream inputStream = new FileInputStream(sourceFilePath)){
            for (int i = 1; i <= chunkCount; i++) {
                byte [] chunk = new byte[chunkSize];
                try (OutputStream outputStream = new FileOutputStream
                        (outputDirPath + File.separator + Paths.get(sourceFilePath).getFileName().toString() + ".part" + i)){
                    int n = inputStream.read(chunk);
                    outputStream.write(chunk, 0, n);
                }
            }
        }
    }
}