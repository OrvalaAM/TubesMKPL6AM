package Controller;

import MainProgram.DBconn;
import Model.Admin;
import Model.Turnamen;
import View.BuatTurnamenView;
import View.DashboardAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BuatTurnamenController {
    BuatTurnamenView menuTurnamen;
    Admin admin;
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    Turnamen turnamenEdit;
    class btnKirim implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String nama = menuTurnamen.getNamaTurnamen();
            String tempat = menuTurnamen.getTempat();
            String tanggal = menuTurnamen.getTanggal();
            String jenis = menuTurnamen.getJenis();
            String deskripsi = menuTurnamen.getDeskripsi();
            Turnamen turnamen = new Turnamen(nama, tempat, tanggal, deskripsi, jenis);
            admin.buatTurnamen(turnamen);
            menuTurnamen.reset();
            menuTurnamen.tampilListTurnamen();
        }
        
    }
    class btnUbah implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String nama = menuTurnamen.getNamaTurnamen();
            String tempat = menuTurnamen.getTempat();
            String tanggal = menuTurnamen.getTanggal();
            String jenis = menuTurnamen.getJenis();
            String deskripsi = menuTurnamen.getDeskripsi();
            Turnamen turnamen = new Turnamen(turnamenEdit.getIdTurnamen(), nama, tempat, tanggal, deskripsi, jenis);
            admin.ubahTurnamen(turnamen);
            menuTurnamen.reset();
            menuTurnamen.tampilListTurnamen();
        }
    }
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuTurnamen.dispose();
            DashboardAdminView dashboard = new DashboardAdminView();
            DashboardAdminController controller = new DashboardAdminController(dashboard, admin);
            dashboard.setVisible(true);
        }
        
    }
    class jListTurnamen implements MouseListener{
        ArrayList<Turnamen> listTurnamen = menuTurnamen.getListTurnamen();
        public void mouseClicked(MouseEvent me) {
            menuTurnamen.setLabelPanel("Ubah Turnamen");
            String namaTurnamen = menuTurnamen.getSelectedTurnamen();
            Turnamen turnamen = null;
            while(turnamen == null){
                for(Turnamen e:listTurnamen){
                    if(e.getNamaTurnamen().equals(namaTurnamen)){
                        turnamen = e;
                        break;
                    }
                }
            }
            turnamenEdit = turnamen;
            menuTurnamen.setHasilListTurnamen(turnamen);
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
    public BuatTurnamenController(BuatTurnamenView menu, Admin admin){
        menuTurnamen = menu;
        this.admin = admin;
        menuTurnamen.klikBtnKirim(new btnKirim());
        menuTurnamen.klikBtnUbah(new btnUbah());
        menuTurnamen.klikBtnKembali(new btnKembali());
        menuTurnamen.klikJListTurnamen(new jListTurnamen());
    }
}
