/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.tiles;

import dev.algorythmic.KoC.gfx.Assets;
/**
 *
 * @author justin
 */
public class StoneWallTile extends Tile{
    
    public StoneWallTile(int id) {
        super(Assets.stoneWall, id);
    }
    
    @Override public boolean isSolid(){return true;}
}
