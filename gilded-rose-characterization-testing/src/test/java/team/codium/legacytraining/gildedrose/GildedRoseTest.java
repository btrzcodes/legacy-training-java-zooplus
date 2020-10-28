package team.codium.legacytraining.gildedrose;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    // At the end of each day items lowers quality and sellIn by one

    @Test
    public void name_of_item_is_not_changing_when_the_quality_is_lowered_by_one() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
    }

    @Test
    public void at_the_end_of_each_day_the_quality_lowers_by_one() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void at_the_end_of_each_day_the_sellIn_lowers_by_one() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void when_sellIn_has_passed_quality_lowers_twice_as_fast() throws IOException {
        Item[] items = new Item[] { new Item("Book", -1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void quality_is_not_negative() throws IOException {
        Item[] items = new Item[] { new Item("Book", 1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void quality_is_not_negative_when_decreasing_twice_as_fast() throws IOException {
        Item[] items = new Item[] { new Item("Book", -1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void quality_increase_when_name_is_aged_brie() throws IOException {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void quality_is_not_bigger_than_50_when_Aged_Brie() throws IOException {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    // "Sulfuras" never has to be sold nor decreases in Quality (quality and sellIn does not change)

    @Test
    public void when_name_is_Sulfuras_quality_not_changes() throws IOException {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void when_name_is_Sulfuras_sellIn_not_changes() throws IOException {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void when_name_is_backstage_quality_increases_three_times_faster() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void when_name_is_backstage_sellIn_decreases_by_one() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
    }
}
