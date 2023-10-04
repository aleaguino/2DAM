package ArchivosTexto;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aleag
 */
public class Fichero{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Escriba el nombre del archivo:");
        String nombreArchivo = "mi_archivo.txt";   

        System.out.println("Escriba el texto a escribir:");
        String textoAEscribir = sc.nextLine();
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);

            escritor.write(textoAEscribir);

            escritor.close();

            System.out.println("Se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
        }
    }
}


