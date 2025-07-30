public class Votante {
    public int edad;
    public String genero;
    public String estadoCivil;
    public String provincia;
    public String nivelAcademico;
    public int ingresoMensual;
    public String agrupacionPolitica;

    public Votante(int edad, String genero, String estadoCivil, String provincia,
                   String nivelAcademico, int ingresoMensual, String agrupacionPolitica) {
        this.edad = edad;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.provincia = provincia;
        this.nivelAcademico = nivelAcademico;
        this.ingresoMensual = ingresoMensual;
        this.agrupacionPolitica = agrupacionPolitica;
    }
}
