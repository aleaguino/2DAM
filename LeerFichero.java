package ArchivosTexto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
/**
 *
 * @author aleag
 */
public class LeerFichero {

    public static void main(String[] args) {
        String nombreArchivo = "mi_archivo.txt";

        escribirEnArchivo(nombreArchivo);

        leerArchivo(nombreArchivo);
    }

    public static void escribirEnArchivo(String nombreArchivo) {
        try {
            FileWriter escritor = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferEscritura = new BufferedWriter(escritor);
            PrintWriter escritura = new PrintWriter(bufferEscritura);

            BufferedReader lectorConsola = new BufferedReader(new InputStreamReader(System.in));
            String linea;

            System.out.println("Escribe líneas en el archivo. Para finalizar, escribe '#' en una línea:");

            while (true) {
                linea = lectorConsola.readLine();
                if (linea.equals("#")) {
                    break;
                }
                escritura.println(linea);
            }

            escritura.close();
            System.out.println("Datos escritos en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        try {
            FileReader lector = new FileReader(nombreArchivo);
            BufferedReader bufferLectura = new BufferedReader(lector);

            String linea;

            System.out.println("Contenido del archivo:");

            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLectura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


