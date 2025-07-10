import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorSederhana extends JFrame implements ActionListener {
    JTextField angka1Field, angka2Field;
    JLabel hasilLabel;
    JButton tambahBtn, kurangBtn, kaliBtn, bagiBtn, modBtn;

    public KalkulatorSederhana() {
        setTitle("Kalkulator Aritmatika");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        angka1Field = new JTextField();
        angka2Field = new JTextField();
        hasilLabel = new JLabel("= Hasil", SwingConstants.CENTER);

        tambahBtn = new JButton("+");
        kurangBtn = new JButton("-");
        kaliBtn = new JButton("*");
        bagiBtn = new JButton("/");
        modBtn = new JButton("Modulus");

        // Menambahkan listener
        tambahBtn.addActionListener(this);
        kurangBtn.addActionListener(this);
        kaliBtn.addActionListener(this);
        bagiBtn.addActionListener(this);
        modBtn.addActionListener(this);

        // Menambahkan komponen ke frame
        add(angka1Field);
        add(angka2Field);
        add(hasilLabel);
        add(tambahBtn);
        add(kurangBtn);
        add(kaliBtn);
        add(bagiBtn);
        add(modBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double angka1 = Double.parseDouble(angka1Field.getText());
            double angka2 = Double.parseDouble(angka2Field.getText());
            double hasil = 0;

            if (e.getSource() == tambahBtn) {
                hasil = angka1 + angka2;
            } else if (e.getSource() == kurangBtn) {
                hasil = angka1 - angka2;
            } else if (e.getSource() == kaliBtn) {
                hasil = angka1 * angka2;
            } else if (e.getSource() == bagiBtn) {
                if (angka2 == 0) {
                    hasilLabel.setText("Error: Bagi 0");
                    return;
                }
                hasil = angka1 / angka2;
            } else if (e.getSource() == modBtn) {
                hasil = angka1 % angka2;
            }

            hasilLabel.setText("= " + hasil);
        } catch (NumberFormatException ex) {
            hasilLabel.setText("Input tidak valid!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KalkulatorSederhana().setVisible(true);
        });
    }
}