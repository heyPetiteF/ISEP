package Chess;

public class Pawn extends Piece {
    public Pawn(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2659" : "\u265F");
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //If the previous square is empty, the pawn is allowed to move one step forward.
        //如果前一个位置是空的，卒被允许向前移动一步
        //If the previous two squares are empty, the pawn may also choose to move two steps directly forward.
        //如果前两个位置都是空的，卒也可以选择直接向前移动两步
        //The pawn is not allowed to move backwards.
        //卒不被允许向后移动。
        //A pawn is the only piece that can move differently to capture a piece.
        //卒是唯一能以不同的移动方式吃掉棋子的棋子
        //A pawn can capture an enemy piece on any of the two diagonal squares in front of it.
        //卒可以吃掉其前面两个对角线上的任何一个位置上的敌方棋子
        //but if these squares are empty, the pawn cannot move to these position
        //如果这些位置是空的，则卒不能移动到这些位置

        //Use +-1 to represent two colors (this can act as the moving direction)
        int c = Board.getPiece(i0, j0).getColor() == PieceColor.BLACK ? 1 : -1;

        //Move two squares straight forward (the i0 should be 1 or 6 according to BLACK/WHITE)
        if (i0 == (c + 7) % 7 && i1 == i0 + c * 2 && j1 == j0) {
            //Both squares on the path should be empty
            return !Board.hasPiece(i0 + c, j0) && !Board.hasPiece(i1, j1);
        }

        else if (i1 == i0 + c && j1 == j0) {
            //Move one square directly forward and the destination should be empty.
            return !Board.hasPiece(i1, j1);
        }

        else if (i1 == i0 + c && Math.abs(j1 - j0) == 1) {
            //Capturing the enemy's piece (of a different colour) on the diagonal of the pawn.
            return Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() != Board.getPiece(i1, j1).getColor();
        }

        else
            return false;
    }
}