package listacompra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * GestorListaCompra
 *
 * Programa de consola para gestionar una lista de la compra usando un array de Strings.
 * <p>
 * Requisitos:
 * - Array máximo de 50 productos.
 * - Variable que lleva la cuenta del número de productos.
 * - Todos los métodos son estáticos (para facilitar pruebas).
 *
 * @author 
 * @version 1.0
 */
public class GestorListaCompra {

    /** Capacidad máxima de la lista. */
    public static final int CAPACIDAD = 10;

    /** Array que contiene los productos. */
    private static final String[] lista = new String[CAPACIDAD];

    /** Número actual de productos en la lista (índice de inserción). */
    private static int contador = 0;

    /* ===========================
       MÉTODOS REQUERIDOS (ESTÁTICOS)
       =========================== */

    /**
     * Intenta añadir un producto a la lista.
     *
     * @param producto nombre del producto a añadir (no nulo ni vacío)
     * @return true si se añadió correctamente; false si la lista está llena o el producto inválido
     */
    public static boolean addProducto(String producto) {
        if (producto == null) return false;
        producto = producto.trim();
        if (producto.isEmpty()) return false;
        if (contador >= CAPACIDAD) return false;

        // evitar duplicados: se permite añadir duplicados según enunciado no lo prohíbe,
        // pero aquí no permitimos duplicados exactos por buena práctica:
        if (buscarProducto(producto) != -1) return false;

        lista[contador++] = producto;
        return true;
    }

    /**
     * Elimina la primera aparición de un producto.
     *
     * @param producto nombre del producto a eliminar (no nulo)
     * @return true si se eliminó; false si no existe o parámetro inválido
     */
    public static boolean eliminarProducto(String producto) {
        if (producto == null) return false;
        int pos = buscarProducto(producto);
        if (pos == -1) return false;

        // desplazar a la izquierda para cubrir hueco
        for (int i = pos; i < contador - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[--contador] = null; // limpiar último
        return true;
    }

    /**
     * Busca un producto y devuelve su índice (0..contador-1).
     *
     * @param producto nombre del producto a buscar
     * @return índice si existe; -1 si no está o parámetro inválido
     */
    public static int buscarProducto(String producto) {
        if (producto == null) return -1;
        for (int i = 0; i < contador; i++) {
            if (lista[i].equalsIgnoreCase(producto.trim())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Obtiene copia del array con la lista actual (longitud = contador).
     *
     * @return un array de Strings con los productos actuales (no contiene nulls)
     */
    public static String[] obtenerLista() {
        return Arrays.copyOf(lista, contador);
    }

    /**
     * Vacía la lista por completo.
     */
    public static void vaciarLista() {
        for (int i = 0; i < contador; i++) {
            lista[i] = null;
        }
        contador = 0;
    }

    /* ===========================
       MÉTODOS AUXILIARES (NO REQUERIDOS PERO ÚTILES)
       =========================== */

    /**
     * Devuelve el número de productos actualmente.
     *
     * @return número de productos
     */
    public static int getContador() {
        return contador;
    }

    /* ===========================
       INTERFAZ DE CONSOLA (main)
       =========================== */

    /**
     * Menú de la aplicación. Ejecuta hasta que el usuario selecciona "Salir".
     *
     * @param args no se usan
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("Opción no válida.");
                continue;
            }

            int opcion;
            try {
                opcion = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número del 1 al 6.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Introduce nombre del producto a añadir: ");
                    String prod = sc.nextLine();
                    if (addProducto(prod)) {
                        System.out.println("Producto añadido.");
                    } else {
                        System.out.println("No se pudo añadir (lista llena, producto inválido o ya existe).");
                    }
                    break;
                case 2:
                    System.out.print("Introduce nombre del producto a eliminar: ");
                    String prodDel = sc.nextLine();
                    if (eliminarProducto(prodDel)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Introduce nombre del producto a buscar: ");
                    String prodBus = sc.nextLine();
                    int pos = buscarProducto(prodBus);
                    if (pos != -1) {
                        System.out.println("Producto encontrado en la posición " + pos + ".");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    mostrarListaConsole();
                    break;
                case 5:
                    vaciarLista();
                    System.out.println("Lista vaciada.");
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Elige entre 1 y 6.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== Lista de la Compra ===");
        System.out.println("1. Añadir producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Buscar producto");
        System.out.println("4. Mostrar lista completa");
        System.out.println("5. Vaciar lista");
        System.out.println("6. Salir");
    }

    private static void mostrarListaConsole() {
        String[] actuales = obtenerLista();
        if (actuales.length == 0) {
            System.out.println("[La lista está vacía]");
            return;
        }
        System.out.println("--- Lista completa (" + actuales.length + ") ---");
        for (int i = 0; i < actuales.length; i++) {
            System.out.printf("%d. %s%n", i + 1, actuales[i]);
        }
    }
}


