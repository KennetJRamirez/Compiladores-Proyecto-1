# Analizador Gramatical con ANTLR

Este proyecto consiste en un analizador gramatical desarrollado en Java utilizando ANTLR para el análisis de lenguaje PL/SQL. Proporciona funcionalidades para el análisis sintáctico y la generación de salidas detalladas sobre los tokens y su frecuencia de aparición en un archivo de entrada.

## Contenido del Repositorio

- `src/`: Directorio que contiene el código fuente del proyecto.
  - `antlrarchivos/`: Contiene los archivos generados por ANTLR a partir del archivo .g4.
  - `Main.java`: Clase principal que ejecuta el análisis gramatical.
- `input.txt`: Archivo de ejemplo que contiene sentencias PL/SQL para ser analizadas.
- `output.txt`: Archivo de salida que contiene los resultados del análisis gramatical.

## Instalación de ANTLR

Para configurar ANTLR en este proyecto, sigue estos pasos:

1. Dirígete al sitio web oficial de ANTLR: [https://www.antlr.org](https://www.antlr.org).
2. Descarga el archivo JAR de ANTLR desde la sección de descargas del sitio web.
3. Abre IntelliJ IDEA y carga tu proyecto.
4. Ve a "File" (Archivo) en la barra de menú, luego selecciona "Project Structure" (Estructura del proyecto).
5. En el panel izquierdo, haz clic en "Libraries" (Bibliotecas).
6. Haz clic en el botón "+" y selecciona "From Java..." (Desde Java).
7. Busca y selecciona el archivo JAR de ANTLR que acabas de descargar y haz clic en "OK".
8. Asegúrate de que el archivo JAR de ANTLR ahora aparezca en la lista de bibliotecas de tu proyecto.
9. Haz clic en "Apply" (Aplicar) y luego en "OK" para cerrar la ventana de configuración.

## Guía de Uso

1. Abre el proyecto en tu entorno de desarrollo.
2. Asegúrate de tener un archivo `input.txt` con sentencias PL/SQL que deseas analizar.
3. Ejecuta la clase `Main` desde tu entorno de desarrollo.
4. Observa los resultados generados en el archivo `output.txt`.

## Capturas de Funcionamiento
![image](https://github.com/KennetJRamirez/Compiladores-Proyecto-1/assets/108908710/fe81bdbc-c318-4e8d-9be3-7eb051a4f874)
![image](https://github.com/KennetJRamirez/Compiladores-Proyecto-1/assets/108908710/33175d6d-68b3-44a6-b9b7-37759c7709ae)
![image](https://github.com/KennetJRamirez/Compiladores-Proyecto-1/assets/108908710/7b35be5b-4e1c-4878-9746-83f09f624c10)
![image](https://github.com/KennetJRamirez/Compiladores-Proyecto-1/assets/108908710/129d3aca-90db-478e-b3ce-1a66b8124cf4)


## Contribuyendo

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, siéntete libre de enviar pull requests.

## Autores

- Kennet Joab Guzman Ramirez

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](https://opensource.org/licenses/MIT).
