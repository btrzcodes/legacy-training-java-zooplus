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
    public void quality_lowers() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void sell_by_date_has_passed() throws IOException {
        Item[] items = new Item[] { new Item("Book", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void quality_never_negative() throws IOException {
        Item[] items = new Item[] { new Item("Book", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void aged_brie() throws IOException {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void quality_is_always_less_or_equal_than_50() throws IOException {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfuras_not_sold() throws IOException {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_quality_increases_by_2() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(42, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_more_than_50() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_sell_date_passed_quality_drops_to_0() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_sell_date_greater_than_11() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(41, app.items[0].quality);
    }

    @Test
    public void backstage_passes_sell_date_smaller_than_6_quality_increases_by_3() throws IOException {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(43, app.items[0].quality);
    }

    @Test
    public void aged_brie_quality_increases_by_2_after_sellIn_date() throws IOException {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(42, app.items[0].quality);
    }


}
