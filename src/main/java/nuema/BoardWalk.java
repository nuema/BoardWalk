package nuema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nuema.Board.*;

/**
 * @Description Main class where the game happens. This holds a simple board and a list of moves.
 * @Author Nuema
 */

public class BoardWalk {

    private Board board;
    private static final int STEP = 1;
    private List<Position> moves;

    public BoardWalk(int boardSize) {
        this.board = new Board(boardSize);
        moves = new ArrayList<>();
        moves.add(new Position(0, 0));
    }

    public List<Position> getMoves() {
        return moves;
    }

    public Position getLastPosition() {
        return moves.get(moves.size() - 1);
    }

    private boolean isOutOfBoard(int step, int boundary) {
        return (step < 0 && 0 == boundary) ||
                (step > 0 && board.getSize() - 1 == boundary);
    }

    private void addPositionMoveCol(int step) {
        if (isOutOfBoard(step, getLastPosition().getCol())) return;

        moves.add(new Position(
                getLastPosition().getRow(),
                getLastPosition().getCol() + step));
    }

    private void addPositionMoveRow(int step) {
        if (isOutOfBoard(step, getLastPosition().getRow())) return;

        moves.add(new Position(
                getLastPosition().getRow() + step,
                getLastPosition().getCol()));
    }

    // Game rules!
    public void takeAction(Action action) {
        switch (action) {
            case FW: // ->
                addPositionMoveCol(STEP);
                break;
            case UP: // ↑
                addPositionMoveRow(-STEP);
                break;
            case DOWN: // ↓
                addPositionMoveRow(STEP);
                break;
            case BACK: // <-
                addPositionMoveCol(-STEP);
                break;
        }
    }

    public List<String> getMovesResult() {
        return getMoves().stream()
                .map(board::getPositionLabel)
                .collect(Collectors.toList());
    }

    public int getBoardSize() {
        return board.getSize();
    }
}
