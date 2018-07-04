import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class GildedRoseTest {

    public static class AllItems {

        @Test
        public void ItemNameNeverChanges_ForAllItems() {
            Item[] items = new Item[] { new Item("Standard Item", 0, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Standard Item", app.items[0].name);
        }

        @Test
        public void updateQuality_DecrementsSellInByOne_ForAllItems() {
            Item[] items = new Item[] { new Item("Standard Item", 5, 17)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(4, app.items[0].sellIn);
        }

        @Ignore
        @Test
        public void quality_IsNeverLessThanZero_ForAllItems() {
            Item[] items = new Item[] { new Item("Standard Item", 1, -1)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    public static class StandardItems {

        @Test
        public void updateQuality_DecrementsQualityByOne_WhenPositiveSellIn() {
            Item[] items = new Item[] { new Item("Standard Item", 5, 12) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(11, app.items[0].quality);
        }

        @Test
        public void updateQuality_DecrementsQualityByTwo_WhenNegativeSellIn() {
            Item[] items = new Item[] {new Item("Standard Item", 0, 8)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(6, app.items[0].quality);
        }

        @Test
        public void quality_IsNeverGreaterThanFifty_ForStandardItem() {
            Item[] items = new Item[] { new Item("Standard Item", 10, 51)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

    public static class AgedBrie {

        @Test
        public void updateQuality_IncreasesQualityOfAgedBrieByOne() {
            Item[] items = new Item[] { new Item("Aged Brie", 6, 11)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
        }
    }
}