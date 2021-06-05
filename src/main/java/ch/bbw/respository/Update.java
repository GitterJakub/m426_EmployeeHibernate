package ch.bbw.respository;

import ch.bbw.*;

import javax.persistence.EntityManager;
import java.util.List;

public class Update {

    EntityManager em;

    public Update(EntityManager em) {
        this.em = em;
    }

    public void Kunde(int id, String vm, String nn, Ort ort, int jahrg){
        Kunde kunde = em.find(Kunde.class, id);
        kunde.setVorname(vm);
        kunde.setNachname(nn);
        kunde.setOrt(ort);
        kunde.setJahrgang(jahrg);
    }

    public void Ort(int id, String name, Land land){
        Ort ort = em.find(Ort.class, id);
        ort.setOrtsname(name);
        ort.setLand_IDFS(land);
    }

    public void Land(int id, String name){
        Land land = em.find(Land.class, id);
        land.setLandname(name);
    }

    public void Gegenstand(int id, String bezeichnung, int preis, List<Kunde> kunden){
        Gegenstand gegenstand = em.find(Gegenstand.class, id);
        gegenstand.setPreis(preis);
        gegenstand.setBezeichnung(bezeichnung);
        gegenstand.setKunden(kunden);
    }
}

