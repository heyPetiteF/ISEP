import dbConnect.DBConnect;
import game.Game;

public class main {

    public static void main(String[] args) {

        new DBConnect();
        Game.initGame();
        Game.go();
        Game.score();
    }}
