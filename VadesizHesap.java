/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeOdev;

/**
 *
 * @author oguzh
 */
public class VadesizHesap extends BankaHesabi {

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public VadesizHesap(double bakiye) {
        super(bakiye);
    }

    private String hesapTuru;

    public static int uretIbanNo() {
        return (int) (Math.random() * 10000 + 10);
    }

    public static Sonuc krediKartiBorcuOde(int iban, int kartNumarasi, double tutar) {
        VadesizHesap vadesizHesap = Musteri.getirVadesizIbanIle(iban);
        if (vadesizHesap == null) {
            return new Sonuc(iban + " numaralı bir vadesiz hesap bulunmamaktadır");
        }
        if (vadesizHesap.getBakiye() < tutar) {
            return new Sonuc("Hesabınızda yazmış olduğunuz tutar kadar para yok");
        }
        KrediKarti krediKarti = Musteri.getirKrediKartiKartNoIle(kartNumarasi);
        if (krediKarti == null) {
            return new Sonuc(kartNumarasi + " numaralı bir kredi karti bulunmamaktadır");
        }
        if (tutar > krediKarti.getGuncelBorc()) {
            return new Sonuc("tutar borcunuzdan yüksek olamaz");
        }
        vadesizHesap.setBakiye(vadesizHesap.getBakiye() - tutar);
        krediKarti.setGuncelBorc(krediKarti.getGuncelBorc() - tutar);
        krediKarti.setKullanilabilirLimit(krediKarti.getKullanilabilirLimit() + tutar);
        return new Sonuc();
    }

    /* 
     Alici => vadesiz ve yatirim
     gonderen => vadesiz ve yatirim
    
     */
    public static Sonuc paraTransferi(int aliciHesap, int gonderenHesap, double tutar) {
        YatirimHesabi aliciYatirim = Musteri.getirYatirimIbanIle(aliciHesap);
        YatirimHesabi gondericiYatirim = Musteri.getirYatirimIbanIle(gonderenHesap);
        VadesizHesap aliciVadesiz = Musteri.getirVadesizIbanIle(aliciHesap);
        VadesizHesap gondericiVadesiz = Musteri.getirVadesizIbanIle(gonderenHesap);

        /* 
        alicinin yatirim 
        gondericinin yatirim 
         */
        if (aliciYatirim != null && gondericiYatirim != null && aliciVadesiz == null && gondericiVadesiz == null) {
            if (gondericiYatirim.getBakiye() >= tutar) {
                aliciYatirim.setBakiye(aliciYatirim.getBakiye() + tutar);
                gondericiYatirim.setBakiye(gondericiYatirim.getBakiye() - tutar);
                return new Sonuc();
            } else {
                return new Sonuc("gönderici hesaptaki tutar, bakiye tutarından daha fazla olamaz.");
            }

        }
        /* 
        alıcı yatırım 
        gonderici vadesiz
         */
        if (aliciYatirim != null && gondericiYatirim == null && aliciVadesiz == null && gondericiVadesiz != null) {
            if (gondericiVadesiz.getBakiye() >= tutar) {
                aliciYatirim.setBakiye(aliciYatirim.getBakiye() + tutar);
                gondericiVadesiz.setBakiye(gondericiVadesiz.getBakiye() - tutar);
                return new Sonuc();
            } else {
                return new Sonuc("gönderici hesaptaki tutar, bakiye tutarından daha fazla olamaz.");
            }

        }

        /* alıcı vadesiz gonderici vadesiz */
        if (aliciYatirim == null && gondericiYatirim == null && aliciVadesiz != null && gondericiVadesiz != null) {
            if (gondericiVadesiz.getBakiye() >= tutar) {
                aliciVadesiz.setBakiye(aliciVadesiz.getBakiye() + tutar);
                gondericiVadesiz.setBakiye(gondericiVadesiz.getBakiye() - tutar);
                return new Sonuc();
            } else {
                return new Sonuc("gönderici hesaptaki tutar, bakiye tutarından daha fazla olamaz.");
            }
        }

        /*alici vadesiz gonderici yatirim */
        if (aliciYatirim == null && gondericiYatirim != null && aliciVadesiz != null && gondericiVadesiz == null) {
            if (gondericiVadesiz.getBakiye() >= tutar) {
                aliciVadesiz.setBakiye(aliciVadesiz.getBakiye() + tutar);
                gondericiYatirim.setBakiye(gondericiYatirim.getBakiye() - tutar);
                return new Sonuc();
            } else {
                return new Sonuc("gönderici hesaptaki tutar, bakiye tutarından daha fazla olamaz.");
            }

        }

        return new Sonuc("Belirtilen iban numalarına sahip hesap bulunamadı");
    }
}
