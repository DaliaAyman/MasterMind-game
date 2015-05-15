import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
/*
 * author: Dalia Ayman Ahmed
 */
public class GameView extends JFrame {
	JFrame frame = new JFrame();
	int LENGTH = 4; int height = 10; int turn;
	String[] Length = { "4", "6", "8" };
	ImageIcon red = new ImageIcon(getClass().getResource("red.png"));
	ImageIcon green = new ImageIcon(getClass().getResource("green.png"));
	ImageIcon blue = new ImageIcon(getClass().getResource("blue.png"));
	ImageIcon yellow = new ImageIcon(getClass().getResource("yellow.png"));
	ImageIcon brown = new ImageIcon(getClass().getResource("brown.png"));
	ImageIcon orange = new ImageIcon(getClass().getResource("orange.png"));
	ImageIcon black = new ImageIcon(getClass().getResource("black.png"));
	ImageIcon white = new ImageIcon(getClass().getResource("white.png"));
	ImageIcon hole = new ImageIcon(getClass().getResource("insert.png"));
	ImageIcon circle = new ImageIcon(getClass().getResource("circle.png"));
	ImageIcon qmark = new ImageIcon(getClass().getResource("qmark.png"));
	
	ImageIcon wcircle = new ImageIcon(getClass().getResource("wcircle.png"));
	ImageIcon bcircle = new ImageIcon(getClass().getResource("bcircle.png"));
	
	JButton redBtn = new JButton(red);
	JButton greenBtn = new JButton(green);
	JButton blueBtn = new JButton(blue);	
	JButton yellowBtn = new JButton(yellow);	
	JButton brownBtn = new JButton(brown);
	JButton orangeBtn = new JButton(orange);
	JButton blackBtn = new JButton(black);		
	JButton whiteBtn = new JButton(white);		
	
	JButton[][] GameBtns;
	JButton[][] ResultBtns;
	JLabel[] correctB;
	JLabel[] LogoB;
	
	JButton inst = new JButton ("Instructions");
	JButton newGame = new JButton("New Game");
	JButton ok = new JButton("OK");
	
	GameView() {
		redBtn.setContentAreaFilled(false); 	redBtn.setBorderPainted(false);
		greenBtn.setContentAreaFilled(false);	greenBtn.setBorderPainted(false);
		blueBtn.setContentAreaFilled(false);	blueBtn.setBorderPainted(false);
		yellowBtn.setContentAreaFilled(false);	yellowBtn.setBorderPainted(false);
		brownBtn.setContentAreaFilled(false);	brownBtn.setBorderPainted(false);
		orangeBtn.setContentAreaFilled(false);	orangeBtn.setBorderPainted(false);
		blackBtn.setContentAreaFilled(false);	blackBtn.setBorderPainted(false);
		whiteBtn.setContentAreaFilled(false);	whiteBtn.setBorderPainted(false);
	
		JPanel ballsPanel = new JPanel();
		JPanel correctP = new JPanel();
		JPanel trials = new JPanel();
		JPanel resultBalls = new JPanel();
		JPanel Game = new JPanel();
		JPanel menu = new JPanel();
		JPanel below = new JPanel();
		
		GameBtns = new JButton[height][LENGTH];
		trials.setLayout(new GridLayout(height, LENGTH,-25,-5));
		addButtons(GameBtns, trials, 10, hole);
		ResultBtns = new JButton[height][LENGTH];
		resultBalls.setLayout(new GridLayout(height, LENGTH,-35,-5));
		addButtons(ResultBtns, resultBalls, 10, circle);
		
		correctB = new JLabel[LENGTH];
		addLabels(correctB, correctP, qmark);
		
		Game.setLayout(new BorderLayout());
		Game.add(correctP,BorderLayout.NORTH);
		Game.add(trials, BorderLayout.WEST);
		Game.add(resultBalls, BorderLayout.EAST);
		
		ballsPanel.setLayout(new GridLayout(2,4));
		ballsPanel.setBackground(new Color(94,111,124));
		ballsPanel.setBorder(new LineBorder(new Color(170,169,170),3));
		ballsPanel.add(redBtn);
		ballsPanel.add(greenBtn);
		ballsPanel.add(blueBtn);
		ballsPanel.add(yellowBtn);
		ballsPanel.add(brownBtn);
		ballsPanel.add(orangeBtn);
		ballsPanel.add(blackBtn);
		ballsPanel.add(whiteBtn);
		
		menu.setBorder(new LineBorder(new Color(170,169,170),3));
		menu.setBackground(new Color(37,56,70));
		menu.setLayout(new GridLayout(1,3,10,10));
	
		menu.add(inst);
		menu.add(newGame);
		menu.add(ok);
		
		below.setLayout(new BorderLayout());
		below.add(ballsPanel, BorderLayout.NORTH);
		below.add(menu, BorderLayout.SOUTH);
		
		setLayout(new BorderLayout());
		add(Game, BorderLayout.NORTH);
		add(below, BorderLayout.SOUTH);
		this.setTitle("MasterMind");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(410, 710);
		this.setResizable(false);
	}
	
