import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class gameframe extends JFrame implements ActionListener{
	
	private gamepanel panel;
	private flipbutton[][] flipbuttons;
	private int numRows, numCols, numXs = 0, numRandom = 10;
	private boolean canPlay = true; 
	private Button randomizeButton,clearButton;
	
	gameframe(int r, int c){
		super("Flip");
		//Set gameframe fields
		this.numRows = r;
		this.numCols = c;
		flipbuttons = new flipbutton[c][r];
		
		//panel = new mypanel();
		//this.add(panel);
		
		//Add the r by c game
		this.setGrid();
		
		// Randomly flip numCells amount of cells
		//this.randomizeBoard(numRandom);
		
		//Set frame settings
		this.setFrame();
		
	}
	
	public void randomizeBoard(int numCells) {
		Random ran = new Random();
		for (int i = 0; i < numCells; i++) {
			int row = ran.nextInt(this.numRows);
			int col = ran.nextInt(this.numCols);
			this.flipAbout(flipbuttons[row][col]);
		}
	}
	
	public void actionPerformed(ActionEvent e){  
		
		if (e.getSource() instanceof flipbutton) {
			flipbutton source = (flipbutton) e.getSource();
			this.flipAbout(source);
		}
		if (e.getSource() == randomizeButton) {
			this.clearBoard();
			this.randomizeBoard(numRandom);
			this.canPlay = true;
		}
		if (e.getSource() == clearButton)
			this.clearBoard();
	}  
	
	private void clearBoard() {
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				flipbuttons[i][j].clearCell();
			}
		}
		this.numXs = 0;
	}
	
	private void flipAbout(flipbutton center) {
		int r = center.ypos;
		int c = center.xpos;
		
		this.numXs += center.flip();
		
		if (r-1 >= 0)
			this.numXs += flipbuttons[r-1][c].flip();
		if (r+1 <= this.numRows-1)
			this.numXs += flipbuttons[r+1][c].flip();
		if (c-1 >= 0)
			this.numXs += flipbuttons[r][c-1].flip();
		if (c+1 <= this.numCols-1)
			this.numXs += flipbuttons[r][c+1].flip();
		
		System.out.println(this.numXs);
		
		//Win game
		if (this.numXs == 0)
			this.winPrompt();
			
	}
	
	private void setGrid() {
		for (int i = 0; i < this.numRows; i++) {
			for (int k = 0; k < this.numCols; k++) {
				flipbuttons[i][k] = new flipbutton(false,k,i);
				flipbuttons[i][k].setBounds(10+k*50,10+i*50,40,40);
				flipbuttons[i][k].addActionListener(this);
				this.add(flipbuttons[i][k]);
			}
		}
		
		randomizeButton = new Button("Randomize");
		randomizeButton.setBounds(10, 10+this.numRows*50, 90, 40);
		randomizeButton.addActionListener(this);
		randomizeButton.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(randomizeButton);
		
		clearButton = new Button("Clear");
		clearButton.setBounds(110, 10+this.numRows*50, 90, 40);
		clearButton.addActionListener(this);
		clearButton.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(clearButton);
	}
	
	
	private void winPrompt() {
		this.canPlay = false;
	}
	
	private void setFrame() {
		this.setSize(this.numRows*50+30,this.numCols*50+100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
