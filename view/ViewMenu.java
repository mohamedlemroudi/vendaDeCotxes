package view;
import java.util.Scanner;

public class ViewMenu {
    private Scanner teclat = new Scanner(System.in);
    private ViewComprador comprador = new ViewComprador();
    protected IComprador escolataComprador;
    private boolean surtirMenuInicial = false;
    protected boolean menuComprador = false;

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
            this.comprador.iniciMenuEines();
        }
    }

    // Opcions del menú d'inici
    private void opcioMenuInici(int opcio) {
        switch (opcio) {
            case 1:
                // Opció de login
                if (this.escolataComprador != null) {
                    String[] credencials = comprador.loginComprador();
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
                String[] dadesComprador = comprador.registrarComprador();
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
}
