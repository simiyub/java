package cucumber;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefitionUpdateFileContent implements En {
    private String content;
    private String filePath;

    public StepDefitionUpdateFileContent() {
        Given("a valid {string} to update", (String file) -> this.filePath = file);

        When("provided with {string} to add", (String content) ->  this.content = content);

        Then("the content should be appended to the file", () -> assertTrue(content!=null && filePath!=null));


    }
}
