package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.gcstudios.entities.Entity;



public class Shop {

	public boolean hpCompleto,coleteCompleto, dinheiroIssuficiente, itemJaSelecionado, itemNaoEncontrado, 
	               facaNaoEncontrada, facaEstadoPerfeito, secretNaoObtido = false;
	public int maxValor = 8;
	public int[][] itemVenda = new int [40][4];
	public int time,j, k,l, maxItemsVenda = 0;
	public int maxTime= 100;
	public String[] frase = new String[3];
	public boolean up,down,left,right;
	private int controle = 0;
	public int currentOptionVert = 0;
	public int maxCurrentOptionVert = 2;
	public int currentOptionHor = 0;
	public int maxCurrentOptionHor = 3;
	public int posicaoHor,posicaoHorSelected = -1;
	public int posicaoVert,posicaoVertSelected = -1;
	public static int lifeKnife = 20;
	public static int life = 20;
	public static int shield = 20;
	public static int ammo = 10;
	public static int valor;
	public static int itemBloqueado;
	public static String valorItem;
	public static int descricaoHpColeteFacaMun;

	
	public Shop() {
		// TODO Auto-generated constructor stub	
	}
	
	public void definirFrase(int item) {
		if (item == 6) {
			frase[0]="Pistola: Com munições, essa pistola é útil contra os inimigos.";
			frase[1]="Quando equipada, pressione a tecla J para atirar.";
			frase[2]="A quantidade de munições fica no canto inferior direito da tela.";
		}
		if (item == 7) {
			frase[0]="Faca: Quando equipada, pressione a tecla J para atacar.";
			frase[1]="Lembre - se, a faca pode quebrar então fique atento a sua duração";
			frase[2]="no canto inferior direito da tela.";
		}
		
		if (item == 8) {
			frase[0]="Chave: Serve para abrir algo do cenário.";
			frase[1]="";
			frase[2]="";
		}
		
		if (item == 9) {
			frase[0]="HP: Cura sua saúde em 20%.";
			frase[1]="";
			frase[2]="";
		}
		
		if (item == 10) {
			frase[0]="Colete: Cura sua armadura em 20%.";
			frase[1]="";
			frase[2]="";
		}
		
		if (item == 11) {
			frase[0]="Munição: Serve para recarregar sua arma. Carrega com 10 balas.";
			frase[1]="A quantidade de balas está no canto inferior direito da tela";
			frase[2]="quando sua arma estiver no inventário rápido.";
		}
		
		if (item == 12) {
			frase[0]="Bigorna: Conserta sua faca em 20%.";
			frase[1]="";
			frase[2]="";
		}
		
		if (item == 13) {
			frase[0]="Moeda rara: Obtenha a moeda como prêmio por achar os segredos.";
			frase[1]="";
			frase[2]="";
		}

	}
	
	public int definirPreco(int item) {
		if (item == 6) {
			valor = 80;
		} else
		if (item == 7) {
			valor = 70;
		} else
		
		if (item == 8) {
			valor = 5;
		} else
		
		if (item == 9) {
			valor = 25;
		} else
		
		if (item == 10) {
			valor = 30;
		} else
		
		if (item == 11) {
			valor = 30;
		} 	
		
		if (item == 12) {
			valor = 25;
		}
		
		if (item == 13) {
			valor = 0;
		}
		
		return valor;
	}
	
	
	public void definirShop() {
		j = -1;
		k = -1;
		l = -1;
		maxItemsVenda = 0;
		for (int i = 0; i < Game.itemsPersonagem.maxItemsInventario;i++) {
			if (Game.itemsPersonagem.items[i][3] == 1) {
				j++;
				itemVenda[j][0] = Game.itemsPersonagem.items[i][0];
				itemVenda[j][3] = definirPreco(itemVenda[j][0]);
				if ((j != 0) && (j != 4) && (j != 8)){
					l++;
					itemVenda[j][1] = k;
					itemVenda[j][2] = l;
				} else {
					k++;
					l = 0;
					itemVenda[j][1] = k;
					itemVenda[j][2] = l;
				}
				
				maxItemsVenda++;
				if (maxItemsVenda >= 13)
					break;
			}

		}
		
		if (maxItemsVenda < 14) {
			for (int i = maxItemsVenda;i < 14;i++) {
				itemVenda[i][0] = -1;
				itemVenda[i][1] = -1;
				itemVenda[i][2] = -1;
				itemVenda[i][3] = 0;
				maxItemsVenda = 14;
			
			}
		}
		
		
		
	}
	
