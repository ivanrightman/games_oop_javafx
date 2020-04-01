package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void positionSame() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.position();
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void copySame() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.A3);
        assertThat(bishopBlackCopy.position(), is(Cell.A3));
    }

    @Test
    public void wayDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(result, is(expected));
    }

    @Test
    public void wayNotDiagonal() throws IllegalStateException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.C1, Cell.H5);
        } catch (IllegalStateException thrown) {
            Assert.assertEquals("Could not way by diagonal from C1 to H5", thrown.getMessage());
        }
    }
}
