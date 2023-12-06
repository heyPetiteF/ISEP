package Chess;

public class Knight extends Piece {
    public Knight(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2658" : "\u265E");
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //The knight is allowed to move in an "L" shape, unhindered by other pieces.
        //骑士被允许以 "L "型移动，不受其他棋子的阻止。

        //The "L" path means that ▲i * ▲j == 2 and that the destination cannot have pieces of the same colour.
        //"L "路径意味着▲i * ▲j == 2，目的地不能有相同颜色的棋子。
        return Math.abs((i1 - i0) * (j1 - j0)) == 2 && !(Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() == Board.getPiece(i1, j1).getColor());
    }
}