package pages;

public class DropdownPage extends BasePage {
	
	private String dropdownLocator = "//select[@id='first']";
	
	public DropdownPage () {
		super(driver);
	}
	
	public void navigateToSandbox() {
		navigateTo("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
	}
	
	public void selectCategory(String value) {
		selectFromDropdownByValue(dropdownLocator, value);
	}
	
	
}