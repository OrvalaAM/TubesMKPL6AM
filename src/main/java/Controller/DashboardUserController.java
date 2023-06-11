package Controller;

import Model.User;
import View.DashboardUserView;
import View.DaftarBeritaView;
import View.JoinTurnamenView;
import View.LoginView;
import View.MenuTimView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardUserController {
    DashboardUserView dashboard;
    User user;
    class btnTim implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            MenuTimView menu = new MenuTimView();
            dashboard.dispose();
            menu.setVisible(true);
            MenuTimController controller = new MenuTimController(menu, user);
        }
        
    }
    class btnTurnamen implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dashboard.dispose();
            JoinTurnamenView menu = new JoinTurnamenView(user);
            menu.setVisible(true);
            JoinTurnamenController controller = new JoinTurnamenController(menu, user);
        }
        
    }
    class btnBerita implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dashboard.dispose();
            DaftarBeritaView beritaView = new DaftarBeritaView();
            beritaView.setVisible(true);
            DaftarBeritaController beritaControl = new DaftarBeritaController(beritaView, user);
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
    public DashboardUserController(DashboardUserView view, User user){
        dashboard = view;
        this.user = user;
        dashboard.setHeader("Welcome, " + user.getUsername());
        dashboard.klikBtnTim(new btnTim());
        dashboard.klikBtnTurnamen(new btnTurnamen());
        dashboard.klikBtnBerita(new btnBerita());
        dashboard.klikBtnLogout(new btnLogout());
    }
}
