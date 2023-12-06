package Chess;

public class Bishop extends Piece {
    public Bishop(PieceColor c) {
        setSymbol(c == PieceColor.WHITE ? "\u2657" : "\u265D");//White Bishop : Black Bishop
        color = c;
    }

    @Override
    public boolean isvalideMove(int i0, int j0, int i1, int j1) {
        //The Bishop moves any number of empty spaces on the diagonal.//对角线移动

        // Check that the movement is diagonal
        if (Math.abs(i1 - i0) == Math.abs(j1 - j0)) {
            //Check if there are other pieces blocking the movement path (two directions in one)
            for (int n = 1; n < Math.abs(i1 - i0); n++) {
                if (Board.hasPiece((i1 - i0 == j1 - j0) ? Math.min(i0, i1) + n : Math.max(i0, i1) - n, Math.min(j0, j1) + n))
                    return false;
            }
        }
        else{
            return false;
        }

        //Check if there is a piece of the same colour at the destination
        return !(Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColor() == Board.getPiece(i1, j1).getColor());
    }
}