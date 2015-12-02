
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarkenBot {

    static JFrame frame;

    public static JPanel createUI() {

        String[] wordListOne = {"24/7", "Multi-Tier", "Intuitive", "Business to business", "Win-win",
                "Front-end", "Web-based", "Pervasive", "New", "Smart", "Total", "Dynamic"};

        String[] wordListTwo = {"high-value", "objectively-oriented", "centric", "distributed", "branded",
                "outside-the-box", "positioned", "networked", "focused", "leveraged", "aligned", "targeted", "shared", "cooperative",
                "accelerated"};

        String[] wordListThree = {"process.", "solution.", "architecture.", "core competency.", "strategy.",
                "mind-share.", "portal.","campaign", "vision.", " paradigm.", "mission."};

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        JLabel intro = new JLabel("What we need is a : ");
        JLabel Phrase = new JLabel();
        Phrase.setText(wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3]);
        intro.setLabelFor(Phrase);

        Phrase.setFont(getAFont());

        final JButton button = new JButton("Get a new phrase");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int rand1 = (int) (Math.random() * oneLength);
                int rand2 = (int) (Math.random() * twoLength);
                int rand3 = (int) (Math.random() * threeLength);

                Phrase.setText(wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3]);

            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,
                BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        intro.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        Phrase.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        panel.add(intro);
        panel.add(Box.createVerticalStrut(5)); //extra space
        panel.add(Phrase);

        panel.add(Box.createRigidArea(new Dimension(350,100)));

        panel.add(button);

        return panel;
    }



    protected static Font getAFont() {
        String[] desiredFonts =
                {"Times", "Times New Roman", "Serif"};

        String[] existingFamilyNames = null;
        String fontName = null;

        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        if (ge != null) {
            existingFamilyNames = ge.getAvailableFontFamilyNames();
        }

        if ((existingFamilyNames != null) && (desiredFonts != null)) {
            int i = 0;
            while ((fontName == null) && (i < desiredFonts.length)) {

                int j = 0;
                while ((fontName == null) && (j < existingFamilyNames.length)) {
                    if (existingFamilyNames[j].startsWith(desiredFonts[i])) {

                        Font f = new Font(existingFamilyNames[j],
                                Font.PLAIN, 1);
                        if (f.canDisplay('A')) {
                            fontName = existingFamilyNames[j];
                            System.out.println("Using font: " + fontName);
                        }
                    }

                    j++;
                }
                i++;
            }
        }

        if (fontName != null) {
            return new Font(fontName, Font.PLAIN, 20);
        } else {
            return new Font("Serif", Font.PLAIN, 20);
        }
    }

    private static void createAndShowGUI() {
        frame = new JFrame("MarkenBot 3000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = createUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}