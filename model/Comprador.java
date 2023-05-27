package model;

public class Comprador {
    private final String ID;
    private String nom;
    private String contrasenya;
    private int edat;
    private String direccio;
    private String telefon;
    private String correuElectronic;

    public Comprador(String ID ,String nom, String contrasenya, int edat, String direccio, String telefon, String correuElectronic) {
        this.ID = ID;
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.edat = edat;
        this.direccio = direccio;
        this.telefon = telefon;
        this.correuElectronic = correuElectronic;
    }

    public String getIdComprador() {
        return this.ID;
    }
}
