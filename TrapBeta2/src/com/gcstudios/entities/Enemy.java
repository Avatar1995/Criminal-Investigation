package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.AudioClip;
import com.gcstudios.main.AudioPlayer;
import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class Enemy extends Entity {
	public int speed = 1;
	public int frames = 0, maxFrames = 4, indexVert=0, maxIndexVert =2, indexHor=0, maxIndexHor =3;
	public boolean movedHor,movedVert = false;
	public int right_dir = 0, left_dir = 1, up_dir = 2, down_dir= 3;
	public int dir = 0;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] downPlayer;
	private BufferedImage[] upPlayer;
	private BufferedImage[] armaSelecionada;
	private BufferedImage enemyDamage;
	public int direcaoTiro, direcaoShoot = 0;
	public int direcaoAttack, tipo = 0;
	private int life;
	private boolean isDamaged, shootAllowed, tickPermitido = false;
	private int damageFrames = 10,damageCurrent= 0;
	private boolean attackknife = false;
	private int timeCenaEnemy,timeCenaEnemyBullet = 0,maxTimeCenaEnemy = 20, maxTimeCenaEnemyBullet = 50;
	private BufferedImage rightAttack;
	private BufferedImage leftAttack;
	private BufferedImage downAttack;
	private BufferedImage upAttack;
	private static int maxEnemies = 21;
	public static int enemy = 0;

	public Enemy(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, null, tipo);
		rightPlayer = new BufferedImage[5];
		leftPlayer = new BufferedImage[5];
		downPlayer = new BufferedImage[4];
		upPlayer = new BufferedImage[4];
		armaSelecionada = new BufferedImage[4];
		enemyDamage = Game.spritesheet.getSprite(101,0,8,16);
		this.tipo = tipo;
		if (this.tipo == 3)
			life = 800;
		else
			life = 30;
		
		if (Game.CUR_LEVEL == 6)
			dir = 3;
		//if (tipo == 1) {
		
		
			rightAttack = Game.spritesheet.getSprite(33,45,8,5);
			leftAttack = Game.spritesheet.getSprite(42,45,8,5);
			downAttack = Game.spritesheet.getSprite(27,44,5,8);
			upAttack = Game.spritesheet.getSprite(21,44,5,8);
			
			if (this.tipo == 0) {
				
				
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						rightPlayer[i] = Game.spritesheet.getSprite(59, 1154, 10, 16);
					} else
						rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 1136, 9, 16);
				}
		
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						leftPlayer[i] = Game.spritesheet.getSprite(72, 1154, 10, 16);
					} else
						leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 1136, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {
					if (i == 3) {
						downPlayer[i] = Game.spritesheet.getSprite(94, 1154, 9, 16);
					}  else
						downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 1154, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {	
					if (i == 3) {
						upPlayer[i] = Game.spritesheet.getSprite(83, 1154, 9, 16);
					} else
						upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 1154, 9, 16);
				}
			
			}
			
			if (this.tipo == 2) {
				
				
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						rightPlayer[i] = Game.spritesheet.getSprite(59, 1191, 10, 16);
					} else
						rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 1173, 9, 16);
				}
		
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						leftPlayer[i] = Game.spritesheet.getSprite(72, 1191, 10, 16);
					} else
						leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 1173, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {
					if (i == 3) {
						downPlayer[i] = Game.spritesheet.getSprite(94, 1191, 9, 16);
					}  else
						downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 1191, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {	
					if (i == 3) {
						upPlayer[i] = Game.spritesheet.getSprite(83, 1191, 9, 16);
					} else
						upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 1191, 9, 16);
				}
			
			}
			
			if (this.tipo == 1) {
				
				
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						rightPlayer[i] = Game.spritesheet.getSprite(59, 1227, 10, 16);
					} else
						rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 1209, 9, 16);
				}
		
				for (int i = 0;i < 5;i++) {
					if (i == 4) {
						leftPlayer[i] = Game.spritesheet.getSprite(72, 1227, 10, 16);
					} else
						leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 1209, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {
					if (i == 3) {
						downPlayer[i] = Game.spritesheet.getSprite(94, 1227, 9, 16);
					}  else
						downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 1227, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {	
					if (i == 3) {
						upPlayer[i] = Game.spritesheet.getSprite(83, 1227, 9, 16);
					} else
						upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 1227, 9, 16);
				}
				
				for (int i = 0;i < 4;i++) {
					armaSelecionada[i] = Game.spritesheet.getSprite(69 + (i * 10), 1245, 9, 16);
				
				}
			
			
			}
			
			if (this.tipo == 3) {
								
				for (int i = 0;i < 4;i++) {
					rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 1466, 9, 16);
				}
		
				for (int i = 0;i < 4;i++) {
					leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 1466, 9, 16);
				}
		
				for (int i = 0;i < 3;i++) {
					downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 1484, 9, 16);
				}
		
				for (int i = 0;i < 3;i++) {	
					upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 1484, 9, 16);
				}
				
				for (int i = 0;i < 4;i++) {
					armaSelecionada[i] = Game.spritesheet.getSprite(69 + (i * 10), 1484, 9, 16);
				
				}
			
			
			}
			
				
		
		
	}
	
	public void tick() {
		if (Game.permissao) {
		if (Math.abs(y - Game.player.getY()) <= 150) {
			Game.tickPermitido = true;
			Game.objetivoLiberado = true;
			tickPermitido = true;	
		}
		
		if (tickPermitido) {
		
		movedHor = false;
		movedVert = false;
		if (attackknife) {
			attackknifemetodo(dir);
		}
		
		if (shootAllowed) {
			attackbulletmetodo(direcaoShoot);
		}
		if (isCollidingWithPlayer() == false) {
			if (Game.rand.nextInt(100) < 40) {
				if (this.tipo == 0) {
				if (y < Game.player.getY() && World.isFree(this.getX(),(int)y + speed,0) && (!isCollidingWithObject(this.getX(), (int)(y+speed)))
						&& !isColliding(this.getX(),(int)y + speed)  && (this.tipo % 2 == 0)){
					dir = down_dir;
					y+=speed;
					movedHor = false;
					movedVert = true;
				}
				
				else if (y > Game.player.getY()&& World.isFree(this.getX(),(int)y - speed,0) && (!isCollidingWithObject(this.getX(), (int)(y -speed)))
						&& !isColliding(this.getX(),(int)y - speed)  && (this.tipo % 2 == 0)){
					dir = up_dir;
					y-=speed;
					movedHor = false;
					movedVert = true;

				} else if (x < Game.player.getX() && World.isFree((int)x+speed,this.getY(),0) && (!isCollidingWithObject((int)(x +speed), this.getY()))
						&& !isColliding((int)x+speed,this.getY()) && (((this.tipo % 2 != 0) && (!shootAllowed)) || (this.tipo % 2 == 0))) {
					dir = right_dir;
					x+=speed;
					movedHor = true;
					movedVert = false;
				}
		
				else if (x > Game.player.getX() && World.isFree((int)x-speed,this.getY(),0) && (!isCollidingWithObject((int)(x-speed), this.getY()))
						&& !isColliding((int)x-speed,this.getY()) && (((this.tipo % 2 != 0) && (!shootAllowed)) || (this.tipo % 2 == 0))){
					dir = left_dir;
					x-=speed;
					movedHor = true;
					movedVert = false;
				}
				
				else 
	
				
			
				if ((isColliding((int)x+speed,this.getY())) || (isCollidingWithObject((int)(x +speed), this.getY())) || (attackknife)) {
					dir = right_dir;
					movedHor = false;
					movedVert = false;
					indexHor = 0;
				
				} else
			
					if ((isColliding((int)x-speed,this.getY())) || (isCollidingWithObject((int)(x-speed), this.getY())) || (attackknife)) {
						dir = left_dir;
						movedHor = false;
						movedVert = false;
						indexHor = 0;
				
					} else
			
						if ((this.tipo % 2 == 0) && ((isColliding(this.getX(),(int)y + speed)) || (isCollidingWithObject(this.getX(), (int)(y+speed))) || (attackknife))) {
							dir = down_dir;
							movedHor = false;
							movedVert = false;
							indexVert = 0;

				
						} else
			
							if ((this.tipo % 2 == 0) && ((isColliding(this.getX(),(int)y - speed)) || (isCollidingWithObject(this.getX(), (int)(y -speed))) || (attackknife))) {
								dir = up_dir;
								movedHor = false;
								movedVert = false;
								indexVert = 0;
							}
				} else {
					if (x < Game.player.getX() && World.isFree((int)x+speed,this.getY(),0) && (!isCollidingWithObject((int)(x +speed), this.getY()))
							&& !isColliding((int)x+speed,this.getY()) && (((this.tipo % 2 != 0) && (!shootAllowed)) || (this.tipo % 2 == 0))) {
						dir = right_dir;
						x+=speed;
						movedHor = true;
						movedVert = false;
					}
			
					else if (x > Game.player.getX() && World.isFree((int)x-speed,this.getY(),0) && (!isCollidingWithObject((int)(x-speed), this.getY()))
							&& !isColliding((int)x-speed,this.getY()) && (((this.tipo % 2 != 0) && (!shootAllowed)) || (this.tipo % 2 == 0))){
						dir = left_dir;
						x-=speed;
						movedHor = true;
						movedVert = false;
					}
					
					else if (y < Game.player.getY() && World.isFree(this.getX(),(int)y + speed,0) && (!isCollidingWithObject(this.getX(), (int)(y+speed)))
							&& !isColliding(this.getX(),(int)y + speed)  && (this.tipo % 2 == 0)){
						dir = down_dir;
						y+=speed;
						movedHor = false;
						movedVert = true;
					}
					
					else if (y > Game.player.getY()&& World.isFree(this.getX(),(int)y - speed,0) && (!isCollidingWithObject(this.getX(), (int)(y -speed)))
							&& !isColliding(this.getX(),(int)y - speed)  && (this.tipo % 2 == 0)){
						dir = up_dir;
						y-=speed;
						movedHor = false;
						movedVert = true;

					} else 
		
					
				
					if ((isColliding((int)x+speed,this.getY())) || (isCollidingWithObject((int)(x +speed), this.getY())) || (attackknife)) {
						dir = right_dir;
						movedHor = false;
						movedVert = false;
						indexHor = 0;
					
					} else
				
						if ((isColliding((int)x-speed,this.getY())) || (isCollidingWithObject((int)(x-speed), this.getY())) || (attackknife)) {
							dir = left_dir;
							movedHor = false;
							movedVert = false;
							indexHor = 0;
					
						} else
				
							if ((this.tipo % 2 == 0) && ((isColliding(this.getX(),(int)y + speed)) || (isCollidingWithObject(this.getX(), (int)(y+speed))) || (attackknife))) {
								dir = down_dir;
								movedHor = false;
								movedVert = false;
								indexVert = 0;

					
							} else
				
								if ((this.tipo % 2 == 0) && ((isColliding(this.getX(),(int)y - speed)) || (isCollidingWithObject(this.getX(), (int)(y -speed))) || (attackknife))) {
									dir = up_dir;
									movedHor = false;
									movedVert = false;
									indexVert = 0;
								}
					
				}
				
				if ((this.getX() == Game.player.getX()) && (this.tipo % 2 != 0)) {
					if (y < Game.player.getY())
						direcaoShoot = down_dir;
						else if (y > Game.player.getY())
							direcaoShoot = up_dir;
					shootAllowed = true;
				} else if ((this.getY() == Game.player.getY()) && (this.tipo % 2 != 0)) {
					if (x < Game.player.getX())
						direcaoShoot = right_dir;
						else if (x > Game.player.getX())
							direcaoShoot = left_dir;
					shootAllowed = true;
				} else 
					shootAllowed = false;
				
				
				
			
				if (movedHor) {	
					frames++;
					if (frames == maxFrames) {
						frames = 0;
						indexHor++;
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
						if (indexVert > maxIndexVert) {
							indexVert = 0;

						}
					}
				}
			}
		} else {
			if (Game.rand.nextInt(100) < 10) { 
				AudioPlayer.playSound(AudioClip.hurt,2,0);
			if (Game.player.shield > 0) {
				Game.player.shield = Game.player.shield - 3;
			} else {
			
				Game.player.life = Game.player.life - 3;
			}
			Game.player.isDamaged = true;
			
			if (this.tipo % 2 == 0)
				this.attackknife = true;
			}
				
		}
		
		collidingBullet();
		collidingAttackKnife();
	
		if(life <= 0) {
			if (Game.CUR_LEVEL == 5) {
				enemy++;
				if ((enemy == maxEnemies) && (Game.objetivoLiberado)) { 
					Game.objetivoLiberado = false;
					Game.objetivo2Completado = true;
					Game.permissao = false;
					AudioPlayer.stopLoopSound();
					AudioPlayer.playLoopSound(AudioClip.oficina2,1.5,1);
				}
				
			}
			
			if (Game.CUR_LEVEL == 6) {
				if (this.tipo != 3) {
						int count = 0;
						for(int i = 0; i < Game.entities.size(); i++){
							Entity atual = Game.entities.get(i);
							if(atual instanceof Bullet) {
								count = count + 1;	
							}
						}
						if (count <= 2)
							Game.entities.add(new Bullet(this.getX(), this.getY(),3,8,Entity.BULLET_EN,0));						
					
				}
				if (this.tipo == 2) { 

					
					Enemy en = new Enemy(150, 30,10,16,Entity.ENEMY_EN,2);
					Game.entities.add(en);
					Game.enemies.add(en);
					en = null;
				}
				
				if (this.tipo == 0) { 					
					Enemy en = new Enemy(50, 30,10,16,Entity.ENEMY_EN,0);
					Game.entities.add(en);
					Game.enemies.add(en);
					en = null;
				}
				
				if ((this.tipo == 3) && (!Game.bossDerrotado)) { 
					AudioPlayer.stopLoopSound();
					AudioPlayer.playSound(AudioClip.bossDerrotado,1.5,0);
					Game.bossDerrotado = true;
					
				}
				
			}
			destroySelf();
			return;
		}
		
		
		
		if(isDamaged) {
			this.damageCurrent++;
			if(this.damageCurrent == this.damageFrames) {
				this.damageCurrent = 0;
				this.isDamaged = false;
			}
		}
	}
		}
	}
	
	public void destroySelf() {
		Game.enemies.remove(this);
		Game.entities.remove(this);
	}
	
	public boolean isCollidingWithPlayer() {
		Rectangle enemyCurrent = new Rectangle(this.getX(), this.getY(),9,16);
		Rectangle player = new Rectangle(Game.player.getX(), Game.player.getY(),5,5);
		
		return enemyCurrent.intersects(player);
	
	}
	
	public void attackknifemetodo(int direcao) {
		timeCenaEnemy++;
		if (timeCenaEnemy <= maxTimeCenaEnemy) {
			if (direcao == 0) {
				dir = right_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;
			}

			if (direcao == 1) {
				dir = left_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;
			}

			if (direcao == 3) {
				dir = down_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;

			}

			if (direcao == 2) {
				dir = up_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;
			}
	
		} else {
			AudioPlayer.playSound(AudioClip.attackKnife,2,0);
			this.attackknife = false;
			timeCenaEnemy = 0;
			
		}
	}
	
	public void attackbulletmetodo(int direcao) {
		timeCenaEnemyBullet++;
		if (timeCenaEnemyBullet <= maxTimeCenaEnemyBullet) {
			if (direcao == 0) {
				dir = right_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;
			}

			if (direcao == 1) {
				dir = left_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;
			}

			if (direcao == 3) {
				dir = down_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;


			}

			if (direcao == 2) {
				dir = up_dir;
				movedHor = false;
				movedVert = false;
				indexHor = 0;

			}
	
		} else {
			
			AudioPlayer.playSound(AudioClip.shoot,2,0);
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
				
			BulletShoot bullet = new BulletShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy,direcaoTiro, 1);
			Game.bullets.add(bullet);	
			bullet = null;
			timeCenaEnemyBullet = 0;
			
		}
	}
	
	public boolean isColliding(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext, ynext,10,16);
		
		for (int i = 0; i < Game.enemies.size();i++) {
			Enemy e = Game.enemies.get(i);
			if ((e == this))
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX(), e.getY(),10,16);
			if (Game.CUR_LEVEL != 6) { 
				if (enemyCurrent.intersects(targetEnemy)) {
					e = null;
					return true;	
				}
			} 
				
		}
		
		return false;
	
	}
	
	public boolean isCollidingWithObject(double xnext, double ynext) {
		Rectangle enemy = new Rectangle((int)xnext, (int)ynext,10,16);
		
		for (int i = 0; i < Game.items.size();i++) {
			Items it = Game.items.get(i);
			Rectangle object = new Rectangle(it.getX(), it.getY(),10,16);
			if ((enemy.intersects(object)) && (Game.items.get(i).tipo != 1)) {
				if (Game.items.get(i).tipo != 98) {
					it = null;
					return true;	
				}
			}
		}
		
		return false;
	
	}
	
	public void collidingBullet() {
		for(int i = 0; i < Game.bullets.size(); i++) {
			Entity e = Game.bullets.get(i);
				if(Entity.isColidding(this,e) && (Game.bullets.get(i).tipo == 0)) {
					isDamaged = true;
					life = life - 10;
					Game.bullets.remove(e);
					e = null;
					return;
				}
		}
		
		
	}
	
	public void collidingAttackKnife() {
		for(int i = 0; i < Game.attackknife.size(); i++) {
			if  (Game.attackknife.get(i).tipo == 0) {
			Entity e = Game.attackknife.get(i);
				if(Entity.isColidding(this,e)) {
					movedHor = false;
					isDamaged = true;
					life--;
					Game.player.lifeKnife = Game.player.lifeKnife - 0.1;
					if (Game.player.lifeKnife <= 0) {
						Game.itemsPersonagem.items[7][1] = 0;
						if (Game.player.itemDireita == 7) {
							Game.player.itemDireita = -1;
							Game.player.itemDireitaSelecionado = false;
						}
						if (Game.player.itemEsquerda == 7) {
							Game.player.itemEsquerda = -1;
							Game.player.itemEsquerdaSelecionado = false;
						}
						Game.player.lifeKnife = 0;
					}
					e = null;
					return;
				}
			}
		}
		
		
	}
	
	public void render(Graphics g) {
		if(!isDamaged) {
			if (dir == right_dir) {
				if (!attackknife) {
					g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (this.tipo % 2 == 0)
						g.drawImage(Entity.KNIFE_EN, this.getX()+7 - Camera.x,this.getY() + 5  - Camera.y, null);
					else
						g.drawImage(Entity.GUN_EN, this.getX()+7 - Camera.x,this.getY() + 8 - Camera.y, null);
					
					
				} else {
					g.drawImage(rightPlayer[4], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (dir == 0) 
						g.drawImage(rightAttack, this.getX() + 10 - Camera.x,this.getY() + 8 - Camera.y, null);
				}
			} else if (dir == left_dir) {
				if (!attackknife) {
					g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);		
					
					if (this.tipo % 2 == 0)
						g.drawImage(Entity.KNIFE_LEFT, this.getX()-6 - Camera.x,this.getY() + 5 - Camera.y, null);
					else
						g.drawImage(Entity.GUN_LEFT, this.getX()-7 - Camera.x,this.getY() + 8 - Camera.y, null);
					
				} else {
					g.drawImage(leftPlayer[4], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (dir == 1) 
						g.drawImage(leftAttack, this.getX() - 8 - Camera.x,this.getY() + 8 - Camera.y, null);
				}
			}
		
			if (dir == down_dir) {
				if (!attackknife) {
					g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (this.tipo % 2 == 0)
						g.drawImage(Entity.KNIFE_EN, this.getX() + 7 - Camera.x,this.getY() + 7 - Camera.y, null);
					else
						g.drawImage(Entity.GUN_DOWN, this.getX() - Camera.x,this.getY()+12 - Camera.y, null);
				} else {
					g.drawImage(downPlayer[3], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (dir == 3)
						g.drawImage(downAttack, this.getX() + 3 - Camera.x,this.getY() + 15 - Camera.y, null);
				}
				
			} else if (dir == up_dir) {
				if (!attackknife) {
					if (this.tipo % 2 == 0) {
						g.drawImage(upPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);	
						g.drawImage(Entity.KNIFE_EN, this.getX()+8 - Camera.x,this.getY() + 6 - Camera.y, null);
					} else {					
						g.drawImage(armaSelecionada[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
						g.drawImage(Entity.GUN_UP, this.getX() + 8 - Camera.x,this.getY()+5 - Camera.y, null);
					}
				} else {
					g.drawImage(upPlayer[3], this.getX() - Camera.x,this.getY() - Camera.y, null);
					if (dir == 2)
						g.drawImage(upAttack, this.getX() + 5 - Camera.x,this.getY() - 4 - Camera.y, null);
				}
				
			}
		} else {
			g.drawImage(enemyDamage, this.getX()-Camera.x, this.getY() - Camera.y,null);		
		}
	}

}
