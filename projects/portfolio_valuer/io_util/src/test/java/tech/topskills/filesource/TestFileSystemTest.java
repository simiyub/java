package tech.topskills.filesource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFileSystemTest {
    private FileSystem fileSystem;

    @BeforeEach
    void setUp() {
        fileSystem = new TestFileSystem();
    }

    @Test
    void canCreateFile() {
        assertDoesNotThrow(() ->fileSystem.createFile(null,null));
    }

    @Test
    void canReadFileContent() {
        assertDoesNotThrow(() ->fileSystem.readFile(null));
    }

    @Test
    void canUpdateFileContent() {
        assertDoesNotThrow(() ->fileSystem.updateFile(null,null));
    }

    @Test
    void canDeleteFile() {
        assertDoesNotThrow(() ->fileSystem.deleteFile(null));
    }
}