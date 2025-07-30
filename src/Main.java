import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Votante> votantes = GeneradorVotantes.generarVotantes(1000);
        System.out.println("===================================================");
        System.out.println("      Sistema de Estadísticas de Votación");
        System.out.println("===================================================\n");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione el tipo de reporte a generar:");
            System.out.println("---------------------------------------------------");
            System.out.println("1) Reporte por discriminante (filtro específico)");
            System.out.println("2) Reporte por factor completo");
            System.out.println("3) Salir");
            System.out.println("---------------------------------------------------");
            System.out.print("Ingrese opción (1-3): ");

            String opcionInput = sc.nextLine().trim();

            if (!opcionInput.matches("[1-3]")) {
                System.out.println("\n[!] Opción inválida, por favor ingrese 1, 2 o 3.");
                continue;
            }

            int opcion = Integer.parseInt(opcionInput);

            if (opcion == 3) {
                System.out.println("\nGracias por usar el sistema. ¡Hasta luego!");
                break;
            }

            System.out.println("\nCampos válidos para filtrar o agrupar:");
            System.out.println(" - genero");
            System.out.println(" - estado civil");
            System.out.println(" - provincia");
            System.out.println(" - nivel academico");
            System.out.print("Ingrese el campo deseado: ");
            String campo = sc.nextLine().trim().toLowerCase();

            if (!(campo.equals("genero") || campo.equals("estado civil") || campo.equals("provincia") || campo.equals("nivel academico"))) {
                System.out.println("\n[!] Campo inválido, intente nuevamente.");
                continue;
            }

            if (opcion == 1) {
                System.out.print("\nIngrese el valor específico para '" + campo + "': ");
                String valor = sc.nextLine().trim();

                System.out.println("\n===================================================");
                EstadisticasVotacion.reportePorDiscriminante(votantes, campo, valor);
                System.out.println("===================================================\n");

            } else if (opcion == 2) {
                System.out.println("\n===================================================");
                EstadisticasVotacion.reportePorFactor(votantes, campo);
                System.out.println("===================================================\n");
            }
        }

        sc.close();
    }
}
