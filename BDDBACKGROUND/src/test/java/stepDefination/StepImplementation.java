package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepImplementation {

	static WebDriver driver;

	@Given("^I load the url \"(.+)\"$")

	public void getURL(String url) {

		WebDriverManager.chromedriver().setup();
if(driver==null) {
		 driver = new ChromeDriver();
		 
}
		driver.manage().window().maximize();

		driver.get(url);

	}

	@Then("^I enter the username and password into the respective field$")
	public void enterUsernameAndPassword(DataTable dataTable) {

		List<List<String>> datas = dataTable.asLists();

		for (int i = 0; i < datas.size(); i++) {

			for (int j = 0; j < datas.get(i).size(); j++) {

				String value = datas.get(i).get(j);

				if (j == 0) {

					WebElement username = driver.findElement(By.id("txtUsername"));

					username.clear();

					username.sendKeys(value);
				}

				if (j == 1) {

					WebElement password = driver.findElement(By.id("txtPassword"));

					password.clear();

					password.sendKeys(value);
				}
			}
		}

	}

	@Then("^I click the login button$")
	public void clickButton() {

		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^I Validate the text equals to \"(.+)\" for the element \"(.+)\"$")

	public void validate(String text, String element) {

		String value = driver.findElement(By.xpath(element)).getText();

		if (value.equals(text)) {
			System.out.println("Text found");

		} else {
			System.out.println("Text not found");
		}
	}

	@Then("^I logout of the homepage$")
	public void logout() throws Exception {

		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

	}

}
