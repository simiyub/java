package tech.topskills.filesource;

import java.nio.file.Path;

public class TestFileSystem implements FileSystem {
    @Override
    public void createFile(Path path, String content) {
        throw new UnsupportedOperationException("create file feature not available.");
    }

    @Override
    public String readFile(Path path) {
        throw new UnsupportedOperationException("read file feature not available.");
    }

    @Override
    public void updateFile(Path filePath, String newContent) {
        throw new UnsupportedOperationException("update file feature not available.");
    }

    @Override
    public void deleteFile(Path filePath) {
        throw new UnsupportedOperationException("delete file feature not available.");
    }
}
