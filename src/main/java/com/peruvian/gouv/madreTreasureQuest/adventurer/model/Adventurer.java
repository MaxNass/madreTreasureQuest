package com.peruvian.gouv.madreTreasureQuest.adventurer.model;

import java.util.List;

public class Adventurer {

    private String name;
    private Position position;
    private Orientation orientation;
    private List<AdventurerMovement> wayToGo;
    private int numberOfTreasuresDiscovered;

    public Adventurer() {

    }

    public Adventurer(final String name,
                      final Position position,
                      final Orientation orientation,
                      final List<AdventurerMovement> wayToGo,
                      final int numberOfTreasuresDiscovered) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.wayToGo = wayToGo;
        this.numberOfTreasuresDiscovered = numberOfTreasuresDiscovered;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<AdventurerMovement> getWayToGo() {
        return wayToGo;
    }

    public int getNumberOfTreasuresDiscovered() {
        return numberOfTreasuresDiscovered;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setNumberOfTreasuresDiscovered(int numberOfTreasuresDiscovered) {
        this.numberOfTreasuresDiscovered = numberOfTreasuresDiscovered;
    }

    public void incrementNumberOfTreasuresFound() {
        setNumberOfTreasuresDiscovered(getNumberOfTreasuresDiscovered() + 1);
    }
}
