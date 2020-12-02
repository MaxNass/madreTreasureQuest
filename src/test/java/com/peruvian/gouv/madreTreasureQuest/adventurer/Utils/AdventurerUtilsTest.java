package com.peruvian.gouv.madreTreasureQuest.adventurer.Utils;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Action;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Orientation;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerUtilsTest {

    private static final String ACTION_FORWARD = "A";
    private static final String ACTION_TURN_RIGHT = "D";
    private static final String ACTION_TURN_LEFT = "G";

    private static final String ORIENTATION_NORTH = "N";
    private static final String ORIENTATION_SOUTH = "S";
    private static final String ORIENTATION_WEST = "W";
    private static final String ORIENTATION_EAST = "E";


    @Test
    public void test_get_action_from_string() {
        assertEquals(Action.MOVE_FORWARD, AdventurerUtils.getActionFromString(ACTION_FORWARD));
        assertEquals(Action.TURN_LEFT, AdventurerUtils.getActionFromString(ACTION_TURN_LEFT));
        assertEquals(Action.TURN_RIGHT, AdventurerUtils.getActionFromString(ACTION_TURN_RIGHT));
    }

    @Test
    public void test_get_orientation_from_string() {
        assertEquals(Orientation.NORTH, AdventurerUtils.getOrientationFromString(ORIENTATION_NORTH));
        assertEquals(Orientation.SOUTH, AdventurerUtils.getOrientationFromString(ORIENTATION_SOUTH));
        assertEquals(Orientation.WEST, AdventurerUtils.getOrientationFromString(ORIENTATION_WEST));
        assertEquals(Orientation.EAST, AdventurerUtils.getOrientationFromString(ORIENTATION_EAST));
    }
}