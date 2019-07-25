package dev.algorythmic.KoC;

import dev.algorythmic.KoC.display.Display;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author justin
 * The main class of our game
 * it will open, run, and close our game.
 */
public class Game {
    
    private Display display;
    public int width, height;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        display = new Display(title,width,height);
    }
    
}
