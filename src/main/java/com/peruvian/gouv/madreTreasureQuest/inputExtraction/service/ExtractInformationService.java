package com.peruvian.gouv.madreTreasureQuest.inputExtraction.service;

import com.peruvian.gouv.madreTreasureQuest.adventurer.utils.AdventurerUtils;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.*;
import com.peruvian.gouv.madreTreasureQuest.inputExtraction.InformationType;

import java.util.ArrayList;
import java.util.List;

public class ExtractInformationService {

    private static final String BLANK = " ";

    public static InformationType extractInformationType (final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        final String firstElement = strings[0];
        switch (firstElement) {
            case "C" :
                return InformationType.MAP;
            case "M" :
                return InformationType.MOUNTAIN;
            case "T" :
                return InformationType.TREASURER;
            case "A" :
                return InformationType.ADVENTURER;
        }
        return null;
    }

    public static Position extractMapInformationDimension (final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return new Position(Integer.valueOf(strings[2]), Integer.valueOf(strings[4]));
    }

    public static Position extractTreasurerInformationPosition(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return new Position(Integer.valueOf(strings[2]), Integer.valueOf(strings[4]));
    }

    public static int extractNumberOfTreasuresInInformationLine(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return Integer.valueOf(strings[6]);
    }

    public static Adventurer extractAdventurerInformation(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        final Position position = new Position(Integer.valueOf(strings[4]), Integer.valueOf(strings[6]));
        final String name = strings[2];
        final Orientation orientation =  AdventurerUtils.getOrientationFromString(strings[8]);
        final List<AdventurerMovement> adventurerMovements = extractAdventurerMovement(strings[10]);
        return new Adventurer(name,position,orientation, adventurerMovements, 0);
    }

    private static List<AdventurerMovement> extractAdventurerMovement(String smoves) {
        List<AdventurerMovement> adventurerMovements = new ArrayList<>();
        final String[] moves = smoves.split("");
        for (String move : moves) {
            final Action actionFromString = AdventurerUtils.getActionFromString(move);
            if(actionFromString != null) {
                adventurerMovements.add(new AdventurerMovement(actionFromString, false));
            }
        }
        return adventurerMovements;
    }

    public static boolean isValidMapInformationLine(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return strings.length == 5 && informationLine.startsWith("C");
    }

    public static boolean isValidMountainInformationLine(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return strings.length == 5 && informationLine.startsWith("M");
    }

    public static boolean isValidTreasurerInformationLine(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return strings.length == 7 && informationLine.startsWith("T");
    }

    public static boolean isValidAdventurerInformationLine(final String informationLine) {
        final String[] strings = informationLine.split(BLANK);
        return strings.length == 11 && informationLine.startsWith("A");
    }

    public static boolean isAvalidTypeLine(String informationLine) {
        final InformationType informationType = extractInformationType(informationLine);
        return informationType !=null;
    }


}
