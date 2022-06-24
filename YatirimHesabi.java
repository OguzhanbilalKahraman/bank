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
public class YatirimHesabi extends BankaHesabi {

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public YatirimHesabi(double bakiye) {
        super(bakiye);
    }

    private String hesapTuru;

    public static int uretIbanNo() {
        return (int) (Math.random() * 10000 + 10);
    }

    public static Sonuc paraCek(int ibanNo, double tutar) {

        YatirimHesabi yatirimHesabi = Musteri.getirYatirimIbanIle(ibanNo);
        if (yatirimHesabi != null) {
            if (yatirimHesabi.getBakiye() < tutar) {
                return new Sonuc("çekmek istediğiniz tutar, bakiyenizden çok olamaz");
            } else {
                yatirimHesabi.setBakiye(yatirimHesabi.getBakiye() - tutar);
                return new Sonuc();
            }
        } else {
            return new Sonuc(ibanNo + " numarasına ait bir hesap bulunamadi");
        }

    }

    public static Sonuc paraEkle(int ibanNo, double tutar) {

        YatirimHesabi yatirimHesabi = Musteri.getirYatirimIbanIle(ibanNo);

        if (yatirimHesabi != null) {
            yatirimHesabi.setBakiye(yatirimHesabi.getBakiye() + tutar);
            return new Sonuc();
        } else {
            return new Sonuc(ibanNo + " numarasına ait bir hesap bulunamadi");
        }
    }
}
