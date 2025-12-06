package listacompra;

import java.util.Scanner;

public class GestorListaCompra {
    private static String[] productos = new String[50];
    private static int contador = 0;

    // Añadir producto
    public static boolean addProducto(String producto) {
        if (contador < productos.length) {
            productos[contador] = producto;
            contador++;
            return true;
        }
        return false;
    }

    // Eliminar producto
    public static boolean eliminarProducto(String producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].equalsIgnoreCase(producto)) {
                // Desplazar elementos
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    // Buscar producto
    public static int buscarProducto(String producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].equalsIgnoreCase(producto)) {
                return i;
            }
        }
        return -1;
    }

    // Obtener lista completa
    public static String[] obtenerLista() {
        String[] lista = new String[contador];
        for (int i = 0; i < contador; i++) {
            lista[i] = productos[i];
        }
        return lista;
    }

    // Vaciar lista
    public static void vaciarLista() {
        productos = new String[50];
        contador = 0;
    }

    // Menú principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Lista de la Compra ===");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Mostrar lista completa");
            System.out.println("5. Vaciar lista");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Producto a añadir: ");
                    String prodAdd = sc.nextLine();
                    System.out.println(addProducto(prodAdd) ? "Añadido." : "Lista llena.");
                    break;
                case 2:
                    System.out.print("Producto a eliminar: ");
                    String prodDel = sc.nextLine();
                    System.out.println(eliminarProducto(prodDel) ? "Eliminado." : "No encontrado.");
                    break;
                case 3:
                    System.out.print("Producto a buscar: ");
                    String prodBus = sc.nextLine();
                    int pos = buscarProducto(prodBus);
                    System.out.println(pos >= 0 ? "Encontrado en posición " + pos : "No encontrado.");
                    break;
                case 4:
                    System.out.println("Lista completa:");
                    for (String p : obtenerLista()) {
                        System.out.println("- " + p);
                    }
                    break;
                case 5:
                    vaciarLista();
                    System.out.println("Lista vaciada.");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        sc.close();
    }
}

