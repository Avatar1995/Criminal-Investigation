package com.gcstudios.main;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;

public class GameOver {	
	public int time = 0;
	public boolean deathCharacter = false;
	private int frames = 0, maxFrames = 15, maxIndex = 4;
	public int index = 0;
	public int maxTime = 8;
	public GameOver() {
	}
	
	public void animacaoMorte() {
		if (deathCharacter) {
			Game.player.dir = Game.player.right_dir;
			Game.player.staticRight = true;
			Game.player.rightPlayer = new BufferedImage[5];
			for (int i = 0;i < 5;i++) {
				if (i == 0) {
					Game.player.rightPlayer[i] = Game.spritesheet.getSprite(60, 108, 10, 16);
				} else
					Game.player.rightPlayer[i] = Game.spritesheet.getSprite(45 + (i * 10), 908, 9, 16);

			}
		}
	}
	
	public void tick() {
		if (deathCharacter) {
			Game.gameState = "TRAVADO";
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index = 4;
					time++;
					if (time >= maxTime) {
						time = 0;
						index = 0;
						deathCharacter = false;
						Game.gameState = "GAME_OVER";
						Game.desligarLigarMusica(Game.CUR_LEVEL);
					}


				}
			}
		}
	}
	
	public void render(Graphics g) {
		if (deathCharacter) {
			g.drawImage(Game.player.rightPlayer[index], Game.player.getX() - Camera.x,Game.player.getY() - Camera.y, null);						
			
		}
	}
	
}