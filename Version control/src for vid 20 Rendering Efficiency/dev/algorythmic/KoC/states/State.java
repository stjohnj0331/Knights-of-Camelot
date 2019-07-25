/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.Game;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public abstract class State {
    //NON-ABSTRACT GAME STATE MANAGER
    private static State currentState = null;
        //ACCESSOR
    public static State getState(){return currentState;}
        //MUTATOR
    public static void setState(State state){currentState = state;}
    
    //ABSTRACT CLASS
        //CLASS VARIABLES
    protected Game game;
    
        //CONSTRUCTOR
    public State(Game game){
        this.game = game;
    }
        //OTHER METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    
}
