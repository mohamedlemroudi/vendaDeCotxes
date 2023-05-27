package controller;

import model.Compra;
import model.Comprador;
import model.Model;
import model.Oferta;
import view.IComprador;
import view.ViewMenu;

import java.util.List;

public class Controller implements IComprador {
    private final Model model;
    private final ViewMenu vista;
    private Comprador comprador = null;

    public Controller(Model model, ViewMenu vista) {
        this.model = model;
        this.vista = vista;
        this.vista.setEscolataComprador(this);
    }

    // Iniciar el menú principal al arrencar el programa
    public void iniciar() {
        this.vista.menuInici();
    }

    // Login del comprador
    public boolean loginComprador(String ID, String contrasenya) {
        comprador = this.model.loginComprador(ID, contrasenya);
        if (comprador != null) {
            return true;
        } else {
            return false;
        }
    }

    // Registrar comprador
    public boolean registrarComprador(String ID, String nom, String contrasenya, int edat, String direccio, String telefon, String correuElectronic) {
        comprador = this.model.registrarComprador(ID, nom, contrasenya, edat, direccio, telefon, correuElectronic);
        if (comprador != null) {
            return true;
        } else {
            return false;
        }
    }

    // Veure ofertes
    public List<Oferta> veureOfertes() {
        List<Oferta> ofertes = this.model.veureOfertes();
        return ofertes;
    }

    // Realitzar compra
    public void realitzarCompra(int idOferta) {
        this.model.realitzarCompra(comprador, idOferta);
    }

    // Veure les compres del comprador actual
    public List<Compra> veureLesMevesCompres() {
        List<Compra> compres = this.model.veureLesMevesCompres();
        return compres;
    }
}
