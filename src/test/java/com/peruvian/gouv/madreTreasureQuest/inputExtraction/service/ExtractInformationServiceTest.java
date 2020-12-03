package com.peruvian.gouv.madreTreasureQuest.inputExtraction.service;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Orientation;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Position;
import com.peruvian.gouv.madreTreasureQuest.inputExtraction.InformationType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtractInformationServiceTest {

    @Test
    public void test_extract_information_type() {
        final String info = "A - Lara - 1 - 1 - S - AADADAGGA";
        final InformationType informationType = ExtractInformationService.extractInformationType(info);
        assertEquals(InformationType.ADVENTURER, informationType);
    }

    @Test
    public void test_extract_map_information_dimension() {
        final String info = "C - 3 - 4";
        final Position position = ExtractInformationService.extractMapInformationDimension(info);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());

    }

    @Test
    public void test_extract_treasurer_information_position() {
        final String info = "T - 1 - 3 - 3";
        final Position position = ExtractInformationService.extractTreasurerInformationPosition(info);
        assertEquals(1, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    public void test_extract_number_Of_treasures_in_information_line() {
        final String info = "T - 1 - 3 - 3";
        final int numberOfTreasuresInInformationLine = ExtractInformationService.extractNumberOfTreasuresInInformationLine(info);
        assertEquals(3, numberOfTreasuresInInformationLine);
    }

    @Test
    public void test_extract_adventurer_information() {
        final String info = "A - Lara - 1 - 1 - S - AADADAGGA";
        final Adventurer adventurer = ExtractInformationService.extractAdventurerInformation(info);
        assertEquals("Lara", adventurer.getName());
        assertEquals(1, adventurer.getPosition().getX());
        assertEquals(1, adventurer.getPosition().getY());
        assertEquals(Orientation.SOUTH, adventurer.getOrientation());
    }

    @Test
    public void test_is_valid_map_information_line() {
        final String info = "C - 3 - 4";
        final boolean validMapInformationLine = ExtractInformationService.isValidMapInformationLine(info);
        assertEquals(true, validMapInformationLine);
    }

    @Test
    public void test_is_not_valid_map_information_line() {
        final String info = "C - 3 - 4 - 6";
        final boolean validMapInformationLine = ExtractInformationService.isValidMapInformationLine(info);
        assertEquals(false, validMapInformationLine);
    }

    @Test
    public void test_is_valid_mountain_information_line() {
        final String info = "M - 2 - 1";
        final boolean validMountainInformationLine = ExtractInformationService.isValidMountainInformationLine(info);
        assertEquals(true, validMountainInformationLine);

    }

    @Test
    public void test_is_not_valid_mountain_information_line() {
        final String info = "M - 2 - 1 - 6";
        final boolean validMountainInformationLine = ExtractInformationService.isValidMountainInformationLine(info);
        assertEquals(false, validMountainInformationLine);

    }

    @Test
    public void test_is_valid_treasurer_information_line() {
        final String info = "T - 1 - 3 - 3";
        final boolean validTreasurerInformationLine = ExtractInformationService.isValidTreasurerInformationLine(info);
        assertEquals(true, validTreasurerInformationLine);
    }

    @Test
    public void test_is_not_valid_treasurer_information_line() {
        final String info = "T - 1 - 3 - 3 - 8";
        final boolean validTreasurerInformationLine = ExtractInformationService.isValidTreasurerInformationLine(info);
        assertEquals(false, validTreasurerInformationLine);
    }

    @Test
    public void test_is_valid_adventurer_information_line() {
        final String info = "A - Lara - 1 - 1 - S - AADADAGGA";
        final boolean validTreasurerInformationLine = ExtractInformationService.isValidAdventurerInformationLine(info);
        assertEquals(true, validTreasurerInformationLine);
    }

    @Test
    public void test_is_not_valid_adventurer_information_line() {
        final String info = "A - Lara - 1 - 1 - S - AADADAGGA - 15";
        final boolean validTreasurerInformationLine = ExtractInformationService.isValidAdventurerInformationLine(info);
        assertEquals(false, validTreasurerInformationLine);
    }

    @Test
    public void test_is_a_valid_type_line() {
        final String info = "A - Lara - 1 - 1 - S - AADADAGGA";
        final InformationType informationType = ExtractInformationService.extractInformationType(info);
        assertEquals(InformationType.ADVENTURER, informationType);
    }

    @Test
    public void test_is_not_a_valid_type_line() {
        final String info = "F - Lara - 1 - 1 - S - AADADAGGA";
        final InformationType informationType = ExtractInformationService.extractInformationType(info);
        assertEquals(null, informationType);
    }
}