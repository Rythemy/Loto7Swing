import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Random;

public class MainScreen extends JFrame implements ActionListener {
	ArrayList yourNumber = new ArrayList();
	ArrayList houseNumber = new ArrayList();
	final static int UPPER_BOUND = 36;
	public int cash = 0;
	public int loop = 0;
	public int earning = 0;
	String name;
	Random rand = new Random();
	
	JPanel panel1;
	JLabel label1;
	JLabel label2;
	JTextField textField1;
	JButton button1;
	JLabel label3;
	JLabel label4;
	JButton button2;
	JLabel label5;
	JLabel label6;
	JButton button3;
	JLabel label7;
	JLabel label8;
	JLabel label9;

	
	ImageIcon logo = new ImageIcon("Loto7.png");
	
	MainScreen() {
		this.setIconImage(logo.getImage());
		this.setTitle("Loto 7");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(500,500));
		panel1.setLayout(new FlowLayout());
		
		label1 = new JLabel();
		label1.setText("Welcome to Loto 7 - where dreams come true");
		label1.setFont(new Font("Verdana", Font.PLAIN, 17));
		
		label2 = new JLabel();
		label2.setText("Please tell us your name: ");
		label2.setFont(new Font("Verdana", Font.PLAIN, 17));
		
		
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(200,25));
		
		button1 = new JButton("OK");
		button1.addActionListener(this);
		
		label3 = new JLabel();
		label3.setFont(new Font("Verdana", Font.PLAIN, 17));
		label3.setVisible(false);
		
		label4 = new JLabel();
		label4.setText("Click the next button to get your numbers");
		label4.setFont(new Font("Verdana", Font.PLAIN, 17));
		label4.setVisible(false);
		
		button2 = new JButton("DRAW");
		button2.addActionListener(this);
		button2.setVisible(false);
		
		label5 = new JLabel();
		label5.setFont(new Font("Verdana", Font.PLAIN, 17));
		label5.setVisible(false);
		
		label6 = new JLabel();
		label6.setText("Click the next button to get the result");
		label6.setFont(new Font("Verdana", Font.PLAIN, 17));
		label6.setVisible(false);
		
		button3 = new JButton("RESULT");
		button3.addActionListener(this);
		button3.setVisible(false);
		
		label7 = new JLabel();
		label7.setFont(new Font("Verdana", Font.PLAIN, 17));
		label7.setVisible(false);
		
		label8 = new JLabel();
		label8.setFont(new Font("Verdana", Font.PLAIN, 17));
		label8.setVisible(false);
		
		label9 = new JLabel();
		label9.setFont(new Font("Verdana", Font.PLAIN, 17));
		label9.setVisible(false);
		
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(textField1);
		panel1.add(button1);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(button2);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(button3);
		panel1.add(label7);
		panel1.add(label8);
		panel1.add(label9);
		
		this.add(panel1);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			name = textField1.getText();
			label3.setText("OK " + name + ", good luck!");
			label3.setVisible(true);
			label4.setVisible(true);
			button2.setVisible(true);
		}
		
		if (e.getSource() == button2) {
			boolean repeat = true;
			do {
				for (int i = 0; i < 7; i++) {
						int random = rand.nextInt(UPPER_BOUND) + 1;
						if (!yourNumber.contains(random)) {
							yourNumber.add(random);
						} else {
							i--;
							repeat = true;
						}
					} repeat = false; 
			} while (repeat);
			yourNumber.sort(null);
			label5.setText("Your lottery numbers are: " + yourNumber);
			label5.setVisible(true);
			label6.setVisible(true);
			button3.setVisible(true);
		}
		
		if (e.getSource() == button3) {
			boolean repeat = true;
			do {
				for (int i = 0; i < 7; i++) {
						int random = rand.nextInt(UPPER_BOUND) + 1;
						if (!houseNumber.contains(random)) {
							houseNumber.add(random);
						} else {
							i--;
							repeat = true;
						}
					} repeat = false; 
			} while (repeat);
			houseNumber.sort(null);
			label7.setText("The winner numbers are: " + houseNumber);
			label7.setVisible(true);

			houseNumber.retainAll(yourNumber);
			label8.setText("You have matched total of " + houseNumber.size() + " numbers: " + houseNumber);
			label8.setVisible(true);
			if (houseNumber.size() == 6) {
				label9.setText("Congratulations! You won first prize of $6,000,000!");
				}
			else if (houseNumber.size() == 5) {
				label9.setText("Congratulations! You won second prize of $72,800!");
				}
			else if (houseNumber.size() == 4) {
				label9.setText("Congratulations! You won third prize of $7,280!");
				}
			else if (houseNumber.size() == 3) {
				label9.setText("Congratulations! You won fourth prize of $91!");
				}
			else if (houseNumber.size() == 2) {
				label9.setText("Congratulations! You won fifth prize of $14!");
				}
			else {
				label9.setText("Sorry! Better luck next time!");
				} label9.setVisible(true);
		}
	}
	
	
}
