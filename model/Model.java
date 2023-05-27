package model;

import connector.Conn;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public Conn connDB = new Conn();

    // Login de l'usuari Comprador
    public Comprador loginComprador(String ID, String contrasenya) {
        connDB.crearConexio();
        String query = "SELECT * FROM comprador WHERE ID = '" + ID + "' and contrasenya = '" + contrasenya + "'";
        ResultSet resultat = null;
        Comprador comprador = null;
        try {
            resultat = connDB.llegirDades(query);
            List<Comprador> compradors =new ArrayList<>();
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                int edat = resultat.getInt("edat");
                String direccio = resultat.getString("direccio");
                String telefon = resultat.getString("telefon");
                String correuElectronic = resultat.getString("correuElectronic");
                Comprador c = new Comprador(ID, nom, contrasenya, edat, direccio, telefon, correuElectronic);
                compradors.add(c);
            }
            if (!compradors.isEmpty()) {
                comprador = compradors.get(0);
            }
        } catch(Exception e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            try {
                if(resultat != null) {
                    resultat.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            connDB.tencarConexio();
        }
        return comprador;
    }

    // Registrar nou usuari comprador
    public Comprador registrarComprador(String id, String nom, String contrasenya, int edat, String direccio, String telefon, String correuElectronic) {
        Comprador comprador = null;
        try {
            connDB.crearConexio();
            String query = "INSERT INTO comprador(ID, nom, contrasenya, edat, direccio, telefon, correuElectronic) " +
                    "VALUES (" +
                    "'" + id + "', " +
                    "'" + nom + "', " +
                    "'" + contrasenya + "', " +
                    edat + ", " +
                    "'" + direccio + "', " +
                    "'" + telefon + "', " +
                    "'" +correuElectronic +
                    "')";
            connDB.executaDades(query);
            connDB.tencarConexio();
            comprador = new Comprador(id, nom, contrasenya, edat, direccio, telefon, correuElectronic);
        } catch(Exception e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            return comprador;
        }
    }

    // Visualitzar les ofertes
    public List<Oferta> veureOfertes() {
        connDB.crearConexio();
        String query = "SELECT of.id, of.date_venta, c.model, c.anyFabricant, c.numeroPortes, c.color, c.tipoCombustible, " +
                "c.kilometratje, c.estatCotxe, c.id AS idCotxe, of.preu " +
                "FROM oferta of " +
                "INNER JOIN cotxe c ON of.id_cotxe = c.id;";
        ResultSet resultat = null;
        List<Oferta> ofertes = null;
        try {
            resultat = connDB.llegirDades(query);
            ofertes = new ArrayList<>();

            while (resultat.next()) {
                int idOferta = resultat.getInt("id");
                String model = resultat.getString("model");
                int anyFabricant = resultat.getInt("anyFabricant");
                int numeroPortes = resultat.getInt("numeroPortes");
                String color = resultat.getString("color");
                String tipoCombustible = resultat.getString("tipoCombustible");
                Double kilometratje = resultat.getDouble("kilometratje");
                String estatCotxe = resultat.getString("estatCotxe");
                String dataVenta = resultat.getString("date_venta");
                int idCotxe = resultat.getInt("idCotxe");
                double preu = resultat.getDouble("preu");
                Oferta of = new Oferta(idOferta, model, anyFabricant, numeroPortes,
                        color, tipoCombustible, kilometratje, estatCotxe, dataVenta, idCotxe, preu);
                ofertes.add(of);
            }
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            try {
                if (resultat != null) {
                    resultat.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            connDB.tencarConexio();
        }
        return ofertes;
    }

    // De les ofertes realitzar una compra
    public void realitzarCompra(Comprador comprador, int idOferta) {
        connDB.crearConexio();
        // Obtener la data actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data_compra = fechaActual.format(formato);
        String idComprador = comprador.getIdComprador();
        String query = "INSERT INTO compra (date_compra, id_cotxe, id_comprador, preu) " +
                "VALUES ( " +
                    "'"+ data_compra + "', " +
                    "(SELECT id_cotxe FROM oferta WHERE id = " + idOferta + " ), " +
                    "'" + idComprador + "', " +
                    "(SELECT preu FROM oferta WHERE id = " + idOferta + " )" +
                " );";
        this.connDB.executaDades(query);
        query = "DELETE FROM oferta " +
                "WHERE id = " + idOferta + ";";
        this.connDB.executaDades(query);
        this.connDB.tencarConexio();
    }

    // Veure les compres del comprador
    public List<Compra> veureLesMevesCompres() {
        connDB.crearConexio();
        String query = "SELECT com.id ,com.date_compra, c.model, c.anyFabricant, c.numeroPortes, c.color, c.tipoCombustible, " +
                "c.kilometratje, c.estatCotxe, com.preu " +
                "FROM compra com " +
                "INNER JOIN cotxe c ON com.id_cotxe = c.id;";
        ResultSet resultat = null;
        List<Compra> compres = null;
        try {
            resultat = connDB.llegirDades(query);
            compres = new ArrayList<>();

            while (resultat.next()) {
                int idCompra = resultat.getInt("id");
                String model = resultat.getString("model");
                int anyFabricant = resultat.getInt("anyFabricant");
                int numeroPortes = resultat.getInt("numeroPortes");
                String color = resultat.getString("color");
                String tipoCombustible = resultat.getString("tipoCombustible");
                Double kilometratje = resultat.getDouble("kilometratje");
                String estatCotxe = resultat.getString("estatCotxe");
                String dateCompra = resultat.getString("date_compra");
                double preu = resultat.getDouble("preu");
                Compra co = new Compra(idCompra, model, anyFabricant, numeroPortes,
                        color, tipoCombustible, kilometratje, estatCotxe, dateCompra, preu);
                compres.add(co);
            }
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión, el statement y el resultSet
                if (resultat != null) {
                    resultat.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            connDB.tencarConexio();
        }
        return compres;
    }
}
