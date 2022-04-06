package steps;

import io.cucumber.java.en.*;
import pages.DropdownPage;

public class StepsForDropdown {
	
	DropdownPage dropdown = new DropdownPage();
	
	@Given("I navigate to the sandbox page")
	public void i_am_on_the_google_search_page() {
	    dropdown.navigateToSandbox();
	}

	@And("select a value from the dropdown")
	public void click_on_the_search_button() {
	    dropdown.selectCategory("Google");
	}
	
	
}