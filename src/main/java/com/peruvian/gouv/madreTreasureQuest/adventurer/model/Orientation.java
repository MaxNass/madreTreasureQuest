package com.peruvian.gouv.madreTreasureQuest.adventurer.model;

public enum Orientation {

    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E");

    private final String direction;

    Orientation(final String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
