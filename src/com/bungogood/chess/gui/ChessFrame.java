package com.bungogood.gui;

import javax.swing.*;

public class ChessFrame extends JFrame {
	/*
	private static final int WINDOW_DIM = 500;
	
	private final Board board;

	public ChessFrame(Board board) {
		this.board = board;

        Objects.requireNonNull(board);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(10, 10));
		setSize(WINDOW_DIM, WINDOW_DIM);

		setTitle("Chess");

        createButtonGrid();
   	}
	 */

    /*
	private void createButtonGrid() {
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Piece piece = board.board[row * 8 + col];
            	JButton button = new JButton();

				// (row + col) % 2 == 0 ? white : black
				button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
            	if (piece != null) {
            		button.setEnabled(true);
					button.setIcon(FieldImage.icons[value-1]);
					button.setDisabledIcon(FieldImage.icons[value-1]);
            	} else {
					button.setEnabled(false);
				}
            	button.addActionListener(new ChessFieldAction(board, row, col));
            	add(button);	
            }
        }
	}
     */
}
