import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class myFrame extends JFrame {
    static JPanel buttongrid;
    static JPanel grid;
    static JPanel panelgrid;
    static JPanel panelgrid2;
    static JPanel panel;
    static JLabel title;
    private JButton btn1;
    private JButton btn2;
    private JButton btninfo;

    private int choise;
    private int counter = 0;
    private int counter2 = 0;
    private int metritis = 0;
    private boolean getTzoker;
    private int[] noumera = new int[45];
    private int[] tzoker = new int[20];
    private int[] noumera_xristi = new int[5];
    private int tzoker_xristi;
    private int k=0;
    private int[] nikitirioi = new int[5];
    private int tzoker_nikitirios;
    private int temp;
    private Random rd = new Random();

    public myFrame(){
        Font font = new Font("Verdana", Font.PLAIN, 14);
        JButton[] buttons = new JButton[45];
        JButton[] buttons2 = new JButton[20];

        btn1 = new JButton("ΚΑΝΕ ΤΗΝ ΚΛΗΡΩΣΗ");
        btn2 = new JButton("ΚΑΘΑΡΙΣΜΟΣ");
        btninfo = new JButton("ΠΛΗΡΟΦΟΡΙΕΣ");
        btn1.setFont(font);
        btn2.setFont(font);
        btninfo.setFont(font);

        panel = new JPanel(new BorderLayout());
        panelgrid = new JPanel(new GridLayout(5, 4));
        panelgrid2 = new JPanel(new GridLayout(5, 4));
        buttongrid = new JPanel(new GridLayout(0, 3));

        grid = new JPanel(new GridLayout(2, 0));

        title = new JLabel("ΕΠΙΛΕΞΤΕ 5 ΝΟΥΜΕΡΑ ΑΠΟ ΤΟ 1 ΕΩΣ ΤΟ 45 ΚΑΙ 1 ΑΠΟ ΤΟ 1 ΕΩΣ ΤΟ 20", SwingConstants.CENTER);
        title.setFont(font);
        panel.add(title, BorderLayout.NORTH);

        showPanel();

        chooseNumbers(buttons,buttons2);

        btninfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Προγραμματιστης : Ψαλτακης Νικολαος StormRideR "
                                + "(c)2019 - 2020 \nΈκδοση Προγράμματος V3 \nΠρόγραμμα Προσομοίωσης του παιχνιδιού ΤΖΟΚΕΡ του ΟΠΑΠ\n" + "Το Πρόγραμμα έχιε φτιαχτεί για εκπαιδευιτκούς σκοπούς και καμία "
                                + "Σχέση δεν έχει με το επίσημο πρόγραμμα του ΟΠΑΠ",
                        "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        grid.add(panelgrid);
        grid.add(panelgrid2);
        buttongrid.add(btn1);
        buttongrid.add(btn2);
        buttongrid.add(btninfo);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(buttongrid, BorderLayout.SOUTH);

        this.setContentPane(panel);
        this.setVisible(true);
        this.setSize(960,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        //setLocationRelativeTo(null);
        this.setTitle("Παίχνιδι Tzoker!!!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPanel() {
        for (int i = 0; i<noumera.length; i++) {
            noumera[i] = i+1;
        }
        for (int i = 0; i<tzoker.length; i++) {
            tzoker[i] = i+1;
        }
    }

    public void chooseNumbers (JButton[] buttons, JButton[] buttons2) {
        for (int i = 0; i<buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(noumera[i]));
            buttons[i].setSize(80, 80);
            buttons[i].setActionCommand(String.valueOf(noumera[i]));
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    choise = Integer.parseInt(e.getActionCommand())-1;
                    if (counter <=4) {
                        buttons[choise].setEnabled(false);
                        counter++;
                        noumera_xristi[k] = choise+1;
                        k++;
                    }
                }
            });
            panelgrid.add(buttons[i]);
        }

        for (int i = 0; i<buttons2.length; i++) {
            buttons2[i] = new JButton(String.valueOf(tzoker[i]));
            buttons2[i].setSize(80, 80);
            buttons2[i].setActionCommand(String.valueOf(tzoker[i]));
            buttons2[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    choise = Integer.parseInt(e.getActionCommand())-1;
                    if (counter2 < 1) {
                        buttons2[choise].setEnabled(false);
                        tzoker_xristi = choise+1;
                        counter2++;
                    }
                }
            });
            panelgrid2.add(buttons2[i]);
        }

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((counter == 5) && (counter2 == 1)) {
                    //Κλήρωση Αριθμων Τζοκερ και έλεγχος να μην είναι κανενας 0 και να μην είνια ιδιος με τον προηγουμενο
                    do {
                        temp = rd.nextInt(46);
                    }while (temp == 0);
                    nikitirioi[0] = temp;
                    for (int i = 1; i<nikitirioi.length ; i++) {
                        temp =  rd.nextInt(46);
                        for (int j = 0; j<i; j++) {
                            while (temp == 0) {
                                temp = rd.nextInt(46);
                            }
                            if (temp == nikitirioi[j]) {
                                temp =  rd.nextInt(46);
                                j = 0;
                            }
                        }
                        nikitirioi[i] =  temp;
                    }
                    Arrays.sort(nikitirioi);
                    Arrays.sort(noumera_xristi);
                    do {
                        temp = rd.nextInt(21);
                    }while (temp == 0);
                    tzoker_nikitirios = temp;

                    for (int i = 0; i<nikitirioi.length; i++) {
                        for (int j = 0; j<noumera_xristi.length; j++) {
                            if (nikitirioi[i] == noumera_xristi[j]) {
                                System.out.println(nikitirioi[i] + " - " + noumera_xristi[j]);
                                metritis ++;
                            }
                        }
                    }
                    if(tzoker_nikitirios == tzoker_xristi) {
                        getTzoker = true;
                    }
                    JOptionPane.showMessageDialog(panel, "Η ΝΙΚΗΤΡΙΑ ΣΤΥΛΗ ΤΖΟΚΕΡ ΕΙΝΑΙ Η " + nikitirioi[0] + "-" + nikitirioi[1] + "-" + nikitirioi[2] + "-" + nikitirioi[3] + "-" + nikitirioi[4]
                                    + "\n Ο ΑΡΙΘΜΟΣ ΤΖΟΚΕΡ ΕΙΝΑΙ Ο " + tzoker_nikitirios ,
                            "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
                    if (getTzoker) {
                        if (metritis == 0) {
                            JOptionPane.showMessageDialog(panel, "Δεν κερδίσατε. Βρήκατε μόνο τον αριθμό τζοκερ",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(panel, "Βρήκατε " + metritis + " + 1",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else {
                        if (metritis == 0) {
                            JOptionPane.showMessageDialog(panel, "Δεν κερδίσατε.",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(panel, "Βρήκατε " + metritis ,
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(panel, "ΔΕΝ ΕΠΙΛΈΞΑΤΕ ΚΑΝΕΝΑ ΝΟΥΜΕΡΟ Ή ΔΕΝ ΕΠΙΛΕΞΑΤΕ 5 ΝΟΥΜΕΡΑ \nΉ ΔΕΝ ΕΠΙΛΕΞΑΤΕ ΝΟΥΜΕΡΟ ΤΖΟΚΕΡ",
                            "ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                for (int i = 0; i<buttons2.length; i++) {
                    buttons2[i].setEnabled(true);
                }
                for (int i = 0; i<noumera_xristi.length; i++) {
                    noumera_xristi[i] = 0;
                }
                tzoker_xristi = 0;
                counter = 0;
                counter2 = 0;
                metritis = 0;
                k=0;
            }
        });
    }
}
