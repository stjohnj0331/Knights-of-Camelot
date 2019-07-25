/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Game;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class Player extends Creature{
    
    private Game game;
    
    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override public void tick() {
        getInput();
        move();
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
    }
    @Override public void render(Graphics g) {
        //TEST CODE
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }
    
}
