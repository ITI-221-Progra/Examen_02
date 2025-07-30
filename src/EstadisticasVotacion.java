import java.util.*;

public class EstadisticasVotacion {

    public static void reportePorDiscriminante(List<Votante> votantes, String campo, String valor) {
        Map<String, Integer> conteo = new LinkedHashMap<>();
        int total = 0;

        for (String agrup : GeneradorDatos.getAgrupaciones()) {
            conteo.put(agrup, 0);
        }

        for (Votante v : votantes) {
            if (getCampo(v, campo).equalsIgnoreCase(valor)) {
                conteo.put(v.agrupacionPolitica, conteo.get(v.agrupacionPolitica) + 1);
                total++;
            }
        }

        System.out.println("\nDistribución de votantes por " + campo + " = " + valor);
        System.out.printf("%-20s %-10s %-10s\n", "Agrupación Política", "Absoluto", "Porcentaje");

        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            double porcentaje = total > 0 ? (entry.getValue() * 100.0 / total) : 0;
            System.out.printf("%-20s %-10d %-9.2f%%\n", entry.getKey(), entry.getValue(), porcentaje);
        }
        System.out.printf("%-20s %-10d %-9.2f%%\n", "Totales", total, 100.0);
    }


    public static void reportePorFactor(List<Votante> votantes, String campo) {
        // Mapeo: agrupacion -> (valorCampo -> conteo)
        Map<String, Map<String, Integer>> matriz = new LinkedHashMap<>();
        Set<String> valoresFactor = new TreeSet<>();
        Map<String, Integer> totalesAgrupacion = new HashMap<>();

        for (String agrup : GeneradorDatos.getAgrupaciones()) {
            matriz.put(agrup, new HashMap<>());
            totalesAgrupacion.put(agrup, 0);
        }

        for (Votante v : votantes) {
            String agrup = v.agrupacionPolitica;
            String val = getCampo(v, campo);

            valoresFactor.add(val);

            Map<String, Integer> fila = matriz.get(agrup);
            fila.put(val, fila.getOrDefault(val, 0) + 1);
            totalesAgrupacion.put(agrup, totalesAgrupacion.get(agrup) + 1);
        }

        int totalGeneral = votantes.size();

        // Imprimir encabezados
        System.out.println("\nDistribución por Agrupación Política y por " + campo);
        System.out.printf("%-20s", "Agrupación");

        for (String val : valoresFactor) {
            System.out.printf("%-15s%-15s", val + " (Abs)", val + " (%)");
        }
        System.out.printf("%-15s%-10s\n", "Total", "%");

        // Imprimir filas
        for (String agrup : GeneradorDatos.getAgrupaciones()) {
            System.out.printf("%-20s", agrup);
            Map<String, Integer> fila = matriz.get(agrup);
            int totalAgrup = totalesAgrupacion.get(agrup);

            for (String val : valoresFactor) {
                int c = fila.getOrDefault(val, 0);
                double pct = totalAgrup > 0 ? (c * 100.0 / totalAgrup) : 0;
                System.out.printf("%-15d%-15.2f", c, pct);
            }

            double pctGlobal = totalGeneral > 0 ? (totalAgrup * 100.0 / totalGeneral) : 0;
            System.out.printf("%-15d%-10.2f\n", totalAgrup, pctGlobal);
        }
    }

    private static String getCampo(Votante v, String campo) {
        return switch (campo.toLowerCase()) {
            case "genero" -> v.genero;
            case "estado civil" -> v.estadoCivil;
            case "provincia" -> v.provincia;
            case "nivel academico" -> v.nivelAcademico;
            default -> "";
        };
    }
}
