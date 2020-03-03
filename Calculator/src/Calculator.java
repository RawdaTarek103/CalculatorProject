import java.awt.EventQueue;
//button_mul.setEnabled(false);

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Component;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Frame;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField textField;
	private JButton button_del;
	private JButton button_1;
	private JButton button_0;
	private JButton button_2; 
	private JButton button_3;
	private JButton button_4;
	private JButton button_5; 
	private JButton button_6; 
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_dot;
	private JButton button_mul;
	private JButton button_plus;
	private JButton button_eq;
	private JButton button_tan;
	private JButton button_fact;
	private JButton button_pow;
	private JButton button_div;
	private JButton button_CL;

	private Double num = null,result = null;
	private char operation = '?';
	private boolean enabled = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void execute_operation(char op)
	{
		if(operation != '?')
		{
			calculate_result();
			num = result;
		}
		else
			num = Double.parseDouble(textField.getText());
		
		operation = op;
		textField.setText("");
	}
	
	private void clear()
	{
		num = null;
		result = null;
		operation = '?';
		textField.setText("");
		if(enabled == false)
			enable();
	}
	
	private Double calculate_result()
	{		
		Double new_num = null;
		try
		{
			new_num = Double.parseDouble(textField.getText());
		}catch(NumberFormatException nfe){
			if(operation != '!' && operation != 'T')
				return -1.0;
			
		}
		if(operation == '+')
			result = num + new_num;			
		
		else if(operation == '*')
			result = num * new_num;		
		
		else if(operation == '/')
		{
			if(new_num == 0)
			{
				textField.setText("NAN");
				disable();
				return -1.0;
			}
			else
				result = num / new_num;	
		}
		
		else if(operation == '^')
			result = Math.pow(num, new_num);
			
		else if(operation == '!')
		{
			Double temp = 1.0;

	        for (int factor = 2; factor <= num; factor++) {
	            temp *= factor;
	        }
	        result = temp;
		}
		
		else if(operation == 'T')
		{
			Double temp = num / 90;
			if(temp%2 == 1)
			{
				textField.setText("NAN");
				disable();
				return -1.0;
			}
			temp = Math.toRadians(num);
			result = Math.tan(temp);
		}
		return num;
		
	}
	
	private void disable()
	{
		button_del.setEnabled(false);
		button_1.setEnabled(false);
		button_0.setEnabled(false);
		button_2.setEnabled(false); 
		button_3.setEnabled(false);
		button_4.setEnabled(false);
		button_5.setEnabled(false); 
		button_6.setEnabled(false); 
		button_7.setEnabled(false);
		button_8.setEnabled(false);
		button_9.setEnabled(false);
		button_dot.setEnabled(false);
		button_mul.setEnabled(false);
		button_plus.setEnabled(false);
		button_eq.setEnabled(false);
		button_tan.setEnabled(false);
		button_fact.setEnabled(false);
		button_pow.setEnabled(false);
		button_div.setEnabled(false);
		enabled = false;
	}
	private void enable()
	{
		button_del.setEnabled(true);
		button_1.setEnabled(true);
		button_0.setEnabled(true);
		button_2.setEnabled(true); 
		button_3.setEnabled(true);
		button_4.setEnabled(true);
		button_5.setEnabled(true); 
		button_6.setEnabled(true); 
		button_7.setEnabled(true);
		button_8.setEnabled(true);
		button_9.setEnabled(true);
		button_dot.setEnabled(true);
		button_mul.setEnabled(true);
		button_plus.setEnabled(true);
		button_eq.setEnabled(true);
		button_tan.setEnabled(true);
		button_fact.setEnabled(true);
		button_pow.setEnabled(true);
		button_div.setEnabled(true);
	}
	
	private void show_result()
	{
		if(operation != '?')
		{
			if(calculate_result() != -1)
			{
				textField.setText(Double.toString(result));
				operation = '?';
			}
		}
	}
	
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(33,33,33));;
		frmCalculator.setForeground(new Color(0, 0, 0));
		frmCalculator.setTitle("Calculator\r\n");
		frmCalculator.setBackground(new Color(0, 0, 51));
		frmCalculator.setType(Type.UTILITY);
		frmCalculator.setBounds(100, 100, 500, 400);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44,41,42));
		panel.setBorder(null);
		panel.setBounds(0, 0, 484, 70);
		frmCalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 0, 464, 70);
		textField.setToolTipText("");
		textField.setSelectionColor(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(44, 41, 42));
		panel.add(textField);
		InputMap in_map = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap act_map = panel.getActionMap();
		
		button_del = new JButton("DEL");
		button_del.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_del.setBounds(10, 305, 65, 45);
		button_del.setForeground(new Color(255, 255, 255));
		button_del.setBorder(null);
		button_del.setBackground(new Color(44, 41, 42));
		AbstractAction del = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().length() > 0)
					textField.setText(textField.getText().substring(0, textField.getText().length()-1));
			}
		};
		button_del.addActionListener(del);
		frmCalculator.getContentPane().add(button_del);
		
		in_map.put(KeyStroke.getKeyStroke("BACK_SPACE"),"del");
		act_map.put("del", del);
		
		button_0 = new JButton("0");
		button_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_0.setForeground(new Color(255, 255, 255));
		button_0.setBounds(85, 305, 65, 45);
		button_0.setBorder(null);
		button_0.setBackground(new Color(44, 41, 42));
		AbstractAction b_0 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"0");
			}
		};
		button_0.addActionListener(b_0);
		frmCalculator.getContentPane().add(button_0);
		
		in_map.put(KeyStroke.getKeyStroke("0"),"num0");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD0"),"num0");
		act_map.put("num0", b_0);
		
		button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBounds(10, 249, 65, 45);
		button_1.setBorder(null);
		button_1.setBackground(new Color(44, 41, 42));
		AbstractAction b_1 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"1");
			}
		};
		button_1.addActionListener(b_1);
		frmCalculator.getContentPane().add(button_1);
		
		in_map.put(KeyStroke.getKeyStroke("1"),"num1");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD1"),"num1");
		act_map.put("num1", b_1);
		
		button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBounds(85, 249, 65, 45);
		button_2.setBorder(null);
		button_2.setBackground(new Color(44, 41, 42));
		AbstractAction b_2 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"2");
			}
		};
		button_2.addActionListener(b_2);
		frmCalculator.getContentPane().add(button_2);
		
		in_map.put(KeyStroke.getKeyStroke("2"),"num2");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD2"),"num2");
		act_map.put("num2", b_2);
		
		button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBounds(160, 249, 65, 45);
		button_3.setBorder(null);
		button_3.setBackground(new Color(44, 41, 42));
		AbstractAction b_3 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"3");
			}
		};
		button_3.addActionListener(b_3);
		frmCalculator.getContentPane().add(button_3);
		
		in_map.put(KeyStroke.getKeyStroke("3"),"num3");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD3"),"num3");
		act_map.put("num3", b_3);
		
		button_4 = new JButton("4");
		button_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBounds(10, 193, 65, 45);
		button_4.setBorder(null);
		button_4.setBackground(new Color(44, 41, 42));
		AbstractAction b_4 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"4");
			}
		};
		button_4.addActionListener(b_4);
		frmCalculator.getContentPane().add(button_4);
		
		in_map.put(KeyStroke.getKeyStroke("4"),"num4");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD4"),"num4");
		act_map.put("num4", b_4);
		
		button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBounds(85, 193, 65, 45);
		button_5.setBorder(null);
		button_5.setBackground(new Color(44, 41, 42));
		AbstractAction b_5 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"5");
			}
		};
		button_5.addActionListener(b_5);
		frmCalculator.getContentPane().add(button_5);
		
		in_map.put(KeyStroke.getKeyStroke("5"),"num5");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD5"),"num5");
		act_map.put("num5", b_5);
		
		button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBorder(null);
		button_6.setBackground(new Color(44, 41, 42));
		button_6.setBounds(160, 193, 65, 45);
		AbstractAction b_6 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"6");
			}
		};
		button_6.addActionListener(b_6);
		frmCalculator.getContentPane().add(button_6);
		
		in_map.put(KeyStroke.getKeyStroke("6"),"num6");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD6"),"num6");
		act_map.put("num6", b_6);
		
		
		button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBounds(10, 137, 65, 45);
		button_7.setBorder(null);
		button_7.setBackground(new Color(44, 41, 42));
		AbstractAction b_7 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"7");
			}
		};
		button_7.addActionListener(b_7);
		frmCalculator.getContentPane().add(button_7);
		
		in_map.put(KeyStroke.getKeyStroke("7"),"num7");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD7"),"num7");
		act_map.put("num7", b_7);
		
		button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBounds(85, 137, 65, 45);
		button_8.setBorder(null);
		button_8.setBackground(new Color(44, 41, 42));
		AbstractAction b_8 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"8");
			}
		};
		button_8.addActionListener(b_8);
		frmCalculator.getContentPane().add(button_8);
		
		in_map.put(KeyStroke.getKeyStroke("8"),"num8");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD8"),"num8");
		act_map.put("num8", b_8);
		
		button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBorder(null);
		button_9.setBackground(new Color(44, 41, 42));
		button_9.setBounds(160, 137, 65, 45);
		AbstractAction b_9 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+"9");
			}
		};
		button_9.addActionListener(b_9);
		frmCalculator.getContentPane().add(button_9);
		
		in_map.put(KeyStroke.getKeyStroke("9"),"num9");
		in_map.put(KeyStroke.getKeyStroke("NUMPAD9"),"num9");
		act_map.put("num9", b_9);
		
		button_dot = new JButton(".");
		button_dot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_dot.setForeground(new Color(255, 255, 255));
		button_dot.setBounds(160, 305, 65, 45);
		button_dot.setBorder(null);
		button_dot.setBackground(new Color(44, 41, 42));
		AbstractAction b_dot = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(operation == '?' && result != null)
					textField.setText("");
				textField.setText(textField.getText()+".");
			}
		};
		button_dot.addActionListener(b_dot);
		frmCalculator.getContentPane().add(button_dot);
		
		in_map.put(KeyStroke.getKeyStroke("DECIMAL"),"dot");
		act_map.put("dot", b_dot);
		
		button_mul = new JButton("\u00D7");
		button_mul.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_mul.setForeground(new Color(255, 255, 255));
		button_mul.setBounds(235, 137, 65, 45);
		button_mul.setBorder(null);
		button_mul.setBackground(new Color(28,69,82));
		AbstractAction mul = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
					execute_operation('*');
			}
		};
		button_mul.addActionListener(mul);
		frmCalculator.getContentPane().add(button_mul);
		
		in_map.put(KeyStroke.getKeyStroke('*'),"mul");
		act_map.put("mul", mul);
		
		button_plus = new JButton("+");
		button_plus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_plus.setForeground(new Color(255, 255, 255));
		button_plus.setBounds(235, 249, 65, 45);
		button_plus.setBorder(null);
		button_plus.setBackground(new Color(28,69,82));
		AbstractAction plus = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
					execute_operation('+');
			}
		};
		button_plus.addActionListener(plus);
		frmCalculator.getContentPane().add(button_plus);
		
		in_map.put(KeyStroke.getKeyStroke('+'),"plus");
		act_map.put("plus", plus);
		
		button_eq = new JButton("=");
		button_eq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_eq.setForeground(new Color(255, 255, 255));
		button_eq.setBounds(235, 305, 65, 45);
		button_eq.setBorder(null);
		button_eq.setBackground(new Color(28,69,82));
		AbstractAction eq = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				show_result();
			}
		};
		button_eq.addActionListener(eq);
		frmCalculator.getContentPane().add(button_eq);
		
		in_map.put(KeyStroke.getKeyStroke('='),"eq");
		in_map.put(KeyStroke.getKeyStroke("ENTER"),"eq");
		act_map.put("eq", eq);
		
		button_tan = new JButton("Tan");
		button_tan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_tan.setForeground(new Color(255, 255, 255));
		button_tan.setBorder(null);
		button_tan.setBackground(new Color(28,69,82));
		button_tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
				{	
					execute_operation('T');
					show_result();
				}
			}
		});
		button_tan.setBounds(10, 81, 65, 45);
		frmCalculator.getContentPane().add(button_tan);
		
		button_fact = new JButton("!");
		button_fact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_fact.setForeground(new Color(255, 255, 255));
		button_fact.setBounds(85, 81, 65, 45);
		button_fact.setBorder(null);
		button_fact.setBackground(new Color(28,69,82));
		AbstractAction fact = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
					execute_operation('!');
					show_result();
			}
		};
		button_fact.addActionListener(fact);
		frmCalculator.getContentPane().add(button_fact);
		
		in_map.put(KeyStroke.getKeyStroke('!'),"fact");
		act_map.put("fact", fact);
		
		button_pow = new JButton("^");
		button_pow.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_pow.setForeground(new Color(255, 255, 255));
		button_pow.setBounds(160, 81, 65, 45);
		button_pow.setBorder(null);
		button_pow.setBackground(new Color(28,69,82));
		AbstractAction pow =new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
					execute_operation('^');
			}
		};
		button_pow.addActionListener(pow);
		frmCalculator.getContentPane().add(button_pow);
		
		in_map.put(KeyStroke.getKeyStroke('^'),"pow");
		act_map.put("pow", pow);
		
		button_div = new JButton("\u00F7");
		button_div.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_div.setForeground(new Color(255, 255, 255));
		button_div.setBounds(235, 193, 65, 45);
		button_div.setBorder(null);
		button_div.setBackground(new Color(28,69,82));
		AbstractAction div = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField.getText().isEmpty()))
					execute_operation('/');
			}
		};
		button_div.addActionListener(div);
		frmCalculator.getContentPane().add(button_div);
		
		in_map.put(KeyStroke.getKeyStroke('/'),"div");
		act_map.put("div", div);
		
		button_CL = new JButton("CL");
		button_CL.setBorder(null);
		button_CL.setForeground(new Color(255, 255, 255));
		button_CL.setBackground(new Color(28,69,82));
		button_CL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_CL.setBounds(235, 81, 65, 45);
		button_CL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		frmCalculator.getContentPane().add(button_CL);
	}
}
