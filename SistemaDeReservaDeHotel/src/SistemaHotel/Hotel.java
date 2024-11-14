package SistemaHotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel(int numQuarto) {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();

        for (int i = 1; i <= numQuarto; i++) {
            quartos.add(new Quarto(i));
        }
    }

    public List<Quarto> getQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (!quarto.isReservado()) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean reservarQuarto(String cliente, int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto && !quarto.isReservado()) {
                reservas.add(new Reserva(cliente, quarto));
                return true;
            }
        }
        return false;
    }

    public boolean cancelarReserva(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                reserva.cancelar();
                reservas.remove(reserva);
                return true;
            }
        }
        return false;
    }
}
