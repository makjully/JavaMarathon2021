package day17;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    private static Map<Character, Integer> indexes;
    private static ChessPiece[][] chessPieces;

    public static void main(String[] args) {
        indexes = fillMap();
        chessPieces = new ChessPiece[8][8];
        fillChessPieces();

        addFigure(8, 'a', ChessPiece.ROOK_BLACK);
        addFigure(8, 'f', ChessPiece.ROOK_BLACK);
        addFigure(8, 'g', ChessPiece.KING_BLACK);
        addFigure(7, 'b', ChessPiece.ROOK_WHITE);
        addFigure(7, 'e', ChessPiece.PAWN_BLACK);
        addFigure(7, 'f', ChessPiece.PAWN_BLACK);
        addFigure(7, 'h', ChessPiece.PAWN_BLACK);
        addFigure(6, 'a', ChessPiece.PAWN_BLACK);
        addFigure(6, 'c', ChessPiece.KNIGHT_BLACK);
        addFigure(6, 'g', ChessPiece.PAWN_BLACK);
        addFigure(5, 'a', ChessPiece.QUEEN_BLACK);
        addFigure(5, 'd', ChessPiece.BISHOP_WHITE);
        addFigure(4, 'd', ChessPiece.BISHOP_BLACK);
        addFigure(4, 'e', ChessPiece.PAWN_WHITE);
        addFigure(3, 'e', ChessPiece.BISHOP_WHITE);
        addFigure(3, 'f', ChessPiece.PAWN_WHITE);
        addFigure(2, 'a', ChessPiece.PAWN_WHITE);
        addFigure(2, 'd', ChessPiece.QUEEN_WHITE);
        addFigure(2, 'f', ChessPiece.PAWN_WHITE);
        addFigure(2, 'h', ChessPiece.PAWN_WHITE);
        addFigure(1, 'f', ChessPiece.ROOK_WHITE);
        addFigure(1, 'g', ChessPiece.KING_WHITE);

        ChessBoard chessBoard = new ChessBoard(chessPieces);
        chessBoard.print();
    }

    private static void fillChessPieces() {
        for (int i = 0; i < chessPieces.length; i++) {
            for (int j = 0; j < chessPieces[i].length; j++) {
                chessPieces[i][j] = ChessPiece.EMPTY;
            }
        }
    }

    public static void addFigure(int lineNumber, char columnIndex, ChessPiece chessPiece) {
        int horizontalPosition = chessPieces.length - lineNumber;
        int verticalPosition = indexes.get(columnIndex);

        chessPieces[horizontalPosition][verticalPosition] = chessPiece;
    }

    public static Map<Character, Integer> fillMap() {
        Map<Character, Integer> indexes = new HashMap<>();
        int index = 0;
        for (char ch = 'a'; ch < 'i'; ch++) {
            indexes.put(ch, index);
            index++;
        }
        return indexes;
    }
}
