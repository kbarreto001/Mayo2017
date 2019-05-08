
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommandS {

    public String[] LeerFichero(String nombreFichero) {
        System.out.println(nombreFichero);
        File ficheroF = new File(nombreFichero);
        int tmp1 = 0;
        String[] ficheroT = null;
        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheroF));
                BufferedReader brT = new BufferedReader(new FileReader(ficheroF));) {
            while (brT.readLine() != null) {
                tmp1++;
            }
            ficheroT = new String[tmp1];
            for (int i = 0; i < ficheroT.length; i++) {
                ficheroT[i] = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return ficheroT;
    }

    public String PalabraR(String[] ficheroT) {
        String maxP = null ;
        int maxR = 1,maxRp=0;
        for (int i = 0; i < ficheroT.length; i++) {
            for (int j = 0; j < ficheroT.length; j++) {
                if (ficheroT[i].equals(ficheroT[j])) {
                    maxRp++;
                    if(maxRp==maxR){   
                        maxR++;
                        maxP = ficheroT[j];
                    }                     
                }                
            }
            maxRp=0;
        }
        return maxP+" "+String.valueOf(maxR);
    }
}
