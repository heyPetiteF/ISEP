package HarryPotter.PlayGame;
import HarryPotter.Background.Background;
import HarryPotter.Game.Level;
import HarryPotter.Wizard.Wizard;

public class Game {
    public static void main(String[] args){
        Background.BG();
        Wizard.wizard();
        Level.play();
    }
}