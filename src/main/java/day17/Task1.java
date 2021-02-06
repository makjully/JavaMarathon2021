package day17;

public class Task1 {
    public static void main(String[] args) {
        ChessPiece[] chessPieces = new ChessPiece[8];

        for (int i = 0; i < chessPieces.length; i++) {
            if (i < chessPieces.length / 2) {
                chessPieces[i] = ChessPiece.PAWN_WHITE;
            } else
                chessPieces[i] = ChessPiece.ROOK_BLACK;
        }

        for (ChessPiece chessPiece : chessPieces) {
            System.out.print(chessPiece + " ");
        }
    }
}