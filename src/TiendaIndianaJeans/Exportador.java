package TiendaIndianaJeans;

import java.io.IOException;
import java.util.ArrayList;

abstract class Exportador {
    public abstract void exportar(ArrayList<Producto> listaProductos) throws IOException;
}