	public void addButtons(JButton[][] btns, JPanel t, int H, ImageIcon img){
		for(int i=0; i<10; i++){
			for(int j=0; j<LENGTH; j++){
				btns[i][j] = new JButton(img);
				btns[i][j].setContentAreaFilled(false); 	btns[i][j].setBorderPainted(false);
				t.add(btns[i][j]);
			}
		}
	}
	public void addLabels(JLabel[] lbls, JPanel t, ImageIcon img){
			for(int i=0; i<LENGTH; i++){
				lbls[i] = new JLabel(img);
				t.add(lbls[i]);
			}
	}

	void addGameListener(ActionListener handler){
		redBtn.addActionListener(handler); 
		greenBtn.addActionListener(handler); 
		blueBtn.addActionListener(handler); 
		yellowBtn.addActionListener(handler); 
		brownBtn.addActionListener(handler); 
		orangeBtn.addActionListener(handler); 
		blackBtn.addActionListener(handler); 
		whiteBtn.addActionListener(handler); 
		ok.addActionListener(handler);
		inst.addActionListener(handler);
		newGame.addActionListener(handler);
		for(int i=0; i<10; i++){
			for(int j=0; j<LENGTH; j++){
				GameBtns[i][j].addActionListener(handler);
			}
		}
    }
	
	public void placePic(ImageIcon pic, int turn, int col){
		GameBtns[turn][col].setIcon(pic);
	}
	
	public void showResult(int w, int b, int t){
			for(int j=0; j<LENGTH; j++){
				if(w>0){
					ResultBtns[t][j].setIcon(wcircle);
					w--;
				}
				else if(b>0){
					ResultBtns[t][j].setIcon(bcircle);
					b--;
				}
			}
	}
	public void showInst(){
		JOptionPane.showMessageDialog(this, "White ball indicates right color and right place. \nBlack ball indicates right color but wrong place. \nNo duplicates are allowed.", "Instructions", ICONIFIED, qmark);
	}	
	public void startNewGame(){
		for(int i=0; i<10; i++){
			for(int j=0; j<LENGTH; j++){
				GameBtns[i][j].setIcon(hole);
				ResultBtns[i][j].setIcon(circle);
			}
		}
		for(int i=0; i<LENGTH; i++){
			correctB[i].setIcon(qmark);
		}
		
	}
	public void setTurn(int t){
		turn = t;
	}
	public void showGeneratedPattern(Ball[] b, boolean state){
		for(int i=0; i<LENGTH; i++){
			correctB[i].setIcon(b[i].picture);
		} 
			if(state){
				JOptionPane.showMessageDialog(this, "You Win!");
			}
			else{
				JOptionPane.showMessageDialog(this, "Game Over!");
			}
	}
	public void showOrderofPlay(){
		JOptionPane.showMessageDialog(this, "Please fill balls in the specified row before clicking OK");
	}
}
