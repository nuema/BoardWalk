package nuema;

/**
 * @Description Board basic POJOs. Required objects.
 * @Author Nuema
 * */
public class Board {

    public enum Action {
        FW(), UP(), DOWN(), BACK();
    }

    static class Position {
        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    private int size;

    public Board() {
    }

    public Board(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getPositionLabel(Position position) {
        return String.valueOf(position.row * size + position.col + 1);
    }

}