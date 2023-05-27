package model;

public class Compra extends Cotxe {
    private int idCompra;
    private String date_compra;
    private double preu;

    public Compra(int idCompra ,String model, int anyFabricant, int numeroPortes,
                  String color, String tipoCombustible, double kilometratje,
                  String estatCotxe, String date_compra, double preu) {

        super(model, anyFabricant, numeroPortes, color, tipoCombustible,
                kilometratje, estatCotxe);

        this.idCompra = idCompra;
        this.date_compra = date_compra;
        this.preu = preu;
    }

    public int getIdCompra() {
        return this.idCompra;
    }

    public String getDateCompra() {
        return this.date_compra;
    }

    public double getPreu() {
        return this.preu;
    }
}
