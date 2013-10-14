package gui;

import logic.TemperatureConverter;
import logic.algorithms.FahrenheitToCelsius;
import logic.algorithms.FahrenheitToKelvin;
import model.Scale;
import model.Temperature;
import model.TemperatureUnicode;
import observer.Observer;
import observer.Subject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Gui implements Subject
{
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

	private JCheckBox chkBoxIsRounded;

	private TemperatureMap temperatureValuesMap;

    private Temperature temperature;

    private Scale scale;


	public Gui(Scale scale, Temperature temperature){
        this.scale = scale;
        this.temperature = temperature;
		parentFrame = new JFrame();
		masterComponentPanel = new JPanel(new BorderLayout());
		southPanel = new JPanel();
        graphPanel = new GraphPanel(temperature);

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
		southPanel.add(graphPanel);

		masterComponentPanel.add(temperatureSlider);
		masterComponentPanel.setBackground(Color.black);
		southPanel.setBackground(Color.black);

        styleLabels();
		styleIsRoundedCheckBox();
        buildToolTips();

		masterComponentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		masterComponentPanel.add(BorderLayout.SOUTH,graphPanel);
		parentFrame.add(masterComponentPanel);

		setParentFrameProperties();
	}

    private void addListeners(){
        temperatureSlider.addChangeListener(new Converter());
		chkBoxIsRounded.addActionListener(new IsRounded());
    }

    private void buildGraphPanel(){
        graphPanel.setLayout(new GridLayout(4,4));
        graphPanel.add(lblFahrenheitUnicode);
		graphPanel.add(lblFahrenheitValue);
		graphPanel.add(lblCelciusUnicode);
		graphPanel.add(lblCelsiusValue);
		graphPanel.add(lblKelvinUnicode);
		graphPanel.add(lblKelvinValue);
		graphPanel.add(chkBoxIsRounded);
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
        parentFrame.setLocationRelativeTo(null);
		parentFrame.setTitle("Temp +");
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.setSize(310, 195);
		parentFrame.setResizable(false);
		parentFrame.setVisible(true);
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
            parentFrame.setIconImage(icon);
        }
    }

    private List<Observer> observers = new ArrayList<Observer>();

    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("obj");
        if(!observers.contains(obj)) observers.add(obj);
    }

    public void unRegister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers() {
        for(Observer obj : observers){
           obj.update(temperature);
        }
    }

    public Object getUpdate(Observer obj) {
        return "Message";
    }

    public class Converter implements ChangeListener {

        public void stateChanged(ChangeEvent arg0) {

			temperature.setFahrenheit(temperatureSlider.getValue());

            double fahrenheit = temperatureSlider.getValue();
            boolean isRounded = chkBoxIsRounded.isSelected();

            Temperature temperatures = calculateTemperatures(fahrenheit, isRounded);

			lblFahrenheitValue.setText(String.valueOf(temperatures.getFahrenheit()));
			lblCelsiusValue.setText(String.valueOf(temperatures.getCelsius()));
			lblKelvinValue.setText(String.valueOf(temperatures.getKelvin()));
		}

        public Temperature calculateTemperatures(double fahrenheit, boolean isRounded){

            TemperatureConverter tempConverterCel = new TemperatureConverter(new FahrenheitToCelsius());
            TemperatureConverter tempConverterKel = new TemperatureConverter(new FahrenheitToKelvin());

            double f = temperatureSlider.getValue();
            double c = tempConverterCel.convert(f, isRounded);
            double k = tempConverterKel.convert(f, isRounded);

            return new Temperature(f, c, k);
        }
	}

	public class IsRounded implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(chkBoxIsRounded.isSelected()){
				//calculate temperatures here
			}
			else{
				//claculate temperatures here
			}
		}
	}
}

