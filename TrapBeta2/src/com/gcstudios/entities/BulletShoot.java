package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.World;
import com.gcstudios.world.Camera;

public class BulletShoot extends Entity{

	private double dx;
	private double dy;
	private int direcaoTiro;
	public int tipo;
	private double spd = 3;
	private int controleTiroDireitaX,controleTiroEsquerdaX,controleTiroCimaY,controleTiroBaixoY;
	
	private int life = 100,curLife = 0;
	
	
	public BulletShoot(int x, int y, int width, int height, BufferedImage sprite,double dx,double dy, int direcaoTiro, int tipo) {
		super(x, y, width, height, sprite, tipo);
		this.dx = dx;
		this.dy = dy;
		this.direcaoTiro = direcaoTiro;
		this.tipo = tipo;
	}
	
	public void tick() {
		x+=dx*spd;
		y+=dy*spd;
		curLife++;
		isCollidingWithObject(x, y);			
		if (!World.isFree((int)(x) ,(int)y,1)) {
			Game.bullets.remove(this);
			return;
		}

		
		if(curLife == life) {
			Game.bullets.remove(this);
			return;
		}
	}
	
	public void isCollidingWithObject(double xnext, double ynext) {
		Rectangle bullet = new Rectangle((int)xnext, (int)ynext,3,3);
		
		for (int i = 0; i < Game.items.size();i++) {
			Items it = Game.items.get(i);
			Rectangle object = new Rectangle(it.getX(), it.getY(),10,16);
			if ((bullet.intersects(object)) && (Game.items.get(i).tipo != 1)) {
				Game.bullets.remove(this);
			}
		}
		
	
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(this.getX() - Camera.x,this.getY() - Camera.y,width,height);
	}
	
}