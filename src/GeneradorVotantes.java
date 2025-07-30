import java.util.ArrayList;
import java.util.List;

public class GeneradorVotantes {
    public static List<Votante> generarVotantes(int cantidad) {
        List<Votante> votantes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            votantes.add(new Votante(
                    GeneradorDatos.generarEdad(),
                    GeneradorDatos.generarGenero(),
                    GeneradorDatos.generarEstadoCivil(),
                    GeneradorDatos.generarProvincia(),
                    GeneradorDatos.generarNivelAcademico(),
                    GeneradorDatos.generarIngresoMensual(),
                    GeneradorDatos.generarAgrupacionPolitica()
            ));
        }
        return votantes;
    }
}
