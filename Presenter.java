import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class Presenter extends JPanel {

    public abstract JComponent createCenterComponent();

    public abstract void northButtonPressed();
    public abstract void eastButtonPressed();
    public abstract void southButtonPressed();
    public abstract void westButtonPressed();
    JTextArea TextComponent;
    public Presenter() {
        JFrame frame = new JFrame();
        JPanel Holder = new JPanel();
        Holder.setLayout(new BorderLayout());
        // setup layout manager for frame
        frame.setTitle("Presenter framework");
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton westButton = new JButton("West");
        JButton eastButton = new JButton("East");
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == northButton) {
                    northButtonPressed();
                }
            }
        }
        );

        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == westButton) {
                    westButtonPressed();
                }
            }
        }
        );

        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == eastButton) {
                    eastButtonPressed();
                }
            }
        }
        );

        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == southButton) {
                    southButtonPressed();
                }
            }
        }
        );

        // add northButton to a JPanel, add that panel to frame

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(northButton, BorderLayout.NORTH);
        panel.add(southButton, BorderLayout.SOUTH);
        panel.add(westButton, BorderLayout.WEST);
        panel.add(eastButton, BorderLayout.EAST);

        Holder.add(panel, BorderLayout.WEST);
        JComponent centerComponent = createCenterComponent();
        TextComponent = new JTextArea();
        TextComponent.setText("sheesh");
        frame.add(centerComponent, BorderLayout.CENTER);
        Holder.add(TextComponent,BorderLayout.CENTER);
        frame.add(Holder, BorderLayout.SOUTH);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        panel.setVisible(true);
        Holder.setVisible(true);
    }

    public void showText(String text) {
        TextComponent.setText(text);
    }

}