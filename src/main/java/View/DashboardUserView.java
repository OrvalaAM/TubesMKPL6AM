package View;

import java.awt.event.ActionListener;

public class DashboardUserView extends javax.swing.JFrame {

    public DashboardUserView() {
        initComponents();
        this.setTitle("Dashboard");
        this.setLocationRelativeTo(null);
    }
    public void setHeader(String header){
        lblHeader.setText(header);
    }
    public void klikBtnTim(ActionListener listener){
        btnTim.addActionListener(listener);
    }
    public void klikBtnTurnamen(ActionListener listener){
        btnTurnamen.addActionListener(listener);
    }
    public void klikBtnBerita(ActionListener listener){
        btnBerita.addActionListener(listener);
    }
    public void klikBtnLogout(ActionListener listener){
        btnLogout.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        btnTurnamen = new javax.swing.JButton();
        btnBerita = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnTurnamen.setText("Ikut Turnamen");

        btnBerita.setText("Lihat Berita");

        btnTim.setText("Gabung Tim");

        btnLogout.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTurnamen, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(btnBerita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnTim)
                .addGap(18, 18, 18)
                .addComponent(btnTurnamen)
                .addGap(18, 18, 18)
                .addComponent(btnBerita)
                .addGap(50, 50, 50)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerita;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTurnamen;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
