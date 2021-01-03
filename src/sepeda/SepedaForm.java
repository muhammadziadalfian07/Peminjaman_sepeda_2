
package sepeda;
import user.*;
import java.util.Optional;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.options.Option;

public class SepedaForm extends javax.swing.JInternalFrame {
    
    private int id;
    private SepedaDAO dao;
    private int tag;

    public SepedaForm() {
        initComponents();
        dao = new SepedaDAOImp();
        reset();
    }
    
    public void reset() {
        tag = 0;
        tf_nama.setText("");
        cb_status.setSelectedIndex(0);
        tf_harga.setText("");
        
        read();
    }
    
    public void read() {
        dao.read(tbl_sepeda);
    }
    
    public boolean validasi() {
        boolean hasil = false;
        
        if (tf_nama.getText().isEmpty() || tf_harga.getText().isEmpty() || cb_status.getSelectedIndex() == 0) {
            hasil = false;
        } else {
            hasil = true;
        }
        return hasil;
    }
    
    public void create() {
        Sepeda sepeda = new Sepeda();
        sepeda.setNama(tf_nama.getText());
        sepeda.setStatus(cb_status.getSelectedItem().toString());
        sepeda.setHarga(Integer.valueOf(tf_harga.getText()));
        
        dao.create(sepeda);
    }
    
    public void update() {
        Sepeda sepeda = new Sepeda();
        sepeda.setNama(tf_nama.getText());
        sepeda.setStatus(cb_status.getSelectedItem().toString());
        sepeda.setHarga(Integer.valueOf(tf_harga.getText()));
        
        sepeda.setId(id);
        dao.update(sepeda);
    }
    
    public void save() {
        if (validasi() == true) {
            if (tag == 0) {
                create();
            } else if (tag == 1) {
                update();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Input belum lengkap!");
        }
        reset();
    }
    
    public void getRecord() {
        int selected = tbl_sepeda.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin mengubah data?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (conf == JOptionPane.YES_OPTION) {
                tag = 1;
                int baris = tbl_sepeda.getSelectedRow();
                id = Integer.valueOf(tbl_sepeda.getValueAt(baris, 0).toString());
                tf_nama.setText(tbl_sepeda.getValueAt(baris, 1).toString());
                cb_status.setSelectedItem(tbl_sepeda.getValueAt(baris, 2).toString());
                tf_harga.setText(tbl_sepeda.getValueAt(baris, 3).toString());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }
    
    public void delete() {
        int selected = tbl_sepeda.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin menghapus data?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbl_sepeda.getSelectedRow();
                id = Integer.valueOf(tbl_sepeda.getValueAt(baris, 0).toString());
                dao.delete(id);
                reset();;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }
    
    public void cari() {
        if (tf_cari.getText().isEmpty()) {
            reset();
        } else {
            dao.search(tbl_sepeda, tf_cari.getText());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_harga = new javax.swing.JTextField();
        cb_status = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sepeda = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_cari = new javax.swing.JTextField();

        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1080, 600));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setText("Nama Sepeda");

        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });

        jLabel2.setText("Status");

        jLabel6.setText("Harga");

        cb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Tersedia", "Keluar" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(tf_nama)
                    .addComponent(cb_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(571, Short.MAX_VALUE))
        );

        tbl_sepeda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_sepeda);

        btn_simpan.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_delete.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_warning.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_edit.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_edit.png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bicycle.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Britannic Bold", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAGEMENT SEPEDA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(45, 45, 45))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Cari");

        tf_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_cari))
                    .addComponent(jScrollPane2)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_simpan)
                .addGap(8, 8, 8)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_edit)
                        .addComponent(btn_batal)
                        .addComponent(btn_hapus))
                    .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 1635, 920);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaActionPerformed

    private void tf_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyReleased
        cari();
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cariKeyReleased

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        save(); //tag=0, jadi menjalankan create
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        getRecord();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_batalActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_sepeda;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
