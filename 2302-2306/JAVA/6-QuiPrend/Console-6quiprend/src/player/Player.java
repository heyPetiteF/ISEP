package player;

import java.util.ArrayList;
import java.util.Collections;
import card.Card;
import game.Game;
import row.Row;

public class Player {
    public Card card = new Card();
    public int playerID;
    public ArrayList<Card> hand = new ArrayList();
    public int cardID;
    public int points;
    public Row[] rowArray = new Row[4];

    public Player() {
    }

    public void playCard() {
        if (this.hand.size() > 0) {
            Collections.shuffle(this.hand);
            Card card = (Card)this.hand.get(0);
            this.hand.remove(0);
            Game.cardsToGame(card);
            System.out.println("Player " + this.playerID + " has played Card " + card.getCardID());
        } else {
            Game.score();
        }

    }

    public void takeCard(Card card) {
        card.setOwner(this.playerID);
        this.hand.add(card);
        this.cardID = card.getCardID();
        System.out.println("Player " + this.playerID + " has taken Card " + this.cardID);
    }

    public int pickRowTake() {
        this.rowArray = Game.getRowArray();
        int bestPointValue = 1000;
        int bestRowToTake = 5;

        for(int i = 0; i < this.rowArray.length; ++i) {
            int pointValue = this.rowArray[i].getPoints();
            if (pointValue < bestPointValue) {
                bestRowToTake = i;
                bestPointValue = pointValue;
            }
        }

        System.out.println("Player " + this.playerID + " has chosen row " + bestRowToTake);
        return bestRowToTake;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
        System.out.println("Player " + playerID + " has been created");
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int newPoints) {
        this.points += newPoints;
        System.out.println("Player " + this.playerID + " got " + newPoints + " new points and now has " + this.points + " points");
    }
}
