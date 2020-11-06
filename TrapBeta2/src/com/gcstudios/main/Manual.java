package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gcstudios.entities.Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Manual {

	public boolean left,right;
	public int currentOption,k = 0;
	public int maxCurrentOption = 9;
	public static BufferedImage[] personagem;
	public static BufferedImage[] dica;
	public static BufferedImage[] segredos;
	public static BufferedImage[] coin;
	public Manual() {
		personagem = new BufferedImage[9];	
		dica = new BufferedImage[3];
		segredos = new BufferedImage[5];
		coin = new BufferedImage[1];
		for (int i = 0;i < 9;i++) {
			if (i > 5) {
				personagem[i] = Game.spritesheet.getSprite(109 + (k * 17), 31, 16, 30);
				k++;
			} else
				personagem[i] = Game.spritesheet.getSprite(109 + (i * 17), 0, 16, 30);
			
			
		}
		
		for (int i = 0;i < 3;i++) {
			dica[i] = Game.spritesheet.getSprite(172 + (i * 10), 31, 9, 29);			
			
		}
		segredos[0] = Game.spritesheet.getSprite(109, 62, 18, 20);
		segredos[1] = Game.spritesheet.getSprite(128, 62, 15, 15);
		segredos[2] = Game.spritesheet.getSprite(144, 62, 12, 25);
		segredos[3] = Game.spritesheet.getSprite(157, 62, 15, 23);
		segredos[4] = Game.spritesheet.getSprite(173, 62, 16, 11);
		
		coin[0] = Game.spritesheet.getSprite(0, 1508, 18, 18);
	}
	
	public void tick() {
		if(left) {
			left = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxCurrentOption;
		}
		if(right) {
			right = false;
			currentOption++;
			if(currentOption > maxCurrentOption)
				currentOption = 0;
		}
	
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.blue);
		g.fillRect(0, 0,(Game.WIDTH * Game.SCALE),(Game.HEIGHT * Game.SCALE));
		g.setFont(new Font("Arial",Font.BOLD,15));
		g.setColor(Color.white);
		g.drawString("P�gina " + (currentOption + 1) + "/" + (maxCurrentOption + 1),5,(Game.HEIGHT * Game.SCALE) - 430);
		g.drawString("Pressione M para sair." ,(Game.WIDTH * Game.SCALE) - 160,(Game.HEIGHT * Game.SCALE) - 430);
		
		if (currentOption == 0) {
			g.setFont(new Font("Arial",Font.BOLD,12));
			g.setColor(Color.white);
			g.drawString("HIST�RIA",((Game.WIDTH * Game.SCALE)/2) - 30,(Game.HEIGHT * Game.SCALE) - 400);
			g.setFont(new Font("Arial",Font.BOLD,10));
			g.drawString("- Leon Scott, 20 anos, um jovem cheio de energia, com um objetivo bem claro, se tornar um",5,(Game.HEIGHT * Game.SCALE) - 380);
			g.drawString("s�mbolo no departamento de investiga��o, como foi com o detetive mais famoso da cidade,",5,(Game.HEIGHT * Game.SCALE) - 365);
			g.drawString("Chris Stone, que desapareceu misteriosamente h� um ano quando investigava o famoso caso",5,(Game.HEIGHT * Game.SCALE) - 350);
			g.drawString("\"Supreme\".",5,(Game.HEIGHT * Game.SCALE) - 335);
			
			g2.setColor(Color.BLACK);
			g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 325, Game.WIDTH*Game.SCALE, 5);
			
			g.setFont(new Font("Arial",Font.BOLD,12));
			g.setColor(Color.white);
			g.drawString("BOT�ES",((Game.WIDTH * Game.SCALE)/2) - 30,(Game.HEIGHT * Game.SCALE) - 300);
			g.setFont(new Font("Arial",Font.BOLD,10));
			g.drawString("- Setas e teclas W,A,S,D: Movimentam o personagem, al�m de ser o cursor no menu, pause,",5,(Game.HEIGHT * Game.SCALE) - 280);
			g.drawString("invent�rio, manual e no sistema de compra.",5,(Game.HEIGHT * Game.SCALE) - 265);
			g.drawString("- Tecla U: Seleciona ou fornece uma dica do item da esquerda no invent�rio r�pido.",5,(Game.HEIGHT * Game.SCALE) - 245);
			g.drawString("- Tecla I: Seleciona ou fornece uma dica do item da direita no invent�rio r�pido.",5,(Game.HEIGHT * Game.SCALE) - 225);
			g.drawString("- Tecla O: Entra no invent�rio.",5,(Game.HEIGHT * Game.SCALE) - 205);
			g.drawString("- Tecla J: Bot�o de intera��o com objetos e personagens, al�m de realizar uma a��o em",5,(Game.HEIGHT * Game.SCALE) - 185);
			g.drawString("determinados itens do invent�rio.Serve tamb�m para avan�ar o di�logo.",5,(Game.HEIGHT * Game.SCALE) - 170);
			g.drawString("- Tecla K: Pula os di�logos com os personagens.",5,(Game.HEIGHT * Game.SCALE) - 150);
			g.drawString("- Tecla M: Acessa o manual do jogo.",5,(Game.HEIGHT * Game.SCALE) - 130);
			g.drawString("- Tecla ENTER: Tecla de intera��o quando se est� no menu, pause ou game over do jogo.",5,(Game.HEIGHT * Game.SCALE) - 110);
			g.drawString("Se estiver jogando pelos cen�rios, pressione a tecla para entrar no pause.",5,(Game.HEIGHT * Game.SCALE) - 95);
		} else
			if (currentOption == 1) {
				g.setFont(new Font("Arial",Font.BOLD,12));
				g.setColor(Color.white);
				g.drawString("PERSONAGENS",((Game.WIDTH * Game.SCALE)/2) - 40,(Game.HEIGHT * Game.SCALE) - 400);
				g.setFont(new Font("Arial",Font.BOLD,10));
				g.drawImage(personagem[0], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
				g.drawString("- O protagonista da hist�ria, Leon, 20 anos, � o qu� definimos como prod�gio. Devido ao seu",5,(Game.HEIGHT * Game.SCALE) - 335);
				g.drawString("destaque na faculdade de investiga��o, ele acabou se formando um ano mais cedo que os",5,(Game.HEIGHT * Game.SCALE) - 320);
				g.drawString("demais e foi recomendado pelos professores ao departamento que est�, o seu sonho, pois um",5,(Game.HEIGHT * Game.SCALE) - 305);
				g.drawString("de seus �dolos, Chris Stone, trabalhava l�. Alguns meses antes de Leon entrar no departamento,",5,(Game.HEIGHT * Game.SCALE) - 290);
				g.drawString("Chris desapareceu e Leon jurou se esfor�ar ao m�ximo para ser t�o bom quanto ele.",5,(Game.HEIGHT * Game.SCALE) - 275);
				
				g2.setColor(Color.BLACK);
				g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 265, Game.WIDTH*Game.SCALE, 5);
				g.setColor(Color.white);
				g.drawImage(personagem[1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 250, null);
				g.drawString("- Conhecido como mestre da justi�a, Robert guiou gera��es na pol�cia com sua experi�ncia para",5,(Game.HEIGHT * Game.SCALE) - 205);
				g.drawString("o combate ao crime. Era uma pessoa bem otimista e alegre at� a morte de seu filho h� cinco",5,(Game.HEIGHT * Game.SCALE) - 190);
				g.drawString("anos por um bandido que ele mesmo havia prendido. Desde ent�o, Robert se habilita para casos",5,(Game.HEIGHT * Game.SCALE) - 175);
				g.drawString("menores e assim que conheceu Leon e Steve, se tornando uma esp�cie de mentor deles.",5,(Game.HEIGHT * Game.SCALE) - 160);
				
				g2.setColor(Color.BLACK);
				g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 150, Game.WIDTH*Game.SCALE, 5);
				g.setColor(Color.white);
				g.drawImage(personagem[2], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 135, null);
				g.drawString("- Capit�o do departamento de investiga��o a mais de dez anos, Ikena se formou em direito em",5,(Game.HEIGHT * Game.SCALE) - 90);
				g.drawString("Havard e se tornou capit�o ap�s descobrir o esquema de corrup��o de seu antecessor.",5,(Game.HEIGHT * Game.SCALE) - 75);
				g.drawString("Sua coragem e determina��o s�o inspira��es para todos os seus subordinados, ainda mais",5,(Game.HEIGHT * Game.SCALE) - 60);
				g.drawString("para Leon.",5,(Game.HEIGHT * Game.SCALE) - 45);
				
			} else
				if (currentOption == 2) {
					g.setFont(new Font("Arial",Font.BOLD,12));
					g.setColor(Color.white);
					g.drawString("PERSONAGENS",((Game.WIDTH * Game.SCALE)/2) - 40,(Game.HEIGHT * Game.SCALE) - 400);
					g.setFont(new Font("Arial",Font.BOLD,10));
					g.drawImage(personagem[3], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
					g.drawString("- Jovem de 26 anos, James � uma pessoa que apesar das dificuldades do dia - a - dia, leva elas",5,(Game.HEIGHT * Game.SCALE) - 335);
					g.drawString("com muito bom humor e dedica��o. Ele entrou no departamento no mesmo dia que Leon e foi",5,(Game.HEIGHT * Game.SCALE) - 320);
					g.drawString("sua primeira amizade no local de trabalho.",5,(Game.HEIGHT * Game.SCALE) - 305);
					
					g2.setColor(Color.BLACK);
					g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 295, Game.WIDTH*Game.SCALE, 5);
					g.setColor(Color.white);
					g.drawImage(personagem[4], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 280, null);
					g.drawString("- � uma pessoa que todos querem ter por perto. John motiva todos a sua volta e consegue ser",5,(Game.HEIGHT * Game.SCALE) - 235);
					g.drawString("um �timo analista. Leon sempre o consultava em seus primeiros meses pois gosta de suas",5,(Game.HEIGHT * Game.SCALE) - 220);
					g.drawString("opini�es diferente das dos demais.",5,(Game.HEIGHT * Game.SCALE) - 205);
					
					g2.setColor(Color.BLACK);
					g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 195, Game.WIDTH*Game.SCALE, 5);
					g.setColor(Color.white);
					g.drawImage(personagem[5], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 170, null);
					g.drawString("- O louco por armas, ele n�o tem medo de admitir que as adora e se pudesse, casava com uma.",5,(Game.HEIGHT * Game.SCALE) - 125);
					g.drawString("Aurelio sempre se habilida para casos com poss�veis assassinos s� para ter uma desculpa em",5,(Game.HEIGHT * Game.SCALE) - 110);
					g.drawString("se envolver em um tiroteio. H� alguns anos, ele foi suspendido por conta de exagerar em uma",5,(Game.HEIGHT * Game.SCALE) - 95);
					g.drawString("miss�o. Leon se pergunta at� hoje o qu� foi que ele fez nesse dia.",5,(Game.HEIGHT * Game.SCALE) - 80);
					
				} else
					if (currentOption == 3) {
						g.setFont(new Font("Arial",Font.BOLD,12));
						g.setColor(Color.white);
						g.drawString("PERSONAGENS",((Game.WIDTH * Game.SCALE)/2) - 40,(Game.HEIGHT * Game.SCALE) - 400);
						g.setFont(new Font("Arial",Font.BOLD,10));
						g.drawImage(personagem[6], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
						g.drawString("- A detetive modelo, como ela mesmo se define. Bonita e sedutora, Chloe entrou no",5,(Game.HEIGHT * Game.SCALE) - 335);
						g.drawString("departamento h� tr�s anos. Teve um grande destaque no caso \"Fl�rida\" quando teve que se",5,(Game.HEIGHT * Game.SCALE) - 320);
						g.drawString("disfar�ar para obter informa��es de um grande traficante. Pela sua personalidade, Leon acaba",5,(Game.HEIGHT * Game.SCALE) - 305);
						g.drawString("sempre ficando sem gra�a com seus coment�rios.",5,(Game.HEIGHT * Game.SCALE) - 290);
						
						g2.setColor(Color.BLACK);
						g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 275, Game.WIDTH*Game.SCALE, 5);
						g.setColor(Color.white);
						g.drawImage(personagem[7], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 265, null);
						g.drawString("- A secret�ria do departamento, Anne � uma garota t�mida que est� cursando o curso de",5,(Game.HEIGHT * Game.SCALE) - 220);
						g.drawString("secretariado. Estagi�ria h� quatro meses, ela se esfor�a bastante para mostrar servi�o.",5,(Game.HEIGHT * Game.SCALE) - 205);
						g.drawString("Anne tem a mesma idade do Leon e sempre se deu bem com ele. Leon suspeita que ela possa",5,(Game.HEIGHT * Game.SCALE) - 190);
						g.drawString("estar interessado nele de outra forma al�m da amizade.",5,(Game.HEIGHT * Game.SCALE) - 175);
						
						
						g2.setColor(Color.BLACK);
						g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 165, Game.WIDTH*Game.SCALE, 5);
						g.setColor(Color.white);
						g.drawImage(personagem[8], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 155, null);
						g.drawString("- O homem abaixo do Capit�o, o Sargento Steve � o respons�vel por treinar todos os recrutas.",5,(Game.HEIGHT * Game.SCALE) - 110);
						g.drawString("Nutrido de uma personalidade completa de um l�der, todos possuem uma facilidade em executar",5,(Game.HEIGHT * Game.SCALE) - 95);
						g.drawString("o trabalho gra�as a ele. Leon o admira por completo e sempre presta muita aten��o em seus",5,(Game.HEIGHT * Game.SCALE) - 80);
						g.drawString("ensinamentos.",5,(Game.HEIGHT * Game.SCALE) - 65);
						
					} else
						if (currentOption == 4) {
							g.setFont(new Font("Arial",Font.BOLD,12));
							g.setColor(Color.white);
							g.drawString("ITENS",((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 400);
							g.setFont(new Font("Arial",Font.BOLD,10));
							g.drawImage(Entity.itemsPersonagem[0][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
							g.drawString("- Guarda - Chuva para se proteger de tempestades. Se n�o equipado na chuva, perde - se HP.",5,(Game.HEIGHT * Game.SCALE) - 330);
							
							g2.setColor(Color.BLACK);
							g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 320, Game.WIDTH*Game.SCALE, 5);
							g.setColor(Color.white);
							g.drawImage(Entity.itemsPersonagem[1][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 310, null);
							g.drawString("- Mon�culo para auxiliar no descobrimento de pistas e segredos do jogo. Pode ser equipado.",5,(Game.HEIGHT * Game.SCALE) - 260);
							
							g2.setColor(Color.BLACK);
							g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 255, Game.WIDTH*Game.SCALE, 5);
							g.setColor(Color.white);
							g.drawImage(Entity.itemsPersonagem[2][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 245, null);
							g.drawString("- Chave prata com objetivo de abrir portas, gavetas ou arm�rios. N�o pode ser equipada mas",5,(Game.HEIGHT * Game.SCALE) - 195);
							g.drawString("deve estar no invent�rio r�pido para ser usada.",5,(Game.HEIGHT * Game.SCALE) - 180);
							
							g2.setColor(Color.BLACK);
							g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 170, Game.WIDTH*Game.SCALE, 5);
							g.setColor(Color.white);
							g.drawImage(Entity.itemsPersonagem[3][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 160, null);
							g.drawString("- Chave dourada com objetivo de abrir portas, gavetas ou arm�rios. N�o pode ser equipada mas",5,(Game.HEIGHT * Game.SCALE) - 110);
							g.drawString("deve estar no invent�rio r�pido para ser usada.",5,(Game.HEIGHT * Game.SCALE) - 95);
							
							g2.setColor(Color.BLACK);
							g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 85, Game.WIDTH*Game.SCALE, 5);
							g.setColor(Color.white);
							g.drawImage(Entity.itemsPersonagem[4][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 75, null);
							g.drawString("- Papel com anota��es da v�tima na cena do crime. Cont�m pistas para a resolu��o do caso.",5,(Game.HEIGHT * Game.SCALE) - 25);						
							g.drawString("N�o pode ser equipado mas deve estar no invent�rio r�pido para demonstrar sua descri��o.",5,(Game.HEIGHT * Game.SCALE) - 10);
						} else
							if (currentOption == 5) {
								g.setFont(new Font("Arial",Font.BOLD,12));
								g.setColor(Color.white);
								g.drawString("ITENS",((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 400);
								g.setFont(new Font("Arial",Font.BOLD,10));
								g.drawImage(Entity.itemsPersonagem[5][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
								g.drawString("- Di�rio com anota��es da v�tima na cena do crime. Cont�m pistas para a resolu��o do caso.",5,(Game.HEIGHT * Game.SCALE) - 330);
								g.drawString("N�o pode ser equipado mas deve estar no invent�rio r�pido para demonstrar sua descri��o.",5,(Game.HEIGHT * Game.SCALE) - 315);
								
								g2.setColor(Color.BLACK);
								g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 305, Game.WIDTH*Game.SCALE, 5);
								g.setColor(Color.white);
								g.drawImage(Entity.itemsPersonagem[6][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 295, null);
								g.drawString("- Arma para o personagem utilizar. Pode ser equipada e serve para derrotar os inimigos.",5,(Game.HEIGHT * Game.SCALE) - 245);
								g.drawString("Para utiliz� - la, obtenha muni��es para carreg� - la.",5,(Game.HEIGHT * Game.SCALE) - 230);
								g2.setColor(Color.BLACK);
								g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 220, Game.WIDTH*Game.SCALE, 5);
								g.setColor(Color.white);
								g.drawImage(Entity.itemsPersonagem[7][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 210, null);
								g.drawString("- Faca para o personagem utilizar. Pode ser equipada e serve para derrotar os inimigos.",5,(Game.HEIGHT * Game.SCALE) - 160);
								g.drawString("Para utiliz� - la, verifique se ela n�o est� quebrada.",5,(Game.HEIGHT * Game.SCALE) - 145);
								
								g2.setColor(Color.BLACK);
								g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 135, Game.WIDTH*Game.SCALE, 5);
								g.setColor(Color.white);
								g.drawImage(Entity.itemsPersonagem[8][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 125, null);
								g.drawString("- Chave verde com objetivo de abrir portas, gavetas ou arm�rios. N�o pode ser equipada mas",5,(Game.HEIGHT * Game.SCALE) - 75);
								g.drawString("deve estar no invent�rio r�pido para ser usada.",5,(Game.HEIGHT * Game.SCALE) - 60);
													

							} else
								if (currentOption == 6) {
									g.setFont(new Font("Arial",Font.BOLD,12));
									g.setColor(Color.white);
									g.drawString("ITENS",((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 400);
									g.setFont(new Font("Arial",Font.BOLD,10));
									g.drawImage(Entity.itemsPersonagem[9][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
									g.drawString("- Cura seu HP em 20%. Ao tocar ou comprar esse item, seu HP � automaticamente aumentado.",5,(Game.HEIGHT * Game.SCALE) - 330);
									
									g2.setColor(Color.BLACK);
									g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 320, Game.WIDTH*Game.SCALE, 5);
									g.setColor(Color.white);
									g.drawImage(Entity.itemsPersonagem[10][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 310, null);
									g.drawString("- Cura seu escudo em 20%. Ao tocar ou comprar esse item, seu escudo � automaticamente",5,(Game.HEIGHT * Game.SCALE) - 260);
									g.drawString("aumentado.",5,(Game.HEIGHT * Game.SCALE) - 245);
									g2.setColor(Color.BLACK);
									g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 235, Game.WIDTH*Game.SCALE, 5);
									g.setColor(Color.white);
									g.drawImage(Entity.itemsPersonagem[11][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 225, null);
									g.drawString("- Muni��o para a arma do personagem. Ao tocar ou comprar esse item, sua muni��o �",5,(Game.HEIGHT * Game.SCALE) - 175);
									g.drawString("aumentada em mais dez tiros.",5,(Game.HEIGHT * Game.SCALE) - 160);
									
									g2.setColor(Color.BLACK);
									g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 150, Game.WIDTH*Game.SCALE, 5);
									g.setColor(Color.white);
									g.drawImage(Entity.itemsPersonagem[12][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 140, null);
									g.drawString("- Bigorna para consertar a faca do personagem em 20%. Ao tocar ou comprar esse item, sua",5,(Game.HEIGHT * Game.SCALE) - 90);
									g.drawString("faca � automaticamente consertada.",5,(Game.HEIGHT * Game.SCALE) - 75);
									
									g2.setColor(Color.BLACK);
									g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 65, Game.WIDTH*Game.SCALE, 5);
									g.setColor(Color.white);
									g.drawImage(coin[0], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 55, null);
									g.drawString("- Essas moedas se encontram espalhadas pelos cen�rios. Colete - as para comprar itens.",5,(Game.HEIGHT * Game.SCALE) - 10);			

								} else
									if (currentOption == 7) {
										g.setFont(new Font("Arial",Font.BOLD,12));
										g.setColor(Color.white);
										g.drawString("DICAS",((Game.WIDTH * Game.SCALE)/2) - 20,(Game.HEIGHT * Game.SCALE) - 400);
										g.setFont(new Font("Arial",Font.BOLD,10));
										g.drawImage(dica[0], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
										g.drawString("- Se encontrar um ponto de exclama��o dessa cor em cima de um personagem, quer dizer que",5,(Game.HEIGHT * Game.SCALE) - 335);
										g.drawString("ele possui informa��o essenciais para avan�ar no jogo.",5,(Game.HEIGHT * Game.SCALE) - 320);
										
										g2.setColor(Color.BLACK);
										g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 310, Game.WIDTH*Game.SCALE, 5);
										g.setColor(Color.white);
										g.drawImage(dica[1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 300, null);
										g.drawString("- Se encontrar um ponto de exclama��o dessa cor em cima de um personagem, quer dizer que",5,(Game.HEIGHT * Game.SCALE) - 255);
										g.drawString("ele possui informa��es adicionais para achar segredos e conhecer melhor o mundo do jogo.",5,(Game.HEIGHT * Game.SCALE) - 240);
											
										g2.setColor(Color.BLACK);
										g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 230, Game.WIDTH*Game.SCALE, 5);
										g.setColor(Color.white);
										g.drawImage(dica[2], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 220, null);
										g.drawString("- Se encontrar um ponto de exclama��o dessa cor em cima de um personagem, quer dizer que",5,(Game.HEIGHT * Game.SCALE) - 175);
										g.drawString("o di�logo com o personagem j� foi escutado pelo protagonista.",5,(Game.HEIGHT * Game.SCALE) - 160);
										
										g2.setColor(Color.BLACK);
										g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 150, Game.WIDTH*Game.SCALE, 5);
										g.setColor(Color.white);
										g.drawString("- Cada cen�rio existe um segredo (com exce��o do boss). Procure bem para colecionar todos.",5,(Game.HEIGHT * Game.SCALE) - 120);
										g.drawString("- Invent�rio R�pido: No canto superior direito fica o invent�rio r�pido com dois espa�os.",5,(Game.HEIGHT * Game.SCALE) - 90);
										g.drawString("Quando selecionar um desses espa�os com a tecla U (espa�o da esquerda)",5,(Game.HEIGHT * Game.SCALE) - 75);
										g.drawString("ou a tecla I (espa�o da direita), se o item for algo equip�vel, o mesmo ficar� com um tamanho",5,(Game.HEIGHT * Game.SCALE) - 60);
										g.drawString("maior comparado ao outro espa�o para indicar que est� selecionado.",5,(Game.HEIGHT * Game.SCALE) - 45);
									} else
										if (currentOption == 8) {
											g.setFont(new Font("Arial",Font.BOLD,12));
											g.setColor(Color.white);
											g.drawString("SEGREDOS",((Game.WIDTH * Game.SCALE)/2) - 30,(Game.HEIGHT * Game.SCALE) - 400);
											if (Game.segredo1Encontrado) {
												g.setColor(Color.white);
												g.setFont(new Font("Arial",Font.BOLD,10));
												g.drawImage(segredos[0], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
												g.drawString("- Quadro do personagem favorito de Leon. Anne soube disso e prometeu lhe dar. Leon ficou",5,(Game.HEIGHT * Game.SCALE) - 335);
												g.drawString("muito feliz.",5,(Game.HEIGHT * Game.SCALE) - 320);
											} else {
												g2.setColor(Color.CYAN);
												g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 380, Game.WIDTH*Game.SCALE, 60);
												
												
											}
											
											g2.setColor(Color.BLACK);
											g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 310, Game.WIDTH*Game.SCALE, 5);
											
											if (Game.segredo2Encontrado) {
												g.setColor(Color.white);
												g.setFont(new Font("Arial",Font.BOLD,10));
												g.drawImage(segredos[1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 300, null);
												g.drawString("- Amuleto encontrado por Leon no condom�nio que aconteceu o assassinato de Nathan.",5,(Game.HEIGHT * Game.SCALE) - 255);
												g.drawString("Um morador local disse que era amaldi�oado mas para Leon isso faz o item ser mais valioso.",5,(Game.HEIGHT * Game.SCALE) - 240);
											} else {
												g2.setColor(Color.CYAN);
												g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 300, Game.WIDTH*Game.SCALE, 60);
												
												
											}	
											
											
											g2.setColor(Color.BLACK);
											g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 230, Game.WIDTH*Game.SCALE, 5);
											
											if (Game.segredo3Encontrado) {
												g.setColor(Color.white);
												g.setFont(new Font("Arial",Font.BOLD,10));
												g.drawImage(segredos[3], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 220, null);
												g.drawString("- Medalha pertecente ao sobrinho de Nathan, a v�tima assassinada. Leon jurou fazer justi�a",5,(Game.HEIGHT * Game.SCALE) - 175);
												g.drawString("e entregar de volta ao garoto como forma de lembran�a de seu tio.",5,(Game.HEIGHT * Game.SCALE) - 160);
											} else {
												g2.setColor(Color.CYAN);
												g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 220, Game.WIDTH*Game.SCALE, 60);
												
												
											}	
											
											g2.setColor(Color.BLACK);
											g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 150, Game.WIDTH*Game.SCALE, 5);
											
											if (Game.segredo4Encontrado) {											
												g.setColor(Color.white);
												g.setFont(new Font("Arial",Font.BOLD,10));
												g.drawImage(segredos[2], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 140, null);
												g.drawString("- Chave da moto do pai de Leon. Ap�s uma discuss�o da sua m�e com seu pai, Leon a pegou",5,(Game.HEIGHT * Game.SCALE) - 95);
												g.drawString("e fez seu pai pedir desculpas a ela e assim ele devolveria a chave.",5,(Game.HEIGHT * Game.SCALE) - 80);
											} else {
												g2.setColor(Color.CYAN);
												g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 140, Game.WIDTH*Game.SCALE, 60);														
											}	
										} else
											if (currentOption == 9) {
												g.setFont(new Font("Arial",Font.BOLD,12));
												g.setColor(Color.white);
												g.drawString("SEGREDOS",((Game.WIDTH * Game.SCALE)/2) - 30,(Game.HEIGHT * Game.SCALE) - 400);
												
												if (Game.segredo5Encontrado) {
													g.setColor(Color.white);		
													g.setFont(new Font("Arial",Font.BOLD,10));
													g.drawImage(segredos[4], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 380, null);
													g.drawString("- Diamante fornecido pelo porteiro da oficina onde estava o assassino Andrey. Ele est�",5,(Game.HEIGHT * Game.SCALE) - 335);
													g.drawString("desesperado para sair do emprego e aguarda Leon resolver tudo para ter uma vida tranquila.",5,(Game.HEIGHT * Game.SCALE) - 320);
												} else {
													g2.setColor(Color.CYAN);
													g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 380, Game.WIDTH*Game.SCALE, 60);														
												}
												g2.setColor(Color.BLACK);
												g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 310, Game.WIDTH*Game.SCALE, 5);
												
												if (Game.segredo6Encontrado) {
													g.setFont(new Font("Arial",Font.BOLD,10));
													g.setColor(Color.white);
													g.drawImage(Entity.itemsPersonagem[13][1], ((Game.WIDTH * Game.SCALE)/2) - 10,(Game.HEIGHT * Game.SCALE) - 300, null);
													g.drawString("- Moeda rara de 1900. O Aurelio a encontrou com um ladr�o de j�ias em seu �ltimo caso.",5,(Game.HEIGHT * Game.SCALE) - 255);
												} else {
													g2.setColor(Color.CYAN);
													g2.fillRect(0, (Game.HEIGHT * Game.SCALE) - 300, Game.WIDTH*Game.SCALE, 60);														
												}
													
											}
		
			
	}
	
}