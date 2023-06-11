package Model;

import Controller.DashboardAdminController;
import MainProgram.DBconn;
import View.DashboardAdminView;
import View.LoginView;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Admin extends Akun{
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    String sql;
    public Admin(){}
    public Admin(String username, String password){
        super(username, password);
    }
    
    
    
    @Override
    public void login(Frame parent) {
        LoginView view = (LoginView) parent;
        view.dispose();
        DashboardAdminView dashboard = new DashboardAdminView();
        dashboard.setVisible(true);
        DashboardAdminController controller = new DashboardAdminController(dashboard, this);
    }
    
    public void buatTurnamen(Turnamen turnamen){
        if(turnamen.getNamaTurnamen().equals("") || 
                turnamen.getTempat().equals("") || 
                turnamen.getDeskripsi().equals("")){
            JOptionPane.showMessageDialog(null, "Silakan lengkapi data terlebih dahulu");
        }
        else{
            sql = "insert into turnamen (nama_turnamen, tempat, tanggal, deskripsi, jenis_turnamen) "
                    + "values ('"+turnamen.getNamaTurnamen()+"',"
                    + "'"+turnamen.getTempat()+"',"
                    + "'"+turnamen.getTanggal()+"',"
                    + "'"+turnamen.getDeskripsi()+"',"
                    + "'"+turnamen.getJenisTurnamen()+"')";
            try{
                stt.execute(sql);
                JOptionPane.showMessageDialog(null, "Turnamen berhasil dibuat");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }
    
    public void ubahTurnamen(Turnamen turnamen){
        try{
            sql = "update turnamen set nama_turnamen = '"+turnamen.getNamaTurnamen()+"', tempat = '"+turnamen.getTempat()+"',"
                    + "tanggal= '"+turnamen.getTanggal()+"', jenis_turnamen = '"+turnamen.getJenisTurnamen()+"',"
                    + "deskripsi= '"+turnamen.getDeskripsi()+"'"
                    + "where id = "+turnamen.getIdTurnamen()+" ";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Turnamen berhasil diubah");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void buatBerita(Berita berita, String lampiran){
        if(berita.getJudul().equals("") || 
                berita.getPenulis().equals("") || 
                berita.getIsiBerita().equals("") || 
                lampiran.equals("")){
            JOptionPane.showMessageDialog(null, "Silakan lengkapi data terlebih dahulu");
        }
        else{
            sql = "insert into berita (judul, penulis, kategori, isi, lampiran) values "
                    + "('"+berita.getJudul()+"', '"+berita.getPenulis()+"',"
                    + "'"+berita.getKategori()+"', '"+berita.getIsiBerita()+"'"
                    + ",'"+lampiran+"')";
            try{
                stt.execute(sql);
                JOptionPane.showMessageDialog(null, "Berita berhasil ditambahkan");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }
    
    public void ubahBerita(Berita berita, String lampiran){
        try{
            sql = "update berita set judul = '"+berita.getJudul()+"', penulis = '"+berita.getPenulis()+"',"
                    + "kategori = '"+berita.getKategori()+"', isi = '"+berita.getIsiBerita()+"',"
                    + "lampiran = '"+lampiran+"'"
                    + "where id = "+berita.getIdNews()+" ";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berita berhasil diubah");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
