package Controller;

import MainProgram.DBconn;
import Model.Admin;
import Model.User;
import View.LoginView;
import View.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginController {
    LoginView menuLogin;
    DBconn db;
    Connection con = db.getConnection();
    Statement stt = db.getStatement();
    ResultSet rs;
    String sql;
    class btnLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String username = menuLogin.getUser();
            String password = menuLogin.getPass();
            sql = "select * from akun where username = '"+username+"' and password = '"+password+"'";
            try{
                rs = stt.executeQuery(sql);
                if(rs.next()){
                    if(rs.getString("role").equals("admin")){
                        Admin admin = new Admin(username, password);
                        admin.login(menuLogin);
                    }
                    else if(rs.getString("role").equals("user")){
                        sql = "select * from user where username = '"+username+"'";
                        rs = stt.executeQuery(sql);
                        if(rs.next()){
                            User user = new User(rs.getString("nama"),
                                    rs.getString("asal"), rs.getString("kontak"),
                                    rs.getString("jenis_kelamin"),
                                    rs.getString("nama_tim"), username, password);
                            user.login(menuLogin);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(menuLogin, "Kesalahan input data");
                    menuLogin.reset();
                }
                
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                //JOptionPane.showMessageDialog(menuLogin, e.getMessage());
            }
            
        }
        
    }
    class btnRegister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            RegisterView menuRegister = new RegisterView();
            RegisterController kontrolRegister = new RegisterController(menuRegister);
            menuLogin.dispose();
            menuRegister.setVisible(true);
        }
        
    }
    public LoginController(LoginView login){
        menuLogin = login;
        menuLogin.klikBtnLogin(new btnLogin());
        menuLogin.klikBtnRegister(new btnRegister());
    }
}
