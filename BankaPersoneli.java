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
public class BankaPersoneli extends Kisi {

    private int personelID;
    private static ArrayList<Musteri> musteriler;

    private void musteriListesiOlustur() {
        BankaPersoneli.musteriler = new ArrayList<>();
        Musteri musteri1 = new Musteri("Oğuzhan", "Kahraman", "oguz@mail.com", "555555555");
        musteri1.setMusteriNumarasi(111);
        Musteri musteri2 = new Musteri("Oğuzhan2", "Kahraman2", "oguz2@mail.com", "555555555");
        musteri2.setMusteriNumarasi(112);

        musteriler.add(musteri1);
        musteriler.add(musteri2);
    }

    public ArrayList<Musteri> getMusteriler() {
        return BankaPersoneli.musteriler;
    }

    public BankaPersoneli(String ad, String soyad, String email, String telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriListesiOlustur();
    }

    public int getPersonelID() {
        return personelID;
    }

    public void setPersonelID(int personelID) {
        this.personelID = personelID;
    }

    //Benzersiz müşteri numarası üretmek için... eğer listede eleman yoksa, müşteri classından üretilmiş olan
    // müşteri numarasını döner.
    private int numaraKontrol(int musteriNo) {

        int index = 0;
        while (index < getMusteriler().size()) {

            Musteri bulunanMusteri = getMusteriler().get(index);
            index++;
            if (bulunanMusteri.getMusteriNumarasi() != musteriNo) {
                break;
            } else {
                musteriNo = (int) (Math.random() * 1000 + 1);

                if (index == getMusteriler().size() - 1) {
                    index = 0;
                }
            }
        }

        return musteriNo;
    }

    // benzersiz bir müşteri numarası ile ekleme yapar.
    public boolean ekleMusteri(Musteri musteri) {
        int musteriNo = Musteri.uretMusteriNumarasi();
        int benzersizMusteriNo;
        benzersizMusteriNo = numaraKontrol(musteriNo);

        musteri.setMusteriNumarasi(benzersizMusteriNo);

        boolean control = BankaPersoneli.musteriler.add(musteri);
        return control;
    }

    public boolean guncelleMusteri(Musteri musteri) {
        ArrayList<Musteri> list = BankaPersoneli.musteriler;

        //tüm listede döner, ilgili kaydı benzersiz müşteri numarasına göre bulur. Eğer varsa güncelleme gerçekleşir
        //yoksa gerçekleşmez.
        for (int i = 0; i < list.size(); i++) {
            Musteri bulunanMusteri = list.get(i);
            if (bulunanMusteri.getMusteriNumarasi() == musteri.getMusteriNumarasi()) {
                Musteri set = BankaPersoneli.musteriler.set(i, musteri);
                return true;
            }
        }
        return false;
    }

    public boolean silMusteri(Musteri musteri) {
        ArrayList<Musteri> list = BankaPersoneli.musteriler;
        //tüm listede döner, ilgili kaydı benzersiz müşteri numarasına göre bulur. Eğer varsa silme gerçekleşir
        //yoksa gerçekleşmez.
        for (int i = 0; i < list.size(); i++) {
            Musteri bulunanMusteri = list.get(i);
            if (bulunanMusteri.getMusteriNumarasi() == musteri.getMusteriNumarasi()) {
                BankaPersoneli.musteriler.remove(i);
                return true;
            }
        }

        return false;
    }

    public static Musteri getirMusteriNumaraIle(int musteriNo) {

        if (BankaPersoneli.musteriler == null) {
            BankaPersoneli.musteriler = new ArrayList<>();
            Musteri musteri1 = new Musteri("Oğuzhan", "Kahraman", "oguz@mail.com", "555555555");
            musteri1.setMusteriNumarasi(111);
            Musteri musteri2 = new Musteri("Oğuzhan2", "Kahraman2", "oguz2@mail.com", "555555555");
            musteri2.setMusteriNumarasi(112);

            musteriler.add(musteri1);
            musteriler.add(musteri2);
        }
        //tüm listede döner, ilgili kaydı benzersiz musteri numarasına göre arar. Eğer varsa true yoksa false döner
        for (int i = 0; i < BankaPersoneli.musteriler.size(); i++) {
            Musteri bulunanMusteri = BankaPersoneli.musteriler.get(i);
            if (bulunanMusteri.getMusteriNumarasi() == musteriNo) {
                return bulunanMusteri;
            }
        }
        return null;
    }

    public boolean musteriVarmi(int musteriNo) {
        //tüm listede döner, ilgili kaydı benzersiz musteri numarasına göre arar. Eğer varsa true yoksa false döner
        for (int i = 0; i < BankaPersoneli.musteriler.size(); i++) {
            Musteri bulunanMusteri = BankaPersoneli.musteriler.get(i);
            if (bulunanMusteri.getMusteriNumarasi() == musteriNo) {
                return true;
            }
        }
        return false;
    }

}
