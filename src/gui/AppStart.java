package gui;


import java.awt.*;

public class AppStart {
    public static void main(String[] args){

		Runnable runner = new Runnable(){
			public void run(){
				Gui gui = new Gui();
				gui.drawGui();
			}
		};
		EventQueue.invokeLater(runner);
	}
}
