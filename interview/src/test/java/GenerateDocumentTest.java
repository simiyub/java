import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateDocumentTest {

    @Test
    void canGenerate() {
        String characters ="Bste!hetsi ogEAxpelrt x ";
                String documentRequired = "AlgoExpert is the Best";
        assertTrue(new GenerateDocumentImpl().canGenerate(characters,documentRequired));
    }
}