	public void tick() {
		if (Game.permissao) {
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
	
	}
	
	public void render(Graphics g) {
		if (Game.permissao) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.fillRect(10, (Game.HEIGHT * Game.SCALE)/2 - 150,345,350);
		g.setColor(Color.yellow);
		g.fillRect(11, (Game.HEIGHT * Game.SCALE)/2 - 149,343,348);
		
		g.setColor(Color.black);
		g.fillRect(11, (Game.HEIGHT * Game.SCALE)/2 - 150,343,60);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);
		g.drawString("Para sair, pressione O.",(Game.HEIGHT * Game.SCALE) - 320,(Game.WIDTH * Game.SCALE) - 380);
		g.drawString("Para comprar, pressione J.",(Game.HEIGHT * Game.SCALE) - 330,(Game.WIDTH * Game.SCALE) - 360);
				
		
		g.setColor(Color.black);
		g.fillRect(11, (Game.HEIGHT * Game.SCALE)/2 + 110,343,90);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.white);		
						
		if (itemNaoEncontrado) {
			g.drawString("Esse espaço está vazio.",(Game.HEIGHT * Game.SCALE) - 330,(Game.WIDTH * Game.SCALE) - 90);
			itemJaSelecionado = false;
			dinheiroIssuficiente = false;
			hpCompleto = false;
			coleteCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			secretNaoObtido = false;
		}
		
		if (secretNaoObtido) {
			g.drawString("Colete os 5 segredos para obter a moeda.",(Game.HEIGHT * Game.SCALE) - 370,(Game.WIDTH * Game.SCALE) - 90);
			itemJaSelecionado = false;
			dinheiroIssuficiente = false;
			hpCompleto = false;
			coleteCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			itemNaoEncontrado = false;
			
			
		}
		
