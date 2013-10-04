package gui;

import model.TemperatureUnicode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

	private JFrame parentFrame;

	private JPanel masterComponentPanel;
	private JPanel southPanel;
	private GraphPanel graphPanel;

	private JLabel lblFahrenheitValue;
	private JLabel lblCelsiusValue;
	private JLabel lblKelvinValue;

	private JLabel lblFahrenheitUnicode;
	private JLabel lblCelciusUnicode;
	private JLabel lblKelvinUnicode;

	private JSlider temperatureSlider;

	private static final int MAX_FAHRENHEIT_VALUE = 150;

	private static final int MIN_FAHRENHEIT_VALUE = -150;

	private JCheckBox chkBoxIsRounded;

	private boolean isRounded = false;

	private TemperatureValuesMap temperatureValuesMap;


	public Gui(){
		parentFrame = new JFrame();
		masterComponentPanel = new JPanel(new BorderLayout());
		southPanel = new JPanel();

		lblFahrenheitUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_F));
		lblFahrenheitValue = new JLabel("0");
		lblCelciusUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_C));
		lblCelsiusValue = new JLabel("0");
		lblKelvinUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_K));
		lblKelvinValue = new JLabel("0");
		temperatureValuesMap = new TemperatureValuesMap();
		temperatureSlider = new JSlider(MIN_FAHRENHEIT_VALUE, MAX_FAHRENHEIT_VALUE);
		chkBoxIsRounded = new JCheckBox("Round");
		graphPanel = new GraphPanel();
	}

	public void drawGui(){

		graphPanel.setLayout(new GridLayout(4,4));

        setCustomFrameIcon();
        InitTemperatureSlider();

		temperatureSlider.addChangeListener(new Converter());
		chkBoxIsRounded.addActionListener(new IsRounded());

		graphPanel.add(lblFahrenheitUnicode);
		graphPanel.add(lblFahrenheitValue);
		graphPanel.add(lblCelciusUnicode);
		graphPanel.add(lblCelsiusValue);
		graphPanel.add(lblKelvinUnicode);
		graphPanel.add(lblKelvinValue);
		graphPanel.add(chkBoxIsRounded);
		southPanel.add(graphPanel);

		masterComponentPanel.add(temperatureSlider);

		masterComponentPanel.setBackground(Color.black);
		southPanel.setBackground(Color.black);
		temperatureSlider.setBackground(Color.black);
		temperatureSlider.setForeground(Color.white);

		lblCelciusUnicode.setForeground(Color.white);
		lblCelciusUnicode.setToolTipText("Celcius");
		lblFahrenheitUnicode.setForeground(Color.white);
		lblFahrenheitUnicode.setToolTipText("Fahrenheit");
		lblKelvinUnicode.setForeground(Color.white);
		lblKelvinUnicode.setToolTipText("Kelvin");

		lblFahrenheitValue.setForeground(Color.white);
		lblCelsiusValue.setForeground(Color.white);
		lblKelvinValue.setForeground(Color.white);

		chkBoxIsRounded.setBackground(Color.black);
		chkBoxIsRounded.setForeground(Color.white);
		chkBoxIsRounded.setSize(5, 5);

		UIManager.put("ToolTip.background", Color.black);
		UIManager.put("ToolTip.foreground", Color.white);
		UIManager.put("ToolTip.font", new Font("trebuchet ms",Font.PLAIN,10));


		masterComponentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		masterComponentPanel.add(BorderLayout.SOUTH,graphPanel);
		parentFrame.add(masterComponentPanel);

		parentFrame.setLocationRelativeTo(null);
		parentFrame.setTitle("Temp +");
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.setSize(310,195);
		parentFrame.setResizable(false);
		parentFrame.setVisible(true);
	}

    private void InitTemperatureSlider() {
        temperatureSlider.setLabelTable(temperatureValuesMap);
        temperatureSlider.setMajorTickSpacing(50);
        temperatureSlider.setMinorTickSpacing(10);
        temperatureSlider.setPaintLabels(true);
        temperatureSlider.setPaintTicks(true);
        temperatureSlider.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0));
    }

    private void setCustomFrameIcon() {

        java.net.URL imageURL = getClass().getResource("images/t_icon.gif");

        if (imageURL != null) {
            Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
            parentFrame.setIconImage(icon);
        }
    }


	private float fahrenheit;
	private float celcius;
	private float kelvin;


	public class Converter implements ChangeListener {

		public void stateChanged(ChangeEvent arg0) {

			fahrenheit = temperatureSlider.getValue();

			lblFahrenheitValue.setText(String.valueOf(fahrenheit));

			lblCelsiusValue.setText(String.valueOf(toCelcius(isRounded)));

			lblKelvinValue.setText(String.valueOf(toKelvin(isRounded)));
		}

		public float toCelcius(boolean rounded){
			celcius = (fahrenheit - 32) * 5/9F;
			celcius = (rounded) ? Math.round(celcius):celcius;
			return celcius;
		}


		public float toKelvin(boolean rounded){
			final float F_TO_K_CONVERSION = 273.15F;

			kelvin = celcius + F_TO_K_CONVERSION;
			kelvin = (rounded) ? Math.round(kelvin):kelvin;

			return kelvin;
		}
	}


	public class IsRounded implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(chkBoxIsRounded.isSelected()){
				isRounded = true;
			}
			else{
				isRounded = false;
			}
		}
	}

	public class GraphPanel extends JPanel{

		private static final int BAR_HEIGHT = 7;

		private static final int DIVIDER = 3;

		private static final int POS_X_START = 15;

		private static final int NEG_X_START = 130;


		public void paintComponent(Graphics g){

			this.setBackground(Color.black);

			super.paintComponent(g);

			if(fahrenheit < 0)
				drawFahrenheitBarNeg(g);
			if(celcius < 0)
				drawCelciusBarNeg(g);
			if(kelvin < 0)
				drawKelvinBarNeg(g);
			if(fahrenheit > 0)
				drawFahrenheitBarPos(g);
			if(celcius > 0)
				drawCelciusBarPos(g);
			if(kelvin > 0)
				drawKelvinBarPos(g);
			repaint();
		}


		public void drawFahrenheitBarPos(Graphics g){
			g.setColor(Color.yellow);
			g.fillRect(POS_X_START, 10,(int)fahrenheit / DIVIDER, BAR_HEIGHT);
		}


		public void drawCelciusBarPos(Graphics g){
			g.setColor(Color.yellow);
			g.fillRect(POS_X_START, 34,(int)celcius / DIVIDER, BAR_HEIGHT);
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
}

