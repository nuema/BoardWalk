import nuema.Board.*;
import nuema.BoardWalk;
import nuema.BoardWalkHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BoardWalkTest {

    private BoardWalk board;
    static List<Action> game = new ArrayList<>();

    @Test
    public void shouldFw3times() {
        //Given
        givenABoardSizeAndGame(3,
                Arrays.asList(Action.FW, Action.FW, Action.FW));

        whenGameTakesAction();
        assertThat(board.getMovesResult()).containsAll(Arrays.asList("1", "2", "3"));

        //Just to check
        BoardWalkHelper.printBoardGame(board, game);
    }

    @Test
    public void shouldReturn14544() {
        givenABoardSizeAndGame(3,
                Arrays.asList(Action.DOWN, Action.FW, Action.BACK, Action.UP));

        whenGameTakesAction();
        assertThat(board.getMovesResult()).containsAll(Arrays.asList("1", "4", "5", "4", "1"));
    }

    @Test
    public void shouldHave100Lockers() {
        givenABoardSizeAndGame(10,
                Arrays.asList(Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN,
                        Action.FW, Action.DOWN
                ));

        whenGameTakesAction();

        List<String> results = board.getMovesResult();
        assertThat(results.get(results.size() - 1)).isEqualTo("100");
    }

    @Test
    public void shouldNotMove() {
        givenABoardSizeAndGame(1,
                Arrays.asList(Action.UP, Action.DOWN, Action.FW));

        whenGameTakesAction();

        List<String> results = board.getMovesResult();
        assertThat(results.get(results.size() - 1)).isEqualTo("1");
    }

    private void givenABoardSizeAndGame(int boardSize, List<Action> gameActions) {
        board = new BoardWalk(boardSize);
        game.clear();
        game.addAll(gameActions);
    }

    private void whenGameTakesAction() {
        game.stream().forEach(board::takeAction);
    }

}
