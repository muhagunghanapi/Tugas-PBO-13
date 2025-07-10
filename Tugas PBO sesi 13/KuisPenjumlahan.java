import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame implements ActionListener {
    JTextField angka1Field, angka2Field, jawabanField;
    JButton checkBtn;
    JLabel hasilLabel;
    int angka1, angka2;

    public KuisPenjumlahan() {
        setTitle("Kuis Penjumlahan");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Random angka
        Random rand = new Random();
        angka1 = rand.nextInt(10); // 0-9
        angka2 = rand.nextInt(10);

        // Panel input angka dan jawaban
        JPanel panelInput = new JPanel(new GridLayout(1, 5));
        angka1Field = new JTextField(String.valueOf(angka1));
        angka2Field = new JTextField(String.valueOf(angka2));
        jawabanField = new JTextField();

        angka1Field.setEditable(false);
        angka2Field.setEditable(false);

        panelInput.add(angka1Field);
        panelInput.add(new JLabel("+", SwingConstants.CENTER));
        panelInput.add(angka2Field);
        panelInput.add(new JLabel("=", SwingConstants.CENTER));
        panelInput.add(jawabanField);

        // Tombol check
        checkBtn = new JButton("CHECK");
        checkBtn.addActionListener(this);

        // Label hasil
        hasilLabel = new JLabel("", SwingConstants.CENTER);

        add(panelInput);
        add(checkBtn);
        add(hasilLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int jawabanUser = Integer.parseInt(jawabanField.getText());

            if (jawabanUser == (angka1 + angka2)) {
                hasilLabel.setText("Selamat Jawaban Anda Benar !!!");
                getContentPane().setBackground(Color.GREEN);
            } else {
                hasilLabel.setText("Maaf, Jawaban Anda Salah");
                getContentPane().setBackground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            hasilLabel.setText("Input tidak valid!");
            getContentPane().setBackground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KuisPenjumlahan().setVisible(true);
        });
    }
}