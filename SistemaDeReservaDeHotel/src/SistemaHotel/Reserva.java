package SistemaHotel;

public class Reserva {
    private String cliente;
    private Quarto quarto;

    public Reserva(String cliente, Quarto quarto) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.quarto.setReservado(true);
    }

    public String getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void cancelar() {
        this.quarto.setReservado(false);
    }

    @Override
    public String toString() {
        return "Reserva - Cliente: " + cliente + ", Quarto: " + quarto.getNumero();
    }
}
