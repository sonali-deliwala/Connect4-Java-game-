import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;



public class Game implements Runnable {
	public void run() {
		
		
		final JFrame frame = new JFrame ("Play Connect 4");

		frame.setLocation(300,300);
		
		
		final JPanel status_panel = new JPanel();
		frame.add(status_panel, BorderLayout.NORTH);
		
		final JPanel column_panel = new JPanel();
		frame.add(column_panel, BorderLayout.NORTH);
		
        final JLabel status = new JLabel("Running...");
        status_panel.add(status); 
        
        /*if (board.whoseTurn()==1) {
        	
        } */
        
        
        final Board board = new Board(status);
        frame.add(board, BorderLayout.CENTER);
        
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.SOUTH);
        
        
        
        final JButton load = new JButton("Load");
        load.setFont(new Font("Calibri", Font.BOLD, 16));
        load.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		try {
					board.read();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        
        JLabel turn = new JLabel();
        
        
        ActionListener whoseTurn = new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		if (board.whoseTurn()==1) {
        			turn.setText("It is now Player 1's turn");
        		}
        		else if (board.whoseTurn()==2) {
        			turn.setText("It is now Player 2's turn");
        		}
        	}
        };
        
        Timer timer1 = new Timer (1, whoseTurn);
        timer1.start();
         
        
        
        final JButton reset = new JButton("Reset");
        reset.setFont(new Font("Calibri", Font.BOLD, 16));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	board.repaint();
            	board.reset();
            }
        });
        
        
        
            
        final JButton undo = new JButton("Undo");
        undo.setFont(new Font("Calibri", Font.BOLD, 16));
        undo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		board.undo();
        		if(board.getUndoClick() == true) {
        		board.flipState();
        		}
        		board.repaint();
        		board.setUndoClicked(false); 
        	}
        });
        
        final JButton save = new JButton("Save");
        save.setFont(new Font("Calibri", Font.BOLD, 16));
        save.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		try {
					board.write();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        
        

        //clicking on these will drop a chip in that respective column
        final JButton first = new JButton("1");
        first.setFont(new Font("Calibri", Font.BOLD, 16));
        first.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(0); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        });
        
        final JButton second = new JButton("2");
        second.setFont(new Font("Calibri", Font.BOLD, 16));
        second.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(1); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        		
        	}
        });
        
        final JButton third = new JButton("3");
        third.setFont(new Font("Calibri", Font.BOLD, 16));
        third.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(2); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        	
        });
        
        final JButton fourth = new JButton("4");
        fourth.setFont(new Font("Calibri", Font.BOLD, 16));
        fourth.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(3); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        });
        
        final JButton fifth = new JButton("5");
        fifth.setFont(new Font("Calibri", Font.BOLD, 16)); 
        fifth.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(4); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        });
        
        final JButton sixth = new JButton("6");
        sixth.setFont(new Font("Calibri", Font.BOLD, 16));       
        sixth.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(5);
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        });
        
        final JButton seventh = new JButton("7");
        seventh.setFont(new Font("Calibri", Font.BOLD, 16));       
        seventh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.setColumn(6); 
        		board.makeMove();
        		board.flipState();
        		board.repaint();
        	}
        });
        //clicking on this will show the instructions
        final JButton instructions = new JButton("Instructions");
        instructions.setFont(new Font("Calibri", Font.BOLD, 16));
        instructions.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.showInstructions();
        		board.repaint();
        		first.setVisible(false);
                second.setVisible(false);
                third.setVisible(false);
                fourth.setVisible(false);
                fifth.setVisible(false);
                sixth.setVisible(false);
                seventh.setVisible(false);
                reset.setVisible(false);
                undo.setVisible(false);
                save.setVisible(false);
                load.setVisible(false);
 
                 
        	}
        });
        
        
        final JButton start = new JButton("Start");
        start.setFont(new Font("Calibri", Font.BOLD, 16));
        start.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		board.stopShowingInstructions();
        		board.startGame();
        		board.repaint(); 
        		first.setVisible(true);
                second.setVisible(true);
                third.setVisible(true);
                fourth.setVisible(true);
                fifth.setVisible(true);
                sixth.setVisible(true);
                seventh.setVisible(true);
                reset.setVisible(true);
                undo.setVisible(true);
                save.setVisible(true);
                load.setVisible(true);
                start.setVisible(false);
                instructions.setVisible(false);
                turn.setVisible(true);



                
        	}
        });
        //at first, the control panel should not display all the buttons necessary
        //the game on the home page
        
        control_panel.add(reset);
        reset.setVisible(false);

        control_panel.add(undo);
        undo.setVisible(false);

        control_panel.add(save);
        save.setVisible(false);

        control_panel.add(load);
        load.setVisible(false);
        
        control_panel.add(turn);
        turn.setVisible(false);

        control_panel.add(start);

        control_panel.add(instructions);

        column_panel.add(first);
        column_panel.add(second);
        column_panel.add(third);
        column_panel.add(fourth);
        column_panel.add(fifth);
        column_panel.add(sixth);
        column_panel.add(seventh);
        first.setVisible(false);
        second.setVisible(false);
        third.setVisible(false);
        fourth.setVisible(false);
        fifth.setVisible(false);
        sixth.setVisible(false);
        seventh.setVisible(false);
        

        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setResizable(false);
		
	}
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}


