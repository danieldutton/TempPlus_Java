package gui;

import model.Temperature;
import observer.Observer;
import observer.Subject;

import javax.swing.*;
import java.awt.*;

	public class GraphPanel extends JPanel implements Observer
    {
        private Subject topic;

		private static final int BAR_HEIGHT = 7;

		private static final int DIVIDER = 3;

		private static final int POS_X_START = 15;

		private static final int NEG_X_START = 130;

        private Temperature temperature;

        public GraphPanel(Temperature temperature){
            this.temperature = temperature;
        }

		public void paintComponent(Graphics g){

			this.setBackground(Color.black);

			super.paintComponent(g);

			if(temperature.getFahrenheit() < 0)
				drawFahrenheitBarNeg(g);
			if(temperature.getCelsius() < 0)
				drawCelciusBarNeg(g);
			if(temperature.getKelvin() < 0)
				drawKelvinBarNeg(g);
			if(temperature.getFahrenheit() > 0)
				drawFahrenheitBarPos(g);
			if(temperature.getCelsius()> 0)
				drawCelciusBarPos(g);
			if(temperature.getKelvin() > 0)
				drawKelvinBarPos(g);
			repaint();
		}


		public void drawFahrenheitBarPos(Graphics g){
			g.setColor(Color.yellow);
			g.fillRect(POS_X_START, 10,(int)temperature.getFahrenheit() / DIVIDER, BAR_HEIGHT);
		}


		public void drawCelciusBarPos(Graphics g){
			g.setColor(Color.yellow);
			g.fillRect(POS_X_START, 34,(int)temperature.getCelsius() / DIVIDER, BAR_HEIGHT);
		}

		public void drawKelvinBarPos(Graphics g){
			g.setColor(Color.yellow);
			g.fillRect(POS_X_START, 58,(int)temperature.getKelvin() / DIVIDER, BAR_HEIGHT);
		}

		public void drawFahrenheitBarNeg(Graphics g){
			g.setColor(Color.red);
			g.fillRect(NEG_X_START, 10,(int)temperature.getFahrenheit() / DIVIDER, BAR_HEIGHT);
		}

		public void drawCelciusBarNeg(Graphics g){
			g.setColor(Color.red);
			g.fillRect(NEG_X_START, 34, (int)temperature.getCelsius() / DIVIDER, 7);
		}

		public void drawKelvinBarNeg(Graphics g){
			g.setColor(Color.red);
			g.fillRect(NEG_X_START,58,(int)temperature.getFahrenheit() / DIVIDER, 7);
		}

        public void update(Temperature temperature) {
           this.temperature = temperature;
        }

        public void setSubject(Subject sub) {
            this.topic = sub;
        }
    }