package fb.stepdefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import tasks.TheMenu;
import tasks.TheMessage;

import static org.assertj.core.api.BDDAssertions.not;
import static org.fluentlenium.core.filter.MatcherConstructor.contains;

public class CheckpointStepDefinitions {
    @Then("{actor} can't see my news feed")
    public void validateNewsFeed(Actor actor){
        actor.should(seeThat(TheMenu.displayed(), not(contains("News Feed"))));
    }

    @But("{actor} see FB has disable my account")
    public void validateAccountIsDisable(Actor actor){
        actor.should(
                seeThat(
                        TheMessage.displayed(), contains(
                                "Your account has been disable"
                        )
                )
        );

        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("checkpoint")
        );
    }
}
