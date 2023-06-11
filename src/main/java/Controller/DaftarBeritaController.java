package Controller;

import Model.Berita;
import Model.User;
import View.DaftarBeritaView;
import View.DashboardUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DaftarBeritaController {
    DaftarBeritaView menuBerita;
    User user;
    class tabelBerita implements MouseListener{
        ArrayList<Berita> listBerita = menuBerita.getListBerita();
        public void mouseClicked(MouseEvent me) {
            String judulBerita = menuBerita.getSelectedBerita();
            Berita berita = null;
            while(berita == null){
                for(Berita e:listBerita){
                    if(e.getJudul().equals(judulBerita)){
                        berita = e;
                        break;
                    }
                }
            }
            user.lihatBerita(menuBerita, berita);
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
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuBerita.dispose();
            DashboardUserView dashboard = new DashboardUserView();
            dashboard.setVisible(true);
            DashboardUserController controller = new DashboardUserController(dashboard, user);
        }
        
    }
    public DaftarBeritaController(DaftarBeritaView view, User user){
        menuBerita = view;
        this.user = user;
        menuBerita.klikTabelBerita(new tabelBerita());
        menuBerita.klikBtnKembali(new btnKembali());
    }
}
