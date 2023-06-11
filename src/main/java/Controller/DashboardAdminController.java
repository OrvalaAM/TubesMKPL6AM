package Controller;

import Model.Admin;
import View.BuatBeritaView;
import View.BuatTurnamenView;
import View.DashboardAdminView;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardAdminController {
    DashboardAdminView dashboard;
    Admin admin;
    class btnTurnamen implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            BuatTurnamenView buatTurnamen = new BuatTurnamenView();
            buatTurnamen.setVisible(true);
            dashboard.dispose();
            BuatTurnamenController controller = new BuatTurnamenController(buatTurnamen, admin);
        }
        
    }
    class btnBerita implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            BuatBeritaView buatBerita = new BuatBeritaView();
            buatBerita.setVisible(true);
            dashboard.dispose();
            BuatBeritaController controller = new BuatBeritaController(buatBerita, admin);
       }
        
    }
    class btnLogout implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dashboard.dispose();
            LoginView menuLogin = new LoginView();
            LoginController controlLogin = new LoginController(menuLogin);
            menuLogin.setVisible(true);
        }
        
    }
    public DashboardAdminController(DashboardAdminView view, Admin admin){
        dashboard = view;
        this.admin = admin;
        dashboard.setLabelHeader("Welcome, " + admin.getUsername());
        dashboard.klikBtnTurnamen(new btnTurnamen());
        dashboard.klikBtnBerita(new btnBerita());
        dashboard.klikBtnLogout(new btnLogout());
    }
}
