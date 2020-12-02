package com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;

public class MapPosition {

    private int x;
    private int y;
    private int numberOfTreasures;
    private Adventurer adventurer;
    private boolean mountain;

    public MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
        this.mountain = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setNumberOfTreasures(int numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public boolean isMountain() {
        return mountain;
    }

    public void setMountain(boolean mountain) {
        this.mountain = mountain;
    }
}
