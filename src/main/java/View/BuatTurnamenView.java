package View;

import MainProgram.DBconn;
import Model.Turnamen;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class BuatTurnamenView extends javax.swing.JFrame {
    ArrayList<Turnamen> listTurnamen = new ArrayList<>();
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    String sql;
    public BuatTurnamenView() {
        initComponents();
        tampilListTurnamen();
        this.setTitle("Menu Turnamen");
        this.setLocationRelativeTo(null);
    }

    public String getNamaTurnamen(){
        return txtNama.getText();
    }
    public String getTempat(){
        return txtTempat.getText();
    }
    public String getTanggal(){
        int indexTgl = cbxTgl.getSelectedIndex();
        int indexBln = cbxBln.getSelectedIndex();
        int indexThn = cbxThn.getSelectedIndex();
        String tgl = cbxTgl.getItemAt(indexTgl);
        String bln = cbxBln.getItemAt(indexBln);
        String thn = cbxThn.getItemAt(indexThn);
        return thn + "-" + bln + "-" + tgl;
    }
    public String getJenis(){
        int index = cbxJenis.getSelectedIndex();
        return cbxJenis.getItemAt(index);
    }
    public String getDeskripsi(){
        return txtDeskripsi.getText();
    }
    public void klikBtnKirim(ActionListener listener){
        btnKirim.addActionListener(listener);
    }
    public void klikBtnUbah(ActionListener listener){
        btnUbah.addActionListener(listener);
    }
    public void klikBtnKembali(ActionListener listener){
        btnKembali.addActionListener(listener);
    }
    public void klikJListTurnamen(MouseListener listener){
        jListTurnamen.addMouseListener(listener);
    }
    public void setLabelPanel(String label){
        jLabel2.setText(label);
    }
    public String getSelectedTurnamen(){
        return jListTurnamen.getSelectedValue();
    }
    public ArrayList<Turnamen> getListTurnamen(){
        return listTurnamen;
    }
    public void tampilListTurnamen(){
        sql = "select * from turnamen";
        try{
            rs = stt.executeQuery(sql);
            while(rs.next()){
                Date date = rs.getDate("tanggal");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String sTanggal = formatter.format(date);
                Turnamen turnamen = new Turnamen(rs.getInt("id"), rs.getString("nama_turnamen"), rs.getString("tempat"), sTanggal, rs.getString("deskripsi"), rs.getString("jenis_turnamen"));
                listTurnamen.add(turnamen);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        DefaultListModel model = new DefaultListModel();
        for(Turnamen e:listTurnamen){
            model.addElement(e.getNamaTurnamen());
        }
        jListTurnamen.setModel(model);
    }
    public void setHasilListTurnamen(Turnamen turnamen){
        txtNama.setText(turnamen.getNamaTurnamen());
        txtTempat.setText(turnamen.getTempat());
        txtDeskripsi.setText(turnamen.getDeskripsi());
        cbxJenis.setSelectedItem(turnamen.getJenisTurnamen());
        cbxTgl.setSelectedItem(turnamen.getTanggal().substring(8));
        cbxBln.setSelectedItem(turnamen.getTanggal().substring(5,7));
        cbxThn.setSelectedItem(turnamen.getTanggal().substring(0,4));
    }
    public void reset(){
        txtNama.setText("");
        txtTempat.setText("");
        txtDeskripsi.setText("");
        cbxJenis.setSelectedItem("");
        cbxTgl.setSelectedIndex(0);
        cbxBln.setSelectedIndex(0);
        cbxThn.setSelectedIndex(0);
        listTurnamen.removeAll(listTurnamen);
        jLabel2.setText("Tambah Turnamen");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTempat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnKirim = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxJenis = new javax.swing.JComboBox<>();
        lblDetail = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        btnUbah = new javax.swing.JButton();
        cbxTgl = new javax.swing.JComboBox<>();
        cbxBln = new javax.swing.JComboBox<>();
        cbxThn = new javax.swing.JComboBox<>();
        btnKembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTurnamen = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("List Turnamen");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Tambah Turnamen");

        jLabel3.setText("Nama");

        jLabel4.setText("Tempat");

        jLabel5.setText("Tanggal");

        btnKirim.setText("Kirim");

        jLabel6.setText("Jenis");

        cbxJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solo", "Team", "Solo/Team" }));

        lblDetail.setText("Deskripsi");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setLineWrap(true);
        txtDeskripsi.setRows(5);
        jScrollPane3.setViewportView(txtDeskripsi);

        btnUbah.setText("Ubah");

        cbxTgl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbxBln.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbxThn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtTempat))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblDetail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(cbxJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbxJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(lblDetail)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirim)
                    .addComponent(btnUbah))
                .addContainerGap())
        );

        btnKembali.setText("Kembali");

        jScrollPane1.setViewportView(jListTurnamen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKirim;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbxBln;
    private javax.swing.JComboBox<String> cbxJenis;
    private javax.swing.JComboBox<String> cbxTgl;
    private javax.swing.JComboBox<String> cbxThn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListTurnamen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTempat;
    // End of variables declaration//GEN-END:variables
}
