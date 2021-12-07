import generatedocument.GenerateDocumentImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateDocumentTest {

    @Test
    void canGenerateTest1() {
        String characters ="When will I see you again ";
                String documentRequired = "niaga ese Wouy  liwl henI";
        assertTrue(new GenerateDocumentImpl().canGenerate(characters,documentRequired));
    }

    @Test
    void canGenerateTest2() {
        String characters ="When I see you again ";
        String documentRequired = "niaga ese Wouy  liwl henI";
        assertFalse(new GenerateDocumentImpl().canGenerate(characters,documentRequired));
    }

    @Test
    void canGenerateTest3() {
        String characters ="When I seeyouagain ";
        String documentRequired = "niaga ese Wouy  liwl henI";
        assertFalse(new GenerateDocumentImpl().canGenerate(characters,documentRequired));
    }
}