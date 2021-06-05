package ch.bbw;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Gegenstand")
@NamedQuery(name = "Gegenstand.findAll", query = "SELECT e FROM Gegenstand e")
public class Gegenstand {

    @Column(name = "Bezeichnung")
    private String Bezeichnung;

    @Column(name = "Preis")
    private int Preis;

    @Id
    @Column(name = "Gegenstand_ID", unique = true)
    private int Gegenstand_ID;

    @ManyToMany(mappedBy = "gegenstaende", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Kunde> kunden;

    public String getBezeichnung() {
        return Bezeichnung;
    }

    @Override
    public String toString() {
        return "[ Gegenstand_ID: " + Gegenstand_ID + " Bezeichnung: " + Bezeichnung + " Preis: " + Preis + " ]";
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public int getPreis() {
        return Preis;
    }

    public void setPreis(int preis) {
        Preis = preis;
    }

    public int getGegenstand_ID() {
        return Gegenstand_ID;
    }

    public void setGegenstand_ID(int gegenstand_ID) {
        Gegenstand_ID = gegenstand_ID;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(List<Kunde> kunden) {
        this.kunden = kunden;
    }
}
