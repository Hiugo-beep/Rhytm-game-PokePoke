package by.mk.mvnex.Poke_Poke_01;

public class InterfaceHandler{
	private Interface gui = new Interface();
	private boolean musicPhone = true;
	private JThread music;
	int beforeNumber = 0;
public InterfaceHandler() { 
	gui.setHandler(this);
	music = new JThread();
	music.start();
}
	public void changeFrame(int numberFrame){
		
		switch(numberFrame) {
		case 1: 
			gui.startMainMenu();
			if(!musicPhone) {
				music.getNewSong("src/main/java/music/nao.wav");
				musicPhone = true;
			}
			beforeNumber = 1;
			break;
		case 2://MAP SELECTIO
			gui.setMapSelectionWindow();
			if(musicPhone || beforeNumber ==2) {
				music.getNewSong("src/main/java/music/ThrillingOneWay.wav");
				musicPhone = false;
			}
			beforeNumber = 2;
			break;
			
		case 3://STATISTICS
			gui.setStatisticsWindow();
			beforeNumber = 3;
			break;
		case 4://PLAY
			music.getNewSong("src/main/java/music/ThrillingOneWay.wav");
			musicPhone = false;
			gui.setPlayWindow();
			beforeNumber = 4;
			break;
		case 5:
			gui.startCharactersFrame();
			beforeNumber = 5;
			break;
		case 6:
			gui.CharacterFrame(1);
			beforeNumber = 6;
			break;
		case 8:
			gui.setStrengthenFrame();
			beforeNumber = 8;
			break;
		case 7:
			gui.setTeamSelectWindow();
			beforeNumber = 7;
			break;
		case 9:
			gui.strengthenCharacterFrame(1);
			beforeNumber = 9;
			break;
		case 10:
			gui.setHelpFrame();		
			beforeNumber = 10;
			break;
		case 11:
			if(!musicPhone) {
				music.getNewSong("src/main/java/music/nao.wav");
				musicPhone = true;
			}
			gui.setResultWindow();
			beforeNumber = 11;
			break;
		case 12:
			gui.setSettingWindow();
			beforeNumber = 12;
			break;
		default:
				gui.startMainMenu();
				beforeNumber = 1;
				break;
				
		}
	}
	
public void changeFrame(int numberFrame, int character){
		
		switch(numberFrame) {
		case 1: 
			gui.startMainMenu();
			if(!musicPhone) {
				music.getNewSong("src/main/java/music/nao.wav");
				musicPhone = true;
			}
			beforeNumber =  1;
			break;
		case 2:
			gui.setMapSelectionWindow();
			if(musicPhone || beforeNumber ==2) {
				music.getNewSong("src/main/java/music/ThrillingOneWay.wav");
				musicPhone = false;
			}
				beforeNumber = 2;
			break;
		case 3:
			gui.setStatisticsWindow();
			beforeNumber =  3;
			break;
		case 4:
			music.getNewSong("src/main/java/music/ThrillingOneWay.wav");
			musicPhone = false;
			gui.setPlayWindow();
			beforeNumber =  4;

			break;
		case 5:
			gui.startCharactersFrame();
			beforeNumber = 5;
			break;
		case 6:
			gui.CharacterFrame(character);
			beforeNumber = 6;
			break;
		case 7:
			gui.setTeamSelectWindow();
			beforeNumber = 7;
			break;
		case 8:
			gui.setStrengthenFrame();
			beforeNumber = 8;
			break;
		case 9:
			gui.strengthenCharacterFrame(character);
			beforeNumber = 9;
			break;
		case 10:
			gui.setHelpFrame();
			beforeNumber = 10;
			break;
		case 11:
			if(!musicPhone) {
				music.getNewSong("src/main/java/music/nao.wav");
				musicPhone = true;
			}
			gui.setResultWindow();
			beforeNumber = 11;
			break;
		case 12:
			gui.setSettingWindow();
			beforeNumber = 12;
			break;
		default:
				gui.startMainMenu();
				beforeNumber = 1;
				break;
			
				
		}
	}
	
}
