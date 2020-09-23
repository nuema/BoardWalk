import nuema.Board.*;
import nuema.BoardWalk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BoardWalkTest {

    private BoardWalk board;
    static List<Action> game = new ArrayList<>();

    @BeforeEach
    private void clear() {
        game.clear();
    }

    private void printBoard() {
        String line="\nGiven Board \n";
        for (int i=1; i<=Math.pow(board.getBoardSize(), 2); i++) {
            line += String.valueOf(i) + " ";
            if (i % board.getBoardSize() == 0) {
                line +="\n";
            }
        }

        System.out.println(line);
    }

    private void printResults(BoardWalk board) {
        System.out.println("Moves result: " + board.getMovesResult().toString());
    }

    private void printGame() {
        System.out.print("Actions: ");
        game.stream().forEach( (action) -> System.out.print(" " + action));
        System.out.println("");
    }


    @Test
    public void shouldFw3times() {
        //Given
        board = new BoardWalk(3);
        game = new ArrayList<>();
        game.add(Action.FW);
        game.add(Action.FW);
        game.add(Action.FW);

        //When
        game.stream().forEach(board::takeAction);

        printBoard();
        printGame();
        printResults(board);
        assertThat(board.getMovesResult()).containsAll(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void shouldReturn14544() {
        //Given
        board = new BoardWalk(3);
        game.add(Action.DOWN);
        game.add(Action.FW);
        game.add(Action.BACK);
        game.add(Action.UP);

        //When
        game.stream().forEach(board::takeAction);

        printBoard();
        printGame();
        printResults(board);

        assertThat(board.getMovesResult()).containsAll(Arrays.asList("1", "4", "5", "4", "1"));
    }

    @Test
    public void shouldHave100Lockers() {
        //Given
        board = new BoardWalk(10);
        for (int i=0; i<10; i++) {
            game.add(Action.FW);
            game.add(Action.DOWN);
        }

        //When
        game.stream().forEach(board::takeAction);

        printBoard();
        printGame();
        printResults(board);

        List<String> results = board.getMovesResult();
        assertThat(results.get(results.size()-1)).isEqualTo("100");
    }

    @Test
    public void shouldNotTakeAction() {
        //Given
        board = new BoardWalk(1);

        game.add(Action.UP);
        game.add(Action.DOWN);
        game.add(Action.FW);

        //When
        game.stream().forEach(board::takeAction);

        printBoard();
        printGame();
        printResults(board);

        List<String> results = board.getMovesResult();
        assertThat(results.get(results.size()-1)).isEqualTo("1");
    }


}
