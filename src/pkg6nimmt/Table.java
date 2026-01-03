/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

import java.util.ArrayList;
import static pkg6nimmt.Main.DECK_QTY;

/**
 *
 * @author artyom
 */
public class Table {
    private CardList[] rows;
    public static final int ROWS_IN_TABLE = 4;
    public static final int CARDS_IN_ROW = 5;

    public CardList[] getRows() {
        return rows;
    }

    public void setRows(CardList[] rows) {
        this.rows = rows;
    }
    
    public Table() {
        setRows(new CardList[ROWS_IN_TABLE]);
        
        for (int i = 0; i < ROWS_IN_TABLE; i++) {
            getRows()[i] = new CardList();
        }
        /* ?? Почему пустой CardList получается если инициализировать вот так:
        for (CardList row : rows) {
            row = new CardList();
        }*/
    }

    public int findFitRow(Card card) {
        int[] okRows;
        okRows = new int[ROWS_IN_TABLE];
        Card cardCurr;
        int smallest = DECK_QTY;
        int result = -1;
        for (int i = 0; i < ROWS_IN_TABLE; i++) {
            okRows[i] = 0;
            cardCurr = rows[i].getCards().get(
                    getRows()[i].getCards().size() - 1
            );
            if (card.getNum() > cardCurr.getNum()) {
                okRows[i] = card.getNum() - cardCurr.getNum();
                if (smallest > card.getNum() - cardCurr.getNum()) {
                    smallest = card.getNum() - cardCurr.getNum();
                }
            }
        }
        
        if (smallest == DECK_QTY) {
            return result;
        }
        
        for (int i = 0; i < ROWS_IN_TABLE; i++) {
            if (okRows[i] == smallest) {
                result = i;
            }
        }
        
        return result;
    }
    
    public boolean checkAddToRow(int row, Card card) {
        return rows[row].getCards().size() == CARDS_IN_ROW;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < ROWS_IN_TABLE; i++) {
            result = result + i + ". row is " + getRows()[i].toString();
        }
        return result;
    }
}
