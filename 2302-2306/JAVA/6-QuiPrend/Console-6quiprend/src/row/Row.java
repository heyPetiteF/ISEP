package row;

import java.util.ArrayList;
import card.Card;
import game.Game;
import player.Player;

public class Row {
    public Card card = new Card();
    public ArrayList<Card> cardsInRow = new ArrayList();
    public int pointValue;
    public int rowPointValue;
    public int rowID;
    public int owner = 2;
    public Player[] playerArray = new Player[5];

    public Row() {
    }

    public void takeCard(Card card) {
        this.card = card;
        this.cardsInRow.add(card);
        System.out.println("card " + card.getCardID() + " given to row " + this.rowID + " in spot " + this.cardsInRow.size());
        if (this.cardsInRow.size() == 6) {
            for(int i = 0; i < 6; ++i) {
                Card pointCard = (Card)this.cardsInRow.get(i);
                this.pointValue = pointCard.getPointValue();
                this.rowPointValue += this.pointValue;
            }

            this.playerArray = Game.getPlayerArray();
            this.owner = card.getOwner();
            this.playerArray[this.owner].addPoints(this.rowPointValue);
            card.setPointsGained(this.rowPointValue);
            Game.setPlayerArray(this.playerArray);
            this.clearRow(card);
            Game.cardToRow(this.rowID);
        }

    }

    public void replaceRow(Card newCard) {
        for(int i = 0; i < this.cardsInRow.size(); ++i) {
            Card pointCard = (Card)this.cardsInRow.get(i);
            this.pointValue = pointCard.getPointValue();
            this.rowPointValue += this.pointValue;
        }

        this.playerArray = Game.getPlayerArray();
        this.owner = newCard.getOwner();
        this.playerArray[this.owner].addPoints(this.rowPointValue);
        Game.setPlayerArray(this.playerArray);
        this.cardsInRow = new ArrayList();
        this.rowPointValue = 0;
    }

    public void clearRow(Card card) {
        this.cardsInRow = new ArrayList();
        this.cardsInRow.add(card);
        this.rowPointValue = 0;
    }

    public Card getLastCard() {
        if (this.cardsInRow.isEmpty()) {
            // 处理列表为空的情况，可以返回null或者抛出异常
            return null; // 或者抛出自定义异常，如 throw new IllegalStateException("Row is empty");
        }
        Card card = this.cardsInRow.get(this.cardsInRow.size() - 1);
        return card;
    }

    public int getPointValue() {
        return this.rowPointValue;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public Player[] getPlayerArray() {
        return this.playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPoints() {
        for(int i = 0; i < this.cardsInRow.size(); ++i) {
            Card pointCard = (Card)this.cardsInRow.get(i);
            this.pointValue = pointCard.getPointValue();
            this.rowPointValue += this.pointValue;
        }

        return this.rowPointValue;
    }

    public int getNumCards() {
        return this.cardsInRow.size();
    }

    public Card getCard(int cardNumber) {
        Card card = (Card)this.cardsInRow.get(cardNumber);
        return card;
    }
}
