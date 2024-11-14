package SistemaHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {
    private Hotel hotel;
    private JTextArea txtAreaQuartos, txtAreaReservas;
    private JTextField txtCliente, txtNumeroQuarto;

    public main() {
        hotel = new Hotel(10); // Hotel com 10 quartos
        setTitle("Sistema de Reservas do Hotel");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de navegação
        JPanel painelNav = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton btnQuartos = new JButton("Exibir Quartos Disponíveis");
        JButton btnReservar = new JButton("Reservar Quarto");
        JButton btnReservas = new JButton("Exibir Reservas");
        JButton btnCancelar = new JButton("Cancelar Reserva");
        painelNav.add(btnQuartos);
        painelNav.add(btnReservar);
        painelNav.add(btnReservas);
        painelNav.add(btnCancelar);
        add(painelNav, BorderLayout.WEST);

        // Área de exibição de dados
        txtAreaQuartos = new JTextArea();
        txtAreaQuartos.setEditable(false);
        txtAreaReservas = new JTextArea();
        txtAreaReservas.setEditable(false);
        JScrollPane scrollQuartos = new JScrollPane(txtAreaQuartos);
        JScrollPane scrollReservas = new JScrollPane(txtAreaReservas);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Quartos Disponíveis", scrollQuartos);
        tabbedPane.addTab("Reservas Ativas", scrollReservas);
        add(tabbedPane, BorderLayout.CENTER);

        // Painel para entrada de dados
        JPanel painelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        painelForm.add(new JLabel("Nome do Cliente:"));
        txtCliente = new JTextField();
        painelForm.add(txtCliente);
        painelForm.add(new JLabel("Número do Quarto:"));
        txtNumeroQuarto = new JTextField();
        painelForm.add(txtNumeroQuarto);
        add(painelForm, BorderLayout.SOUTH);

        // Configurando ações dos botões
        btnQuartos.addActionListener(e -> exibirQuartosDisponiveis());
        btnReservar.addActionListener(e -> reservarQuarto());
        btnReservas.addActionListener(e -> exibirReservas());
        btnCancelar.addActionListener(e -> cancelarReserva());
    }

    private void exibirQuartosDisponiveis() {
        txtAreaQuartos.setText("");
        for (Quarto quarto : hotel.getQuartosDisponiveis()) {
            txtAreaQuartos.append(quarto + "\n");
        }
    }

    private void reservarQuarto() {
        String cliente = txtCliente.getText();
        int numeroQuarto = Integer.parseInt(txtNumeroQuarto.getText());
        if (hotel.reservarQuarto(cliente, numeroQuarto)) {
            JOptionPane.showMessageDialog(this, "Reserva realizada com sucesso!");
            exibirQuartosDisponiveis();
        } else {
            JOptionPane.showMessageDialog(this, "Quarto indisponível.");
        }
    }

    private void exibirReservas() {
        txtAreaReservas.setText("");
        for (Reserva reserva : hotel.getReservas()) {
            txtAreaReservas.append(reserva + "\n");
        }
    }

    private void cancelarReserva() {
        int numeroQuarto = Integer.parseInt(txtNumeroQuarto.getText());
        if (hotel.cancelarReserva(numeroQuarto)) {
            JOptionPane.showMessageDialog(this, "Reserva cancelada!");
            exibirQuartosDisponiveis();
            exibirReservas();
        } else {
            JOptionPane.showMessageDialog(this, "Reserva não encontrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            main gui = new main();
            gui.setVisible(true);
        });
    }
}
