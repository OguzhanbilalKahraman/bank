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
public class KrediKarti{

    private int kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;
    private int musteriNo;

    public KrediKarti(double limit, double guncelBorc){
        this.limit=limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit-guncelBorc;
    }
    
    public int getMusteriNo() {
        return this.musteriNo;
    }
    
    public void setMusteriNo(int musteriNo){
        this.musteriNo = musteriNo;
    }

    public int getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(int kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getGuncelBorc() {
        return guncelBorc;
    }

    public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
    }

    public double getKullanilabilirLimit() {
        return kullanilabilirLimit;
    }

    public void setKullanilabilirLimit(double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
    }

    public static int uretKrediKartiNumarasi() {
        return (int) (Math.random() * 10000 + 10);
    }
}
