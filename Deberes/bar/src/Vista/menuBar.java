package Vista;

import javax.swing.*;

public class menuBar {
    private JPanel pnlMenu;
    private JTextField txtMenu;

    public static void main(String[] args) {
        JFrame frame = new JFrame("menuBar");
        frame.setContentPane(new menuBar().pnlMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPnlMenu() {
        return pnlMenu;
    }
}
