/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author artyom
 */
public class CardList {
    private ArrayList<Card> cards;
    
    public CardList() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void addCard(Card card) {
        getCards().add(card);
    }
    
    @Override
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result = result + card.toString() + "\n";
        }
        return result;
    }
    
    public Card removeCard(int num) {
        for (Card card : cards) {
            if (num == card.getNum()) {
                cards.remove(card);
                return card;
            }
        }
        
        return null;
    }
    
    public Card removeCard(Card card) {
        for (Card card1 : cards) {
            if (card1 == card) {
                cards.remove(card);
                return card;
            }
        }
        
        return null;
    }
}
