package com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;

public class MadreDeDiosMap {

    private MapPosition[][] map;

    public int getNumberOfLines() {
       return this.map.length;
    }

    public int getNumberOfColumns() {
        return this.map[0].length;
    }

    public MapPosition[][] getMap() {
        return map;
    }

    public MapPosition[][] createMatrix(final Integer numberOfLines,
                             final Integer numberOfColumns) {
        this.map = new MapPosition[numberOfLines][numberOfColumns];
        return map;
    }

    public void displayMap() {
        for (int i = 0; i<this.getNumberOfLines(); i++) {
            for (int j = 0; j<this.getNumberOfColumns(); j++) {
                String value = (this.map[i][j] == null) ? "." : displayPositionValue(this.map[i][j]);
                System.out.print(value);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    private String displayPositionValue(MapPosition mapPosition) {
        String displayValue = "";
        if (mapPosition.isMountain()) {
            displayValue = "M";
        } else if (mapPosition.getAdventurer() != null) {
            displayValue = mapPosition.getAdventurer().getName();
            if (mapPosition.getNumberOfTreasures() > 0) {
                displayValue = displayValue + "| T=" + mapPosition.getNumberOfTreasures();
            }
        }
        return displayValue;
    }

    public void addTreasuresToMadreDeDiosMap(final Integer x, final Integer y, final Integer numberOfTreasures) {
        final MapPosition mapPosition = new MapPosition(x,y);
        mapPosition.setNumberOfTreasures(numberOfTreasures);
        map[x][y] = mapPosition;
    }

    public void deleteTreasureToMadreDeDiosMap(final Integer x, final Integer y) {
        final int nbTreasures = map[x][y].getNumberOfTreasures();
        map[x][y].setNumberOfTreasures(nbTreasures - 1);
    }

    public void addMountainToMadreDeDiosMap(final Integer x, final Integer y) {
        final MapPosition mapPosition = new MapPosition(x,y);
        mapPosition.setMountain(true);
        map[x][y] = mapPosition;
    }

    public void addOrUpdateMadreDeDiosMapWithAdventurer(final Adventurer adventurer, final int x, final int y) {
        if (map[x][y] == null) {
            final MapPosition mapPosition = new MapPosition(x,y);
            mapPosition.setAdventurer(adventurer);
        } else {
            map[x][y].setAdventurer(adventurer);
        }
    }
}
