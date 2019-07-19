/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.states;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.gfx.GFXAssets;
import dev.algorythmic.KoC.ui.ClickListener;
import dev.algorythmic.KoC.ui.UIImageButton;
import dev.algorythmic.KoC.ui.UIManager;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author justin
 */
public class MenuState extends State{
    
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200,200,128,64, GFXAssets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }
    
    @Override public void tick() {
        uiManager.tick();
    }

    @Override public void render(Graphics g) {
        uiManager.render(g);
    }
    
}
