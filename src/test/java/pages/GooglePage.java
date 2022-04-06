package pages;

public class GooglePage extends BasePage {
	
	private String searchButton = "//input[@value='Buscar con Google']";
	private String searchTextField = "//input[@title='Buscar']";
	private String firstResult= "//span[contains(text(),'País en América del Sur')]";
	
	public GooglePage () {
		super(driver);
	}
	
	public void navigateToGoogle() {
		navigateTo("https://www.google.com");
	}
	
	public void clikGoogleSearch() {
		clickElement(searchButton);
	}
	
	public void enterSearchCriteria(String criteria) {
		write(searchTextField, criteria);
	}
	
	public String firstResult() {
		return textFromElement(firstResult);
	}
	
	public boolean firstResultIsDisplayed() {
		return elementIsDisplayed(firstResult);
	}
}
