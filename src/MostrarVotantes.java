import java.util.List;

class MostrarVotantes {
    public static void main(String[] args) {
        List<Votante> votantes = GeneradorVotantes.generarVotantes(1000);
        System.out.println("Listado completo de los 1000 votantes generados:\n");

        int i = 1;
        for (Votante v : votantes) {
            System.out.printf("[%04d] Edad: %d | Género: %s | Estado Civil: %s | Provincia: %s | Nivel Académico: %s | Ingreso: ¢%,d | Agrupación: %s\n",
                    i++, v.edad, v.genero, v.estadoCivil, v.provincia, v.nivelAcademico, v.ingresoMensual, v.agrupacionPolitica);
        }
    }
}
