import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Form window = new Form("Ball collision");
        window.draw(9, 8);

        window.update();

        window.setVisible(true);
    }
}