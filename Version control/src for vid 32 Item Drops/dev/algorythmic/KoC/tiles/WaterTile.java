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
public class WaterTile extends Tile {
    
    public WaterTile(int id) {
        super(Assets.water, id);
    }
    
    @Override public boolean isNotTraversable(){return true;}
}
