package com.bungogood.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessFieldAction implements ActionListener {
	public void actionPerformed(ActionEvent event) {

	}
/*
	private final Board board;
	private final int column;	
	private final int row;

	public ChessFieldAction(Board board, int row, int col) {
		this.board = board;
		this.column = col;
		this.row = row;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			JButton button = (JButton) event.getSource();

			try {
				int value = Integer.parseInt(input);
				if (value == GameGrid.EMPTY_VAL ||
				    (GameGrid.MIN_VAL <= value && value <= GameGrid.MAX_VAL)) {
					processValue(value, button);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input: " + input);
				}
			} catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Invalid input: " + input);
			}
		}
	}

	private void processValue(int value, JButton button) {
		System.out.println(value);
		if (value == 0) {
			game.clearField(column, row);
			button.setIcon(null);
		} else if (game.setField(column, row, value)) {
			button.setIcon(FieldImage.icons[value]);
		} else {
			JOptionPane.showMessageDialog(null, "Number " + value + " not allowed here.");
		}
	}
 */
}
