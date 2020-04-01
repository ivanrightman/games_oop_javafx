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
    public void bishopMoveTest() {
        Logic logic = new Logic();
        Figure obstacle = new PawnBlack(Cell.D2);
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(obstacle);
        logic.add(bishop);

    }
}
