package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

public class stepsForSearchGoogle {
	
	GooglePage google = new GooglePage();
	
	@Given("I am on the Google search page")
	public void i_am_on_the_google_search_page() {
	    google.navigateToGoogle();
	}

	@When("I enter a search criteria")
	public void i_enter_a_search_criteria() {
	    google.enterSearchCriteria("Argentina");
	}

	@And("Click on the search button")
	public void click_on_the_search_button() {
	    google.clikGoogleSearch();
	}

	@Then("the results match the criteria")
	public void the_results_match_the_criteria() {
	    Assert.assertEquals("País en América del Sur", google.firstResult());
	}
	
	@Then("the result is visible")
	public void result_displayed() {
		Assert.assertTrue("Exploto todo", google.firstResultIsDisplayed());
	}
}