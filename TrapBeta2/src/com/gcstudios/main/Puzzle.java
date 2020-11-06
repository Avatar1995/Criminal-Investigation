package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class Puzzle {

	public boolean valoresNaoPreenchidos, puzzleResolvido = false;
	public int maxValor = 8;
	public int[] valor = new int [8];
	public int time = 0;
	public int maxTime= 100;
	
	public Puzzle() {
		// TODO Auto-generated constructor stub	
		for (int i = 0; i < maxValor;i++) {
			valor[i] = -1;

		}
	}
	
	public void tick() {
		if (Game.CUR_LEVEL == 3) {
			valoresNaoPreenchidos = false;
			for (int i = 0; i < maxValor;i++) {
				if (valor[i] == -1) {
					valoresNaoPreenchidos = true;
					break;
				}
			}
		
			if (!valoresNaoPreenchidos) {			
				if ((valor[0] == 2) &&
					(valor[1] == 5) &&
					(valor[2] == 0) &&
					(valor[3] == 1) &&
					(valor[4] == 2) &&
					(valor[5] == 0) &&
					(valor[6] == 0) &&
					(valor[7] == 0)) {
					this.time++;
					if (this.time >= this.maxTime) {
						this.time = 0;
						puzzleResolvido = true;
						AudioPlayer.playSound(AudioClip.itemSelected,2,0);
						Game.phrases.definirFrases(5);
						Game.phrases.showMessage6 = true;
						Game.phrases.fraseIndex = 0;
						Game.messageNPC = true;
						Game.gameState = "TRAVADO";
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						
						for (int i = 0; i < maxValor;i++) {
							valor[i] = -1; 

						}
					}
				
				} else {
					this.time++;
					if (this.time >= this.maxTime) {
						this.time = 0;
						puzzleResolvido = false;
						AudioPlayer.playSound(AudioClip.itemNaoPermitido,2,0);
						Game.phrases.definirFrases(5);
						Game.phrases.showMessage6 = true;
						Game.phrases.fraseIndex = 0;
						Game.messageNPC = true;
						Game.gameState = "TRAVADO";
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						
						for (int i = 0; i < maxValor;i++) {
							valor[i] = -1; 

						}
					}
				}
			}		
		}

	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 - 90,200,250);
		g.setColor(Color.blue);
		g.fillRect(151, (Game.HEIGHT * Game.SCALE)/2 - 89,198,248);
		
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.setColor(Color.green);
		if (valor[0] != -1)
			g.drawString(String.valueOf(valor[0]),(Game.WIDTH * Game.SCALE) - 290,(Game.HEIGHT * Game.SCALE) - 200);
		
		if (valor[1] != -1)
			g.drawString(String.valueOf(valor[1]),(Game.WIDTH * Game.SCALE) - 280,(Game.HEIGHT * Game.SCALE) - 200);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.green);
		g.drawString("/",(Game.WIDTH * Game.SCALE) - 265,(Game.HEIGHT * Game.SCALE) - 200);
		
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.setColor(Color.green);
		
		if (valor[2] != -1)
			g.drawString(String.valueOf(valor[2]),(Game.WIDTH * Game.SCALE) - 250,(Game.HEIGHT * Game.SCALE) - 200);
		
		if (valor[3] != -1)
			g.drawString(String.valueOf(valor[3]),(Game.WIDTH * Game.SCALE) - 240,(Game.HEIGHT * Game.SCALE) - 200);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.green);
		g.drawString("/",(Game.WIDTH * Game.SCALE) - 225,(Game.HEIGHT * Game.SCALE) - 200);
		
		
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.setColor(Color.green);
		
		if (valor[4] != -1)		
			g.drawString(String.valueOf(valor[4]),(Game.WIDTH * Game.SCALE) - 210,(Game.HEIGHT * Game.SCALE) - 200);
		
		if (valor[5] != -1)	
			g.drawString(String.valueOf(valor[5]),(Game.WIDTH * Game.SCALE) - 200,(Game.HEIGHT * Game.SCALE) - 200);
		
		if (valor[6] != -1)	
			g.drawString(String.valueOf(valor[6]),(Game.WIDTH * Game.SCALE) - 190,(Game.HEIGHT * Game.SCALE) - 200);
			
		if (valor[7] != -1)	
			g.drawString(String.valueOf(valor[7]),(Game.WIDTH * Game.SCALE) - 180,(Game.HEIGHT * Game.SCALE) - 200);
		
		
		
		
		g.setColor(Color.black);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 + 120,200,40);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);
		g.drawString("Digite usando os números do teclado",(Game.HEIGHT * Game.SCALE) - 290,(Game.WIDTH * Game.SCALE) - 120);
		g.drawString("Data formato DD/MM/YYYY",(Game.HEIGHT * Game.SCALE) - 270,(Game.WIDTH * Game.SCALE) - 100);	
	
		g.setColor(Color.black);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 - 90,200,40);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);
		g.drawString("Para sair, pressione J ou digite a data",(Game.HEIGHT * Game.SCALE) - 295,(Game.WIDTH * Game.SCALE) - 320);
		
		
			
	}
	
}
