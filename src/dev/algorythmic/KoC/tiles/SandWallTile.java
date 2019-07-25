/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.tiles;

import dev.algorythmic.KoC.gfx.GFXAssets;
/**
 *
 * @author justin
 */
public class SandWallTile extends Tile{
    
    public SandWallTile(int id) {
        super(GFXAssets.sandWall, id);
    }
    
    @Override public boolean isNotTraversable(){return true;}
}
