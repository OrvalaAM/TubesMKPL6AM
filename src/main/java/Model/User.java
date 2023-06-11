package Model;

import Controller.DashboardUserController;
import MainProgram.DBconn;
import View.DaftarBeritaView;
import View.DashboardUserView;
import View.LoginView;
import View.PopUpBerita;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class User extends Akun{
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    private String nama, asal, kontak, jenisKelamin, namaTeam;
    public User(){}
    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }


    public String getKontak() {
        return kontak;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNamaTeam() {
        return namaTeam;
    }    
    
    public User(String nama, String asal, String kontak, String jenisKelamin, String namaTeam, String username, String password) {
    super(username, password);
    this.nama = nama;
    this.asal = asal;
    this.kontak = kontak;
    this.jenisKelamin = jenisKelamin;
    this.namaTeam = namaTeam;
    }

    @Override
    public void login(Frame parent) {
        LoginView view = (LoginView) parent;
        view.dispose();
        DashboardUserView dashboard = new DashboardUserView();
        dashboard.setVisible(true);
        DashboardUserController controller = new DashboardUserController(dashboard, this);
    }
    public void lihatBerita(Frame parent, Berita berita){
        new PopUpBerita(parent, true, berita).setVisible(true);
    }
    public void buatTim(Tim tim){
        try{
            sql = "insert into tim values ('"+tim.getNamaTim()+"',"
                    + "'"+tim.getProfilTim()+"',"
                    + ""+tim.getKapasitas()+")";
            stt.execute(sql);
            JOptionPane.showMessageDialog(null, "Menambahkan tim");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void gabungTim(Tim tim){
        try{
            sql = "update user set nama_tim = '"+tim.getNamaTim()+"' where username = '"+getUsername()+"'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Anda bergabung dengan tim " + tim.getNamaTim());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        namaTeam = tim.getNamaTim();
    }
    public void ikutTurnamen(Turnamen turnamen, String jenis){
        try{
            if(namaTeam.equals("") || turnamen.getJenisTurnamen().equals("Solo")){
                sql = "insert into partisipasi (turnamen, peserta) values "
                        + "('"+turnamen.getNamaTurnamen()+"', '"+getUsername()+"')";
            }
            else{
                sql = "insert into partisipasi (turnamen, peserta) values "
                        + "('"+turnamen.getNamaTurnamen()+"', '"+namaTeam+"')";
            }
            stt.execute(sql);
            JOptionPane.showMessageDialog(null, "Berhasil join");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
