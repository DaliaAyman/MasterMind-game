import java.awt.*;
import java.awt.event.*;
/*
 * author: Fatma Gamal ElNagar
 */
public class GameController{
	GameView theView;
	GameModel theModel;
	
	public GameController(GameView view, GameModel model) {
		theModel = model;
		theView = view;
		theView.turn = 9;
		this.theView.addGameListener(new thehandler());
	}
	
	private class thehandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if (event.getSource() == theView.newGame){
				theView.startNewGame(); 
				theModel.turn = 9; 
				theModel.generateRandomPattern();
				theModel.resetGuessedPattern();
				theView.ok.setEnabled(true);
			}
			else if(event.getSource() == theView.inst)      {theView.showInst();}
			else if(event.getSource() == theView.redBtn)    {theModel.temp = theModel.redB;} 
			else if(event.getSource() == theView.greenBtn)  {theModel.temp = theModel.greenB;}
			else if(event.getSource() == theView.blueBtn)   {theModel.temp = theModel.blueB;} 
			else if(event.getSource() == theView.yellowBtn) {theModel.temp = theModel.yellowB;} 
			else if(event.getSource() == theView.brownBtn)  {theModel.temp = theModel.brownB;} 
			else if(event.getSource() == theView.orangeBtn) {theModel.temp = theModel.orangeB;} 
			else if(event.getSource() == theView.blackBtn)  {theModel.temp = theModel.blackB;} 
			else if(event.getSource() == theView.whiteBtn)  {theModel.temp = theModel.whiteB;} 
			
			else if(event.getSource() == theView.ok){ 
				if(theModel.isFilled()){
					theModel.checkResult();
					theView.showResult(theModel.countW, theModel.countB, theModel.turn);
					boolean state = theModel.isWin();
						if(theModel.isWin()){ 				//if win
							theView.showGeneratedPattern(theModel.generatedPattern, state);
							theView.ok.setEnabled(false);
						}
						else{								//not win
							if (theModel.turn != 0){		//still playing
								theModel.turn--;
								theModel.resetGuessedPattern();
							}
						    else if(theModel.turn==0){		//last turn
							theView.showGeneratedPattern(theModel.generatedPattern, state);
							theView.ok.setEnabled(false);
							}		
						}
				}
				
				else{										//if balls are not complete
					theView.showOrderofPlay();
				}
			}
			else{
				for (int i=0; i<10; i++){
					for (int j=0; j<theModel.LENGTH ; j++){
						if (event.getSource() == theView.GameBtns[theModel.turn][j])
			         	{if(!theModel.checkIfContains(theModel.temp)){
							theModel.placeBall(theModel.temp, j);
					    	theView.placePic(theModel.temp.picture, theModel.turn, j);
			            	}
						}
					}
				}
			}
		}
	}
}





