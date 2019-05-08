package sockettcpclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ComandC {

    protected File fichero;
    protected String nombreFichero;

    public File NombreFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del fichero");
        nombreFichero = sc.next();

        return fichero = new File(nombreFichero);
    }

    public Byte[] LeerFichero(File fichero) {
        Byte[] ficheroInf = new Byte[(int) fichero.length()];
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(fichero));) {
            for (int i = 0; i < ficheroInf.length; i++) {
                ficheroInf[i] = dis.readByte();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return ficheroInf;
    }

    public void EnviarFichero(Byte[] fichero, DataOutputStream dosSocket, File ficheroN) {
        try {
            dosSocket.writeUTF(ficheroN.getName());
            dosSocket.writeInt((int) ficheroN.length());
            for (int i = 0; i < fichero.length; i++) {
                dosSocket.writeByte(fichero[i]);
            }
            dosSocket.writeByte(fichero[fichero.length - 1]);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }

    public void LeerFicheroN(String repeticionesyV) throws IOException {
        File ficheroN = new File("bytes.txt");
        int tmp = 0;
        String tmp2;
        String[] tmp3;
        if (ficheroN.exists()) {
            try (
                    BufferedReader br = new BufferedReader(new FileReader(ficheroN));
                    BufferedReader brT = new BufferedReader(new FileReader(ficheroN));) {
                while ((tmp2 = brT.readLine()) != null) {
                    tmp++;
                }
                tmp3 = new String[tmp + 1];
                tmp3[tmp3.length - 1] = repeticionesyV;
                for (int i = 0; i < tmp3.length - 1; i++) {
                    tmp3[i] = br.readLine();
                }
                GuardarFicheroN(ficheroN, tmp3);
            }
        } else {
            GuardarFicheroN(ficheroN, repeticionesyV);
        }
    }

    public void GuardarFicheroN(File ficheroN, String[] ficheroG) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroN));) {
            for (int i = 0; i < ficheroG.length; i++) {
                bw.write(ficheroG[i] + "\n");
            }
        }
    }

    public void GuardarFicheroN(File ficheroN, String ficheroG) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroN));) {
            bw.write(ficheroG);
        }
    }

    public String RecibirInfoFinal(DataInputStream disSocket) throws IOException {
        String repeticionesyV = null;
        try {
            repeticionesyV = nombreFichero + " " + disSocket.readUTF();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return repeticionesyV;
    }
}
