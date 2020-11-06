package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.gcstudios.world.Camera;


import java.awt.Graphics;
import java.awt.Graphics2D;

public class Abertura {

	private int time = 0, time2 = 0, maxTime = 180, maxTime2 = 300;
	private BufferedImage[] abertura;
	private int index = 0;

	public Abertura() {

		abertura = new BufferedImage[2];
		
		abertura[0] = Game.spritesheet.getSprite(112, 240, 105, 68);
		abertura[1] = Game.spritesheet.getSprite(112, 328, 105, 68);
	
	}

	
	public void tick() {
		time++;
		if (time >= maxTime) {
			if (time == maxTime) {
				AudioPlayer.playSound(AudioClip.abertura,2,1);
			} 
			index = 1;
			time2++;
			if (time2 > maxTime2) {
				Game.permissao = false;
				Game.gameState = "MENU";
				
			}
				
		}


	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.drawImage(abertura[index], (Game.WIDTH*Game.SCALE) / 2 - 55 , ((Game.HEIGHT*Game.SCALE) / 2) - 50, null);
		
		
	}
	
}