import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorFicheros {

    public static void exportarAdoptados(List<Gato> listaGatos) {
        String rutaArchivo = "exportados/gatos_adoptados.txt";

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Gato g : listaGatos) {
                if (g.isAdoptado()) {
                    writer.write(g.toString() + "\n");
                }
            }
            System.out.println("Exportación completada: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
