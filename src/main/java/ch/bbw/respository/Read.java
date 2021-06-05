package ch.bbw.respository;

import ch.bbw.*;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Read {

    EntityManager em;

    public Read(EntityManager em) {
        this.em = em;
    }


    public void Kunde(){
        @SuppressWarnings("unchecked")
        List<Kunde> listKunden = em.createNamedQuery("Kunde.findAll").getResultList();
        listReader(listKunden);
    }

    public void Ort(){
        @SuppressWarnings("unchecked")
        List<Ort> listOrte = em.createNamedQuery("Ort.findAll").getResultList();
        listReader(listOrte);
    }

    public void Land(){
        @SuppressWarnings("unchecked")
        List<Land> listLand = em.createNamedQuery("Land.findAll").getResultList();
        System.out.println(listLand.toString());
    }

    public void Gegenstand(){
        @SuppressWarnings("unchecked")
        List<Gegenstand> listGegenstand = em.createNamedQuery("Gegenstand.findAll").getResultList();
        System.out.println(listGegenstand.toString());
    }

    public void Einkauf(){
        @SuppressWarnings("unchecked")
        List<Gegenstand> g = em.createNamedQuery("Gegenstand.findAll").getResultList();
        List<Kunde> k = em.createNamedQuery("Kunde.findAll").getResultList();
        List<Gegenstand> output = new ArrayList<>();

        for (Kunde kunde : k){
            int preis = 0;
            for (Gegenstand gl : kunde.getGegenstaende()){
                preis += gl.getPreis();
            }
            System.out.println(kunde.getNachname() + " besitzt:");
            listReader(kunde.getGegenstaende());

            System.out.println("Totale Kosten: " + preis + "\n\n");
        }



    }




    private void listReader(List myList){
        if (myList.isEmpty()){
            System.out.println("Liste ist leer!");
        } else{
            myList.forEach(System.out::println);
        }
    }
}
