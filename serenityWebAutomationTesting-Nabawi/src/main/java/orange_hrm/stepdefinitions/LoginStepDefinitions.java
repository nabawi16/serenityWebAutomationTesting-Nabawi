package orange_hrm.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;

public class LoginStepDefinitions {
    @Given("{actor} open Orange HRM login page")
    public void loadPage(Actor actor) throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("HRM Login"));
    }

    @When("{actor} input username and password")
    public void inputCredential(Actor actor) throws Exception{
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("USERNAME_HRM");
        String password = dotenv.get("PASSWORD_HRM");

        actor.attemptsTo(
                InputText.onField("HRM username", username),
                InputText.onField("HRM password", password)
        );
    }

    @And("{actor} can login successfully")
    public void clickLoginButton(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("HRM Log In")
        );
    }

  @Then("{actor} can login successfully")
  public void validateLoginSuccess(Actor actor) throws Exception {
    actor.attemptsTo(Ensure.thatTheCurrentPage().currentUrl().contains("/index.php/dashboard"));
        }
}
