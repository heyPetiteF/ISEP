package Chess;

//This class requires your input
public abstract class Piece {
    private String symbol;
    protected PieceColor color;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String sym) {
        symbol = sym;
    }

    public PieceColor getColor() {
        return color;
    }

    public abstract boolean isvalideMove(int i0, int j0, int i1, int j1);
}