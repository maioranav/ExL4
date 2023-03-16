package exl4;

public class Dipendente {
    private int matricola;
    private static final double stipendioBase = 1000.00d;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private String dipartimento;

    public Dipendente(int matr, String dip){
        this.matricola = matr;
        this.dipartimento = dip;
        this.importoOrarioStraordinario = 30;
        this.livello = Livello.OPERAIO;
        this.stipendio = stipendioBase;
    }

    public Dipendente(int matr, String dip, Livello liv){
        this(matr, dip);
        this.livello = liv;
        this.stipendio = Dipendente.genStipendio(liv);
    }

    public Dipendente(int matr, String dip, Livello liv, double pagaora) {
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

    public void setDipartimento(String dip) {
        this.dipartimento = dip;
    }

    public void promuovi() {
        switch (this.livello) {
            case OPERAIO -> {
                this.livello = Livello.IMPIEGATO;
                this.stipendio = genStipendio(Livello.IMPIEGATO);
            }
            case IMPIEGATO -> {
                this.livello = Livello.QUADRO;
                this.stipendio = genStipendio(Livello.QUADRO);
            }
            case QUADRO -> {
                this.livello = Livello.DIRIGENTE;
                this.stipendio = genStipendio(Livello.DIRIGENTE);
            }
            default -> System.out.println("Il dipendente non è promuovibile. Stato attuale: " + this.livello);
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

    public double calcolaPaga() {
        return this.stipendio;
    }

    public double calcolaPaga(int ore) {
       double pagaStraord = ore * this.importoOrarioStraordinario;
        return this.stipendio + pagaStraord;
    }

}
