package team.codium.legacytraining.gildedrose;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void xxx() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
    }

    @Test
    public void at_the_end_of_each_day_items_lowers_quality_by_one() {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,4);
    }

    @Test
    public void at_the_end_of_each_day_items_lowers_sellIn_by_one() {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn,9);
    }

    @Test
    public void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        Item[] items = new Item[] { new Item("Book", 0, 6),new Item("Book2", 0, 4)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,4);
        assertEquals(app.items[1].quality,2);
    }

    @Test
    public void the_quality_of_an_item_is_never_negative() {
        Item[] items = new Item[] { new Item("Book", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,0);
    }

    @Test
    public void once_the_sell_by_date_has_passed_quality_should_degrades_twice_as_fast_and_the_quality_of_an_item_is_never_negative() {
        Item[] items = new Item[] { new Item("Book3", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,0);
    }

    @Test
    public void aged_brie_actually_increases_in_Quality_the_older_it_gets_instead_of_decreasing() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,11);
    }

    @Test
    public void aged_brie_actually_increases_in_Quality_by_2_when_sellin_is_lower_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,12);
    }

    @Test
    public void the_quality_of_an_item_is_never_more_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,50);
    }

    @Test
    public void sulfuras_never_has_to_be_sold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn,10);
    }

    @Test
    public void sulfuras_never_decreases_in_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,10);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_sellin_decreases() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn,9);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_quality_increased_by_2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,12);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_is_capped_at_quality_50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,50);
        assertEquals(app.items[1].quality,50);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_quality_is_0_when_sellin_is_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,0);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_quality_increases_by_2_if_sellin_is_lower_than_11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,42);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_quality_increases_by_one_if_sellin_is_greater_equals_11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,41);
    }

    @Test
    public void backstage_passes_to_a_TAFKAL80ETC_concert_quality_increases_by_3_if_sellin_is_lower_than_6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality,43);
    }

}
