package dev.algorythmic.KoC;

import dev.algorythmic.KoC.display.Display;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open thes template in the editor.
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
    
    private boolean running = false;//FOR OUR THREAD
    
    private BufferStrategy bs;
    
    private Graphics g;
    
    //CONSTRUCTOR
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    //OTHER METHODS
    /**
     * Used to run all of our graphics
     * called in the start() method
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
     * render() will render our game or draw to the screen
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();//our paint brush
        //CLEAR THE SCREEN
        g.clearRect(0, 0, width, height);
        
        //DRAW HERE (order matters)
        g.drawRect(10, 50, 50, 70);
        g.setColor(Color.red);
        g.fillRect(10, 50, 50, 70);
        g.setColor(Color.blue);
        g.fillRect(10, 50, 10, 10);
        
        
        //END OF DRAWING MUST DO!!!!
        bs.show();
        g.dispose();
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
     * checks for an instance of our game and starts it if running is false
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();//calls the run method above
    }
    /**
     * thread.join must be surrounded by a try/catch for exception handling
     * checks for an instance of our game and stops it if running is true
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
