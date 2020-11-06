package com.gcstudios.entities;



import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;

public class Items extends Entity {
	public int tipo = -1;
	private BufferedImage itemsSprite;

	public Items(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, sprite, tipo);
		// TODO Auto-generated constructor stub
		itemsSprite = sprite;
		this.x = x;
		this.y = y;
		this.tipo = tipo;

	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(itemsSprite, this.getX() - Camera.x,this.getY() - Camera.y, null);		
		
	}

}