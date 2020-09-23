package nuema;

import java.util.ArrayList;
import java.util.List;
import nuema.Board.*;

/**
 * @Description Main. This has a boardWalk and a list of gameActions.
 * @Author Nuema
 * */
public class BoardGame {

    static BoardWalk board;
    static List<Action> game;

    public static void main(String args[]) {
        System.out.println("- BOARD WALK - Given a 5x5 board and a set of posible " +
                "(FW ->, DOWN ↓ , BACK <-, UP ↑) actions," +
                " this prints the values of the walked lockers ");

        board = new BoardWalk(5);

        game = new ArrayList<>();
        game.add(Board.Action.FW);
        game.add(Board.Action.FW);
        game.add(Board.Action.DOWN);
        game.add(Board.Action.DOWN);
        game.add(Board.Action.BACK);
        game.add(Board.Action.BACK);
        game.add(Board.Action.UP);

        game.stream().forEach(board::takeAction);

        System.out.println("Moves: " + board.getMoves().size());
        System.out.println(board.getMovesResult().toString());
    }

}
