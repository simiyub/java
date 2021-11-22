package tech.topskills.filesource;

public class FileSourceFactory {
    private static FileSystem fileSystem;
    public FileSourceFactory() {
        fileSystem = new TestFileSystem();
    }
    public FileSourceFactory() {
        fileSystem = new TestFileSystem();
    }


    public static FileSystem getFileSource(){
        return fileSystem == null ? new TestFileSystem(): fileSystem;
    }
}
