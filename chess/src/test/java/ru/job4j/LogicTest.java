package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {

    @Test
    public void bishopMoveNoObstaclesOnWay() {
        Logic logic = new Logic();
        Figure obstacle = new PawnBlack(Cell.D3);
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(obstacle);
        logic.add(bishop);
        boolean expect = true;
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(expect));
    }

    @Test
    public void bishopMoveWithObstacleOnWay() {
        Logic logic = new Logic();
        Figure obstacle = new PawnBlack(Cell.D2);
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(obstacle);
        logic.add(bishop);
        boolean expect = false;
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(expect));
    }
}
