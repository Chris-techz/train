package rest.train;
import java.sql.*;



public class mysql{
    
    private Connection con = null;
    // TODO : add sprind entry points, add dependencies in pom.xml
    // Folow the spring's tutorial 

    private String url =  "jdbc:mysql://localhost/resatrain?useSSL=false";
    private String name = "root";
    private String password = "";

    private String test;

    mysql() {
        this.connect();
    }

    protected int connect() {
        try {
            con = DriverManager.getConnection(url, name, password);

        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }

        return 0;
    }

    public int close() {
        try {
            con.close();
        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
        return 0;
    }

    public int reserve(String destination, boolean volDirect, int nbPassagers) {
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
            Statement st = con.createStatement();

            // execute querry
            st.executeUpdate(sql);

        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }

        return 0;
    }

}

