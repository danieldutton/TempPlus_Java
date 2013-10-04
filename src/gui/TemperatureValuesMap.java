package gui;


import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class TemperatureValuesMap extends Hashtable<Integer, JLabel> {

	private JLabel lblNegative150;
	private JLabel lblNegative100;
	private JLabel lblNegative50;

	private JLabel lblZero;

	private JLabel lblPositive50;
	private JLabel lblPositive100;
	private JLabel lblPositive150;


	public TemperatureValuesMap(){

        initLabelValues();
        styleLabels();
		buildLabelTable();
	}

    private void initLabelValues(){

        lblNegative150 = new JLabel("-150");
		lblNegative100 = new JLabel("-100");
		lblNegative50 = new JLabel("-50");

		lblZero = new JLabel("0");

		lblPositive50 = new JLabel("50");
		lblPositive100 = new JLabel("100");
		lblPositive150 = new JLabel("150");
    }

    private void styleLabels(){

        Font font = new Font("Courier",Font.BOLD,10);

		lblNegative150.setFont(font);
		lblNegative150.setForeground(Color.red);
		lblNegative100.setFont(font);
		lblNegative100.setForeground(Color.red);
		lblNegative50.setFont(font);
		lblNegative50.setForeground(Color.red);

		lblZero.setFont(font);
		lblZero.setForeground(Color.blue);

		lblPositive50.setFont(font);
		lblPositive50.setForeground(Color.yellow);
		lblPositive100.setFont(font);
		lblPositive100.setForeground(Color.yellow);
		lblPositive150.setFont(font);
		lblPositive150.setForeground(Color.yellow);
    }

	private void buildLabelTable(){

		this.put(-150, lblNegative150);
		this.put(-100, lblNegative100);
		this.put(-50, lblNegative50);
		this.put(0, lblZero);
		this.put(50, lblPositive50);
		this.put(100, lblPositive100);
		this.put(150, lblPositive150);
	}
}
