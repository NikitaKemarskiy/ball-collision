import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.EmptyBorder;

class Form extends JFrame {
    // Private
    private int width = 0;
    private int height = 0;
    private Container pane = null;

    // Public
    public Form() {
        super();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        pane = this.getContentPane();
        pane.setLayout(new OverlayLayout(pane));
        this.setSize(screenSize.width / 3, (int) (screenSize.height / 2.5)); // Size
        this.setLocation(screenSize.width / 2 - this.getWidth() / 2, screenSize.height / 2 - this.getHeight() / 2); // Location
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public Form(String title) {
        super(title);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        pane = this.getContentPane();
        pane.setLayout(new OverlayLayout(pane));
        this.setSize(screenSize.width / 3, (int) (screenSize.height / 2.5)); // Size
        this.setLocation(screenSize.width / 2 - this.getWidth() / 2, screenSize.height / 2 - this.getHeight() / 2); // Location
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public void draw(int ball1Size, int ball2Size) {
        JComponent graphics = new MyComponent(ball1Size, ball2Size);
        JPanel options = new JPanel(new FlowLayout());

        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        options.setSize(160, 190);
        options.add(new JButton("button"));
        options.add(new JTextField(15));
        options.setBackground(new Color(0, 0, 0, 70));
        options.setAlignmentX(0.3f);
        options.setAlignmentY(0.3f);
        options.setOpaque(true);

        pane.add(options);
        pane.add(graphics);
    }
}

class MyComponent extends JComponent {
    // Private
    private static int defaultSize = 30;
    private int ball1Size;
    private int ball2Size;

    private void drawBalls(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth(); // Application width
        int height = getHeight(); // Application height
        int ball1Diameter = defaultSize * ball1Size;
        int ball2Diameter = defaultSize * ball2Size;
        if (ball1Diameter > getHeight() * 0.7 || ball2Diameter > getHeight() * 0.7) {
            double ratio = ball1Diameter > getHeight() * 0.7 ? ball1Diameter / (getHeight() * 0.7) : 1;
            ratio = ratio > ball2Diameter / (getHeight() * 0.7) ? ratio : ball2Diameter / (getHeight() * 0.7);
            ball1Diameter /= ratio;
            ball2Diameter /= ratio;
        }
        Ellipse2D ball1 = new Ellipse2D.Double(0, height - ball1Diameter, ball1Diameter, ball1Diameter);
        Ellipse2D ball2 = new Ellipse2D.Double(width - ball2Diameter, height - ball2Diameter, ball2Diameter, ball2Diameter);

        g2.setPaint(Color.RED);
        g2.fill(ball1);
        g2.fill(ball2);
    }

    // Public
    MyComponent(int ball1Size, int ball2Size) {
        this.ball1Size = ball1Size;
        this.ball2Size = ball2Size;
    }

    public void paint(Graphics g) {
        drawBalls(g);
    }
}