/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

/**
 *
 * @author artyom
 */
public class Card implements Comparable<Card> {
    private int num;
    private int bullheads;

    public Card(int num, int bullheads) {
        setNum(num);
        setBullheads(bullheads);
    }
    
    public int getNum() {
        return num;
    }

    public int getBullheads() {
        return bullheads;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setBullheads(int bullheads) {
        this.bullheads = bullheads;
    }
    
    @Override
    public String toString() {
        return "Card " + getNum() + " bullheads " + getBullheads();
    }
    
    @Override
    public int compareTo(Card c) {
        return (int)(this.getNum() - c.getNum());
    }
}
