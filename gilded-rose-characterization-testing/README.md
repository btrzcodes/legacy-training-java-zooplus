# Gilded Rose characterization testing

## Description:
This kata has a legacy code to practice writing unit tests and characterization tests.

There is an example test to simplify writing the first test.

You can to run the test with coverage in order to know if all the paths have been executed.

You can to run [PIT mutation testing](http://pitest.org/) in order to know if all the boundaries have been ensured.

# Business requirements
- At the end of each day items lowers quality and sellIn by one
- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- "Aged Brie" actually increases in Quality the older it gets instead of decreasing
- The Quality of an item is never more than 50
- "Sulfuras" never has to be sold nor decreases in Quality (quality and sellIn does not change)
- "Backstage passes": We don’t know the requirements :(


## Goals:
- Write unit tests that validate the business requirements
- Use the characterization test technique 
- Use the code coverage to identify the Backstage passes requirements and try to reach 100% coverage.
- As code coverage is not enough, use mutation testing to find extra requirements writing new tests.

Mutation testing
======================================

How to run mutation testing:

    mvn org.pitest:pitest-maven:mutationCoverage
    

Reports are generated under the folder: target/pit-reports

Open the index.html file in a browser.

## Inspired by:
https://github.com/emilybache/GildedRose-Refactoring-Kata/

Emily Bache @emilybache