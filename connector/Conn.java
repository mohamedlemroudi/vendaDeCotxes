package connector;

import java.sql.*;

public class Conn {
    // Configuració de la conexió de la base de dades
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("USERNAME");
    private static final String PASSWORD = System.getenv("PASSWORD");
    Connection connection = null;
    Statement statement = null;
    ResultSet resultat = null;

    // Crear conexió base de dades
    public void crearConexio() {
        try {
            connection = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Menjase del error: " + e.getMessage());
        }
    }

    // Per tancar la conexió de la base de dades
    public void tencarConexio() {
        // Cerrar la conexión, el statement y el resultSet
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultat != null) {
                resultat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Llegir dades de les taules de les base de dades (SELECT)
    public ResultSet llegirDades(String query) {
        try {
            // Creiem una declaració per executar consultes SQL
            statement = connection.createStatement();

            // Executar la consulta que tenim per parametre
            resultat = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultat;
    }

    // Execució d'una consulta sobre la taula
    public void executaDades(String query) {
        try {
            // Creiem una declaració per executar consultes SQL
            statement = connection.createStatement();

            // Executar la consulta que tenim per parametre
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tancar la conexió, el statement i el resultSet
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
