
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SupportC {

    public String NombreFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del fichero");
        return sc.next();
    }

    public void GuardarP(String infoR, String nombreFichero) throws IOException {
        File guardarP = new File("palabras.txt");
        String[] ficheroT;
        String tmp2;
        int tmp1 = 0;
        if (guardarP.exists()==true) {
            try (
                    BufferedReader br = new BufferedReader(new FileReader(guardarP));
                    BufferedReader brT = new BufferedReader(new FileReader(guardarP));) {
                while ((tmp2=brT.readLine()) != null) {
                    tmp1++;
                }
                ficheroT = new String[tmp1 + 1];
                ficheroT[ficheroT.length - 1] = nombreFichero + " " + infoR;                
                for (int i = 0; i < (ficheroT.length - 1); i++) {
                    ficheroT[i] = br.readLine();                    
                }               
                GuardarF(guardarP, ficheroT);
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getLocalizedMessage());
            }            
        } else {            
            GuardarF(guardarP, nombreFichero + " " + infoR);
        }
    }

    public void GuardarF(File guardarP, String[] ficheroT) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(guardarP));) {
            for (int i = 0; i < ficheroT.length; i++) {
                bw.write(ficheroT[i]+"\n");
            }
        }
    }

    public void GuardarF(File guardarP, String ficheroT) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(guardarP));) {
            bw.write(ficheroT);
        }
    }
}
