package Chess;

//This class is partially implemented
public class Board {

    //Create a two-dimensional array as a chessboard
    private static Square[][] board = new Square[8][8];

    public static void initialiseBoard() {
                for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++)
                board[i][j] = new Square();
        }
    }

    //Requires the input
    public static void initialisePieces() {
        //Black pieces
        setPiece(0, 0, new Rook(PieceColor.BLACK));
        setPiece(0, 1, new Knight(PieceColor.BLACK));
        setPiece(0, 2, new Bishop(PieceColor.BLACK));
        setPiece(0, 3, new Queen(PieceColor.BLACK));
        setPiece(0, 4, new King(PieceColor.BLACK));
        setPiece(0, 5, new Bishop(PieceColor.BLACK));
        setPiece(0, 6, new Knight(PieceColor.BLACK));
        setPiece(0, 7, new Rook(PieceColor.BLACK));
        setPiece(1, 0, new Pawn(PieceColor.BLACK));
        setPiece(1, 1, new Pawn(PieceColor.BLACK));
        setPiece(1, 2, new Pawn(PieceColor.BLACK));
        setPiece(1, 3, new Pawn(PieceColor.BLACK));
        setPiece(1, 4, new Pawn(PieceColor.BLACK));
        setPiece(1, 5, new Pawn(PieceColor.BLACK));
        setPiece(1, 6, new Pawn(PieceColor.BLACK));
        setPiece(1, 7, new Pawn(PieceColor.BLACK));

        //White pieces
        setPiece(6, 0, new Pawn(PieceColor.WHITE));
        setPiece(6, 1, new Pawn(PieceColor.WHITE));
        setPiece(6, 2, new Pawn(PieceColor.WHITE));
        setPiece(6, 3, new Pawn(PieceColor.WHITE));
        setPiece(6, 4, new Pawn(PieceColor.WHITE));
        setPiece(6, 5, new Pawn(PieceColor.WHITE));
        setPiece(6, 6, new Pawn(PieceColor.WHITE));
        setPiece(6, 7, new Pawn(PieceColor.WHITE));
        setPiece(7, 0, new Rook(PieceColor.WHITE));
        setPiece(7, 1, new Knight(PieceColor.WHITE));
        setPiece(7, 2, new Bishop(PieceColor.WHITE));
        setPiece(7, 3, new Queen(PieceColor.WHITE));
        setPiece(7, 4, new King(PieceColor.WHITE));
        setPiece(7, 5, new Bishop(PieceColor.WHITE));
        setPiece(7, 6, new Knight(PieceColor.WHITE));
        setPiece(7, 7, new Rook(PieceColor.WHITE));
    }

    //Printed chessboard
    public static void printBoard() {
        System.out.print("\n  a b c d e f g h \n");
        System.out.print("  -----------------\n");
        for (int i = 0; i < board[0].length; i++) {
            int row = i + 1;
            for (int j = 0; j < board[1].length; j++) {
                if ((j == 0) && Board.hasPiece(i, j))
                    System.out.print(row + " " + Board.getPiece(i, j).getSymbol());
                else if ((j == 0) && !Board.hasPiece(i, j))
                    System.out.print(row + " ");
                else if (Board.hasPiece(i, j))
                    System.out.print("|" + Board.getPiece(i, j).getSymbol());
                else
                    System.out.print("| ");
            }
            System.out.print("  " + row + "\n");
        }
        System.out.print("  -----------------");
        System.out.print("\n  a b c d e f g h \n");
    }

    //Requires the input
    public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p) {
        boolean isKingCaptured = board[i1][j1].getPiece() instanceof King;
        board[i0][j0].removePiece();
        board[i1][j1].setPiece(p);
        return isKingCaptured;
    }

    //Requires the input
    public static void setPiece(int iIn, int jIn, Piece p) {
        board[iIn][jIn].setPiece(p);
    }

    //Requires the input
    public static Piece getPiece(int iIn, int jIn) {
        return board[iIn][jIn].getPiece();
    }

    //Requires the input
    public static boolean hasPiece(int i, int j) {
        return board[i][j].hasPiece();
    }
}