import java.awt.Button;
import java.awt.Font;

public class flipbutton extends Button{
	int xpos, ypos;
	private boolean cellval;
	
	flipbutton(boolean val, int x, int y){
		//Set Button text
		super((val)? "x":"o");
		this.xpos = x;
		this.ypos = y;
		this.cellval = val;
		this.setFont(new Font("Arial", (this.cellval)? Font.BOLD:Font.PLAIN, 20));
	}
	
	int flip() {
		this.cellval = !this.cellval;
		this.setLabel((this.cellval)? "x":"o");
		this.setFont(new Font("Arial", (this.cellval)? Font.BOLD:Font.PLAIN, 20));
		return (this.cellval)? 1:-1;
	}
	
	void clearCell() {
		this.cellval = false;
		this.setLabel("o");
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}
}
