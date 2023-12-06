public abstract class Chess {
    private boolean gameOver;//Determine if the game is over

    public abstract void main();//Main functions

    public abstract void play();//Body of the game
}

    abstract class Board extends Chess {
        private int[][] board;//Board specifications

        public abstract void initialiseBoard();//Initialising the board

        public abstract void initialisePieces();//Initialising the Pieces

        public abstract void printBoard();//Show board

        Chess chess = new Chess() {
            @Override
            public void main() {

            }

            @Override
            public void play() {

            }
        };

    }

    abstract class position extends Board {
        public boolean hasPieces;//Determining if pieces are available

        public abstract void getpieces();//Get the location of pieces

        public abstract void setpieces();//Set the location of pieces

        public abstract void removepieces();//Move the location of pieces

        Chess chess = new Chess() {
            @Override
            public void main() {

            }

            @Override
            public void play() {

            }
        };
    }

    abstract class player extends position {
        private String name;//name of player
        private int color;//color of player: 0 for white and 1 for black

        public abstract String toString();//Return the position of player

        public abstract String getSymbol();

        public abstract String setSymbol();

        private position po;

    }

    abstract class King {
        public int Kingcolor;
        public boolean isValideMove;

        private player p;

    }

    abstract class Queen {
        public int Queencolor;
        public boolean isValideMove;

        private player p;

    }

    abstract class Bishop {
        public int Bishopcolor;
        public boolean isValideMove;

        private player p;

    }

    abstract class Knight {
        public int Knightcolor;
        public boolean isValideMove;

        private player p;

    }

    abstract class Rook {
        public int Rookcolor;
        public boolean isValideMove;

        private player p;

    }

    abstract class Pawn {
        public int Pawncolor;
        public boolean isValideMove;

        private player p;

    }


