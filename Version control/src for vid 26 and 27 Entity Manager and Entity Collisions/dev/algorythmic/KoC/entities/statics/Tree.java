/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.statics;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.tiles.Tile;
import java.awt.Graphics;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Color;



/**
 *
 * @author justin
 */
public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);
        //customize this to fit your entity.
        bounds.x = 20;
        bounds.y = 100;
        bounds.width = 28;
        bounds.height = 30;
    }

    @Override public void tick() {
        
    }

    @Override public void render(Graphics g) {
        g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset())
                , (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        //for making the collision box visible
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                //(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
    
}
