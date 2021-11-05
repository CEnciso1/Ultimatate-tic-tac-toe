/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ultimatettt;

/**
 *
 * @author CHRIS
 */
public class DriverMain {
    public static void main(String[] args){
        UltimateGame uGame = new UltimateGame();
        uGame.setPlayers(new RoboPlayer("Player 1", "N"), new HumanPlayer("Player 2", "X"));
        uGame.start();

    }
}
