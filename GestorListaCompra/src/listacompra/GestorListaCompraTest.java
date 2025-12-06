package listacompra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests unitarios para GestorListaCompra.
 *
 * Requiere JUnit 5 (junit-jupiter).
 */
public class GestorListaCompraTest {

    @BeforeEach
    public void setup() {
        // asegurar lista limpia antes de cada test
        GestorListaCompra.vaciarLista();
    }

    @Test
    public void testAddProducto() {
        assertTrue(GestorListaCompra.addProducto("Pan"));
        assertEquals(1, GestorListaCompra.getContador());
        // no permite duplicados exactos según implementación
        assertFalse(GestorListaCompra.addProducto("Pan"));
        assertTrue(GestorListaCompra.addProducto("Leche"));
        assertEquals(2, GestorListaCompra.getContador());
    }

    @Test
    public void testEliminarProducto() {
        GestorListaCompra.addProducto("Azúcar");
        GestorListaCompra.addProducto("Sal");
        assertTrue(GestorListaCompra.eliminarProducto("Azúcar"));
        assertEquals(1, GestorListaCompra.getContador());
        assertFalse(GestorListaCompra.eliminarProducto("Azúcar")); // ya no existe
    }

    @Test
    public void testBuscarProducto() {
        GestorListaCompra.addProducto("Huevos");
        GestorListaCompra.addProducto("Mantequilla");
        assertEquals(0, GestorListaCompra.buscarProducto("Huevos"));
        assertEquals(1, GestorListaCompra.buscarProducto("mantequilla")); // case-insensitive
        assertEquals(-1, GestorListaCompra.buscarProducto("Tomate"));
    }

    @Test
    public void testObtenerLista() {
        GestorListaCompra.addProducto("Manzana");
        GestorListaCompra.addProducto("Pera");
        String[] lista = GestorListaCompra.obtenerLista();
        assertArrayEquals(new String[] { "Manzana", "Pera" }, lista);
    }

    @Test
    public void testVaciarLista() {
        GestorListaCompra.addProducto("A");
        GestorListaCompra.addProducto("B");
        GestorListaCompra.vaciarLista();
        assertEquals(0, GestorListaCompra.getContador());
        assertArrayEquals(new String[] {}, GestorListaCompra.obtenerLista());
    }

    @Test
    public void testCapacidadMaxima() {
        GestorListaCompra.vaciarLista();
        for (int i = 0; i < GestorListaCompra.CAPACIDAD; i++) {
            assertTrue(GestorListaCompra.addProducto("P" + i));
        }
        // siguiente debe fallar
        assertFalse(GestorListaCompra.addProducto("Extra"));
        assertEquals(GestorListaCompra.CAPACIDAD, GestorListaCompra.getContador());
    }
}

