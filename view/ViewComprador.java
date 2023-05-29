package view;

import model.Compra;
import model.Oferta;

import java.util.List;
import java.util.Scanner;

public class ViewComprador {

    private Scanner teclat = new Scanner(System.in);

    // Vista pel login
    public String[] loginComprador() {
        String[] credencials = new String[2];
        System.out.println("Introdueix el ID del comprador: ");
        String ID = teclat.nextLine();
        credencials[0] = ID;
        System.out.println("Introdueix la contrasenya del comprador: ");
        String contrasenya = teclat.nextLine();
        credencials[1] = contrasenya;
        return credencials;
    }

    // Vista pel registra
    public String[] registrarComprador() {
        String[] dadesComprador = new String[7];
        System.out.println("Introdueix un identificador únic: ");
        String id = teclat.nextLine();
        dadesComprador[0] = id;

        System.out.println("Nom del comprador: ");
        String nom = teclat.nextLine();
        dadesComprador[1] = nom;

        System.out.println("Contrasenya del comprador: ");
        String contrasenya = teclat.nextLine();
        dadesComprador[2] = contrasenya;

        System.out.println("Edat: ");
        int edat = Integer.parseInt(teclat.nextLine());
        dadesComprador[3] = String.valueOf(edat);

        System.out.println("Direcció: ");
        String direccio = teclat.nextLine();
        dadesComprador[4] = direccio;

        System.out.println("Telèfon: ");
        String telefon = teclat.nextLine();
        dadesComprador[5] = telefon;

        System.out.println("Correu electrònic: ");
        String correuElectronic = teclat.nextLine();
        dadesComprador[6] = correuElectronic;

        return dadesComprador;
    }

    // Vista per visualitzar ofertes
    void visualitzarOfertes(List<Oferta> ofertes) {
        System.out.println("---------- Ofertes ----------");
        for (Oferta oferta : ofertes) {
            System.out.println("ID Oferta: " + oferta.getIdOferta());
            System.out.println("Date Oferta: " + oferta.getDataOferta());
            System.out.println("ID Cotxe: " + oferta.getIdCotxe());
            System.out.println("Model del cotxe: "+ oferta.getModel());
            System.out.println("Any del fabricant: " + oferta.getAnyFabricant());
            System.out.println("Nombre de portes: " + oferta.getNumeroPortes());
            System.out.println("Color del cotxe: " + oferta.getColor());
            System.out.println("Tipus de combustible: " + oferta.getTipoCombustible());
            System.out.println("Kilometratje: " + oferta.getKilometratje());
            System.out.println("Estat del cotxe: " + oferta.getEstatCotxe());
            System.out.println("Preu del cotxe: " + oferta.getPreu());
            System.out.println("---------------------------");
        }
    }

    // Vista per realitzar compra
    int realitzarCompra() {
        System.out.println("Quina oferta vols compra? ");
        int idOferta = Integer.parseInt(teclat.nextLine());
        return idOferta;
    }

    // Vista per visualitzar les compres del comprador que ha iniciat sessió
    void visualitzarCompres(List<Compra> compres) {
        System.out.println("---------- Les Meves Compres ----------");
        for (Compra compra : compres) {
            System.out.println("ID Compra: " + compra.getIdCompra());
            System.out.println("Date de la compra: " + compra.getDateCompra());
            System.out.println("Model del cotxe: "+ compra.getModel());
            System.out.println("Any del fabricant: " + compra.getAnyFabricant());
            System.out.println("Nombre de portes: " + compra.getNumeroPortes());
            System.out.println("Color del cotxe: " + compra.getColor());
            System.out.println("Tipus de combustible: " + compra.getTipoCombustible());
            System.out.println("Kilometratje: " + compra.getKilometratje());
            System.out.println("Estat del cotxe: " + compra.getEstatCotxe());
            System.out.println("Preu del cotxe: " + compra.getPreu());
            System.out.println("---------------------------");
        }
    }

}
