package nuema;

import java.util.List;

/**
 * @Description Printers
 * @Author Nuema
 */

public class BoardWalkHelper {

    public static void printTitle (BoardWalk boardWalk) {
        System.out.println("   ____     U  ___ u    _       ____    ____                         _      _       _  __    \n" +
                "U | __\")u    \\/\"_ \\/U  /\"\\  uU |  _\"\\ u|  _\"\\       __        __ U  /\"\\  u |\"|     |\"|/ /    \n" +
                " \\|  _ \\/    | | | | \\/ _ \\/  \\| |_) |/| | | |      \\\"\\      /\"/  \\/ _ \\/U | | u   | ' /     \n" +
                "  | |_) |.-,_| |_| | / ___ \\   |  _ < U| |_| |\\     /\\ \\ /\\ / /\\  / ___ \\ \\| |/__U/| . \\\\u   \n" +
                "  |____/  \\_)-\\___/ /_/   \\_\\  |_| \\_\\ |____/ u    U  \\ V  V /  U/_/   \\_\\ |_____| |_|\\_\\    \n" +
                " _|| \\\\_       \\\\    \\\\    >>  //   \\\\_ |||_       .-,_\\ /\\ /_,-. \\\\    >> //  \\\\,-,>> \\\\,-. \n" +
                "(__) (__)     (__)  (__)  (__)(__)  (__|__)_)       \\_)-'  '-(_/ (__)  (__|_\")(\"_)\\.)   (_/  ");
        System.out.println("   Given a " + getBoardSize(boardWalk.getBoardSize()) +
                " board and a set of posible " +
                "(FW ->, DOWN ↓ , BACK <-, UP ↑) actions. \n" +
                "   The Goal is to get the values of the walked lockers.");
    }

    public static void printBoard(BoardWalk boardWalk) {
        int boardSize = boardWalk.getBoardSize();
        String line= String.format("\n-Board is %s-\n", getBoardSize(boardSize));
        for (int i=1; i<=Math.pow(boardSize, 2); i++) {
            line += String.format("[%03d]", i) + " ";
            if (i % boardSize == 0) {
                line +="\n";
            }
        }

        System.out.println(line);
    }

    public static void printResults(BoardWalk boardWalk) {
        System.out.println("Walked path: " + boardWalk.getMovesResult().toString());
    }

    public static void printGameMoves(List<Board.Action> game) {
        System.out.print("Actions: ");
        game.stream().forEach( (action) -> System.out.print(action + "  "));
        System.out.println("");
    }

    public static void printBoardGame(BoardWalk boardWalk, List<Board.Action> game) {
        printBoard(boardWalk);
        printGameMoves(game);
        printResults(boardWalk);
    }


    private static String getBoardSize(int boardSize) {
        return String.format("%dx%d", boardSize, boardSize);
    }

}
