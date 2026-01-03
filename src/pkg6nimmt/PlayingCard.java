/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

/**
 *
 * @author artyom
 */
public class PlayingCard implements Comparable<PlayingCard> {
    private int player;
    private Card card;

    public int getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public int compareTo(PlayingCard pc) {
        return (int)(this.getCard().getNum() - pc.getCard().getNum());
    }
    
    @Override
    public String toString() {
        return getCard().toString();
    }
}
