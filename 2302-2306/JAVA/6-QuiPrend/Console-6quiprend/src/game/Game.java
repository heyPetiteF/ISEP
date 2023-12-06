package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import card.Card;
import dbConnect.DBConnect;
import player.Player;
import row.Row;

public class Game {
    public static int numOfPlayers = 5;
    public static int numOfRows = 4;
    public static int handSize = 10;
    public static int deckSize = 104;
    public static int numDataObjects = 0;
    public static ArrayList<Card> dataArray = new ArrayList();
    public static Card card = new Card();
    public static Row row = new Row();
    public static ArrayList<Card> deck = new ArrayList();
    public static Player[] playerArray;
    public static Row[] rowArray;
    public static ArrayList<Card> cardArray;
    public static int[] lastCardIDs;
    public static int rCardValue;
    public static int pCardValue;
    public static int gameInterest;
    public static int turnInterest;
    public static int playInterest;

    static {
        playerArray = new Player[numOfPlayers];
        rowArray = new Row[numOfRows];
        cardArray = new ArrayList();
        lastCardIDs = new int[numOfRows];
        rCardValue = 0;
        pCardValue = 0;
        gameInterest = 7;
        turnInterest = 1;
        playInterest = 1;
    }

    public Game() {
    }

    public static void initGame() {
        createDeck();
        createPlayers();
        deal();
        createRows();
    }

    public static void createDeck() {
        for(int i = 0; i < deckSize; ++i) {
            System.out.println("Card " + (i + 1) + " has been created");
            Card card = new Card();
            deck.add(card);
            card.setCardValues(i + 1);
        }

        Collections.shuffle(deck);
        System.out.println("-----Deck has been created and shuffled-----");
    }

    public static void createPlayers() {
        for(int i = 0; i < numOfPlayers; ++i) {
            playerArray[i] = new Player();
            playerArray[i].setPlayerID(i);
        }

    }

    public static void deal() {
        for(int i = 0; i < playerArray.length; ++i) {
            System.out.println("Dealing cards to player " + i);

            for(int q = 0; q < handSize; ++q) {
                Card card = (Card)deck.get(0);
                playerArray[i].takeCard(card);
                deck.remove(0);
            }
        }

        ++numDataObjects;
        System.out.println("numDataObjects = " + numDataObjects);
    }

    public static void createRows() {
        int i;
        for(i = 0; i < numOfRows; ++i) {
            rowArray[i] = new Row();
            rowArray[i].setRowID(i);
            System.out.println("row " + i + " added to row array");
        }

        for(i = 0; i < numOfRows; ++i) {
            Card card = (Card)deck.get(0);
            rowArray[i].takeCard(card);
            deck.remove(0);
        }

    }

    public static void go() {
        for(int i = 0; i < handSize; ++i) {
            playersPlay();
            resolvePlayersPlays(i);
            addDataToFactData(i);
            DBConnect.addDataToGameIndex(1, gameInterest, i, turnInterest);
        }

    }

    public static void playersPlay() {
        for(int q = 0; q < playerArray.length; ++q) {
            playerArray[q].playCard();
        }

    }

    public static void resolvePlayersPlays(int i) {
        int currentBestValue = 0;
        int currentBestRow = 10;
        int currentLowestCard = 1 + deckSize;
        int currentLowestCardsRow = 0;

        for(int q = 0; q < playerArray.length; ++q) {
            int j;
            Card rowCard;
            for(j = 0; j < cardArray.size(); ++j) {
                rowCard = (Card)cardArray.get(j);
                if (rowCard != null) {
                    int cardValue = rowCard.getCardID();
                    if (cardValue < currentLowestCard) {
                        currentLowestCardsRow = j;
                        currentLowestCard = cardValue;
                    }
                }
            }

            currentLowestCard = deckSize + 1;
            Game.card = (Card)cardArray.get(currentLowestCardsRow);
            cardArray.remove(currentLowestCardsRow);
            if (Game.card != null) {
                pCardValue = Game.card.getCardID();

                for(j = 0; j < rowArray.length; ++j) {
                    rowCard = rowArray[j].getLastCard();
                    if (rowCard != null) {
                        rCardValue = rowCard.getCardID();
                        if (pCardValue > rCardValue && rCardValue > currentBestValue) {
                            currentBestValue = rCardValue;
                            currentBestRow = j;
                        }
                    }
                }

                if (currentBestRow == 10) {
                    currentBestRow = playerArray[q].pickRowTake();
                    rowArray[currentBestRow].replaceRow(Game.card);
                    currentBestValue = 0;
                } else {
                    rowArray[currentBestRow].takeCard(Game.card);
                    currentBestValue = 0;
                }

                dataArray.add(Game.card);
            }
        }

        addDataToPlayData(i);
    }

