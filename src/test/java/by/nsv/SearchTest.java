package by.nsv;

import by.nsv.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest extends BaseTest {

    SearchPage searchPage;

    @BeforeEach
    void setUpSearch() {
        searchPage = new SearchPage();
    }

    @Nested
    class PositiveTests {
        @ParameterizedTest
        @ValueSource(strings = {
                "Мобильный телефон Maxvi P100 (синий)",
                "Смартфон HONOR Magic7 Pro 12GB/512GB (серый)",
                "Робот-пылесос Roborock Q8 Max Pro RRA1TAL Q8MRP52-02 (с русской озвучкой, черный)"
        })
        @DisplayName("Поиск конкретного товара")
        void testSearchConcreteItem(String expectedItem) {
            assertEquals(
                    expectedItem,
                    searchPage.sendKeysSearch(expectedItem)
                            .startSearch()
                            .getSearchResultFirstItemTitleText(),
                    "Найденный товар не совпадает с ожидаемым"
            );
        }

        @Test
        @Tag("smoke")
        @DisplayName("Поиск товаров по ключевому слову 'телефон'")
        void testSearchByKeyword() {
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
    }

    @Nested
    class NegativeTests {
        @Test
        @DisplayName("Поиск несуществующего товара")
        void testSearchNothingFound() {
            String searchQuery = "ытадлцощжш4окдаьвь";
            searchPage.sendKeysSearch(searchQuery)
                    .startSearch();

            List<String> titles = searchPage.getSearchResultItemsTitleText();
            assertTrue(titles.isEmpty(), "Ожидалось, что результаты будут пустыми");
        }
    }
}
