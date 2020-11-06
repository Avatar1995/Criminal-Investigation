package com.gcstudios.entities;



import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class ItemsPersonagem {
	public static int[][] items = new int[40][4];
	public int[][] itemsOrigLevel = new int[40][4];
	public int maxItemsInventario = 14;
	
	public ItemsPersonagem() {
		// o primeiro array é a numeração do item
		//OBS: O segundo array verifica se o item ta com o personagem
		// o terceiro array verifica se é item para ta no menu de itens
		//o quarto array verifica se é item para ta para venda
		
		//Guarda - Chuva
		items[0][0] = 0;
		items[0][1] = 0;
		items[0][2] = 1;
		items[0][3] = 0;
		
		//Monoculo
		items[1][0] = 1;
		items[1][1] = 0;
		items[1][2] = 1;
		items[1][3] = 0;
		
		//Chave prata
		items[2][0] = 2;
		items[2][1] = 0;
		items[2][2] = 1;
		items[2][3] = 0;
		
		//Chave dourada
		items[3][0] = 3;
		items[3][1] = 0;
		items[3][2] = 1;
		items[3][3] = 0;
		
		//Papel enigma
		items[4][0] = 4;
		items[4][1] = 0;
		items[4][2] = 1;
		items[4][3] = 0;
		
		//Diário
		items[5][0] = 5;
		items[5][1] = 0;
		items[5][2] = 1;
		items[5][3] = 0;
		
		//arma
		items[6][0] = 6;
		items[6][1] = 0;
		items[6][2] = 1;
		items[6][3] = 1;
		
		//faca
		items[7][0] = 7;
		items[7][1] = 0;
		items[7][2] = 1;
		items[7][3] = 1;
		
		//chave secret
		items[8][0] = 8;
		items[8][1] = 0;
		items[8][2] = 1;
		items[8][3] = 1;
		
		//HP
		items[9][0] = 9;
		items[9][1] = 0;
		items[9][2] = 0;
		items[9][3] = 1;
		
		//Colete
		items[10][0] = 10;
		items[10][1] = 0;
		items[10][2] = 0;
		items[10][3] = 1;
		
		//Munição
		items[11][0] = 11;
		items[11][1] = 0;
		items[11][2] = 0;
		items[11][3] = 1;
		
		//Ajuste facas
		items[12][0] = 12;
		items[12][1] = 0;
		items[12][2] = 0;
		items[12][3] = 1;	
		
		//Moeda Rara
		items[13][0] = 13;
		items[13][1] = 0;
		items[13][2] = 0;
		items[13][3] = 0;	
	
	}

	

	public void tick() {
		
	}

	public void render(Graphics g) {
		//g.drawImage(itemsSprite, this.getX() - Camera.x,this.getY() - Camera.y, null);		
		
	}

}