package Controller;

import MainProgram.DBconn;
import Model.Tim;
import Model.User;
import View.BuatTimView;
import View.DashboardUserView;
import View.MenuTimView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuTimController {
    MenuTimView menuTim;
    User user;
    Tim timGabung;
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    class btnBuat implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            BuatTimView view = new BuatTimView();
            view.setVisible(true);
            BuatTimController controller = new BuatTimController(view, user, menuTim);
        }
        
    }
    class btnGabung implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            user.gabungTim(timGabung);
            menuTim.dispose();
            DashboardUserView dashboard = new DashboardUserView();
            dashboard.setVisible(true);
            DashboardUserController controller = new DashboardUserController(dashboard, user);
        }
        
    }
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuTim.dispose();
            DashboardUserView dashboard = new DashboardUserView();
            dashboard.setVisible(true);
            DashboardUserController controller = new DashboardUserController(dashboard, user);
        }
        
    }
    class tabelTim implements MouseListener{
        ArrayList<Tim> listTim = menuTim.getListTim();
        public void mouseClicked(MouseEvent me) {
            String namaTim = menuTim.getSelectedTim();
            Tim tim = null;
            while(tim == null){
                for(Tim e:listTim){
                    if(e.getNamaTim().equals(namaTim)){
                        tim = e;
                        break;
                    }
                }
            }
            timGabung = tim;
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
    public MenuTimController(MenuTimView menu, User user){
        this.menuTim = menu;
        this.user = user;
        menuTim.klikBtnBuat(new btnBuat());
        menuTim.klikBtnGabung(new btnGabung());
        menuTim.klikTabelTim(new tabelTim());
        menuTim.klikBtnKembali(new btnKembali());
    }

    public MenuTimController() {}
    
    public int getJumlahAnggota(String tim){
        int jumlah = 0;
        try{
            sql = "select count(nama) jumlah from user where nama_tim = '"+tim+"'";
            rs = stt.executeQuery(sql);
            if(rs.next()){
                jumlah = rs.getInt("jumlah");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(menuTim, e.getMessage());
        }
        return jumlah;
    }
    public int getKapasitas(String tim){
        int jumlah = 0;
        try{
            sql = "select kapasitas_anggota from tim where nama_tim = '"+tim+"'";
            rs = stt.executeQuery(sql);
            if(rs.next()){
                jumlah = rs.getInt("jumlah");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(menuTim, e.getMessage());
        }
        return jumlah;
    }
    
}
