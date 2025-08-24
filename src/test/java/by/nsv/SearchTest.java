package by.nsv;

import by.nsv.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    SearchPage searchPage;

    @BeforeEach
    public void setUpSearch() {
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Поиск конкретного товара")
    public void testSearchConcreteItem() {
        String expectedItem = "Мобильный телефон Maxvi P100 (синий)";
        searchPage.sendKeysSearch(expectedItem)
                .startSearch();

        String actualItem = searchPage.getSearchResultFirstItemTitleText();
        assertEquals(expectedItem, actualItem, "Найденный товар не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Поиск товаров по ключевому слову 'телефон'")
    public void testSearchByKeyword() {
        String keyword = "телефон";
        searchPage.sendKeysSearch(keyword)
                .startSearch();

        List<String> titles = searchPage.getSearchResultItemsTitleText();

        assertFalse(titles.isEmpty(), "Результаты поиска пустые");
        for (String title : titles) {
            assertTrue(title.toLowerCase().contains(keyword),
                    "В названии товара нет ключевого слова: " + title);
        }
    }

    @Test
    @DisplayName("Поиск несуществующего товара")
    public void testSearchNothingFound() {
        String searchQuery = "ытадлцощжш4окдаьвь";
        searchPage.sendKeysSearch(searchQuery)
                .startSearch();

        List<String> titles = searchPage.getSearchResultItemsTitleText();
        assertTrue(titles.isEmpty(), "Ожидалось, что результаты будут пустыми");
    }
}
