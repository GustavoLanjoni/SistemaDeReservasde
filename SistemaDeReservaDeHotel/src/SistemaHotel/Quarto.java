package SistemaHotel;

public class Quarto {
    private int numero;
    private boolean reservado;

    public Quarto(int numero) {
        this.numero = numero;
        this.reservado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + (reservado ? " - Reservado" : " - Disponível");
    }
}
