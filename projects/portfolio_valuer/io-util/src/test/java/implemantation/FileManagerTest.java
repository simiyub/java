package implemantation;

import api.FileManager;
import implementation.FileManagerExcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FileManagerTest {
    private FileManager fileManager;

    @BeforeEach
    void setUp() {
        fileManager = new FileManagerExcel();
    }

    @Test
    void canUpdateFileContent() {
        assertDoesNotThrow(()->fileManager.updateFileContent(null, null));
    }
}