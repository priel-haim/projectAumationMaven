package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseASubscriptionThatSuitsYou extends MenuPage {

	@FindBy(css = "#pills-monthly a.select-cta>button")
	private List<WebElement> TheUpgradePriceBtn;
	@FindBy(css = ".e-title")
	private WebElement ChooseSuitableSubscription;

	// for assert
	@FindBy(css = "#pills-monthly div:nth-child(3) a>button")
	private WebElement Business;

	public ChooseASubscriptionThatSuitsYou(WebDriver driver) {
		super(driver);
	}

	public void TypeUpgrade(String upgrade) {
		List<WebElement> list = TheUpgradePriceBtn;
		for (WebElement TheUpgradePriceBtn : list) {
			if (getText(TheUpgradePriceBtn).contains(upgrade)) {
				actions.clickAndHold(TheUpgradePriceBtn).click().build().perform();
				break;
			}
			sleep(1000);
		}

	}

	public String GetChooseSuitableSubscription() {
		return getText(ChooseSuitableSubscription);
	}

	public String GetChooseTypeUpgade() {
		return getText(Business);
	}
}
