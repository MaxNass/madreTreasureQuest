package com.peruvian.gouv.madreTreasureQuest.adventurer.service;

import com.peruvian.gouv.madreTreasureQuest.adventurer.manager.ActionManager;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;
import com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap.MadreDeDiosMap;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    public void moveForward(MadreDeDiosMap madreDeDiosMap, final Adventurer adventurer) {
        ActionManager.moveForward(madreDeDiosMap, adventurer);
    }

    public void turnLeft(final Adventurer adventurer) {
        ActionManager.turnLeft(adventurer);
    }

    public void turnRight(final Adventurer adventurer) {
        ActionManager.turnRight(adventurer);
    }

}
