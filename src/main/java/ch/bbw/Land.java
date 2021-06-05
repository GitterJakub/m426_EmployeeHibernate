package ch.bbw;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Land")
@NamedQuery(name = "Land.findAll", query = "SELECT e FROM Land e")
public class Land {
    @Column(name = "Landname")
    private String Landname;
    @Id
    @Column(name = "Land_ID", unique = true)
    private int Land_ID;

    @OneToMany(mappedBy = "Land_IDFS")
    private List<Ort> orte;

    @Override
    public String toString(){
        String tmp = "Verfügbare Orte:\n";
        for (Ort o : getOrte()){
            tmp += o.toString() + "\n";
        }
        return "[ Landname: " + Landname + " Land_ID: " + Land_ID + " ]\n" + tmp;
    }

    public String getLandname() {
        return Landname;
    }

    public void setLandname(String landname) {
        Landname = landname;
    }

    public int getLand_ID() {
        return Land_ID;
    }

    public void setLand_ID(int land_ID) {
        Land_ID = land_ID;
    }

    public List<Ort> getOrte() {
        return orte;
    }
}
