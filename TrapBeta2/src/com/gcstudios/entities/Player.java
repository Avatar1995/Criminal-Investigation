package com.gcstudios.entities;



import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.AudioClip;
import com.gcstudios.main.AudioPlayer;
import com.gcstudios.main.Ball;
import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class Player extends Entity{
	public boolean right, up, left, down, staticRight, staticLeft, staticDown, staticUp;
	public int right_dir = 0, left_dir = 1, up_dir = 2, down_dir= 3;
	public int dir = 2;
	public int direcaoAttack = 0;
	public int direcaoTiro = 0;
	public double speed = 0.7;
	public static double lifeKnife = 0;
	public static double lifeOriginalLevel, lifeKnifeOriginalLevel;
	private int frames = 0, maxFrames = 15, maxIndexVert =2, maxIndexHor =3;
	public int indexHor=0,indexVert=0;
	public boolean movedHor,movedVert = false;
	public BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] downPlayer;
	private BufferedImage[] upPlayer;
	private BufferedImage[] armaSelecionada;
	private BufferedImage[] umbrellaSelecionadaUp,umbrellaSelecionadaDown,umbrellaSelecionadaLeft;
	private BufferedImage   playerDamage;
	public static int itemDireita = -1;
	public static int itemDireitaOriginal = -1;
	public static boolean itemDireitaSelecionado = false;
	public static boolean itemDireitaSelecionadoOriginal = false;
	public static int itemEsquerda = -1;
	public static int itemEsquerdaOriginal = -1;
	public static boolean itemEsquerdaSelecionado = false;
	public static boolean itemEsquerdaSelecionadoOriginal = false;
	public boolean falandoComNPC = false;
	public static double life = 100;
	public static int shield = 0;
	public static int shieldOriginalLevel = 0;
	public static int ammo = 0;
	public static int coin = 0;
	public static int coinOriginalLevel = 0;
	public static int ammoOriginalLevel = 0;
	public boolean isDamaged = false;
	public boolean shoot = false;
	public boolean attack = false;
	public boolean messagemDisponivel = false;
	private int damageFrames = 0;
	public static  boolean attackknife = false;
	

	public Player(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, sprite, tipo);
		rightPlayer = new BufferedImage[5];
		leftPlayer = new BufferedImage[5];
		downPlayer = new BufferedImage[4];
		upPlayer = new BufferedImage[4];
		armaSelecionada = new BufferedImage[4];
		umbrellaSelecionadaUp = new BufferedImage[4];
		umbrellaSelecionadaDown = new BufferedImage[4];
		umbrellaSelecionadaLeft = new BufferedImage[4];
		
		playerDamage = Game.spritesheet.getSprite(101,0,8,16);
		
		for (int i = 0;i < 5;i++) {
			if (i == 4) {
				rightPlayer[i] = Game.spritesheet.getSprite(60, 126, 10, 16);
			} else
				rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 108, 9, 16);

		}
		
		for (int i = 0;i < 5;i++) {			
			if (i == 4) {
				leftPlayer[i] = Game.spritesheet.getSprite(71, 126, 10, 16);
			} else
				leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 108, 9, 16);

		}
		
		for (int i = 0;i < 4;i++) {
			if (i == 3) {
				downPlayer[i] = Game.spritesheet.getSprite(93, 126, 9, 16);
			} else
				downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 126, 9, 16);
			
		}
		
		for (int i = 0;i < 4;i++) {
			if (i == 3) {
				upPlayer[i] = Game.spritesheet.getSprite(82, 126, 9, 16);
			} else
				upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 126, 9, 16);
			
		}
		
		for (int i = 0;i < 4;i++) {
			armaSelecionada[i] = Game.spritesheet.getSprite(34 + (i * 10), 224, 9, 16);
			
		}
		
		for (int i = 0;i < 4;i++) {
			umbrellaSelecionadaUp[i] = Game.spritesheet.getSprite(28 + (i * 10), 314, 9, 16);
			
		}
		
		for (int i = 0;i < 4;i++) {
			umbrellaSelecionadaDown[i] = Game.spritesheet.getSprite(58 + (i * 10), 314, 9, 16);
			
		}
		
		for (int i = 0;i < 4;i++) {
			if (i == 3) {
				umbrellaSelecionadaLeft[i] = Game.spritesheet.getSprite(4, 331, 10, 16);
			} else
				umbrellaSelecionadaLeft[i] = Game.spritesheet.getSprite(35 + (i * -1 * 10), 331, 9, 16);
			
		}
	}
	
	public void tick() {
		movedHor = false;
		movedVert = false;

		if (!attackknife) {
		if (right && World.isFree((int)(x +speed), this.getY(),0) && (!isCollidingWithObject((int)(x +speed), this.getY()))
				&& (!isCollidingWithNpc((int)(x +speed), this.getY()))) {
			if (staticRight) 
				staticRight = false;
			
			if (staticLeft) 
				staticLeft = false;
			
			if (staticUp) 
				staticUp = false;
			
			if (staticDown) 
				staticDown = false;

			dir = right_dir;			
			x+=speed;
			movedHor = true;
			movedVert = false;
			
		} else if (left && World.isFree((int)(x-speed), this.getY(),0)  && (!isCollidingWithObject((int)(x-speed), this.getY()))
				&& (!isCollidingWithNpc((int)(x-speed), this.getY()))){
			if (staticRight) 
				staticRight = false;
			
			if (staticLeft) 
				staticLeft = false;
			
			if (staticUp) 
				staticUp = false;
			
			if (staticDown) 
				staticDown = false;
			dir = left_dir;
			x-=speed;
			movedHor = true;
			movedVert = false;
		} else
		
		if (up && World.isFree(this.getX(), (int)(y-speed),0) && (!isCollidingWithObject(this.getX(), (int)(y-speed)))
				&& (!isCollidingWithNpc(this.getX(), (int)(y-speed)))) {
			if (staticRight) 
				staticRight = false;
			
			if (staticLeft) 
				staticLeft = false;
			
			if (staticUp) 
				staticUp = false;
			
			if (staticDown) 
				staticDown = false;
			dir = up_dir;
			y-=speed;
			movedHor = false;
			movedVert = true;
		} else if (down && World.isFree(this.getX(), (int)(y +speed),0) && (!isCollidingWithObject(this.getX(), (int)(y +speed)))
				&& (!isCollidingWithNpc(this.getX(), (int)(y +speed)))) {
			if (staticRight) 
				staticRight = false;
			
			if (staticLeft) 
				staticLeft = false;
			
			if (staticUp) 
				staticUp = false;
			
			if (staticDown) 
				staticDown = false;
			dir = down_dir;
			y+=speed;
			movedHor = false;
			movedVert = true;
		}
		}
		
		if (staticRight) {
			dir = right_dir;
			movedHor = false;
			movedVert = false;
			indexHor = 0;
			
		} else
		
		if (staticLeft) {
			dir = left_dir;
			movedHor = false;
			movedVert = false;
			indexHor = 0;
			
		} else
		
		if (staticUp) {
			dir = up_dir;
			movedHor = false;
			movedVert = false;
			indexVert = 0;
			
		} else
		
		if (staticDown) {
			dir = down_dir;
			movedHor = false;
			movedVert = false;
			indexVert = 0;
			
		}
		
		
		if (movedHor) {
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				indexHor++;
				AudioPlayer.playSound(AudioClip.passos,2,0);
				if (indexHor > maxIndexHor) {
					indexHor = 2;

				}
			}
		}
		
		if (movedVert) {
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				indexVert++;
				AudioPlayer.playSound(AudioClip.passos,2,0);
				if (indexVert > maxIndexVert) {
					indexVert = 0;

				}
			}
		}
		
		if(isDamaged) {
			this.damageFrames++;
			if(this.damageFrames == 8) {
				this.damageFrames = 0;
				isDamaged = false;
			}
		}

		if(shoot) {
			shoot = false;
			if((Game.itemsPersonagem.items[6][1] == 1) && ammo > 0) {
				AudioPlayer.playSound(AudioClip.shoot,2,0);
				ammo--;
			//Criar bala e atirar!
			
			int dx = 0;
			int dy = 0;
			int px = 0;
			int py = 6;
			if(dir == right_dir) {
				px = 18;
				dx = 1;
				direcaoTiro = right_dir;
			}else if(dir == left_dir){
				px = -8;
				dx = -1;
				direcaoTiro = left_dir;
			}else if(dir == down_dir){
				py = 18;
				dy = 1;
				direcaoTiro = down_dir;
			}else {
				px = 6;
				py = -5;
				dy = -1;
				direcaoTiro = up_dir;
			}
			
			BulletShoot bullet = new BulletShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy,direcaoTiro, 0);
			Game.bullets.add(bullet);
			bullet = null;
			}					
			
		}
		
		if(attack) {
			if(Game.itemsPersonagem.items[7][1] == 1) {
			AudioPlayer.playSound(AudioClip.attackKnife,2,0);
			attack = false;
			int px = 0;
			int py = 0;
			if(dir == right_dir) {
				px = 10;
				py = 9;
				direcaoAttack = right_dir;
			}else if(dir == left_dir){
				px = -8;
				py = 9;
				direcaoAttack = left_dir;
			}else if(dir == down_dir){
				py = 16;
				px = 4;
				direcaoAttack = down_dir;
			}else {
				py = -4;
				px = 6;
				direcaoAttack = up_dir;
			}
			
			AttackKnife attack = new AttackKnife(this.getX()+px,this.getY()+py,3,3,null,direcaoAttack, 0);
			Game.attackknife.add(attack);
			attack = null;
			}
		}	
		checkCollisionLifePack();
		checkCollisionAmmo();
		checkCollisionGun();
		checkCollisionKnife();
		checkCollisionShield();
		checkCollisionBigorna();
		checkCollisionCoin();
		collidingBullet();
		
		if ((Game.CUR_LEVEL == 6) && (Game.logicaPermitidaBoss)  && (!Game.levelConcluido))
			collidingBulletBoss();
		
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2), 0, World.WIDTH * 10 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2), 0, World.HEIGHT * 16 - Game.HEIGHT );
		
		if(life<=0) {
			//Game over!
			life = 0;
			Game.gameOver.deathCharacter = true;
			Game.gameOver.animacaoMorte();
			
			AudioPlayer.playSound(AudioClip.death,1.5,0);
		}
		
		if(shield<=0) 
			shield = 0;

		if((((Game.player.itemDireita == 0) && (!Game.player.itemDireitaSelecionado))				
				|| ((Game.player.itemEsquerda == 0) && (!Game.player.itemEsquerdaSelecionado))	
			    || ((Game.player.itemDireita != 0) && (Game.player.itemEsquerda != 0)))
				&& (Game.CUR_LEVEL == 2)) {
			//Game over!
			
			life = life - 0.01;
			if ((life <= 80) && (life >=79.8)) {
				AudioPlayer.playSound(AudioClip.hurt,2,0);
				isDamaged = true;
			}
			
			if ((life <= 60) && (life >=59.8)) {
				AudioPlayer.playSound(AudioClip.hurt,2,0);
				isDamaged = true;
			}
			
			if ((life <= 40) && (life >=39.8)) {
				AudioPlayer.playSound(AudioClip.hurt,2,0);
				isDamaged = true;
			}
			
			if ((life <= 20) && (life >=19.8)) {
				AudioPlayer.playSound(AudioClip.hurt,2,0);
				isDamaged = true;
			}
		}
	}
	
	public void checkCollisionGun() {
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Weapon) {
				if((Entity.isColidding(this, atual)) && (Game.itemsPersonagem.items[6][1] == 0)) {
					AudioPlayer.playSound(AudioClip.gun,2,0);
					Game.itemsPersonagem.items[6][1] = 1;
					//System.out.println("Pegou a arma!");
			
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void collidingBullet() {
		for(int i = 0; i < Game.bullets.size(); i++) {
			Entity e = Game.bullets.get(i);
				if(Entity.isColidding(this,e) && (Game.bullets.get(i).tipo == 1)) {
					isDamaged = true;
					AudioPlayer.playSound(AudioClip.hurt,2,0);
					if (shield > 0)
						shield = shield - 3;
					else
						life = life - 3;
					Game.bullets.remove(e);
					e = null;
					return;
				}
		}
		
		
	}
	
	public void collidingBulletBoss() {
		
		for(int i = 0; i < Game.ball.size(); i++) {
			Ball e = Game.ball.get(i);
				if(Ball.isColidding(this,e)) {
					isDamaged = true;
					AudioPlayer.playSound(AudioClip.hurt,2,0);
					if (shield > 0)
						shield = shield - 1;
					else
						life = life - 1;
					e = null;
					return;
				}
		}					
	}
	
	public void checkCollisionKnife() {
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Knife) {
				if((Entity.isColidding(this, atual)) && (Game.itemsPersonagem.items[7][1] == 0)) {
					AudioPlayer.playSound(AudioClip.knife,2,0);
					lifeKnife = 100;
					Game.itemsPersonagem.items[7][1] = 1;
					//System.out.println("Pegou a faca!");
			
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void checkCollisionAmmo(){
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Bullet) {
				if(Entity.isColidding(this, atual)) {
					AudioPlayer.playSound(AudioClip.ammo,2,0);
					ammo+=10;
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void checkCollisionLifePack(){
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Life) {
				if((Entity.isColidding(this, atual) && (life < 100))) {
					AudioPlayer.playSound(AudioClip.health,2,0);
					life+=10;
					if(life > 100)
						life = 100;
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void checkCollisionShield(){
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Shield) {
				if((Entity.isColidding(this, atual) && (shield < 100))) {
					AudioPlayer.playSound(AudioClip.shield,2,0);
					shield+=20;
					if(shield > 100)
						shield = 100;
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void checkCollisionBigorna(){
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Bigorna) {
				if((Entity.isColidding(this, atual) && (lifeKnife < 100) && (Game.itemsPersonagem.items[7][1] == 1))) {
					AudioPlayer.playSound(AudioClip.bigorna,2,0);
					lifeKnife+=20;
					if(lifeKnife > 100)
						lifeKnife = 100;
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public void checkCollisionCoin(){
		for(int i = 0; i < Game.entities.size(); i++){
			Entity atual = Game.entities.get(i);
			if(atual instanceof Coin) {
				if(Entity.isColidding(this, atual)) {
					coin+=1;
					AudioPlayer.playSound(AudioClip.coin,2,0);
					Game.entities.remove(atual);
					atual = null;
					return;
				}
			}
		}
	}
	
	public boolean isCollidingWithObject(double xnext, double ynext) {
		Rectangle player = new Rectangle((int)xnext, (int)ynext,10,16);
		
		for (int i = 0; i < Game.items.size();i++) {
			Items it = Game.items.get(i);
			Rectangle object = new Rectangle(it.getX(), it.getY(),10,16);
			if ((player.intersects(object)) && (Game.items.get(i).tipo != 1)) {
				it = null;
				return true;	
			}
		}
		
		return false;
	
	}
	
	public boolean isCollidingWithNpc(double xnext, double ynext) {
		Rectangle player = new Rectangle((int)xnext, (int)ynext,10,16);
		
		for (int i = 0; i < Game.npcs.size();i++) {
			Npc n = Game.npcs.get(i);
			
			Rectangle npc = new Rectangle(n.getX(), n.getY(),10,16);
			if ((player.intersects(npc)) && (Game.npcs.get(i).tipo != 30)) {
				n = null;
				return true;	
			}
		}
		
		return false;
	
	}
		
	public void render(Graphics g) {
		if((!isDamaged) && (!Game.gameOver.deathCharacter))  {
			if (dir == right_dir) {
				if (!attackknife) {
					if(((itemEsquerda == 7) && (itemEsquerdaSelecionado))
						|| ((itemDireita == 7) && (itemDireitaSelecionado)) ){
						//Desenhar arma para direita.
						g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);						
						g.drawImage(Entity.KNIFE_EN, this.getX()+7 - Camera.x,this.getY() + 5  - Camera.y, null);
					}

				if(((itemEsquerda == 6) && (itemEsquerdaSelecionado))
						|| ((itemDireita == 6) && (itemDireitaSelecionado)) ){
					//Desenhar arma para direita.
					g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);					
					g.drawImage(Entity.GUN_EN, this.getX()+7 - Camera.x,this.getY() + 8 - Camera.y, null);
				} else 
					if(((itemEsquerda == 0) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 0) && (itemDireitaSelecionado))) {
						g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);						
						g.drawImage(Entity.UMBRELLA_UPRIGTH, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
					} else
						if((((itemEsquerda == 1) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 1) && (itemDireitaSelecionado))) && (indexHor == 0)) {
							g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);						
							g.drawImage(Entity.MONOCULO_EN, this.getX() + 7 - Camera.x,this.getY() + 6 - Camera.y, null);						
						} else
							g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);
						
				} 				
				else
					g.drawImage(rightPlayer[4], this.getX() - Camera.x,this.getY() - Camera.y, null);
				
				
				
			} else if (dir == left_dir) {
				if (!attackknife) {
					
					if(((itemEsquerda == 7) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 7) && (itemDireitaSelecionado)) ){
						//Desenhar arma para esquerda.
						g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);	
						g.drawImage(Entity.KNIFE_LEFT, this.getX()-6 - Camera.x,this.getY() + 5 - Camera.y, null);
					}
				
					else
						if(((itemEsquerda == 6) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 6) && (itemDireitaSelecionado)) ){
					//Desenhar arma para esquerda.
					g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);	
					g.drawImage(Entity.GUN_LEFT, this.getX()-7 - Camera.x,this.getY() + 8 - Camera.y, null);
				} else
					if(((itemEsquerda == 0) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 0) && (itemDireitaSelecionado)) ){
						g.drawImage(umbrellaSelecionadaLeft[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);											
						g.drawImage(Entity.UMBRELLA_DOWNLEFT, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
					} else
						if((((itemEsquerda == 1) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 1) && (itemDireitaSelecionado))) && (indexHor == 0)) {
							g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);												
							g.drawImage(Entity.MONOCULO_EN, this.getX() + 3 - Camera.x,this.getY() + 6 - Camera.y, null);
						} else
							if((((itemEsquerda == 1) && (itemEsquerdaSelecionado))
									|| ((itemDireita == 1) && (itemDireitaSelecionado))) && (indexHor > 0)) {
								g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);												
								g.drawImage(Entity.MONOCULO_EN, this.getX() + 1 - Camera.x,this.getY() + 6 - Camera.y, null);
							} else
								g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);	
				} else
					g.drawImage(leftPlayer[4], this.getX() - Camera.x,this.getY() - Camera.y, null);
				
			
				
			}
		
			if (dir == down_dir) {
				if (!attackknife) {
					if(((itemEsquerda == 7) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 7) && (itemDireitaSelecionado)) ){
						//Desenhar arma para baixo.
						g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
						g.drawImage(Entity.KNIFE_EN, this.getX() + 7 - Camera.x,this.getY() + 7 - Camera.y, null);
					}
					

				else
					if(((itemEsquerda == 6) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 6) && (itemDireitaSelecionado)) ){
					//Desenhar arma para baixo.
					g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
					g.drawImage(Entity.GUN_DOWN, this.getX() - Camera.x,this.getY()+12 - Camera.y, null);
				} else
					if(((itemEsquerda == 0) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 0) && (itemDireitaSelecionado)) ){
						g.drawImage(umbrellaSelecionadaDown[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);						
						g.drawImage(Entity.UMBRELLA_DOWNLEFT, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
					} else
						if(((itemEsquerda == 1) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 1) && (itemDireitaSelecionado)) ){
							g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);						
							g.drawImage(Entity.MONOCULO_EN, this.getX() + 5 - Camera.x,this.getY() + 6 - Camera.y, null);
						} else
							g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
				}
					else
						g.drawImage(downPlayer[3], this.getX() - Camera.x,this.getY() - Camera.y, null);
				
			

			} else if (dir == up_dir) {
				if (!attackknife) {
					if(((itemEsquerda == 6) && (itemEsquerdaSelecionado))
							|| ((itemDireita == 6) && (itemDireitaSelecionado)) ){
						//Desenhar arma para cima.
						g.drawImage(armaSelecionada[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
						g.drawImage(Entity.GUN_UP, this.getX() + 8 - Camera.x,this.getY()+5 - Camera.y, null);
					} else
						if(((itemEsquerda == 7) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 7) && (itemDireitaSelecionado)) ){
						//Desenhar arma para cima.
						g.drawImage(upPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
						g.drawImage(Entity.KNIFE_EN, this.getX()+8 - Camera.x,this.getY() + 6 - Camera.y, null);
					} else
					
						if(((itemEsquerda == 0) && (itemEsquerdaSelecionado))
								|| ((itemDireita == 0) && (itemDireitaSelecionado)) ){
						g.drawImage(umbrellaSelecionadaUp[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);						
						g.drawImage(Entity.UMBRELLA_UPRIGTH, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
					} else
						g.drawImage(upPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
					
				}
				else
					g.drawImage(upPlayer[3], this.getX() - Camera.x,this.getY() - Camera.y, null);
				
			}
		}else {
			g.drawImage(playerDamage, this.getX()-Camera.x, this.getY() - Camera.y,null);
		}
	}

}