package rest.train;
import java.sql.*;



public class MySQL {
    
    // sql connection object
    private Connection m_con = null;
    // table object, used for callback
    private Table m_table;
    // database logs, allowPublicKeyRetrieval ??
    private String url =  "jdbc:mysql://localhost/Resatrain?allowPublicKeyRetrieval=true&useSSL=false";
    private String name = "root";
    private String password = "root";

    // *****

    // Connect and instanciate a new table object, for callback
    MySQL() {
        this.connect();
        this.m_table = new Table();
    }

    // Connect to the database, handle sql exceptions
    protected int connect() {
        try {
            m_con = DriverManager.getConnection(url, name, password);

        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }

        return 0;
    }

    // Close the connection
    public int close() {
        try {
            m_con.close();
        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
        return 0;
    }

    // Add a new reservation to the database
    public void reserve(String destination, boolean volDirect, int nbPassagers) {
        String sql;
        
        if(volDirect)
            sql = "INSERT INTO RESERVATION (v_destination_Reservation, v_nbPassagers_Reservation) VALUES('" + 
                destination +
                "', '" +
                nbPassagers + 
                "');";
        else {
            sql = "INSERT INTO RESERVATION (v_destination_Reservation, v_etapes_Reservation , v_nbPassagers_Reservation) VALUES('" + 
                destination +
                "', '" +
                "Marseille;Lyon" +
                "', '" +
                nbPassagers + 
                "');";
        }
        try {
            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            st.executeUpdate(sql);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    // Get a reservation with it ID
    public void retrieveReservation(int id) {
        String sql = "SELECT * FROM Reservation WHERE ";

        try {
            sql += "pk_id_Reservation = '";
            sql += id;
            sql += "';";
            
        
            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            ResultSet result = st.executeQuery(sql);
            
            this.m_table.callback(result);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    // Update a reservation's number of travelers with it ID
    public void updateNbPassagers(int newNbPassagers, int idReservation) {

        String sql = "UPDATE Reservation SET v_nbPassagers_Reservation='";
        sql += newNbPassagers;
        sql += "' WHERE pk_id_Reservation='";
        sql += idReservation;
        sql += "';";
        
        try {
            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            st.executeUpdate(sql);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }

    }

    public void deleteEntry(int id) {
        String sql = "DELETE FROM Reservation WHERE pk_id_Reservation='";
        sql += id;
        sql += "';";
        
        try {
            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            st.executeUpdate(sql);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }

    }
    public Table getTable() {return this.m_table;}
}