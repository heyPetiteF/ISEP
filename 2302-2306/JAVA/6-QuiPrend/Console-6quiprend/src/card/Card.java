package card;

public class Card {
    public int cardID = 0;
    public int pointValue = 0;
    public int owner = 2;
    public int pointsGained = 0;

    public Card() {
    }

    public int getCardID() {
        return this.cardID;
    }

    public int getPointValue() {
        return this.pointValue;
    }

    public void setCardValues(int cardID) {
        this.cardID = cardID;
        if (cardID % 5 == 0) {
            this.pointValue += 2;
        }

        if (cardID % 10 == 0) {
            ++this.pointValue;
        }

        if (cardID % 11 == 0) {
            this.pointValue += 5;
        }

        if (this.pointValue == 0) {
            this.pointValue = 1;
        }

        System.out.println("PointValue is " + this.pointValue);
    }

    public int getOwner() {
        return this.owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
        System.out.println("Card " + this.cardID + "'s owner has been set to " + owner);
    }

    public int getPointsGained() {
        return this.pointsGained;
    }

    public void setPointsGained(int pointsGained) {
        this.pointsGained = pointsGained;
    }
}
