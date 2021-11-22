package cucumber;
import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class StepDefinitions implements En {

    private String actualAnswer;
    private String today;

    public StepDefinitions(){

        Given("today is {string}", (String day) -> {
            // Write code here that turns the phrase above into concrete actions
            today = day;
        });


        When("I ask whether it's Friday yet", () -> {
            // Write code here that turns the phrase above into concrete actions
           actualAnswer = new IsItFriday().isItFriday(today);
        });

        Then("I should be told {string}", (String expectedAnswer) -> {
            // Write code here that turns the phrase above into concrete actions
            assertEquals(expectedAnswer, actualAnswer);

        });

//        Given("today is Friday", () ->{
//            today = "Friday";
//        });



    }

    private  class IsItFriday {
        public String isItFriday(String today) {
            return "Friday".equals(today) ? "TGIF": "Nope";
        }
    }
}
