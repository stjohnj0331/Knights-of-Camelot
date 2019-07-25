/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.Handler;
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
    protected Handler handler;
    
        //CONSTRUCTOR
    public State(Handler handler){
        this.handler = handler;
    }
        //OTHER METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    
}
