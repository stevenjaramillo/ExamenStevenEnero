import java.io.FileReader;
import java.io.IOException;

public class EjercicioUno {
    public static void main(String[] args) {

    }
    class Leer_Fichero {
        public void leer() {
            try {
                FileReader entrada = new FileReader(("C:/Users/Steven/Desktop/ejemplo.txt"));
                int c=entrada.read();
                while (c!=-1){
                    c=entrada.read();
                    System.out.println(c);
                }
                System.out.println();
                System.out.println("no se encuentra el archivo");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
