package storejava.dal.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "zones", schema = "store_java")
public class Zones implements Serializable{
    private Integer id;
    private Cities cities;
    private String name;
    private Set<Branches> branches = new HashSet<>(0);

    public Zones() {
    }

//    public Zones(Integer id) {
//        this.id = id;
//    }
//    
    
    
    @Id
    @GeneratedValue (strategy = IDENTITY)
    @Column (name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "city_id", nullable = false)
    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }
    
    @Column (name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "zones")
    public Set<Branches> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branches> branches) {
        this.branches = branches;
    }
    
    
}
