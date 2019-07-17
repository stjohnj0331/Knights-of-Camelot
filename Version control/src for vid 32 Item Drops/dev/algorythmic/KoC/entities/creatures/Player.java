/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.algorythmic.KoC.entities.creatures;

import dev.algorythmic.KoC.Handler;
import dev.algorythmic.KoC.entities.Entity;
import dev.algorythmic.KoC.gfx.Animation;
import dev.algorythmic.KoC.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin
 */
public class Player extends Creature{
    
    //ATTACK TIMERS
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    
    //ANIMATIONS
    private Animation animDown, animUp, animLeft, animRight, animStand, atkUp, atkDown, atkLeft, atkRight;
    
    
    //CONSTUCTOR
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 150, 150);
        //customize this to fit your character.
        bounds.x = 67;
        bounds.y = 78;
        bounds.width = 18;
        bounds.height = 30;
        
        //ANIMATIONS
            //MOVEMENT
            animDown = new Animation(500, Assets.player_down);
            animUp = new Animation(500, Assets.player_up);
            animLeft = new Animation(500, Assets.player_left);
            animRight = new Animation(500, Assets.player_right);
            animStand = new Animation(500,Assets.player_stand);
            //ATTACK
            atkDown = new Animation(50,Assets.atk_down);
    }
    
    @Override public void die() {
        System.out.println("You Lose");
    }
    
    @Override public void tick() {
        //ANIMATIONS
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animStand.tick();
        atkDown.tick();
        
        //MOVEMENT
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //ATTACK
        checkAttacks();
    }
    public void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        
        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else{
            return;
        }
        
        attackTimer = 0;
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        xAttack = 0;
        yAttack = 0;
        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
        if(handler.getKeyManager().aDown){
            yAttack = 1;
        }
        if(handler.getKeyManager().aLeft){
            xAttack = -1;
        }
        if(handler.getKeyManager().aRight){
            xAttack = 1;
        }
        if(handler.getKeyManager().aUp){
            yAttack = -1;
        }
    }
    @Override public void render(Graphics g) {
        
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
        //for making the collision box visible
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                //(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){//left
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){//right
            return animRight.getCurrentFrame();
        }else if(yMove < 0){//up
            return animUp.getCurrentFrame();
        }else if(yMove > 0){//down
            return animDown.getCurrentFrame();
        }else if(yAttack > 0){
            return atkDown.getCurrentFrame();
        }else//facing down
            return Assets.player_stand[0];
    }

    
}
