/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.statics;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.Entity;

/**
 * Entities that do not move like trees or rocks
 * @author justin
 */
public abstract class StaticEntity extends Entity{
    
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }
    
    @Override public void die(){
        
    }
}
