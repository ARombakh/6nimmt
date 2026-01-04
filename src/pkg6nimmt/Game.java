/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6nimmt;

/**
 *
 * @author artyom
 */
public class Game {
    private Table table;
    private Player[] players;
    
    public Table getTable() {
        return table;
    }

    public Player[] getPlayers() {
        return players;
    }
    
    public void setTable(Table table) {
        this.table = table;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Game(Player[] players, Table table) {
        setPlayers(players);
        setTable(table);
    }
    
    
    public void transferRowToPlayer (Table table, int row, Player player,
            Card card) {
        CardList cl = new CardList();
        
        cl.getCards().addAll(table.getRows()[row].getCards());
        
        table.getRows()[row].getCards().removeAll(
                table.getRows()[row].getCards()
        );
        
        table.getRows()[row].addCard(card);
        
        player.getTaken().getCards().addAll(cl.getCards());
    }
    
    public void addToTable (Table table, Player player, Card card) {
        int row = table.findFitRow(card);
        if (row == -1) {
            System.out.println("Choose the row to pick:");
            System.out.println(table.toString());
            row = player.askRow();
            transferRowToPlayer(table, row, player, card);
        } else {
            if (table.getRows()[row].getCards().size() == Table.CARDS_IN_ROW) {
                transferRowToPlayer(table, row, player, card);
            } else {
                table.getRows()[row].addCard(card);
            }
        }
    }
}