    public static void addDataToFactData(int i) {
        Random rand = new Random();
        numDataObjects = 3 + 2 * rowArray.length;

        int q;
        int p;
        for(q = 0; q < rowArray.length; ++q) {
            for(p = 0; p < rowArray[q].getNumCards(); ++p) {
                numDataObjects += 2;
            }
        }

        int randNum;
        for(q = 0; q < rowArray.length; ++q) {
            randNum = rand.nextInt(numDataObjects) + 1;
            if (randNum <= gameInterest) {
                DBConnect.addDatatoFactData(1, i, "\"NumCards\"", rowArray[q].getNumCards(), "\"R" + q + "\"");
            }

            randNum = rand.nextInt(numDataObjects) + 1;
            if (randNum <= gameInterest) {
                DBConnect.addDatatoFactData(1, i, "\"PointValue\"", rowArray[q].getPointValue(), "\"R" + q + "\"");
            }

            for(p = 0; p < rowArray[q].getNumCards(); ++p) {
                Card recordCard = rowArray[q].getCard(p);
                randNum = rand.nextInt(numDataObjects) + 1;
                if (randNum <= gameInterest) {
                    DBConnect.addDatatoFactData(1, i, "\"CardID\"", recordCard.getCardID(), "\"C" + p + "R" + q + "\"");
                }

                randNum = rand.nextInt(numDataObjects) + 1;
                if (randNum <= gameInterest) {
                    DBConnect.addDatatoFactData(1, i, "\"PointValue\"", recordCard.getPointValue(), "\"C" + p + "R" + q + "\"");
                }
            }
        }

        randNum = rand.nextInt(numDataObjects) + 1;
        if (randNum <= gameInterest) {
            DBConnect.addDatatoFactData(1, i, "\"NumPlayers\"", numOfPlayers, "\"G\"");
        }

        randNum = rand.nextInt(numDataObjects) + 1;
        if (randNum <= gameInterest) {
            DBConnect.addDatatoFactData(1, i, "\"NumCards\"", 9 - i, "\"H\"");
        }

        randNum = rand.nextInt(numDataObjects) + 1;
        if (randNum <= gameInterest) {
            DBConnect.addDatatoFactData(1, i, "\"NumCards\"", deck.size(), "\"D\"");
        }

    }

    public static void score() {
        for(int i = 0; i < numOfPlayers; ++i) {
            int points = playerArray[i].getPoints();
            System.out.println("Player " + i + " got " + points + " points");
        }

    }

    public static void addDataToPlayData(int i) {
        int averagePoints = 0;

        int q;
        Card dataCard;
        for(q = 0; q < numOfPlayers; ++q) {
            dataCard = (Card)dataArray.get(q);
            averagePoints += dataCard.getPointsGained();
        }

        averagePoints /= numOfPlayers;

        for(q = 0; q < numOfPlayers; ++q) {
            dataCard = (Card)dataArray.get(q);
            int success = averagePoints - dataCard.getPointsGained();
            DBConnect.addDataToPlayData(1, i, dataCard.getOwner(), dataCard.getCardID(), success, success);
        }

    }

    public static void cardToRow(int i) {
        Card card = (Card)deck.get(0);
        rowArray[i].takeCard(card);
        deck.remove(0);
    }

    public static void givePlayerPoints(int player, int points) {
    }

    public static void cardsToGame(Card newCard) {
        cardArray.add(newCard);
    }

    public static Player[] getPlayerArray() {
        return playerArray;
    }

    public static void setPlayerArray(Player[] newPlayerArray) {
        playerArray = newPlayerArray;
    }

    public static Row[] getRowArray() {
        return rowArray;
    }

    public static void setRowArray(Row[] newRowArray) {
        rowArray = newRowArray;
    }
}
