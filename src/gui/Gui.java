package gui;

import logic.TemperatureConverter;
import logic.algorithms.FahrenheitToCelsius;
import logic.algorithms.FahrenheitToKelvin;
import model.Scale;
import model.Temperature;
import model.TemperatureUnicode;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui
{
	private JFrame frameParent;

	private JPanel panelMaster;
	private JPanel southPanel;
	private GraphPanel panelGraph;

	private JLabel lblFahrenheitValue;
	private JLabel lblCelsiusValue;
	private JLabel lblKelvinValue;

	private JLabel lblFahrenheitUnicode;
	private JLabel lblCelciusUnicode;
	private JLabel lblKelvinUnicode;

	private JSlider temperatureSlider;

	private JCheckBox chkBoxIsRounded;
    private boolean isTemperatureRounded;

	private TemperatureMap temperatureValuesMap;

    private Temperature temperature;

    private Scale scale;


	public Gui(Scale scale, Temperature temperature){
        this.scale = scale;
        this.temperature = temperature;
		frameParent = new JFrame();
		panelMaster = new JPanel(new BorderLayout());
		southPanel = new JPanel();
        panelGraph = new GraphPanel(temperature);

		lblFahrenheitUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_F));
		lblFahrenheitValue = new JLabel("0");
		lblCelciusUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_C));
		lblCelsiusValue = new JLabel("0");
		lblKelvinUnicode = new JLabel(Character.toString(TemperatureUnicode.DEGREE_K));
		lblKelvinValue = new JLabel("0");
		temperatureValuesMap = new TemperatureMap();
		temperatureSlider = new JSlider(scale.getMinimum(), scale.getMaximum());
		chkBoxIsRounded = new JCheckBox("Round");
	}

	public void drawGui(){
        setCustomFrameIcon();
        InitTemperatureSlider();
		addListeners();
		buildGraphPanel();

		southPanel.add(panelGraph);
		panelMaster.add(temperatureSlider);
		panelMaster.setBackground(Color.black);
		southPanel.setBackground(Color.black);

        styleLabels();
		styleIsRoundedCheckBox();
        buildToolTips();

		panelMaster.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelMaster.add(BorderLayout.SOUTH, panelGraph);
		frameParent.add(panelMaster);

		setParentFrameProperties();
	}

    private void addListeners(){
        temperatureSlider.addChangeListener(new Converter());
    }

    private void buildGraphPanel(){
        panelGraph.setLayout(new GridLayout(4,4));
        panelGraph.add(lblFahrenheitUnicode);
		panelGraph.add(lblFahrenheitValue);
		panelGraph.add(lblCelciusUnicode);
		panelGraph.add(lblCelsiusValue);
		panelGraph.add(lblKelvinUnicode);
		panelGraph.add(lblKelvinValue);
		panelGraph.add(chkBoxIsRounded);
    }

    private void styleLabels(){
        lblCelciusUnicode.setForeground(Color.white);
		lblCelciusUnicode.setToolTipText("Celcius");
		lblFahrenheitUnicode.setForeground(Color.white);
		lblFahrenheitUnicode.setToolTipText("Fahrenheit");
		lblKelvinUnicode.setForeground(Color.white);
		lblKelvinUnicode.setToolTipText("Kelvin");

		lblFahrenheitValue.setForeground(Color.white);
		lblCelsiusValue.setForeground(Color.white);
		lblKelvinValue.setForeground(Color.white);
    }

    private void buildToolTips(){
        UIManager.put("ToolTip.background", Color.black);
		UIManager.put("ToolTip.foreground", Color.white);
		UIManager.put("ToolTip.font", new Font("trebuchet ms",Font.PLAIN,10));
    }

    private void setParentFrameProperties(){
        frameParent.setLocationRelativeTo(null);
		frameParent.setTitle("Temp +");
		frameParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameParent.setSize(310, 195);
		frameParent.setResizable(false);
		frameParent.setVisible(true);
    }

    private void styleIsRoundedCheckBox(){
        chkBoxIsRounded.setBackground(Color.black);
		chkBoxIsRounded.setForeground(Color.white);
		chkBoxIsRounded.setSize(5, 5);
    }

    private void InitTemperatureSlider() {
        temperatureSlider.setLabelTable(temperatureValuesMap);
        temperatureSlider.setMajorTickSpacing(50);
        temperatureSlider.setMinorTickSpacing(10);
        temperatureSlider.setPaintLabels(true);
        temperatureSlider.setPaintTicks(true);
        temperatureSlider.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0));
        temperatureSlider.setBackground(Color.black);
		temperatureSlider.setForeground(Color.white);
    }

    private void setCustomFrameIcon() {

        java.net.URL imageURL = getClass().getResource("images/t_icon.gif");

        if (imageURL != null) {
            Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
            frameParent.setIconImage(icon);
        }
    }

    public class Converter implements ChangeListener {

        public void stateChanged(ChangeEvent arg0) {

            double fahrenheit = temperatureSlider.getValue();
            boolean isRounded = chkBoxIsRounded.isSelected();

            Temperature temperatures = calculateTemperatures(fahrenheit, isRounded);

			lblFahrenheitValue.setText(String.valueOf(temperatures.getFahrenheit()));
			lblCelsiusValue.setText(String.valueOf(temperatures.getCelsius()));
			lblKelvinValue.setText(String.valueOf(temperatures.getKelvin()));

            panelGraph.setTemperature(temperatures);
		}

        public Temperature calculateTemperatures(double fahrenheit, boolean isRounded){

            TemperatureConverter tempConverterCel = new TemperatureConverter(new FahrenheitToCelsius());
            TemperatureConverter tempConverterKel = new TemperatureConverter(new FahrenheitToKelvin());

            double celcius = tempConverterCel.convert(fahrenheit, isRounded);
            double kelvin = tempConverterKel.convert(fahrenheit, isRounded);

            return new Temperature(fahrenheit, celcius, kelvin);
        }
	}
}

