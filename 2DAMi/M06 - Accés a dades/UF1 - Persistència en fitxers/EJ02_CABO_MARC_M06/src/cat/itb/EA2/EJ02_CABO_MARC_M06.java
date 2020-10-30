package cat.itb.EA2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EJ02_CABO_MARC_M06 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int eleccion;

        System.out.println("\n******** MENÚ ********");
        System.out.println("1. Ejercicio 1\n2. Ejercicio 2\n3. Ejercicio 3\n4. Ejercicio 4\n5. Ejercicio 5");
        System.out.println("**********************");

        System.out.println("Que ejercicio quieres hacer ?¿ (1-5)");
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
            case 5:
                ex5();
                break;
            default:
                System.out.println("ERROR, NO EXISTE!");
                break;
        }

    }

    public static void ex1() throws IOException {
        System.out.println("********** EJERCICIO 1 **********");
        Scanner sc = new Scanner(System.in);
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;

        System.out.println("Introduce el ID del empleado a buscar : ");
        id = sc.nextInt();
        posicion = (id - 1) * 36;

        if (posicion < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                apellido[i] = file.readChar();
            }

            String apellidos = new String(apellido);
            dep = file.readInt();
            salario = file.readDouble();

            System.out.println("ID : " + id + "\nApellido : " + apellidos.trim()
                    + "\nDepartamento : " + dep + "\nSalario : " + salario);

        } else {
            System.out.println("El empleado indicado no existe!");
        }
        sc.close();
        file.close();
        System.out.println("*********************************");
    }

    public static void ex2() throws IOException {
        System.out.println("********** EJERCICIO 2 **********");
        Scanner sc = new Scanner(System.in);
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        StringBuffer buffer = null;

        System.out.println("Introduce el ID : ");
        id = sc.nextInt();
        posicion = (id - 1) * 36;

        if (posicion >= file.length()) {
            file.seek(posicion);
            file.writeInt(id);

            System.out.println("Introduce el Apellido : ");
            String apellidoString = sc.next();
            buffer = new StringBuffer(apellidoString);
            buffer.setLength(10);
            file.writeChars(buffer.toString());
            System.out.println("Introduce el Departamento : ");
            dep = sc.nextInt();
            file.writeInt(dep);
            System.out.println("Introduce el Salario : ");
            salario = sc.nextDouble();
            file.writeDouble(salario);
        } else {
            System.out.println("Error! Ya existe un empleado con el ID especificado");
        }
        sc.close();
        file.close();
        System.out.println("*********************************");
    }

    public static void ex3() throws IOException {
        System.out.println("********** EJERCICIO 3 **********");
        Scanner sc = new Scanner(System.in);
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id, dep;
        long posicion;
        Double salario, salarioNuevo, salarioAntiguo, incrementoSalario;
        char apellido[] = new char[10], aux;

        System.out.println("Introduce el ID del empleado a editar : ");
        id = sc.nextInt();
        posicion = (id - 1) * 36;

        if (posicion < fichero.length()) {
            System.out.println("Introduce el incremento de sueldo para el empleado indicado : ");
            incrementoSalario = sc.nextDouble();
            file.seek(posicion);

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }

            String apellidos = new String(apellido);
            posicion = posicion + 4 + 20 + 4; // ID + APELLIDO + DEPARTAMENTO
            file.seek(posicion);
            salario = file.readDouble();
            salarioAntiguo = salario;
            salarioNuevo = salario + incrementoSalario;
            file.seek(posicion);
            file.writeDouble(salarioNuevo);
            System.out.println("Apellido : " + apellidos.trim() + "\nSalario Antiguo : " + salarioAntiguo
                    + "\nSalario Nuevo : " + salarioNuevo);
        } else {
            System.out.println("El empleado indicado no existe!");
        }
        sc.close();
        file.close();
        System.out.println("*********************************");
    }

    public static void ex4() throws IOException {
        System.out.println("********** EJERCICIO 4 **********");
        Scanner sc = new Scanner(System.in);
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;

        System.out.println("Introduce el ID del empleado que quieres eliminar : ");
        id = sc.nextInt();
        posicion = (id - 1) * 36;
        file.seek(posicion);

        if (posicion < fichero.length()) {
            StringBuilder idDelete = new StringBuilder(String.valueOf(id));
            idDelete.setLength(10);
            file.seek(posicion);
            file.writeInt(-1);
            file.writeChars(idDelete.toString());
            file.writeInt(0);
            file.writeDouble(0);
            System.out.println("El empleado " + id + " se ha eliminado correctamente!");
        } else {
            System.out.println("El empleado indicado no existe!");
        }
        sc.close();
        file.close();
        System.out.println("*********************************");
    }

    public static void ex5() throws IOException {
        System.out.println("********** EJERCICIO 5 **********");
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        StringBuilder registrosEliminados = new StringBuilder();

        int posicion = 0;
        char[] apellido = new char[10];
        while (posicion < file.length()) {
            file.seek(posicion);
            if (file.readInt() == -1) {
                registrosEliminados.append("ID:");
                for (int i = 0; i < 10; i++)
                    apellido[i] = file.readChar();
                registrosEliminados.append(new String(apellido).trim());
                registrosEliminados.append(", ");
            }
            posicion += 36;
        }
        file.close();
        System.out.println("Usuarios eliminados: " + registrosEliminados.toString());
    }
}