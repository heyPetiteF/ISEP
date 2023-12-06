package Chess;

//This class Requires the input
public class Square {
    private boolean hasPiece = false;
    private Piece p = null;

    public Piece getPiece() {
        return p;
    }

    public void setPiece(Piece piece) {
        p = piece;
        hasPiece = (p != null);
    }

    public void removePiece() {
        p = null;
        hasPiece = false;
    }

    public boolean hasPiece() {
        return hasPiece;
    }
}