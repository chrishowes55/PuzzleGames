package com.liedssna.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.liedssna.display.Display;

public class Game {
	
	private Display display;
	
	public Game() {
		display = new Display("Picture Cross", this);
		display.setVisible(true);
	}
	
	public boolean check() {
		for(int i = 0; i < display.getSpaces().size(); i++) {
			if (display.getSpaces().get(i).isShouldBe() != display.getSpaces().get(i).getBlack()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkColumn(int column, int size, int level) {
		BufferedReader br;
		String thisColumn = "";
		String thisLineUser = "";
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					"/home/chris/PuzzleGames/PictureCross/assets/levelplans/level" + level + ".txt"));
			br = new BufferedReader(reader);
			ArrayList<String> lines = new ArrayList<String>();
			String thisLine = null;
			while ((thisLine = br.readLine()) != null) {
				lines.add(thisLine);
			}
			for (int i = 0; i < lines.size(); i++) {
				thisColumn += lines.get(i).charAt(column);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = column; i < size * size; i += size) {
			if (display.getSpaces().get(i).getBlack()) {
				thisLineUser += "x";
			} else {
				thisLineUser += " " ;
			}
		}
		String user = thisLineUser.trim();
		String finalComputer = thisColumn.trim();
		System.out.println(display.decideRowTitle(finalComputer));
		System.out.println(display.decideRowTitle(user));
		if (display.decideRowTitle(finalComputer).equals(display.decideRowTitle(user))) {
			return true;
		}
		return false;
	}
	
	public boolean checkRow(int row, int size, int level) {
		BufferedReader br;
		String thisLine = "";
		String thisLineUser = "";
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					"/home/chris/PuzzleGames/PictureCross/assets/levelplans/level" + level + ".txt"));
			br = new BufferedReader(reader);
			for (int i = 0; i < row; i++) {
				br.readLine();
			}
			thisLine = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = row * size; i < (row + 1) * size; i++) {
			if (display.getSpaces().get(i).getBlack()) {
				thisLineUser += "x";
			} else {
				thisLineUser += " " ;
			}
		}
		String user = thisLineUser.trim();
		String finalComputer = thisLine.trim();
		if (display.decideRowTitle(finalComputer).equals(display.decideRowTitle(user))) {
			return true;
		}
		return false;
	}

}
