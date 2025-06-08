

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorFicheros {

    public static void exportarAdoptados(List<Gato> listaGatos) {
        String carpeta = "exportados";
        String rutaArchivo = carpeta + File.separator + "gatos_adoptados.txt";

        // Crear la carpeta si no existe
        File directorio = new File(carpeta);
        if (!directorio.exists()) {
            boolean creada = directorio.mkdirs();
            if (!creada) {
                System.out.println("No se pudo crear la carpeta de exportación.");
                return;
            }
        }

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
