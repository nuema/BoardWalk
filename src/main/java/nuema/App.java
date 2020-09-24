package nuema;

import java.util.ArrayList;
import java.util.List;
import nuema.Board.*;

/**
 * @Description Main. This has a  5x5 boardWalk and a list of gameActions.
 * @Author Nuema
 * */
public class App {

    static BoardWalk board;
    static List<Action> game;

    public static void main(String args[]) {
        board = new BoardWalk(5);
        BoardWalkHeper.printTitle(board);

        game = new ArrayList<>();
        game.add(Board.Action.FW);
        game.add(Board.Action.FW);
        game.add(Board.Action.DOWN);
        game.add(Board.Action.DOWN);
        game.add(Board.Action.BACK);
        game.add(Board.Action.BACK);
        game.add(Board.Action.UP);

        game.stream().forEach(board::takeAction);

        BoardWalkHeper.printBoardGame(board, game);
    }

}
