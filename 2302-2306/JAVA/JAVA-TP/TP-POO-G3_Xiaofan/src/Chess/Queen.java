package Chess;

public class Queen extends Piece {
    public Queen(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2655" : "\u265B");
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //The Queen is allowed to move any number of empty squares horizontally, vertically or diagonally.
        //As long as no other pieces are in the way of the path
        // 皇后被允许在水平、垂直或对角线上移动任意数量的空位。(只要没有其他棋子挡在路径上)

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

        else if (Math.abs(i1 - i0) == Math.abs(j1 - j0)) {
            //Diagonal movement 斜向移动
            for (int n = 1; n < Math.abs(i1 - i0); n++) {
                if (Board.hasPiece((i1 - i0 == j1 - j0) ? Math.min(i0, i1) + n : Math.max(i0, i1) - n, Math.min(j0, j1) + n))
                    return false;
            }
        }

        else
            return false;

        //Check if there is a piece of the same colour at the destination
        return !(Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() == Board.getPiece(i1, j1).getColor());
    }
}