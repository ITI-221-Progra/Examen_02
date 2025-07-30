import java.util.List;

class CreadorVotantes {
    public static void main(String[] args) {
        List<Votante> votantes = GeneradorVotantes.generarVotantes(1000);
        System.out.println("Se generaron " + votantes.size() + " votantes aleatorios.");

        // Mostrar los primeros 5 como ejemplo
        for (int i = 0; i < 5; i++) {
            Votante v = votantes.get(i);
            System.out.printf("Edad: %d | Género: %s | Estado Civil: %s | Provincia: %s | Nivel Académico: %s | Ingreso: ¢%,d | Agrupación: %s\n",
                    v.edad, v.genero, v.estadoCivil, v.provincia, v.nivelAcademico, v.ingresoMensual, v.agrupacionPolitica);
        }
    }
}