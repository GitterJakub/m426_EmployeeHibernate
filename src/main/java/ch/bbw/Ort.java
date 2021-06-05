package ch.bbw;

import javax.persistence.*;

@Entity
@Table(name = "Ort")
@NamedQuery(name = "Ort.findAll", query = "SELECT e FROM Ort e")
public class Ort {
    @Column(name = "Ortsname")
    private String Ortsname;

    @Id
    @Column(name = "Ort_ID", unique = true)
    private int Ort_ID;

    @ManyToOne
    @JoinColumn(name = "Land_IDFS")
    Land Land_IDFS;

    @Override
    public String toString() {
        return "[" + " Ortsname: " + Ortsname + " Ort_ID: " + Ort_ID + " Land: " + Land_IDFS.getLandname() + "]";
    }

    public String getOrtsname() {
        return Ortsname;
    }

    public void setOrtsname(String ortsname) {
        Ortsname = ortsname;
    }

    public int getOrt_ID() {
        return Ort_ID;
    }

    public void setOrt_ID(int ort_ID) {
        Ort_ID = ort_ID;
    }

    public Land getLand_IDFS() {
        return Land_IDFS;
    }

    public void setLand_IDFS(Land land_IDFS) {
        Land_IDFS = land_IDFS;
    }
}
