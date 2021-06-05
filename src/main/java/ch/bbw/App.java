package ch.bbw;

import ch.bbw.demo.Employee;
import ch.bbw.respository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Main Class
 * @author Jakub Baranec
 * @version 15.04.2021
 * */

public class App {


    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("KundePersistanceUnit");
        EntityManager entitymanager = emfactory.createEntityManager();

        System.out.println("Shopping starts..");
        entitymanager.getTransaction().begin();
        Create c = new Create(entitymanager);
        //c.Kunde(1, "Simon", "Schopmann", entitymanager.find(Ort.class, 8400), 1999);
        //c.createOrt(8400, "Winterthur", 1);
        //c.KundeGegnstand(2,3);
        //c.Gegenstand(1, "Johgurt", 2);
        /*c.Gegenstand(4, "Bier", 5);
        c.Gegenstand(5, "Brot", 3);
        c.Kunde(3, "Simon", "Hirscher", entitymanager.find(Ort.class, 8400), 1989);
        c.Land(2, "Deutschland");
        c.Ort(77451, "Hamburg", entitymanager.find(Land.class, 2));
        c.Ort(33096, "München", entitymanager.find(Land.class, 2));
        c.Kunde(4, "Thomas", "Meier", entitymanager.find(Ort.class, 77451), 1977);
        c.Kunde(5, "Marco", "Hauser", entitymanager.find(Ort.class, 77451), 1987);*/
        //c.KundeGegnstand(1,2);
        //c.Ort(8477, "Oberstammheim", entitymanager.find(Land.class, 1));


        Update u = new Update(entitymanager);
        //u.updateKunde(2, "Timon", "Hoffmann", 8400, 2003);

        Delete d = new Delete(entitymanager);
        //d.deleteKunde(3);

        Find f = new Find(entitymanager);
        //f.findKunde(2);


        //d.KundeGegenstand(1,1);
        entitymanager.getTransaction().commit();

        //f.KundeGegenstand(1);




        Read read = new Read(entitymanager);
        //read.Kunde();
        //read.Ort();
        //read.Land();
        //read.Einkauf();


        entitymanager.close();
        emfactory.close();
        System.out.println("EntityManager passed");
    }
}
