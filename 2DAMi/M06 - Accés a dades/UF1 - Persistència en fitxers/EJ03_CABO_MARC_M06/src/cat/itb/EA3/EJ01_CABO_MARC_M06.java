package cat.itb.EA3;

import java.io.*;
import java.util.Scanner;

public class EJ01_CABO_MARC_M06 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int eleccion;

        System.out.println("\n******** MENÚ ********");
        System.out.println("1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Leer Fichero");
        System.out.println("**********************");

        System.out.println("Que ejercicio quieres hacer ?¿");
        eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                ex1();
                break;
            case 2:
                ex2();
                break;
            case 3:
                ex3();
                break;
            case 4:
                ex4();
                break;
            default:
                System.out.println("ERROR, NO EXISTE!");
                break;
        }
    }

    public static void ex1() throws IOException {
        File file = new File("Departaments.dat");
        DataOutputStream data = new DataOutputStream(new FileOutputStream(file));
        int[] numeroDepartamento = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String[] nombreDepartamento = {"Departamento de Ventas", "Departamento de RRHH", "Departamento de Marketing", "Departamento Financiero", "Departamento Administrativo", "Departamento I+D", "Departamento Logísitico", "Departameto Comercial", "Departamento de Producción", "Departamento Directivo"};
        String[] localidades = {"Barcelona", "Madrid", "Murcia", "Málaga", "Bilbao", "Santander", "Asturias", "Pontevedra", "Albacete", "Valencia"};

        for (int i = 0; i < numeroDepartamento.length; i++) {
            data.writeInt(numeroDepartamento[i]);
            data.writeUTF(nombreDepartamento[i]);
            data.writeUTF(localidades[i]);
        }
        data.close();
    }


    public static void ex2() {
        Scanner sc = new Scanner(System.in);
        File fileIN = new File("Departaments.dat");
        File fileOUT = new File("NewDepartaments");
        System.out.println("Introduce el ID de departamento a modificar : ");
        int id = sc.nextInt();
        System.out.println("Introduce el nuevo nombre de departamento : ");
        String nuevoDepartamento = sc.next();
        System.out.println("Introduce la nueva localidad : ");
        String nuevaLocalidad = sc.next();
        boolean existe = false;
        try {
            DataInputStream data = new DataInputStream(new FileInputStream(fileIN));
            DataOutputStream dataOUT = new DataOutputStream(new FileOutputStream(fileOUT));
            StringBuilder datosAntiguos = new StringBuilder();
            fileOUT.createNewFile();
            if (fileOUT.exists()) {
                while (data.available() > 1) {
                    int idAntiguo = data.readInt();
                    if (idAntiguo == id) {
                        datosAntiguos.append(idAntiguo);
                        datosAntiguos.append(" || ").append(data.readUTF());
                        datosAntiguos.append(" || ").append(data.readUTF());
                        dataOUT.writeInt(idAntiguo);
                        dataOUT.writeUTF(nuevoDepartamento);
                        dataOUT.writeUTF(nuevaLocalidad);
                        existe = true;
                    } else {
                        dataOUT.writeInt(idAntiguo);
                        dataOUT.writeUTF(data.readUTF());
                        dataOUT.writeUTF(data.readUTF());
                    }
                }
                if (existe) {
                    dataOUT.close();
                    data.close();
                    File file = new File(fileIN.getName());
                    fileIN.delete();
                    fileOUT.renameTo(file);
                    System.out.println("Departamento Antiguo : " + datosAntiguos + "\nDepartamento Nuevo: " + id + " || " + nuevoDepartamento + " || " + nuevaLocalidad);
                } else {
                    fileOUT.delete();
                    System.out.println("El ID de departamento indicado no existe!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static void ex3() {
        Scanner sc = new Scanner(System.in);
        File fileIN = new File("Departaments.dat");
        File fileOUT = new File("NewDepartaments.dat");
        System.out.println("Introduce el ID del departamento a borrar : ");
        int id = sc.nextInt();
        int contador = 0;
        try {
            DataInputStream dataIN = new DataInputStream(new FileInputStream(fileIN));
            DataOutputStream dataOUT = new DataOutputStream(new FileOutputStream(fileOUT));

            fileOUT.createNewFile();
            if (fileOUT.exists()) {
                while (dataIN.available() > 1) {
                    int idf = dataIN.readInt();
                    if (idf == id) {
                        dataIN.readUTF();
                        dataIN.readUTF();
                    } else {
                        dataOUT.writeInt(idf);
                        dataOUT.writeUTF(dataIN.readUTF());
                        dataOUT.writeUTF(dataIN.readUTF());
                        contador++;
                    }
                }
                dataOUT.close();
                dataIN.close();
                File file = new File(fileIN.getName());
                fileIN.delete();
                fileOUT.renameTo(file);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static void ex4() {
        try (DataInputStream data = new DataInputStream(new FileInputStream("Departaments.dat"))) {
            while (data.available() > 1) {
                System.out.println(data.readInt() + "\t" + data.readUTF() + "\t" + data.readUTF());
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

}
