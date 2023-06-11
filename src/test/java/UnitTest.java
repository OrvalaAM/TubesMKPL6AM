package test;

import org.junit.Test;
import MainProgram.DBconn;
import Model.Turnamen;
import java.sql.*;
import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void testConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/6pm", "root", "");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(con, DBconn.getConnection());
    }
    @Test
    public void testNamaTurnamen(){
        Turnamen turnamenTest = new Turnamen("Nama", "peserta");
        assertEquals("Nama", turnamenTest.getNamaTurnamen());
    }
    @Test
    public void testPesertaTurnamen(){
        Turnamen turnamenTest = new Turnamen("Nama", "peserta");
        assertEquals("peserta", turnamenTest.getPeserta());
    }

    @Test
    public void testNamaTim(){
        Tim timTest = new Tim("Nama", "profil", 10);
        assertEquals("Nama", timTest.getNamaTim());
    }
    
}
