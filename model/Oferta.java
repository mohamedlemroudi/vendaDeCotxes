package model;

public class Oferta extends Cotxe {
    private int idOferta;
    private String dateOferta;
    private int idCotxe;
    private double preu;

    public Oferta(int idOferta, String model, int anyFabricant, int numeroPortes, String color,
                  String tipoCombustible, double kilometratje, String estatCotxe, String dateOferta, int idCotxe, double preu) {

        super(model, anyFabricant, numeroPortes, color, tipoCombustible, kilometratje, estatCotxe);

        this.idOferta = idOferta;
        this.dateOferta = dateOferta;
        this.idCotxe = idCotxe;
        this.preu = preu;
    }

    public int getIdOferta() {
        return this.idOferta;
    }

    public String getDataOferta() {
        return this.dateOferta;
    }

    public int getIdCotxe() {
        return this.idCotxe;
    }

    public double getPreu() {
        return this.preu;
    }
}
