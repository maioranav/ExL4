package exl4;

public class Dipendente {
    private int matricola;
    private static final double stipendioBase = 1000.00d;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    public Dipendente(int matr, Dipartimento dip){
        this.matricola = matr;
        this.dipartimento = dip;
        this.importoOrarioStraordinario = 30;
        this.livello = Livello.OPERAIO;
        this.stipendio = stipendioBase;
    }

    public Dipendente(int matr, Dipartimento dip, Livello liv){
        this(matr, dip);
        this.livello = liv;
        this.stipendio = Dipendente.genStipendio(liv);
    }

    public Dipendente(int matr, Dipartimento dip, Livello liv, double pagaora) {
        this(matr, dip, liv);
        this.importoOrarioStraordinario = pagaora;
    }

    private static double genStipendio(Livello liv) {
        return switch (liv) {
            case IMPIEGATO -> stipendioBase * 1.2;
            case QUADRO -> stipendioBase * 1.5;
            case DIRIGENTE -> stipendioBase * 2;
            default -> stipendioBase;
        };
    }
    public void setStraordinario(double pagaora) {
        this.importoOrarioStraordinario = pagaora;
    }

    public void setDipartimento(Dipartimento dip) {
        this.dipartimento = dip;
    }

    public void promuovi() {
        switch (this.livello) {
            case OPERAIO -> {
                this.livello = Livello.IMPIEGATO;
                this.stipendio = genStipendio(Livello.IMPIEGATO);
                System.out.println("Il dipendente " + this.matricola + " è diventanto " + this.livello);
            }
            case IMPIEGATO -> {
                this.livello = Livello.QUADRO;
                this.stipendio = genStipendio(Livello.QUADRO);
                System.out.println("Il dipendente " + this.matricola + " è diventanto " + this.livello);

            }
            case QUADRO -> {
                this.livello = Livello.DIRIGENTE;
                this.stipendio = genStipendio(Livello.DIRIGENTE);
                System.out.println("Il dipendente " + this.matricola + " è diventanto " + this.livello);

            }
            default -> System.out.println("Il dipendente " + this.matricola + " non è promuovibile. Stato attuale: " + this.livello);
        }
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "matricola=" + matricola +
                ", stipendio=" + stipendio +
                ", livello='" + livello + '\'' +
                ", dipartimento='" + dipartimento + '\'' +
                '}';
    }

    public void stampa() {
        System.out.println(toString());
    }

    public static double calcolaPaga(Dipendente dip) {
        return dip.stipendio;
    }

    public static double calcolaPaga(Dipendente dip, int ore) {
       double pagaStraord = ore * dip.importoOrarioStraordinario;
        return dip.stipendio + pagaStraord;
    }

}
