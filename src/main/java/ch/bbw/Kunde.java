package ch.bbw;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Kunde")
@NamedQuery(name = "Kunde.findAll", query = "SELECT e FROM Kunde e")
public class Kunde {

    @Column(name = "Vorname")
    private String Vorname;
    @Column(name = "Nachname")
    private String Nachname;
    @Column(name = "Jahrgang")
    private int Jahrgang;
    @ManyToOne
    @JoinColumn(name = "Ort_IDFS")
    private Ort ort;
    @Id
    @Column(name = "Kunde_ID", unique = true)
    private int Kunde_ID;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "KundeGegenstand",
        joinColumns = {@JoinColumn(name = "Kunde_IDFS")},
        inverseJoinColumns = {@JoinColumn(name = "Gegenstand_IDFS")})
    private List<Gegenstand> gegenstaende;

    @Override
    public String toString() {
        return Vorname + " " + Nachname + " " + Jahrgang + " " + ort.getOrtsname() + " " + Kunde_ID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public int getJahrgang() {
        return Jahrgang;
    }

    public void setJahrgang(int jahrgang) {
        Jahrgang = jahrgang;
    }

    /*public int getOrt_IDFS() {
        return Ort_IDFS;
    }

    public void setOrt_IDFS(int ort_IDFS) {
        Ort_IDFS = ort_IDFS;
    }*/

    public int getKunde_ID() {
        return Kunde_ID;
    }

    public void setKunde_ID(int kunde_ID) {
        Kunde_ID = kunde_ID;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public List<Gegenstand> getGegenstaende() {
        return gegenstaende;
    }

    public void setGegenstaende(List<Gegenstand> gegenstaende) {
        this.gegenstaende = gegenstaende;
    }
}
