package view;

import model.Compra;
import model.Oferta;

import java.util.List;

/**
 *  L'interface IComprador té declarat tots els mètodes del comprador,
 *  de forma que quan ho implementem en la classe Controlador estarem obligats
 *  a implementar els mètodes de comprador. D'aquesta forma en la vista
 *  declararem un objecta de tipus IComprador per poder accedir de
 *  forma indirecta el controlador.
 *  Aquest patró que utilitzem en aquesta estructura es diu Proxy.
 *  Enllaç: https://refactoring.guru/es/design-patterns/proxy/java/example
 **/

public interface IComprador {
    boolean loginComprador(String ID, String contrasenya);
    boolean registrarComprador(String ID, String nom, String contrasenya, int edat, String direccio, String telefon, String correuElectronic);
    List<Oferta> veureOfertes();
    void realitzarCompra(int idOferta);
    public List<Compra> veureLesMevesCompres();
}
