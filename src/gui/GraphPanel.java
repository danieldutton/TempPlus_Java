package gui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	/*The standard height used by each graph bar*/
	private static final int BAR_HEIGHT = 7;

	/*All conversions divided by 3 to scale*/
	private static final int DIVIDER = 3;

	private static final int POS_X_START = 15;

	private static final int NEG_X_START = 130;

	private int celcius;

	private int kelvin;

	private int fahrenheit;


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.black);
	}


	public void drawCelciusBarPos(Graphics g){
		g.setColor(Color.yellow);
		g.fillRect(POS_X_START, 34, (int) celcius / DIVIDER, BAR_HEIGHT);
	}


	public void drawKelvinBarPos(Graphics g){
		g.setColor(Color.yellow);
		g.fillRect(POS_X_START, 58,(int)kelvin / DIVIDER, BAR_HEIGHT);
	}


	public void drawFahrenheitBarNeg(Graphics g){
		g.setColor(Color.red);
		g.fillRect(NEG_X_START, 10,(int)fahrenheit / DIVIDER, BAR_HEIGHT);
	}


	public void drawCelciusBarNeg(Graphics g){
		g.setColor(Color.red);
		g.fillRect(NEG_X_START, 34, (int)celcius / DIVIDER, 7);
	}


	public void drawKelvinBarNeg(Graphics g){
		g.setColor(Color.red);
		g.fillRect(NEG_X_START,58,(int)kelvin / DIVIDER, 7);
	}
}
