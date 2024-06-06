package TiendaIndianaJeans;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private ProductoServicio productoServicio;
    private Scanner scanner;

    // Constructor
    public Menu() {
        productoServicio = new ProductoServicio();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("1 Listar Producto");
            System.out.println("2 Agregar Producto");
            System.out.println("3 Exportar Datos");
            System.out.println("4 Salir");
            System.out.print("Ingrese una opción: ");
            try {
                String input = scanner.nextLine();
                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        productoServicio.listarProductos();
                        break;
                    case 2:
                        agregarProducto();
                        break;
                    case 3:
                        exportarDatos();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor ingrese una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
        } while (opcion != 4);
        scanner.close();
    }

    // Método para agregar un producto
    private void agregarProducto() {
        System.out.println("Ingrese los detalles del producto:");
        System.out.print("Artículo: ");
        String articulo = scanner.nextLine();
        System.out.print("Precio: ");
        String precio = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Talla: ");
        String talla = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
        productoServicio.agregarProducto(producto);
        System.out.println("Producto agregado correctamente.");
    }

    // Método para exportar datos
    private void exportarDatos() {
        Exportador exportador = new ExportadorTxt();
        try {
            exportador.exportar(productoServicio.getListaProductos());
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}
