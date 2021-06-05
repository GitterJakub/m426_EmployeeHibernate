package ch.bbw.respository;

import ch.bbw.*;

import javax.persistence.EntityManager;

public class Delete {
    EntityManager em;

    public Delete(EntityManager em) {
        this.em = em;
    }

    public void Kunde(int id){
        Kunde kunde = em.find(Kunde.class, id);
        em.remove(kunde);
    }

    public void Ort(int id){
        Ort ort = em.find(Ort.class, id);
        em.remove(ort);
    }

    public void Land(int id){
        Land land = em.find(Land.class, id);
        em.remove(land);
    }

    public void Gegenstand(int id){
        Gegenstand gegenstand = em.find(Gegenstand.class, id);
        em.remove(gegenstand);
    }

    public void KundeGegenstand(int idkunde, int idgegenstand){
        Kunde kunde = em.find(Kunde.class, idkunde);
        Gegenstand gegenstand = em.find(Gegenstand.class, idgegenstand);
        kunde.getGegenstaende().remove(gegenstand);
        gegenstand.getKunden().remove(kunde);
    }
}
