import java.util.ArrayList;
import java.util.Random;
/*
 * author: Yomna Ali-ElDin
 */
public class GameModel {
	Ball temp = new Ball();
	int LENGTH = 4;
	int countW = 0;
	int countB = 0;
	int turn = 9;
	
	Ball redB = new Ball();
	Ball greenB = new Ball();
	Ball blueB = new Ball();
	Ball yellowB = new Ball();
	Ball brownB = new Ball();
	Ball orangeB = new Ball();
	Ball blackB = new Ball();
	Ball whiteB = new Ball();
	
	public GameModel(){
		redB.setImage(getClass().getResource("red.png"));
		redB.color = "red";
		greenB.setImage(getClass().getResource("green.png"));
		greenB.color = "green";
		blueB.setImage(getClass().getResource("blue.png"));
		blueB.color = "blue";
		yellowB.setImage(getClass().getResource("yellow.png"));
		yellowB.color = "yellow";
		brownB.setImage(getClass().getResource("brown.png"));
		brownB.color = "brown";
		orangeB.setImage(getClass().getResource("orange.png"));
		orangeB.color = "orange";
		blackB.setImage(getClass().getResource("black.png"));
		blackB.color = "black";
		whiteB.setImage(getClass().getResource("white.png"));
		whiteB.color = "white";
		
		generateRandomPattern();
		
	}
	
	Ball[] generatedPattern = new Ball[LENGTH];
	String [] generatedPatternColors=new String[LENGTH];
	String[] guessedPattern = new String[LENGTH];
	
	String[] set = { "red", "green", "blue", "yellow", "brown", "orange", "black", "white" };
	
	public void generateRandomPattern()
	{
		boolean b=true;
		ArrayList<Integer>indices = new ArrayList<Integer>();
	       for (int k=0; k<LENGTH; k++){    
	    	      
	    	   Random randomGenerator = new Random();
	    	   if (indices.size() < LENGTH) 
	    	   {
	    		   while(b)
	    		   {    int random = randomGenerator .nextInt(7);
		    	      if (!indices.contains(random)) 
		    	         {
		    	          indices.add(random);  
		    	          b=false;
		    	         }
	    		   }
 
                     b = true;
          switch(set[indices.get(k)]){
	    	          case "red": {generatedPattern[k] = redB;
	    	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "green":	{generatedPattern[k] = greenB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "blue":	{generatedPattern[k] = blueB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "yellow": {generatedPattern[k] = yellowB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "brown":	{generatedPattern[k] = brownB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "orange": {generatedPattern[k] = orangeB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "black":	{generatedPattern[k] = blackB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          case "white":	{generatedPattern[k] = whiteB;
	          			generatedPatternColors[k]=generatedPattern[k].color;	break;}
	    	          
	    	          }
	    	          
	    	   }		    	    
	       } 
	   }
	
	public void placeBall(Ball tempBall, int DimensionJ){
		guessedPattern[DimensionJ] = tempBall.color;
	}
	
	public void checkResult()
	{
		for(int i=0; i<LENGTH;i++)
		{
			if(ifArrayOfStContainSt(generatedPatternColors , guessedPattern[i])){
				if(generatedPatternColors[i]==guessedPattern[i])
					countW++;
				else countB++;
			}
		}
	}
	public static boolean ifArrayOfStContainSt(String []strings ,String s){
		for(int i=0; i<strings.length; i++){
			if(strings[i]==s){
		        return true;
			}
		}
		return false;
	}
	boolean isWin(){
		if(countW==LENGTH)
			return true;
		else return false;
	}
	boolean isFilled(){
		int count = 0;
		for(int i=0 ; i<LENGTH; i++){
			for(int m=0; m<8 ; m++)
				if (guessedPattern[i]== set[m]){
					count++;
				}
			}
			if (count == LENGTH)
				return true;
			else return false;
	}
	
	void resetGuessedPattern(){
		for(int k=0 ; k<LENGTH; k++){
			guessedPattern[k]="";
			countB = 0;
			countW = 0;
		}	
	}
	boolean checkIfContains(Ball ballSelected){
		for(int k=0; k<LENGTH; k++){
			if (ballSelected.color == guessedPattern[k]){
				return true;
			}
		}
		return false;
	}
	
}