package com.liedssna.org.java.main.display;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame{
	
	private JPanel normalPane;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public Display(String title) {
		super(title);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createPanels();
		setContentPane(normalPane);
	}
	
	private void createPanels() {
		normalPane = new JPanel();
		normalPane.setLayout(new GridLayout(0, 1));
		for (int i = 1; i <= 5; i++) {
			JButton button = new JButton("Level " + i);
			button.addMouseListener(new LevelListener(i));
			buttons.add(button);
			normalPane.add(button);
		}
	}
	
	public class LevelListener extends MouseAdapter {
		
		private int num;
		
		public LevelListener(int num) {
			this.num = num;
		}
		
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				System.out.println(num);
			}
		}
		
	}

}
