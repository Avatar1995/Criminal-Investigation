package com.gcstudios.main;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gcstudios.graficos.Spritesheet;
import com.gcstudios.main.Game;
import com.gcstudios.main.Load;
import com.gcstudios.main.Menu;
import com.gcstudios.main.Pause;
import com.gcstudios.entities.*;
import com.gcstudios.world.Camera;
import com.gcstudios.graficos.UI;
import com.gcstudios.world.World;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public final static int WIDTH = 160;
	public final static int HEIGHT = 150;
	public final static int SCALE= 3;
	public static BufferedImage image;
	private int timeChuvaMax = 10;
	private int timeChuva = 0;
	public static List<Entity> entities;
	public static List<Enemy> enemies;
	public static List<BulletShoot> bullets;
	public static Phrases phrases;
	public static Spritesheet spritesheet;
	public static Player player;
	public static List<AttackKnife> attackknife;
	public static World world;
	public static boolean showMessageNpc, facaEncontrada, objetivoLiberado = false;
	public static boolean [] mensagemJ = new boolean[12];
	public static Random rand;
	public static Boolean controleTela = false;
	public static Boolean evitarErro = false;
	public static Boolean primeiroLoad = false;
	public static Boolean permissao = true;
	public static Boolean criarBola = false;
	public static Boolean sairDoJogo = false;
	public static int tipoBola = 0;
	private static Boolean enterManualnoMenu = false;
	private static Boolean controleRight = false;
	private static Boolean controleUp = false;
	private static Boolean controleDown = false;
	private static Boolean controleLeft = false;
	public UI ui;
	public static int CUR_LEVEL = 1;
	private int MAX_LEVEL = 7;
	public static String gameState = "ABERTURA";
	private boolean showMessageGameOver, itemNaoEncontrado = true;
	private int framesGameOver = 0;
	private boolean restartGame = false;
	private boolean controleTiroFaca = true;
	public static boolean wardrobeAnalisado, portaAberta,papelAnalisado,diarioLido = false;
	private boolean controle = true;
	public static int cutScene = 1;
	public static int comecar = 2;
	public static int jogando = 3;
	public static int timeCena = 0;
	public static int maxTimeCena = 60*2;
	public static int estado_cena = jogando;
	public static int timeButton,itemInventarioFound = 0;
	public static int maxTimeButton = 30;
	public static boolean objetivo1Completado, objetivo5Completado, objetivoOpcional1Completado, objetivoOpcional5Completado, objetivo3Completado = false;
	public static boolean objetivo2Completado, objetivo4Completado,objetivoOpcional3Completado,objetivoOpcional2Completado = false;
	public static boolean levelConcluido, saidaAlcancada, dialogoCompleto = false;
	public static boolean segredo1Encontrado,segredo2Encontrado, segredo3Encontrado, segredo4Encontrado, segredo5Encontrado,segredo6Encontrado = false;	
	public static boolean segredo1EncontradoOriginalLevel,segredo2EncontradoOriginalLevel,segredo3EncontradoOriginalLevel,segredo4EncontradoOriginalLevel,segredo5EncontradoOriginalLevel,segredo6EncontradoOriginalLevel, chuvaAllowed = false;
	public static Menu menu;
	public static boolean tickPermitido = false;
	public static boolean controleMusic = true;
	public static GameOver gameOver;
	public static Load load;
	public static Encerramento encerramento;
	public static Abertura abertura;
	public static Manual manual;
	public static List<Ball> ball;
	public static Puzzle puzzle;
	public static Inventary inventary;
	public static Shop shop;
	public static ItemsPersonagem itemsPersonagem;
	public static Pause pause;
	public static List<Rain> rain;
	public static CutScenes cutscenes;
	public static List<Npc> npcs;
	public static List<Items> items;
	public static List<NpcMovimento> npcMovi;
	public static boolean messageNPC, messageEnded = false;
	public static boolean armaSelecionada = false;
	public static boolean facaSelecionada = false;
	public static boolean umbrellaSelecionada = false;
	public static boolean monoculoSelecionada = false;
	public static boolean controle2 = true;
	public static boolean demonstraObjetivo = true;
	public static boolean bossDerrotado = false;
	private static int timeCenaBoss = 0,maxTimeCenaBoss = 480;
	private static int timeTelaPreta = 0,maxTimeTelaPreta= 30;
	public static boolean logicaPermitidaBoss = false;
	public static boolean rodarBoss = true;
	public static BufferedImage[] coinTela;
	private int framesCoin = 0, maxFramesCoin = 7, maxIndexCoin = 4;
	public int indexCoin=0;
	private ImageIcon logo;
	public Game(){
		rand = new Random();
		//Metodos padrões para tela
		//Define o tamanho da tela do jogo
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		//Inicializando objetos
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		itemsPersonagem = new ItemsPersonagem();
		entities = new ArrayList<Entity>();
		npcs = new ArrayList<Npc>();
		items = new ArrayList<Items>();
		npcMovi = new ArrayList<NpcMovimento>();
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<BulletShoot>();
		attackknife = new ArrayList<AttackKnife>();
		spritesheet = new Spritesheet("/Trap.png");
		ui = new UI(0,144,9,16,spritesheet.getSprite(0, 144, 9, 16));
		cutscenes = new CutScenes();		
		player = new Player(0,126,9,16,spritesheet.getSprite(0, 126, 9, 16),0);
		phrases = new Phrases();
		entities.add(player);
		world = new World("/level1.png");
		menu = new Menu();
		encerramento = new Encerramento();
		abertura = new Abertura();
		pause = new Pause();
		load = new Load();
		puzzle = new Puzzle();
		inventary = new Inventary();
		shop = new Shop();
		ball = new ArrayList<Ball>();
		manual = new Manual();
		gameOver = new GameOver();
		rain = new ArrayList<Rain>();
		coinTela = new BufferedImage[5];


		for (int i = 0;i < 5;i++) {
			coinTela[i] = spritesheet.getSprite(0 + (i * 19), 1508, 18, 18);

		}
	}
	
	public void initFrame(){
		logo = new ImageIcon(getClass().getResource("/IconeCI.png"));
		frame = new JFrame("Criminal Investigation");
		frame.add(this);
		frame.setResizable(false);
		frame.setIconImage(logo.getImage());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop(){
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Game game = new Game();
		game.start();
	}
	
	public void tick(){
		if ((CUR_LEVEL == 5) && (tickPermitido)){
			if (controleMusic) {
				permissao = false;
				Game.demonstraObjetivo = true;
				AudioPlayer.stopLoopSound();
				AudioPlayer.playLoopSound(AudioClip.oficina,1.5,1);
				controleMusic = false;
			}

			tickPermitido = false;
		}
		if (((CUR_LEVEL == 6) && (rodarBoss))) {
			permissao = false;
			AudioPlayer.playLoopSound(AudioClip.boss,1.5,1);
			Ball ball1 = new Ball(10,Game.HEIGHT/2 - 1,2);
			Ball ball2 = new Ball(100,Game.HEIGHT/2 - 1,3);	
			Game.ball.add(ball1);
			Game.ball.add(ball2);		
			ball1 = null;
			ball2 = null;
			logicaPermitidaBoss = true;
			rodarBoss = false;
		}
		
		if (criarBola) {
			if (tipoBola == 2) {
				Ball ball1 = new Ball(10,Game.HEIGHT/2 - 1,2);
				Game.ball.add(ball1);	
				ball1 = null;
			} else {
				Ball ball2 = new Ball(100,Game.HEIGHT/2 - 1,3);	
				Game.ball.add(ball2);		
				ball2 = null;
			}
			criarBola = false;
		}
		
		if (((gameState == "NORMAL") || (gameState == "TRAVADO")) && (Game.cutscenes.numero != 1) && (CUR_LEVEL == 2)  && (chuvaAllowed)) {
			this.timeChuva++;
			if (this.timeChuva >= this.timeChuvaMax) {
				this.timeChuva = 0;
				Rain chuva0 = new Rain(Camera.x - 9,Camera.y,2,5);
				Game.rain.add(chuva0);
				chuva0 = null;
				Rain chuva1 = new Rain(Camera.x + 4,Camera.y,2,5);
				Game.rain.add(chuva1);
				chuva1 = null;
				Rain chuva2 = new Rain(Camera.x + 18,Camera.y,2,5);
				Game.rain.add(chuva2);
				chuva2 = null;
				Rain chuva3 = new Rain(Camera.x + 33,Camera.y,2,5);
				Game.rain.add(chuva3);
				chuva3 = null;
				Rain chuva4 = new Rain(Camera.x + 48,Camera.y,2,5);
				Game.rain.add(chuva4);
				chuva4 = null;
				Rain chuva5 = new Rain(Camera.x + 63,Camera.y,2,5);
				Game.rain.add(chuva5);
				chuva5 = null;
				Rain chuva6 = new Rain(Camera.x + 78,Camera.y,2,5);
				Game.rain.add(chuva6);
				chuva6 = null;
				Rain chuva7 = new Rain(Camera.x + 93,Camera.y,2,5);
				Game.rain.add(chuva7);
				chuva7 = null;
				Rain chuva8 = new Rain(Camera.x + 108,Camera.y,2,5);
				Game.rain.add(chuva8);
				chuva8 = null;
				Rain chuva9 = new Rain(Camera.x + 123,Camera.y,2,5);
				Game.rain.add(chuva9);
				chuva9 = null;
				Rain chuva10 = new Rain(Camera.x + 138,Camera.y,2,5);
				Game.rain.add(chuva10);
				chuva10 = null;
				Rain chuva11 = new Rain(Camera.x + 153,Camera.y,2,5);
				Game.rain.add(chuva11);
				chuva11 = null;
				Rain chuva12 = new Rain(Camera.x + 168,Camera.y,2,5);
				Game.rain.add(chuva12);
				chuva12 = null;
			
			}
			for(int i = 0; i < rain.size(); i++) {
				rain.get(i).tick();
			}			
		}
		if(gameState == "MENU") {
			menu.tick();
		}else if(gameState == "SHOP") {
			shop.tick();

		} else
		if(gameState == "NORMAL") {
			if (Game.estado_cena == Game.jogando) {
			this.restartGame = false;
			if ((Game.cutscenes.numero == 2) && (Game.cutscenes.SegundaCutScene)) {
				Game.estado_cena = Game.cutScene;
				Game.cutscenes.fraseTerminada = false;
				controle = true;
				Game.cutscenes.SegundaCutScene = false;
				timeCena = 0;
			}
				
				for(int i = 0; i < entities.size(); i++) {
					Entity e = entities.get(i);
					e.tick();
				}
				
			
				for(int i = 0; i < bullets.size(); i++) {
					bullets.get(i).tick();
				}
				
				for(int i = 0; i < attackknife.size(); i++) {
					attackknife.get(i).tick();
				}
				
				
				if ((Game.CUR_LEVEL == 6) && (logicaPermitidaBoss) && (!levelConcluido) && (Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1)) {
					for(int i = 0; i < ball.size(); i++) {
						ball.get(i).tick();
					}
				}
				
				
				
												
							
				if((levelConcluido) && (saidaAlcancada)) {
					primeiroLoad = true;
					//Avançar para o próximo level!
					if (controle2) {
						load.chamaCarregamento = true;
						load.fimCarregamento = false;
						controle2 = false;
						if (CUR_LEVEL == 1) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.playSound(AudioClip.door,1.5,0);
						}
						
						if (CUR_LEVEL == 2) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.stopLoopSoundRain();
							
							AudioPlayer.playSound(AudioClip.door,1.5,0);
						}
						if (CUR_LEVEL == 3) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.playSound(AudioClip.door,1.5,0);

						}
						if (CUR_LEVEL == 4) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.playSound(AudioClip.door,1.5,0);
						}
						if (CUR_LEVEL == 5) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.playSound(AudioClip.door,1.5,0);
						}
						
						if (CUR_LEVEL == 6) {
							AudioPlayer.stopLoopSound();
						}
						
						
						if (CUR_LEVEL == 7) {
							AudioPlayer.stopLoopSound();
							AudioPlayer.playSound(AudioClip.door,1.5,0);
						}
						
					}
					
					

					if (load.fimCarregamento) {
						load.fimCarregamento = false;
						CUR_LEVEL++;
						if(CUR_LEVEL > MAX_LEVEL){
							gameState = "ENCERRAMENTO";
						} else {
							String newWorld = "level"+CUR_LEVEL+".png";
							World.restartGame(newWorld);
						}
					}
					
				}
			} else {
				
				if (Game.estado_cena == Game.cutScene) {
					gameState = "TRAVADO";
					cutscenes.level = CUR_LEVEL;
					if (Game.cutscenes.numero == 1)
						phrases.definirFrases(3);
					else if (Game.cutscenes.numero == 2) {
						phrases.definirFrases(4);
					}
					
					if (controle) {
						phrases.fraseIndex = 0;
						controle = false;
					}
					cutscenes.tick();
					messageNPC = true;
				} else if (Game.estado_cena == Game.comecar) {
					timeCena++;
					if (timeCena == maxTimeCena) {
						Game.estado_cena = Game.jogando;
						timeCena = 0;
						if ((Game.cutscenes.numero == 2) && (!Game.cutscenes.SegundaCutScene)) {
							Game.cutscenes.numero = -1;
						}
						
					}
							
					}
			}
		}else if(gameState == "GAME_OVER") {
			this.framesGameOver++;
			if(this.framesGameOver == 30) {
				this.framesGameOver = 0;
				if(this.showMessageGameOver)
					this.showMessageGameOver = false;
				else
					this.showMessageGameOver = true;
			}
			if(restartGame) {
				this.restartGame = false;
				String newWorld = "level"+CUR_LEVEL+".png";
				World.restartFromGameOver(newWorld);
			}
		} else if(gameState == "PAUSE") {
			pause.tick();
		}else if(gameState == "PUZZLE") {
			puzzle.tick();
		}else if(gameState == "INVENTARY") {
			inventary.tick();
		}else if(gameState == "MANUAL") {
			manual.tick();
		}else if(gameState == "ENCERRAMENTO") {
			encerramento.tick();
		}else if(gameState == "ABERTURA") {
			abertura.tick();
		}
		phrases.tick();
		gameOver.tick();	

		if (load.chamaCarregamento) {
				load.tick();
		}

			
			if (bossDerrotado) {
				timeCenaBoss++;
				gameState = "TRAVADO";
				logicaPermitidaBoss = false;
				if (timeCenaBoss > maxTimeCenaBoss) {
					timeCenaBoss = 0;
					bossDerrotado = false;
					levelConcluido = true;
					saidaAlcancada = true;
					gameState = "NORMAL";
				}
								
				
			}
			
			framesCoin++;
			if (framesCoin == maxFramesCoin) {
				framesCoin = 0;
				indexCoin++;
				if (indexCoin > maxIndexCoin) {
					indexCoin = 0;

				}
			}
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		//renderizar uma cor
		g.setColor(new Color(0,0,0));
		//renderizar um retangulo
		g.fillRect(0,0,WIDTH,HEIGHT);
		world.render(g);
		if (Game.permissao) {
		if (((gameState == "NORMAL") || (gameState == "TRAVADO")) && (Game.cutscenes.numero != 1) && (CUR_LEVEL == 2)  && (chuvaAllowed)) {
			for (int i = 0;i < rain.size();i++) {
				rain.get(i).render(g);
			}
				
		
		}
		
		
		if((gameState == "NORMAL") || (gameState == "TRAVADO") || (gameState == "PAUSE")) {
		for (int i = 0;i < entities.size();i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		
	
		for (int i = 0;i < bullets.size();i++) {
			bullets.get(i).render(g);
		}
		
		for (int i = 0;i < attackknife.size();i++) {
			attackknife.get(i).render(g);
		}
						
		ui.render(g);		
		gameOver.render(g);
		if(gameState == "PAUSE") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);	
			pause.render(g);
		} else {
			
			if ((Game.CUR_LEVEL == 6) && (logicaPermitidaBoss) && (!levelConcluido) && (gameState == "NORMAL") && (Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1)) {
				for(int i = 0; i < ball.size(); i++) {
					ball.get(i).render(g);
				}
			} 
		g.dispose();

		g = bs.getDrawGraphics();
		g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);	
		
		if ((Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1)) {
			if (Game.demonstraObjetivo) {
				g.setFont(new Font("arial",Font.BOLD,18));
				g.setColor(Color.white);
				g.drawString("Objetivo(s): ",5,40);
				g.setFont(new Font("arial",Font.BOLD,15));
				if ((objetivo1Completado) && (objetivo2Completado) && (CUR_LEVEL == 1)){ 
					g.setColor(Color.white);
					g.drawString("- Saia da delegacia",8,60);				
				
				} else {
					if ((!objetivo1Completado) && (CUR_LEVEL == 1)) { 
						g.setColor(Color.white);
						g.drawString("- Obtenha o guarda - chuva ",8,60);
					} else if ((objetivo1Completado) && (CUR_LEVEL == 1)) {
						g.setColor(Color.green);
						g.drawString("- Obtenha o guarda - chuva ",8,60);
					}
					if ((!objetivo2Completado) && (CUR_LEVEL == 1)) { 
						g.setColor(Color.white);
						g.drawString("- Obtenha o monóculo ",8,80);
					} else if ((objetivo2Completado) && (CUR_LEVEL == 1)) {
						g.setColor(Color.green);
						g.drawString("- Obtenha o monóculo ",8,80);
					}
				}
				
				
				if ((objetivo1Completado) && (objetivo2Completado) && (objetivo3Completado) && (CUR_LEVEL == 2)){ 
					g.setColor(Color.white);
					g.drawString("- Entre na casa",8,60);				
				
				} else {
				
					if ((!objetivo1Completado) && (!objetivo2Completado) && (!objetivo3Completado) && (CUR_LEVEL == 2)){ 
						g.setColor(Color.white);
						g.drawString("- Fale com o oficial Robert",8,60);				
				
					} else {
						if ((objetivo1Completado) && (!objetivo3Completado) && (CUR_LEVEL == 2)) { 
							g.setColor(Color.white);
							g.drawString("- Fale com a primeira testemunha",8,68);
						} else if ((objetivo1Completado) && (objetivo3Completado) && (CUR_LEVEL == 2)) {
							g.setColor(Color.green);
							g.drawString("- Fale com a primeira testemunha",8,68);
						}
						if ((objetivo1Completado) && (!objetivo2Completado) && (CUR_LEVEL == 2)) { 
							g.setColor(Color.white);
							g.drawString("- Fale com a segunda testemunha",8,88);
						} else if ((objetivo1Completado) && (objetivo2Completado) && (CUR_LEVEL == 2)) {
							g.setColor(Color.green);
							g.drawString("- Fale com a segunda testemunha",8,88);
						}
					}
				}	
				
				if ((objetivo1Completado) && (objetivo2Completado) && (objetivo3Completado) && (objetivo4Completado)  && (objetivo5Completado)   && (CUR_LEVEL == 3)){ 
					g.setColor(Color.white);
					g.drawString("- Saia da casa",8,60);				
				
				} else {
				
					if ((objetivo1Completado) && (objetivo2Completado) && (objetivo3Completado) && (objetivo4Completado)  && (!objetivo5Completado) && (CUR_LEVEL == 3)){ 
						g.setColor(Color.white);
						g.drawString("- Leia o diário e fale com o Robert",8,70);				
				
					} else {
						if ((!objetivo2Completado) && (CUR_LEVEL == 3)) { 
							g.setColor(Color.white);
							g.drawString("- Ache a primeira pista",8,60);
						} else if ((objetivo2Completado) && (CUR_LEVEL == 3)) {
							g.setColor(Color.green);
							g.drawString("- Ache a primeira pista",8,60);
						}
						if ((!objetivo4Completado) && (CUR_LEVEL == 3)) { 
							g.setColor(Color.white);
							g.drawString("- Ache a segunda pista",8,80);
						} else if ((objetivo4Completado) && (CUR_LEVEL == 3)) {
							g.setColor(Color.green);
							g.drawString("- Ache a segunda pista",8,80);
						}
					}
				}
				
				if ((objetivo1Completado) && (CUR_LEVEL == 4)){ 
					g.setColor(Color.white);
					g.drawString("- Saia da delegacia",8,60);				
				
				} else {
				
					if ((!objetivo1Completado) && (CUR_LEVEL == 4)){ 
						g.setColor(Color.white);
						g.drawString("- Obtenha seu armamento",8,70);				
				
					} 
				}	
				
				
				if ((objetivo2Completado) && (CUR_LEVEL == 5)){ 
					g.setColor(Color.white);
					g.drawString("- Vá para a sala do assassino",8,60);				
				
				} else
				
				if ((objetivo1Completado) && (objetivoLiberado) && (CUR_LEVEL == 5)){ 
					g.setColor(Color.white);
					g.drawString("- Derrote os inimigos",8,60);				
				
				} else {
				
					if ((!objetivo1Completado) && (CUR_LEVEL == 5)){ 
						g.setColor(Color.white);
						g.drawString("- Fale com o porteiro",8,70);				
				
					} 
				}
				
				if (CUR_LEVEL == 6){ 
					g.setColor(Color.white);
					g.drawString("- Detenha o Andrey",8,60);				
				
				
				}

				if ((objetivo1Completado) && (CUR_LEVEL == 7)){ 
					g.setColor(Color.white);
					g.drawString("- Saia da delegacia",8,60);				
				
				} else {
				
					if ((!objetivo1Completado) && (CUR_LEVEL == 7)){ 
						g.setColor(Color.white);
						g.drawString("- Fale com o Sargento Steve",8,70);				
				
					} 
				}
				
			}
			
			for (int i = 0;i < mensagemJ.length;i++) {
				if (mensagemJ[i]) {
					g.setFont(new Font("arial",Font.BOLD,15));
					g.setColor(Color.green);
					if (permissao) {
						g.drawString("Pressione J para interagir",((WIDTH/2) * SCALE) - 60,(HEIGHT * SCALE) - 10);
					} else {
						g.drawString("Loading...",((WIDTH/2) * SCALE) - 60,(HEIGHT * SCALE) - 10);
					}
					break;
				}
					
			}
			
			if ((objetivoOpcional1Completado) && (objetivoOpcional2Completado) && (CUR_LEVEL == 2)) { 					
				for (int i = 0;i < items.size();i++) {
					if (items.get(i).tipo == 3) {
						items.get(i).tipo = 1;
					}
				}
			}
			
			
			if ((objetivo1Completado) && (CUR_LEVEL == 5)) { 					
				for (int i = 0;i < npcs.size();i++) {
					if (npcs.get(i).tipo == 9) {
						Game.entities.remove(npcs.get(i));
						Game.npcs.remove(npcs.get(i));
						break;
					}
					
					if (npcs.get(i).tipo == 14) {
						Game.entities.remove(npcs.get(i));
						Game.npcs.remove(npcs.get(i));
						break;
					}
				}
			}
			
			if ((objetivo2Completado) && (CUR_LEVEL == 5)) { 					
				for (int i = 0;i < npcs.size();i++) {
					if (npcs.get(i).tipo == 7) {
						Game.entities.remove(npcs.get(i));
						Game.npcs.remove(npcs.get(i));
					}
					
					if (npcs.get(i).tipo == 5) {
						Game.entities.remove(npcs.get(i));
						Game.npcs.remove(npcs.get(i));
					}
				}
			}
			
			if ((portaAberta) && (CUR_LEVEL == 3)) { 					
				for (int i = 0;i < npcs.size();i++) {
					if (npcs.get(i).tipo == 9) {
						npcs.get(i).tipo = 30;
					}
				}
			}
				
			if ((objetivo1Completado) && (objetivo2Completado) && (!levelConcluido) && (CUR_LEVEL == 1)){ 
				demonstraObjetivo = true;
				levelConcluido = true;						
			}
			
			if ((objetivo1Completado) && (objetivo2Completado) && (objetivo3Completado)  && (!levelConcluido) && (CUR_LEVEL == 2)){ 
				demonstraObjetivo = true;
				levelConcluido = true;						
			}
			
			if ((objetivo1Completado) && (objetivo2Completado) && (objetivo3Completado) && (objetivo4Completado)  && (objetivo5Completado) && (!levelConcluido) && (CUR_LEVEL == 3)){ 
				demonstraObjetivo = true;
				levelConcluido = true;						
			}
			
			if ((objetivo1Completado) && (!levelConcluido) && (CUR_LEVEL == 4)){ 
				demonstraObjetivo = true;
				levelConcluido = true;						
			}
			
			
			if ((objetivo1Completado) && (!levelConcluido) && (objetivo2Completado) && (CUR_LEVEL == 5)){ 
				demonstraObjetivo = true;
				levelConcluido = true;
			}
			
			if ((objetivo1Completado) && (!levelConcluido) && (CUR_LEVEL == 7)){ 
				demonstraObjetivo = true;
				levelConcluido = true;						
			}
			
			if ((objetivoOpcional1Completado) && (objetivoOpcional2Completado) && (CUR_LEVEL == 2)) {
			
				for (int i = 0; i < Game.items.size();i++) {
					Items it = Game.items.get(i);
					if (Game.items.get(i).tipo == 3)
						Game.items.get(i).tipo = 1;

				}
			}
			
			if ((CUR_LEVEL == 1) && (!messageEnded)){ 
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,25));
				g.drawString("Capítulo 1",((WIDTH * SCALE)/2) - 20,(HEIGHT * SCALE)/2);
				g.drawString("O jovem promissor",((WIDTH * SCALE)/2) - 70,((HEIGHT * SCALE)/2) + 30);	
				timeCena++;
				if (timeCena == maxTimeCena) {
					timeCena = 0;
					messageEnded = true;
				}
			}
			
			
		if (!messageNPC) {		
			g.setFont(new Font("arial",Font.BOLD,13));
			g.setColor(Color.white);
						
			g.drawImage(coinTela[indexCoin], (Game.WIDTH * Game.SCALE) - 60,Game.HEIGHT * Game.SCALE - 430, null);	
			g.drawString(":" + player.coin,(Game.WIDTH * Game.SCALE) - 42,Game.HEIGHT * Game.SCALE - 416);
					
			if ((player.itemEsquerda == 7) || (player.itemDireita == 7)) {
				g.drawImage(Entity.itemsPersonagem[7][0], (Game.WIDTH * Game.SCALE) - 110,Game.HEIGHT * Game.SCALE - 50, null);	
				g.drawString(":" +(int)player.lifeKnife + "/100",(Game.WIDTH * Game.SCALE) - 80,Game.HEIGHT * Game.SCALE - 30);
			}
			if ((player.itemEsquerda == 6) || (player.itemDireita == 6)) {
				g.drawImage(Entity.itemsPersonagem[6][0], (Game.WIDTH * Game.SCALE) - 110,Game.HEIGHT * Game.SCALE - 20, null);
				g.drawString(":" + player.ammo,(Game.WIDTH * Game.SCALE) - 80,Game.HEIGHT * Game.SCALE - 5);
			}			
		}
		
		
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 250, 15,80,2);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 248, 13,78,1);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 250, 15,2,40);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 248, 13,1,38);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 250, 55,80,2);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 248, 53,78,1);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 170, 15,2,40);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 168, 13,1,38);
		
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 150, 15,80,2);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 148, 13,78,1);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 150, 15,2,40);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 148, 13,1,38);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 150, 55,80,2);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 148, 53,78,1);
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH * Game.SCALE - 70, 15,2,40);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH * Game.SCALE - 68, 13,1,38);
		
		g.setColor(Color.blue);
		g.fillRect(5, 3,95,17);
		g.setFont(new Font("arial",Font.BOLD,11));
		g.setColor(Color.white);
		g.drawString("Tecla M - Manual",7,16);

		if (CUR_LEVEL >= 3) {
			g.setColor(Color.blue);
			g.fillRect(Game.WIDTH * Game.SCALE - 70, 55,42,20);
			g.setFont(new Font("arial",Font.BOLD,11));
			g.setColor(Color.white);
			g.drawString("Tecla O",Game.WIDTH * Game.SCALE - 68,70);
		}
		
		

		if (player.itemEsquerda != -1) {
			if (player.itemEsquerdaSelecionado) {
				g.drawImage(Entity.itemsPersonagem[player.itemEsquerda][1], (Game.WIDTH * Game.SCALE) - 221,20, null);
			} else
				g.drawImage(Entity.itemsPersonagem[player.itemEsquerda][0], (Game.WIDTH * Game.SCALE) - 221,20, null);							
		}
		
		if (player.itemDireita != -1) {
			if (player.itemDireitaSelecionado) {
				g.drawImage(Entity.itemsPersonagem[player.itemDireita][1], (Game.WIDTH * Game.SCALE) - 120,20, null);
			} else
				g.drawImage(Entity.itemsPersonagem[player.itemDireita][0], (Game.WIDTH * Game.SCALE) - 120,20, null);							
		}
	
		
		}
		
		phrases.render(g);
		} 
		} else
		if(gameState == "GAME_OVER") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			desligarLigarMusica(CUR_LEVEL);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
			g.setFont(new Font("arial",Font.BOLD,20));
			g.setColor(Color.white);
			g.drawString("Game Over",(WIDTH*SCALE) / 2 - 60,(HEIGHT* SCALE) / 2);
			g.setFont(new Font("arial",Font.BOLD,18));
			if(showMessageGameOver)
				g.drawString(">Pressione Enter para reiniciar<",(WIDTH*SCALE) / 2 - 135,(HEIGHT* SCALE) / 2 + 40);
			
			
			if(CUR_LEVEL == 2)
				g.drawString("Sempre escute a sua mãe. Nunca tome chuva.",(WIDTH*SCALE) / 2 - 200,(HEIGHT* SCALE) / 2 + 150);
			else
			if(CUR_LEVEL == 5)
				g.drawString("O Capitão Ikena vai precisar de uma boa explicação.",(WIDTH*SCALE) / 2 - 225,(HEIGHT* SCALE) / 2 + 150);	
			else
			if(CUR_LEVEL == 6)
				g.drawString("Parece que o Andrey vai ficar a solta.",(WIDTH*SCALE) / 2 - 165,(HEIGHT* SCALE) / 2 + 150);	
		
		}else if(gameState == "MENU") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			menu.render(g);
		}else if(gameState == "PUZZLE") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			puzzle.render(g);
		}else if(gameState == "INVENTARY") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			inventary.render(g);
		}else if(gameState == "SHOP") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			shop.render(g);
		}else if(gameState == "MANUAL") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			manual.render(g);
		}else if(gameState == "ENCERRAMENTO") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			encerramento.render(g);
		}else if(gameState == "ABERTURA") {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			abertura.render(g);
		}

			if (load.chamaCarregamento) {
				load.render(g);
			}
			
			if (Game.estado_cena == Game.cutScene) {
				cutscenes.render(g);
			}
			if (controleTela) {
				timeTelaPreta++;
				if (timeTelaPreta >= maxTimeTelaPreta) {
					timeTelaPreta = 0;
					primeiroLoad = false;
					controleTela = false;
				}
			}
			if(primeiroLoad) {
				g.dispose();
				g = bs.getDrawGraphics();
				g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial",Font.BOLD,30));				
				g.drawString("Loading", (Game.WIDTH*Game.SCALE) / 2 - 55 , (Game.HEIGHT*Game.SCALE) / 2);
			}
			
		} else {
			g.dispose();
			g = bs.getDrawGraphics();
			g.drawImage(image,0,0,WIDTH * SCALE,HEIGHT * SCALE,null);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.BOLD,30));				
			g.drawString("Loading", (Game.WIDTH*Game.SCALE) / 2 - 55 , (Game.HEIGHT*Game.SCALE) / 2);
			
		}

		bs.show();
	}
	
	public void definirSomItemSelected(int music) {
		if (music == 0) {
			AudioPlayer.playSound(AudioClip.umbrellaSelecionado,2,0);
		}
		if (music == 1) {
			AudioPlayer.playSound(AudioClip.monoculoSelecionado,2,0);
		}
		
		if (music == 2) {
			//frase="Chave prata.";
		}
		
		if (music == 3) {
			//frase="Chave dourada.";
		}
		
		if (music == 4) {
			//frase="Papel com algumas anotações.";
		}
		
		if (music == 5) {
			//frase="Diário com algumas informações.";
		}
		
		if (music == 6) {
			AudioPlayer.playSound(AudioClip.gunSelecionado,2,0);
		}
		if (music == 7) {
			AudioPlayer.playSound(AudioClip.knifeSelecionado,2,0);
		}
		
	}
	
	public void definirSomItemDesSelected(int music) {
		if (music == 0) {
			AudioPlayer.playSound(AudioClip.umbrellaDeselecionado,2,0);
		}
		if (music == 1) {
			AudioPlayer.playSound(AudioClip.monoculoDeselecionado,2,0);
		}
		
		if (music == 2) {
			//frase="Chave prata.";
		}
		
		if (music == 3) {
			//frase="Chave dourada.";
		}
		
		if (music == 4) {
			//frase="Papel com algumas anotações.";
		}
		
		if (music == 5) {
			//frase="Diário com algumas informações.";
		}
		
		if (music == 6) {
			AudioPlayer.playSound(AudioClip.gunDeselecionado,2,0);
		}
		if (music == 7) {
			AudioPlayer.playSound(AudioClip.knifeDeselecionado,2,0);
		}
		
	}
	
	public static void abaixarAumentarMusica() {
		if ((gameState == "PAUSE") || (gameState == "INVENTARY") || (gameState == "MANUAL")) {
			AudioPlayer.abaixarAumentarSound(0.5);
		} else
			AudioPlayer.abaixarAumentarSound(1.5);
			
			
	}
	
	public static void desligarLigarMusica(int level) {
		if (level == 1) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
			} else if (gameState == "GAME_OVER")  {
				AudioPlayer.stopLoopSound();
			}
			
			
		}
		if (level == 2) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.abaixarAumentarSoundRain(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
				AudioPlayer.abaixarAumentarSoundRain(0.5);
			} else if (gameState == "GAME_OVER")  {
				AudioPlayer.stopLoopSound();
				AudioPlayer.stopLoopSoundRain();

			}
			
			
		}
		
		if (level == 3) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
			} else if (gameState == "GAME_OVER")  {
				AudioPlayer.stopLoopSound();
			}
			
			
		}
		
		if (level == 4) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
			} else if (gameState == "GAME_OVER")  {
				AudioPlayer.stopLoopSound();
			}
			
			
		}
		
		if (level == 5) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
			} else if (gameState == "GAME_OVER") {
				AudioPlayer.stopLoopSound();
			}  
			
			
		}
		
		if (level == 6) {
			if (gameState == "GAME_OVER") {
				AudioPlayer.stopLoopSound();
			} 
			
		}
		
		if (level == 7) {
			if (gameState == "SHOP") {
				AudioPlayer.abaixarAumentarSound(0.0);
				AudioPlayer.playLoopSoundShop(AudioClip.shop,0.9,7);
			} else if (gameState == "NORMAL")  {
				AudioPlayer.stopLoopSoundShop();
				AudioPlayer.abaixarAumentarSound(1.5);
			} else if (gameState == "GAME_OVER")  {
				AudioPlayer.stopLoopSound();
			}
			
			
		}
		
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				frames = 0;
				timer+=1000;
			}
			
		}
		
		stop();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Game.permissao) {
		if ((e.getKeyCode() == KeyEvent.VK_J ) && ((gameState == "NORMAL") || (gameState == "PUZZLE") || (gameState == "TRAVADO") || (gameState == "SHOP"))) {
			
			if (gameState == "PUZZLE") {
				gameState = "NORMAL"; 
				for (int i = 0; i < puzzle.maxValor;i++) {
					puzzle.valor[i] = -1;

				}
				
			} else 
			
			if ((phrases.showMessage3) && (CUR_LEVEL == 3) && (Game.papelAnalisado) 
					&& (Game.gameState != "TRAVADO")
					&& (!puzzle.puzzleResolvido) && (itemsPersonagem.items[5][1] == 0)) {
				gameState = "PUZZLE";
			} else 	
			
			if ((permissao) &&((phrases.fraseIndex == -1) || (evitarErro)) && ((phrases.showMessage1) || (phrases.showMessage2) || (phrases.showMessage3)
					|| (phrases.showMessage4) || (phrases.showMessage5) || (phrases.showMessage6)
					|| (phrases.showMessage7) || (phrases.showMessage8) || (phrases.showMessage9)
					|| (phrases.showMessage10) || (phrases.showMessage11) || (phrases.showMessage12) || (phrases.showMessage13)))  {
					evitarErro = false;	
					AudioPlayer.playSound(AudioClip.phrases,2,0);
					messageNPC = true;
					player.indexHor = 0;
					player.indexVert = 0;
					phrases.fraseIndex++;
					gameState = "TRAVADO";
			} else
			
			if ((Game.cutscenes.numero != -1) && (!load.chamaCarregamento) && (Game.phrases.fraseIndex >= 0) && (Game.phrases.fraseIndex <= Game.phrases.maxFrases) && (Game.phrases.curIndexMsg > 0) ) {
				if (Game.phrases.timeFrase < Game.phrases.maxTimeFrase) {
					Game.phrases.curIndexMsg = Game.phrases.frases[Game.phrases.fraseIndex].length() -1;
					AudioPlayer.playSound(AudioClip.phrases,2,0);
				}
			} else
			
			if ((Game.phrases.fraseIndex >= 0) && (Game.phrases.fraseIndex <= Game.phrases.maxFrases) && (Game.phrases.curIndexMsg > 0) && ((phrases.showMessage1) || (phrases.showMessage2) || (phrases.showMessage3)
					|| (phrases.showMessage4) || (phrases.showMessage5) || (phrases.showMessage6)
					|| (phrases.showMessage7) || (phrases.showMessage8) || (phrases.showMessage9)
					|| (phrases.showMessage10) || (phrases.showMessage11) || (phrases.showMessage12) || (phrases.showMessage13)))  {
				if (Game.phrases.timeFrase < Game.phrases.maxTimeFrase) {
					Game.phrases.curIndexMsg = Game.phrases.frases[Game.phrases.fraseIndex].length() -1;
					AudioPlayer.playSound(AudioClip.phrases,2,0);
				}	
			
			
			} else
			
			if (gameState == "SHOP") {				
				itemNaoEncontrado = true;
				for (int i = 0; i < Game.shop.maxItemsVenda;i++) {
					if ((shop.itemVenda[i][1] == shop.currentOptionVert) &&
						(shop.itemVenda[i][2] == shop.currentOptionHor)) {
						itemNaoEncontrado = false;
						for (int j = 0; j < inventary.maxItemsInventario;j++) {
							if ((inventary.itemInventario[j][0] == shop.itemVenda[i][0])) {
								itemInventarioFound = inventary.itemInventario[j][0];
								break;
							} else
								itemInventarioFound = -1;
						}
							if ((itemInventarioFound == shop.itemVenda[i][0]) &&
								(shop.itemVenda[i][0] <= 8)){
								itemNaoEncontrado = false;	
								shop.itemJaSelecionado = true;
								shop.posicaoVertSelected = shop.currentOptionVert;
								shop.posicaoHorSelected = shop.currentOptionHor;
								shop.itemBloqueado = shop.itemVenda[i][3];
								AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
								break;

							} else
								
							 if (shop.itemVenda[i][0] == 9){
								 if (player.life == 100) {
									 itemNaoEncontrado = false;
									 shop.hpCompleto = true;
									 shop.posicaoVertSelected = shop.currentOptionVert;
									 shop.posicaoHorSelected = shop.currentOptionHor;
									 shop.itemBloqueado = shop.itemVenda[i][3];
									 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
									 break;
									 
								 } else
									 if (player.coin >= shop.itemVenda[i][3]) {					 				 
										 player.life+=shop.life;
										 if (player.life > 100)
											 player.life = 100;
										 player.coin -=shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemComprado,1,0);
										 itemNaoEncontrado = false;	
										 break;
									 } else {
										 itemNaoEncontrado = false;
										 shop.dinheiroIssuficiente = true;
										 shop.posicaoVertSelected = shop.currentOptionVert;
										 shop.posicaoHorSelected = shop.currentOptionHor;
										 shop.itemBloqueado = shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);	
										 break;
									 }
									 
							 } else
								 
							if (shop.itemVenda[i][0] == 10){
								if (player.shield == 100) {
									itemNaoEncontrado = false;
									shop.coleteCompleto = true;
									shop.posicaoVertSelected = shop.currentOptionVert;
									shop.posicaoHorSelected = shop.currentOptionHor;
									shop.itemBloqueado = shop.itemVenda[i][3];
									AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
									break;
										 
								} else
									 if (player.coin >= shop.itemVenda[i][3]) {			
										 player.shield+=shop.shield;
										 if (player.shield > 100)
											 player.shield = 100;
										 player.coin -=shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemComprado,1,0);
										 itemNaoEncontrado = false;	
										 break;
									 } else {
										 itemNaoEncontrado = false;
										 shop.dinheiroIssuficiente = true;
										 shop.posicaoVertSelected = shop.currentOptionVert;
										 shop.posicaoHorSelected = shop.currentOptionHor;
										 shop.itemBloqueado = shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
										 break;
									 }
							} else
							
							if (shop.itemVenda[i][0] == 11){
								if (player.coin >= shop.itemVenda[i][3]) {					 				 
										 player.ammo+=shop.ammo;
										 player.coin -=shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemComprado,1,0);
										 itemNaoEncontrado = false;	
										 
										 break;
								} else {
										 itemNaoEncontrado = false;
										 shop.dinheiroIssuficiente = true;
										 shop.posicaoVertSelected = shop.currentOptionVert;
										 shop.posicaoHorSelected = shop.currentOptionHor;
										 shop.itemBloqueado = shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
										 itemNaoEncontrado = false;	
										 break;
									 }
							} else 
								
								if (shop.itemVenda[i][0] == 12){
									facaEncontrada = false;
									 for (int k = 0; k < itemsPersonagem.maxItemsInventario;k++) {
											if ((itemsPersonagem.items[k][0] == 7) && (itemsPersonagem.items[k][1] == 1)) {
												facaEncontrada = true;
												break;
											}

									 }
									 
									 if (!facaEncontrada) {
										 itemNaoEncontrado = false;
										 shop.facaNaoEncontrada = true;
										 shop.posicaoVertSelected = shop.currentOptionVert;
										 shop.posicaoHorSelected = shop.currentOptionHor;
										 shop.itemBloqueado = shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
										 break;
										 
										 
									 } else
									
									
									
									
									 if (player.lifeKnife == 100) {
										 itemNaoEncontrado = false;
										 shop.facaEstadoPerfeito = true;
										 shop.posicaoVertSelected = shop.currentOptionVert;
										 shop.posicaoHorSelected = shop.currentOptionHor;
										 shop.itemBloqueado = shop.itemVenda[i][3];
										 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
										 break;
										 
									 } else
										 if (player.coin >= shop.itemVenda[i][3]) {					 				 
											 player.lifeKnife+=shop.lifeKnife;
											 if (player.lifeKnife > 100)
												 player.lifeKnife = 100;
											 player.coin -=shop.itemVenda[i][3];
											 AudioPlayer.playSound(AudioClip.itemComprado,1,0);
											 itemNaoEncontrado = false;	
											 break;
										 } else {
											 itemNaoEncontrado = false;
											 shop.dinheiroIssuficiente = true;
											 shop.posicaoVertSelected = shop.currentOptionVert;
											 shop.posicaoHorSelected = shop.currentOptionHor;
											 shop.itemBloqueado = shop.itemVenda[i][3];
											 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);	
											 break;
										 }
										 
								 } else if (shop.itemVenda[i][0] == 13){
										if ((segredo1Encontrado) && (segredo2Encontrado) && (segredo3Encontrado)
												&& (segredo4Encontrado) && (segredo5Encontrado) && (!segredo6Encontrado)) {					 				 
											 segredo6Encontrado = true;
											 AudioPlayer.playSound(AudioClip.secret,1,0);
											 itemNaoEncontrado = false;	
											 
											 break;
									} else if (segredo6Encontrado)  {
											itemNaoEncontrado = false;	
											shop.itemJaSelecionado = true;
											shop.posicaoVertSelected = shop.currentOptionVert;
											shop.posicaoHorSelected = shop.currentOptionHor;
											shop.itemBloqueado = shop.itemVenda[i][3];
											AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
										break;
										 } else {
											 itemNaoEncontrado = false;
											 shop.secretNaoObtido = true;
											 shop.posicaoVertSelected = shop.currentOptionVert;
											 shop.posicaoHorSelected = shop.currentOptionHor;
											 shop.itemBloqueado = shop.itemVenda[i][3];
											 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
											 break;
										 }
								} else
								
								
								if ((itemInventarioFound != shop.itemVenda[i][0]) &&
									(shop.itemVenda[i][0] <= 8)
									&&(player.coin >= shop.itemVenda[i][3])) {	
								 AudioPlayer.playSound(AudioClip.itemComprado,1,0);
								 itemNaoEncontrado = false;	
								 player.coin -=shop.itemVenda[i][3];
								 
								 for (int k = 0; k < itemsPersonagem.maxItemsInventario;k++) {
										if (itemsPersonagem.items[k][0] == shop.itemVenda[i][0]) {
											itemsPersonagem.items[k][1] = 1;
											itemsPersonagem.items[k][2] = 1;
											if (itemsPersonagem.items[k][0] == 7)
												player.lifeKnife = 100;
											
											inventary.definirInventario();
											break;
										}

								 }
								 break;
							 } else {
								 itemNaoEncontrado = false;
								 shop.dinheiroIssuficiente = true;
								 shop.posicaoVertSelected = shop.currentOptionVert;
								 shop.posicaoHorSelected = shop.currentOptionHor;
								 shop.itemBloqueado = shop.itemVenda[i][3];
								 AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
								 break;
							 }
					
						

							
					}
					
				}
					
					if (itemNaoEncontrado) {
						shop.itemNaoEncontrado = true;
						AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
						itemNaoEncontrado = false;
						
					}
					
				
			} else
			
			if (gameState == "NORMAL") {
				
				
				if ((((player.itemEsquerda == 6) && (player.itemEsquerdaSelecionado))				
					|| ((player.itemDireita == 6) && (player.itemDireitaSelecionado))) && (controleTiroFaca)) {							
					controleTiroFaca = false;
					player.shoot = true;					
				} else
					if ((((player.itemEsquerda == 7) && (player.itemEsquerdaSelecionado))				
						|| ((player.itemDireita == 7) && (player.itemDireitaSelecionado))) && (controleTiroFaca)) {					
					controleTiroFaca = false;
					player.attack = true;
				 }
				 else if (demonstraObjetivo) {
					demonstraObjetivo = false;
				} else
					demonstraObjetivo = true;
				
			}
				
			
		}
		if ((Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1) && (!Game.bossDerrotado)) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D ) {
				
				if((gameState == "SHOP") && (permissao)) {
					shop.right = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.right = false;				
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
				
				if(gameState == "INVENTARY") {
					inventary.right = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.right = false;				
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else if(gameState == "NORMAL") {
					player.right = true;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
					
					if(gameState == "MANUAL") {
						manual.right = true;
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;				
						player.staticLeft = false;
						player.staticRight = false;
						player.staticUp = false;
						player.staticDown = false;
					}
				
				
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
				
				if((gameState == "SHOP") && (permissao)) {
					shop.left = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.left = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
				
				if(gameState == "INVENTARY") {
					inventary.left = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.left = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else if(gameState == "NORMAL") {
					player.left = true;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
					
					if(gameState == "MANUAL") {
						manual.left = true;
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.left = false;
						player.staticLeft = false;
						player.staticRight = false;
						player.staticUp = false;
						player.staticDown = false;
					}
			
				
				
			}  else
			
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W ) {
				
				if((gameState == "SHOP") && (permissao)) {
					shop.up = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.up = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
				
				if(gameState == "INVENTARY") {
					inventary.up = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.up = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else 
					if((gameState == "MENU") && (permissao)) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						menu.up = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.up = false;
						player.staticLeft = false;
						player.staticRight = false;
						player.staticUp = false;
						player.staticDown = false;
					} else
						if(gameState == "PAUSE") {
							AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
							pause.up = true;
							Game.player.indexHor = 0;
							Game.player.indexVert = 0;
							player.up = false;
							player.staticLeft = false;
							player.staticRight = false;
							player.staticUp = false;
							player.staticDown = false;
						} else if(gameState == "NORMAL") {
							player.up = true;
							player.staticLeft = false;
							player.staticRight = false;
							player.staticUp = false;
							player.staticDown = false;
						}
				
				
				
				
				
				
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S ) {
				
				if((gameState == "SHOP") && (permissao)) {
					shop.down = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.down = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
				
				if(gameState == "INVENTARY") {
					inventary.down = true;
					AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
					Game.player.indexHor = 0;
					Game.player.indexVert = 0;
					player.down = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else
					if((gameState == "MENU") && (permissao)) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						menu.down = true;
					} else
						if(gameState == "PAUSE") {
							AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
							pause.down = true;
						} else if(gameState == "NORMAL") {
							player.down = true;
							player.staticLeft = false;
							player.staticRight = false;
							player.staticUp = false;
							player.staticDown = false;
						}
			}
			
			if ((e.getKeyCode() == KeyEvent.VK_O ) && (CUR_LEVEL >= 3)  && ((gameState == "NORMAL") || (gameState == "INVENTARY") || (gameState == "SHOP"))) {
				if (gameState == "SHOP") {
					if(permissao){
						permissao = false;
						gameState = "NORMAL";
						shop.currentOptionHor = 0;
						shop.currentOptionVert = 0;
						desligarLigarMusica(CUR_LEVEL);
					}
					
				} else
								
				if (gameState == "NORMAL") {
					AudioPlayer.playSound(AudioClip.inventary,2,0);
					gameState = "INVENTARY";
					abaixarAumentarMusica();
					inventary.definirInventario();
				} else if (gameState == "INVENTARY") { 
					AudioPlayer.playSound(AudioClip.exitInventary,2,0);
					gameState = "NORMAL"; 
					abaixarAumentarMusica();
					inventary.currentOptionHor = 0;
					inventary.currentOptionVert = 0;
				}

			}

			
			
			
			if((e.getKeyCode() == KeyEvent.VK_ENTER) && (!messageNPC)) {
				if (gameState == "GAME_OVER") {
				AudioPlayer.playSound(AudioClip.itemSelected,0.5,0);
				this.restartGame = true;				
				} else
				if((gameState == "MENU") && (permissao)) {
					AudioPlayer.playSound(AudioClip.itemSelected,0.5,0);
					menu.enter = true;
				} 
				
				if (gameState == "NORMAL") {
					AudioPlayer.playSound(AudioClip.pause,2,0);
					gameState = "PAUSE";
					abaixarAumentarMusica();
				}
				else
				if (gameState == "PAUSE") {
					AudioPlayer.playSound(AudioClip.itemSelected,0.5,0);
					pause.enter = true;
				} else
					if (gameState == "ENCERRAMENTO") {
						if (sairDoJogo) {					
							System.exit(1);
						}
					}							
				
			}
			

			if((e.getKeyCode() == KeyEvent.VK_U) && (!messageNPC) && ((gameState == "NORMAL") || (gameState == "INVENTARY"))) {
				
				if (gameState == "INVENTARY") {
					itemNaoEncontrado = true;
					for (int i = 0; i < Game.inventary.maxItemsInventario;i++) {
						if ((Game.inventary.itemInventario[i][1] == Game.inventary.currentOptionVert) &&
							(Game.inventary.itemInventario[i][2] == Game.inventary.currentOptionHor)) {
							itemNaoEncontrado = false;
							if ((Game.inventary.itemInventario[i][0] != player.itemEsquerda) &&
								(Game.inventary.itemInventario[i][0] != player.itemDireita)){
								player.itemEsquerda = Game.inventary.itemInventario[i][0];
								player.itemEsquerdaSelecionado = false;
								AudioPlayer.playSound(AudioClip.itemSelected,0.5,0);
								
							} else {
								Game.inventary.posicaoVertSelected = Game.inventary.currentOptionVert;
								Game.inventary.posicaoHorSelected = Game.inventary.currentOptionHor;
								Game.inventary.itemJaSelecionado = true;
								AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
							}
							
							break;
							
						}
					}
					
					if (itemNaoEncontrado) {
						Game.inventary.itemNaoEncontrado = true;
						AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
						itemNaoEncontrado = false;
						
					}
					
					
				} else {
				
					if ((CUR_LEVEL != 2) && (player.itemEsquerda == 0)) {
						Game.phrases.fraseIndex = 0;
						Game.phrases.definirFrases(8);
						Game.phrases.showMessage7 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
					} else 
					if ((CUR_LEVEL == 3) && (player.itemEsquerda == 3)) {
						Game.phrases.fraseIndex = 0;
						Game.phrases.definirFrases(10);
						Game.phrases.showMessage8 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
							
					} else 
						
					if ((CUR_LEVEL == 3) && (player.itemEsquerda == 4)) {
						Game.phrases.fraseIndex = 0;
						Game.phrases.definirFrases(11);
						Game.phrases.showMessage9 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						papelAnalisado = true;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
								
					} else 
						
					if ((CUR_LEVEL == 3) && (player.itemEsquerda == 5)) {
						Game.phrases.fraseIndex = 0;
						Game.phrases.definirFrases(12);
						Game.phrases.showMessage10 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.diarioLido = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
									
					} else 
						if ((CUR_LEVEL == 3) && (player.itemEsquerda == 2)) {
							Game.phrases.fraseIndex = 0;
							Game.phrases.definirFrases(13);
							Game.phrases.showMessage11 = true;
							Game.phrases.showMessage1 = false;
							Game.phrases.showMessage2 = false;
							Game.phrases.showMessage3 = false;
							Game.phrases.showMessage4 = false;
							Game.phrases.showMessage5 = false;
							Game.phrases.showMessage6 = false;
							Game.phrases.showMessage7 = false;
							Game.phrases.showMessage8 = false;
							Game.phrases.showMessage9 = false;
							Game.phrases.showMessage10 = false;
							Game.phrases.showMessage12 = false;
							Game.phrases.showMessage13 = false;
							Game.gameState = "TRAVADO";
							messageNPC = true;
							Game.player.indexHor = 0;
							Game.player.indexVert = 0;
							player.right = false;
							player.up = false;
							player.left = false;
							player.down = false;
										
						} else 
							
							if (((CUR_LEVEL <= 4) || (CUR_LEVEL == 7)) && ((player.itemEsquerda == 6) || (player.itemEsquerda == 7))) {
								Game.phrases.fraseIndex = 0;
								Game.phrases.definirFrases(8);
								Game.phrases.showMessage7 = true;
								Game.phrases.showMessage1 = false;
								Game.phrases.showMessage2 = false;
								Game.phrases.showMessage3 = false;
								Game.phrases.showMessage4 = false;
								Game.phrases.showMessage5 = false;
								Game.phrases.showMessage6 = false;
								Game.phrases.showMessage8 = false;
								Game.phrases.showMessage9 = false;
								Game.phrases.showMessage10 = false;
								Game.phrases.showMessage11 = false;
								Game.phrases.showMessage12 = false;
								Game.phrases.showMessage13 = false;
								Game.gameState = "TRAVADO";
								messageNPC = true;
								Game.player.indexHor = 0;
								Game.player.indexVert = 0;
								player.right = false;
								player.up = false;
								player.left = false;
								player.down = false;
											
							} else 
								if ((CUR_LEVEL == 4) && (player.itemEsquerda == 8)) {
									Game.phrases.fraseIndex = 0;
									Game.phrases.definirFrases(15);
									Game.phrases.showMessage13 = true;
									Game.phrases.showMessage1 = false;
									Game.phrases.showMessage2 = false;
									Game.phrases.showMessage3 = false;
									Game.phrases.showMessage4 = false;
									Game.phrases.showMessage5 = false;
									Game.phrases.showMessage6 = false;
									Game.phrases.showMessage7 = false;
									Game.phrases.showMessage8 = false;
									Game.phrases.showMessage9 = false;
									Game.phrases.showMessage10 = false;
									Game.phrases.showMessage11 = false;
									Game.phrases.showMessage12 = false;
									Game.gameState = "TRAVADO";
									messageNPC = true;
									Game.player.indexHor = 0;
									Game.player.indexVert = 0;
									player.right = false;
									player.up = false;
									player.left = false;
									player.down = false;
												
								} else 
					
					if ((player.itemEsquerda != -1) && (!player.itemEsquerdaSelecionado)) {					
						player.itemEsquerdaSelecionado = true;
						player.itemDireitaSelecionado = false;
						definirSomItemSelected(player.itemEsquerda);
						
					
						
					} else
				
					if ((player.itemEsquerda != -1) && (player.itemEsquerdaSelecionado)) {
						player.itemEsquerdaSelecionado = false;
						definirSomItemDesSelected(player.itemEsquerda);
						
					}
				} 

			}
	
			
			if((e.getKeyCode() == KeyEvent.VK_I) && (!messageNPC) && ((gameState == "NORMAL") || (gameState == "INVENTARY"))) {
				
				if (gameState == "INVENTARY") {
					itemNaoEncontrado = true;
					for (int i = 0; i < Game.inventary.maxItemsInventario;i++) {
						if ((Game.inventary.itemInventario[i][1] == Game.inventary.currentOptionVert) &&
							(Game.inventary.itemInventario[i][2] == Game.inventary.currentOptionHor)) {
							itemNaoEncontrado = false;
							if ((Game.inventary.itemInventario[i][0] != player.itemEsquerda) &&
								(Game.inventary.itemInventario[i][0] != player.itemDireita)){
								player.itemDireita = Game.inventary.itemInventario[i][0];
								player.itemDireitaSelecionado = false;
								AudioPlayer.playSound(AudioClip.itemSelected,0.5,0);
								
							} else {
								Game.inventary.posicaoVertSelected = Game.inventary.currentOptionVert;
								Game.inventary.posicaoHorSelected = Game.inventary.currentOptionHor;
								Game.inventary.itemJaSelecionado = true;
								AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
							}
							break;
							
						}
					}
					
					if (itemNaoEncontrado) {
						Game.inventary.itemNaoEncontrado = true;
						AudioPlayer.playSound(AudioClip.itemNaoPermitido,0.5,0);
						itemNaoEncontrado = false;
						
					}
									
					
				} else {
					
					if ((CUR_LEVEL != 2) && (player.itemDireita == 0)) {
						Game.phrases.definirFrases(8);
						Game.phrases.showMessage7 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
					} else 
						

					if ((CUR_LEVEL == 3) && (player.itemDireita == 3)) {
						Game.phrases.definirFrases(10);
						Game.phrases.showMessage8 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
								
					} else
							
					if ((CUR_LEVEL == 3) && (player.itemDireita == 4)) {
						Game.phrases.definirFrases(11);
						Game.phrases.showMessage9 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						papelAnalisado = true;
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
									
					} else 
							
					if ((CUR_LEVEL == 3) && (player.itemDireita == 5)) {
						Game.phrases.definirFrases(12);
						Game.phrases.showMessage10 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.diarioLido = true;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
										
					} else if ((CUR_LEVEL == 3) && (player.itemDireita == 2)) {
						Game.phrases.definirFrases(13);
						Game.phrases.showMessage11 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
									
					} else if (((CUR_LEVEL <= 4) || (CUR_LEVEL == 7))  && ((player.itemDireita == 6) || (player.itemDireita == 7))) {
						Game.phrases.definirFrases(8);
						Game.phrases.showMessage7 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.showMessage13 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
									
					} else if ((CUR_LEVEL == 4) && (player.itemDireita == 8)) {
						Game.phrases.definirFrases(15);
						Game.phrases.showMessage13 = true;
						Game.phrases.showMessage1 = false;
						Game.phrases.showMessage2 = false;
						Game.phrases.showMessage3 = false;
						Game.phrases.showMessage4 = false;
						Game.phrases.showMessage5 = false;
						Game.phrases.showMessage6 = false;
						Game.phrases.showMessage7 = false;
						Game.phrases.showMessage8 = false;
						Game.phrases.showMessage9 = false;
						Game.phrases.showMessage10 = false;
						Game.phrases.showMessage11 = false;
						Game.phrases.showMessage12 = false;
						Game.phrases.fraseIndex = 0;
						Game.gameState = "TRAVADO";
						messageNPC = true;
						Game.player.indexHor = 0;
						Game.player.indexVert = 0;
						player.right = false;
						player.up = false;
						player.left = false;
						player.down = false;
									
					} else 
				
				
				if ((player.itemDireita != -1) && (!player.itemDireitaSelecionado)) {
					player.itemEsquerdaSelecionado = false;
					player.itemDireitaSelecionado = true;
					definirSomItemSelected(player.itemDireita);
					
						
				} else
					
					
			
				
				if ((player.itemDireita != -1) && (player.itemDireitaSelecionado)) {
					player.itemDireitaSelecionado = false;
					definirSomItemDesSelected(player.itemDireita);
					
						
				}

					
				}
				
				}
			
			if((e.getKeyCode() == KeyEvent.VK_M) && (!messageNPC) && ((gameState == "NORMAL") || (gameState == "MANUAL") || (gameState == "MENU"))) {
				if (gameState == "MENU") {
					AudioPlayer.playSound(AudioClip.enterManual,2,0);
					gameState = "MANUAL";
					abaixarAumentarMusica();
					enterManualnoMenu = true;
				} else
				
				if (gameState == "NORMAL") {
					AudioPlayer.playSound(AudioClip.enterManual,2,0);
					gameState = "MANUAL";
					abaixarAumentarMusica();
				} else
					if (gameState == "MANUAL") {
						AudioPlayer.playSound(AudioClip.exitManual,2,0);
						manual.currentOption = 0;
						if (enterManualnoMenu) {
							gameState = "MENU";
							enterManualnoMenu = false;
						} else {
							gameState = "NORMAL";
						}
						abaixarAumentarMusica();
					}			
			}
			
												
			}
		
				if(e.getKeyCode() == KeyEvent.VK_K) {
					if ((Game.cutscenes.numero != -1) && (!load.chamaCarregamento)) {
						AudioPlayer.playSound(AudioClip.phrases,2,0);
						phrases.fraseIndex = Game.phrases.maxFrases + 1;
						phrases.curIndexMsg = 0;
						cutscenes.fraseTerminada = true;
						estado_cena = Game.comecar;
						gameState = "NORMAL";
						messageNPC = false;
						phrases.showMessage1 = false;
						phrases.showMessage2 = false;
						phrases.showMessage3 = false;
						phrases.showMessage1 = false;
						phrases.showMessage2 = false;
						phrases.showMessage3 = false;
						phrases.showMessage4 = false;
						phrases.showMessage5 = false;
						phrases.showMessage6 = false;
						phrases.showMessage7 = false;
						phrases.showMessage8 = false;
						phrases.showMessage9 = false;
						phrases.showMessage10 = false;
						phrases.showMessage11 = false;
						phrases.showMessage12 = false;
						phrases.showMessage13 = false;
						if (cutscenes.numero == 2) {
							cutscenes.SegundaCutScene = false;
							cutscenes.cutSceneTerminada = true;
							phrases.fraseIndex = -1;
							if ((CUR_LEVEL == 2) && (!chuvaAllowed)) {
								chuvaAllowed = true;
								AudioPlayer.playLoopSoundRain(AudioClip.rain,0.5,4);
							}
						} else
							
							phrases.fraseIndex = 0;
						if (cutscenes.numero == 1) {
							cutscenes.numero = 2;
							cutscenes.SegundaCutScene = true;
						}
					

				}


					if ((phrases.fraseIndex >= 0) && ((phrases.showMessage1) || (phrases.showMessage2) || (phrases.showMessage3)
						|| (phrases.showMessage4) || (phrases.showMessage5) || (phrases.showMessage6)
						|| (phrases.showMessage7) || (phrases.showMessage8) || (phrases.showMessage9)
						|| (phrases.showMessage10) || (phrases.showMessage11) || (phrases.showMessage12) || (phrases.showMessage13)))  {
											
						AudioPlayer.playSound(AudioClip.phrases,2,0);
						messageNPC = true;
						player.indexHor = 0;
						player.indexVert = 0;
						phrases.fraseIndex++;
						
						if (phrases.fraseIndex > 0)
							phrases.fraseIndex = phrases.maxFrases + 1;
						
						if (phrases.fraseIndex >=phrases.maxFrases) {
							phrases.fraseIndex = -1;
							player.right = false;
							player.up = false;
							player.left = false;
							player.down = false;
							phrases.curIndexMsg = 0;
							messageNPC = false;											
							gameState = "NORMAL";
							if ((!phrases.showMessage7) && (!phrases.showMessage8) && (!phrases.showMessage9) && (!phrases.showMessage10) && (!phrases.showMessage11)
									&& (!phrases.showMessage13)) {
								if (phrases.showMessage1)
									phrases.showMessage1 = false;
								if (phrases.showMessage2)
									phrases.showMessage2 = false;
								if (phrases.showMessage3)
									phrases.showMessage3 = false;
								if (phrases.showMessage4)
									phrases.showMessage4 = false;
								if (phrases.showMessage5)
									phrases.showMessage5 = false;
								if (phrases.showMessage6)
									phrases.showMessage6 = false;
								if (phrases.showMessage12)
									phrases.showMessage12 = false;
								for (int i = 0;i < npcs.size();i++) {
								if ((phrases.npcX == npcs.get(i).npcX) &&
								    (phrases.npcY == npcs.get(i).npcY)){
									npcs.get(i).fraseHabilitada = false;
									if (npcs.get(i).tipo == 2) {
										if (npcs.get(i).tipoFrase == 2) {
											objetivo1Completado = true;
											if (CUR_LEVEL == 1) {
												itemsPersonagem.items[0][1] = 1;
												player.itemEsquerda = 0;
												AudioPlayer.playSound(AudioClip.umbrella,2,0);
											}
										}
										
										if ((CUR_LEVEL == 5) && (!objetivo1Completado)) {
											objetivo1Completado = true;
										}
										
										if ((CUR_LEVEL == 5) && (objetivo2Completado) && (!segredo5Encontrado)) {
											segredo5Encontrado = true;
											AudioPlayer.playSound(AudioClip.secret,2,0);
											mensagemJ[1] = false;
										}
										
										if ((npcs.get(i).tipoFrase == -1) && (CUR_LEVEL == 3) && (!objetivo1Completado)  && (wardrobeAnalisado)
												&& ((player.itemEsquerda == 3) || (player.itemDireita == 3))) {
													objetivo1Completado = true;
													itemsPersonagem.items[4][1] = 1;
													AudioPlayer.playSound(AudioClip.papel,2,0);
													itemsPersonagem.items[3][1] = 0;
													if (player.itemEsquerda == 3) {
														player.itemEsquerda = -1;
														player.itemEsquerdaSelecionado = false;
														
													}
													if (player.itemDireita == 3) {
														player.itemDireita = -1;
														player.itemDireitaSelecionado = false;
														
													}
													mensagemJ[1] = false;
										} else
											if ((npcs.get(i).tipoFrase == -1) && (CUR_LEVEL == 3) && (!objetivo1Completado)
													&& (((player.itemEsquerda == 1) 
													&& (player.itemEsquerdaSelecionado)) || ((player.itemDireita == 1) && (player.itemDireitaSelecionado)) || (wardrobeAnalisado)))
													 {
												Game.wardrobeAnalisado = true;
											}
									}
									
									if ((npcs.get(i).tipo == 1) && (CUR_LEVEL == 3) && (diarioLido) && (objetivo4Completado)) {
											objetivo5Completado = true;
										
									}
									
									
									if ((npcs.get(i).tipo == 1) && (CUR_LEVEL == 2)) {
										if (npcs.get(i).tipoFrase == 1) {
											objetivoOpcional1Completado = true;
										}
									}
								
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 2)) {
										if (npcs.get(i).tipoFrase == 1) {
											objetivoOpcional2Completado = true;

										}
									}
									
									if (npcs.get(i).tipo == 5) {
										if (npcs.get(i).tipoFrase == 2) {
											objetivo2Completado = true;
											if (CUR_LEVEL == 1) {
												itemsPersonagem.items[1][1] = 1;
												player.itemDireita = 1;
												AudioPlayer.playSound(AudioClip.monoculo,2,0);
											}
										}
										
										if ((npcs.get(i).tipoFrase == -1) && (CUR_LEVEL == 3) && (puzzle.puzzleResolvido)) {													
													objetivo2Completado = true;
													itemsPersonagem.items[5][1] = 1;
													AudioPlayer.playSound(AudioClip.diario,2,0);
													itemsPersonagem.items[4][1] = 0;
													if (player.itemEsquerda == 4) {
														player.itemEsquerda = -1;
														player.itemEsquerdaSelecionado = false;
														
													}
													if (player.itemDireita == 4) {
														player.itemDireita = -1;
														player.itemDireitaSelecionado = false;
													}
													mensagemJ[2] = false;
										}
										
										
									}
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 3)) {
										objetivo4Completado = true;
									}
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 5) && (!dialogoCompleto) && (permissao)) {								
										gameState = "SHOP";
										permissao = false;
										desligarLigarMusica(CUR_LEVEL);
										dialogoCompleto = true;
										inventary.definirInventario();	
										shop.definirShop();	
										
									} else
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 5) && (dialogoCompleto) && (permissao)) {								
										gameState = "SHOP";
										permissao = false;
										desligarLigarMusica(CUR_LEVEL);
										inventary.definirInventario();	
										shop.definirShop();	
									}
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 4) && (!objetivo1Completado) && (permissao)) {
										objetivo1Completado = true;
										gameState = "SHOP";
										permissao = false;
										desligarLigarMusica(CUR_LEVEL);
										itemsPersonagem.items[6][1] = 1;
										itemsPersonagem.items[7][1] = 1;
										player.ammo =+ 20;
										player.lifeKnife = 100;
										inventary.definirInventario();	
										shop.definirShop();	
									} else
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 4) && (objetivo1Completado) && (permissao)) {
										gameState = "SHOP";
										permissao = false;
										desligarLigarMusica(CUR_LEVEL);
										inventary.definirInventario();	
										shop.definirShop();	
									}
									
									if ((npcs.get(i).tipo == 6) && (CUR_LEVEL == 7) && (permissao)) {
										gameState = "SHOP";
										permissao = false;
										desligarLigarMusica(CUR_LEVEL);
										inventary.definirInventario();	
										shop.definirShop();	
									}
									
									if (npcs.get(i).tipo == 9) {
										if (npcs.get(i).tipoFrase == 2) {
											objetivo3Completado = true;
										}
										if ((npcs.get(i).tipoFrase == -1) && (CUR_LEVEL == 3) 
										&& (Game.player.itemEsquerda == 2) || (Game.player.itemDireita == 2)) {
											portaAberta = true;
											itemsPersonagem.items[2][1] = 0;
											if (player.itemEsquerda == 2) {
												player.itemEsquerda = -1;
												player.itemEsquerdaSelecionado = false;
												
											}
											if (player.itemDireita == 2) {
												player.itemDireita = -1;
												player.itemDireitaSelecionado = false;
											}
											mensagemJ[5] = false;
											
										}
									}
									
									if ((npcs.get(i).tipo == 9) && (CUR_LEVEL == 4) && (!segredo4Encontrado) 
											&& ((player.itemDireita == 8) || (player.itemEsquerda == 8))) {
										segredo4Encontrado = true;
										AudioPlayer.playSound(AudioClip.secret,2,0);
										mensagemJ[5] = false;
										if (player.itemEsquerda == 8) {
											player.itemEsquerda = -1;
											player.itemEsquerdaSelecionado = false;
											
										}
										if (player.itemDireita == 8) {
											player.itemDireita = -1;
											player.itemDireitaSelecionado = false;
										}
										itemsPersonagem.items[8][1] = 0;
										itemsPersonagem.items[8][3] = 0;
									}
									
									
									if ((npcs.get(i).tipo == 14)  && (!Game.segredo3Encontrado) && (CUR_LEVEL == 3) && (diarioLido)) {									
										segredo3Encontrado = true;
										AudioPlayer.playSound(AudioClip.secret,2,0);
										mensagemJ[11] = false;
									}
									
									if ((npcs.get(i).tipo == 14)  && (CUR_LEVEL == 7)) {									
										objetivo1Completado = true;
									}
									
									if ((npcs.get(i).tipo == 7) && (((player.itemDireita == 1) 
											&& (player.itemDireitaSelecionado)) || ((player.itemEsquerda == 1) && (player.itemEsquerdaSelecionado)))
											&& (!segredo1Encontrado) && (CUR_LEVEL == 1)) {
											segredo1Encontrado = true;
											AudioPlayer.playSound(AudioClip.secret,2,0);
											mensagemJ[4] = false;
									} else if ((npcs.get(i).tipo == 7)  && (!segredo2Encontrado) && (CUR_LEVEL == 2)) {
										segredo2Encontrado = true;
										AudioPlayer.playSound(AudioClip.secret,2,0);
										entities.remove(npcs.get(i));
										npcs.remove(npcs.get(i));
										mensagemJ[4] = false;
									} else if ((npcs.get(i).tipo == 7) && (((player.itemDireita == 1) 
											&& (player.itemDireitaSelecionado)) || ((player.itemEsquerda == 1) && (player.itemEsquerdaSelecionado)))
											&& (CUR_LEVEL == 3)) {
										objetivo3Completado = true;
										itemsPersonagem.items[2][1] = 1;
										AudioPlayer.playSound(AudioClip.chave,2,0);								
										mensagemJ[4] = false;
									} 
																			
										
										if (npcs.get(i).tipoFrase != -1)
											npcs.get(i).tipoFrase = 0;
									
									break;
								}
							}
						}
							if (phrases.showMessage7)
								phrases.showMessage7 = false;
							if (phrases.showMessage8)
								phrases.showMessage8 = false;
							if (phrases.showMessage9)
								phrases.showMessage9 = false;
							if (phrases.showMessage10)
								phrases.showMessage10 = false;	
							if (phrases.showMessage11)
								phrases.showMessage11 = false;
							if (phrases.showMessage13)
								phrases.showMessage13 = false;
							
						}else {
							phrases.curIndexMsg = 0;
							gameState = "TRAVADO";
						}
							
					} 
					
					
				}

			
			
			
			if (gameState == "PUZZLE") {
			if(((e.getKeyCode() == KeyEvent.VK_0) || (e.getKeyCode() == KeyEvent.VK_NUMPAD0)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 0;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_1) || (e.getKeyCode() == KeyEvent.VK_NUMPAD1)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 1;
						break;
					}
				}
		
			}

			if(((e.getKeyCode() == KeyEvent.VK_2) || (e.getKeyCode() == KeyEvent.VK_NUMPAD2)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 2;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_3) || (e.getKeyCode() == KeyEvent.VK_NUMPAD3)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 3;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_4) || (e.getKeyCode() == KeyEvent.VK_NUMPAD4)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 4;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_5) || (e.getKeyCode() == KeyEvent.VK_NUMPAD5)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 5;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_6) || (e.getKeyCode() == KeyEvent.VK_NUMPAD6)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 6;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_7) || (e.getKeyCode() == KeyEvent.VK_NUMPAD7)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 7;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_8) || (e.getKeyCode() == KeyEvent.VK_NUMPAD8)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 8;
						break;
					}
				}
		
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_9) || (e.getKeyCode() == KeyEvent.VK_NUMPAD9)) && (!messageNPC) && (gameState == "PUZZLE")) {
				for (int i = 0; i < puzzle.maxValor;i++) {
					if (puzzle.valor[i] == -1) {
						AudioPlayer.playSound(AudioClip.movingInventary,0.5,0);
						puzzle.valor[i] = 9;
						break;
					}
				}
		
			}
			}
		} else {
			if (player.down) {
				player.down = false;
				player.up = false;
				player.left = false;
				player.right = false;
				player.staticLeft = false;
				player.staticRight = false;
				player.staticUp = false;
				player.staticDown = true;
			}
			else
				if (player.up) {
					player.down = false;
					player.up = false;
					player.left = false;
					player.right = false;
					player.staticLeft = false;
					player.staticRight = false;
					player.staticUp = true;
					player.staticDown = false;
				} else
					if (player.left) {
						player.down = false;
						player.up = false;
						player.left = false;
						player.right = false;
						player.staticLeft = true;
						player.staticRight = false;
						player.staticUp = false;
						player.staticDown = false;
					} else
						if (player.right) {
							player.down = false;
							player.up = false;
							player.left = false;
							player.right = false;
							player.staticLeft = false;
							player.staticRight = true;
							player.staticUp = false;
							player.staticDown = false;
						}
		}
		
		
		}
				
			
		
		
		@Override
		public void keyReleased(KeyEvent e) {
			if (Game.permissao) {
			if ((Game.estado_cena == Game.jogando)  && (Game.cutscenes.numero == -1)) {
			if ((gameState == "NORMAL") || (gameState == "PUZZLE") || (gameState == "INVENTARY")
			|| (gameState == "PAUSE") || (gameState == "MANUAL")) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D ) {
				controleRight = player.right;
				controleUp = player.up;
				controleDown = player.down;
				controleLeft = player.left;
				if (gameState == "NORMAL") {
					player.right = false;
					player.staticRight = true;
					player.staticLeft = false;
					player.staticUp = false;
					player.staticDown = false;
				} else {
					if (controleRight) {
						player.right = false;
						player.staticRight = true;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = false;
					} else if (controleUp) {
						player.up = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = true;
						player.staticDown = false;
					} else if (controleDown) {
						player.down = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = true;
					} else if (controleLeft) {
						player.left = false;
						player.staticRight = false;
						player.staticLeft = true;
						player.staticUp = false;
						player.staticDown = false;
					}

				}
				
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
				controleRight = player.right;
				controleUp = player.up;
				controleDown = player.down;
				controleLeft = player.left;
				if (gameState == "NORMAL") {
					player.left = false;
					player.staticLeft = true;
					player.staticRight = false;
					player.staticUp = false;
					player.staticDown = false;
				} else {
					if (controleRight) {
						player.right = false;
						player.staticRight = true;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = false;
					} else if (controleUp) {
						player.up = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = true;
						player.staticDown = false;
					} else if (controleDown) {
						player.down = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = true;
					} else if (controleLeft) {
						player.left = false;
						player.staticRight = false;
						player.staticLeft = true;
						player.staticUp = false;
						player.staticDown = false;
					}

				}

			} else
			
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W ) {
				controleRight = player.right;
				controleUp = player.up;
				controleDown = player.down;
				controleLeft = player.left;
				if (gameState == "NORMAL") {
					player.up = false;
					player.staticRight = false;
					player.staticLeft = false;
					player.staticUp = true;
					player.staticDown = false;
				} else {
					if (controleRight) {
						player.right = false;
						player.staticRight = true;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = false;
					} else if (controleUp) {
						player.up = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = true;
						player.staticDown = false;
					} else if (controleDown) {
						player.down = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = true;
					} else if (controleLeft) {
						player.left = false;
						player.staticRight = false;
						player.staticLeft = true;
						player.staticUp = false;
						player.staticDown = false;
					}

				}
				
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S ) {
				controleRight = player.right;
				controleUp = player.up;
				controleDown = player.down;
				controleLeft = player.left;
				if (gameState == "NORMAL") {
					player.down = false;
					player.staticRight = false;
					player.staticLeft = false;
					player.staticUp = false;
					player.staticDown = true;
				} else {
					if (controleRight) {
						player.right = false;
						player.staticRight = true;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = false;
					} else if (controleUp) {
						player.up = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = true;
						player.staticDown = false;
					} else if (controleDown) {
						player.down = false;
						player.staticRight = false;
						player.staticLeft = false;
						player.staticUp = false;
						player.staticDown = true;
					} else if (controleLeft) {
						player.left = false;
						player.staticRight = false;
						player.staticLeft = true;
						player.staticUp = false;
						player.staticDown = false;
					}

				}
				
			}
			
			 if ((e.getKeyCode() == KeyEvent.VK_J) && (gameState == "NORMAL"))  {
				controleTiroFaca = true;
				
			 }
			
			}
			}
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}
