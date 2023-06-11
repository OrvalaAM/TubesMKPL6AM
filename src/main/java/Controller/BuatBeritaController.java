package Controller;

import MainProgram.DBconn;
import Model.Admin;
import Model.Berita;
import Model.HasilPertandingan;
import Model.ProfilPemain;
import View.BuatBeritaView;
import View.DashboardAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BuatBeritaController {
    BuatBeritaView menu;
    Admin admin;
    ProfilPemain profil = new ProfilPemain();
    HasilPertandingan hasil = new HasilPertandingan();
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    Berita beritaEdit;
    class btnKirim implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String judul = menu.getJudul();
            String penulis = menu.getPenulis();
            String isiBerita = menu.getIsi();
            String lampiran = menu.getDetail();
            String kategori = menu.getKategori();
            Berita beritaTambah = new Berita(judul, penulis, isiBerita, kategori);
            admin.buatBerita(beritaTambah, lampiran);
            menu.reset();
            menu.tampilListBerita();
        }
        
    }
    class btnUbah implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String judul = menu.getJudul();
            String penulis = menu.getPenulis();
            String isiBerita = menu.getIsi();
            String lampiran = menu.getDetail();
            String kategori = menu.getKategori();
            Berita berita = new Berita(beritaEdit.getIdNews(), judul, penulis, isiBerita, kategori);
            admin.ubahBerita(berita, lampiran);
            menu.reset();
            menu.tampilListBerita();
        }
        
    }
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menu.dispose();
            DashboardAdminView dashboard = new DashboardAdminView();
            DashboardAdminController controller = new DashboardAdminController(dashboard, admin);
            dashboard.setVisible(true);
        }
        
    }
    class cbxKategori implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int index = menu.getIndexDetail();
            if(index == 0){
                menu.comboboxProfil("Detail", profil);
            }
            else if(index == 1){
                menu.comboboxHasil("Detail", hasil);
            }
            else if(index == 2){
                menu.comboboxEvent("Kesan");
            }
       }
    }
    class jListBerita implements MouseListener{
        ArrayList<Berita> listBerita = menu.getListBerita();
        @Override
        public void mouseClicked(MouseEvent me) {
            menu.setLabelPanel("Ubah berita");
            String judulBerita = menu.getSelectedBerita();
            Berita berita = null;
            while(berita == null){
                for(Berita e:listBerita){
                    if(e.getJudul().equals(judulBerita)){
                        berita = e;
                        break;
                    }
                }
            }
            beritaEdit = berita;
            menu.setHasilListBerita(berita);
        }

        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent me) {}

        @Override
        public void mouseExited(MouseEvent me) {}
    }
    public BuatBeritaController(BuatBeritaView view, Admin admin){
        menu = view;
        this.admin = admin;
        menu.klikBtnKirim(new btnKirim());
        menu.klikBtnKembali(new btnKembali());
        menu.klikComboboxKategori(new cbxKategori());
        menu.klikJListBerita(new jListBerita());
        menu.klikBtnUbah(new btnUbah());
    }
}
