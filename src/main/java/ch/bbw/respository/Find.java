package ch.bbw.respository;

import ch.bbw.*;

import javax.persistence.EntityManager;

public class Find {
    EntityManager em;

    public Find(EntityManager em) {
        this.em = em;
    }

    public void Kunde(int id) {
        Kunde kunde = em.find(Kunde.class, id);
        System.out.println(kunde.toString());
    }
    public void Ort(int id) {
        Ort ort = em.find(Ort.class, id);
        System.out.println(ort.toString());
    }

    public void Land(int id) {
        Land land = em.find(Land.class, id);
        System.out.println(land.toString());
    }

    public void Gegenstand(int id){
        Gegenstand gegenstand = em.find(Gegenstand.class, id);
        System.out.println(gegenstand.toString());
    }

    public void KundeGegenstand(int idkunde){
        Kunde kunde = em.find(Kunde.class, idkunde);
        System.out.println(kunde.getNachname() + " besitzt: ");
        System.out.println(kunde.getGegenstaende().toString());
        int preis = 0;
        for (Gegenstand a : kunde.getGegenstaende()){
            preis += a.getPreis();
        }
        System.out.println("Seine Totale Kosten: " + preis);
    }

    public void GegnstandKunde(int idgegstand){
        Gegenstand gegenstand = em.find(Gegenstand.class, idgegstand);
        System.out.println(gegenstand.getKunden().toString());
    }
}
