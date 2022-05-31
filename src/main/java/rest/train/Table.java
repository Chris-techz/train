package rest.train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table {
    private int m_id;
    private String m_destination;
    private String m_etapes;
    private int m_nbPassagers;

    public void setTable(ResultSet result) {
        try {
            while(result.next()) {
                this.m_id = result.getInt(1);
                this.m_destination = result.getString(2);
                this.m_etapes = result.getString(3);
                this.m_nbPassagers = result.getInt(4);
            }
        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public int getID() {return this.m_id;}
    public String getDestination() {return this.m_destination;}
    public String getEtapes() {return this.m_etapes;}
    public int getNbPassagers() {return this.m_nbPassagers;}
}
