# Memoria Técnica – Lista de la Compra
1. Relación programa - hardware:
Mi programa Java se ejecuta sobre la JVM (Java Virtual Machine):
- Memoria RAM: aquí se carga el bytecode (LO QUE HAY DENTRO DE UN .class) generado por el compilador y se almacenan las variables.
- CPU: interpreta y ejecuta las instrucciones del bytecode, transformándolas en operaciones reales sobre el hardware.
- Periféricos: el teclado se usa como dispositivo de entrada y la pantalla como dispositivo de salida.

2. Código fuente, objeto y ejecutable:
- Código fuente: archivos .java escritos por el programador.
- Código objeto: archivos .class generados al compilar, contienen el bytecode.
- Ejecutable: el programa que corre en la JVM, ya sea lanzado desde Eclipse o desde terminal con java.

3. Eclipse como IDE:
Eclipse me ha proporcionado:
- Autocompletado, depuración y ejecución rápida de pruebas con JUnit.
- Integración con Git para commits y gestión de ramas.
- Facilidad para organizar paquetes y clases.

Mi proceso de desarrollo se ha ajustado a una metodología ágil tipo Kanban/Scrum, porque:
- He hecho commits frecuentes en Git.
- He probado continuamente con JUnit para validar funcionalidades.

4. Generación de ejecutables:
- Desde Eclipse: File → Export → Runnable JAR.
- Desde terminal:
  javac GestorListaCompra.java
  java GestorListaCompra

5. Desde otro IDE: IntelliJ:
Abre el proyecto en IntelliJ.
Ve a File → Project Structure → Artifacts.
Añade un nuevo artefacto tipo JAR → From modules with dependencies.
Selecciona la clase principal (main).
Compila el proyecto con Build → Build Artifacts → Build.
Obtendrás el .jar en la carpeta out/artifacts/.

