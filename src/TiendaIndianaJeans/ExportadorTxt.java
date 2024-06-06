package TiendaIndianaJeans;

import java.io.*;
import java.util.ArrayList;

class ExportadorTxt extends Exportador {
    @Override
    public void exportar(ArrayList<Producto> listaProductos) throws IOException {
        try {
            // Obtener la ruta absoluta del directorio src
            String srcPath = new File("src").getAbsolutePath();

            // Crear la carpeta Archivo dentro del directorio src si no existe
            File archivoDir = new File(srcPath + File.separator + "Archivo");
            if (!archivoDir.exists()) {
                archivoDir.mkdirs(); // Crea la carpeta y todas las carpetas padres si no existen
            }

            // Crear el archivo productos.txt dentro de la carpeta Archivo
            FileWriter fw = new FileWriter(archivoDir.getAbsolutePath() + File.separator + "productos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            // Agregar productos al final del archivo
            for (Producto producto : listaProductos) {
                writer.write(producto.toString() + "\n");
            }

            writer.close();
            System.out.println("Productos exportados correctamente a " + archivoDir.getAbsolutePath() + File.separator + "productos.txt");
        } catch (IOException e) {
            System.out.println("Error al exportar productos: " + e.getMessage());
        }
    }
}
