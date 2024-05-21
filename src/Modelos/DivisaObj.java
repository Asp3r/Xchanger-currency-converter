package Modelos;

public class DivisaObj {

    private double ars;
    private double bob;
    private double brl;
    private double clp;
    private double cop;
    private double usd;

    //GETTERS --------------------------------------------------------------------

    public double getArs() {
        return ars;
    }

    public double getBob() {
        return bob;
    }

    public double getBrl() {
        return brl;
    }

    public double getClp() {
        return clp;
    }

    public double getCop() {
        return cop;
    }

    public double getUsd() {
        return usd;
    }

    //SETTERS --------------------------------------------------------------------

    public void setArs(double ars) {
        this.ars = ars;
    }

    public void setBob(double bob) {
        this.bob = bob;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public void setClp(double clp) {
        this.clp = clp;
    }

    public void setCop(double cop) {
        this.cop = cop;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    //CONSTRUCTOR --------------------------------------------------------------------

    public DivisaObj(double ars, double bob, double brl, double clp,
                     double cop, double usd) {
        this.ars = ars;
        this.bob = bob;
        this.brl = brl;
        this.clp = clp;
        this.cop = cop;
        this.usd = usd;
    }

    //FUNCIONES --------------------------------------------------------------------

    public double convertirUnaMonedaHaciaOtra (String divisaInicial,
                                               double valorDivisaInicial,
                                               String divisaFinal){

        //esta variable guarda la equivalencia de a que valor de la divisa final equivale
        //UNA unidad de la divisa inicial.
        double valorNeutroDivisaFinal;

        /*
        EN CONSTRUCCION:

        switch (divisaFinal){

            case "ARS":
                valorNeutroDivisaFinal = this.ars;
                break;

        }
        */
        double valorDivisaFinal = valorDivisaInicial*()

    }

    @Override
    public String toString() {
        return "DivisaObj{" +
                "ars='" + ars + '\'' +
                ", bob='" + bob + '\'' +
                ", brl='" + brl + '\'' +
                ", clp='" + clp + '\'' +
                ", cop='" + cop + '\'' +
                ", usd='" + usd + '\'' +
                '}';
    }

}
