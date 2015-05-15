import java.net.URL;

import javax.swing.ImageIcon;

public class Ball {
	public String color;
	ImageIcon picture;
	public void setImage(URL url){
		picture = new ImageIcon(url);
	}
}