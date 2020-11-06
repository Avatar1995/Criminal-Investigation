package com.gcstudios.graficos;



import java.awt.Graphics;
import java.awt.image.BufferedImage;


import com.gcstudios.entities.Player;
import com.gcstudios.main.Game;

public class UI  {
	private BufferedImage[] life;
	private BufferedImage[] shield;
	
	public UI(int x, int y, int width, int height, BufferedImage sprite) {
		life = new BufferedImage[11];
		
		for (int i = 0;i < 11;i++) {
			
			life[i] = Game.spritesheet.getSprite(0, 53 + (i * 10), 53, 10);
			if ((i >= 5) && (i < 10)) {
				life[i] = Game.spritesheet.getSprite(54, 53 + ((i - 5) * 10), 53, 10);	
			}
			
			if (i == 10) {
				life[i] = Game.spritesheet.getSprite(54, 144, 53, 10);	
			}
		}
		
		shield = new BufferedImage[11];
		
		for (int i = 0;i < 11;i++) {
			
			shield[i] = Game.spritesheet.getSprite(0, 163 + (i * 10), 53, 10);
			if (i >= 5)  {
				shield[i] = Game.spritesheet.getSprite(54, 163 + ((i - 5) * 10), 53, 10);	
			}
			
		}
	}

	public void render(Graphics g) {
		if ((Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1) && (!Game.messageNPC))  {
		if (Player.shield <= 100 && Player.shield > 90) {
			g.drawImage(shield[0], 3,Game.HEIGHT - 28, null);
		} else if (Player.shield <= 90 && Player.shield > 80) {
			g.drawImage(shield[1], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 80 && Player.shield > 70) {
			g.drawImage(shield[2], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 70 && Player.shield > 60) {
			g.drawImage(shield[3], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 60 && Player.shield > 50) {
			g.drawImage(shield[4], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 50 && Player.shield > 40) {
			g.drawImage(shield[5], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 40 && Player.shield > 30) {
			g.drawImage(shield[6], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 30 && Player.shield > 20) {
			g.drawImage(shield[7], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 20 && Player.shield > 10) {
			g.drawImage(shield[8], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 10 && Player.shield > 0) {
			g.drawImage(shield[9], 3,Game.HEIGHT - 28, null);
		
		} else if (Player.shield <= 0) {
			g.drawImage(shield[10], 3,Game.HEIGHT - 28, null);
		
		}
				
		if (Player.life <= 100 && Player.life > 90) {
			g.drawImage(life[0], 3,Game.HEIGHT - 15, null);
		} else if (Player.life <= 90 && Player.life > 80) {
			g.drawImage(life[1], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 80 && Player.life > 70) {
			g.drawImage(life[2], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 70 && Player.life > 60) {
			g.drawImage(life[3], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 60 && Player.life > 50) {
			g.drawImage(life[4], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 50 && Player.life > 40) {
			g.drawImage(life[5], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 40 && Player.life > 30) {
			g.drawImage(life[6], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 30 && Player.life > 20) {
			g.drawImage(life[7], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 20 && Player.life > 10) {
			g.drawImage(life[8], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 10 && Player.life > 0) {
			g.drawImage(life[9], 3,Game.HEIGHT - 15, null);
		
		} else if (Player.life <= 0) {
			g.drawImage(life[10], 3,Game.HEIGHT - 15, null);
		
		}
		}
		
	}
	
}
