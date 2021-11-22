package cucumber;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitionReadFileContent implements En {
    private String fileName;
    private static String content;

   public StepDefinitionReadFileContent() {
        Given("a valid {string} with {string} to read", (String file, String contentToRead) -> {
            fileName = file;
            content = contentToRead;
        });

        When("we ask for content", () ->  content = FileContentReader.readFile(fileName));

        Then("we should have {string} returned",
                (String expectedContent) -> assertEquals(content, expectedContent));
    }

   private static class FileContentReader{
        static String readFile(String fileName){
            return content;
        }
    }
}
