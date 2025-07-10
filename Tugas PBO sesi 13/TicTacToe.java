import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[][] buttons = new JButton[3][3];
    boolean isXturn = true; // Giliran X

    public TicTacToe() {
        setTitle("Tic Tac Toe Sederhana");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3));

        // Membuat 9 tombol dan menambahkan ke frame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();

        // Cek apakah tombol sudah berisi
        if (clickedBtn.getText().equals("")) {
            clickedBtn.setText(isXturn ? "X" : "O");
            isXturn = !isXturn; // Ganti giliran
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToe().setVisible(true);
        });
    }
}