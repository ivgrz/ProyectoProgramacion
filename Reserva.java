public class Reserva {

        private String nombreCliente;
        private String fecha;

        public Reserva() {
        }

        public Reserva(String nombreCliente, String fecha) {
            this.nombreCliente = nombreCliente;
            this.fecha = fecha;
        }

        public String getNombreCliente() {
            return nombreCliente;
        }

        public void setNombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        @Override
        public String toString() {
            return "Reserva: " + nombreCliente + " el " + fecha;
        }
    }


