package gui;


import model.Scale;

import java.awt.*;

public class AppStart {
    public static void main(String[] args){

        final Scale scale = new Scale(-150, 150, 3);

		Runnable runner = new Runnable(){
			public void run(){
				Gui gui = new Gui(scale);
				gui.drawGui();
			}
		};
		EventQueue.invokeLater(runner);
	}
}
