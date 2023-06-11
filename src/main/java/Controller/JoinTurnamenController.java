package Controller;

import MainProgram.DBconn;
import Model.Turnamen;
import Model.User;
import View.DashboardUserView;
import View.JoinTurnamenView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JoinTurnamenController {
    JoinTurnamenView menuTurnamen;
    User user;
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    class cbxJenis implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<Turnamen> listTurnamen;
            String jenis = menuTurnamen.getJenis();
            if(jenis.equals("Semua")){
                listTurnamen = setListTurnamen();
            }
            else{
                listTurnamen = setListTurnamenByJenis(jenis);
            }
            menuTurnamen.reset();
            menuTurnamen.tampilTabelTurnamenByJenis(listTurnamen);
        }
        
    }
    class btnIkut implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                String namaTurnamen = menuTurnamen.getNamaTurnamen();
                ArrayList<Turnamen> listTurnamen = menuTurnamen.getListTurnamen();
                Turnamen turnamen = null;
                while(turnamen == null){
                    for(Turnamen e:listTurnamen){
                        if(e.getNamaTurnamen().equals(namaTurnamen)){
                            turnamen = e;
                        }
                    }
                }
                boolean found = false;
                sql = "select turnamen from partisipasi where peserta = '"+user.getUsername()+"' "
                        + "or peserta = '"+user.getNamaTeam()+"'";
                rs = stt.executeQuery(sql);
                while(rs.next()){
                    if(turnamen.getNamaTurnamen().equals(rs.getString("turnamen"))){
                        found = true;
                        break;
                    }
                }
                if(found == false){
                    String jenis = menuTurnamen.getJenis();
                    user.ikutTurnamen(turnamen, jenis);
                }
                else{
                    JOptionPane.showMessageDialog(menuTurnamen, "Sudah mengikuti turnamen ini");
                }
                menuTurnamen.reset();
                menuTurnamen.tampilTabelTurnamen();
                menuTurnamen.tampilListPartisipasi();
                menuTurnamen.setCbxJenis(0);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(menuTurnamen, e.getMessage());
            }
        }
        
    }
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuTurnamen.dispose();
            DashboardUserView dashboard = new DashboardUserView();
            dashboard.setVisible(true);
            DashboardUserController controller = new DashboardUserController(dashboard, user);
        }
        
    }
    public JoinTurnamenController(JoinTurnamenView view, User user){
        menuTurnamen = view;
        this.user = user;
        menuTurnamen.klikCbxJenis(new cbxJenis());
        menuTurnamen.klikBtnIkut(new btnIkut());
        menuTurnamen.klikBtnKembali(new btnKembali());
    }
    public JoinTurnamenController(){}
    public ArrayList<Turnamen> setListTurnamen(){
        ArrayList<Turnamen> listTurnamen = new ArrayList<>();
        try{
            sql = "select * from turnamen";
            rs = stt.executeQuery(sql);
            while(rs.next()){
                Turnamen turnamen = new Turnamen(
                        rs.getString("nama_turnamen"),
                        rs.getString("tempat"),
                        rs.getString("tanggal"),
                        rs.getString("deskripsi"),
                        rs.getString("jenis_turnamen"));
                listTurnamen.add(turnamen);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(menuTurnamen, e.getMessage());
        }
        return listTurnamen;
    }
    public ArrayList<Turnamen> setListTurnamenByJenis(String jenis){
        ArrayList<Turnamen> listTurnamen = new ArrayList<>();
        try{
            sql = "select * from turnamen where jenis_turnamen = '"+jenis+"'";
            rs = stt.executeQuery(sql);
            while(rs.next()){
                Turnamen turnamen = new Turnamen(
                        rs.getString("nama_turnamen"),
                        rs.getString("tempat"),
                        rs.getString("tanggal"),
                        rs.getString("deskripsi"),
                        rs.getString("jenis_turnamen"));
                listTurnamen.add(turnamen);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(menuTurnamen, e.getMessage());
        }
        return listTurnamen;
    }
    public ArrayList<Turnamen> setListPartisipasi(User partisipan){
        ArrayList<Turnamen> listPartisipasi = new ArrayList<>();
        try{
            if(partisipan.getNamaTeam().equals("")){
                sql = "select distinct turnamen from partisipasi where peserta= '"+partisipan.getUsername()+"'";
            }
            else{
                sql = "select distinct turnamen from partisipasi where peserta= '"+partisipan.getUsername()+"'"
                        + "or peserta= '"+partisipan.getNamaTeam()+"'";
            }
            rs = stt.executeQuery(sql);
            while(rs.next()){
                Turnamen partisipasi = new Turnamen(rs.getString("turnamen"));
                listPartisipasi.add(partisipasi);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(menuTurnamen, e.getMessage());
        }
        
        return listPartisipasi;
    }
}
