package ch.bbw.respository;

import ch.bbw.*;


import javax.persistence.EntityManager;

public class Create {

    EntityManager em;

    public Create(EntityManager em) {
        this.em = em;
    }

    public void Kunde(int id, String vn, String nn, Ort ort, int jahrg) {

        Kunde kunde = new Kunde();
        kunde.setKunde_ID(id);
        kunde.setVorname(vn);
        kunde.setNachname(nn);
        kunde.setOrt(ort);
        kunde.setJahrgang(jahrg);
        em.persist(kunde);
        //entityManager.getTransaction().commit();
    }

    public void Ort(int id, String name, Land land) {
        Ort ort = new Ort();
        ort.setOrt_ID(id);
        ort.setOrtsname(name);
        ort.setLand_IDFS(land);
        em.persist(ort);
    }

    public void Land(int id, String name){
        Land land = new Land();
        land.setLand_ID(id);
        land.setLandname(name);
        em.persist(land);
    }

    public void Gegenstand(int id, String name, int preis){
        Gegenstand gegenstand = new Gegenstand();
        gegenstand.setGegenstand_ID(id);
        gegenstand.setBezeichnung(name);
        gegenstand.setPreis(preis);
        em.persist(gegenstand);
    }

    public void KundeGegnstand(int idkunde, int idgegenstand){
        Kunde kunde = em.find(Kunde.class, idkunde);
        Gegenstand gegenstand = em.find(Gegenstand.class, idgegenstand);

        kunde.getGegenstaende().add(gegenstand);
        gegenstand.getKunden().add(kunde);
    }


}
