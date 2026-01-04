/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg6nimmt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
        
/**
 *
 * @author artyom
 */
public class Main {
    
    public static final int PLAYERS_QTY = 4;
    public static final int HAND_QTY = 10;
    public static final int DECK_QTY = 104;

    /**
     * @param args the command line arguments
     */
    
    public static int returnRandCardNum(CardList cl) {
        int cardN;
        Random rand = new Random();
        cardN = rand.nextInt(cl.getCards().size());
        return cardN;
    }
    
    public static CardList initDeck(CardList cl) {
        Card card;
        String istr;
        int i;
        for (i = 1; i <= DECK_QTY; i++) {
            card = new Card(i, 1);
            
            if (i % 10 == 5) {
                card = new Card(i, 2);
            }
            
            if (i % 10 == 0) {
                card = new Card(i, 3);
            }
            
            istr = Integer.toString(i);
            
            if (istr.length() == 2 && istr.charAt(0) == istr.charAt(1)) {
                card = new Card(i, 5);
            }
            
            if (i == 55) {
                card = new Card(i, 7);
            }
            
            cl.getCards().add(card);
        }
        
        return cl;
    }

    public static void main(String[] args) {
        CardList cl = new CardList();
        
        cl = initDeck(cl);
        Card card;
        int i;
        
        int cardN;
        int j;
        Player players[] = new Player[PLAYERS_QTY];
        
        for (i = 0; i < PLAYERS_QTY; i++) {
            players[i] = new Player();
        }
        
        Table table = new Table();
        
        for (i = 0; i < PLAYERS_QTY; i++) {
            for (j = 0; j < HAND_QTY; j++) {
                cardN = returnRandCardNum(cl);
                players[i].getHand().addCard(cl.getCards().remove(cardN));
            }
        }

        for (i = 0; i < PLAYERS_QTY; i++) {
            Collections.sort(players[i].getHand().getCards());
        }

        Game game = new Game(players, table);
        
        for (i = 0; i < Table.ROWS_IN_TABLE; i++) {
            cardN = returnRandCardNum(cl);
            game.addCardToTableRow(i, cl.getCards().remove(cardN));
        }
        
        while (!players[0].getHand().getCards().isEmpty()) {            
            System.out.println(table.toString());

            PlayingCard[] cardsToGo = new PlayingCard[PLAYERS_QTY];

            for (i = 0; i < PLAYERS_QTY; i++) {
                cardsToGo[i] = new PlayingCard();
                System.out.println("Player " + i + " turn");
                if (players[i].getHand().getCards().size() > 1) {
                    cardsToGo[i].setCard(players[i].removeCard(
                            players[i].askInput())
                    );
                } else {
                    card = players[i].getHand().getCards().get(0);
                    System.out.println("Removing card " + card.toString());
                    cardsToGo[i].setCard(players[i].removeCard(card));
                }
                cardsToGo[i].setPlayer(i);
            }

            Arrays.sort(cardsToGo);

            System.out.println("");
            for (i = 0; i < PLAYERS_QTY; i++) {
                System.out.println("Player no. " + cardsToGo[i].getPlayer() +
                        " " + cardsToGo[i].toString());
            }
            
            for (i = 0; i < PLAYERS_QTY; i++) {
                System.out.println("Player's " + cardsToGo[i].getPlayer() + 
                        " turn");

                game.addToTable(table, players[cardsToGo[i].getPlayer()],
                        cardsToGo[i].getCard());
            }

            for (i = 0; i < PLAYERS_QTY; i++) {
                System.out.println("\n\nPlayer's " + i + ":\n" +
                        players[i].toString());
            }

            System.out.println(table.toString());
        }
        
        int smallest = DECK_QTY;
        
        for (i = 0; i < PLAYERS_QTY; i++) {
            if (smallest > players[i].countBullheads()) {
                smallest = players[i].countBullheads();
            }
        }
        
        ArrayList<Integer> winners = new ArrayList<>();
        
        for (i = 0; i < PLAYERS_QTY; i++) {
            if (smallest == players[i].countBullheads()) {
                winners.add(i);
            }
        }
        
        if (winners.size() > 1) {
            System.out.println("The winners with " + smallest + 
                    " bullheads are:");
        } else {
            System.out.println("The winner with " + smallest + 
                    " bullheads is:");
        }
        
        for (Integer winner : winners) {
            System.out.println(winner);
        }
    }
}