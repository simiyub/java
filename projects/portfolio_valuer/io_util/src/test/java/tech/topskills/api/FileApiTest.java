package tech.topskills.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.topskills.api.FileApi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FileApiTest {
    private FileApi api;

    @BeforeEach
    void setUp() {
        api = new FileApi();
    }

    @Test
    void canUpdateFileContent() {
        assertDoesNotThrow(()-> api.updateFileContent(null, null));
    }

    @Test
    void canCreateFile() {
        assertDoesNotThrow(()-> api.createFile(null, null));
    }

    @Test
    void canReadFileContent() {
        assertDoesNotThrow(()-> api.readFileContent(null));
    }

    @Test
    void canDeleteFile() {
        assertDoesNotThrow(()-> api.deleteFile(null));
    }
}