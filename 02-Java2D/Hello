import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    private Image img;
    public Hello2DFrame () {
    	this.img = new ImageIcon("putcute.jpg").getImage();
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Glorioso");
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (img != null) {
        int wdefault = 600; 
        int hdefault = 400;  
        
        int x = (getWidth() - wdefault) / 2;
        int y = (getHeight() - hdefault) / 2;
        g2d.drawImage(img, x, y, wdefault, hdefault, this);
        

        int w = getWidth();
        int h = getHeight();
        
	g2d.setPaint(Color.BLACK);
	g2d.fillOval(w/2 - 250, h/2 + 200, 500, 100);
	

	g2d.setPaint(Color.white);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
	g2d.drawString("Botafogo", w/2 - 60, h/2 + 220);
	g2d.drawString("Campeao da libertadores 2024", w/2 - 180, h/2 + 260);
	}
    }
}
