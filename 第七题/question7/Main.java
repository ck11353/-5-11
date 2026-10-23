package question7;

import java.io.*;
import java.nio.file.*;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        Path base = Paths.get("target", "q7");
        Files.createDirectories(base);
        Path source = base.resolve("bigfile.bin");
        Path partsDir = base.resolve("parts");
        Path merged = base.resolve("merged.bin");
        int chunkSize = 256 * 1024;
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(source))){
            for (int i = 0; i < 1029 * 1024 + 5; i++) {
                out.write(i);
            }
        }
        FileChunk.fileChunk(source.toString(), partsDir.toString(), chunkSize);
        out.println("分片完成");
        File[] all = partsDir.toFile().listFiles();
        out.println("partsDir里有" + all.length + "个文件");
        FileMerge.fileMerge(partsDir.toString(), "bigfile.bin", merged.toString());
        out.println("合并完成");
        boolean isSameSize = Files.size(source) == Files.size(merged);
        out.println("源文件大小 = 合并文件大小 ?  -> " + isSameSize);
        out.println("Files.mismatch = " + Files.mismatch(source, merged));
        out.println("partsDir里还剩几个文件 = " + partsDir.toFile().listFiles().length);
        Files.deleteIfExists(merged);
        Files.deleteIfExists(source);
        Files.deleteIfExists(partsDir);
        Files.deleteIfExists(base);

    }
}
