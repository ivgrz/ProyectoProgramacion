import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
        private static final Scanner scanner = new Scanner(System.in);
        private static final List<Cliente> clientes = new ArrayList<>();
        private static final List<Reserva> reservas = new ArrayList<>();
        private static final GatoDAO gatoDAO = new GatoDAO();

        public static void main(String[] args) {
            int opcion;
            do {
                mostrarMenu();
                opcion = leerEntero("Opción: ");
                switch (opcion) {
                    case 1 -> registrarGato();
                    case 2 -> mostrarGatos();
                    case 3 -> registrarCliente();
                    case 4 -> registrarReserva();
                    case 5 -> GestorFicheros.exportarAdoptados(gatoDAO.listarTodos());
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }

        private static void mostrarMenu() {
            System.out.println("""
                --- MENÚ CAT CAFÉ ---
                1. Registrar gato
                2. Mostrar gatos
                3. Registrar cliente
                4. Registrar reserva
                5. Exportar gatos adoptados
                0. Salir
                """);
        }

        private static void registrarGato() {
            String nombre = leerTexto("Nombre: ");
            String raza = leerTexto("Raza: ");
            int edad = leerEntero("Edad: ");
            boolean adoptado = leerBooleano("¿Está adoptado? (s/n): ");
            gatoDAO.insertar(new Gato(nombre, raza, edad, adoptado));
            System.out.println("Gato registrado.");
        }

        private static void mostrarGatos() {
            List<Gato> gatos = gatoDAO.listarTodos();
            if (gatos.isEmpty()) {
                System.out.println("No hay gatos registrados.");
            } else {
                gatos.forEach(System.out::println);
            }
        }

        private static void registrarCliente() {
            String nombre = leerTexto("Nombre del cliente: ");
            String email = leerTexto("Email: ");
            clientes.add(new Cliente(nombre, email));
            System.out.println("Cliente registrado.");
        }

        private static void registrarReserva() {
            String nombre = leerTexto("Nombre del cliente: ");
            String fecha = leerTexto("Fecha (YYYY-MM-DD): ");
            reservas.add(new Reserva(nombre, fecha));
            System.out.println("Reserva registrada.");
        }

        private static String leerTexto(String mensaje) {
            System.out.print(mensaje);
            return scanner.nextLine();
        }

        private static int leerEntero(String mensaje) {
            while (true) {
                try {
                    System.out.print(mensaje);
                    return Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número válido.");
                }
            }
        }

        private static boolean leerBooleano(String mensaje) {
            while (true) {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim().toLowerCase();
                if (entrada.equals("s")) return true;
                if (entrada.equals("n")) return false;
                System.out.println("Responde con 's' o 'n'.");
            }
        }
    }


