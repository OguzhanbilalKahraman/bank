/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeOdev;

import java.util.ArrayList;

/**
 *
 * @author oguzh
 */
public class Musteri extends Kisi {

    public static ArrayList<YatirimHesabi> getYatirimHesaplari() {
        if (Musteri.yatirimHesaplari == null) {
            yatirimHesapListesiOlustur();
        }
        return yatirimHesaplari;
    }

    public static ArrayList<VadesizHesap> getVadesizHesaplar() {
        if (Musteri.vadesizHesaplar == null) {
            vadesizHesapListesiOlustur();
        }
        return vadesizHesaplar;
    }

    public Musteri(String ad, String soyad, String email, String telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
    }

    private static void krediKartiListesiOlustur() {
        Musteri.krediKartlari = new ArrayList<>();
        KrediKarti kart1 = new KrediKarti(10000, 2000);
        kart1.setMusteriNo(111);
        kart1.setKartNumarasi(123123);
        KrediKarti kart2 = new KrediKarti(12000, 0);
        kart2.setMusteriNo(111);
        kart2.setKartNumarasi(124124);
        KrediKarti kart3 = new KrediKarti(50000, 43000);
        kart3.setMusteriNo(112);
        kart3.setKartNumarasi(125125);
        KrediKarti kart4 = new KrediKarti(12000, 9000);
        kart4.setMusteriNo(112);
        kart4.setKartNumarasi(126126);
        Musteri.krediKartlari.add(kart1);
        Musteri.krediKartlari.add(kart2);
        Musteri.krediKartlari.add(kart3);
        Musteri.krediKartlari.add(kart4);
    }

    private static void vadesizHesapListesiOlustur() {
        Musteri.vadesizHesaplar = new ArrayList<>();
        VadesizHesap hesap1 = new VadesizHesap(234234);
        hesap1.setMusteriNo(111);
        hesap1.setIban(47474747);
        hesap1.setHesapTuru("VADESİZ");

        VadesizHesap hesap2 = new VadesizHesap(101231);
        hesap2.setMusteriNo(111);
        hesap2.setIban(47474746);
        hesap2.setHesapTuru("VADESİZ");

        VadesizHesap hesap3 = new VadesizHesap(342342);
        hesap3.setMusteriNo(112);
        hesap3.setIban(47474745);
        hesap3.setHesapTuru("VADESİZ");

        VadesizHesap hesap4 = new VadesizHesap(12312);
        hesap4.setMusteriNo(112);
        hesap4.setIban(47474744);
        hesap4.setHesapTuru("VADESİZ");

        Musteri.getVadesizHesaplar().add(hesap1);
        Musteri.getVadesizHesaplar().add(hesap2);
        Musteri.getVadesizHesaplar().add(hesap3);
        Musteri.getVadesizHesaplar().add(hesap4);
    }

    private static void yatirimHesapListesiOlustur() {
        Musteri.yatirimHesaplari = new ArrayList<>();
        YatirimHesabi hesap1 = new YatirimHesabi(1000);
        hesap1.setMusteriNo(111);
        hesap1.setIban(57474747);
        hesap1.setHesapTuru("YATIRIM");

        YatirimHesabi hesap2 = new YatirimHesabi(15000);
        hesap2.setMusteriNo(111);
        hesap2.setIban(57474746);
        hesap2.setHesapTuru("YATIRIM");

        YatirimHesabi hesap3 = new YatirimHesabi(25000);
        hesap3.setMusteriNo(112);
        hesap3.setIban(57474745);
        hesap3.setHesapTuru("YATIRIM");

        YatirimHesabi hesap4 = new YatirimHesabi(30000);
        hesap4.setMusteriNo(112);
        hesap4.setIban(57474744);
        hesap4.setHesapTuru("YATIRIM");

        Musteri.getYatirimHesaplari().add(hesap1);
        Musteri.getYatirimHesaplari().add(hesap2);
        Musteri.getYatirimHesaplari().add(hesap3);
        Musteri.getYatirimHesaplari().add(hesap4);
    }

    private static ArrayList<KrediKarti> krediKartlari;

    private static ArrayList<VadesizHesap> vadesizHesaplar;

    private static ArrayList<YatirimHesabi> yatirimHesaplari;

    // eğer kredi kartı hiç yoksa ilgili kredi kartlarını ekleyip getirsin;
    private ArrayList<KrediKarti> getKrediKartlari() {
        if (Musteri.krediKartlari == null) {
            krediKartiListesiOlustur();
        }
        return Musteri.krediKartlari;
    }

    private int musteriNumarasi;

    public int getMusteriNumarasi() {
        return this.musteriNumarasi;
    }

