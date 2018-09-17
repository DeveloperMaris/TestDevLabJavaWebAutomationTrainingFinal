package pages.homepage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomepagePageObject {

    // Homepage flight section page object
    public FlightSectionHomepagePageObject flightSection = new FlightSectionHomepagePageObject();

    // --- Selectors ---

    private SelenideElement getMainSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getBookingMenu(String menuName) {
        // return $(By.xpath("//div[@id='body-section']/descendant::a[span[contains(lower-case(text()), '" + menuLink + "')]]"));
        // return $("div#body-section a[href*='" + menuLink + "' i]");
        return $(By.xpath("//div[@id='body-section']/descendant::a[span[contains(text(), '" + menuName + "')]]"));
    }

    // --- Methods ---

    public void selectBookingMenu(String menuName) {
        // FIXME: Don't like this approach, but it works and it is generic, while the Page will contain menus named with Capital first character.
        String formattedMenuName = menuName.substring(0, 1).toUpperCase() + menuName.substring(1).toLowerCase();
        getBookingMenu(formattedMenuName).click();
    }

    // --- Validation Methods ---

    public boolean isMainSectionVisible() {
        return getMainSection().isDisplayed();
    }

}
