import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import data.Position;
import data.Move;

public class Board extends JPanel {
	private final JFrame frame;
	private Position pos;
	private Piece[][] pieces;
	//private BoardComponent boardComp;
	private Lines lines;
	private Square[][] squares;
	private JLayeredPane pane = new JLayeredPane();
	private static JPanel mainPane = new JPanel();

	public Board(Position pos) {
		this.setPreferredSize(new Dimension(510, 510));
		this.frame = new JFrame("ChessX");
		frame.setBackground(new Color(0, 255, 255));
//		this.lines = new Lines();
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		pane.setLayout(null);

		//this.boardComp = new BoardComponent();
		//boardComp.setVisible(true);
		this.squares = new Square[8][8];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				squares[r][c] = new Square(r, c);
				pane.add(squares[r][c]);
				frame.revalidate();
				frame.repaint();
			}
		}


		pieces = new Piece[8][8];
		for (int c = 0; c < 8; c++) {
			for (int r = 0; r < 8; r++) {
				if (pos.getSquare(r, c) != 0) {
					System.out.println("making piece");
					pieces[r][c] = new Piece(pos.getSquare(r, c), c, r);
					pane.add(pieces[r][c], 5);
					//boardComp.setLayer(pieces[r][c], 0);
					frame.revalidate();
					frame.repaint();
				}
			}
		}


		mainPane.add(pane);
		frame.setContentPane(mainPane);
		frame.revalidate();
		frame.repaint();

		//frame.add(boardComp);

		this.pos = pos;

		//frame.add(squares);
	}


	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		//if (init) {
			for (int i = 0; i < 9; i++) {
				g.drawLine(51, 51*(i+1), 459, 51*(i+1));
				g.drawLine(51*(i+1), 51, 51*(i+1), 459);
			}
			for (int c = 0; c < 8; c++) {
				g.drawString("" + c, 51*(c+1) + 25, 40);
				g.drawString("" + c, 40, 51*(c+1) + 25);
			}

	}

	public void move(Move mov) {
		System.out.println();

		int rI = mov.getxInitial();
		int cI = mov.getyInitial();
		int rF = mov.getxFinal();
		int cF = mov.getyFinal();

		System.out.println("rI: " + rI + "cI: " + cI + "rF: " + rF + "cF: " + cF);
		//Call vars directly from Move?
		pos.setSquare(rF, cF, pos.getSquare(rI, cI));
		pos.setSquare(rI, cI, (byte) 0);
		//refresh();

//		squares[rI][cI].repaint();
//		revalidate();
//		squares[rF][cF].repaint();
//		revalidate();

		pieces[rI][cI].movePiece(rF, cF);
		pieces[rF][cF] = pieces[rI][cI];

		pieces[rI][cI] = null;
		paintPiece(rF, cF);
		revalidate();

	}

	public void refresh() {
	      frame.revalidate();
	      frame.repaint();
   }

	public Piece[][] getPieces() {
		return pieces;
	}

	public JFrame getFrame() {
		return frame;
	}
	private void paintPiece(final int rF, final int cF) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	pieces[rF][cF].repaint();
				revalidate();
		    }
		  });
	}
	Position getPosition() {
		return pos;
	}
}
