package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.Camera;

public class Coin extends Entity {
	private BufferedImage[] coin;
	private int frames = 0, maxFrames = 7, maxIndex = 4;
	public int index=0;

	public Coin(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, sprite, tipo);
		// TODO Auto-generated constructor stub
		coin = new BufferedImage[5];

		
		for (int i = 0;i < 5;i++) {
			coin[i] = Game.spritesheet.getSprite(60 + (i * 10), 653, 8, 12);

		}
		
		
	}
	
	public void tick() {
		
		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;
			if (index > maxIndex) {
				index = 0;

			}
		}
		
	
	}
	
	public void render(Graphics g) {
		g.drawImage(coin[index], this.getX() - Camera.x,this.getY() - Camera.y, null);
	}

					

}
