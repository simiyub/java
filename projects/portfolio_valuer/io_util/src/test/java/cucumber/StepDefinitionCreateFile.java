package cucumber;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitionCreateFile implements En {
    private String fileName;
    private String newFileName;

    public StepDefinitionCreateFile() {

        Given("a valid {string} path name", (String string) -> fileName = string );

        When("requested to create a file", () -> newFileName = fileName);

        Then("we create a file in that {string}", (String string) -> assertEquals(newFileName,fileName));


    }
}
