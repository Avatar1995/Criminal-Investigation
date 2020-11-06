package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gcstudios.main.AudioClip;
import com.gcstudios.main.AudioPlayer;
import com.gcstudios.main.Game;


public class Phrases{
	public String[] frases = new String[40];
	
	public boolean showMessage1, showMessage2, showMessage3, 
	               showMessage4, showMessage5, showMessage6, showMessage7, showMessage8, showMessage9,
	               showMessage10,showMessage11,showMessage12, showMessage13, fraseCompletada = false;
	public boolean fraseHabilitada = true;
	public  int curIndexMsg = 0;
	public  int fraseIndex = -1;
	public int maxFrases;
	public int time, timeFrase = 0;
	public int tipoNPC = 0;
	public int maxTime= 3;
	public int maxTimeFrase = 25;
	public int npcX = 0;
	public int npcY = 0;

	public Phrases() {
		// TODO Auto-generated constructor stub		
	}
			

   public void definirFrases(int tipo) {
	   if (tipo!= 0) {
			if ((tipo == 1) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Capitão Ikena: O policial Robert te aguarda.";
				frases[1] = "Ele está muito feliz em trabalhar com você, boa sorte e mande";
				frases[2] = "lembranças a ele.";
				maxFrases = 3;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Morador 1: Todos estão chocados com o crime mas eu não, sabe?";
				frases[1] = "Esse condomínio sempre foi rodeado de energias ruins, e já era";
				frases[2] = "hora de acontecer algo assim...Com certeza ele foi amaldiçoado";
				frases[3] = "e aposto que tem algo a ver com aquelas plantas estranhas que";
				frases[4] = "sempre me deram um mal estar.";
				maxFrases = 5;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "Chloe: Hey bonitão, como você está?";
				frases[1] = "Leon Scott: Ah...muito bem Chloe, e você?";
				frases[2] = "Chloe: Tudo ótimo, vejo que está arrasando nos casos.";
				frases[3] = "Estou precisando de ajuda, pode passar na minha mesa depois?";
				frases[4] = "Leon Scott: Claro...Pode deixar.";
				frases[5] = "Chloe: Obrigada, docinho, você é demais!";
				maxFrases = 6;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Chloe: Meus parabéns, gatíssimo, que orgulho de você!";
				frases[1] = "Leon Scott: Ah...obrigado, Chloe.";
				frases[2] = "Chloe: Sabia que iria conseguir!";
				maxFrases = 3;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 3) && (Game.diarioLido) && (Game.objetivo4Completado)) {
				frases[0] = "Oficial Robert: Então, o quê descobriu?";
				frases[1] = "Leon Scott: De acordo com as pistas encontradas, a vítima tinha";
				frases[2] = "encontrado fraudes relacionadas a sua empresa e foi descoberto.";
				frases[3] = "Os remédios no banheiro indicam que ele possa ter descoberto";
				frases[4] = "isso faz um tempo e estava receioso para ir na delegacia até";
				frases[5] = "que quando decidiu, foi tarde...";
				frases[6] = "Oficial Robert: Entendo, acredita que com as informações";
				frases[7] = "obtidas aqui na casa e com as testemunhas são o suficiente?";
				frases[8] = "Leon Scott: Sim, o fato do carro não ser comum, o assassino ter";
				frases[9] = "uma cicatriz, o motivo do assassinato, tudo isso se analisado";
				frases[10] = "com calma irá me levar ao lugar certo.";
				frases[11] = "Oficial Robert: Perfeito, volte ao departamento que me encarrego";
				frases[12] = "do resto.";
				frases[13] = "Leon Scott: Obrigado mais uma vez, lhe mando notícias.";
				maxFrases = 14;
			} else if ((tipo == 1) && (Game.CUR_LEVEL == 3)) {
				frases[0] = "Oficial Robert: Alguns itens não podem ser selecionados porém";
				frases[1] = "se você tentar equipá - los com as teclas U ou I, uma descrição";
				frases[2] = "do mesmo será demonstrada.";
				frases[3] = "Dependendo da função do item, ele pode ser apenas informativo";
				frases[4] = "ou servir para interagir com algo no cenário pressionando";
				frases[5] = "a tecla de ação J.";
				frases[6] = "Mas lembre - se, se for um item de interação, o mantenha no";
				frases[7] = "seu inventário rápido para usá - lo.";
				maxFrases = 8;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "James: Fala campeão, bom dia! Fiquei sabendo que você vai";
				frases[1] = "para o seu primeiro caso. Parabéns, você merece! Não vemos";
				frases[2] = "um jovem como você em décadas...Boa sorte na missão, e use";
				frases[3] = "o guarda - chuva, está bem complicado lá fora.";
				maxFrases = 4;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "James: Opa brother, o caso que o Capitão Ikena me passou ta";
				frases[1] = "de matar.";
				frases[2] = "Leon Scott: Precisa de ajuda?";
				frases[3] = "James: Valeu amigão mas vou me organizar e resolver.";
				frases[4] = "Boa sorte na conclusão do seu caso.";
				frases[5] = "Leon Scott: Valeu, você também.";
				maxFrases = 6;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "James: Boa mito, fiquei sabendo que conseguiu a missão.";
				frases[1] = "Leon Scott: Pois é, que bom que deu tudo certo.";
				frases[2] = "James: Ótimo cara, também tenho que me esforçar para não ficar";
				frases[3] = "para trás.";
				maxFrases = 4;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Oficial Robert: Bom dia filho, como está?";
				frases[1] = "Leon Scott: Tudo bem, senhor. O Capitão Ikena me enviou algumas";
				frases[2] = "informações sobre o assassinato, poderia me atualizar?";
				frases[3] = "Oficial Robert: Sim, o jovem se chama Nathan Price, trabalhava";
				frases[4] = "na Candy Store á três quarteirões daqui. O crime ocorreu há três";
				frases[5] = "horas, um tiro nas costas de pistola, aparentemente sem digitais";
				frases[6] = "do suspeito porém existem duas testemunhas.";
				frases[7] = "Leon Scott: Elas estão por perto?";
				frases[8] = "Oficial Robert: Sim, uma se encontra ao lado do carro rosa e a";
				frases[9] = "outra voltando ao portão, acredito que seja melhor falar com";
				frases[10] = "elas antes de entrar na casa para investigar.";
				frases[11] = "Leon Scott: Ok, depois verificarei o corpo.";
				frases[12] = "Oficial Robert: Tudo bem, o quê necessitar, estou aqui.";
				maxFrases = 13;
			
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado) && (Game.wardrobeAnalisado)
					&& ((Game.player.itemEsquerda == 3) || (Game.player.itemDireita == 3))) {
				frases[0] = "Leon Scott: Ok, consegui abrir, parece que temos um papel com";
				frases[1] = "algumas anotações da vítima.";
				frases[2] = "Melhor pegar e analisar.";
				maxFrases = 3;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 3)  && (!Game.objetivo1Completado)
					&& (((Game.player.itemDireita == 1) && (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado))|| (Game.wardrobeAnalisado)) ) {
				frases[0] = "Leon Scott: O rastro de sangue começa daqui e vai para a sala.";
				frases[1] = "Nesse caso, a vítima levou um tiro em frente a esse guarda - roupa";
				frases[2] = "e caminhou até a sala quando faleceu.";
				frases[3] = "Acredito que tenha algo importante aqui dentro mas ele está";
				frases[4] = "trancado.";
				maxFrases = 5;
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 5) && (!Game.objetivo2Completado)) {
				frases[0] = "Leon Scott: Bom dia, preciso falar com um homem chamado";
				frases[1] = "Andrey Stuart, ele se encontra?";
				frases[2] = "Porteiro: Cara, ele até se encontra mas o pessoal aqui disse";
				frases[3] = "para não deixar ninguém entrar...";
				frases[4] = "Leon Scott: E porque está me contando isso?";
				frases[5] = "Porteiro: Bom, eu não gosto de trabalhar aqui e sei que tem";
				frases[6] = "algo estranho acontecendo então se você resolver e me livrar";
				frases[7] = "desse trabalho, agradeço. Sinto que nem demissão posso pedir.";
				frases[8] = "Leon Scott: Entendo, vou entrar então.";
				frases[9] = "Porteiro: Boa sorte e cuidado, vi que estão armados.";
				maxFrases = 10;
			
			} else if ((tipo == 2) && (Game.CUR_LEVEL == 5) && (Game.objetivo2Completado) && (!Game.segredo5Encontrado)) {
				frases[0] = "Porteiro: Cara, você conseguiu dar conta de todos esses caras.";
				frases[1] = "Parece um sonho, só falta o Andrey. Toma esse diamante, você";
				frases[2] = "merece por me salvar desse trampo.";
				maxFrases = 3;
			
			} else if ((tipo == 3) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Narrador: A nossa história começa com o detetive mais promissor";
				frases[1] = "da delegacia nos últimos anos, seu nome é Leon Scott, 20 anos,";
				frases[2] = "jovem e cheio de energia, com um objetivo bem claro, se tornar";
				frases[3] = "um símbolo no ramo, como foi com o detetive mais famoso da";
				frases[4] = "cidade, Chris Stone, que desapareceu misteriosamente há um ano";
				frases[5] = "quando investigava o famoso caso \"Supreme\".";	 
				maxFrases = 6;
			} else if ((tipo == 3) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Narrador: Conforme a ordem de seu Capitão, Leon partiu.";
				frases[1] = "Ele não podia negar, estava bem ansioso para seu primeiro caso";
				frases[2] = "sozinho, afinal, seria a oportunidade de demonstrar todo o seu";
				frases[3] = "potencial e talento."; 
				maxFrases = 4;
			} else if ((tipo == 3) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "Narrador: Pistas coletadas, testemunhas abordadas, Leon estava";
				frases[1] = "confiante para resolver esse caso.";
				frases[2] = "De volta a delegacia, ele começou a analisar seus documentos";
				frases[3] = "por alguns dias para chegar onde o assassino está e assim";
				frases[4] = "fazer justiça ao jovem Nathan.";
				maxFrases = 5;
			} else if ((tipo == 3) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Narrador: Missão cumprida. Leon levou o assassino até a delegacia";
				frases[1] = "para confessar o crime. A cara de satisfação de Leon era evidente,";
				frases[2] = "e agora, mais do quê nunca, Leon estava sentindo que finalmente";
				frases[3] = "estava no caminho certo.";
				maxFrases = 4;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Capitão Ikena: Dia difícil, não acha, Leon?";
				frases[1] = "Além dessa chuva bem forte lá fora, a cidade amanheceu com um ";
				frases[2] = "assassinato a poucos kilômetros de distância...";
				frases[3] = "Parece que a nossa reputação pouco importa para os novos";
				frases[4] = "criminosos.";
				frases[5] = "Leon Scott: Ahh...não sei lhe dizer, senhor, acredito que temos";
				frases[6] = "que descobrir o quê aconteceu e levar esse assassino a justiça.";
				frases[7] = "Capitão Ikena: De fato, Leon, o estive observando, sei que você";
				frases[8] = "está pronto para prosseguir em seu primeiro caso sozinho, o";	
				frases[9] = "Sargento Steve me informou que você foi surpreendente no seu";
				frases[10] = "caso anterior, realizando todos os procedimentos de forma";
				frases[11] = "rápida e eficaz, e, devido a isso, acredito que consiga";
				frases[12] = "prosseguir com esse trabalho, estou correto?";
				frases[13] = "Leon Scott: Seria uma honra, senhor.";
				frases[14] = "Capitão Ikena: Ótimo, então está decidido. As informações que";
				frases[15] = "possuímos do caso serão enviadas no seu celular.";
				frases[16] = "Devido a essa chuva, sugiro levar seu guarda - chuva, o James";
				frases[17] = "me informou que o usou hoje, deve estar com ele.";
				frases[18] = "Ahh...seu monóculo, ele está com o John, seria importante você";
				frases[19] = "levar ele também.";
				frases[20] = "Leon Scott: Sim senhor, pode deixar.";
				maxFrases = 21;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Leon Scott: Ok, o lugar do assassinato está logo a frente.";
				frases[1] = "De acordo com as informações, a vítima é um homem, 30 anos, sem";
				frases[2] = "histórico criminal, aparentemente uma pessoa comum.";
				frases[3] = "Certo...relaxa, vou encontrar o oficial Robert para mais";
				frases[4] = "informações.";
				frases[5] = "E que chuva! É melhor eu continuar usando o guarda - chuva, se";
				frases[6] = "não eu vou ficar muito doente.";
				maxFrases = 7;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 3)) {
				frases[0] = "Oficial Robert: Parece que foi ontem que vi você com o Steve no";
				frases[1] = "seu primeiro caso...E agora você está aqui, sozinho.";
				frases[2] = "O tempo passa muito rápido, apesar de só ter sido seis meses.";
				frases[3] = "Enfim, perdoe o sentimentalismo desse homem velho aqui.";
				frases[4] = "Leon Scott: É uma honra trabalhar com o senhor. Me ajudou e";
				frases[5] = "continua a me ajudar nas minhas dificuldades. Espero resolver";
				frases[6] = "esse crime como nas outras ocasiões.";
				frases[7] = "Oficial Robert: E irá, filho, confio em você.";
				frases[8] = "Ok, vamos ao o quê importa...Como você pode ver de primeira, o";
				frases[9] = "assassino não foi muito descuidado, então temos que analisar bem";
				frases[10] = "a casa para descobrir as pistas. O quê consigo te ajudar a";
				frases[11] = "princípio foi que a vítima tinha uma chave no bolso.";
				frases[12] = "Então podemos começar por isso.";
				frases[13] = "Leon Scott: Sim, concordo.";
				frases[14] = "Oficial Robert: Certo, use todos os seus artifícios, boa sorte.";				
				frases[15] = "Narrador: Você agora tem mais de dois itens, seu inventário está";
				frases[16] = "disponivel, acesse com a tecla O e escolha o item a ser";
				frases[17] = "selecionado na esquerda pressionando a tecla U e na direita";
				frases[18] = "pressionando a tecla I.";
				maxFrases = 19;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "Leon Scott: Certo, vamos revisar todas as pistas antes de ir.";
				frases[1] = "O carro do assassino realmente é um carro raro na região.";
				frases[2] = "De acordo com a placa, ele pertence a uma senhora de 50 anos.";
				frases[3] = "Ao entrar em contato com ela e verificar, o carro não foi";
				frases[4] = "roubado e usado por nenhuma pessoa. Chequei tudo o quê pude";
				frases[5] = "do histórico dela de amigos e parentes e nenhum se encaixa na";
				frases[6] = "descrição do suspeito porém um fator importante foi dito por ela,";
				frases[7] = "o carro havia dado alguns problemas mecânicos e ficou na oficina";
				frases[8] = "Baker no mesmo dia que ocorreu o assassinato.";
				frases[9] = "Além do mais, nessa oficina existe uma pessoa com cicatriz e";
				frases[10] = "barba, conforme a descrição do assassino.";
				frases[11] = "Não há dúvidas, fora que existem rumores dessa oficina prestar";
				frases[12] = "serviços ilegais como esse.";				
				frases[13] = "O quê tenho que fazer é ir lá, achar o assassino e trazê - lo";
				frases[14] = "até aqui para confessar e entregar o seu empregador.";
				frases[15] = "Mas antes de mais nada, melhor pegar os armamentos necessários";
				frases[16] = "para não ser surpreendido.";
				maxFrases = 17;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 5)) {
				frases[0] = "Leon Scott: Em alguns minutos chego na oficina.";
				frases[1] = "Espero que dê tudo certo, boa sorte para mim.";
				maxFrases = 2;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 6)) {
				frases[0] = "Andrey: Parece que não é só o cérebro que funciona.";
				frases[1] = "Você conseguiu derrotar todos os meus companheiros.";
				frases[2] = "Mas agora se prepare, vai desejar nunca ter nascido.";
				maxFrases = 3;
			} else if ((tipo == 4) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Capitão Ikena: Muito bem, Leon. O Andrey confessou o crime e";
				frases[1] = "entregou o empregador, o chefe de Nathan.";
				frases[2] = "Infelizmente a corrupção é recorrente hoje em dia mas fico feliz";
				frases[3] = "por existir jovens como você para levar a justiça a esses";
				frases[4] = "criminosos.";
				frases[5] = "Leon Scott: Obrigado, senhor. Espero continuar nessa crescente";
				frases[6] = "e resolver o máximo de casos possíveis.";
				frases[7] = "Capitão Ikena: De fato, Leon, o Sargento Steve retornou e está";
				frases[8] = "ao lado de sua mesa. Ele me informou que gostaria de te";	
				frases[9] = "parabenizar.";
				frases[10] = "Leon Scott: Que bom que ele voltou, irei lá agora mesmo!";
				frases[11] = "Capitão Ikena: Perfeito, até logo.";
				maxFrases = 12;
			}  else if ((tipo == 5) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "John: Cara, esse monóculo salva vidas, obrigado parceiro,";
				frases[1] = "prometo comprar um desse para mim.";
				maxFrases = 2;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "John: Leon, você perdeu o Capitão na sala de depoimento atrás";
				frases[1] = "de mim a algumas horas dando um espetáculo acusando um";
				frases[2] = "assassino que a Chloe pegou, ele não teve nenhuma chance, deu";
				frases[3] = "até medo! Mudando de assunto, eu sempre tive essa dúvida, seu";
				frases[4] = "nome tem relação com aquele personagem de terror daquele jogo";
				frases[5] = "antigo?";
				frases[6] = "Leon Scott: Sim, meu pai é um grande fã e me deu esse nome em";
				frases[7] = "homenagem a ele...";
				frases[8] = "John: Da hora, eu queria que meu pai me chamasse de Matt";
				frases[9] = "Murdock, cairia perfeito em mim!";
				maxFrases = 10;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "John: Como esperado, você conseguiu!";
				frases[1] = "Leon Scott: Sim, deu trabalho mas peguei o assassino.";
				frases[2] = "John: Boa, me conta tudo depois, quero saber a história do nosso";
				frases[3] = "novo herói!";
				maxFrases = 4;
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 2) && (Game.objetivo1Completado)) {
				frases[0] = "Testemunha 2: Bom dia, você é o detetive?";
				frases[1] = "Leon Scott: Sim, sou eu, bom dia.";
				frases[2] = "Testemunha 2: Você é mais jovem do quê pensei...Espero ajudar.";
				frases[3] = "Leon Scott: Com certeza irá! O quê o senhor viu?";
				frases[4] = "Testemunha 2: Depois do barulho do tiro, eu sai de casa para ver";
				frases[5] = "o quê estava havendo. Meu coração ficou acelerado pois eu";
				frases[6] = "conheço o barulho de um tiro de longe.";
				frases[7] = "Infelizmente eu cheguei tarde e a única coisa que vi foi o carro";
				frases[8] = "do assassino e a placa.";
				frases[9] = "Era uma Mitsubishi 2008, placa RJE - 2402. Não é comum esse tipo";
				frases[10] = "de carro por essas bandas.";
				frases[11] = "Leon Scott: Verdade, isso será de grande ajuda. Muito obrigado.";
				frases[12] = "Testemunha 2: Por nada, espero que consiga fazer justiça por nós.";
				maxFrases = 13; 
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 3) && (!Game.objetivo2Completado) && (!Game.papelAnalisado)) {
				frases[0] = "Leon Scott: Um cofre...A senha parece se referir a uma data.";
				frases[1] = "Não faço ideia do quê seria, talvez tenha alguma pista na casa.";
				maxFrases = 2; 
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 3) && (!Game.objetivo2Completado) && (Game.papelAnalisado) && (Game.puzzle.puzzleResolvido) && (Game.itemsPersonagem.items[5][1] == 0)) {
				frases[0] = "Leon Scott: Um diário dentro de um cofre, com certeza deve ser";
				frases[1] = "importante, vou analisar com muita calma esse item.";
				maxFrases = 2; 
			} else if ((tipo == 5) && (Game.CUR_LEVEL == 3) && (!Game.objetivo2Completado) && (Game.papelAnalisado) && (!Game.puzzle.puzzleResolvido) && (Game.itemsPersonagem.items[5][1] == 0)) {
				frases[0] = "Leon Scott: A senha parece não ser essa.";
				maxFrases = 1; 
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Aurelio: A sala de armas atrás de mim está em manutenção.";
				frases[1] = "Espero que abra logo, estou doido para testar essas belezinhas.";
				maxFrases = 2;
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 4) && (!Game.objetivo1Completado)) {
				frases[0] = "Aurelio: Finalmente, a sala está aberta, estava com saudades delas.";
				frases[1] = "Leon Scott: Olá, Aurelio, estou precisando de armamento.";
				frases[2] = "Aurelio: Opa, com certeza, irei te providenciar uma pistola, faca";
				frases[3] = "e munições de primeira para você, está bem?";
				frases[4] = "Leon Scott: Sim, ótimo.";
				frases[5] = "Aurelio: Perfeito, tem alguns outros itens que podem te interessar.";
				frases[6] = "Dê uma olhada neles.";
				maxFrases = 7;
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 4) && (Game.objetivo1Completado)) {
				frases[0] = "Aurelio: Olá, fique a vontade para escolher o quê você precisa.";
				maxFrases = 1;
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Aurelio: Olá, fique a vontade para escolher o quê você precisa.";
				maxFrases = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 5) && (!Game.dialogoCompleto)) {
				frases[0] = "Aurelio: Opa, parece que cheguei a tempo.";
				frases[1] = "Leon Scott: O quê faz aqui, Aurelio?";
				frases[2] = "Aurelio: O Capitão disse que você poderia precisar de suporte";
				frases[3] = "então cá estou. Dê uma olhada nos armamentos e pegue o quê";
				frases[4] = "você precisar.";
				maxFrases = 5;
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 5) && (Game.dialogoCompleto)) {
				frases[0] = "Aurelio: Olá, fique a vontade para escolher o quê você precisa.";
				maxFrases = 1;
			} else if ((tipo == 6) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Morador 2: Ainda estou tentando processar o quê aconteceu...";
				frases[1] = "É uma trajédia, gostava muito desse moço, lembro que ele ajudou";
				frases[2] = "meu filho a fazer a tarefa de casa sobre plantas exóticas";
				frases[3] = "pesquisando algumas que temos perto do carro rosa.";
				frases[4] = "Ele tirou um A, nunca o tinha visto tão feliz!";
				maxFrases = 5; 
			}  else if ((tipo == 6) && (Game.CUR_LEVEL == 3)) {
				frases[0] = "Leon Scott: Pela quantidade de medicamentos nesse armário,";
				frases[1] = "parece que ele estava tendo muitos problemas com ansiedade e";
				frases[2] = "insônia.";
				maxFrases = 3; 
			} else if ((tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (!Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
					|| ((Game.player.itemDireita != 1) || (Game.player.itemDireita != 1)))
					&& (!Game.segredo1Encontrado) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Leon Scott: Hmm...a Anne esqueceu sua bolsa.";
				frases[1] = "Deve ter muita coisa importante para trazer para o trabalho pois";
				frases[2] = "essa bolsa é grande para ela, o quê será que deve ter ai?";
				maxFrases = 3;
			} else if ((tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
					&& (!Game.segredo1Encontrado) && (Game.CUR_LEVEL == 1)) {
				frases[0] = "Leon Scott: Olha, na bolsa da Anne está o quadro que ela tinha me";
				frases[1] = "prometido. Vou aproveitar para pegar.";
				maxFrases = 2;
			} else if ((tipo == 7) && (!Game.segredo2Encontrado) && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Leon Scott: Parece um tipo de amuleto.";
				frases[1] = "Hm, se aquele senhor estranho visse um item desses aqui, com";
				frases[2] = "certeza iria chamar um exorxista para benzer o lugar.";
				frases[3] = "Acho que ninguém irá se importar se eu levar comigo, gosto de";
				frases[4] = "colecionar itens assim.";
				maxFrases = 5;
			} else if ((tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (!Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (!Game.player.itemEsquerdaSelecionado)) 
					|| ((Game.player.itemDireita != 1) && (Game.player.itemEsquerda != 1)) || (Game.objetivo3Completado))
					 && (Game.CUR_LEVEL == 3)) {
				frases[0] = "Leon Scott: Hmm...Na casa da minha vó era comum guardar coisas";
				frases[1] = "nos vasos, será que tem algo ai?";
				maxFrases = 2;
			} else if ((tipo == 7) && (((Game.player.itemDireita == 1) 
					&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
					&& (!Game.objetivo3Completado) && (Game.CUR_LEVEL == 3)) {

				frases[0] = "Leon Scott: Uma chave prata, pode ser útil para algo.";
				maxFrases = 1;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 4)) {
				frases[0] = "Anne: Olá, Leon...que bom te ver de novo.";
				frases[1] = "Leon Scott: Olá Anne, como estão indo as coisas com a sua mãe?";
				frases[2] = "Anne: Tudo bem, obrigada por perguntar, finalmente ela saiu do";
				frases[3] = "hospital e está em casa descansando.";
				frases[4] = "Leon Scott: Ótimo, fico feliz em saber.";
				frases[5] = "Anne: Pois é, ela merece, tadinha.";
				frases[6] = "A propósito, adorei aquela hamburgueria que você recomendou.";
				frases[7] = "Leon Scott: Boa né? A gente poderia ir lá de novo algum dia.";
				frases[8] = "Anne: Sério?";
				frases[9] = "Leon Scott: Sim, aposto que a galera também iria gostar.";
				frases[10] = "Anne: Ah...Sim, claro, vamos marcar com eles então.";
				maxFrases = 11;
			} else if ((tipo == 7) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Anne: Leon! Que bom que você conseguiu e está bem, estou feliz!";
				frases[1] = "Leon Scott: Obrigado Anne, estou muito feliz também.";
				frases[2] = "Anne: Pois é, primeiro caso sozinho, imagino como você está.";
				frases[3] = "Você me inspira a ser uma alguém melhor, tanto profissionalmente";
				frases[4] = "como pessoalmente, sabia?";
				frases[5] = "Leon Scott: Fico muito feliz, de todas as secretárias que conheço,";
				frases[6] = "você é a melhor delas!";
				frases[7] = "Anne: Ah...obrigada, não sei nem o quê dizer...";
				frases[8] = "Leon Scott: Apenas vamos continuar dando o nosso melhor.";
				frases[9] = "Anne: Sim, vamos!";
				maxFrases = 10;
			} else if (tipo == 8) {
				frases[0] = "Leon Scott: Melhor não usar esse item aqui.";
				maxFrases = 1;
			} else if ((tipo == 9) && (Game.objetivo1Completado)  && (Game.CUR_LEVEL == 2)) {
				frases[0] = "Testemunha 1: Opa, tu é o detetive boladão da parada né?";
				frases[1] = "Leon Scott:...";
				frases[2] = "Testemunha 1: É você mesmo, ele disse que um loirinho ia vir.";
				frases[3] = "Maluco, foi barulheira para todo lado, eu só tava ali no meu";
				frases[4] = "cantinho, curtindo a minha vibe sacou? Do nada o mano saiu";
				frases[5] = "correndo da casa do Nathan, já vi que tinha dado ruim.";
				frases[6] = "Leon Scott: Você viu o criminoso?";
				frases[7] = "Testemunha 1: Vi como ninguém, tinha um bigode, um cavanhaque,";
				frases[8] = "era uma pessoa branca além de uma cicatriz na bochecha,";
				frases[9] = "bem feia por sinal, ta ligado?";
				frases[10] = "Leon Scott: Entendi, obrigado pelas informações.";
				frases[11] = "Testemunha 1: Por nada bro, tamo junto nessa fita ai.";
				frases[12] = "Leon Scott: Ahh...ok.";
				maxFrases = 13;
			} else if ((tipo == 9) && ((Game.player.itemDireita != 2) && (Game.player.itemEsquerda != 2)) && (Game.CUR_LEVEL == 3) && (!Game.portaAberta)) {
				frases[0] = "Leon Scott: A porta está trancada, preciso de uma chave para abrir.";
				maxFrases = 1;
			} else if ((tipo == 9) && ((Game.player.itemDireita == 2) || (Game.player.itemEsquerda == 2)) && (Game.CUR_LEVEL == 3) && (!Game.portaAberta)) {
				frases[0] = "Leon Scott: Ok, consegui abrir a porta.";
				maxFrases = 1;
			} else if ((tipo == 9) && ((Game.player.itemDireita == 8) || (Game.player.itemEsquerda == 8))
						&& (!Game.objetivo4Completado) && (Game.CUR_LEVEL == 4)) {

				frases[0] = "Leon Scott: Ok, agora posso pegar a chave do meu pai.";
				maxFrases = 1;
				
			} else if ((tipo == 9) && (!Game.segredo4Encontrado)  && (Game.CUR_LEVEL == 4)) {
				frases[0] = "Leon Scott: Hmm, o meu armário está trancado, preciso abrir";
				frases[1] = "para pegar a chave da moto do meu pai e entregar para ele.";
				maxFrases = 2;
			} else if ((tipo == 9) && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Capitão Ikena: Continue assim, detetive, que você irá longe!";
				maxFrases = 1; 
			}  else if (tipo == 10) {
				frases[0] = "Leon Scott: Uma chave dourada encontrada. Serve para abrir algo.";
				maxFrases = 1;
			} else if (tipo == 11) {
				frases[0] = "Leon Scott: Parece um papel com algumas anotações, vamos ver:";
				frases[1] = "\"- Desde o dia do nascimento de Jesus, a humanidade foi";
				frases[2] = "abençoada e salva de seus pecados. No mês seguinte ao seu";
				frases[3] = "nascimento, todos estavam felizes e confiantes na justiça que";
				frases[4] = "viria. Passou - se muitos anos e mesmo agora, o último ano do";
				frases[5] = "século XX, estou crendo no senhor para que ele abençoe a minha";
				frases[6] = "família e meu sobrinho que está nascendo.\"";
				frases[7] = "Hmm, será que esse texto pode me ajudar em algo?";
				maxFrases = 8;
			} else if (tipo == 12) {
				frases[0] = "Leon Scott: Vamos ver o quê está escrito nesse diário:";
				frases[1] = "\"- Parece que eles notaram, não posso esperar mais se não vão me";
				frases[2] = "matar. Preciso ir na delegacia confessar os crimes de corrupção da";
				frases[3] = "empresa. Deus quer justiça no mundo e não posso deixar isso de";
				frases[4] = "lado. Meu sonho de trabalhar na contabilidade tem que ser";
				frases[5] = "honrado agora mais do quê nunca. Vou para casa tomar um banho";
				frases[6] = "e amanhã ir na delegacia. 04 de Março de 2021.\"";
				frases[7] = "Leon Scott: Isso foi ontem...Parece que eles estavam realmente";				
				frases[8] = "de olho nele. Hmm...tem algo a mais aqui:";	
				frases[9] = "\"- PS: Lembrar de deixar a medalha do sobrinho embaixo do";
				frases[10] = "travesseiro para dar sorte a ele no seu próximo campeonato.\"";
				maxFrases = 11;
			} else if (tipo == 13) {
				frases[0] = "Leon Scott: Uma chave prata encontrada. Serve para abrir algo.";
				maxFrases = 1;
			} else if ((tipo == 14) && (!Game.segredo3Encontrado) && (Game.diarioLido)  && (Game.CUR_LEVEL == 3)) {
				frases[0] = "Leon Scott: A medalha ta embaixo do travesseiro, prometo cuidar";
				frases[1] = "dela e dar ao seu sobrinho, Nathan.";
				maxFrases = 2;
			} else if ((tipo == 14)  && (Game.CUR_LEVEL == 7)) {
				frases[0] = "Sargento Steve: Leon, o homem do momento, parabéns!";
				frases[1] = "Leon Scott: Obrigado, senhor, consegui me dar bem nessa!";
				frases[2] = "Sargento Steve: Senhor? Sem formalismo com seu amigão.";
				frases[3] = "Não poderia estar mais orgulho de você, parceiro.";
				frases[4] = "Leon Scott: Tudo graças a você.";
				frases[5] = "Sargento Steve: Haha, é, tenho um pouco de crédito por te ensinar";
				frases[6] = "minhas técnicas. Enfim, Leon, temos muito o quê conversar mas vá";
				frases[7] = "para casa descansar e amanhã prosseguimos. Tenho certeza que";
				frases[8] = "irá gostar do quê irei falar.";
				frases[9] = "É sobre o caso Supreme (falando baixo).";
				frases[10] = "Leon Scott: Sério? Mal posso esperar (falando baixo).";
				frases[11] = "Sargento Steve: Com certeza, até logo!";
				maxFrases = 12;
			} else if (tipo == 15) {
				frases[0] = "Leon Scott: Uma chave verde. Serve para abrir algo.";
				maxFrases = 1;
			
			} else tipo = 0;
		}
	   this.tipoNPC = tipo;
   }
   
	public void tick() {
		if (Game.permissao) {
		if  ((Game.messageNPC) && (this.tipoNPC!= 0)) {
			if ((fraseIndex == 0) && (this.tipoNPC == 4) && (Game.CUR_LEVEL == 2) && (!Game.chuvaAllowed)) {
				Game.chuvaAllowed = true;
				AudioPlayer.playLoopSoundRain(AudioClip.rain,0.5,4);
			}
							
			this.time++;
			if (this.time >= this.maxTime) {
				this.time = 0;
				if (fraseIndex == -1) {
					fraseIndex = 0;	
					Game.evitarErro = true;
				}
				if (curIndexMsg < frases[fraseIndex].length() -1) {
					curIndexMsg++;
				}else {
					if (fraseIndex < frases.length - 1) {
						this.timeFrase++;
						if (this.timeFrase >= this.maxTimeFrase) {
							this.timeFrase = 0;
							fraseIndex++;
							curIndexMsg = 0;
						}
				
					}
				}
			}
			
			if ((this.fraseIndex >= maxFrases) && (Game.estado_cena == Game.jogando)) {
				this.fraseIndex = -1;
				Game.player.right = false;
				Game.player.up = false;
				Game.player.left = false;
				Game.player.down = false;
				curIndexMsg = 0;
				Game.messageNPC = false;									
				Game.gameState = "NORMAL";
				if ((!showMessage7) && (!showMessage8) && (!showMessage9) && (!showMessage10) && (!showMessage11) && (!showMessage13)) {
					if (showMessage1)
						showMessage1 = false;
					if (showMessage2)
						showMessage2 = false;
					if (showMessage3)
						showMessage3 = false;
					if (showMessage4)
						showMessage4 = false;
					if (showMessage5)
						showMessage5 = false;
					if (showMessage6)
						showMessage6 = false;
					if (showMessage12)
						showMessage6 = false;

					
				for (int i = 0;i < Game.npcs.size();i++) {
					if ((npcX == Game.npcs.get(i).npcX) &&
					    (npcY == Game.npcs.get(i).npcY)){
						Game.npcs.get(i).fraseHabilitada = false;
						if (Game.npcs.get(i).tipo == 2) {
							if (Game.npcs.get(i).tipoFrase == 2) {
								Game.objetivo1Completado = true;
								if (Game.CUR_LEVEL == 1) {
									Game.itemsPersonagem.items[0][1] = 1;
									Game.player.itemEsquerda = 0;
									AudioPlayer.playSound(AudioClip.umbrella,2,0);
								}
							}
							
							if ((Game.CUR_LEVEL == 5) && (!Game.objetivo1Completado)) {
								Game.objetivo1Completado = true;
							}
							
							if ((Game.CUR_LEVEL == 5) && (Game.objetivo2Completado) && (!Game.segredo5Encontrado)) {
								Game.segredo5Encontrado = true;
								AudioPlayer.playSound(AudioClip.secret,2,0);
								Game.mensagemJ[1] = false;
							}
							
							if ((Game.npcs.get(i).tipoFrase == -1) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado)  && (Game.wardrobeAnalisado)
									&& ((Game.player.itemEsquerda == 3) || (Game.player.itemDireita == 3))) {
								Game.objetivo1Completado = true;
								Game.itemsPersonagem.items[4][1] = 1;
								AudioPlayer.playSound(AudioClip.papel,2,0);
										Game.itemsPersonagem.items[3][1] = 0;
										if (Game.player.itemEsquerda == 3) {
											Game.player.itemEsquerda = -1;
											Game.player.itemEsquerdaSelecionado = false;
											
										}
										if (Game.player.itemDireita == 3) {
											Game.player.itemDireita = -1;
											Game.player.itemDireitaSelecionado = false;
											
										}
										Game.mensagemJ[1] = false;
							} else
								if ((Game.npcs.get(i).tipoFrase == -1) && (Game.CUR_LEVEL == 3) && (!Game.objetivo1Completado)
										&& (((Game.player.itemEsquerda == 1) 
										&& (Game.player.itemEsquerdaSelecionado)) || ((Game.player.itemDireita == 1) && (Game.player.itemDireitaSelecionado)) || (Game.wardrobeAnalisado)))
										 {
									Game.wardrobeAnalisado = true;
								}
						}
						
						if ((Game.npcs.get(i).tipo == 1) && (Game.CUR_LEVEL == 3) && (Game.diarioLido) && (Game.objetivo4Completado)) {
							Game.objetivo5Completado = true;
						
						}
						
						
						if ((Game.npcs.get(i).tipo == 1) && (Game.CUR_LEVEL == 2)) {
							if (Game.npcs.get(i).tipoFrase == 1) {
								Game.objetivoOpcional1Completado = true;
							}
						}
					
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 2)) {
							if (Game.npcs.get(i).tipoFrase == 1) {
								Game.objetivoOpcional2Completado = true;

							}
						}
						
						
						
						if (Game.npcs.get(i).tipo == 5) {
							if (Game.npcs.get(i).tipoFrase == 2) {
								Game.objetivo2Completado = true;
								if (Game.CUR_LEVEL == 1) {
									Game.itemsPersonagem.items[1][1] = 1;
									Game.player.itemDireita = 1;
									AudioPlayer.playSound(AudioClip.monoculo,2,0);
								}
							}
							if ((Game.npcs.get(i).tipoFrase == -1) && (Game.CUR_LEVEL == 3) 
									&& (Game.puzzle.puzzleResolvido)) {
										Game.objetivo2Completado = true;
										Game.itemsPersonagem.items[5][1] = 1;
										AudioPlayer.playSound(AudioClip.diario,2,0);
										Game.itemsPersonagem.items[4][1] = 0;
										if (Game.player.itemEsquerda == 4) {
											Game.player.itemEsquerda = -1;
											Game.player.itemEsquerdaSelecionado = false;
											
										}
										if (Game.player.itemDireita == 4) {
											Game.player.itemDireita = -1;
											Game.player.itemDireitaSelecionado = false;
										}
										Game.mensagemJ[2] = false;
							}
						}
						
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 3)) {
							Game.objetivo4Completado = true;
						}
						
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 5) && (!Game.dialogoCompleto) && (Game.permissao)) {								
							Game.gameState = "SHOP";
							Game.permissao = false;
							Game.desligarLigarMusica(Game.CUR_LEVEL);
							Game.dialogoCompleto = true;
							Game.inventary.definirInventario();	
							Game.shop.definirShop();	
							
						} else
						
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 5) && (Game.dialogoCompleto) && (Game.permissao)) {									
							Game.gameState = "SHOP";
							Game.permissao = false;
							Game.desligarLigarMusica(Game.CUR_LEVEL);
							Game.inventary.definirInventario();	
							Game.shop.definirShop();
						}
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 4) && (!Game.objetivo1Completado) && (Game.permissao)) {
							Game.objetivo1Completado = true;
							Game.gameState = "SHOP";
							Game.permissao = false;
							Game.desligarLigarMusica(Game.CUR_LEVEL);
							Game.itemsPersonagem.items[6][1] = 1;
							Game.itemsPersonagem.items[7][1] = 1;
							Game.player.ammo =+ 20;
							Game.player.lifeKnife = 100;
							Game.inventary.definirInventario();								
							Game.shop.definirShop();	
						} else
						
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 4) && (Game.objetivo1Completado) && (Game.permissao)) {
							Game.gameState = "SHOP";
							Game.permissao = false;
							Game.desligarLigarMusica(Game.CUR_LEVEL);
							Game.inventary.definirInventario();	
							Game.shop.definirShop();	
						}
						
						if ((Game.npcs.get(i).tipo == 6) && (Game.CUR_LEVEL == 7) && (Game.permissao)) {
							Game.gameState = "SHOP";
							Game.permissao = false;
							Game.desligarLigarMusica(Game.CUR_LEVEL);
							Game.inventary.definirInventario();	
							Game.shop.definirShop();	
						}
						
						if (Game.npcs.get(i).tipo == 9) {
							if (Game.npcs.get(i).tipoFrase == 2) {
								Game.objetivo3Completado = true;
							}
							if ((Game.npcs.get(i).tipoFrase == -1) && (Game.CUR_LEVEL == 3) 
									&& (Game.player.itemEsquerda == 2) || (Game.player.itemDireita== 2)) {
								Game.portaAberta = true;
								Game.itemsPersonagem.items[2][1] = 0;
								if (Game.player.itemEsquerda == 2) {
									Game.player.itemEsquerda = -1;
									Game.player.itemEsquerdaSelecionado = false;
									
								}
								if (Game.player.itemDireita == 2) {
									Game.player.itemDireita = -1;
									Game.player.itemDireitaSelecionado = false;
								}
								Game.mensagemJ[5] = false;
							}
						}
						
						if ((Game.npcs.get(i).tipo == 9) && (Game.CUR_LEVEL == 4) && (!Game.segredo4Encontrado) 
								&& ((Game.player.itemDireita == 8) || (Game.player.itemEsquerda == 8))) {
							Game.segredo4Encontrado = true;
							Game.mensagemJ[5] = false;
							AudioPlayer.playSound(AudioClip.secret,2,0);
							if (Game.player.itemEsquerda == 8) {
								Game.player.itemEsquerda = -1;
								Game.player.itemEsquerdaSelecionado = false;
								
							}
							if (Game.player.itemDireita == 8) {
								Game.player.itemDireita = -1;
								Game.player.itemDireitaSelecionado = false;
							}
							Game.itemsPersonagem.items[8][1] = 0;
							Game.itemsPersonagem.items[8][3] = 0;
						}
						
						if ((Game.npcs.get(i).tipo == 14) && (!Game.segredo3Encontrado) && (Game.CUR_LEVEL == 3) && (Game.diarioLido)) {									
							Game.segredo3Encontrado = true;
							AudioPlayer.playSound(AudioClip.secret,2,0);
							Game.mensagemJ[11] = false;
							
						}
						
						if ((Game.npcs.get(i).tipo == 14)  && (Game.CUR_LEVEL == 7)) {									
							Game.objetivo1Completado = true;
						}
						
						
						if ((Game.npcs.get(i).tipo == 7) && (((Game.player.itemDireita == 1) 
								&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
								&& (!Game.segredo1Encontrado) && (Game.CUR_LEVEL == 1)) {
							Game.segredo1Encontrado = true;
							AudioPlayer.playSound(AudioClip.secret,2,0);
								Game.mensagemJ[4] = false;
						} else if ((Game.npcs.get(i).tipo == 7)  && (!Game.segredo2Encontrado) && (Game.CUR_LEVEL == 2)) {
							Game.segredo2Encontrado = true;
							AudioPlayer.playSound(AudioClip.secret,2,0);
							Game.entities.remove(Game.npcs.get(i));
							Game.npcs.remove(Game.npcs.get(i));
							Game.mensagemJ[4] = false;
						} else if ((Game.npcs.get(i).tipo == 7) && (((Game.player.itemDireita == 1) 
								&& (Game.player.itemDireitaSelecionado)) || ((Game.player.itemEsquerda == 1) && (Game.player.itemEsquerdaSelecionado)))
								&& (Game.CUR_LEVEL == 3)) {
							Game.objetivo3Completado = true;
							Game.itemsPersonagem.items[2][1] = 1;
							AudioPlayer.playSound(AudioClip.chave,2,0);
							Game.mensagemJ[4] = false;

						} 
							
						if (Game.npcs.get(i).tipoFrase != -1)
								Game.npcs.get(i).tipoFrase = 0;
						break;
					}
				}
			}
				if (showMessage7)
					showMessage7 = false;
				if (showMessage8)
					showMessage8 = false;
				if (showMessage9)
					showMessage9 = false;
				if (showMessage10)
					showMessage10 = false;
				if (showMessage11)
					showMessage11 = false;
				if (showMessage13)
					showMessage13 = false;
				
			}
			
			if ((this.fraseIndex >= this.maxFrases) && (Game.estado_cena == Game.cutScene)) {
				Game.phrases.curIndexMsg = 0;
				Game.cutscenes.fraseTerminada = true;
				Game.estado_cena = Game.comecar;
				Game.gameState = "NORMAL";
				Game.messageNPC = false;
				this.showMessage1 = false;
				this.showMessage2 = false;
				this.showMessage3 = false;
				this.showMessage1 = false;
				this.showMessage2 = false;
				this.showMessage3 = false;
				this.showMessage4 = false;
				this.showMessage5 = false;
				this.showMessage6 = false;
				this.showMessage7 = false;
				this.showMessage8 = false;
				this.showMessage9 = false;
				this.showMessage10 = false;
				this.showMessage11 = false;
				this.showMessage12 = false;
				this.showMessage13 = false;;
				if (Game.cutscenes.numero == 2) {
					Game.cutscenes.SegundaCutScene = false;
					Game.cutscenes.cutSceneTerminada = true;
					fraseIndex = -1;
				} else
					fraseIndex = 0;

				
				if (Game.cutscenes.numero == 1) {
					Game.cutscenes.numero = 2;
					Game.cutscenes.SegundaCutScene = true;
				}

			}

			
		} 
		}
	}
	
	public void render(Graphics g) {	

		if (Game.permissao) {
			if (Game.cutscenes.numero == 1) {		
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);				
				
			} 
		
		if ((Game.messageNPC) && (this.tipoNPC!= 0)){
			g.setColor(Color.white);
			g.fillRect(1, (Game.HEIGHT * Game.SCALE) - 60,478,60);
			g.setColor(Color.blue);
			g.fillRect(2, (Game.HEIGHT * Game.SCALE) - 59,476,58);
			g.setFont(new Font("Arial",Font.BOLD,14));
			g.setColor(Color.white);
			if (fraseIndex <= -1)
				fraseIndex = 0;
				
			
			if (fraseIndex % 2 == 0) {
				g.drawString(frases[fraseIndex].substring(0, curIndexMsg + 1), 4, (Game.HEIGHT * Game.SCALE) - 25);		
			} else {
				g.drawString(frases[fraseIndex - 1].substring(0, frases[fraseIndex - 1].length()), 4, (Game.HEIGHT * Game.SCALE) - 25);		
				g.drawString(frases[fraseIndex].substring(0, curIndexMsg + 1), 4, (Game.HEIGHT * Game.SCALE) - 8);
			}
			
			g.setFont(new Font("arial",Font.BOLD,12));
			g.setColor(Color.green);
			
			g.drawString("Pressione K para pular o diálogo.",((Game.WIDTH/2) * Game.SCALE) - 235, (Game.HEIGHT * Game.SCALE) - 45);
			g.drawString("Pressione J para avançar o diálogo.",((Game.WIDTH/2) * Game.SCALE) + 35, (Game.HEIGHT * Game.SCALE) - 45);

								
		}
		} else {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);	
			
		}
	}

}