		if (itemJaSelecionado) {
			g.drawString("Esse item já está com você.",(Game.HEIGHT * Game.SCALE) - 350,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			dinheiroIssuficiente = false;
			hpCompleto = false;
			coleteCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			secretNaoObtido = false;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
		} 
		
		if (dinheiroIssuficiente) {
			g.drawString("Você não tem dinheiro o suficiente.",(Game.HEIGHT * Game.SCALE) - 350,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			itemJaSelecionado = false;
			hpCompleto = false;
			coleteCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			secretNaoObtido = false;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
		} 
		
		if (hpCompleto) {
			g.drawString("Seu HP já está completo.",(Game.HEIGHT * Game.SCALE) - 330,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			itemJaSelecionado = false;
			coleteCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			secretNaoObtido = false;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
			descricaoHpColeteFacaMun = 9;
		} 
		
		if (coleteCompleto) {
			g.drawString("Sua armadura já está completa.",(Game.HEIGHT * Game.SCALE) - 350,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			itemJaSelecionado = false;
			hpCompleto = false;
			facaNaoEncontrada = false;
			facaEstadoPerfeito = false;
			secretNaoObtido = false;
			descricaoHpColeteFacaMun = 10;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
		}
		
		if (facaEstadoPerfeito) {
			g.drawString("A faca já está consertada.",(Game.HEIGHT * Game.SCALE) - 330,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			itemJaSelecionado = false;
			hpCompleto = false;
			facaNaoEncontrada = false;
			coleteCompleto = false;
			secretNaoObtido = false;
			descricaoHpColeteFacaMun = 12;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
		}
		
		if (facaNaoEncontrada) {
			g.drawString("Não existe faca para consertar.",(Game.HEIGHT * Game.SCALE) - 350,(Game.WIDTH * Game.SCALE) - 90);
			itemNaoEncontrado = false;
			itemJaSelecionado = false;
			hpCompleto = false;
			facaEstadoPerfeito = false;
			coleteCompleto = false;
			secretNaoObtido = false;
			descricaoHpColeteFacaMun = 12;
			valorItem = Integer.toString(itemBloqueado) + " Coins";
		}
		
		for (int i = 0; i < maxItemsVenda;i++) {
			if ((itemVenda[i][1] == currentOptionVert) &&
				(itemVenda[i][2] == currentOptionHor)) {
				if ((posicaoHorSelected != currentOptionHor) || (posicaoVertSelected != currentOptionVert)) {
					itemJaSelecionado = false;
					dinheiroIssuficiente = false;
					hpCompleto = false;
					coleteCompleto = false;
					facaNaoEncontrada = false;
					facaEstadoPerfeito = false;
					secretNaoObtido = false;
					posicaoHorSelected = -1;
					posicaoVertSelected = -1;
					definirFrase(itemVenda[i][0]);
					descricaoHpColeteFacaMun = itemVenda[i][0];
					valorItem = Integer.toString(itemVenda[i][3]) + " Coins";
					g.drawString(frase[0],(Game.HEIGHT * Game.SCALE) - 430,(Game.WIDTH * Game.SCALE) - 110);
					g.drawString(frase[1],(Game.HEIGHT * Game.SCALE) - 430,(Game.WIDTH * Game.SCALE) - 90);
					g.drawString(frase[2],(Game.HEIGHT * Game.SCALE) - 430,(Game.WIDTH * Game.SCALE) - 70);
					itemNaoEncontrado = false;
					break;
				}
				
			} else
				if ((itemVenda[i][1] == -1) && (itemVenda[i][2] == -1) && ((posicaoHorSelected != currentOptionHor) || (posicaoVertSelected != currentOptionVert))) {
					valorItem = "0 Coins";
					descricaoHpColeteFacaMun = 0;
				}
			
		} 
			
		
		

					
				
		
		g.setColor(Color.yellow);
		g.fillRect(360, (Game.HEIGHT * Game.SCALE)/2 - 150,100,350);
		
		int x = -1;
		int y = -1;
		for (int i = 0; i < maxItemsVenda;i++) {

			if (itemVenda[i][0] == -1)
				break;
			
			if ((i != 0) && (i != 4) && (i != 8)){
				
					x++;
			} else {
					y++;
					x = 0;
					
			}
			
			g.drawImage(Entity.itemsPersonagem[itemVenda[i][0]][1],50 + (x * 80),150 + (y * 70), null);	
			g.setFont(new Font("Arial",Font.BOLD,13));
			g.setColor(Color.green);
			g.drawString(valorItem, 385, 250);

		}
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.black);
		if((currentOptionVert == 0) && (currentOptionHor == 0)) {
			g.drawString(">", 20, 160);
		} else
		if((currentOptionVert == 0) && (currentOptionHor == 1)) {
			g.drawString(">", 100, 160);
		} else
		if((currentOptionVert == 0) && (currentOptionHor == 2)) {
			g.drawString(">", 180, 160);
		} else
		if((currentOptionVert == 0) && (currentOptionHor == 3)) {
			g.drawString(">", 260, 160);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 0)) {
			g.drawString(">", 20, 230);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 1)) {
			g.drawString(">", 100, 230);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 2)) {
			g.drawString(">", 180, 230);
		} else
		if((currentOptionVert == 1) && (currentOptionHor == 3)) {
			g.drawString(">", 260, 230);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 0)) {
			g.drawString(">", 20, 300);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 1)) {
			g.drawString(">", 100, 300);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 2)) {
			g.drawString(">", 180, 300);
		} else
		if((currentOptionVert == 2) && (currentOptionHor == 3)) {
			g.drawString(">", 260, 300);
		}  
			
		g.setFont(new Font("Arial",Font.BOLD,13));
		g.setColor(Color.black);
		g.drawString("Dinheiro Atual",365,150);
		
		g.setFont(new Font("Arial",Font.BOLD,13));
		g.setColor(Color.green);
		g.drawString(Integer.toString(Game.player.coin) +  " Coins",385,180);
		
		g.setFont(new Font("Arial",Font.BOLD,13));
		g.setColor(Color.black);
		g.drawString("Preço",390,220);
		
		
		if (descricaoHpColeteFacaMun == 9) {
			
			g.setFont(new Font("Arial",Font.BOLD,13));
			g.setColor(Color.black);
			g.drawString("HP Atual",385,290);
			g.setColor(Color.green);
			String resultado = String.format("%.2f",Game.player.life);
			g.drawString(resultado + "%",390,320);
			
			
		} else
			
			if (descricaoHpColeteFacaMun == 10) {
				
				g.setFont(new Font("Arial",Font.BOLD,13));
				g.setColor(Color.black);
				g.drawString("Colete Atual",370,290);
				g.setColor(Color.green);
				g.drawString(Integer.toString(Game.player.shield) + "%",398,320);
				
				
			} else
				if (descricaoHpColeteFacaMun == 11) {
					
					g.setFont(new Font("Arial",Font.BOLD,13));
					g.setColor(Color.black);
					g.drawString("Munição Atual",365,290);
					g.setColor(Color.green);
					g.drawString(Integer.toString(Game.player.ammo),398,320);
					
					
				} 
				if (descricaoHpColeteFacaMun == 12) {
					
					g.setFont(new Font("Arial",Font.BOLD,13));
					g.setColor(Color.black);
					g.drawString("Faca Atual",380,290);
					g.setColor(Color.green);
					String resultado2 = String.format("%.2f",Game.player.lifeKnife);
					g.drawString(resultado2 + "%",390,320);
					
					
				}
		
		
		
		
			
	} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,30));				
		g.drawString("Loading", (Game.WIDTH*Game.SCALE) / 2 - 55 , (Game.HEIGHT*Game.SCALE) / 2);
	}
	}
	
}