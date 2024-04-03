package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    static void printMatrix(String [][] matrix) {
        System.out.println("---------");
        System.out.println("| "+matrix[0][0].replace("_", " ")+" "+matrix[0][1].replace("_", " ")+" "+matrix[0][2].replace("_", " ")+" |");
        System.out.println("| "+matrix[1][0].replace("_", " ")+" "+matrix[1][1].replace("_", " ")+" "+matrix[1][2].replace("_", " ")+" |");
        System.out.println("| "+matrix[2][0].replace("_", " ")+" "+matrix[2][1].replace("_", " ")+" "+matrix[2][2].replace("_", " ")+" |");
        System.out.println("---------");
    }

    static String gameStatus(String [][] gameMatrix) {
        StringBuilder buffer = new StringBuilder();
        for (String[] row : gameMatrix) {
            for (String value : row) {
                buffer.append(value);
            }
        }
        String gameState = buffer.toString().trim();
        int countX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameMatrix[i][j].equals("X")) {
                    countX++;
                }
            }
        }
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameMatrix[i][j].equals("O")) {
                    countO++;
                }
            }
        }
        if ((gameMatrix[0][0] + gameMatrix[0][1] + gameMatrix[0][2]).equals("XXX") ||
                (gameMatrix[1][0] + gameMatrix[1][1] + gameMatrix[1][2]).equals("XXX") ||
                (gameMatrix[2][0] + gameMatrix[2][1] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[0][0] + gameMatrix[1][0] + gameMatrix[2][0]).equals("XXX") ||
                (gameMatrix[0][1] + gameMatrix[1][1] + gameMatrix[2][1]).equals("XXX") ||
                (gameMatrix[0][2] + gameMatrix[1][2] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[0][0] + gameMatrix[1][1] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[2][0] + gameMatrix[1][1] + gameMatrix[0][2]).equals("XXX")) {
            return "X wins";
        } else if ((gameMatrix[0][0] + gameMatrix[0][1] + gameMatrix[0][2]).equals("OOO") ||
                (gameMatrix[1][0] + gameMatrix[1][1] + gameMatrix[1][2]).equals("OOO") ||
                (gameMatrix[2][0] + gameMatrix[2][1] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[0][0] + gameMatrix[1][0] + gameMatrix[2][0]).equals("OOO") ||
                (gameMatrix[0][1] + gameMatrix[1][1] + gameMatrix[2][1]).equals("OOO") ||
                (gameMatrix[0][2] + gameMatrix[1][2] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[0][0] + gameMatrix[1][1] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[2][0] + gameMatrix[1][1] + gameMatrix[0][2]).equals("OOO")) {
            return "O wins";
        } else if (
                !((gameMatrix[0][0] + gameMatrix[0][1] + gameMatrix[0][2]).equals("OOO") ||
                (gameMatrix[1][0] + gameMatrix[1][1] + gameMatrix[1][2]).equals("OOO") ||
                (gameMatrix[2][0] + gameMatrix[2][1] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[0][0] + gameMatrix[1][0] + gameMatrix[2][0]).equals("OOO") ||
                (gameMatrix[0][1] + gameMatrix[1][1] + gameMatrix[2][1]).equals("OOO") ||
                (gameMatrix[0][2] + gameMatrix[1][2] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[0][0] + gameMatrix[1][1] + gameMatrix[2][2]).equals("OOO") ||
                (gameMatrix[2][0] + gameMatrix[1][1] + gameMatrix[0][2]).equals("OOO"))

                &&

                !((gameMatrix[0][0] + gameMatrix[0][1] + gameMatrix[0][2]).equals("XXX") ||
                (gameMatrix[1][0] + gameMatrix[1][1] + gameMatrix[1][2]).equals("XXX") ||
                (gameMatrix[2][0] + gameMatrix[2][1] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[0][0] + gameMatrix[1][0] + gameMatrix[2][0]).equals("XXX") ||
                (gameMatrix[0][1] + gameMatrix[1][1] + gameMatrix[2][1]).equals("XXX") ||
                (gameMatrix[0][2] + gameMatrix[1][2] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[0][0] + gameMatrix[1][1] + gameMatrix[2][2]).equals("XXX") ||
                (gameMatrix[2][0] + gameMatrix[1][1] + gameMatrix[0][2]).equals("XXX"))

                &&

                !gameState.contains("_")) {
            return "Draw";
        }
        return "";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [][] boardMatrix = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    boardMatrix[i][j] = "_";
                }
            }

        printMatrix(boardMatrix);
        String symbol = "O";
        while (true) {
            int row = 0;
            int column = 0;
            if (symbol.equals("O")) {
                symbol = "X";
            } else {
                symbol = "O";
            }
            try {
                row = scanner.nextInt();
                column =  scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                if (symbol.equals("O")) {
                    symbol = "X";
                } else {
                    symbol = "O";
                }
                continue;
            }
            if (row > 3 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                if (symbol.equals("O")) {
                    symbol = "X";
                } else {
                    symbol = "O";
                }
                continue;
            }
            if (boardMatrix[row-1][column-1].equals("_")) {
                boardMatrix[row-1][column-1] = symbol;
                printMatrix(boardMatrix);
                String result = gameStatus(boardMatrix);
                if (!result.isEmpty()) {
                    System.out.println(result);
                    break;
                }
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                if (symbol.equals("O")) {
                    symbol = "X";
                } else {
                    symbol = "O";
                }
            }
        }
    }
}
