import java.io.*;
import java.util.Scanner;

public class EJ01_CABO_MARC_M06 {
    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
        int eleccion;

        System.out.println("\n******************************************************************************************");
        System.out.println("Ejercicio 1 - Llistar el nom de tots el fitxers d'un directori que li passem per teclat");
        System.out.println("Ejercicio 2 - Omplir un fitxer creat de nou amb els textos que li passes per teclat");
        System.out.println("Ejercicio 3 - Afegir el que escrius per teclat al final d'un fitxer de text ja existent");
        System.out.println("Ejercicio 4 - Llegir línia a línia el contingut d'un fitxer de text i mostrar-lo per pantalla");
        System.out.println("Ejercicio 5 - Llegir un fitxer línia a línia utilitzan la clase Scanner");
        System.out.println("Ejercicio 6 - Llegir el fitxer enters.txt que trobaràs a la carpeta fitxers al Classroom i que mostri els números per pantalla, digui quants números hi i ha i mostri també la suma de tots els números");
        System.out.println("Ejercicio 7 - Obtenir la línia més llarga i la més curta d'un fitxer de text");
        System.out.println("Ejercicio 8 - Eliminar el fitxer que s'introdueixi la ruta pel teclat");
        System.out.println("Ejercicio 9 - Que per qualsevol ruta entrada per teclar mostri, si el fitxer exsteix o no, si es tracta de un fitxer o un directori, si es un fitxer ha de mostrar el nom, mida, permisos de lectura i escriptura");
        System.out.println("Ejercicio 10 - Que llegeixi el fitxer restaurants.csv que trobaràs a la carpeta fitxers al Classroom i mostri les dades de tots els restaurants que es trobin a l'Eixample ");
        System.out.println("Ejercicio 11 - Que permeti afegir per teclat nous restaurants al fitxer restaurants.csv utilitzant el mateix format que els que ja hi són");
        System.out.println("Ejercicio 12 - Que faci una còpia del fitxer restaurants.csv que es digui restaurants2.csv que contingui les dades de tots els restaurants que no estiguin a l'Eixample");
        System.out.println("******************************************************************************************\n");
        System.out.println("Que ejercicio quieres hacer ?¿ ");
        eleccion = lector.nextInt();

