package by.mk.mvnex.Poke_Poke_01;

import java.awt.Image;

import javax.swing.ImageIcon;

import by.mk.mvnex.Poke_Poke_01.Interface.playFrame;

public class PlayHandler extends Thread{
	private playFrame panel;
	private InterfaceHandler handler;
	PlayHandler( playFrame p, InterfaceHandler h){
		panel = p;
		handler = h;
	}
	public void run() {
		new Play(1,panel).start();
		try {
			sleep(1000);
		} catch(Exception ex) {}
		
		new Play(2,panel).start();
		try {
			sleep(1000);
		} catch(Exception ex) {}
		
		new Play(3,panel).start();
		try {
			sleep(1000);
		} catch(Exception ex) {}
		
		new Play(4,panel).start();
		try {
			sleep(1000);
		} catch(Exception ex) {}
		
		new Play(5,panel).start();
		try {
			sleep(1000);
		} catch(Exception ex) {}
		
		new Play(6,panel).start();
		
		try {
			sleep(5000);
		} catch(Exception ex) {}
		
		handler.changeFrame(11);
	}
}


class Play extends Thread{
	
	private String music = "src/main/java/music/DING.wav";
	private Sound play;

    
    
	private playFrame panel;
	private int actionNumber;
	private Image icon = new ImageIcon("src/main/java/icons/CIRCLE.png").getImage();
	public Play(int x, playFrame p) {
		actionNumber = x;
		panel = p;
	}
	public void run() {
		switch(actionNumber) {
		case 1:
			trajectory1();
			break;
		case 2:
			trajectory2();
			break;
		case 3:
			trajectory3();
			break;
		case 4:
			trajectory4();
			break;
		case 5:
			trajectory5();
			break;
		case 6:
			trajectory6();
			break;
		default:
				trajectory1();
				break;
		}
	}
	private void trajectory1() {
		int y = 200;
		int x  = 957;
		for(; x > 170 -50 && !panel.isPressed[0] ; x-=5) {
			panel.setIcon(x, y, 1);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}

		if(panel.isPressed[0]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 1);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		} else panel.comboNumber = 0;
		x = 0;
		y = 0;
		panel.isPressed[0] = false;
		panel.setIcon(x, y, 1);
	}
	private void trajectory2() {
		int y = 200;
		int x  = 764;
		for(; x < 1530 + 50 && !panel.isPressed[5]; x+=5) {
			panel.setIcon(x, y ,6);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}
		
		if(panel.isPressed[5]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 6);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		} else panel.comboNumber = 0;
		x = 0;
		y = 0;
		panel.isPressed[5] = false;
		panel.setIcon(x, y,6);
	}
	private void trajectory3() {
		int y = 200;
		int x  = 957;
		for(; x > 268 -50 && !panel.isPressed[1]; x-=5) {
			y =( 479449 - 357*x )/689;
			panel.setIcon(x, y, 2);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}
		
		if(panel.isPressed[1]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 2);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		} else panel.comboNumber=0;
		x = 0;
		y = 0;
		panel.isPressed[1] = false;
		panel.setIcon(x, y, 2);
		
	}
	private void trajectory4() {
		int y = 200;
		int x  = 764;
		for(; x < 1432+50 && !panel.isPressed[4]; x+=5) {
			y = (352*x-135328 ) / 668;
			panel.setIcon(x, y, 5);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}
		
		if(panel.isPressed[4]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 5);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		} else panel.comboNumber = 0;
		x = 0;
		y = 0;
		panel.isPressed[4] = false;
		panel.setIcon(x, y, 5);
	}
	private void trajectory5() {
		int y = 200;
		int x  = 957;
		for(; x > 530-50 && !panel.isPressed[2]; x-=3) {
			y = (659600 - 600*x) / 427;
			panel.setIcon(x, y, 3);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}
		
		
		if(panel.isPressed[2]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 3);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		}else panel.comboNumber=0;
		x = 0;
		y = 0;
		panel.isPressed[2] = false;
		panel.setIcon(x, y, 3);
	}
	private void trajectory6() {
		int y = 200;
		int x  = 764;
		for(; x < 1170 + 50 && !panel.isPressed[3]; x+=3) {

			y = (600*x-377200 ) / 406;
			panel.setIcon(x, y, 4);
			try {
				sleep(10);
			} catch(Exception ex) {}
		}
		
		if(panel.isPressed[3]) {
			panel.comboNumber++;
			panel.allNotes++;
			panel.setIcon(x, y, 4);
			play = Sound.playSound(music);//.start();
    		play.start();
			try {
				sleep(50);
			} catch(Exception ex) {}
		}else panel.comboNumber=0;
		x = 0;
		y = 0;
		panel.isPressed[3] = false;
		panel.setIcon(x, y, 4);
	}
}
