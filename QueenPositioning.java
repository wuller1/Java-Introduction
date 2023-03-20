import java.util.Random;

public class QueenPositioning {
    public static void main(String[] args) {
        String[][] chessBoard = placeQueens();
        printChessBoard(chessBoard);
    }

    public static void printChessBoard(String[][] chessBoard) {
        System.out.println("_".repeat(19));
        for (int i = 0; i < chessBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.printf("%s ", chessBoard[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println("-".repeat(19));
    }

    public static String[][] placeQueens() {
        String[][] chessBoard = createEmptyChessBoard();

        Random random = new Random();
        int queenCount = 0;

        while (queenCount < 8) {
            int row = random.nextInt(8);
            int column = random.nextInt(8);

            if (isSafeToPlace(chessBoard, row, column)) {
                chessBoard[row][column] = "X";
                queenCount += 1;
            }

            if (!queenCanBePlaced(chessBoard) && queenCount < 8) {
                chessBoard = createEmptyChessBoard();
                queenCount = 0;
            }
        }

        return chessBoard;
    }

    public static boolean queenCanBePlaced(String[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if (isSafeToPlace(chessBoard, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSafeToPlace(String[][] chessBoard, int rowIndex, int columnIndex) {
        return !queenOnDiagonal(chessBoard, rowIndex, columnIndex) &&
                !queenOnRow(chessBoard, rowIndex) &&
                !queenOnColumn(chessBoard, columnIndex);
    }

    public static boolean queenOnRow(String[][] chessBoard, int rowIndex) {
        for (int i = 0; i < 8; i++) {
            if (chessBoard[rowIndex][i].equals("X")) {
                return true;
            }
        }

        return false;
    }

    public static boolean queenOnColumn(String[][] chessBoard, int columnIndex) {
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[i][columnIndex].equals("X")) {
                return true;
            }
        }

        return false;
    }

    public static boolean queenOnDiagonal(String[][] chessBoard, int rowIndex, int columnIndex) {

        int leftDiagonalRowStart = rowIndex;
        int leftDiagonalColumnStart = columnIndex;
        int rightDiagonalRowStart = rowIndex;
        int rightDiagonalColumnStart = columnIndex;

        while (leftDiagonalColumnStart > 0 && leftDiagonalRowStart > 0) {
            leftDiagonalColumnStart -= 1;
            leftDiagonalRowStart -= 1;
        }

        while (rightDiagonalColumnStart < chessBoard.length - 1 && rightDiagonalRowStart > 0) {
            rightDiagonalRowStart -= 1;
            rightDiagonalColumnStart += 1;
        }

        int currentLeftDiagonalRow = leftDiagonalRowStart;
        int currentLeftDiagonalColumn = leftDiagonalColumnStart;

        while (currentLeftDiagonalColumn < chessBoard.length && currentLeftDiagonalRow < chessBoard.length) {
            if (chessBoard[currentLeftDiagonalRow][currentLeftDiagonalColumn].equals("X")) {
                return true;
            }
            currentLeftDiagonalColumn += 1;
            currentLeftDiagonalRow += 1;
        }

        int currentRightDiagonalRow = rightDiagonalRowStart;
        int currentRightDiagonalColumn = rightDiagonalColumnStart;

        while (currentRightDiagonalColumn >= 0 && currentRightDiagonalRow < chessBoard.length) {
            if (chessBoard[currentRightDiagonalRow][currentRightDiagonalColumn].equals("X")) {
                return true;
            }

            currentRightDiagonalColumn -= 1;
            currentRightDiagonalRow += 1;
        }

        return false;
    }

    public static String[][] createEmptyChessBoard() {
        String[][] chessBoard = new String[8][8];

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = "O";
            }
        }

        return chessBoard;
    }
}
