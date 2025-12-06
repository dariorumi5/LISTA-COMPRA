# Memoria Técnica – Lista de la Compra

## 1. Relación programa ↔ hardware
- **RAM**: almacena bytecode y variables en ejecución.
- **CPU**: interpreta y ejecuta instrucciones del bytecode.
- **Periféricos**: teclado (entrada) y pantalla (salida).

## 2. Código fuente, objeto y ejecutable
- **Fuente**: archivos `.java` escritos por el programador.
- **Objeto**: archivos `.class` compilados a bytecode.
- **Ejecutable**: programa que corre en la JVM.

## 3. Eclipse como IDE
- Facilita edición, autocompletado, depuración y pruebas.
- Se ajusta a metodologías ágiles (Scrum/Kanban) porque permite iteraciones rápidas y commits frecuentes.

## 4. Generación de ejecutables
- **Desde Eclipse**: `File → Export → Runnable JAR`.
- **Desde terminal**:
  ```bash
  javac GestorListaCompra.java
  java GestorListaCompra
