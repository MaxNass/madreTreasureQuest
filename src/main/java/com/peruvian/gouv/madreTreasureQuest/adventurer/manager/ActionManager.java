package com.peruvian.gouv.madreTreasureQuest.adventurer.manager;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Orientation;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Position;
import com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap.MadreDeDiosMap;
import com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap.MapPosition;

public class ActionManager {

    public static void moveForward(final MadreDeDiosMap madreDeDiosMap,
                            final Adventurer adventurer) {
        final Orientation orientation = adventurer.getOrientation();
        final Position adventurerPosition = adventurer.getPosition();
        final Position newPosition = getNewAdventurerPosition(adventurerPosition, orientation);

        final boolean isInsideTheMapLimits = isInsideTheMapLimits(newPosition, madreDeDiosMap);
        final boolean isNotHavingAMountainInFrontOfHim = isNotHavingAMountainInFrontOfHim (newPosition, madreDeDiosMap);
        final boolean isThereAnyTreasureInFrontOfHim = isThereAnyTreasureInFrontOfHim(newPosition, madreDeDiosMap);

        if(isInsideTheMapLimits) {

            if(isNotHavingAMountainInFrontOfHim) {

                adventurer.setPosition(newPosition);
                madreDeDiosMap.addOrUpdateMadreDeDiosMapWithAdventurer(adventurer, newPosition.getX(), newPosition.getY());

                if (isThereAnyTreasureInFrontOfHim) {
                    adventurer.incrementNumberOfTreasuresFound();
                    madreDeDiosMap.deleteTreasureToMadreDeDiosMap(newPosition.getX(), newPosition.getY());
                }
            } else {
                System.out.println("There is a mountain in front of him he can't go there");
            }
        } else {
            System.out.println("This position in not available on the map");
        }
    }

    public static Position getNewAdventurerPosition(final Position oldPosition, final Orientation orientation) {
        final Position newPosition = new Position();
        switch (orientation) {
            case NORTH:
                newPosition.setX(oldPosition.getX() - 1);
                newPosition.setY(oldPosition.getY());
                break;
            case EAST:
                newPosition.setX(oldPosition.getX());
                newPosition.setY(oldPosition.getY() + 1);
                break;
            case SOUTH:
                newPosition.setX(oldPosition.getX() + 1);
                newPosition.setY(oldPosition.getY());
                break;
            case WEST:
                newPosition.setX(oldPosition.getX());
                newPosition.setY(oldPosition.getY() -1);
                break;
        }
        return newPosition;
    }

    public static void turnLeft(final Adventurer adventurer) {

        final Orientation direction = adventurer.getOrientation();
        switch (direction) {
            case NORTH :
                adventurer.setOrientation(Orientation.WEST);
                break;
            case SOUTH :
                adventurer.setOrientation(Orientation.EAST);
                break;
            case EAST :
                adventurer.setOrientation(Orientation.NORTH);
                break;
            case WEST :
                adventurer.setOrientation(Orientation.SOUTH);
                break;
        }
    }

    public static void turnRight(final Adventurer adventurer) {

        final Orientation direction = adventurer.getOrientation();
        switch (direction) {
            case NORTH :
                adventurer.setOrientation(Orientation.EAST);
                break;
            case SOUTH :
                adventurer.setOrientation(Orientation.WEST);
                break;
            case EAST :
                adventurer.setOrientation(Orientation.SOUTH);
                break;
            case WEST :
                adventurer.setOrientation(Orientation.NORTH);
                break;
        }

    }

    public static boolean isNotHavingAMountainInFrontOfHim(final Position adventurerNewPosition,
                                                           final MadreDeDiosMap madreDeDiosMap) {
        final int newX = adventurerNewPosition.getX();
        final int newY = adventurerNewPosition.getY();
        final MapPosition[][] map = madreDeDiosMap.getMap();
        final boolean isNotHavingAMountainInFrontOfHim = map[newX][newY].isMountain();
        return !isNotHavingAMountainInFrontOfHim;
    }

    public static boolean isInsideTheMapLimits(final Position adventurerNewPosition,
                                         final MadreDeDiosMap madreDeDiosMap) {
        final int newX = adventurerNewPosition.getX();
        final int newY = adventurerNewPosition.getY();
        final int numberOfColumns = madreDeDiosMap.getNumberOfColumns();
        final int numberOfLines = madreDeDiosMap.getNumberOfLines();
        final boolean isInsideTheMapLimits =
                        newX >=0 &&
                        newY >=0 &&
                        numberOfLines > newX &&
                        numberOfColumns > newY;
        return isInsideTheMapLimits ;
    }

    public static boolean isThereAnyTreasureInFrontOfHim(final Position adventurerNewPosition,
                                                   final MadreDeDiosMap madreDeDiosMap) {
        final int newX = adventurerNewPosition.getX();
        final int newY = adventurerNewPosition.getY();
        final MapPosition[][] map = madreDeDiosMap.getMap();
        final boolean isThereAnyTreasureInFrontOfHim = map[newX][newY].getNumberOfTreasures() > 0;
        return isThereAnyTreasureInFrontOfHim;
    }

}
