package model;

public class Cotxe {
    private  String model;
    private int anyFabricant;
    private int numeroPortes;
    private String color;
    private String tipoCombustible;
    private double kilometratje;
    private String estatCotxe;

    public Cotxe(String model, int anyFabricant, int numeroPortes, String color, String tipoCombustible,
                 double kilometratje, String estatCotxe) {
        this.model = model;
        this.anyFabricant = anyFabricant;
        this.numeroPortes = numeroPortes;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.kilometratje = kilometratje;
        this.estatCotxe = estatCotxe;
    }

    public String getModel() {
        return this.model;
    }

    public int getAnyFabricant() {
        return this.anyFabricant;
    }

    public int getNumeroPortes() {
        return this.numeroPortes;
    }

    public String getColor() {
        return this.color;
    }

    public String getTipoCombustible() {
        return this.tipoCombustible;
    }

    public double getKilometratje() {
        return this.kilometratje;
    }

    public String getEstatCotxe() {
        return this.estatCotxe;
    }
}
