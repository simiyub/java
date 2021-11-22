package c;

import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class StepDefinitions implements En {
    private String fileName;
    private String content;

    public StepDefinitions() {
        Given("a valid file {string}", (String file) -> fileName = file);

        When("we ask for content", () ->  content =fileName);//FileContentReader.readFile(fileName));

        Then("we should have the {string} returned",(String expectedContent) -> assertEquals(content, expectedContent));
    }

   private static class FileContentReader{
        static String readFile(String fileName){
            return fileName;
        }
    }
}
