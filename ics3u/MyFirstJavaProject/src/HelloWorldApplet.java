import java.applet.Applet;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class HelloWorldApplet extends Applet {

	public void paint(Graphics g) {
		g.drawString("Hello World", 50, 25);
	}

}
