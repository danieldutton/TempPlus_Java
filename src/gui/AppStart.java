package gui;

import model.Scale;
import model.Temperature;
import java.awt.*;

public class AppStart
{
    public static void main(String[] args)
    {
        final Scale scale = new Scale(-150, 150);

        final Temperature temperatures = new Temperature(0.00, 0.00, 0.00);

		Runnable runner = new Runnable(){
			public void run(){
				Gui gui = new Gui(scale, temperatures);
				gui.drawGui();
			}
		};
		EventQueue.invokeLater(runner);
	}
}
