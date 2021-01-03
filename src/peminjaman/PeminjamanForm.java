
package peminjaman;
import java.util.List;
import user.*;
import java.util.Optional;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.options.Option;
import sepeda.Sepeda;

public class PeminjamanForm extends javax.swing.JInternalFrame {

    private int id;
    private PeminjamanDAO dao;
    private List<Sepeda> SepedaList;
    private int tag = 0;
    int barangId;

    public PeminjamanForm() {
        initComponents();
        dao = new PeminjamanDAOImp();
        loadSepeda();
        reset();
    }

    public void reset() {
        tf_nama.setText("");
        cb_sepeda.setSelectedIndex(0);
        tf_nama.setText("");
        tf_nik.setText("");
        tf_total.setText("");
        tf_lama_pinjam.setText("");
        tag = 0;

        read();
    }

    public boolean validasi() {
        boolean hasil = false;
        if (tf_nama.getText().isEmpty() || cb_sepeda.getSelectedIndex() == 0 || tf_nama.getText().isEmpty() || tf_nik.getText().isEmpty() || tf_total.getText().isEmpty()) {
            hasil = false;
        } else {
            hasil = true;
        }
        return hasil;
    }

    public void read() {
        dao.read(tbl_peminjaman);
    }

    public void save() {
        if (validasi() == true) {
            if (!jikaKeluar()) {
                JOptionPane.showMessageDialog(this, "Maaf sepeda ini sedang tidak tersedia");
            } else {
                create();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Input belum lengkap!");
        }
        reset();
    }

    public void loadSepeda() {
        SepedaList = dao.loadSepeda();
        cb_sepeda.removeAllItems();
        cb_sepeda.addItem("-- PILIH --");
        for (Sepeda sp : SepedaList) {
            cb_sepeda.addItem(sp.getNama());
        }
        selecetSepeda();
    }

    public void selecetSepeda() {
        int index = cb_sepeda.getSelectedIndex();
        if (index == 0) {
            tf_harga.setText("");
        } else {
            tf_harga.setText(String.valueOf(SepedaList.get(index - 1).getHarga()));
        }
    }

    public void total() {
        int harga = Integer.valueOf(tf_harga.getText());
        int lama_pinjam = Integer.valueOf(tf_lama_pinjam.getText());
        int hasil = harga * lama_pinjam;
        tf_total.setText(String.valueOf(hasil));
    }

    public void delete() {
        int selected = tbl_peminjaman.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk menghapus?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbl_peminjaman.getSelectedRow();
                id = Integer.valueOf(tbl_peminjaman.getValueAt(baris, 0).toString());
                dao.delete(id);
                read();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }

    public void cekStatus() {
        dao.cekStatus(cb_sepeda.getSelectedItem().toString());
    }

    public boolean jikaKeluar() {
        return dao.jikaKeluar(cb_sepeda.getSelectedItem().toString());
    }

    public void create() {
        Peminjaman peminjaman = new Peminjaman();
        Sepeda sepeda = new Sepeda();
        peminjaman.setSepeda(sepeda);
        peminjaman.setNama_peminjam(tf_nama.getText());
        peminjaman.setNik(tf_nik.getText());
        peminjaman.setHarga_total(Integer.valueOf(tf_total.getText()));
        peminjaman.setLama_pinjam(Integer.valueOf(tf_lama_pinjam.getText()));
        dao.create(peminjaman, cb_sepeda.getSelectedIndex());

        cekStatus();
    }

    public void cari() {
        if (tf_cari.getText().isEmpty()) {
            reset();
        } else {
            dao.search(tbl_peminjaman, tf_cari.getText());
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
        tf_nik = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_lama_pinjam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_harga = new javax.swing.JTextField();
        tf_total = new javax.swing.JTextField();
        cb_sepeda = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_peminjaman = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_cari = new javax.swing.JTextField();

        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1080, 600));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setText("NAMA PEMINJAM");

        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });

        jLabel2.setText("SEPEDA");

        jLabel6.setText("NIK");

        jLabel4.setText("LAMA PINJAM");

        tf_lama_pinjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_lama_pinjamKeyReleased(evt);
            }
        });

        jLabel3.setText("HARGA");

        jLabel9.setText("TOTAL");

        tf_harga.setEnabled(false);

        tf_total.setEnabled(false);

        cb_sepeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sepedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_sepeda, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE)
                    .addComponent(tf_nik, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_lama_pinjam, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_harga, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_total, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nama))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_sepeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_lama_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(462, Short.MAX_VALUE))
        );

        tbl_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_peminjaman);

        jButton1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_delete.png"))); // NOI18N
        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shoppingcart_add.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Britannic Bold", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PEMINJAMAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_cari))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        setBounds(0, 0, 1630, 920);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        save(); //tag=0, jadi menjalankan create
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyReleased
        cari();
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cariKeyReleased

    private void cb_sepedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sepedaActionPerformed
        selecetSepeda();
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sepedaActionPerformed

    private void tf_lama_pinjamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_lama_pinjamKeyReleased
        if (tf_lama_pinjam.getText().isEmpty()) {
            tf_total.setText("");
        } else {
            total();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_lama_pinjamKeyReleased
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeminjamanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_sepeda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_peminjaman;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_lama_pinjam;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nik;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}
