package by.mk.mvnex.Poke_Poke_01;

import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Iterator;

import com.sun.tools.javac.parser.JavacParser;



public class Notation {


	int levels[];
	public int favorite  = 7;
	public  int gems=300;
	public int maxCombo = 0;//Сделать это часть класса Map который входит сюда но пока public
	public int maxScore = 0;
	public int maxNotes = 0;
	public int earnedGEM = 0;
	public int playedOnce = 0;
	public int[] levelDesignation = {100, 300, 600, 1000, 1500, 2100, 2800, 3600, 4400,5300};
	public int[] levelCost = { 150, 300, 600, 1200, 2400, 4800, 9600, 19200,38400, 0};
	public Team team;
	public int[] keys;
	public Notation() {
		team = new Team();
		levels = new int[9];
		levels[0] = 1;
		levels[1] = 2;
		levels[2] = 3;
		levels[3] = 4;
		levels[4] = 5;
		levels[5] = 6;
		levels[6] = 7;
		levels[7] = 8;
		levels[8] = 9;
		//вызвать их узнать их лвл
		// узнать назначенные клавиши
		keys = new int[6];
		keys[0] = KeyEvent.VK_D;
		keys[1] = KeyEvent.VK_F;
		keys[2] = KeyEvent.VK_G;
		keys[3] = KeyEvent.VK_H;
		keys[4] = KeyEvent.VK_J;
		keys[5] = KeyEvent.VK_K;;
	}
	
	
}
