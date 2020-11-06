package com.gcstudios.world;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.gcstudios.entities.Bigorna;
import com.gcstudios.entities.Bullet;
import com.gcstudios.entities.BulletShoot;
import com.gcstudios.entities.Coin;
import com.gcstudios.entities.Enemy;
import com.gcstudios.entities.Entity;
import com.gcstudios.entities.Items;
import com.gcstudios.entities.Knife;
import com.gcstudios.entities.Life;
import com.gcstudios.entities.Npc;
import com.gcstudios.entities.NpcMovimento;
import com.gcstudios.entities.Phrases;
import com.gcstudios.entities.Player;
import com.gcstudios.entities.Rain;
import com.gcstudios.entities.Shield;
import com.gcstudios.entities.Weapon;
import com.gcstudios.world.Camera;
import com.gcstudios.graficos.Spritesheet;
import com.gcstudios.main.Abertura;
import com.gcstudios.main.AudioClip;
import com.gcstudios.main.AudioPlayer;
import com.gcstudios.main.Ball;
import com.gcstudios.main.Encerramento;
import com.gcstudios.main.Game;
import com.gcstudios.main.GameOver;
import com.gcstudios.main.Inventary;
import com.gcstudios.main.Manual;
import com.gcstudios.main.Menu;
import com.gcstudios.main.Pause;
import com.gcstudios.main.Puzzle;
import com.gcstudios.main.Shop;

