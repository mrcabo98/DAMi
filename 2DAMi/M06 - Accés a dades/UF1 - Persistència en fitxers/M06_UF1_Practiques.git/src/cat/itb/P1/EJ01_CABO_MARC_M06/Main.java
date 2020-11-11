package cat.itb.P1.EJ01_CABO_MARC_M06;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ex2();
        ex3();
        ex4();
        ex3();
    }

    public static void ex2() throws IOException {
        Empleat empleat;
        File fileEmpleat = new File("FitxerEmpleats.dat");
        Departament departament;
        File fileDepartament = new File("FitxerDepartaments.dat");

        if (!fileEmpleat.exists() || !fileDepartament.exists()) {

            FileOutputStream fileOutEmpleats = new FileOutputStream(fileEmpleat, true);
            ObjectOutputStream dataOSempleats = new ObjectOutputStream(fileOutEmpleats);
            FileOutputStream fileOutDepartaments = new FileOutputStream(fileDepartament, true);
            ObjectOutputStream dataOSdepartaments = new ObjectOutputStream(fileOutDepartaments);

            /* DADES EMPLEATS */
            int idEmpleats[] = {1, 2, 3, 4, 5};
            int departamentEmpleats[] = {10, 20, 30, 40, 50};
            String cognomsEmpleats[] = {"Cabo", "Fernández", "Sánchez", "Romero", "Madroñal"};
            double salariEmpleats[] = {1250.00, 1500.00, 1125.00, 3025.50, 2000.00};

            System.out.println();
            for (int i = 0; i < idEmpleats.length; i++) {
                empleat = new Empleat(idEmpleats[i], departamentEmpleats[i], cognomsEmpleats[i], salariEmpleats[i]);
                dataOSempleats.writeObject(empleat);
                System.out.println("DATOS EMPLEADO " + i + " INSERTADO EN EL ARCHIVO");
            }
            System.out.println();
            dataOSempleats.close();

            /* DADES DEPARTAMENTS */
            int idDepartaments[] = {10, 20, 30, 40, 50};
            String nomDepartaments[] = {"Comercial", "Vendas", "Informátic", "RRHH", "Administrativo"};
            String localitatDepartaments[] = {"Barcelona", "Bilbao", "Madrid", "Sevilla", "Murcia"};

            for (int i = 0; i < idDepartaments.length; i++) {
                departament = new Departament(idDepartaments[i], nomDepartaments[i], localitatDepartaments[i]);
                dataOSdepartaments.writeObject(departament);
                System.out.println("DATOS DEPARTAMENTO " + i + " INSERTADO EN EL ARCHIVO");
            }
            System.out.println();
            dataOSdepartaments.close();
        }
    }

    public static void ex3() throws IOException, ClassNotFoundException {
        Empleat empleat;
        File fileEmpleat = new File("FitxerEmpleats.dat");
        ObjectInputStream dataISempleats = new ObjectInputStream(new FileInputStream(fileEmpleat));
        Departament departament;
        File fileDepartament = new File("FitxerDepartaments.dat");
        ObjectInputStream dataISdepartaments = new ObjectInputStream(new FileInputStream(fileDepartament));

        /* LLEGIR DADES EMPLEATS */
        int i = 1;
        try {
            System.out.println("\n\n\n\nLLEGINT FITXER EMPLEATS . . . . . . . . . .");
            while (true) {
                empleat = (Empleat) dataISempleats.readObject();
                System.out.println(i + "=>");
                i++;
                System.out.println("* * * * * * * * * * * * * * * * * * * *");
                System.out.println("ID : " + empleat.getId() + "\nCOGNOM : " + empleat.getCognom() + "\nDEPARTAMENT : " + empleat.getDepartament() + "\nSALARI : " + empleat.getSalari());
                System.out.println("* * * * * * * * * * * * * * * * * * * *");
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LA LECTURA\n");
        } catch (StreamCorruptedException x) {
        }

        /* LLEGIR DADES DEPARTAMENTS */
        int d = 1;
        try {
            System.out.println("\n\n\n\nLLEGINT FITXER DEPARTAMENTS . . . . . . . . . .");
            while (true) {
                departament = (Departament) dataISdepartaments.readObject();
                System.out.println(d + "=>");
                d++;
                System.out.println("* * * * * * * * * * * * * * * * * * * *");
                System.out.println("ID : " + departament.getId() + "\nNOM DEPARTAMENT : " + departament.getNom() + "\nLOCALITAT : " + departament.getLocalitat());
                System.out.println("* * * * * * * * * * * * * * * * * * * *");
            }
        } catch (EOFException eo) {
            System.out.println("FIN DE LA LECTURA");
        } catch (StreamCorruptedException x) {
        }
        dataISdepartaments.close();
        dataISempleats.close();
    }

    public static void ex4() throws IOException {
        Empleat empleat;
        Departament departament;
        File fileEmpleats = new File("FitxerEmpleats.dat");
        ObjectOutputStream dataOSempleats;
        File fileDepartaments = new File("FitxerDepartaments.dat");
        ObjectOutputStream dataOSdepartaments;

        if (!fileEmpleats.exists() && !fileDepartaments.exists()) {
            FileOutputStream fileOutEmpleats;
            fileOutEmpleats = new FileOutputStream(fileEmpleats);
            dataOSempleats = new ObjectOutputStream(fileOutEmpleats);
            FileOutputStream fileOutDepartaments;
            fileOutDepartaments = new FileOutputStream(fileDepartaments);
            dataOSdepartaments = new ObjectOutputStream(fileOutDepartaments);
        } else {
            dataOSempleats = new MyObjectOutputStrem(new FileOutputStream(fileEmpleats, true));
            dataOSdepartaments = new MyObjectOutputStrem(new FileOutputStream(fileDepartaments, true));
        }

        /* DADES EMPLEATS */
        int idEmpleats[] = {1, 2, 3, 4, 5};
        int departamentEmpleats[] = {10, 20, 30, 40, 50};
        String cognomsEmpleats[] = {"Cabo", "Fernández", "Sánchez", "Romero", "Madroñal"};
        double salariEmpleats[] = {1250.00, 1500.00, 1125.00, 3025.50, 2000.00};

        System.out.println();
        for (int i = 0; i < idEmpleats.length; i++) {
            empleat = new Empleat(idEmpleats[i], departamentEmpleats[i], cognomsEmpleats[i], salariEmpleats[i]);
            dataOSempleats.writeObject(empleat);
        }
        System.out.println();
        dataOSempleats.close();

        /* DADES DEPARTAMENTS */
        int idDepartaments[] = {10, 20, 30, 40, 50};
        String nomDepartaments[] = {"Comercial", "Vendas", "Informátic", "RRHH", "Administrativo"};
        String localitatDepartaments[] = {"Barcelona", "Bilbao", "Madrid", "Sevilla", "Murcia"};

        for (int i = 0; i < idDepartaments.length; i++) {
            departament = new Departament(idDepartaments[i], nomDepartaments[i], localitatDepartaments[i]);
            dataOSdepartaments.writeObject(departament);
        }
        System.out.println();

    }
}