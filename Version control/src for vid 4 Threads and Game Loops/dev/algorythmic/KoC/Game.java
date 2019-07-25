package dev.algorythmic.KoC;

import dev.algorythmic.KoC.display.Display;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Game implements Runnable{
    
    //CLASS VARIABLES
    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    
    //CONSTRUCTOR
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    //OTHER METHODS
    /**
     * Used to run all of our graphics
     */
    private void init(){
        display = new Display(title,width,height);
    }
    
    /**
     * tick() will update our variables
     */
    private void tick(){
        
    }
    
    /**
     * render() will render our game
     */
    private void render(){
        
    }
    /**
     * used to run the game loop
     */
    @Override public void run() {
        init();
        
        while(running){
            tick();
            render();
        }
        
        stop();
        
    }
    
    //THREAD CODE
    /**
    * threads are mini programs that run separately from the rest of the code in our application
    */
    private Thread thread;
    
    /**
     * we always use synchronized methods when working with threads
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();//calls the run method above
    }
    /**
     * thread.join must be surrounded by a try/catch
     */
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
