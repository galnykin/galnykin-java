package by.nsv.pages;

import by.nsv.webdriver.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private final By SEARCH_INPUT = By.cssSelector("input#title-search-input_fixed");
    private final By SEARCH_BUTTON = By.cssSelector("#header button#subserch");
    private final By SEARCH_RESULT_CARDS = By.cssSelector("div.display_list > div.list_item_wrapp");
    private final By SEARCH_RESULT_ITEM_TITLE_TEXT = By.cssSelector("span[itemprop='name']");

    public SearchPage sendKeysSearch(String search) {
        ElementUtils.sendKeys(SEARCH_INPUT, search);
        return this;
    }

    public SearchPage startSearch() {
        ElementUtils.click(SEARCH_BUTTON);
        return this;
    }

    public WebElement getSearchResultCard(int index) {
        List<WebElement> cards = ElementUtils.findElements(SEARCH_RESULT_CARDS);
        return cards.get(index);
    }

    public WebElement getSearchResultFirstItem() {
        return getSearchResultCard(0);
    }

    public String getSearchResultFirstItemTitleText() {
        List<String> titles = getSearchResultItemsTitleText();
        return titles.isEmpty() ? null : titles.get(0);
    }

    public List<String> getSearchResultItemsTitleText() {
        List<WebElement> cards = ElementUtils.findElements(SEARCH_RESULT_CARDS);
        List<String> titles = new java.util.ArrayList<>();

        for (WebElement card : cards) {
            WebElement titleElement = ElementUtils.findElement(card, SEARCH_RESULT_ITEM_TITLE_TEXT);
            titles.add(titleElement.getText());
        }
        return titles;
    }
}
