public class MasterMind {
	public static void main(String[] args) {	
			GameView view = new GameView();
			GameModel model = new GameModel();
			GameController controller = new GameController(view, model);
			
			view.setVisible(true);
		}
	
}
