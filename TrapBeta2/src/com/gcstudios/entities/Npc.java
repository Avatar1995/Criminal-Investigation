package com.gcstudios.entities;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.Game;

public class Npc extends Entity {
	public String[] frases = new String[4];

	public boolean showMessage = false;
	public boolean fraseHabilitada = true;

	public int curIndexMsg = 0;
	public int fraseIndex = -1;
	public int maxFrases = 4;
	public int tipo = -1;
	public int npcX = 0;
	public int npcY = 0;
	public int tipoFrase = 0;
	private BufferedImage[] NPCSprites, NivelMensagem;

	public Npc(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, sprite, tipo);
		// TODO Auto-generated constructor stub
		NPCSprites = new BufferedImage[4];
		NivelMensagem = new BufferedImage[3];
		this.tipo = tipo;
		npcX = x;
		npcY = y;
		for (int i = 0; i < 4; i++) {
			if ((tipo == 1) && (Game.CUR_LEVEL == 1)) {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10), 420, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 470, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[i] = Game.spritesheet.getSprite(64 + (i * 10), 225, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 1) && ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10), 801, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 1)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 420, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 2) && ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 420, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10), 146, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[i] = Game.spritesheet.getSprite(0, 636, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 5)) {
				NPCSprites[i] = Game.spritesheet.getSprite(67 + (i * 10), 726, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 1)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 436, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 5) && ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 436, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 486, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 5)) {
				NPCSprites[i] = Game.spritesheet.getSprite(33,1264,9,16);
				tipoFrase = -1;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[i] = Game.spritesheet.getSprite(20, 636, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 1)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 453, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 4)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 453, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 7)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 453, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 5)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 453, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 502, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[i] = Game.spritesheet.getSprite(0, 653, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 1)) {
				NPCSprites[i] = Game.spritesheet.getSprite(59, 366, 9, 16);
				tipoFrase = -1;
			} else if ((tipo == 7) && ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10), 819, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(93, 401, 9, 16);
				tipoFrase = -1;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[0] = Game.spritesheet.getSprite(0, 470, 10, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(10, 470, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 5)) {
				NPCSprites[i] = Game.spritesheet.getSprite(22,1264,9,16);
				tipoFrase = -1;
			} else if ((tipo == 90)) {
				NPCSprites[0] = Game.spritesheet.getSprite(40, 401, 9, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(50, 401, 9, 16);
				tipoFrase = -1;
			} else if ((tipo == 91)) {
				NPCSprites[0] = Game.spritesheet.getSprite(40, 401, 9, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(93, 401, 9, 16);
				tipoFrase = -1;
			} else if ((tipo == 92)) {
				NPCSprites[0] = Game.spritesheet.getSprite(40, 401, 9, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(0, 487, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 93)) {
				NPCSprites[0] = Game.spritesheet.getSprite(40, 401, 9, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(44, 801, 7, 12);
				tipoFrase = -1;
			} else if ((tipo == 94)) {
				NPCSprites[0] = Game.spritesheet.getSprite(40, 401, 9, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(0, 1249, 9, 7);
				tipoFrase = -1;
			}  else if ((tipo == 9) && (Game.CUR_LEVEL == 2)) {
				NPCSprites[i] = Game.spritesheet.getSprite(40 + (i * 10), 518, 9, 16);
				tipoFrase = 2;
			} else if ((tipo == 9) && (Game.CUR_LEVEL == 3)) {
				NPCSprites[0] = Game.spritesheet.getSprite(59, 401, 10, 16);
				NPCSprites[1] = Game.spritesheet.getSprite(30, 636, 10, 16);
				tipoFrase = -1;
			} else if ((tipo == 9) && (Game.CUR_LEVEL == 5)) {
				NPCSprites[i] = Game.spritesheet.getSprite(22,1264,9,16);
				tipoFrase = -1;
			} else if ((tipo == 9) && (Game.CUR_LEVEL == 4)) {
				NPCSprites[i] = Game.spritesheet.getSprite(99, 689, 9, 16);
				tipoFrase = -1;
			} else if ((tipo == 9) && (Game.CUR_LEVEL == 7)) {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10), 420, 9, 16);
				tipoFrase = 1;
			} else if ((tipo == 14) && (Game.CUR_LEVEL == 3))  {
				NPCSprites[i] = Game.spritesheet.getSprite(60,619,10,16);
				tipoFrase = -1;
			} else if ((tipo == 14) && (Game.CUR_LEVEL == 5))  {
				NPCSprites[i] = Game.spritesheet.getSprite(33,1264,9,16);
				tipoFrase = -1;
			} else if ((tipo == 14) && (Game.CUR_LEVEL == 7))  {
				NPCSprites[i] = Game.spritesheet.getSprite(0 + (i * 10),1448,9,16); 
				tipoFrase = 2;
			} else tipoFrase = -1;
		}

		for (int i = 0; i < 3; i++) {
			NivelMensagem[i] = Game.spritesheet.getSprite(0 + (i * 4), 314, 3, 8);
		}
	}

	public void tick() {
		int xPlayer = Game.player.getX();
		int yPlayer = Game.player.getY();
		int xNpc = (int) x;
		int yNpc = (int) y;
		if ((!Game.objetivo1Completado) && (Game.CUR_LEVEL == 2) && (this.tipo == 5))
			tipoFrase = -1;
			else
				if ((Game.objetivo1Completado) && (!Game.objetivo2Completado) && (Game.CUR_LEVEL == 2) && (this.tipo == 5))
					tipoFrase = 2;	
		
		if ((!Game.objetivo1Completado) && (Game.CUR_LEVEL == 2) && (this.tipo == 9))
			tipoFrase = -1; 
			else
				if ((Game.objetivo1Completado) && (!Game.objetivo3Completado) && (Game.CUR_LEVEL == 2) && (this.tipo == 9))
					tipoFrase = 2;	
		
		if ((Game.objetivo1Completado) && (Game.objetivo2Completado) 
				&& (Game.objetivo3Completado) && (Game.objetivo4Completado) && (Game.diarioLido) && (!Game.objetivo5Completado)   
				&& (Game.CUR_LEVEL == 3) && (this.tipo == 1))
			tipoFrase = 2;
		
		
		if ((Game.objetivo1Completado) && (Game.objetivo2Completado)  
				&& (Game.CUR_LEVEL == 5) && (this.tipo == 2) && (!Game.segredo5Encontrado))
			tipoFrase = 1;
		
		if ((Game.objetivo1Completado) && (Game.objetivo2Completado)  
				&& (Game.CUR_LEVEL == 5) && (this.tipo == 2) && (Game.segredo5Encontrado))
			tipoFrase = -1;
			

		if ((Math.abs(xPlayer - xNpc) < 20) && (Math.abs(yPlayer - yNpc) < 20)) {
			if (this.tipo == 1)  {
				Game.phrases.showMessage1 = true;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[0] = true;
				
			} else if ((this.tipo == 2) && (Game.CUR_LEVEL != 3) && (Game.CUR_LEVEL != 5)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = true;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[1] = true;
				
			} else if ((this.tipo == 2) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado) && (Game.wardrobeAnalisado) 
						&& ((Game.player.itemEsquerda == 3) || (Game.player.itemDireita == 3))) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = true;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[1] = true;
				
			} else if ((this.tipo == 2) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado) 
					&& (((Game.player.itemDireita == 1) && (Game.player.itemDireitaSelecionado))
					|| ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)) || (Game.wardrobeAnalisado))) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = true;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[1] = true;
				
			} else if ((this.tipo == 2) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado) && (!Game.wardrobeAnalisado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[1] = false;
				
			} else if ((this.tipo == 2) && (Game.CUR_LEVEL == 5) && (!Game.segredo5Encontrado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = true;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[1] = true;
		
				
			} else if ((this.tipo == 5) && ((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = true;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[2] = true;

				
			} else if ((this.tipo == 5) && (Game.CUR_LEVEL == 2) && (Game.objetivo1Completado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = true;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[2] = true;
				
			} else if ((this.tipo == 5) && (Game.CUR_LEVEL == 3) 
					&& (!Game.objetivo2Completado) && (!Game.papelAnalisado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = true;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[2] = true;
				
			} else if ((this.tipo == 5) && (Game.CUR_LEVEL == 3) && (Game.objetivo1Completado) && (!Game.objetivo2Completado) 
					&& (Game.papelAnalisado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = true;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[2] = true;
				
			} else if (this.tipo == 6) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = true;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[3] = true;
				
			} else if ((this.tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (!Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
					|| ((Game.player.itemDireita != 1) || (Game.player.itemEsquerda != 1)))
					&& (!Game.segredo1Encontrado) && (Game.CUR_LEVEL == 1)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= true;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[4] = true;
				
			} else if ((this.tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
					&& (!Game.segredo1Encontrado) && (Game.CUR_LEVEL == 1)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= true;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[4] = true;
				
			} else if ((this.tipo == 7) && (!Game.segredo2Encontrado) && (Game.CUR_LEVEL == 2)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= true;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[4] = true;
				
			} else if ((this.tipo == 7) && (!Game.objetivo3Completado) && (Game.CUR_LEVEL == 3)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= true;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[4] = true;
				
			} else if ((this.tipo == 7) && ((Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7))) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3 = false;
				Game.phrases.showMessage4 = false;
				Game.phrases.showMessage5= true;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[4] = true;
				
			} else if ((this.tipo == 9) && (Game.CUR_LEVEL == 2) && (Game.objetivo1Completado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= true;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[5] = true;

				
			} else if ((this.tipo == 9) && ((Game.player.itemDireita != 2) && (Game.player.itemEsquerda != 2)) 
					&& (!Game.portaAberta) && (Game.CUR_LEVEL == 3)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= true;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[5] = true;
				
			} else if ((this.tipo == 9) && ((Game.player.itemDireita == 2) || (Game.player.itemEsquerda == 2)) && (Game.CUR_LEVEL == 3) && (!Game.portaAberta)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= true;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[5] = true;
				
			} else if ((this.tipo == 9) && (Game.CUR_LEVEL == 4) && (!Game.segredo4Encontrado)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= true;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[5] = true;
				
			} else if ((this.tipo == 9) && (Game.CUR_LEVEL == 7)) {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= true;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[5] = true;
				
			} else if (this.tipo == 8)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= true;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[6] = true;
				
			} else if (this.tipo == 10)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= true;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[7] = true;
				
			}  
			else if (this.tipo == 11)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= true;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[8] = true;
				
			} 
			else if (this.tipo == 12)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= true;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[9] = true;
		
			}else if (this.tipo == 13)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= true;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[10] = true;
			}
			else if ((this.tipo == 14) && (Game.CUR_LEVEL == 3) && (Game.diarioLido) && (!Game.segredo3Encontrado))  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= true;
				Game.phrases.showMessage13= false;
				Game.mensagemJ[11] = true;
			
			} else if ((this.tipo == 14) && (Game.CUR_LEVEL == 7))  {
					Game.phrases.showMessage1 = false;
					Game.phrases.showMessage2 = false;
					Game.phrases.showMessage3= false;
					Game.phrases.showMessage4= false;
					Game.phrases.showMessage5= false;
					Game.phrases.showMessage6= false;
					Game.phrases.showMessage7= false;
					Game.phrases.showMessage8= false;
					Game.phrases.showMessage9= false;
					Game.phrases.showMessage10= false;
					Game.phrases.showMessage11= false;
					Game.phrases.showMessage12= true;
					Game.phrases.showMessage13= false;
					Game.mensagemJ[11] = true;
				
				}else if (this.tipo == 15)  {
				Game.phrases.showMessage1 = false;
				Game.phrases.showMessage2 = false;
				Game.phrases.showMessage3= false;
				Game.phrases.showMessage4= false;
				Game.phrases.showMessage5= false;
				Game.phrases.showMessage6= false;
				Game.phrases.showMessage7= false;
				Game.phrases.showMessage8= false;
				Game.phrases.showMessage9= false;
				Game.phrases.showMessage10= false;
				Game.phrases.showMessage11= false;
				Game.phrases.showMessage12= false;
				Game.phrases.showMessage13= true;
				Game.mensagemJ[12] = true;
		
			}
			Game.phrases.definirFrases(this.tipo);
			Game.phrases.npcX = npcX;
			Game.phrases.npcY = npcY;
			
		}  else {
			if (this.tipo == 1) {
				Game.phrases.showMessage1 = false;
				Game.mensagemJ[0] = false;
			} else if (this.tipo == 2) {
				Game.phrases.showMessage2 = false;
				Game.mensagemJ[1] = false;
			} else if (this.tipo == 5) {
				Game.phrases.showMessage3 = false;
				Game.mensagemJ[2] = false;
			} else if (this.tipo == 6) {
				Game.phrases.showMessage4 = false;
				Game.mensagemJ[3] = false;
			} else if (this.tipo == 7) {
				Game.phrases.showMessage5= false;
				Game.mensagemJ[4] = false;
			} else if (this.tipo == 9) {
				Game.phrases.showMessage6= false;
				Game.mensagemJ[5] = false;
			} else if (this.tipo == 8) {
				Game.phrases.showMessage7= false;
				Game.mensagemJ[6] = false;
			} else if (this.tipo == 10) {
				Game.phrases.showMessage8= false;
				Game.mensagemJ[7] = false;
			} else if (this.tipo == 11) {
				Game.phrases.showMessage9= false;
				Game.mensagemJ[8] = false;
			} else if (this.tipo == 12) {
				Game.phrases.showMessage10= false;
				Game.mensagemJ[9] = false;
			} else if (this.tipo == 13) {
				Game.phrases.showMessage11= false;
				Game.mensagemJ[10] = false;
			} else if (this.tipo == 14) {
				Game.phrases.showMessage12= false;
				Game.mensagemJ[11] = false;
			} else if (this.tipo == 15) {
				Game.phrases.showMessage13= false;
				Game.mensagemJ[12] = false;
			}
		}
	}

	public void render(Graphics g) {
		if ((Game.estado_cena == Game.jogando) && (Game.cutscenes.numero == -1)) {
			if (tipoFrase == 0) {
				g.drawImage(NivelMensagem[2], this.getX() + 3 - Camera.x, this.getY() - 10 - Camera.y, null);
			} else if (tipoFrase == 1) {
				g.drawImage(NivelMensagem[1], this.getX() + 3 - Camera.x, this.getY() - 10 - Camera.y, null);
			} else if (tipoFrase == 2) {
				g.drawImage(NivelMensagem[0], this.getX() + 3 - Camera.x, this.getY() - 10 - Camera.y, null);
			}
		}
		
		if ((this.tipo == 91) && (!Game.segredo2Encontrado)){
			g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
		} else
			if ((this.tipo == 91) && (Game.segredo2Encontrado)){
				g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} 
			else if ((this.tipo == 90) && (!Game.segredo1Encontrado)){
					g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				} else
					if ((this.tipo == 90) && (Game.segredo1Encontrado)){
						g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
					} else if ((this.tipo == 92) && (!Game.segredo3Encontrado)){
							g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
						} else
							if ((this.tipo == 92) && (Game.segredo3Encontrado)){
								g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
							} else if ((this.tipo == 93) && (!Game.segredo4Encontrado)){
								g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
							} else
								if ((this.tipo == 93) && (Game.segredo4Encontrado)){
									g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
								} else
									if ((this.tipo == 94) && (Game.segredo5Encontrado)){
										g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
									} else 
						if  ((this.tipo == 7) && (((Game.player.itemDireita == 1) 
								&& (!Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
								|| ((Game.player.itemDireita != 1) && (Game.player.itemEsquerda != 1)) || (Game.objetivo3Completado))
								 && (Game.CUR_LEVEL == 3)){
							g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
						} else 
			
							if ((this.tipo == 7) && (((Game.player.itemDireita == 1) 
									&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
									&& (!Game.objetivo3Completado) && (Game.CUR_LEVEL == 3)) {
								g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
							} else
								
						if  ((!Game.portaAberta) && (tipo == 9) && (Game.CUR_LEVEL == 3)){
							g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
						} else 	
							if  ((Game.portaAberta) && (tipo == 30) && (Game.CUR_LEVEL == 3)){
								g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
							} else 
										
						if ((Game.player.getY() > (int) y)) {
							g.drawImage(NPCSprites[2], this.getX() - Camera.x, this.getY() - Camera.y, null);
							if ((Game.CUR_LEVEL == 2) && (this.tipo != 7))
								g.drawImage(Entity.UMBRELLA_DOWNLEFT, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
							
						}  else
							if ((Game.player.getX() < this.getX())) {
								g.drawImage(NPCSprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
								if ((Game.CUR_LEVEL == 2) && (this.tipo != 7))
									g.drawImage(Entity.UMBRELLA_DOWNLEFT, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
								
							} else

								if ((Game.player.getX() > this.getX())) {
									g.drawImage(NPCSprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
									if ((Game.CUR_LEVEL == 2) && (this.tipo != 7))
										g.drawImage(Entity.UMBRELLA_UPRIGTH, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
									
								} else  if ((Game.player.getY() < (int) y)) {
									g.drawImage(NPCSprites[3], this.getX() - Camera.x, this.getY() - Camera.y, null);
									if ((Game.CUR_LEVEL == 2) && (this.tipo != 7))
										g.drawImage(Entity.UMBRELLA_UPRIGTH, this.getX() - 1 - Camera.x,this.getY() - 6 - Camera.y, null);
									
								}
					}

	

}
