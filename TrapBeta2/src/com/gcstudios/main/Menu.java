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

public class Menu {

	public int currentOption = 0;
	private Boolean trovaoPermitido = false;
	public int maxOption = 1;
	private int time = 0, maxTime = 400;
	public boolean up,down,enter;
	private BufferedImage[] menu;
	public boolean pause = false;
	public static boolean controle = true;
	

	public Menu() {

		menu = new BufferedImage[4];
		
		menu[0] = Game.spritesheet.getSprite(0, 1528, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		menu[1] = Game.spritesheet.getSprite(0, 1980, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		menu[2] = Game.spritesheet.getSprite(0, 2429, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		menu[3] = Game.spritesheet.getSprite(0, 2881, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
	}

	
	public void tick() {
		if (controle) {
			AudioPlayer.playLoopSound(AudioClip.menu,1.5,1);
			controle = false;
		}
	if (Game.permissao) {
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
		
		time++;
		if (time > maxTime) {
			if (trovaoPermitido) {
				trovaoPermitido = false;
				maxTime = 400;
			} else {
				trovaoPermitido = true;
				maxTime = 115;
				AudioPlayer.playSound(AudioClip.trovao,1.5,0);
			}
			time = 0;
		}
		
		
		
		if(enter) {
			if(currentOption == 0) {
				Game.load.chamaCarregamento = true;
				Game.load.fimCarregamento = false;
				Game.gameState = "NORMAL";
				Game.estado_cena = Game.cutScene;
				Game.cutscenes.numero = 1;
				Game.primeiroLoad = true;
				Game.permissao = false;
				AudioPlayer.stopLoopSound();
				AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);
				Game.permissao = false;
				Game.player.lifeOriginalLevel = Game.player.life;
				Game.player.coinOriginalLevel = Game.player.coin;
				Game.player.lifeKnifeOriginalLevel = Game.player.lifeKnife;
				Game.player.itemDireitaOriginal = Game.player.itemDireita;
				Game.player.itemEsquerdaOriginal = Game.player.itemEsquerda;
				Game.player.itemDireitaSelecionadoOriginal = Game.player.itemDireitaSelecionado;
				Game.player.itemEsquerdaSelecionadoOriginal = Game.player.itemEsquerdaSelecionado;
				Game.player.shieldOriginalLevel = Game.player.shield;
				Game.player.ammoOriginalLevel = Game.player.ammo;
				Game.segredo1EncontradoOriginalLevel  = Game.segredo1Encontrado;
				Game.segredo2EncontradoOriginalLevel  = Game.segredo2Encontrado;
				Game.segredo3EncontradoOriginalLevel  = Game.segredo3Encontrado;
				Game.segredo4EncontradoOriginalLevel  = Game.segredo4Encontrado;
				
				for(int i = 0; i < Game.itemsPersonagem.maxItemsInventario; i++) {
					for(int j = 0; j < 4; j++) {
						Game.itemsPersonagem.itemsOrigLevel[i][j] = Game.itemsPersonagem.items[i][j];
					}
				}
				
				Camera.definirCameraInicio();
			}else if(currentOption == 1) {
				System.exit(1);
			}
			enter = false;
		}
	}

	}
	
	public void render(Graphics g) {
		if (Game.permissao) {
			if (currentOption == 0) {
					if (!trovaoPermitido)
						g.drawImage(menu[0], 0,0, null);
					else
						g.drawImage(menu[2], 0,0, null);
			}
			if (currentOption == 1) {
				if (!trovaoPermitido)
					g.drawImage(menu[1], 0,0, null);
				else
					g.drawImage(menu[3], 0,0, null);
			}
			
			g.setColor(Color.blue);
			g.fillRect(5, 3,95,17);
			g.setFont(new Font("arial",Font.BOLD,11));
			g.setColor(Color.white);
			g.drawString("Tecla M - Manual",7,16);
			
			
		} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,30));				
		g.drawString("Loading", (Game.WIDTH*Game.SCALE) / 2 - 55 , (Game.HEIGHT*Game.SCALE) / 2);
		
		}
	}
	
}