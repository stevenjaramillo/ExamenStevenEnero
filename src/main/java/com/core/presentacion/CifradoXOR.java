package com.core.presentacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CifradoXOR {
    public static void main(String[] args) throws IOException {
        String archivoOrigen = "origen.txt";
        String archivoDestino = "destino.txt";
        int clave = 100;
        try {
            FileInputStream fis = new FileInputStream(archivoOrigen);
            FileOutputStream fos = new FileOutputStream(archivoDestino);
            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                byteLeido = byteLeido ^ clave;
                fos.write(byteLeido);
            }
            fis.close();
            fos.close();

            System.out.println("Archivo cifrado correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
