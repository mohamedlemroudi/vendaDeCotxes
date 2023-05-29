package view;
import model.Compra;
import model.Oferta;

import java.util.List;
import java.util.Scanner;

public class ViewMenu {
    private Scanner teclat = new Scanner(System.in);
    protected IComprador escolataComprador;
    private boolean surtirMenuInicial = false;
    protected boolean menuComprador = false;
    private ViewComprador viewComprador = new ViewComprador();

    // De forma indirecta ens connectem amb el controlador
    public void setEscolataComprador(IComprador escolataComprador) {
        this.escolataComprador = escolataComprador;
    }

    // Vista del menu d'inici
    public void menuInici() {
        while (!surtirMenuInicial) {
            String menu = "1. Login Comprador \n" +
                    "2. Registrar Comprador\n" +
                    "3. Surtir";
            System.out.println(menu);
            System.out.print("Opció: ");
            int opcio = teclat.nextInt();
            this.opcioMenuInici(opcio);
        }

        if (menuComprador) {
            this.iniciMenuEines();
        }
    }

    // Opcions del menú d'inici
    private void opcioMenuInici(int opcio) {
        switch (opcio) {
            case 1:
                // Opció de login
                if (this.escolataComprador != null) {
                    String[] credencials = this.viewComprador.loginComprador();
                    boolean login = this.escolataComprador.loginComprador(credencials[0], credencials[1]);
                    if (login) {
                        System.out.println("Sessió iniciada!");
                        surtirMenuInicial = true;
                        menuComprador = true;
                    }
                    else {
                        System.out.println("Error de login!");
                    }
                }
                break;
            case 2:
                // Opció de registrar
                String[] dadesComprador = this.viewComprador.registrarComprador();
                boolean registrar =  this.escolataComprador.registrarComprador(dadesComprador[0], dadesComprador[1],
                        dadesComprador[2], Integer.parseInt(dadesComprador[3]), dadesComprador[4], dadesComprador[5],
                        dadesComprador[6]);
                if (registrar) {
                    System.out.println("Us heu registrat correctament!");
                    surtirMenuInicial = true;
                    menuComprador = true;
                } else {
                    System.out.println("Error en intentar registrar-te!");
                }
                break;
            case 3:
                // Opció de surtir
                surtirMenuInicial = true;
                break;
            default:
                System.out.println("NO existeix l'opció");
        }
    }

    // Vista del menú de les funcionalitats que disposa el comprador
    public void iniciMenuEines() {
        while (this.menuComprador) {
            String menu = "1. Veura Ofertes\n" +
                    "2. Realitzar Compra\n" +
                    "3. Les Meves Compres\n" +
                    "4. Surtir";
            System.out.println(menu);
            System.out.print("Opció: ");
            int opcio = teclat.nextInt();
            this.opcioMenuEines(opcio);
        }
    }

    // Opcions del menú d'eines del comprador
    private void opcioMenuEines(int opcio) {
        switch (opcio) {
            case 1:
                this.viewComprador.visualitzarOfertes(this.escolataComprador.veureOfertes());
                break;
            case 2:
                int idOferta = this.viewComprador.realitzarCompra();
                this.escolataComprador.realitzarCompra(idOferta);
                System.out.println("Compra realitzada!");
                break;
            case 3:
                this.viewComprador.visualitzarCompres(this.escolataComprador.veureLesMevesCompres());
                break;
            case 4:
                this.menuComprador = false;
                break;
            default:
                System.out.println("NO existeix l'opció");
        }
    }


}