        switch (eleccion) {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5();
                break;
            case 6:
                ejercicio6();
                break;
            case 7:
                ejercicio7();
                break;
            case 8:
                ejercicio8();
                break;
            case 9:
                ejercicio9();
                break;
            case 10:
                ejercicio10();
                break;
            case 11:
                ejercicio11();
                break;
            case 12:
                ejercicio12();
                break;
            default:
                System.out.println("ERROR, NO EXISTE!");
                break;
        }
    }

    // EJERCICIO 1
    public static void ejercicio1() {
        System.out.println("********** EJERCICIO 1 **********");
        Scanner sc = null;
        System.out.println("Introduce la ruta del directorio : ");
        sc = new Scanner(System.in);

        String directorio = sc.nextLine();
        File path = new File(directorio);

        if (path.exists() && path.isDirectory()) {
            System.out.println("[dir] : " + directorio);
            File[] contents = path.listFiles();
            for (File content : contents) {
                if (content.isFile()) {
                    System.out.println("[file] : " + content.getName());
                } else {
                    System.out.println("[dir] : " + content.getPath());
                }
            }
        } else {
            System.out.println("No es un directorio");
        }
        sc.close();
        System.out.println("*********************************");
    }

    // EJERCICIO 2
    public static void ejercicio2() throws IOException {
        System.out.println("********** EJERCICIO 2 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero : ");
        String filename = sc.nextLine();
        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            System.out.println("Cuantas lineas quieres escribir ? ");
            int lineas = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < lineas; i++) {
                System.out.println("Linea " + i);
                String textLine = sc.nextLine();
                writer.write(textLine + "\n");
            }
            writer.close();
            sc.close();
        } else {
            System.out.println("El fichero ya existe");
        }
        System.out.println("Fichero creado en : " + file.getAbsolutePath());
        System.out.println("*********************************");
    }

    // EJERCICIO 3
    public static void ejercicio3() throws IOException {
        System.out.println("********** EJERCICIO 3 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);

        if (file.exists() && file.isFile()) {
            FileWriter writer = new FileWriter(file, true);
            System.out.println("El fichero se encuentra en " + file.getAbsolutePath());
            System.out.println("Escribe una frase para añadir al archivo especificado ");
            String frase = sc.nextLine();
            writer.write(frase);
            sc.close();
            writer.close();
        } else {
            System.out.println("El archivo especificado (" + file + ") no existe!");
        }
        System.out.println("*********************************");
    }

    // EJERCICIO 4
    public static void ejercicio4() throws IOException {
        System.out.println("********** EJERCICIO 4 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero a leer : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);

        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                sc.close();
            }
        } else {
            System.out.println("El archivo especificado (" + file + ") no existe!");
        }
        System.out.println("*********************************");
    }

    // EJERCICIO 5
    public static void ejercicio5() throws FileNotFoundException {
        System.out.println("********** EJERCICIO 5 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero a leer : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);

        if (file.exists()) {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } else {
            System.out.println("El archivo especificado (" + file + ") no existe!");
        }
        System.out.println("*********************************");
    }

    // EJERCICIO 6
    public static void ejercicio6() throws FileNotFoundException {
        System.out.println("\n********** EJERCICIO 6 **********");
        Scanner archivo = new Scanner(new File("enters.txt"));
        File file = new File("enters.txt");

        int num = 0, acumulador = 0, contador = 0;
        System.out.print("NÚMEROS DEL ARCHIVO : ");
        while (archivo.hasNext()) {
            num = archivo.nextInt();
            acumulador = acumulador + num;
            contador = contador + 1;
            System.out.print(" " + num);
        }
        System.out.println("\nNÚMEROS TOTALES : " + contador);
        System.out.println("SUMA TOTAL : " + acumulador);
        System.out.println("*********************************");
    }

    // EJERCICIO 7
    public static void ejercicio7() throws IOException {
        System.out.println("********** EJERCICIO 7 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero a leer : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);
        sc = new Scanner(file);

        if (file.exists()) {
            String linea, mayor = null, menor = null;
            linea = sc.nextLine();
            mayor = menor = linea;

            while (sc.hasNext()) {
                linea = sc.nextLine();
                if (linea.length() > mayor.length()) {
                    mayor = linea;
                } else if (linea.length() < menor.length()) {
                    menor = linea;
                }
            }
            System.out.println("Línea más larga : " + mayor);
            System.out.println("Línea más corta : " + menor);
            sc.close();
        } else {
            System.out.println("El archivo especificado (" + file + ") no existe!");
        }
        System.out.println("*********************************");
    }

    // EJERCICIO 8
    public static void ejercicio8() {
        System.out.println("********** EJERCICIO 8 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero a leer : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);

        if (file.delete()) {
            System.out.println("El fichero se ha borrado satisfactoriamente!");
        } else {
            System.out.println("El fichero no se ha podido eliminar");
        }
        sc.close();
        System.out.println("*********************************");
    }

    // EJERCICIO 9
    public static void ejercicio9() {
        System.out.println("********** EJERCICIO 9 **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta y el nombre del fichero a leer : ");
        String pathFile = sc.nextLine();
        File file = new File(pathFile);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Nombre del Archivo : " + file.getName());
                System.out.println("Tamaño del Archivo : " + file.length());
                System.out.println("Permisos de Lectura : " + file.canRead());
                System.out.println("Permisos de Escritura : " + file.canWrite());
            } else if (file.isDirectory()) {
                System.out.println("És un directorio");
            }
            sc.close();
        } else {
            System.out.println("El archivo o directorio especificado (" + file + ") no existe!");
        }
        System.out.println("*********************************");
    }

    // EJERCICIO 10
    public static void ejercicio10() throws IOException {
        System.out.println("********** EJERCICIO 10 **********");
        String fileCSV = "restaurants.csv";
        String linea = "";
        String separador = ",";
        BufferedReader br = new BufferedReader(new FileReader(fileCSV));

        while ((linea = br.readLine()) != null) {
            String[] campo = linea.split(separador);
            if (campo[3].equalsIgnoreCase("Eixample")) {
                for (int i = 0; i < 12; i++) {
                    System.out.print(campo[i] + separador);
                }
                System.out.println();
            }
        }
        br.close();
        System.out.println("**********************************");
    }

    // EJERCICIO 11
    public static void ejercicio11() throws IOException {
        System.out.println("********** EJERCICIO 11 **********");
        Scanner sc = new Scanner(System.in);
        String fileCSV = "restaurants.csv";
        File file = new File(fileCSV);

        if (file.exists() && file.isFile()) {
            FileWriter writer = new FileWriter(file, true);
            System.out.println("Introduce el nombre del restaurante : ");
            String nombreRestaurante = sc.nextLine();
            System.out.println("Introduce el teléfono : ");
            String telefonoRestaurante = sc.nextLine();
            System.out.println("Introduce la dirección : ");
            String direccion = sc.nextLine();
            System.out.println("Introduce el Distrito : ");
            String distrito = sc.nextLine();
            System.out.println("Introduce el Barrio : ");
            String barrio = sc.nextLine();
            System.out.println("Introduce la Ciudad : ");
            String ciudad = sc.nextLine();
            System.out.println("Introduce el Código Postal");
            String cp = sc.nextLine();
            System.out.println("Introduce la Region : ");
            String region = sc.nextLine();
            System.out.println("Introduce el Pais : ");
            String pais = sc.nextLine();
            System.out.println("Introduce la Latitud : ");
            String latitud = sc.nextLine();
            System.out.println("Introduce la Longitud : ");
            String longitud = sc.nextLine();
            System.out.println("Introduce la Web del Restaurante : ");
            String web = sc.nextLine();
            System.out.println("Introduce el mail del Restaurante : ");
            String email = sc.nextLine();
            writer.write(nombreRestaurante + "," + telefonoRestaurante + "," + direccion + "," + distrito + "," + barrio + "," + ciudad + "," + cp + "," + region + "," + pais + "," + latitud + "," + longitud + "," + web + "," + email);
            sc.close();
            writer.close();
        } else {
            System.out.println("El archivo especificado (" + file + ") no existe!");
        }
        System.out.println("**********************************");
    }

    //EJERCICIO 12
    public static void ejercicio12() throws IOException {
        System.out.println("********** EJERCICIO 12 **********");
        String fileCSV = "restaurants.csv";
        String linea = "";
        String contenido;
        String separador = ",";
        BufferedReader br = new BufferedReader(new FileReader(fileCSV));
        FileWriter file = new FileWriter("restaurants2.csv");


        while ((linea = br.readLine()) != null) {
            String[] campo = linea.split(separador);
            if (!campo[3].equalsIgnoreCase("Eixample")) {
                file.write("\n");
                for (int i = 0; i < 12; i++) {
                    file.write(campo[i] + separador);
                }
            }
        }
        System.out.println("El archivo se ha generado correctamente!");
        br.close();
        System.out.println("**********************************");
    }
}

