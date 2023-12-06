package Chess;

public class Rook extends Piece {
    public Rook(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2656" : "\u265C");
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //A rook is allowed to move any number of empty squares horizontally or vertically.
        //As long as no other pieces are in the way in the middle
        //车被允许在水平或垂直方向上移动任意数量的空位。(只要没有其他棋子挡在中间)

        if (i0 == i1) {
            //Horizontal movement 水平移动
            for (int n = Math.min(j0, j1) + 1; n < Math.max(j0, j1); n++) {
                if (Board.hasPiece(i1, n))
                    return false;
            }
        }

        else if (j0 == j1) {
            //Vertical movement 竖直移动
            for (int n = Math.min(i0, i1) + 1; n < Math.max(i0, i1); n++) {
                if (Board.hasPiece(n, j1))
                    return false;
            }
        }

        else
            return false;

        //Check if there is a piece of the same colour at the destination
        return !(Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() == Board.getPiece(i1, j1).getColor());
    }
}