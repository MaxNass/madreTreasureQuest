package com.peruvian.gouv.madreTreasureQuest.adventurer.manager;

import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Adventurer;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Orientation;
import com.peruvian.gouv.madreTreasureQuest.adventurer.model.Position;
import com.peruvian.gouv.madreTreasureQuest.adventurer.service.ActionService;
import com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap.MadreDeDiosMap;
import com.peruvian.gouv.madreTreasureQuest.madreDeDiosMap.MapPosition;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ActionManagerTest {

    MadreDeDiosMap madreDeDiosMap;
    ActionService actionService;

    @Before
    public void init() {
        madreDeDiosMap = new MadreDeDiosMap();
        actionService = new ActionService();
        madreDeDiosMap.createMatrix(3,3);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }
    }

    @Test
    public void test_adventurer_move_forward() {

        madreDeDiosMap.createMatrix(3,3);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        bob.setPosition(new Position(2,2));
        bob.setOrientation(Orientation.NORTH);
        madreDeDiosMap.getMap()[2][2].setAdventurer(bob);

        actionService.moveForward(madreDeDiosMap, bob);

        assertEquals(bob, madreDeDiosMap.getMap()[1][2].getAdventurer());

    }

    @Test
    public void test_adventurer_do_not_move_forward_because_of_mountain() {

        madreDeDiosMap.createMatrix(2,2);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        bob.setPosition(new Position(1,1));
        bob.setOrientation(Orientation.NORTH);
        madreDeDiosMap.getMap()[1][1].setAdventurer(bob);
        madreDeDiosMap.getMap()[0][1].setMountain(true);

        actionService.moveForward(madreDeDiosMap, bob);

        assertEquals(bob, madreDeDiosMap.getMap()[1][1].getAdventurer());
    }

    @Test
    public void test_adventurer_do_not_move_forward_because_of_map_limits() {
        madreDeDiosMap.createMatrix(2,2);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        bob.setPosition(new Position(1,1));
        bob.setOrientation(Orientation.WEST);
        madreDeDiosMap.getMap()[1][1].setAdventurer(bob);

        actionService.moveForward(madreDeDiosMap, bob);

        assertEquals(bob, madreDeDiosMap.getMap()[1][1].getAdventurer());
    }

    @Test
    public void test_adventurer_turn_left() {

        Adventurer tom = new Adventurer();
        tom.setPosition(new Position(0,2));
        tom.setOrientation(Orientation.NORTH);
        madreDeDiosMap.getMap()[0][2].setAdventurer(tom);

        actionService.turnLeft(tom);

        assertEquals(tom, madreDeDiosMap.getMap()[0][2].getAdventurer());
        assertEquals(tom.getOrientation(), Orientation.WEST);
    }

    @Test
    public void test_adventurer_turn_right() {

        Adventurer jerry = new Adventurer();
        jerry.setPosition(new Position(1,2));
        jerry.setOrientation(Orientation.NORTH);
        madreDeDiosMap.getMap()[1][2].setAdventurer(jerry);

        actionService.turnRight(jerry);

        assertEquals(jerry, madreDeDiosMap.getMap()[1][2].getAdventurer());
        assertEquals(jerry.getOrientation(), Orientation.EAST);
    }

    @Test
    public void test_condition_is_not_having_an_mountain_in_front_of_him() {
        madreDeDiosMap.createMatrix(3,3);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        Position position = new Position(2,2);
        bob.setPosition(position);
        bob.setOrientation(Orientation.NORTH);

        Position newPosition = ActionManager.getNewAdventurerPosition(position, Orientation.NORTH);
        final boolean isNotHavingAMountainInFrontOfHim = ActionManager.isNotHavingAMountainInFrontOfHim(newPosition, madreDeDiosMap);

        assertEquals(true, isNotHavingAMountainInFrontOfHim);
    }

    @Test
    public void test_condition_is_inside_map_limits() {
        madreDeDiosMap.createMatrix(3,3);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        Position position = new Position(2,2);
        bob.setPosition(position);
        bob.setOrientation(Orientation.NORTH);

        Position newPosition = ActionManager.getNewAdventurerPosition(position, Orientation.NORTH);
        final boolean insideTheMapLimits = ActionManager.isInsideTheMapLimits(newPosition, madreDeDiosMap);

        assertEquals(true, insideTheMapLimits);
    }

    @Test
    public void test_condition_is_there_any_treasure_in_front_of_him() {
        madreDeDiosMap.createMatrix(3,3);
        for (int i = 0; i < madreDeDiosMap.getNumberOfLines(); i++) {
            for (int j = 0; j < madreDeDiosMap.getNumberOfLines(); j++) {
                madreDeDiosMap.getMap()[i][j] = new MapPosition(i, j);
            }
        }

        Adventurer bob = new Adventurer();
        Position position = new Position(2,2);
        bob.setPosition(position);
        bob.setOrientation(Orientation.NORTH);

        Position newPosition = ActionManager.getNewAdventurerPosition(position, Orientation.NORTH);

        madreDeDiosMap.getMap()[1][2].setNumberOfTreasures(2);

        final boolean isThereAnyTreasureInFrontOfHim = ActionManager.isThereAnyTreasureInFrontOfHim(newPosition, madreDeDiosMap);

        assertEquals(true, isThereAnyTreasureInFrontOfHim);

    }



}