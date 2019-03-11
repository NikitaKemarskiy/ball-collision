import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;

public class Form {
    // Private
    private Form() {}

    // Public
    public static JFrame getFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame window = new JFrame() { // New window
            // Anonymous class code
        };
        Dimension screenSize = toolkit.getScreenSize();
        window.setSize(screenSize.width / 3, (int) (screenSize.height / 2.5)); // Size
        window.setLocation(screenSize.width / 2 - window.getWidth() / 2, screenSize.height / 2 - window.getHeight() / 2); // Location
        window.setTitle("Ball collision"); // Title
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program after closing a window
        return window;
    }

    public static void draw(JFrame window) {
        Container container = window.getContentPane();
        container.add(new MyComponent());
        container.setBackground(new Color(255, 255, 255));
        window.setVisible(true);
    }
}

class MyComponent extends Component {
    private int defaultSize = 30;

    public void paint(Graphics g) {
        drawBalls(g);
    }

    private void drawBalls(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth(); // Application width
        int height = getHeight(); // Application height
        int ball1Size = defaultSize;
        int ball2Size = defaultSize * 3;
        Ellipse2D ball1 = new Ellipse2D.Double(width - ball1Size, height - ball1Size, ball1Size, ball1Size);
        Ellipse2D ball2 = new Ellipse2D.Double(0, height - ball2Size, ball2Size, ball2Size);

        /*g2.setStroke(new BasicStroke(3));
        g2.setPaint(Color.BLACK);
        g2.draw(ball1);
        g2.draw(ball2);*/
        g2.setPaint(Color.RED);
        g2.fill(ball1);
        g2.fill(ball2);
    }
}