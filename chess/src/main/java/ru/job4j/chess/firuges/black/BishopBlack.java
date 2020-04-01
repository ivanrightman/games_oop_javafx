package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                  String.format("Could not way by diagonal from %s to %s", source, dest)
         );
      }
        int size = dest.x - source.x;
        Cell[] steps = new Cell[size];
        int deltaX = dest.x > source.x ? source.x + 1 : dest.x -1;
        int deltaY = dest.y > source.y ? source.y + 1 : dest.y -1;
        for (int index = 0; index < size; index++) {
            int x = index + deltaX;
            int y = index + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return dest.x + source.x == dest.y - source.y
                || dest.x + source.x == source.y - dest.y
                || dest.x - source.x == source.y - dest.y
                || dest.x - source.x == dest.y - source.y;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
