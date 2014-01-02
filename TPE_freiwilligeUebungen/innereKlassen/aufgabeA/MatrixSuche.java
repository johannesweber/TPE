package aufgabeA;

/**
 * Created by Johannes on 01.01.14.
 */
public class MatrixSuche {

    private static int[][] matrix;

    public MatrixSuche() {
        this.matrix = new int[3][3];
    }

    public static Position findEntry(int eintrag){
        Position position = null;
        for (int i = 0; i < MatrixSuche.matrix.length; i++){
            for (int j = 0; i < MatrixSuche.matrix[i].length; i++){
                if (MatrixSuche.matrix[i][j] == eintrag){
                    position = new Position(i,j);
                }
            }
        }
        return position;
    }

    private static class Position{

        private int x;
        private int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" + x + y + "}";
        }
    }
}
