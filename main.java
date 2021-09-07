import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("\nObjeto 1.\n");
        Mexicano persona1 = pedirDatos();
        System.out.println("\nObjeto 2.\n");
        Mexicano persona2 = pedirDatos();
        System.out.println("\nObjeto 3.\n");
        Mexicano persona3 = pedirDatos();

        System.out.println("El RFC de "+persona1.getNombre()+ " es: "+persona1.getRfc());
        System.out.println("El CURP de "+persona2.getNombre()+ " es: "+persona2.getCurp());
        System.out.println("El RFC de "+persona3.getNombre()+ " es: "+persona3.getRfc()+" y su CURP: "+persona3.getCurp());
    }

    public static Mexicano pedirDatos() {
        Scanner sc = new Scanner(System.in);
        Mexicano persona = new Mexicano();
        String nombre, aPaterno, aMaterno, año, mes, dia, rfc, sexo, estadoN, curp;
        String acum = "", acum2 = "";

        System.out.println("Ingresa tu nombre (O nombres): ");
        nombre = sc.nextLine();
        persona.setNombre(nombre);
        System.out.println("Ingresa tu apellido paterno: ");
        aPaterno = sc.nextLine();
        System.out.println("Ingresa tu apellido materno: ");
        aMaterno = sc.nextLine();

        System.out.println("Ingresa tu año de nacimiento  (Ejemplo = 1990): ");
        año = sc.nextLine();
        System.out.println("Ingresa tu sexo (Hombre 'H', Mujer 'M': ");
        sexo = sc.nextLine();
        System.out.println("Ingresa tu mes de nacimiento: ");
        System.out.println("1 - Enero\n2 - Febrero\n3 - Marzo\n4 - Abril\n5 - Mayo\n6 - Junio\n7 - Julio\n8 - Agosto\n9 - Septiembre\n10 - Octubre\n11 - Noviembre\n12 - Diciembre");
        mes = sc.nextLine();
        switch (mes) {
            case "1":
                mes = "01";
                break;
            case "2":
                mes = "02";
                break;
            case "3":
                mes = "03";
                break;
            case "4":
                mes = "04";
                break;
            case "5":
                mes = "05";
                break;
            case "6":
                mes = "06";
                break;
            case "7":
                mes = "07";
                break;
            case "8":
                mes = "08";
                break;
            case "9":
                mes = "09";
                break;
            case "10":
                mes = "10";
                break;
            case "11":
                mes = "11";
                break;
            case "12":
                mes = "12";
                break;
            default:
                System.out.println("Ingrese una opcion correcta.");
                break;
        }

        System.out.println("Ingresa tu dia de nacimiento (Ejemplo  05, 11): ");
        dia = sc.nextLine();
        System.out.println("Ingresa tu entidad federativa de nacimiento de acuerdo a la siguiente tabla: ");
        System.out.println("\nAGUASCALIENTES AS\tBAJA CALIFORNIA BC\tBAJA CALIFORNIA SUR BS\tCAMPECHE CC\tCOAHUILA CL\nCOLIMA CM\tCHIAPAS CS\tCHIHUAHUA CH\t" + "DISTRITO FEDERAL DF\tDURANGO DG\nGUANAJUATO GT\tGUERRERO GR\tHIDALGO HG\tJALISCO JC\tMÉXICO MC\nMICHOACÁN MN\tMORELOS MS\tNAYARIT NT\tNUEVO LEÓN NL\tOAXACA OC\n" + "PUEBLA PL\tQUERÉTARO QT\tQUINTANA ROO QR\tSAN LUIS POTOSÍ SP\tSINALOA SL\nSONORA SR\tTABASCO TC\tTAMAULIPAS TS\tTLAXCALA TL\tVERACRUZVZ\nYUCATÁN YN\tZACATECAS ZS\tNACIDO EN EL EXTRANJERO NE\n");
        estadoN = sc.nextLine();

        persona.setCurp(calcularCurp(nombre, aPaterno, aMaterno, año, mes, dia, sexo, estadoN));
        persona.setRfc(calcularRfc(nombre, aPaterno, aMaterno, año, mes, dia));
        persona.setNombre(nombre);
        return persona;

    }
    public static String consInterna(String aPaterno, String aMaterno, String nombre) {
        StringBuilder sb = new StringBuilder();
        String suma = "";
        char c1 = aPaterno.charAt(0);
        char c2 = aMaterno.charAt(0);
        char c3 = nombre.charAt(0);
        char c4 = 0, c5 = 0, c6 = 0;
        for (int i = 1; i < aPaterno.length(); i++) {
            char e = aPaterno.charAt(i);
            if (e != 'A' && e != 'E' && e != 'I' && e != 'O' && e != 'U' && e != 'a' && e != 'e' && e != 'i' && e != 'o' && e != 'u') {
                c4 = e;
                break;
            }
        }
        for (int i = 1; i < aMaterno.length(); i++) {
            char c = aMaterno.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                c5 = c;
                break;
            }
        }
        for (int i = 1; i < nombre.length(); i++) {
            char d = nombre.charAt(i);
            if (d != 'A' && d != 'E' && d != 'I' && d != 'O' && d != 'U' && d != 'a' && d != 'e' && d != 'i' && d != 'o' && d != 'u') {
                c6 = d;
                break;
            }
        }
        suma = new StringBuilder().append(c4).append(c5).append(c6).toString();
        return suma;
    }
    public static String calcularCurp(String nombre, String aPaterno, String aMaterno, String año, String mes, String dia, String sexo, String estadoN) {
        String acum2 = "";
        String curp;
        for (int i = 0; i < 2; i++) {
            char v = (char) (Math.random() * 26 + 'a');
            acum2 = acum2 + v;
        }
        curp = aPaterno.substring(0, 2);
        curp = curp.concat(aMaterno.substring(0, 1));
        curp = curp.concat(nombre.substring(0, 1));
        curp = curp.concat(año.substring(2, 4));
        curp = curp.concat(mes);
        curp = curp.concat(dia);
        curp = curp.concat(sexo);
        curp = curp.concat(estadoN);
        curp = curp.concat(consInterna(aPaterno, aMaterno, nombre));
        curp = curp.concat(acum2);

        return curp.toUpperCase();
    }
    public static String calcularRfc(String nombre, String aPaterno, String aMaterno, String año, String mes, String dia) {
        String acum = "";
        String rfc;
        rfc = aPaterno.substring(0, 2);
        rfc = rfc.concat(aMaterno.substring(0, 1));
        rfc = rfc.concat(nombre.substring(0, 1));
        rfc = rfc.concat(año.substring(2, 4));
        rfc = rfc.concat(mes);
        rfc = rfc.concat(dia);
        for (int i = 0; i < 3; i++) {
            char c = (char) (Math.random() * 26 + 'a');
            acum = acum + c;
        }
        rfc = rfc.concat(acum);
        return rfc.toUpperCase();
    }
}