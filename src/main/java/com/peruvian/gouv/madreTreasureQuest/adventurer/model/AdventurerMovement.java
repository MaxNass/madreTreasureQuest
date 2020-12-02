package com.peruvian.gouv.madreTreasureQuest.adventurer.model;

public class AdventurerMovement {

    private Action action;
    private boolean executed;

    public AdventurerMovement(Action action, boolean executed) {
        this.action = action;
        this.executed = executed;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }
}
