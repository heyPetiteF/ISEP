package Chess;
import java.io.Console;

/*--------------------------------------------------------------------------------------------------------------------*/
//To avoid the problem:Exception in thread "main" java.lang.NullPointerException
//Please run in the terminal
/*--------------------------------------------------------------------------------------------------------------------*/

public class Game {
    private static boolean gameOver = false; //Determine if the game is over

        public static void play() {
            Console console = System.console();
            String userInput;
            CheckInput inputChecker = new CheckInput();
            int[] oriPos = new int[2];//original position
            int[] desPos = new int[2];//destination position

            //Start from pieces white
            PieceColor playerTurn = PieceColor.WHITE;

            while (!gameOver) {

                //Print pieces turn: white or black
                System.out.println("\n" + (playerTurn == PieceColor.WHITE ? "Whites" : "Blacks") + " move.");

                //[origin]Processing user input
                System.out.println("> Enter origin:");
                userInput = console.readLine();

                //Check END command
                if (userInput.trim().equals("END")) {
                    System.out.println("\n" + (playerTurn == PieceColor.WHITE ? "White" : "Black") + " resigns.");
                    break;
                }
                userInput = inputChecker.handleUserInput(userInput);
                if (userInput == null) {
                    continue;
                }
                oriPos[0] = userInput.charAt(0) - '0' - 1;
                oriPos[1] = userInput.charAt(1) - 'a';

                //Check if the original position is valid
                if (!(Board.hasPiece(oriPos[0], oriPos[1]) && Board.getPiece(oriPos[0], oriPos[1]).getColor() == playerTurn)) {
                    System.out.println("【ERROR】Invalid original coordinates. Only pieces of your colour are allowed to be moved. Please try again.");
                    continue;
                }

                //Processing user input: destination
                System.out.println("> Enter destination:");
                userInput = console.readLine();

                // check END command (resign)
                if (userInput.trim().equals("END")) {
                    System.out.println("\n" + (playerTurn == PieceColor.WHITE ? "White" : "Black") + " resigns.");
                    break;
                }
                userInput = inputChecker.handleUserInput(userInput);
                if (userInput == null) {
                    continue;
                }
                desPos[0] = userInput.charAt(0) - '0' - 1;
                desPos[1] = userInput.charAt(1) - 'a';

                //Check if the move is legal
                if (!Board.getPiece(oriPos[0], oriPos[1]).isvalideMove(oriPos[0], oriPos[1], desPos[0], desPos[1])) {
                    System.out.println("【ERROR】Illegal movement. Please try again.");
                    continue;
                }
                //Move the piece
                gameOver = Board.movePiece(oriPos[0], oriPos[1], desPos[0], desPos[1], Board.getPiece(oriPos[0], oriPos[1]));

                //Print the board
                Board.printBoard();

                //Turn
                playerTurn = (playerTurn == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE);
            }

            //Print the winner
            System.out.println("\n----------! Game Over !----------");
            System.out.println("\n" + (playerTurn == PieceColor.WHITE ? "Black" : "White") + " Wins! ");
        }

        public static void main(String[] args) {
            Board.initialiseBoard();
            Board.initialisePieces();
            Board.printBoard();
            Game.play();
        }
}
