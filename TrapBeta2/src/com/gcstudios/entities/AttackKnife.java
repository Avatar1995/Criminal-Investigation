package com.gcstudios.entities;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.Game;

public class AttackKnife extends Entity{
	private BufferedImage rightAttack;
	private BufferedImage leftAttack;
	private BufferedImage downAttack;
	private BufferedImage upAttack;
	public static int attackKnife, tipo;
	private double dx;
	private double dy;
	private double spd = 4;
	public static boolean controle = false;
	
	
	private int timeCena, maxTimeCena = 10;
	
	public AttackKnife(int x, int y, int width, int height, BufferedImage sprite, int direcaoAttack, int tipo) {
		super(x, y, width, height, sprite,tipo);
		
		rightAttack = Game.spritesheet.getSprite(33,45,8,5);
		leftAttack = Game.spritesheet.getSprite(42,45,8,5);
		downAttack = Game.spritesheet.getSprite(27,44,5,8);
		upAttack = Game.spritesheet.getSprite(21,44,5,8);
		attackKnife = direcaoAttack; 
		this.tipo = tipo;

	}
	
	public void tick() {
			timeCena++;
			if (timeCena <= maxTimeCena) {
				Game.player.attackknife = true;
				if (attackKnife == 0) {
					Game.player.staticRight = true;
				}
		
				if (attackKnife == 1) {
					Game.player.staticLeft= true;
				}
		
				if (attackKnife == 3) {
					Game.player.staticDown = true;
				}
		
				if (attackKnife == 2) {
					Game.player.staticUp = true;
				}
		
			} else {
						
				Game.attackknife.remove(this);
				timeCena = 0;
				Game.player.attackknife = false;
						
			}
		
		
		
	}
	
	public void render(Graphics g){
		if (attackKnife == 0) { 
			g.drawImage(rightAttack, this.getX() - Camera.x,this.getY() - Camera.y, null);

		}
		
		if (attackKnife == 1) { 
			g.drawImage(leftAttack, this.getX() - Camera.x,this.getY() - Camera.y, null);
		}
		
		if (attackKnife == 3) { 
			g.drawImage(downAttack, this.getX() - Camera.x,this.getY() - Camera.y, null);
		}
		
		if (attackKnife == 2) { 
			g.drawImage(upAttack, this.getX() - Camera.x,this.getY() - Camera.y, null);
		}
		
	}
}