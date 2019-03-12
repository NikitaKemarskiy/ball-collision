import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Form extends JFrame {
    // Private
    private static int screenWidth; // Screen width in pixels
    private static int screenHeight; // Screen height in pixels
    private Container pane;
    private MyComponent graphics;
    private JPanel options;

    // Static initialization block
    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
    }

    // Public
    public Form() {
        super();
        pane = this.getContentPane();
        pane.setLayout(new OverlayLayout(pane));
        this.setSize(new Dimension(screenWidth / 3, (int) (screenHeight / 2.5))); // Size
        this.setMinimumSize(new Dimension(screenWidth / 3, (int) (screenHeight / 2.5)));
        this.setLocation(screenWidth / 2 - this.getWidth() / 2, screenHeight / 2 - this.getHeight() / 2); // Location
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public Form(String title) {
        super(title);
        pane = this.getContentPane();
        pane.setLayout(new OverlayLayout(pane));
        this.setSize(new Dimension(screenWidth / 3, (int) (screenHeight / 2.5))); // Size
        this.setMinimumSize(new Dimension(screenWidth / 3, (int) (screenHeight / 2.5)));
        this.setLocation(screenWidth / 2 - this.getWidth() / 2, screenHeight / 2 - this.getHeight() / 2); // Location
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public void draw(int ball1Size, int ball2Size) {
        graphics = new MyComponent(ball1Size, ball2Size);
        options = new JPanel(new FlowLayout());

        options.setLocation(15, 15);
        options.setSize(160, 190);
        options.add(new JButton("button"));
        options.add(new JTextField(15));
        options.setBackground(new Color(0, 0, 0, 180));
        options.setAlignmentX(0.3f);
        options.setAlignmentY(0.3f);
        options.setOpaque(true);

        pane.add(options);
        pane.add(graphics);
    }

    public void update() {
        graphics.repaint();
    }
}

class MyComponent extends JComponent {
    // Private
    private static int defaultSize = 30;
    private static Color backgroundColor = new Color(22, 27, 33);
    private static Color ballColor = new Color(244, 169, 80);
    private int ball1Size;
    private int ball2Size;

    // Public
    MyComponent(int ball1Size, int ball2Size) {
        this.ball1Size = ball1Size;
        this.ball2Size = ball2Size;
    }

    public void paint(Graphics g) {
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

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(ballColor);
        g2.fill(ball1);
        g2.fill(ball2);
    }
}