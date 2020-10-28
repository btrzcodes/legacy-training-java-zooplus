package team.codium.legacytraining.gildedrose;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.lang.model.element.QualifiedNameable;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void At_the_end_of_each_day_items_lowers_sellIn_by_one() throws IOException {
        int quality = 5;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Book", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn, sellIn - 1);
    }

    @Test
    public void At_the_end_of_each_day_items_lowers_quality_by_one() throws IOException {
        int quality = 5;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Book", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality - 1);
    }

    @Test
    public void Once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast() throws IOException {
        int quality = 5;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Book", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality - 2);
    }

    @Test
    public void The_Quality_of_an_item_is_never_negative() throws IOException {
        int quality = 0;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Book", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality);
    }

    @Test
    public void Aged_Brie_actually_increases_in_Quality_the_older_it_gets_instead_of_decreasing() throws IOException {
        int quality = 0;
        int sellIn = 1;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality + 1);
    }

    @Test
    public void Aged_Brie_actually_increases_in_Quality_the_older_it_gets_instead_of_decreasing_twice_as_fast_when_sellIn_is_zero() throws IOException {
        int quality = 0;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality + 2);
    }

    @Test
    public void The_Quality_of_an_item_is_never_more_than_50() {
        int quality = 50;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality);
    }

    @Test
    public void Sulfuras_never_change_its_quality_and_sellIn() {

        int quality = 40;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality);
    }

    @Test
    public void Sulfuras_never_change_its_sellIn() {
        int quality = 40;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn, sellIn);
    }

    @Test
    public void backstage_sellIn_decreases_by_1() {
        int quality = 40;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn, sellIn-1);
    }

    @Test
    public void backstage_sellIn_can_be_lower_than_zero() {
        int quality = 40;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].sellIn, sellIn-1);
    }

    @Test
    public void backstage_quality_increase_by_2() {
        int quality = 40;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(app.items[0].quality, quality+2);
    }

}
