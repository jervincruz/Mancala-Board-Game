import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  Mancala Board Game
 *  @author: Jervin Cruz, Chris Wong, Aidan Nguyen
 **/

public class MancalaTest extends JFrame
{	
	JPanel player = new JPanel();
	private GameModel model;
	private BoardType style;
	private BoardComp c;
    private int numStone = 3;
    private int type = 0;
        
	public MancalaTest()
	{
		model = new GameModel(numStone);
	    final CircleBoard b = new CircleBoard(model);
		final RectangleBoard b1 = new RectangleBoard(model);
		style = b;
		model.attach(b);
		setSize(500,400);
		
        JButton circle = new JButton("Circle");
		circle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				style = b;
				model.attach(b);
				type = 0;
				buildBoard();
			}
		});
		
		/* Start with 3 initial stones */
        JButton three = new JButton("3");
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				numStone = 3;
			}
		});	
		
		/* Undo most recent move */
		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(model.canUndo() == true) {model.undo();}
				repaint();
				model.switchTurn();
			}
		});
                
		JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MancalaTest x = new MancalaTest();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane();
		
        // Add Buttons   
		player.add(undo);   player.add(newGame);
        
        player.setSize(75, 700);
                
        this.setSize(900, 700);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		buildBoard();
    }
	
	/*  buildBoard - attaches the components to the board */
	public void buildBoard(){
		c = new BoardComp(style, model);	// builds board by getting the component (style and model)
		this.add(c, BorderLayout.CENTER);
		this.add(player, BorderLayout.NORTH);
	}
        
    public BoardType setBoard(){
        return new Board(model);  
    }
        
	public static void main(String args[]){
		MancalaTest x = new MancalaTest();       
		return;
	}	
}
