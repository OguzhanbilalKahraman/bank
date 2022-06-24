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
public class BankaHesabi {

    private int iban;
    private double bakiye;
    private int musteriNo;

    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public int getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo(int musteriNo) {
        this.musteriNo = musteriNo;
    }

}
