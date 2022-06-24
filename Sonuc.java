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
public class Sonuc {

    // direk nesne örneği alırsam bu iş başarılı sonuçlanmıştır.
    public Sonuc() {
        this.basariliMi = true;
    }

    // bir hata mesajı ile örnek alıyorsam bu iş başarısız sonuçlanmıştır.
    public Sonuc(String hataMesaji) {
        this.basariliMi = false;
        this.hataMesaji = hataMesaji;
    }

    public boolean getBasariliMi() {
        return this.basariliMi;
    }

    public void setBasariliMi(boolean basariliMi) {
        this.basariliMi = basariliMi;
    }

    public String getHataMesaji() {
        return hataMesaji;
    }

    public void setHataMesaji(String hataMesaji) {
        this.hataMesaji = hataMesaji;
    }
    private boolean basariliMi;
    private String hataMesaji;
}
