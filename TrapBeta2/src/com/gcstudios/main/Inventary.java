package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.gcstudios.entities.Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Inventary {

	public boolean valoresNaoPreenchidos, puzzleResolvido, itemJaSelecionado, itemNaoEncontrado = false;
	public int maxValor = 8;
	public int[][] itemInventario = new int [40][3];
	public int time,j, k, maxItemsInventario = 0;
	public int maxTime= 100;
	public String frase;
	public boolean up,down,left,right;
	private int controle = 0;
	public int currentOptionVert = 0;
	public int maxCurrentOptionVert = 3;
	public int currentOptionHor = 0;
	public int maxCurrentOptionHor = 1;
	public int posicaoHor,posicaoHorSelected = -1;
	public int posicaoVert,posicaoVertSelected = -1;
	
	public Inventary() {
		// TODO Auto-generated constructor stub	
	}
	
	public String definirFrase(int item) {
		//Guarda - Chuva
		if (item == 0) {
			frase="Guarda - chuva.";
		}
		if (item == 1) {
			frase="Monóculo para investigar pistas.";
		}
		
		if (item == 2) {
			frase="Chave prata.";
		}
		
		if (item == 3) {
			frase="Chave dourada.";
		}
		
		if (item == 4) {
			frase="Papel com algumas anotações.";
		}
		
		if (item == 5) {
			frase="Diário com algumas informações.";
		}
		
		if (item == 6) {
			frase="Pistola.";
		}
		if (item == 7) {
			frase="Faca.";
		}
		
		return frase;
	}
	
	
	public void definirInventario() {
		j = -1;
		k = -1;
		maxItemsInventario = 0;
		for (int i = 0; i < Game.itemsPersonagem.maxItemsInventario;i++) {
			if ((Game.itemsPersonagem.items[i][1] == 1) &&  (Game.itemsPersonagem.items[i][2] == 1)) {
				j++;
				itemInventario[j][0] = Game.itemsPersonagem.items[i][0];
				if (j % 2 != 0) {
					itemInventario[j][1] = k;
					itemInventario[j][2] = 1;
				} else {
					k++;
					itemInventario[j][1] = k;
					itemInventario[j][2] = 0;
				}
				
				maxItemsInventario++;
				if (maxItemsInventario >= 8)
					break;
			}

		}
		
		if (maxItemsInventario < 8) {
			for (int i = maxItemsInventario;i < 9;i++) {
				itemInventario[i][0] = -1;
				itemInventario[i][1] = -1;
				itemInventario[i][2] = -1;
				maxItemsInventario = 8;
			
			}
		}
		
		
		
	}
	
	public void tick() {
		if(up) {
			up = false;
			currentOptionVert--;
			if(currentOptionVert < 0)
				currentOptionVert = maxCurrentOptionVert;
		}
		if(down) {
			down = false;
			currentOptionVert++;
			if(currentOptionVert > maxCurrentOptionVert)
				currentOptionVert = 0;
		}
		
		if(left) {
			left = false;
			currentOptionHor--;
			if(currentOptionHor < 0)
				currentOptionHor = maxCurrentOptionHor;
		}
		if(right) {
			right = false;
			currentOptionHor++;
			if(currentOptionHor > maxCurrentOptionHor)
				currentOptionHor = 0;
		}
	
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 - 150,200,350);
		g.setColor(Color.red);
		g.fillRect(151, (Game.HEIGHT * Game.SCALE)/2 - 149,198,348);
		
		g.setColor(Color.black);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 - 150,200,40);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);
		g.drawString("Para sair, pressione O.",(Game.HEIGHT * Game.SCALE) - 255,(Game.WIDTH * Game.SCALE) - 380);
				
		
		g.setColor(Color.black);
		g.fillRect(150, (Game.HEIGHT * Game.SCALE)/2 + 160,200,40);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);		
				
		if (itemNaoEncontrado) {
			g.drawString("Esse espaço está vazio.",(Game.HEIGHT * Game.SCALE) - 295,(Game.WIDTH * Game.SCALE) - 70);
			itemJaSelecionado = false;
		}
		
		if (itemJaSelecionado) {
			g.drawString("Esse item já está selecionado.",(Game.HEIGHT * Game.SCALE) - 295,(Game.WIDTH * Game.SCALE) - 70);
			itemNaoEncontrado = false;
		} 
		
		for (int i = 0; i < maxItemsInventario;i++) {
			if ((itemInventario[i][1] == currentOptionVert) &&
				(itemInventario[i][2] == currentOptionHor)) {
				if ((posicaoHorSelected != currentOptionHor) || (posicaoVertSelected != currentOptionVert)) {
					
					itemJaSelecionado = false;
					posicaoHorSelected = -1;
					posicaoVertSelected = -1;
					frase = definirFrase(itemInventario[i][0]);
					g.drawString(frase,(Game.HEIGHT * Game.SCALE) - 295,(Game.WIDTH * Game.SCALE) - 70);
					
				}
				
				itemNaoEncontrado = false;
				break;
				
			}
		}
		
		

					
				
		
		g.setColor(Color.red);
		g.fillRect(360, (Game.HEIGHT * Game.SCALE)/2 - 150,100,350);
		
		int x = 0;
		int y = -1;
		for (int i = 0; i < maxItemsInventario;i++) {

			if (itemInventario[i][0] == -1)
				break;
			
			if (i % 2 != 0) {
					x = 1;
			} else {
					y++;
					x = 0;
			}
			
			g.drawImage(Entity.itemsPersonagem[itemInventario[i][0]][1], 175 + (x * 115),140 + (y * 70), null);	
	
		}
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.white);
		if((currentOptionVert == 0) && (currentOptionHor == 0)) {
			g.drawString(">", 160, 160);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 0)) {
			g.drawString(">", 160, 230);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 0)) {
			g.drawString(">", 160, 300);
		} else
		if((currentOptionVert == 3) && (currentOptionHor == 0)) {
			g.drawString(">", 160, 370);
		} else
		if((currentOptionVert == 0) && (currentOptionHor == 1)) {
			g.drawString(">", 260, 160);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 1)) {
			g.drawString(">", 260, 230);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 1)) {
			g.drawString(">", 260, 300);
		} else
		if((currentOptionVert == 3) && (currentOptionHor == 1)) {
			g.drawString(">", 260, 370);
		}
		
		if (Game.player.itemEsquerda != -1) {
			g.drawImage(Entity.itemsPersonagem[Game.player.itemEsquerda][1], 395,170, null);	
		}
		
		if (Game.player.itemDireita != -1) {
			g.drawImage(Entity.itemsPersonagem[Game.player.itemDireita][1], 395,320, null);	
		}
		g.setFont(new Font("Arial",Font.BOLD,12));
		g.setColor(Color.green);
		g.drawString("Tecla I.",390,290);
		g.drawString("Tecla U.",387,140);
		g.setFont(new Font("Arial",Font.BOLD,15));
		g.setColor(Color.white);
		g.drawString("Esquerda",375,220);
		g.drawString("Direita",385,370);
		
		
		
			
	}
	
}