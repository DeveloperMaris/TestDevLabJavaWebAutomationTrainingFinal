package pages.homepage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomepagePageObject {

    // --- Selectors ---

    private SelenideElement getMainSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getBookingMenu(String menuLink) {
//        return $(By.xpath("//div[@id='body-section']/descendant::a[span[contains(lower-case(text()), '" + menuLink + "')]]"));
        // TODO: This could be updated to search for inner span element with title
        return $("div#body-section a[href*='" + menuLink + "' i]");
    }

    // --- Methods ---

    public void selectBookingMenu(String menuLink) {
        getBookingMenu(menuLink).click();
    }

    // --- Validation Methods ---

    public boolean isMainSectionVisible() {
        return getMainSection().isDisplayed();
    }

}
