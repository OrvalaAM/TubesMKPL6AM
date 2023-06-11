package Controller;

import MainProgram.DBconn;
import View.LoginView;
import View.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RegisterController {
    RegisterView menuRegister;
    DBconn db;
    Connection con = db.getConnection();
    Statement stt = db.getStatement();
    ResultSet rs;
    String sql;
    
    class btnRegister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String user = menuRegister.getUser();
            String pass = menuRegister.getPass();
            String confirm = menuRegister.getConfirmPass();
            String nama = menuRegister.getNama();
            String asal = menuRegister.getAsal();
            String kontak = menuRegister.getKontak();
            String jenisKelamin = menuRegister.getKelamin();
            if(!pass.equals(confirm)){
                JOptionPane.showMessageDialog(menuRegister, "Terjadi ketidakcocokan data");
                menuRegister.reset();
            }
            else if(user.length() > 20 || pass.length() > 20){
                JOptionPane.showMessageDialog(menuRegister, "Input melebihi batas yang ditentukan");
                menuRegister.reset();
            }
            else{
                try{
                    sql = "insert into akun values('"+user+"', '"+pass+"', 'user')";
                    stt.execute(sql);
                    sql = "insert into user(username, nama, asal, kontak, jenis_kelamin, nama_tim)"
                            + " values('"+user+"', '"+nama+"','"+asal+"','"+kontak+"','"+jenisKelamin+"', '')";
                    stt.execute(sql);
                    JOptionPane.showMessageDialog(menuRegister, "Register berhasil");
                    LoginView menuLogin = new LoginView();
                    LoginController kontrolLogin = new LoginController(menuLogin);
                    menuLogin.setVisible(true);
                    menuRegister.dispose();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(menuRegister, e.getMessage());
                }
                
            }
        }
        
    }
    class btnKembali implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuRegister.dispose();
            LoginView menuLogin = new LoginView();
            LoginController controlLogin = new LoginController(menuLogin);
            menuLogin.setVisible(true);
        }
        
    }
    public RegisterController(RegisterView regis){
        menuRegister = regis;
        menuRegister.klikBtnRegister(new btnRegister());
        menuRegister.klikBtnKembali(new btnKembali());
    }
}
