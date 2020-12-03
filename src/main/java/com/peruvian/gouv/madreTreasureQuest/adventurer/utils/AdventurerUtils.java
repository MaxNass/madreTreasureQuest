package com.peruvian.gouv.madreTreasureQuest.adventurer.utils;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Action;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Orientation;
import org.springframework.stereotype.Component;

@Component
public class AdventurerUtils {

    public static Action getActionFromString(final String element) {
        switch (element) {
            case "A" : return Action.MOVE_FORWARD;
            case "G" : return Action.TURN_LEFT;
            case "D" : return Action.TURN_RIGHT;
        }
        return null;
    }

    public static Orientation getOrientationFromString(final String element) {
        switch (element) {
            case "N" : return Orientation.NORTH;
            case "S" : return Orientation.SOUTH;
            case "E" : return Orientation.EAST;
            case "W" : return Orientation.WEST;
        }
        return null;
    }


}
