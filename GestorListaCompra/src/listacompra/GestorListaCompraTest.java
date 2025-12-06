package listacompra;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GestorListaCompraTest {

    @Before
    public void setUp() {
        GestorListaCompra.vaciarLista();
    }

    @Test
    public void testAddProducto() {
        assertTrue(GestorListaCompra.addProducto("Leche"));
    }

    @Test
    public void testEliminarProducto() {
        GestorListaCompra.addProducto("Pan");
        assertTrue(GestorListaCompra.eliminarProducto("Pan"));
    }

    @Test
    public void testBuscarProducto() {
        GestorListaCompra.addProducto("Huevos");
        assertEquals(0, GestorListaCompra.buscarProducto("Huevos"));
    }

    @Test
    public void testObtenerLista() {
        GestorListaCompra.addProducto("Agua");
        String[] lista = GestorListaCompra.obtenerLista();
        assertEquals(1, lista.length);
        assertEquals("Agua", lista[0]);
    }

    @Test
    public void testVaciarLista() {
        GestorListaCompra.addProducto("Carne");
        GestorListaCompra.vaciarLista();
        assertEquals(0, GestorListaCompra.obtenerLista().length);
    }
}