    public void setMusteriNumarasi(int musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }

    public static int uretMusteriNumarasi() {
        return (int) (Math.random() * 1000 + 1);
    }

    public void krediKartiEkle(KrediKarti krediKarti) {
        int krediKartiNo = KrediKarti.uretKrediKartiNumarasi();
        int benzersizKrediKartiNo;
        benzersizKrediKartiNo = krediKartiNumaraKontrol(krediKartiNo);
        krediKarti.setKartNumarasi(benzersizKrediKartiNo);

        Musteri.krediKartlari.add(krediKarti);
    }

    public Sonuc silKrediKarti(int kartNumarasi) {

        //tüm listede döner, ilgili kaydı benzersiz kredikarti numarasına göre bulur. Eğer varsa silme gerçekleşir
        //yoksa gerçekleşmez.
        if (Musteri.krediKartlari != null) {
            for (int i = 0; i < Musteri.krediKartlari.size(); i++) {
                KrediKarti bulunanKrediKarti = Musteri.krediKartlari.get(i);
                if (bulunanKrediKarti.getKartNumarasi() == kartNumarasi) {
                    if (bulunanKrediKarti.getGuncelBorc() == 0) {

                        Musteri.krediKartlari.remove(i);
                        return new Sonuc();
                    } else {
                        return new Sonuc("lütfen öncelikle borç ödemesi yapınız");
                    }

                }
            }
        }
        return new Sonuc("Sistem kayıtlı kredi kardı bulunamadı");
    }

    public static ArrayList<KrediKarti> getirKrediKartlariMusteriNo(int musteriNo) {

        if (Musteri.krediKartlari == null) {
            krediKartiListesiOlustur();
        }
        ArrayList<KrediKarti> ilgiliMusteriyeAitList = new ArrayList<>();
        //tüm listede döner, ilgili kaydı müşteri numarasına göre bulur. Eğer kayıt varsa dönülecek listeye ekler.
        for (int i = 0; i < Musteri.krediKartlari.size(); i++) {
            KrediKarti bulunanKrediKarti = Musteri.krediKartlari.get(i);
            if (bulunanKrediKarti.getMusteriNo() == musteriNo) {
                ilgiliMusteriyeAitList.add(bulunanKrediKarti);

            }
        }

        return ilgiliMusteriyeAitList;
    }

    private int krediKartiNumaraKontrol(int krediKartiNo) {

        int index = 0;
        while (index < getKrediKartlari().size()) {

            KrediKarti bulunanKrediKarti = getKrediKartlari().get(index);
            index++;
            if (bulunanKrediKarti.getKartNumarasi() != krediKartiNo) {
                break;
            } else {
                krediKartiNo = (int) (Math.random() * 10000 + 10);

                if (index == getKrediKartlari().size() - 1) {
                    index = 0;
                }
            }
        }

        return krediKartiNo;
    }

    private int vadesizIcinIbanNoKontrol(int ibanNo) {

        int index = 0;
        while (index < getVadesizHesaplar().size()) {

            VadesizHesap vadesizHesap = getVadesizHesaplar().get(index);
            index++;
            if (vadesizHesap.getIban() != ibanNo) {
                break;
            } else {
                ibanNo = (int) (Math.random() * 10000 + 10);

                if (index == getKrediKartlari().size() - 1) {
                    index = 0;
                }
            }
        }

        return ibanNo;
    }

    public static ArrayList<VadesizHesap> getirVadesizHesaplarMusteriNo(int musteriNo) {

        if (Musteri.getVadesizHesaplar() == null) {
            vadesizHesapListesiOlustur();
        }
        ArrayList<VadesizHesap> ilgiliMusteriyeAitList = new ArrayList<>();
        //tüm listede döner, ilgili kaydı müşteri numarasına göre bulur. Eğer kayıt varsa dönülecek listeye ekler.
        for (int i = 0; i < Musteri.getVadesizHesaplar().size(); i++) {
            VadesizHesap bulunanVadesizHesap = Musteri.getVadesizHesaplar().get(i);
            if (bulunanVadesizHesap.getMusteriNo() == musteriNo) {
                ilgiliMusteriyeAitList.add(bulunanVadesizHesap);

            }
        }

        return ilgiliMusteriyeAitList;
    }

