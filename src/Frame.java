import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    
    Frame() {
        this.setSize(720, 720);
        this.setResizable(false);
        this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        this.setBackground(Color.ORANGE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
}

class RoundedPanel extends JPanel {
    private int cornerRadius = 40; // Change this for more/less curve

    public RoundedPanel() {
        super();
        setOpaque(false); // Needed for transparent corners
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill rounded rectangle background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g);
    }
}