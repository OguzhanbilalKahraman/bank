/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeOdev;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oguzh
 */
public class BankPanel extends javax.swing.JFrame {
    
    private BankaPersoneli bankaPersoneli;
    
    private DefaultTableModel getTableModel() {
        return (DefaultTableModel) tableMusteri.getModel();
    }
    
    private DefaultTableModel getKrediKartiTableModel() {
        return (DefaultTableModel) tableKrediKarti.getModel();
    }
    
    private DefaultTableModel getHesapTableModel() {
        return (DefaultTableModel) tableHesap.getModel();
    }
    
    private DefaultTableModel getYatirimTableModel() {
        return (DefaultTableModel) tableYatirim.getModel();
    }
    
    private void alanlarBosGecilemez() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "Alanlar boş geçilemez", "Hata", dialogButton);
    }
    
    private void mesajGoster(String mesaj, String baslik) {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, mesaj, baslik, dialogButton);
    }
    
    private void musteriNoileAramaYapilmali() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "Bir eklemeye yada güncelleme işlemi yapmak için, öncelikle bir müşteri numarası"
                + "ile arama yapilmali", "Hata", dialogButton);
    }
    
    private void alanlarBosYadaSecilmemis() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "Alanlar boş yada seçim yapmadınız", "Hata", dialogButton);
    }
    
    private void islemBasarili() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "İşleminiz başarı ile gerçekleşti", "Başarılı", dialogButton);
    }
    
    private void islemBasarisiz() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "İşleminiz başarısız oldu.", "Hata", dialogButton);
    }
    
    private void guncelBorcLimittenYuksekOlamaz() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, "Güncel borç limitten yüksek olamaz.", "Hata", dialogButton);
    }
    
    private void musteriNoBulunamadi(int musteriNo) {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        JOptionPane.showConfirmDialog(null, musteriNo + "numarali müşteri numarasına sahip müşteri bulunamadı.", "Hata", dialogButton);
    }
    
    private void doldurKrediKartiTablo(int musteriNo) {
        ArrayList<KrediKarti> krediKartlari = Musteri.getirKrediKartlariMusteriNo(musteriNo);
        DefaultTableModel model = getKrediKartiTableModel();
        Object rowData[] = new Object[4];
        
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            model.setRowCount(0);
        }
        
        for (int i = 0; i < krediKartlari.size(); i++) {
            KrediKarti krediKarti = krediKartlari.get(i);
            rowData[0] = krediKarti.getKartNumarasi();
            rowData[1] = krediKarti.getLimit();
            rowData[2] = krediKarti.getGuncelBorc();
            rowData[3] = krediKarti.getKullanilabilirLimit();
            model.addRow(rowData);
        }
    }
    
    private void doldurHesapTablo(int musteriNo) {
        ArrayList<VadesizHesap> vadesizHesaplar = Musteri.getirVadesizHesaplarMusteriNo(musteriNo);
        DefaultTableModel model = getHesapTableModel();
        
        Object rowData[] = new Object[3];
        
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            model.setRowCount(0);
        }
        
        for (int i = 0; i < vadesizHesaplar.size(); i++) {
            VadesizHesap vadesizHesap = vadesizHesaplar.get(i);
            rowData[0] = vadesizHesap.getIban();
            rowData[1] = vadesizHesap.getBakiye();
            rowData[2] = vadesizHesap.getHesapTuru();
            
            model.addRow(rowData);
        }
    }
    
    private void doldurYatirimTablo(int musteriNo) {
        ArrayList<YatirimHesabi> yatirimHesaplar = Musteri.getirYatirimHesaplarMusteriNo(musteriNo);
        
        DefaultTableModel model = getYatirimTableModel();
        
        Object rowData[] = new Object[3];
        
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            model.setRowCount(0);
        }
        
        for (int i = 0; i < yatirimHesaplar.size(); i++) {
            YatirimHesabi yatirimHesabi = yatirimHesaplar.get(i);
            rowData[0] = yatirimHesabi.getIban();
            rowData[1] = yatirimHesabi.getBakiye();
            rowData[2] = yatirimHesabi.getHesapTuru();
            
            model.addRow(rowData);
        }
    }
    
    private void bosaltKrediKartiTablo() {
        DefaultTableModel model = getKrediKartiTableModel();
        model.setRowCount(0);
    }
    
    private void bosaltHesapTablo() {
        DefaultTableModel model = getHesapTableModel();
        model.setRowCount(0);
    }
    
    private void bosaltYatirimTablo() {
        DefaultTableModel model = getYatirimTableModel();
        model.setRowCount(0);
    }
    
    private void doldurMusteriTablo() {
        ArrayList<Musteri> musteriler = this.bankaPersoneli.getMusteriler();
        DefaultTableModel model = getTableModel();
        Object rowData[] = new Object[5];
        
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            model.setRowCount(0);
        }
        
        for (int i = 0; i < musteriler.size(); i++) {
            Musteri musteri = musteriler.get(i);
            rowData[0] = musteri.getMusteriNumarasi();
            rowData[1] = musteri.getAd();
            rowData[2] = musteri.getSoyad();
            rowData[3] = musteri.getEmail();
            rowData[4] = musteri.getTelefonNumarasi();
            model.addRow(rowData);
        }
    }

    // alanlardan herhangi biri boş ise true döner
    private boolean formAlanKontrol() {
        return "".equals(String.valueOf(txtAd.getText())) || "".equals(String.valueOf(txtMail.getText())) || "".equals(String.valueOf(txtTel.getText())) || "".equals(String.valueOf(txtSoyad.getText()));
    }

    // borçsuz kredi kartı oluşturabilir.
    private boolean formKrediKartiAlanKontrol() {
        return "".equals(String.valueOf(txtLimit.getText()));
    }
    
    private boolean formVadesizAlanKontrol() {
        return "".equals(String.valueOf(txtHesapBakiye.getText()));
    }
    
    private boolean formYatirimAlanKontrol() {
        return "".equals(String.valueOf(txtYatirimBakiye.getText()));
    }
    
    private void musteriFiltreGizle() {
        lblMusteriNo.setVisible(false);
        btnMusteriAramaKaldir.setVisible(false);
    }
    
    private void musteriFiltreAc(int musteriNo) {
        lblMusteriNo.setVisible(true);
        lblMusteriNo.setText(musteriNo + " numaralı müşteriye ait sonuçları görmektesiniz.");
        btnMusteriAramaKaldir.setVisible(true);
    }
    
    private void hesapFiltreGizle() {
        lblHesapMusteriNo.setVisible(false);
        btnHesapMusteriAramaKaldir.setVisible(false);
    }
    
    private void hesapFiltreAc(int musteriNo) {
        lblHesapMusteriNo.setVisible(true);
        lblHesapMusteriNo.setText(musteriNo + " numaralı müşteriye ait sonuçları görmektesiniz.");
        btnHesapMusteriAramaKaldir.setVisible(true);
    }
    
    private void yatirimFiltreGizle() {
        lblYatirim.setVisible(false);
        btnYatirimKaldir.setVisible(false);
    }
    
    private void yatirimFiltreAc(int musteriNo) {
        lblYatirim.setVisible(true);
        lblYatirim.setText(musteriNo + " numaralı müşteriye ait sonuçları görmektesiniz.");
        btnYatirimKaldir.setVisible(true);
    }
    
    private void bosaltForm() {
        txtAd.setText("");
        txtMail.setText("");
        txtSoyad.setText("");
        txtTel.setText("");
        txtMusteriNo.setText("");
    }
    
    private void bosaltKrediKartiForm() {
        txtKartNumarasi.setText("");
        txtGuncelBorc.setText("");
        txtKullanılabilirLimit.setText("");
        txtLimit.setText("");
    }
    
    private void bosaltHesapForm() {
        txtHesapBakiye.setText("");
        txtHesapIban.setText("");
    }
    
    private void bosaltYatirimForm() {
        txtYatirimBakiye.setText("");
        txtHesapIban.setText("");
    }

    /**
     * Creates new form BankPanel
     */
    public BankPanel() {
        this.bankaPersoneli = new BankaPersoneli("Oğuzhan", "Kahraman", "oguz@mail.com", "555555555");
        initComponents();
        this.doldurMusteriTablo();
        this.musteriFiltreGizle();
        this.hesapFiltreGizle();
        this.yatirimFiltreGizle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        musteriOptionPane = new javax.swing.JOptionPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMusteri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMusteriEkle = new javax.swing.JButton();
        btnMusteriDuzenle = new javax.swing.JButton();
        btnMusteriSil = new javax.swing.JButton();
        btnTemizle = new javax.swing.JButton();
        txtMail = new javax.swing.JTextField();
        txtMusteriNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtKrediMusteriNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnMusteriNoAra = new javax.swing.JButton();
        lblMusteriNo = new javax.swing.JLabel();
        btnMusteriAramaKaldir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKrediKarti = new javax.swing.JTable();
        btnKrediKartıEkle = new javax.swing.JButton();
        btnKrediKartiSil = new javax.swing.JButton();
        btnKrediKartiTemizle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtKartNumarasi = new javax.swing.JTextField();
        txtGuncelBorc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKullanılabilirLimit = new javax.swing.JTextField();
        txtLimit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtHesapMusteriNo = new javax.swing.JTextField();
        btnHesapMusteriNoAra = new javax.swing.JButton();
        lblHesapMusteriNo = new javax.swing.JLabel();
        btnHesapMusteriAramaKaldir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHesap = new javax.swing.JTable();
        txtHesapIban = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHesapBakiye = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnParaTransferiYap = new javax.swing.JButton();
        btnKartBorcuOde = new javax.swing.JButton();
        btnVadesizHesapEkle = new javax.swing.JButton();
        btnVadesizHesapSil = new javax.swing.JButton();
        btnVadesizTemizle = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtYatirimMusteriNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblYatirim = new javax.swing.JLabel();
        btnYatirimKaldir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableYatirim = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtYatirimIban = new javax.swing.JTextField();
        txtYatirimBakiye = new javax.swing.JTextField();
        btnYatirimHesapEkle = new javax.swing.JButton();
        btnYatirimHesapSil = new javax.swing.JButton();
        btnYatirimTemizle = new javax.swing.JButton();
        btnParaEkle = new javax.swing.JButton();
        btnParaCek = new javax.swing.JButton();
        btnYatirimAra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMusteri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Müşteri Numarası ", "Adı", "Soyadı", "Mail Adresi", "Telefon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMusteri.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMusteri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMusteriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMusteri);

        jLabel1.setText("Adı :");

        jLabel2.setText("Soyadı :");

        jLabel3.setText("Mail Adresi :");

        jLabel4.setText("Tel No :");

        btnMusteriEkle.setText("Yeni Müşteri Ekle");
        btnMusteriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriEkleActionPerformed(evt);
            }
        });

        btnMusteriDuzenle.setText("Müşteri Düzenle");
        btnMusteriDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriDuzenleActionPerformed(evt);
            }
        });

        btnMusteriSil.setText("Müşteri Sil");
        btnMusteriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriSilActionPerformed(evt);
            }
        });

        btnTemizle.setText("Textleri Temizle");
        btnTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizleActionPerformed(evt);
            }
        });

        txtMusteriNo.setEnabled(false);
        txtMusteriNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMusteriNoActionPerformed(evt);
            }
        });

        jLabel5.setText("Müşteri Numarası :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMusteriEkle, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                            .addComponent(btnMusteriDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMusteriSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTemizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel1)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoyad, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtAd)
                            .addComponent(txtMail)
                            .addComponent(txtMusteriNo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTel))))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnMusteriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMusteriDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMusteriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Müşteri Bilgileri", jPanel1);

        txtKrediMusteriNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKrediMusteriNoActionPerformed(evt);
            }
        });

        jLabel6.setText("Müşteri Numarası :");

        btnMusteriNoAra.setText("Ara");
        btnMusteriNoAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriNoAraActionPerformed(evt);
            }
        });

        lblMusteriNo.setText("jLabel7");

        btnMusteriAramaKaldir.setText("Filtreyi Kaldır");
        btnMusteriAramaKaldir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriAramaKaldirActionPerformed(evt);
            }
        });

        tableKrediKarti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kart Numarası", "Limit", "Güncel Borç", "Kullanılabilir Limit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKrediKarti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableKrediKarti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKrediKartiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKrediKarti);

        btnKrediKartıEkle.setText("Kredi Kartı Ekle");
        btnKrediKartıEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKrediKartıEkleActionPerformed(evt);
            }
        });

        btnKrediKartiSil.setText("Kredi Kartı Sil");
        btnKrediKartiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKrediKartiSilActionPerformed(evt);
            }
        });

        btnKrediKartiTemizle.setText("Temizle");
        btnKrediKartiTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKrediKartiTemizleActionPerformed(evt);
            }
        });

        jLabel7.setText("Kart Numarası :");

        txtKartNumarasi.setEnabled(false);
        txtKartNumarasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKartNumarasiActionPerformed(evt);
            }
        });

        jLabel8.setText("Güncel Borç :");

        jLabel9.setText("Kullanılabilir Limit:");

        txtKullanılabilirLimit.setEnabled(false);

        jLabel10.setText("Limit :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKrediMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMusteriNoAra))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMusteriAramaKaldir))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnKrediKartıEkle, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(btnKrediKartiSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnKrediKartiTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel10)))))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGuncelBorc)
                                    .addComponent(txtKartNumarasi)
                                    .addComponent(txtKullanılabilirLimit)
                                    .addComponent(txtLimit))))))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKrediMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnMusteriNoAra))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMusteriNo)
                    .addComponent(btnMusteriAramaKaldir))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtKartNumarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGuncelBorc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtKullanılabilirLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKrediKartıEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKrediKartiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnKrediKartiTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Kredi Kartı Bilgileri", jPanel3);

        jLabel11.setText("Müşteri Numarası :");

        btnHesapMusteriNoAra.setText("Ara");
        btnHesapMusteriNoAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHesapMusteriNoAraActionPerformed(evt);
            }
        });

        lblHesapMusteriNo.setText("jLabel12");

        btnHesapMusteriAramaKaldir.setText("Filtreyi Kaldır");
        btnHesapMusteriAramaKaldir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHesapMusteriAramaKaldirActionPerformed(evt);
            }
        });

        tableHesap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iban", "Bakiye", "Hesap Türü"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHesap.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableHesap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHesapMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableHesap);

        txtHesapIban.setEnabled(false);
        txtHesapIban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHesapIbanActionPerformed(evt);
            }
        });

        jLabel13.setText("Iban No :");

        jLabel14.setText("Bakiye :");

        btnParaTransferiYap.setText("Para Transferi");
        btnParaTransferiYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaTransferiYapActionPerformed(evt);
            }
        });

        btnKartBorcuOde.setText("Kredi Kartı Borcu Ödeme");
        btnKartBorcuOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKartBorcuOdeActionPerformed(evt);
            }
        });

        btnVadesizHesapEkle.setText("Hesap Ekle");
        btnVadesizHesapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVadesizHesapEkleActionPerformed(evt);
            }
        });

        btnVadesizHesapSil.setText("Hesap Sil");
        btnVadesizHesapSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVadesizHesapSilActionPerformed(evt);
            }
        });

        btnVadesizTemizle.setText("Temizle");
        btnVadesizTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVadesizTemizleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel11)
                        .addGap(54, 54, 54)
                        .addComponent(txtHesapMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnHesapMusteriNoAra))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblHesapMusteriNo)
                        .addGap(379, 379, 379)
                        .addComponent(btnHesapMusteriAramaKaldir))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHesapBakiye, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(txtHesapIban)))
                    .addComponent(btnParaTransferiYap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKartBorcuOde, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(btnVadesizHesapEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVadesizHesapSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVadesizTemizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHesapMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnHesapMusteriNoAra))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHesapMusteriAramaKaldir)
                    .addComponent(lblHesapMusteriNo))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHesapIban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHesapBakiye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(99, 99, 99)
                        .addComponent(btnVadesizHesapEkle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVadesizHesapSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVadesizTemizle)
                        .addGap(30, 30, 30)
                        .addComponent(btnParaTransferiYap)
                        .addGap(18, 18, 18)
                        .addComponent(btnKartBorcuOde)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Vadesiz Hesap İşlemleri", jPanel2);

        jLabel12.setText("Müşteri No :");

        lblYatirim.setText("jLabel15");

        btnYatirimKaldir.setText("Filtreyi Kaldır");
        btnYatirimKaldir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYatirimKaldirActionPerformed(evt);
            }
        });

        tableYatirim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iban", "Bakiye", "Hesap Türü"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableYatirim.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableYatirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableYatirimMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableYatirim);

        jLabel15.setText("Iban No :");

        jLabel16.setText("Bakiye :");

        txtYatirimIban.setEnabled(false);

        btnYatirimHesapEkle.setText("Hesap Ekle");
        btnYatirimHesapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYatirimHesapEkleActionPerformed(evt);
            }
        });

        btnYatirimHesapSil.setText("Hesap Sil");
        btnYatirimHesapSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYatirimHesapSilActionPerformed(evt);
            }
        });

        btnYatirimTemizle.setText("Temizle");
        btnYatirimTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYatirimTemizleActionPerformed(evt);
            }
        });

        btnParaEkle.setText("Para Ekle");
        btnParaEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaEkleActionPerformed(evt);
            }
        });

        btnParaCek.setText("Para Çek");
        btnParaCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaCekActionPerformed(evt);
            }
        });

        btnYatirimAra.setText("Ara");
        btnYatirimAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYatirimAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblYatirim, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnYatirimKaldir))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(55, 55, 55)
                        .addComponent(txtYatirimMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnYatirimAra)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtYatirimIban)
                            .addComponent(txtYatirimBakiye, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                    .addComponent(btnYatirimHesapEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnYatirimHesapSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnYatirimTemizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParaEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParaCek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYatirimMusteriNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnYatirimAra))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnYatirimKaldir)
                    .addComponent(lblYatirim))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtYatirimIban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtYatirimBakiye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(btnYatirimHesapEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnYatirimHesapSil)
                        .addGap(18, 18, 18)
                        .addComponent(btnYatirimTemizle)
                        .addGap(18, 18, 18)
                        .addComponent(btnParaEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnParaCek)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Yatırım Hesap İşlemleri", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKartNumarasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKartNumarasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKartNumarasiActionPerformed

    private void btnKrediKartiTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKrediKartiTemizleActionPerformed
        // TODO add your handling code here:
        bosaltKrediKartiForm();
    }//GEN-LAST:event_btnKrediKartiTemizleActionPerformed

    private void btnKrediKartiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKrediKartiSilActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = this.getKrediKartiTableModel();
        if (model.getRowCount() == -1 || formKrediKartiAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtKrediMusteriNo.getText()));
            Sonuc silmeKontrol = musteri.silKrediKarti(Integer.parseInt(txtKartNumarasi.getText()));
            if (silmeKontrol.getBasariliMi()) {
                islemBasarili();
                doldurKrediKartiTablo(Integer.parseInt(txtKrediMusteriNo.getText()));
                bosaltKrediKartiForm();
            } else {
                mesajGoster(silmeKontrol.getHataMesaji(), "Hata");
            }
        }
    }//GEN-LAST:event_btnKrediKartiSilActionPerformed

    private void btnKrediKartıEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKrediKartıEkleActionPerformed
        // TODO add your handling code here:

        if ("".equals(txtKrediMusteriNo.getText())) {
            alanlarBosGecilemez();
        } else {
            
            DefaultTableModel model = getKrediKartiTableModel();
            int rowCount = model.getRowCount();
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtKrediMusteriNo.getText()));
            
            double guncelBorc;
            if ("".equals(txtGuncelBorc.getText())) {
                guncelBorc = 0;
            } else {
                guncelBorc = Double.parseDouble(txtGuncelBorc.getText());
            }
            
            double limit;
            limit = Double.parseDouble(txtLimit.getText());
            if (guncelBorc > limit) {
                guncelBorcLimittenYuksekOlamaz();
            } else {
                
                KrediKarti krediKarti = new KrediKarti(limit, guncelBorc);
                
                krediKarti.setMusteriNo(Integer.parseInt(txtKrediMusteriNo.getText()));
                musteri.krediKartiEkle(krediKarti);
                islemBasarili();
                doldurKrediKartiTablo(Integer.parseInt(txtKrediMusteriNo.getText()));
                bosaltKrediKartiForm();
            }
            
        }
    }//GEN-LAST:event_btnKrediKartıEkleActionPerformed

    private void tableKrediKartiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKrediKartiMouseClicked
        // TODO add your handling code here:

        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        
        txtKartNumarasi.setText(table.getModel().getValueAt(row, 0) + "");
        txtLimit.setText(table.getModel().getValueAt(row, 1) + "");
        txtGuncelBorc.setText(table.getModel().getValueAt(row, 2) + "");
        txtKullanılabilirLimit.setText(table.getModel().getValueAt(row, 3) + "");
    }//GEN-LAST:event_tableKrediKartiMouseClicked

    private void btnMusteriAramaKaldirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriAramaKaldirActionPerformed
        // TODO add your handling code here:
        bosaltKrediKartiForm();
        txtKrediMusteriNo.setText("");
        musteriFiltreGizle();
        bosaltKrediKartiTablo();
    }//GEN-LAST:event_btnMusteriAramaKaldirActionPerformed

    private void btnMusteriNoAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriNoAraActionPerformed
        // TODO add your handling code here:
        if ("".equals(String.valueOf(txtKrediMusteriNo.getText()))) {
            alanlarBosGecilemez();
        } else {
            if (bankaPersoneli.musteriVarmi(Integer.parseInt(txtKrediMusteriNo.getText()))) {
                musteriFiltreAc(Integer.parseInt(txtKrediMusteriNo.getText()));
                doldurKrediKartiTablo(Integer.parseInt(txtKrediMusteriNo.getText()));
            } else {
                musteriNoBulunamadi(Integer.parseInt(txtKrediMusteriNo.getText()));
            }
        }
    }//GEN-LAST:event_btnMusteriNoAraActionPerformed

    private void txtKrediMusteriNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKrediMusteriNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKrediMusteriNoActionPerformed

    private void txtMusteriNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMusteriNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMusteriNoActionPerformed

    private void btnTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizleActionPerformed
        // TODO add your handling code here:
        this.bosaltForm();
        this.doldurMusteriTablo();
    }//GEN-LAST:event_btnTemizleActionPerformed

    private void btnMusteriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriSilActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = this.getTableModel();
        if (model.getRowCount() == -1 || formAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            
            Musteri musteri = new Musteri(txtAd.getText(), txtSoyad.getText(), txtMail.getText(), txtTel.getText());
            musteri.setMusteriNumarasi(Integer.parseInt(txtMusteriNo.getText()));
            boolean silmeKontrol = bankaPersoneli.silMusteri(musteri);
            if (silmeKontrol) {
                islemBasarili();
                doldurMusteriTablo();
                bosaltForm();
            } else {
                islemBasarisiz();
            }
        }
    }//GEN-LAST:event_btnMusteriSilActionPerformed

    private void btnMusteriDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriDuzenleActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = this.getTableModel();
        if (model.getRowCount() == -1 || formAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            
            Musteri musteri = new Musteri(txtAd.getText(), txtSoyad.getText(), txtMail.getText(), txtTel.getText());
            musteri.setMusteriNumarasi(Integer.parseInt(txtMusteriNo.getText()));
            boolean guncelleMusteriKontrol = bankaPersoneli.guncelleMusteri(musteri);
            if (guncelleMusteriKontrol) {
                islemBasarili();
                doldurMusteriTablo();
                bosaltForm();
            } else {
                islemBasarisiz();
            }
        }
    }//GEN-LAST:event_btnMusteriDuzenleActionPerformed

    private void btnMusteriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriEkleActionPerformed
        // TODO add your handling code here:
        if (formAlanKontrol()) {
            alanlarBosGecilemez();
        } else {
            Musteri musteri = new Musteri(txtAd.getText(), txtSoyad.getText(), txtMail.getText(), txtTel.getText());
            boolean ekleMusteri = bankaPersoneli.ekleMusteri(musteri);
            if (ekleMusteri) {
                islemBasarili();
                this.doldurMusteriTablo();
                this.bosaltForm();
            } else {
                islemBasarisiz();
            }
        }
    }//GEN-LAST:event_btnMusteriEkleActionPerformed

    private void tableMusteriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMusteriMouseClicked
        // TODO add your handling code here:

        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        
        txtMusteriNo.setText(table.getModel().getValueAt(row, 0) + "");
        txtAd.setText(table.getModel().getValueAt(row, 1) + "");
        txtSoyad.setText(table.getModel().getValueAt(row, 2) + "");
        txtMail.setText(table.getModel().getValueAt(row, 3) + "");
        txtTel.setText(table.getModel().getValueAt(row, 4) + "");
    }//GEN-LAST:event_tableMusteriMouseClicked

    private void txtHesapIbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHesapIbanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHesapIbanActionPerformed

    private void btnHesapMusteriNoAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHesapMusteriNoAraActionPerformed
        // TODO add your handling code here:

        if ("".equals(String.valueOf(txtHesapMusteriNo.getText()))) {
            alanlarBosGecilemez();
        } else {
            if (bankaPersoneli.musteriVarmi(Integer.parseInt(txtHesapMusteriNo.getText()))) {
                hesapFiltreAc(Integer.parseInt(txtHesapMusteriNo.getText()));
                doldurHesapTablo(Integer.parseInt(txtHesapMusteriNo.getText()));
            } else {
                musteriNoBulunamadi(Integer.parseInt(txtHesapMusteriNo.getText()));
            }
        }
    }//GEN-LAST:event_btnHesapMusteriNoAraActionPerformed

    private void btnHesapMusteriAramaKaldirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHesapMusteriAramaKaldirActionPerformed
        // TODO add your handling code here:

        bosaltHesapForm();
        txtHesapMusteriNo.setText("");
        hesapFiltreGizle();
        bosaltHesapTablo();
    }//GEN-LAST:event_btnHesapMusteriAramaKaldirActionPerformed

    private void tableHesapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHesapMouseClicked
        // TODO add your handling code here:

        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        
        txtHesapIban.setText(table.getModel().getValueAt(row, 0) + "");
        txtHesapBakiye.setText(table.getModel().getValueAt(row, 1) + "");
    }//GEN-LAST:event_tableHesapMouseClicked

    private void btnVadesizHesapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVadesizHesapEkleActionPerformed
        // TODO add your handling code here:
        if (formVadesizAlanKontrol()) {
            alanlarBosGecilemez();
        } else {
            
            DefaultTableModel model = getHesapTableModel();
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtHesapMusteriNo.getText()));
            
            musteri.HesapEkle(Double.parseDouble(txtHesapBakiye.getText()), "VADESİZ", Integer.parseInt(txtHesapMusteriNo.getText()));
            islemBasarili();
            doldurHesapTablo(Integer.parseInt(txtHesapMusteriNo.getText()));
            bosaltHesapForm();
            
        }
    }//GEN-LAST:event_btnVadesizHesapEkleActionPerformed

    private void btnVadesizTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVadesizTemizleActionPerformed
        // TODO add your handling code here:
        bosaltHesapForm();
    }//GEN-LAST:event_btnVadesizTemizleActionPerformed

    private void btnVadesizHesapSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVadesizHesapSilActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = this.getHesapTableModel();
        if (model.getRowCount() == -1 || formVadesizAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtHesapMusteriNo.getText()));
            Sonuc silmeKontrol = musteri.hesapSil(Integer.parseInt(txtHesapIban.getText()));
            if (silmeKontrol.getBasariliMi()) {
                islemBasarili();
                doldurHesapTablo(Integer.parseInt(txtHesapMusteriNo.getText()));
                bosaltHesapForm();
            } else {
                mesajGoster(silmeKontrol.getHataMesaji(), "HATA");
            }
        }
    }//GEN-LAST:event_btnVadesizHesapSilActionPerformed

    private void btnKartBorcuOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKartBorcuOdeActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtHesapIban.getText())) {
            mesajGoster("Bir kredi kartı borcunu ödeyebilmeniz için bir hesap seçmeniz gerekmektedir.", "Hata");
        }
        KrediKartiBorcuOdePanel panel = new KrediKartiBorcuOdePanel(Integer.parseInt(txtHesapIban.getText()));
        panel.setVisible(true);
    }//GEN-LAST:event_btnKartBorcuOdeActionPerformed

    private void btnParaTransferiYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaTransferiYapActionPerformed
        // TODO add your handling code here:
        ParaTransferiPanel panel = new ParaTransferiPanel();
        panel.setVisible(true);
    }//GEN-LAST:event_btnParaTransferiYapActionPerformed

    private void btnYatirimAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYatirimAraActionPerformed
        // TODO add your handling code here:

        if ("".equals(String.valueOf(txtYatirimMusteriNo.getText()))) {
            alanlarBosGecilemez();
        } else {
            if (bankaPersoneli.musteriVarmi(Integer.parseInt(txtYatirimMusteriNo.getText()))) {
                yatirimFiltreAc(Integer.parseInt(txtYatirimMusteriNo.getText()));
                doldurYatirimTablo(Integer.parseInt(txtYatirimMusteriNo.getText()));
            } else {
                musteriNoBulunamadi(Integer.parseInt(txtYatirimMusteriNo.getText()));
            }
        }
    }//GEN-LAST:event_btnYatirimAraActionPerformed

    private void btnYatirimKaldirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYatirimKaldirActionPerformed
        // TODO add your handling code here:
        bosaltYatirimForm();
        txtYatirimMusteriNo.setText("");
        yatirimFiltreGizle();
        bosaltYatirimTablo();
    }//GEN-LAST:event_btnYatirimKaldirActionPerformed

    private void tableYatirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableYatirimMouseClicked
        // TODO add your handling code here:
        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        
        txtYatirimIban.setText(table.getModel().getValueAt(row, 0) + "");
        txtYatirimBakiye.setText(table.getModel().getValueAt(row, 1) + "");
    }//GEN-LAST:event_tableYatirimMouseClicked

    private void btnYatirimHesapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYatirimHesapEkleActionPerformed
        // TODO add your handling code here:

        if (formYatirimAlanKontrol()) {
            alanlarBosGecilemez();
        } else {
            
            DefaultTableModel model = getYatirimTableModel();
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtYatirimMusteriNo.getText()));
            
            musteri.HesapEkle(Double.parseDouble(txtYatirimBakiye.getText()), "YATIRIM", Integer.parseInt(txtYatirimMusteriNo.getText()));
            islemBasarili();
            doldurYatirimTablo(Integer.parseInt(txtYatirimMusteriNo.getText()));
            bosaltYatirimForm();
            
        }
    }//GEN-LAST:event_btnYatirimHesapEkleActionPerformed

    private void btnYatirimHesapSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYatirimHesapSilActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = this.getYatirimTableModel();
        if (model.getRowCount() == -1 || formYatirimAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            
            Musteri musteri = BankaPersoneli.getirMusteriNumaraIle(Integer.parseInt(txtYatirimMusteriNo.getText()));
            Sonuc silmeKontrol = musteri.hesapSil(Integer.parseInt(txtYatirimIban.getText()));
            if (silmeKontrol.getBasariliMi()) {
                islemBasarili();
                doldurYatirimTablo(Integer.parseInt(txtYatirimMusteriNo.getText()));
                bosaltYatirimForm();
            } else {
                mesajGoster(silmeKontrol.getHataMesaji(), "HATA");
            }
        }
    }//GEN-LAST:event_btnYatirimHesapSilActionPerformed

    private void btnYatirimTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYatirimTemizleActionPerformed
        // TODO add your handling code here:
        bosaltYatirimForm();
    }//GEN-LAST:event_btnYatirimTemizleActionPerformed

    private void btnParaCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaCekActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = this.getYatirimTableModel();
        if (model.getRowCount() == -1 || formYatirimAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            ParaCekPanel panel = new ParaCekPanel(Integer.parseInt(txtYatirimIban.getText()));
            panel.setVisible(true);
        }
    }//GEN-LAST:event_btnParaCekActionPerformed

    private void btnParaEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaEkleActionPerformed
        // TODO add your handling code here:
            DefaultTableModel model = this.getYatirimTableModel();
        if (model.getRowCount() == -1 || formYatirimAlanKontrol()) {
            alanlarBosYadaSecilmemis();
        } else {
            ParaEklePanel panel = new ParaEklePanel(Integer.parseInt(txtYatirimIban.getText()));
            panel.setVisible(true);
        }
        
    }//GEN-LAST:event_btnParaEkleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHesapMusteriAramaKaldir;
    private javax.swing.JButton btnHesapMusteriNoAra;
    private javax.swing.JButton btnKartBorcuOde;
    private javax.swing.JButton btnKrediKartiSil;
    private javax.swing.JButton btnKrediKartiTemizle;
    private javax.swing.JButton btnKrediKartıEkle;
    private javax.swing.JButton btnMusteriAramaKaldir;
    private javax.swing.JButton btnMusteriDuzenle;
    private javax.swing.JButton btnMusteriEkle;
    private javax.swing.JButton btnMusteriNoAra;
    private javax.swing.JButton btnMusteriSil;
    private javax.swing.JButton btnParaCek;
    private javax.swing.JButton btnParaEkle;
    private javax.swing.JButton btnParaTransferiYap;
    private javax.swing.JButton btnTemizle;
    private javax.swing.JButton btnVadesizHesapEkle;
    private javax.swing.JButton btnVadesizHesapSil;
    private javax.swing.JButton btnVadesizTemizle;
    private javax.swing.JButton btnYatirimAra;
    private javax.swing.JButton btnYatirimHesapEkle;
    private javax.swing.JButton btnYatirimHesapSil;
    private javax.swing.JButton btnYatirimKaldir;
    private javax.swing.JButton btnYatirimTemizle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHesapMusteriNo;
    private javax.swing.JLabel lblMusteriNo;
    private javax.swing.JLabel lblYatirim;
    private javax.swing.JOptionPane musteriOptionPane;
    private javax.swing.JTable tableHesap;
    private javax.swing.JTable tableKrediKarti;
    private javax.swing.JTable tableMusteri;
    private javax.swing.JTable tableYatirim;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtGuncelBorc;
    private javax.swing.JTextField txtHesapBakiye;
    private javax.swing.JTextField txtHesapIban;
    private javax.swing.JTextField txtHesapMusteriNo;
    private javax.swing.JTextField txtKartNumarasi;
    private javax.swing.JTextField txtKrediMusteriNo;
    private javax.swing.JTextField txtKullanılabilirLimit;
    private javax.swing.JTextField txtLimit;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMusteriNo;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtYatirimBakiye;
    private javax.swing.JTextField txtYatirimIban;
    private javax.swing.JTextField txtYatirimMusteriNo;
    // End of variables declaration//GEN-END:variables
}