public class World {
	private static Tile[] tiles,controleTile;
	public static int WIDTH, HEIGHT;
	private static double life,lifeKnife;
	public static int itemDireita = -1;
	public static int itemDireitaOriginal = -1;
	public static int[][] items = new int[40][4];
	public static int[][] itemsOriginal = new int[40][4];
	public static boolean itemDireitaSelecionado = false;
	public static boolean itemDireitaSelecionadoOriginal = false;
	public static int itemEsquerda = -1;
	public static int itemEsquerdaOriginal = -1;
	public static boolean itemEsquerdaSelecionado = false;
	public static boolean itemEsquerdaSelecionadoOriginal = false;
	public static int shield = 0;
	public static int coin = 0;
	public static int ammo = 0;
	public static int xx1,yy1 = -1;
	private static boolean controle = false;
	public static boolean segredo1Encontrado,segredo2Encontrado, segredo3Encontrado, segredo4Encontrado, segredo5Encontrado,segredo6Encontrado = false;


	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			tiles = new Tile[map.getHeight() * map.getWidth()];
			controleTile = tiles;
			WIDTH =  map.getWidth();
			HEIGHT =  map.getHeight();
			map.getRGB(0,0,map.getWidth(), map.getHeight(),pixels,0,map.getWidth());
			for (int xx = 0;xx < map.getWidth(); xx++) {
				for (int yy = 0;yy < map.getHeight(); yy++) {
					int pixelAtual = pixels[xx + (yy * map.getWidth())]; 
					
					if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
						if ((xx >= 1 ) && (xx <= 11) && (yy >= 1) && (yy <= 10)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR);
						} else if ((xx >= 12 ) && (xx <= 36) && (yy >= 1) && (yy <= 10)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR2);
						}  else if ((xx >= 1 ) && (xx <= 36) && (yy >= 11) && (yy <= 20)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR3);
						}  else if (((xx >= 1 ) && (xx < 25) && (yy >= 21) && (yy <= 33)) || ((xx >= 33) && (xx <= 35) && (yy == 21)) || ((xx >= 25) && (xx <= 36) && (yy >= 22) && (yy <= 33))) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR2);
						}  else if ((xx >= 25 ) && (xx <= 32) && (yy == 21)) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL4);
						} else
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR);
					} else
					
					if (Game.CUR_LEVEL == 2) {
						if ((xx >= 0 ) && (xx <= 39) && (yy == 54)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR7);
						} else if ((xx >= 0 ) && (xx <= 14) && (yy >= 0 ) && (yy <= 7 )) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR8);
						} else
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR4);
					} else
					
					if (Game.CUR_LEVEL == 3) {
						if ((xx >= 9 ) && (xx <= 12) && (yy >= 12) && (yy <= 15)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR3);
						} else if (((xx == 6 ) && (yy == 16)) || ((xx == 11) && (yy == 11)) || ((xx >= 11) && (yy == 0))) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_WALL3);
						}  else if ((xx >= 1 ) && (xx <= 7) && (yy >= 1) && (yy <= 9)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR9);
						} else 
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR10);
							
						}
					if ((Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 6))  {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR13);						
					}
					//0xFF tem que ser colocado antes do código hexadecimal das cores
					if (pixelAtual == 0xFF000000) {
						//Chão 
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR);
						}
						
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR4);
						}
						
						if (Game.CUR_LEVEL == 3) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR9);
						}
						
						if ((Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 6)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR13);
						}
						
						
						
					} else if (pixelAtual == 0xFFFF006E) {
						//Chão
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR2);
						}
						
						if ((Game.CUR_LEVEL == 2) || (Game.CUR_LEVEL == 5)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR5);
						}
						
						if (Game.CUR_LEVEL == 3) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR10);
						}
						
					} else if (pixelAtual == 0xFF7A6744) {
						//Chão
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR8);
						}
						
					} else if (pixelAtual == 0xFF7580B7) {
						//Chão 
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR3);
						}
						
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR6);
						}
						
						if (Game.CUR_LEVEL == 5) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_FLOOR14);
						}
						
						
						
					} else if (pixelAtual == 0xFF8816AA) {
						//Chão
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.EXIT_EN,1);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR7);
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TV2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					} else if (pixelAtual == 0xFF8B14AA) {
						//Chão
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR1_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						if ((Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SOFA2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PORTAO2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
					} else if (pixelAtual == 0xFF8A14A8) {
						//Chão
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}	
						
						if ((Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SOFA_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.PORTAO3_EN,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 6) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.WALL5,98);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
							
					} else if (pixelAtual == 0xFF8A14AA) {
						//Parede
						if (Game.CUR_LEVEL != 2 ) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SOFA3_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						} else {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR3_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						
						}
						
							
						
					} else if (pixelAtual == 0xFF8710A8) {
						//Chão
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR4_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.PORTAO4_EN,14);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 7) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN14_LEVEL7,14);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}

					} else if (pixelAtual == 0xFF8C10A5) {
						//Chão

						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR5_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PORTAO5_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}	
					} else if (pixelAtual == 0xFF9214A8) {
						//Chão
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR6_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}	
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PORTAO6_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}	
					} else if (pixelAtual == 0xFF8F17A8) {
						//Chão
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR7_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PICTURE_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.PORTAO3_EN,7);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						
					} else if (pixelAtual == 0xFF9610A3) {
						//Chão
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR8_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}	
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PICTURE2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.PORTAO4_EN,5);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
					} else if (pixelAtual == 0xFF9214AF) {
						//Chão
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR9_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}				
					} else if (pixelAtual == 0xFF9114AD) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR10_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}				
					} else if (pixelAtual == 0xFF9114AA) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR11_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}				
					} else if (pixelAtual == 0xFF9213A3) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR12_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}				
					} else if (pixelAtual == 0xFF9213A5) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR13_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}				
					} else if (pixelAtual == 0xFF9213A6) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR14_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}				
					} else if (pixelAtual == 0xFF9C13A3) {
						//Chão
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR15_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}				
					}
					 else if (pixelAtual == 0xFFA0139E) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR16_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);	
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF9E129B) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR17_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);	
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF9B1296) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR18_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF991292) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR19_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF99128D) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR20_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF99128B) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR21_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);		
							 item = null;
						 }				
					 }
					 else if (pixelAtual == 0xFF991289) {
					//Chão
					
						 if (Game.CUR_LEVEL == 5) {
							 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR22_EN,0);
							 Game.entities.add(item);
							 Game.items.add(item);	
							 item = null;
						 }				
					}
					 else if (pixelAtual == 0xFF991287) {
							//Chão
							
								 if (Game.CUR_LEVEL == 5) {
									 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR23_EN,0);
									 Game.entities.add(item);
									 Game.items.add(item);	
									 item = null;
								 }				
							}
					 else if (pixelAtual == 0xFF991284) {
							//Chão
							
								 if (Game.CUR_LEVEL == 5) {
									 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR24_EN,0);
									 Game.entities.add(item);
									 Game.items.add(item);		
									 item = null;
								 }				
							}
					 else if (pixelAtual == 0xFF991282) {
							//Chão
							
								 if (Game.CUR_LEVEL == 5) {
									 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR25_EN,0);
									 Game.entities.add(item);
									 Game.items.add(item);	
									 item = null;
								 }				
							}
					 else if (pixelAtual == 0xFF991280) {
							//Chão
							
								 if (Game.CUR_LEVEL == 5) {
									 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR26_EN,0);
									 Game.entities.add(item);
									 Game.items.add(item);	
									 item = null;
								 }				
							}
					 else if (pixelAtual == 0xFF99127E) {
							//Chão
							
								 if (Game.CUR_LEVEL == 5) {
									 Items item = new Items(xx * 10, yy * 16,8,16,Entity.CAR27_EN,0);
									 Game.entities.add(item);
									 Game.items.add(item);	
									 item = null;
								 }				
					}

					else if (pixelAtual == 0xFF8A14AC) {
						//Chão
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SETA_EN,1);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SPECIALTREE1_EN,1);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DEATHBODY2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
					} else if (pixelAtual == 0xFFFF7200) {
						//Parede 
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CHAIR_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SPECIALTREE2_EN,1);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						
					} else if (pixelAtual == 0xFFFFBCBC) {
						//Parede 
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CHAIR_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SPECIALTREE2_EN,1);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
					}  else if (pixelAtual == 0xFF9987FF) {
						//Parede 
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.SPECIALTREE3_EN,1);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DEATHBODY_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
					} else if (pixelAtual == 0xFFFFFFFF) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 7))  {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL);					
						}
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_FLOOR4);					
						}
						if (Game.CUR_LEVEL == 3) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL3);					
						}
						
						if ((Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 6))  {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL5);					
						}
					} else if (pixelAtual == 0xFF9187FF) {
						//Parede
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL2);	
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.GELADEIRA_EN,0);
							Game.entities.add(item);
							Game.items.add(item);	
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALL6);	
						}
						
						
						if (Game.CUR_LEVEL == 7) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}

					}else if (pixelAtual == 0xFF00FF3F) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFF00FF48) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WINDOW);					
								
						}
						
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.ARMARIO_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
								
						}
					}else if (pixelAtual == 0xFF00FF50) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK3_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_HOUSE);					
								
						}
					}else if (pixelAtual == 0xFF00FF59) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK4_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK11_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 5) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_FLOOR6);
						}
					}else if (pixelAtual == 0xFF00FF5D) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK5_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK12_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFF00FF61) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK6_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CHAIR3_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.ENGINE1_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFF09FBFF) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK7_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.CHAIR2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_FLOOR5);
						}
					}else if (pixelAtual == 0xFF09FBFA) {
						//Parede
						Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK8_EN,0);
						Game.entities.add(item);
						Game.items.add(item);
						item = null;
					}else if (pixelAtual == 0xFF09FBF2) {
						//Parede
						Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK9_EN,0);
						Game.entities.add(item);
						Game.items.add(item);
						item = null;
					}else if (pixelAtual == 0xFFFF7FB3) {
						//Parede
						Items item = new Items(xx * 10, yy * 16,8,16,Entity.DESK10_EN,0);
						Game.entities.add(item);
						Game.items.add(item);
						item = null;
					}else if (pixelAtual == 0xFFFFC8C8) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.LOCKER_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TREE2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFFFFCCC9) {
						//Parede
						if (Game.CUR_LEVEL == 4) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.LOCKER2_EN,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
					}else if (pixelAtual == 0xFF21007F) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7) ) {
							tiles[xx + (yy * WIDTH)] = new WallExit(xx * 10, yy * 16,Tile.TILE_WALLEXIT);
						}
						
						if ((Game.CUR_LEVEL == 2) || (Game.CUR_LEVEL == 5)) {
							tiles[xx + (yy * WIDTH)] = new WallExit(xx * 10, yy * 16,Tile.TILE_WALLEXIT2);
						}
					 }else if (pixelAtual == 0xFF005905) {
							//Parede
							if (Game.CUR_LEVEL == 1) {
								tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_WALLEXIT);
							}

					} else if (pixelAtual == 0xFFFF7700) {
						//Parede
						Items item = new Items(xx * 10, yy * 16,8,16,Entity.WARDROBE_EN,0);
						Game.entities.add(item);
						Game.items.add(item);
						item = null;
					}else if (pixelAtual == 0xFFFF8300) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 3) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TREE_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TREE_EN_LEVEL2,3);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFFFF9D00) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TREE2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.MURO_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.BED_EN,14);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PORTAO1_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFF7F857F) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_LETTER_M);	
						}
						
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_DOOR);	
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TOILET_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}else if (pixelAtual == 0xFF0F857F) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 2) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)  ) {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_DOOR2);	
						}
					}else if (pixelAtual == 0xFF7F8580) {
						//Parede
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_LETTER_F);
						}
						if (Game.CUR_LEVEL == 2) {
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 10, yy * 16,Tile.POCA_EN);
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.BED2_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.PNEU_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}

					}else if (pixelAtual == 0xFF000FFF) {
						//Parede
						if (Game.CUR_LEVEL != 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.DOOR_EN,3);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN9_LEVEL3,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
					}
					 else if (pixelAtual == 0xFF0026FF) {
						//Player
						Game.player.setX(xx * 10);
						Game.player.setY(yy * 16);
												
					}
					 else if (pixelAtual == 0xFF007F46) {
						//
						if (Game.CUR_LEVEL == 1)  {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN,1);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN_LEVEL2,1);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN_LEVEL3,1);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN_LEVEL4,1);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
					 
					
					 } else if (pixelAtual == 0xFF005607) {
					 //
						 tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_GLASS);
						
				     }
					
				     else if (pixelAtual == 0xFF005408) {
					 //
				    	 tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_GLASS2);
						
				     }
					
				     else if (pixelAtual == 0xFF00510C) {
						 //
				    	 tiles[xx + (yy * WIDTH)] = new WallTile(xx * 10, yy * 16,Tile.TILE_GLASS3);
							
					  }
					
				     else if (pixelAtual == 0xFF004F09) {
						 //
					    	 Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN6,94);
					    	 Game.entities.add(npc);
					    	 Game.npcs.add(npc);
					    	 npc = null;
							
					  }

					 else if (pixelAtual == 0xFFFF0000) {
						
						Enemy en = new Enemy(xx * 10, yy * 16,10,16,Entity.ENEMY_EN,0);
						Game.entities.add(en);
						Game.enemies.add(en);
						en = null;
					 }else if (pixelAtual == 0xFFFF1000) {
							
						Enemy en = new Enemy(xx * 10, yy * 16,10,16,Entity.ENEMY_EN,2);
						Game.entities.add(en);
						Game.enemies.add(en);
						en = null;
					}else if (pixelAtual == 0xFFFF0C00) {
							
						Enemy en = new Enemy(xx * 10, yy * 16,10,16,Entity.ENEMY_EN,1);
						Game.entities.add(en);
						Game.enemies.add(en);
						en = null;
					}else if (pixelAtual == 0xFFFF1200) {
						
						Enemy en = new Enemy(xx * 10, yy * 16,10,16,Entity.ENEMY_EN,3);
						Game.entities.add(en);
						Game.enemies.add(en);
						en = null;
					} else if (pixelAtual == 0xFFA17FFF) {
						Game.entities.add(new Weapon(xx * 10, yy * 16,10,16,Entity.GUN_EN,0));
					} else if (pixelAtual == 0xFFFFB27F) {
						Game.entities.add(new Life(xx * 10, yy * 16,10,16,Entity.LIFEPACK_EN,0));
					} else if (pixelAtual == 0xFF00FFFF) {
						Game.entities.add(new Knife(xx * 10, yy * 16,10,16,Entity.KNIFE_EN,0));
					} else if (pixelAtual == 0xFF7F0037) {
						Game.entities.add(new Bullet(xx * 10, yy * 16,3,8,Entity.BULLET_EN,0));
					} else if (pixelAtual == 0xFF0094FF) {
						Game.entities.add(new Shield(xx * 10, yy * 16,10,16,Entity.SHIELD_EN,0));
					} else if (pixelAtual == 0xFF0090FF) {
						Game.entities.add(new Bigorna(xx * 10, yy * 16,10,16,Entity.BIGORNA_EN,0));
					} else if (pixelAtual == 0xFF008CFF) {
						Game.entities.add(new Coin(xx * 10, yy * 16,10,16,Entity.COIN_EN,0));
					} else if (pixelAtual == 0xFF004E00) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN2,2);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN2_LEVEL2,2);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN2_LEVEL3,2);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 5) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN2_LEVEL5,2);
							Game.entities.add(npc);
							Game.npcs.add(npc);
							npc = null;
						}
					} else if (pixelAtual == 0xFF004C01) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN3,5);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN3_LEVEL2,5);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN3_LEVEL3,5);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
					} else if (pixelAtual == 0xFF004903) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 5) || (Game.CUR_LEVEL == 7)) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN4,6);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN4_LEVEL2,6);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN4_LEVEL3,6);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
					} else if (pixelAtual == 0xFF0B630B) {
						if (Game.CUR_LEVEL == 1) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN5,7);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN5_LEVEL2,7);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN5_LEVEL3,7);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN5_LEVEL4,7);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
					} else if (pixelAtual == 0xFF005B00) {
						if (Game.CUR_LEVEL == 2) {
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN9_LEVEL2,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if (Game.CUR_LEVEL == 3 ) {
							
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.NPC_EN9_LEVEL3,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
						
						if ((Game.CUR_LEVEL == 4 ) || (Game.CUR_LEVEL == 7)) {
							
							Npc npc = new Npc(xx * 10, yy * 16,8,16,Entity.LOCKER2_EN,9);
							Game.entities.add(npc);
							Game.npcs.add(npc);	
							npc = null;
						}
					} else if (pixelAtual == 0xFFFF7FED) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV1_EN,1);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
						if (Game.CUR_LEVEL == 2) {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV4_EN,1);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
						if (Game.CUR_LEVEL == 3) {
							Items item = new Items(xx * 10, yy * 16,8,16,Entity.TV_EN,0);
							Game.entities.add(item);
							Game.items.add(item);
							item = null;
						}
					}  else if (pixelAtual == 0xFFFF6DEB) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))  {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV2_EN,2);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
						if (Game.CUR_LEVEL == 2) {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV4_EN,2);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
					}  else if (pixelAtual == 0xFFFFA3F2) {
						if ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV3_EN,3);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
						if (Game.CUR_LEVEL == 2) {
							NpcMovimento npcMov = new NpcMovimento(xx * 10, yy * 16,9,16,Entity.NPCMOV4_EN,3);
							Game.entities.add(npcMov);
							Game.npcMovi.add(npcMov);
							npcMov = null;
						}
					}
									
					
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean isFree (int xnext, int ynext,int tipo) {
		
		int x1 = 0;
		int y1 = 0;
	
		int x2 = 0;
		int y2 = 0;
	
		int x3 = 0;
		int y3 = 0;
	
		int x4 = 0;
		int y4 = 0;
		
		if (tipo == 0) {
			x1 = xnext/ 10;
			y1 = ynext/ 16;
		
			x2 = (xnext+ 10 - 1) / 10;
			y2 = ynext/ 16;
		
			x3 = xnext/ 10;
			y3 = (ynext+ 16 - 1)/16;
		
			x4 = (xnext+ 10 - 1) / 10;
			y4 = (ynext+ 16 - 1)/ 16;
		} else
			
			if (tipo == 1) {
				x1 = xnext/ 10;
				y1 = ynext/ 16;
			
				x2 = (xnext+ 3 - 1) / 10;
				y2 = ynext/ 16;
			
				x3 = xnext/ 10;
				y3 = (ynext+ 3 - 1)/16;
			
				x4 = (xnext+ 3 - 1) / 10;
				y4 = (ynext+ 3 - 1)/ 16;
			}  else
				
				if (tipo == 2) {
					x1 = xnext/ 10;
					y1 = ynext/ 16;
				
					x2 = (xnext+ 4 - 1) / 10;
					y2 = ynext/ 16;
				
					x3 = xnext/ 10;
					y3 = (ynext+ 4 - 1)/16;
				
					x4 = (xnext+ 4 - 1) / 10;
					y4 = (ynext+ 4 - 1)/ 16;
				} else if (tipo == 3) {
					x1 = xnext/ 10;
					y1 = ynext/ 16;
				
					x2 = (xnext+ 4 - 1) / 10;
					y2 = ynext/ 16;
				
					x3 = xnext/ 10;
					y3 = (ynext+ 4 - 1)/16;
				
					x4 = (xnext+ 4 - 1) / 10;
					y4 = (ynext+ 4 - 1)/ 16;
				}
		
		
		
		if ((tipo == 0) && (Game.levelConcluido) &&
		   (((tiles[x1 + (y1 * World.WIDTH)] instanceof WallExit) ||
		   (tiles[x2 + (y2 * World.WIDTH)] instanceof WallExit) ||
		   (tiles[x3 + (y3 * World.WIDTH)] instanceof WallExit) ||
		   (tiles[x4 + (y4 * World.WIDTH)] instanceof WallExit)))) {
			
			Game.saidaAlcancada = true;
			
		}
		
			
			
			
		return !((tiles[x1 + (y1 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2 * World.WIDTH)] instanceof WallTile) ||
			    (tiles[x3 + (y3 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x1 + (y1 * World.WIDTH)] instanceof WallExit) ||
				(tiles[x2 + (y2 * World.WIDTH)] instanceof WallExit) ||
				(tiles[x3 + (y3 * World.WIDTH)] instanceof WallExit) ||
				(tiles[x4 + (y4 * World.WIDTH)] instanceof WallExit));
		
	}
	
	
public static boolean verificaErroBola (int xnext, int ynext) {
		
		int x1 = 0;
		int y1 = 0;
	
		int x2 = 0;
		int y2 = 0;
	
		int x3 = 0;
		int y3 = 0;
	
		int x4 = 0;
		int y4 = 0;
		
		x1 = xnext/ 10;
		y1 = ynext/ 16;
				
		x2 = (xnext+ 4 - 1) / 10;
		y2 = ynext/ 16;
				
		x3 = xnext/ 10;
		y3 = (ynext+ 4 - 1)/16;
				
		x4 = (xnext+ 4 - 1) / 10;
		y4 = (ynext+ 4 - 1)/ 16;
						
		if ((x1 + (y1 * World.WIDTH) > (World.HEIGHT * World.WIDTH)) || 
				(x2 + (y2 * World.WIDTH) > (World.HEIGHT * World.WIDTH)) ||  
				(x3 + (y3 * World.WIDTH) > (World.HEIGHT * World.WIDTH)) || 
				(x4 + (y4 * World.WIDTH) > (World.HEIGHT * World.WIDTH))) {
			
			return true;

			
		} else
			return false;
		
	}
	
	public static void restartGame(String level){
		life = Game.player.life;
		lifeKnife = Game.player.lifeKnife;
		itemDireita = Game.player.itemDireita;
		itemEsquerda = Game.player.itemEsquerda;
		itemDireitaSelecionado = Game.player.itemDireitaSelecionado;
		itemEsquerdaSelecionado = Game.player.itemEsquerdaSelecionado;
		shield = Game.player.shield;
		coin = Game.player.coin;
		ammo = Game.player.ammo;
		segredo1Encontrado  = Game.segredo1Encontrado;
		segredo2Encontrado  = Game.segredo2Encontrado;
		segredo3Encontrado  = Game.segredo3Encontrado;
		segredo4Encontrado  = Game.segredo4Encontrado;
		segredo5Encontrado  = Game.segredo5Encontrado;
		segredo6Encontrado  = Game.segredo6Encontrado;
		
		for(int i = 0; i < Game.itemsPersonagem.maxItemsInventario; i++) {
			for(int j = 0; j < 4; j++) {
				items[i][j] = Game.itemsPersonagem.items[i][j];
			}
		}
		
			
		for(int i = 0; i < Game.enemies.size(); i++) {
			Game.enemies.get(i).enemy = 0;
		}
		
		for (int i = 0;i < Game.mensagemJ.length;i++) {
			Game.mensagemJ[i] = false;
				
		}
		Game.entities.clear();
		Game.enemies.clear();
		Game.ball.clear();
		Game.rain.clear();
		Game.items.clear();
		Game.npcs.clear();
		Game.bullets.clear();
		Game.npcMovi.clear();
		Game.coinTela = null;
		Game.menu = null;
		Game.pause = null;
		Game.puzzle = null;
		Game.inventary = null;
		Game.shop = null;
		Game.manual = null;
		Game.gameOver = null;
		Game.phrases = null;
		Game.messageNPC = false;
		Game.levelConcluido = false;
		Game.saidaAlcancada = false;
		Game.objetivo1Completado = false;
		Game.objetivo2Completado = false;
		Game.objetivo3Completado = false;
		Game.objetivo4Completado = false;
		Game.objetivo5Completado = false;
		Game.evitarErro = false;
		Game.primeiroLoad = false;
		Game.chuvaAllowed = false;
		Game.bossDerrotado = false;
		Game.logicaPermitidaBoss = false;
		Game.wardrobeAnalisado = false;	
		Game.player.attack = false;
		Game.player.shoot = false;
		Game.player.attackknife = false;	
		Game.portaAberta = false;		
		Game.papelAnalisado = false;
		Game.diarioLido = false;
		Game.objetivoLiberado = false;
		Game.load.chamaCarregamento = false;
		Game.load.fimCarregamento = false;
		Game.controle2 = true;
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.items = new ArrayList<Items>();
		Game.npcs = new ArrayList<Npc>();
		Game.rain = new ArrayList<Rain>();
		Game.bullets = new ArrayList<BulletShoot>();
		Game.npcMovi = new ArrayList<NpcMovimento>();
		Game.ball = new ArrayList<Ball>();
		Game.menu = new Menu();
		Game.pause = new Pause();
		Game.puzzle = new Puzzle();
		Game.abertura = new Abertura();
		Game.encerramento = new Encerramento();
		Game.inventary = new Inventary();
		Game.shop = new Shop();
		Game.manual = new Manual();
		Game.gameOver = new GameOver();
		Game.phrases = new Phrases();
		Game.phrases.fraseIndex = 0;
		Game.spritesheet = new Spritesheet("/Trap.png");
		Game.player = new Player(60,108,9,16,Game.spritesheet.getSprite(60, 108, 9, 16),0);
		Game.entities.add(Game.player);
		Game.player.life = life;
		Game.player.lifeKnife = lifeKnife;
		Game.player.itemDireita = itemDireita;
		Game.player.itemEsquerda = itemEsquerda;
		Game.player.itemDireitaSelecionado = itemDireitaSelecionado;
		Game.player.itemEsquerdaSelecionado = itemEsquerdaSelecionado;
		Game.player.shield = shield;
		Game.player.ammo = ammo;
		Game.player.coin = coin;
		Game.segredo1Encontrado = segredo1Encontrado;
		Game.segredo2Encontrado = segredo2Encontrado;
		Game.segredo3Encontrado = segredo3Encontrado;
		Game.segredo4Encontrado = segredo4Encontrado;
		Game.segredo5Encontrado = segredo5Encontrado;
		Game.segredo6Encontrado = segredo6Encontrado;
		
		for(int i = 0; i < Game.itemsPersonagem.maxItemsInventario; i++) {
			for(int j = 0; j < 4; j++) {
				Game.itemsPersonagem.items[i][j] = items[i][j];
				Game.itemsPersonagem.itemsOrigLevel[i][j] = items[i][j];
			}
		}
		
		Game.player.lifeOriginalLevel = Game.player.life;
		Game.player.lifeKnifeOriginalLevel = Game.player.lifeKnife;
		Game.player.itemDireitaOriginal = Game.player.itemDireita;
		Game.player.itemEsquerdaOriginal = Game.player.itemEsquerda;
		Game.player.itemDireitaSelecionadoOriginal = Game.player.itemDireitaSelecionado;
		Game.player.itemEsquerdaSelecionadoOriginal = Game.player.itemEsquerdaSelecionado;
		Game.player.shieldOriginalLevel = Game.player.shield;
		Game.player.ammoOriginalLevel = Game.player.ammo;
		Game.player.coinOriginalLevel = Game.player.coin;
		Game.segredo1EncontradoOriginalLevel  = Game.segredo1Encontrado;
		Game.segredo2EncontradoOriginalLevel  = Game.segredo2Encontrado;
		Game.segredo3EncontradoOriginalLevel  = Game.segredo3Encontrado;
		Game.segredo4EncontradoOriginalLevel  = Game.segredo4Encontrado;
		Game.segredo5EncontradoOriginalLevel  = Game.segredo5Encontrado;
		Game.segredo6EncontradoOriginalLevel  = Game.segredo6Encontrado;
		Game.controleMusic = true;
		Game.tickPermitido = false;
		Game.coinTela = new BufferedImage[5];
		for (int i = 0;i < 5;i++) {
			Game.coinTela[i] = Game.spritesheet.getSprite(0 + (i * 19), 1508, 18, 18);

		}
		Camera.definirCameraInicio();
		
		if (Game.CUR_LEVEL == 1) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);
		} else
		
		if (Game.CUR_LEVEL == 2) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerdaSelecionado = true;
			Game.player.itemDireitaSelecionado = false;
			AudioPlayer.playLoopSound(AudioClip.condominio,1.5,1);		
		} else
		
		if (Game.CUR_LEVEL == 3) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 2;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			Game.itemsPersonagem.items[3][1] = 1;
			AudioPlayer.playLoopSound(AudioClip.cenaCrime,1.5,1);	

		} else
		
		if (Game.CUR_LEVEL == 4) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			if (Game.player.itemEsquerda == 5)
				Game.player.itemEsquerda = -1;
			
			if (Game.player.itemDireita == 5)
				Game.player.itemDireita = -1;
			
			Game.itemsPersonagem.items[5][1] = 0;
			Game.player.dir = 3;
			AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);

		} else
		
		if (Game.CUR_LEVEL == 5) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 2;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			if (Game.player.itemEsquerda == 8)
				Game.player.itemEsquerda = -1;
			
			if (Game.player.itemDireita == 8)
				Game.player.itemDireita = -1;
			
			Game.itemsPersonagem.items[8][1] = 0;
			Game.itemsPersonagem.items[8][2] = 0;
			Game.itemsPersonagem.items[8][3] = 0;
			Game.player.dir = 0;
			AudioPlayer.playLoopSound(AudioClip.oficina2,1.5,1);

		} else
		
		if (Game.CUR_LEVEL == 6) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 2;			
			Game.player.dir = 2;


		} else
		
		if (Game.CUR_LEVEL == 7) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.itemsPersonagem.items[13][3] = 1;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			Game.player.dir = 2;
			AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);

		}
		Game.world = new World("/"+level);
		return;
	}
	
	public static void restartFromGameOver(String level){
		if (Game.CUR_LEVEL == 1) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			//AudioPlayer.playSound(AudioClip.delegacia,1.5,2);
		} else
		
		if (Game.CUR_LEVEL == 2) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerdaSelecionado = true;
			//AudioPlayer.playSound(AudioClip.condominio,1.5,2);
			//AudioPlayer.playSound(AudioClip.rain,1.5,1);

		} else
		if (Game.CUR_LEVEL == 3) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 2;
			Game.player.itemEsquerdaSelecionado = false;
			Game.itemsPersonagem.items[3][1] = 1;
			//AudioPlayer.playSound(AudioClip.cenaCrime,1.5,2);

		} else
		if (Game.CUR_LEVEL == 4) {
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			if (Game.player.itemEsquerda == 5)
				Game.player.itemEsquerda = -1;
			
			if (Game.player.itemDireita == 5)
				Game.player.itemDireita = -1;
			
			Game.itemsPersonagem.items[5][1] = 0;
			//AudioPlayer.playSound(AudioClip.delegacia,1.5,2);

		} else
			if (Game.CUR_LEVEL == 5) {
				Game.estado_cena = Game.cutScene;
				Game.cutscenes.numero = 2;
				Game.player.itemEsquerdaSelecionado = false;
				Game.player.itemDireitaSelecionado = false;
				if (Game.player.itemEsquerda == 8)
					Game.player.itemEsquerda = -1;
				
				if (Game.player.itemDireita == 8)
					Game.player.itemDireita = -1;
				
				Game.itemsPersonagem.items[8][1] = 0;
				Game.itemsPersonagem.items[8][2] = 0;
				Game.itemsPersonagem.items[8][3] = 0;
				Game.player.dir = 0;
				//Sound.oficina.stop();
			} else
				if (Game.CUR_LEVEL == 6) {
					Game.estado_cena = Game.cutScene;
					Game.cutscenes.numero = 2;			
					Game.player.dir = 2;
					Game.rodarBoss = true;
				//	Sound.boss.stop();

				} else
					if (Game.CUR_LEVEL == 7) {
						Game.estado_cena = Game.cutScene;
						Game.cutscenes.numero = 1;
						Game.itemsPersonagem.items[13][3] = 1;
						Game.player.itemEsquerdaSelecionado = false;
						Game.player.itemDireitaSelecionado = false;
						Game.player.dir = 2;
						//AudioPlayer.playSound(AudioClip.delegacia,1.5,2);

					}
		
		for(int i = 0; i < Game.enemies.size(); i++) {
			Game.enemies.get(i).enemy = 0;
		}
		for (int i = 0;i < Game.mensagemJ.length;i++) {
			Game.mensagemJ[i] = false;
				
		}
		life = Game.player.lifeOriginalLevel;
		lifeKnife = Game.player.lifeKnifeOriginalLevel;
		itemDireita = Game.player.itemDireitaOriginal;
		itemEsquerda = Game.player.itemEsquerdaOriginal;
		itemDireitaSelecionado = Game.player.itemDireitaSelecionadoOriginal;
		itemEsquerdaSelecionado = Game.player.itemEsquerdaSelecionadoOriginal;
		shield = Game.player.shieldOriginalLevel;
		ammo = Game.player.ammoOriginalLevel;
		coin = Game.player.coinOriginalLevel;
		segredo1Encontrado  = Game.segredo1EncontradoOriginalLevel;
		segredo2Encontrado  = Game.segredo2EncontradoOriginalLevel;
		segredo3Encontrado  = Game.segredo3EncontradoOriginalLevel;
		segredo4Encontrado  = Game.segredo4EncontradoOriginalLevel;
		segredo5Encontrado  = Game.segredo5EncontradoOriginalLevel;
		segredo6Encontrado  = Game.segredo6EncontradoOriginalLevel;
		
		for(int i = 0; i < Game.itemsPersonagem.maxItemsInventario; i++) {
			for(int j = 0; j < 4; j++) {
				items[i][j] = Game.itemsPersonagem.itemsOrigLevel[i][j];
			}
		}
		
		Game.entities.clear();
		Game.ball.clear();
		Game.enemies.clear();
		Game.rain.clear();
		Game.items.clear();
		Game.npcs.clear();
		Game.npcMovi.clear();
		Game.bullets.clear();
		Game.menu = null;
		Game.coinTela = null;
		Game.pause = null;
		Game.puzzle = null;
		Game.inventary = null;
		Game.shop = null;
		Game.manual = null;
		Game.gameOver = null;
		Game.phrases = null;
		Game.messageNPC = false;
		Game.levelConcluido = false;
		Game.saidaAlcancada = false;
		Game.objetivo1Completado = false;
		Game.objetivo2Completado = false;
		Game.objetivo3Completado = false;
		Game.objetivo4Completado = false;
		Game.objetivo5Completado = false;
		Game.evitarErro = false;
		Game.chuvaAllowed = false;
		Game.wardrobeAnalisado = false;	
		Game.player.attack = false;
		Game.player.shoot = false;
		Game.player.attackknife = false;
		Game.bossDerrotado = false;
		Game.logicaPermitidaBoss = false;
		Game.portaAberta = false;		
		Game.papelAnalisado = false;
		Game.diarioLido = false;
		Game.objetivoLiberado = false;
		Game.controle2 = true;
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.items = new ArrayList<Items>();
		Game.npcs = new ArrayList<Npc>();
		Game.rain = new ArrayList<Rain>();
		Game.bullets = new ArrayList<BulletShoot>();
		Game.npcMovi = new ArrayList<NpcMovimento>();
		Game.ball = new ArrayList<Ball>();
		Game.menu = new Menu();
		Game.pause = new Pause();
		Game.puzzle = new Puzzle();
		Game.inventary = new Inventary();
		Game.shop = new Shop();
		Game.manual = new Manual();
		Game.abertura = new Abertura();
		Game.encerramento = new Encerramento();
		Game.gameOver = new GameOver();
		Game.phrases = new Phrases();
		Game.phrases.fraseIndex = 0;
		Game.spritesheet = new Spritesheet("/Trap.png");
		Game.player = new Player(60,108,9,16,Game.spritesheet.getSprite(60, 108, 9, 16),0);
		Game.entities.add(Game.player);
		Game.load.chamaCarregamento = true;
		Game.load.fimCarregamento = false;
		Game.player.life = life;
		Game.player.lifeKnife = lifeKnife;
		Game.player.itemDireita = itemDireita;
		Game.player.itemEsquerda = itemEsquerda;
		Game.player.itemDireitaSelecionado = itemDireitaSelecionado;
		Game.player.itemEsquerdaSelecionado = itemEsquerdaSelecionado;
		Game.player.shield = shield;
		Game.player.ammo = ammo;
		Game.player.coin = coin;
		Game.segredo1Encontrado = segredo1Encontrado;
		Game.segredo2Encontrado = segredo2Encontrado;
		Game.segredo3Encontrado = segredo3Encontrado;
		Game.segredo4Encontrado = segredo4Encontrado;
		Game.segredo5Encontrado = segredo5Encontrado;
		Game.segredo6Encontrado = segredo6Encontrado;
		Game.player.lifeOriginalLevel = life;
		Game.player.lifeKnifeOriginalLevel = lifeKnife;
		Game.player.itemDireitaOriginal = itemDireita;
		Game.player.itemEsquerdaOriginal = itemEsquerda;
		Game.player.itemDireitaSelecionadoOriginal = itemDireitaSelecionado;
		Game.player.itemEsquerdaSelecionadoOriginal = itemEsquerdaSelecionado ;
		Game.player.shieldOriginalLevel = shield;
		Game.player.ammoOriginalLevel = ammo;
		Game.player.coinOriginalLevel = coin;
		Game.segredo1EncontradoOriginalLevel = segredo1Encontrado;
		Game.segredo2EncontradoOriginalLevel = segredo2Encontrado;
		Game.segredo3EncontradoOriginalLevel = segredo3Encontrado;
		Game.segredo4EncontradoOriginalLevel = segredo4Encontrado;
		Game.segredo5EncontradoOriginalLevel = segredo5Encontrado;
		Game.segredo6EncontradoOriginalLevel = segredo6Encontrado;
		Game.primeiroLoad = true;
		
		for(int i = 0; i < Game.itemsPersonagem.maxItemsInventario; i++) {
			for(int j = 0; j < 4; j++) {
				Game.itemsPersonagem.items[i][j] = items[i][j];
				Game.itemsPersonagem.itemsOrigLevel[i][j] = items[i][j];
			}
		}
		
		
		Game.controleMusic = true;
		Game.tickPermitido = false;
		Game.coinTela = new BufferedImage[5];
		for (int i = 0;i < 5;i++) {
			Game.coinTela[i] = Game.spritesheet.getSprite(0 + (i * 19), 1508, 18, 18);

		}
		Camera.definirCameraInicio();
		if (Game.CUR_LEVEL == 1) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);
		} else
		
		if (Game.CUR_LEVEL == 2) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerda = 0;
			Game.player.itemEsquerdaSelecionado = true;
			AudioPlayer.playLoopSound(AudioClip.condominio,1.5,1);

		} else
		if (Game.CUR_LEVEL == 3) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 2;
			Game.player.itemEsquerdaSelecionado = false;
			Game.itemsPersonagem.items[3][1] = 1;
			AudioPlayer.playLoopSound(AudioClip.cenaCrime,1.5,1);

		} else
		if (Game.CUR_LEVEL == 4) {
			Game.permissao = false;
			Game.estado_cena = Game.cutScene;
			Game.cutscenes.numero = 1;
			Game.player.itemEsquerdaSelecionado = false;
			Game.player.itemDireitaSelecionado = false;
			if (Game.player.itemEsquerda == 5)
				Game.player.itemEsquerda = -1;
			
			if (Game.player.itemDireita == 5)
				Game.player.itemDireita = -1;
			
			Game.itemsPersonagem.items[5][1] = 0;
			AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);

		} else
			if (Game.CUR_LEVEL == 5) {
				Game.estado_cena = Game.cutScene;
				Game.cutscenes.numero = 2;
				Game.player.itemEsquerdaSelecionado = false;
				Game.player.itemDireitaSelecionado = false;
				if (Game.player.itemEsquerda == 8)
					Game.player.itemEsquerda = -1;
				
				if (Game.player.itemDireita == 8)
					Game.player.itemDireita = -1;
				
				Game.itemsPersonagem.items[8][1] = 0;
				Game.itemsPersonagem.items[8][2] = 0;
				Game.itemsPersonagem.items[8][3] = 0;
				Game.player.dir = 0;
				AudioPlayer.playLoopSound(AudioClip.oficina2,1.5,1);

			} else
				if (Game.CUR_LEVEL == 6) {
					Game.estado_cena = Game.cutScene;
					Game.cutscenes.numero = 2;			
					Game.player.dir = 2;
					Game.rodarBoss = true;

				} else 
					if (Game.CUR_LEVEL == 7) {
						Game.permissao = false;
						Game.estado_cena = Game.cutScene;
						Game.cutscenes.numero = 1;
						Game.itemsPersonagem.items[13][3] = 1;
						Game.player.itemEsquerdaSelecionado = false;
						Game.player.itemDireitaSelecionado = false;
						Game.player.dir = 2;
						AudioPlayer.playLoopSound(AudioClip.delegacia,1.5,1);

					}

		Game.world = new World("/"+level);
		
		return;
	}
			
	
	public void render(Graphics g) {
		int xstart = Camera.x/10;
		int ystart = Camera.y/16;
		
		int xfinal = xstart + (Game.WIDTH / 10);
		int yfinal = ystart + (Game.HEIGHT / 16);
		
		for (int xx = xstart;xx <= xfinal; xx++) {
			for (int yy = ystart;yy <= yfinal; yy++) {
				if (xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
					continue;
				}		
				
				
				if ((Game.CUR_LEVEL == 3) && ((((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)) 
						|| ((Game.player.itemDireita == 1) && (Game.player.itemDireitaSelecionado)))
						
						&& (((xx >= 4) && (xx <= 12) && (yy ==21)) || ((xx == 4) && (yy >= 11) && (yy <=21))))) {									
				controleTile[xx + (yy * WIDTH)]  = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR11);
				Tile tile = controleTile[xx + (yy * WIDTH)];
				tile.render(g);
				
				} else if ((Game.CUR_LEVEL == 3) && (((((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
						|| ((Game.player.itemDireita == 1) && (!Game.player.itemDireitaSelecionado)))
						
						|| ((Game.player.itemEsquerda != 1) || (Game.player.itemDireita != 1)))
						
						&& (((xx >= 4) && (xx <= 12) && (yy ==21)) || ((xx == 4) && (yy >= 11) && (yy <=21))))) {									
				controleTile[xx + (yy * WIDTH)]  = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR10);
				Tile tile = controleTile[xx + (yy * WIDTH)];
				tile.render(g);
				} else if ((Game.CUR_LEVEL == 3) && ((((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)) 
						|| ((Game.player.itemDireita == 1) && (Game.player.itemDireitaSelecionado)))
						
						&& ((xx == 4) && (yy >= 2) && (yy <=10)))) {									
				controleTile[xx + (yy * WIDTH)]  = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR12);
				Tile tile = controleTile[xx + (yy * WIDTH)];
				tile.render(g);
				} else if ((Game.CUR_LEVEL == 3) && (((((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
						|| ((Game.player.itemDireita == 1) && (!Game.player.itemDireitaSelecionado)))
						
						|| ((Game.player.itemEsquerda != 1) || (Game.player.itemDireita != 1)))
						
						&& ((xx == 4) && (yy >= 2) && (yy <=10)))) {										
				controleTile[xx + (yy * WIDTH)]  = new FloorTile(xx * 10, yy * 16,Tile.TILE_FLOOR9);
				Tile tile = controleTile[xx + (yy * WIDTH)];
				tile.render(g);
				}else {
					Tile tile = tiles[xx + (yy * WIDTH)];
					tile.render(g);
					
				}

				
			}
		}
		
	}
	
	
}
