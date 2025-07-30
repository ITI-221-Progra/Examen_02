import java.util.Random;

public class GeneradorDatos {
    private static final Random random = new Random();

    private static final String[] generos = {"masculino", "femenino", "otro"};
    private static final String[] estadosCiviles = {"soltero", "casado", "divorciado", "viudo", "unión libre"};
    private static final String[] provincias = {"San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón"};
    private static final String[] nivelesAcademicos = {
            "Primaria incompleta", "Primaria completa",
            "Secundaria incompleta", "Secundaria completa",
            "Universidad incompleta", "Universidad completa"
    };
    private static final String[] agrupaciones = {
            "Agrupación 1", "Agrupación 2", "Agrupación 3",
            "Agrupación 4", "Agrupación 5", "Agrupación 6"
    };

    public static int generarEdad() {
        return random.nextInt(103) + 18; // 18 a 120
    }
    public static String generarGenero() {
        return generos[random.nextInt(generos.length)];
    }
    public static String generarEstadoCivil() {
        return estadosCiviles[random.nextInt(estadosCiviles.length)];
    }
    public static String generarProvincia() {
        return provincias[random.nextInt(provincias.length)];
    }
    public static String generarNivelAcademico() {
        return nivelesAcademicos[random.nextInt(nivelesAcademicos.length)];
    }
    public static int generarIngresoMensual() {
        return random.nextInt(3_500_001);
    }
    public static String generarAgrupacionPolitica() {
        return agrupaciones[random.nextInt(agrupaciones.length)];
    }

    public static String[] getAgrupaciones() { return agrupaciones; }
    public static String[] getGeneros() { return generos; }
    public static String[] getEstadosCiviles() { return estadosCiviles; }
    public static String[] getProvincias() { return provincias; }
    public static String[] getNivelesAcademicos() { return nivelesAcademicos; }
}
