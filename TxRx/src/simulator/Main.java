package simulator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {

		String[] sizesList = {"3200" ,"10", "100", "200", "300", "500", "750", "1000" };
		String[] bnList = { "10000", "10000000" };
		String[] dList = { "5000000", "100", "1000", "10000" };
		String[] PbList = { "0.00001", "0.0001", "0.001", "0.01", "0.02" };
		String[] TaxGnList = { "0.05", "0.10", "0.20", "0.50", "0.75", "0.90" };

		final JComboBox streamSize = new JComboBox(sizesList);
		final JComboBox binaryRate = new JComboBox(bnList);
		final JComboBox d = new JComboBox(dList);
		final JComboBox PbBox = new JComboBox(PbList);
		final JComboBox TaxGn = new JComboBox(TaxGnList);
		
		JButton btn = new JButton("Start");
  
		
		
		JFrame frame = new JFrame("sup");
		frame.setSize(new Dimension(500, 150));
		frame.setLayout(new GridLayout(0,5, 0,20));


		JLabel l1=new JLabel("Data Size", JLabel.CENTER);
		JLabel l2=new JLabel("Bin. rate", JLabel.CENTER);
		JLabel l3=new JLabel("Distance", JLabel.CENTER);
		JLabel l4=new JLabel("Pb", JLabel.CENTER);
		JLabel l5=new JLabel("Tax. Gen.", JLabel.CENTER);
		
		l1.setFont(new Font("Serif", Font.BOLD, 14));
		l2.setFont(new Font("Serif", Font.BOLD, 14));
		l3.setFont(new Font("Serif", Font.BOLD, 14));
		l4.setFont(new Font("Serif", Font.BOLD, 14));
		l5.setFont(new Font("Serif", Font.BOLD, 14));
		
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		
		frame.add(streamSize);
		frame.add(binaryRate);
		frame.add(d);
		frame.add(PbBox);
		frame.add(TaxGn);
		
		
	
		
		frame.add(new JLabel());
		frame.add(btn);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size=Integer.parseInt((String) streamSize.getSelectedItem());
				double rate= Integer.parseInt((String) binaryRate.getSelectedItem());
				double dist = Integer.parseInt((String) d.getSelectedItem());
				double Pb= Integer.parseInt((String) PbBox.getSelectedItem());
				double TxG = Integer.parseInt((String) TaxGn.getSelectedItem());
				
				
				TxRxSystem TxRx = new TxRxSystem(size, rate, dist, Pb, TxG);
				TxRx.init();
			}
		});

		

	}

}
