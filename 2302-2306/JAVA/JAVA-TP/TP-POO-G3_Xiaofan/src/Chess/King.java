package Chess;

public class King extends Piece {
    public King(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2654" : "\u265A");
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //The King is allowed to move one step horizontally, vertically or diagonally.
        //国王被允许在水平、垂直或对角线上移动一步

        //Movements are only allowed within a 3x3 grid and there are no pieces of the same colour at the destination.
        //只被允许在3x3的网格内移动，并且目的地没有相同颜色的棋子。
        return Math.abs((i1 - i0) * (j1 - j0)) <= 1 && !(Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() == Board.getPiece(i1, j1).getColor());
    }
}