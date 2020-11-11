package cat.itb.P2.EJ01_CABO_MARC_M06;

import cat.itb.P1.EJ01_CABO_MARC_M06.Departament;
import cat.itb.P1.EJ01_CABO_MARC_M06.Empleat;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int eleccion;

        System.out.println("* * * * * MENÚ PRINCIPAL * * * * *");
        System.out.println("1. Generar XML Empleats");
        System.out.println("2. Generar XML Departaments");
        System.out.println("3. Llegir Empleats.XML");
        System.out.println("4. Llegir Departaments.XML");
        System.out.println("0. Sortir");
        System.out.println("* * * * * * * * * * * * * * * * * *");
        System.out.println("Que vols fer ? Opcions disponibles (0-4)");
        eleccion = sc.nextInt();

        switch (eleccion) {
            case 0:
                System.out.println("Sortint . . . . . . . . . .");
                break;
            case 1:
                escriureEmpleats();
                break;
            case 2:
                escriureDepartaments();
                break;
            case 3:
                llegirEmpleatsXML();
                break;
            case 4:
                llegirDepartamentsXML();
                break;
            default:
                System.out.println("Error! La opción indicada no existe!\n");
                break;
        }
    }

    public static void escriureEmpleats() throws IOException, ClassNotFoundException {
        File file = new File("FitxerEmpleats.dat");
        FileInputStream filein = new FileInputStream(file);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso de creación del fichero a XML (Empleats.XML) . . .");
        LlistaEmpleats listaper = new LlistaEmpleats();
        try {
            while (true) {
                Empleat empleat = (Empleat) dataIS.readObject();
                listaper.add(empleat);
            }
        } catch (EOFException eo) {
        }
        dataIS.close();
        try {
            XStream xstream = new XStream();
            xstream.alias("LlistaEmpleats", LlistaEmpleats.class);
            xstream.alias("DadesEmpleat", LlistaEmpleats.class);

            xstream.addImplicitCollection(LlistaEmpleats.class, "llista");
            xstream.toXML(listaper, new FileOutputStream("Empleats.xml"));
            System.out.println("Creando fichero XML (Empleats.XML) . . .");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escriureDepartaments() throws IOException {
        File file = new File("FitxerDepartaments.dat");
        FileInputStream filein = new FileInputStream(file);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso de creación del fichero a XML (Departaments.XML) . . .");
        LlistaDepartaments listaper = new LlistaDepartaments();
        try {
            while (true) {
                Departament departament = (Departament) dataIS.readObject();
                listaper.add(departament);
            }
        } catch (IOException | ClassNotFoundException eo) {
        }
        dataIS.close();
        try {
            XStream xstream = new XStream();
            xstream.alias("LlistaDepartaments", LlistaDepartaments.class);
            xstream.alias("DadesDepartament", LlistaDepartaments.class);

            xstream.addImplicitCollection(LlistaDepartaments.class, "llista");
            xstream.toXML(listaper, new FileOutputStream("Departaments.xml"));
            System.out.println("Creando fichero XML (Departaments.XML) . . .");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void llegirEmpleatsXML() throws FileNotFoundException {
        XStream xstream = new XStream();
        xstream.alias("LlistaEmpleats", LlistaEmpleats.class);
        xstream.alias("DadesEmpleat", LlistaEmpleats.class);
        xstream.addImplicitCollection(LlistaEmpleats.class, "llista");

        LlistaEmpleats llistatEmpleats = (LlistaEmpleats) xstream.fromXML(new FileInputStream("Empleats.xml"));
        System.out.println("Número de Empleats : " + llistatEmpleats.getLlista().size());

        List<Empleat> listaEmpleats = new ArrayList<Empleat>();
        listaEmpleats = llistatEmpleats.getLlista();

        Iterator iterador = listaEmpleats.listIterator();
        int i = 1;
        while (iterador.hasNext()) {
            Empleat emp = (Empleat) iterador.next();
            System.out.println("\n" + i + "=>");
            i++;
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            System.out.println("ID : " + emp.getId() + "\nDEPARTAMENT : " + emp.getDepartament() + "\nCOGNOM : " + emp.getCognom() + "\nSALARI : " + emp.getSalari());
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
        }
        System.out.println("FIN DEL LLISTAT . . .\n");
    }

    public static void llegirDepartamentsXML() throws FileNotFoundException {
        XStream xstream = new XStream();
        xstream.alias("LlistaDepartaments", LlistaDepartaments.class);
        xstream.alias("DadesDepartament", LlistaDepartaments.class);
        xstream.addImplicitCollection(LlistaDepartaments.class, "llista");

        LlistaDepartaments llistatDepartaments = (LlistaDepartaments) xstream.fromXML(new FileInputStream("Departaments.xml"));
        System.out.println("Número de Empleats : " + llistatDepartaments.getLlista().size());

        List<Departament> listaDepartaments = new ArrayList<Departament>();
        listaDepartaments = llistatDepartaments.getLlista();

        Iterator iterador = listaDepartaments.listIterator();
        int i = 1;
        while (iterador.hasNext()) {
            Departament dep = (Departament) iterador.next();
            System.out.println("\n" + i + "=>");
            i++;
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            System.out.println("ID : " + dep.getId() + "\nNOM : " + dep.getNom() + "\nLOCALITAT : " + dep.getLocalitat());
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
        }
        System.out.println("FIN DEL LLISTAT . . .\n");
    }

}
