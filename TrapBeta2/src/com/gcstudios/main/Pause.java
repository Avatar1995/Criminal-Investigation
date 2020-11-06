package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Pause {

	public int currentOption = 0;
	public int maxOption = 1;
	
	public boolean up,down,enter;
	private BufferedImage[] pauseImage;
	
	public boolean pause = false;
	
	
	public Pause() {

		pauseImage = new BufferedImage[1];
		
		pauseImage[0] = Game.spritesheet.getSprite(115, 168, 82, 56);
	}
	
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			if(currentOption == 0) {
				Game.gameState = "NORMAL";
				Game.abaixarAumentarMusica();
			}else if(currentOption == 1) {
				System.exit(1);
			}
			enter = false;
		}

	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.drawImage(pauseImage[0], ((Game.WIDTH*Game.SCALE)/2) - 30,((Game.HEIGHT*Game.SCALE)/2) - 80, null);
		//Opcoes de menu
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,20));
		
		if(currentOption == 0) {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 30, 185);
		}else if(currentOption == 1) {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 45, 203);
		}
	}
}