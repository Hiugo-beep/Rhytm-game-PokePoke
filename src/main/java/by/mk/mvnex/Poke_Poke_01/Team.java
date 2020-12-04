package by.mk.mvnex.Poke_Poke_01;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Team {
private String[] iconsStr = {
		"src/main/java/icons/CHIKA.png",
		"src/main/java/icons/RIKO.png",
		"src/main/java/icons/YOU.png",
		"src/main/java/icons/DIA.png",
		"src/main/java/icons/MARI.png",
		"src/main/java/icons/KANAN.png",
		"src/main/java/icons/MARU.png",
		"src/main/java/icons/YOSHIKO.png",
		"src/main/java/icons/RUBY.png"
		};
public  int[] selectedIcons =  {1,2,3,4,5,6};
public Team (){
	//Из файла selectedIcons =  {1,2,3,4,5,6};
}


public Image[] getTeam () {
	
	Image[] icons = new Image[6];
	for(int i=0;i<6;i++) {
		if(selectedIcons[i] == 0) {
			icons [i] = new ImageIcon("src/main/java/playImages/selected.png").getImage();
		}
		else icons[i] = new ImageIcon(iconsStr[selectedIcons[i]-1]).getImage();
	}
	
	return icons;
}
public Image[] getMembers() {
	Image[] icons = new Image[9];
	for(int i=0;i<9;i++) {
		icons[i] = new ImageIcon(iconsStr[i]).getImage();
	}
	
	return icons;
}
}
