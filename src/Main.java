import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Form window = new Form("Ball collision");
        window.draw(1, 4);

        window.setVisible(true);
    }
}

class myClass {}

/*
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuBar menuBar = new JMenuBar();
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0, 50, 15);
        JLabel label = new JLabel(Integer.toString(slider.getValue()));

        popupMenu.add(new JMenuItem("Cut"));
        popupMenu.add(new JMenuItem("Copy"));
        popupMenu.add(new JMenuItem("Paste"));

        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemExit = new JMenuItem("Exit");
        JMenuItem itemCut = new JMenuItem("Cut");
        JMenuItem itemCopy = new JMenuItem("Copy");
        JMenuItem itemPaste = new JMenuItem("Paste");

        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        itemExit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.addSeparator();
        menuFile.add(itemExit);

        menuEdit.add(itemCut);
        menuEdit.add(itemCopy);
        menuEdit.add(itemPaste);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                label.setText(Integer.toString(slider.getValue()));
            }
        });
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel.setComponentPopupMenu(popupMenu);
        panel.add(slider, BorderLayout.WEST);
        panel.add(label, BorderLayout.CENTER);
        panel.revalidate();

        window.add(panel, BorderLayout.NORTH);
        window.setJMenuBar(menuBar);
        window.revalidate();*/
