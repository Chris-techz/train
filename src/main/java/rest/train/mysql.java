package rest.train;
import java.sql.*;



public class MySQL{
    
    private Connection m_con = null;
    private Table m_table;
    // TODO : add sprind entry points, add dependencies in pom.xml
    // Folow the spring's tutorial 

    private String url =  "jdbc:mysql://localhost/Resatrain?useSSL=false";
    private String name = "root";
    private String password = "root";

    private String test;

    MySQL() {
        this.connect();
        this.m_table = new Table();
    }

    protected int connect() {
        try {
            m_con = DriverManager.getConnection(url, name, password);

        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }

        return 0;
    }

    public int close() {
        try {
            m_con.close();
        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
        return 0;
    }

    public void reserve(String destination, boolean volDirect, int nbPassagers) {
        String sql;
        
        if(volDirect)
            sql = "INSERT INTO RESERVATION (destination, nb_passagers) VALUES('" + 
                destination +
                "', '" +
                nbPassagers + 
                "');";
        else {
            sql = "INSERT INTO RESERVATION (destination, etapes , nb_passagers) VALUES('" + 
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

    public void getReservation(int id) {
        String sql = "SELECT * FROM Reservation WHERE ";

        try {
            sql += "pk_id_Reservation = '";
            sql += id;
            sql += "';";
            
        
            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            ResultSet result = st.executeQuery(sql);
            
            this.m_table.setTable(result);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
    }

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

}