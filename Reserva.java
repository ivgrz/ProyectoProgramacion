import java.time.LocalDate;

public class Reserva {

    private int id;
    private int clienteId;
    private int gatoId;
    private LocalDate fecha;
    private String comentario;

    public Reserva(int clienteId, int gatoId, LocalDate fecha, String comentario) {
        this.clienteId = clienteId;
        this.gatoId = gatoId;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public Reserva() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getGatoId() {
        return gatoId;
    }

    public void setGatoId(int gatoId) {
        this.gatoId = gatoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "clienteId=" + clienteId +
                ", gatoId=" + gatoId +
                ", fecha=" + fecha +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}

