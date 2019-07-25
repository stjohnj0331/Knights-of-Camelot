package dev.algorythmic.KoC;

import dev.algorythmic.KoC.display.Display;
import dev.algorythmic.KoC.gfx.Assets;
import dev.algorythmic.KoC.gfx.ImageLoader;
import dev.algorythmic.KoC.gfx.SpriteSheet;
import dev.algorythmic.KoC.states.GameState;
import dev.algorythmic.KoC.states.MenuState;
import dev.algorythmic.KoC.states.SettingsState;
import dev.algorythmic.KoC.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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
    
    //STATES
    private State gameState;
    private State settingsState;
    private State menuState;
    
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
        Assets.init();
        //test = ImageLoader.loadImage("/textures/Player.png");
        gameState = new GameState();
        settingsState = new SettingsState();
        menuState = new MenuState();
        State.setState(gameState);
    }
    
    /**
     * tick() will update our variables
     */
    private void tick(){
        if(State.getState() != null)
            State.getState().tick();
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
        if(State.getState() != null)
            State.getState().render(g);
        
        //END OF DRAWING MUST DO!!!!
        bs.show();
        g.dispose();
    }
    /**
     * used to run the game loop
     */
    @Override public void run() {
        init();
        
        int fps = 60;
        double timePerTick = 1_000_000_000/*nano-seconds*/ / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1_000_000_000){
                System.out.println("FPS: "+ticks);
                ticks = 0;
                timer = 0;
            }
                
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
