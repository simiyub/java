package cucumber;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitionDeleteFile implements En {
    private String fileName;
    private String fileToDelete;

    public StepDefinitionDeleteFile() {
        Given("a valid {string} path", (String string) -> fileName=string);

        When("requested to delete", () -> fileToDelete = fileName);

        Then("delete the file", () -> assertEquals(fileToDelete,fileName));


    }
}
