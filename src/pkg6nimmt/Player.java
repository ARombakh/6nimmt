/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author artyom
 */
public class Player {
    private Card turn;
    private CardList hand;
    private CardList taken;
    
    public Player() {
        setHand(new CardList());
        setTaken(new CardList());
    }

    public Card getTurn() {
        return turn;
    }

    public CardList getHand() {
        return hand;
    }

    public CardList getTaken() {
        return taken;
    }

    public void setTurn(Card turn) {
        this.turn = turn;
    }

    public void setHand(CardList hand) {
        this.hand = hand;
    }

    public void setTaken(CardList taken) {
        this.taken = taken;
    }
    
    public Card chooseCard(int cardNum) {
        for (int i = 0; i < getHand().getCards().size(); i++) {
            if (getHand().getCards().get(i).getNum() == cardNum) {
                return getHand().getCards().get(i);
            }
        }
        
        return null;
    }
    
    public Card askInput() {
        Scanner scanner = new Scanner(System.in);
        
        int cardNum = 0;
        
        Card card = null;
        
        while (card == null) {
            System.out.println(getHand().toString());
            System.out.println("Choose the card number:");
            cardNum = scanner.nextInt();
            
            card = chooseCard(cardNum);
            if (card == null) {
                System.out.println("Incorrect card number. Repeat input.");
            }
        }
        
        return card;
    }
    
    public int askRow() {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        boolean corrRow = false;
        
        while (!corrRow) {
            System.out.println("Choose row number:");
            row = scanner.nextInt();
            corrRow = (row >= 0 && row < Table.ROWS_IN_TABLE);
            if (!corrRow) {
                System.out.println("Wrong row, input another row.");
            }
        }
        
        return row;
    }
    
    public Card removeCard(Card card) {
        return getHand().removeCard(card);
    }
    
    public int countBullheads() {
        int sum = 0;
        for (Card card : getTaken().getCards()) {
            sum += card.getBullheads();
        }
        
        return sum;
    }
    
    @Override
    public String toString() {
        return "Player's hand:\n" + getHand().toString() + "\n" +
                "Player's taken:\n" + getTaken().toString() + "\n";
    }
}