    public static ArrayList<YatirimHesabi> getirYatirimHesaplarMusteriNo(int musteriNo) {

        if (Musteri.getYatirimHesaplari() == null) {
            yatirimHesapListesiOlustur();
        }
        ArrayList<YatirimHesabi> ilgiliMusteriyeAitList = new ArrayList<>();
        //tüm listede döner, ilgili kaydı müşteri numarasına göre bulur. Eğer kayıt varsa dönülecek listeye ekler.
        for (int i = 0; i < Musteri.getYatirimHesaplari().size(); i++) {
            YatirimHesabi bulunanYatirimHesabi = Musteri.getYatirimHesaplari().get(i);
            if (bulunanYatirimHesabi.getMusteriNo() == musteriNo) {
                ilgiliMusteriyeAitList.add(bulunanYatirimHesabi);

            }
        }

        return ilgiliMusteriyeAitList;
    }

    // ilgili müşteriye belirtilen hesap türüne göre, bir hesap oluşturur.
    public void HesapEkle(double bakiye, String hesapTuru, int musteriNo) {
        if ("VADESİZ".equals(hesapTuru)) {
            VadesizHesap hesap = new VadesizHesap(bakiye);
            hesap.setHesapTuru(hesapTuru);
            hesap.setMusteriNo(musteriNo);

            hesap.setIban(vadesizIcinIbanNoKontrol(VadesizHesap.uretIbanNo()));
            Musteri.getVadesizHesaplar().add(hesap);
        } else {
            YatirimHesabi hesap = new YatirimHesabi(bakiye);
            hesap.setHesapTuru(hesapTuru);
            hesap.setMusteriNo(musteriNo);
            hesap.setIban(vadesizIcinIbanNoKontrol(YatirimHesabi.uretIbanNo()));
            Musteri.getYatirimHesaplari().add(hesap);
        }
    }

    public Sonuc hesapSil(int ibanNo) {
        if (Musteri.getVadesizHesaplar() == null) {
            vadesizHesapListesiOlustur();
        }
        if (Musteri.getYatirimHesaplari() == null) {
            yatirimHesapListesiOlustur();
        }
        for (int i = 0; i < Musteri.getVadesizHesaplar().size(); i++) {
            VadesizHesap bulunanVadesizHesap = Musteri.getVadesizHesaplar().get(i);
            if (bulunanVadesizHesap.getIban() == ibanNo) {
                if (bulunanVadesizHesap.getBakiye() > 0) {
                    return new Sonuc("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
                }
                Musteri.getVadesizHesaplar().remove(i);
                return new Sonuc();
            }
        }
        for (int i = 0; i < Musteri.getYatirimHesaplari().size(); i++) {
            YatirimHesabi yatirimHesabi = Musteri.getYatirimHesaplari().get(i);
            if (yatirimHesabi.getIban() == ibanNo) {
                if (yatirimHesabi.getBakiye() > 0) {
                    return new Sonuc("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
                }
                Musteri.getYatirimHesaplari().remove(i);
                return new Sonuc();
            }
        }

        return new Sonuc("Hesap bulunamadı");
    }

    public static KrediKarti getirKrediKartiKartNoIle(int kartNumarasi) {
        if (Musteri.krediKartlari == null) {
            krediKartiListesiOlustur();
        }
        //tüm listede döner, ilgili kaydı benzersiz kart numarasına göre arar. Eğer varsa kartı yoksa null döner
        for (int i = 0; i < Musteri.krediKartlari.size(); i++) {
            KrediKarti bulunanKrediKarti = Musteri.krediKartlari.get(i);
            if (bulunanKrediKarti.getKartNumarasi() == kartNumarasi) {
                return bulunanKrediKarti;
            }
        }
        return null;
    }

    public static VadesizHesap getirVadesizIbanIle(int iban) {
        if (Musteri.vadesizHesaplar == null) {
            vadesizHesapListesiOlustur();
        }

        //tüm listede döner, ilgili kaydı benzersiz iban numarasına göre arar. Eğer varsa hesabı yoksa null döner
        for (int i = 0; i < Musteri.vadesizHesaplar.size(); i++) {
            VadesizHesap vadesizHesap = Musteri.vadesizHesaplar.get(i);
            if (vadesizHesap.getIban() == iban) {
                return vadesizHesap;
            }
        }
        return null;

    }

    public static YatirimHesabi getirYatirimIbanIle(int iban) {
        if (Musteri.yatirimHesaplari == null) {
            yatirimHesapListesiOlustur();
        }

        //tüm listede döner, ilgili kaydı benzersiz iban numarasına göre arar. Eğer varsa hesabı yoksa null döner
        for (int i = 0; i < Musteri.yatirimHesaplari.size(); i++) {
            YatirimHesabi yatirimHesap = Musteri.yatirimHesaplari.get(i);
            if (yatirimHesap.getIban() == iban) {
                return yatirimHesap;
            }
        }
        return null;
    }
}
