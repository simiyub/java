package tech.topskills.api;

import tech.topskills.api.FileApi;

public class FileApiImpl implements FileApi {
    @Override
    public void createFile(String filePath, String fileContent) {
        throw new UnsupportedOperationException("create file feature not available.");

    }

    @Override
    public String readFileContent(String filePath) {
        throw new UnsupportedOperationException("read file feature not available.");
    }

    @Override
    public void deleteFile(String filePath) {
        throw new UnsupportedOperationException("delete file feature not available.");
    }

    @Override
    public void updateFileContent(String path, String content) {

        throw new UnsupportedOperationException("update file feature not available.");

    }
}
