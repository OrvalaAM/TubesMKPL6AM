package View;

import MainProgram.DBconn;
import Model.Berita;
import Model.Event;
import Model.HasilPertandingan;
import Model.ProfilPemain;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class BuatBeritaView extends javax.swing.JFrame {
    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    ArrayList<Berita> listBerita = new ArrayList<>();
    
    public BuatBeritaView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Buat Berita");
        tampilListBerita();
    }
    public void setListBerita(ArrayList<Berita> list){
        listBerita = list;
    }
    public String getJudul(){
        return txtJudul.getText();
    }
    public String getPenulis(){
        return txtPenulis.getText();
    }
    public String getIsi(){
        return txtIsi.getText();
    }
    public String getDetail(){
        return txtDetail.getText();
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
    public void klikComboboxKategori(ActionListener listener){
        cbxKategori.addActionListener(listener);
    }
    public void setIsi(String berita){
        txtIsi.setText(berita);
    }
    public int getIndexDetail(){
        return cbxKategori.getSelectedIndex();
    }
    public String getKategori(){
        int index = cbxKategori.getSelectedIndex();
        return cbxKategori.getItemAt(index);
    }
    public void comboboxEvent(String label){
        lblDetail.setText(label);
    }
    public void comboboxHasil(String label, HasilPertandingan hasil){
        lblDetail.setText(label);
        txtDetail.setText(hasil.analisis());
    }
    public void comboboxProfil(String label, ProfilPemain profil){
        lblDetail.setText(label);
        txtDetail.setText(profil.analisis());
    }
    public void tampilListBerita(){
        try{
            String sql = "select * from berita";
            rs = stt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("kategori").equals("Profil Pemain")){
                    Berita tambahProfil = new ProfilPemain(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahProfil);
                }
                else if(rs.getString("kategori").equals("Hasil Pertandingan")){
                    Berita tambahHasil = new HasilPertandingan(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahHasil);
                }
                else if(rs.getString("kategori").equals("Event")){
                    Berita tambahEvent = new Event(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahEvent);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        DefaultListModel model = new DefaultListModel();
        for(Berita e:listBerita){
            model.addElement(e.getJudul());
        }
        jListBerita.setModel(model);
    }
    public ArrayList<Berita> getListBerita(){
        return listBerita;
    }
    public String getSelectedBerita(){
        return jListBerita.getSelectedValue();
    }
    public void klikJListBerita(MouseListener listener){
        jListBerita.addMouseListener(listener);
    }
    public void setHasilListBerita(Berita berita){
        txtJudul.setText(berita.getJudul());
        txtPenulis.setText(berita.getPenulis());
        txtIsi.setText(berita.getIsiBerita());
        if(berita instanceof ProfilPemain){
            ProfilPemain profil = (ProfilPemain) berita;
            cbxKategori.setSelectedIndex(0);
            txtDetail.setText(profil.getDetailPemain());
        }
        if(berita instanceof HasilPertandingan){
            HasilPertandingan hasil = (HasilPertandingan) berita;
            cbxKategori.setSelectedIndex(1);
            txtDetail.setText(hasil.getStatistik());
        }
        if(berita instanceof Event){
            Event event = (Event) berita;
            cbxKategori.setSelectedIndex(2);
            txtDetail.setText(event.getKesan());
        }
    }
    public void reset(){
        txtJudul.setText("");
        txtPenulis.setText("");
        txtIsi.setText("");
        cbxKategori.setSelectedIndex(0);
        txtDetail.setText("");
        listBerita.removeAll(listBerita);
        jLabel2.setText("Tambah Berita");
    }
    public void setLabelPanel(String label){
        jLabel2.setText(label);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListBerita = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPenulis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIsi = new javax.swing.JTextArea();
        btnKirim = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxKategori = new javax.swing.JComboBox<>();
        lblDetail = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        btnUbah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jListBerita);

        jLabel1.setText("List Berita");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Tambah Berita");

        jLabel3.setText("Judul");

        jLabel4.setText("Penulis");

        jLabel5.setText("Isi Berita");

        txtIsi.setColumns(20);
        txtIsi.setLineWrap(true);
        txtIsi.setRows(5);
        jScrollPane2.setViewportView(txtIsi);

        btnKirim.setText("Kirim");

        jLabel6.setText("Kategori");

        cbxKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profil Pemain", "Hasil Pertandingan", "Event" }));

        lblDetail.setText("Detail");

        txtDetail.setColumns(20);
        txtDetail.setLineWrap(true);
        txtDetail.setRows(5);
        jScrollPane3.setViewportView(txtDetail);

        btnUbah.setText("Ubah");

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
                            .addComponent(txtJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtPenulis)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblDetail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(cbxKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblDetail)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirim)
                    .addComponent(btnUbah))
                .addContainerGap())
        );

        btnKembali.setText("Kembali");

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
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKirim;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbxKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListBerita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextArea txtIsi;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenulis;
    // End of variables declaration//GEN-END:variables

}
