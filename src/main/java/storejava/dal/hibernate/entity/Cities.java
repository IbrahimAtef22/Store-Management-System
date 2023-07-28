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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "cities", schema = "store_java", uniqueConstraints = @UniqueConstraint (columnNames = "name"))
public class Cities implements Serializable{
    private Integer id;
    private String name;
    private Set<Zones> zones = new HashSet<>(0);

    public Cities() {
    }

//    public Cities(Integer id) {
//        this.id = id;
//    }
//
//    public Cities(String name) {
//        this.name = name;
//    }
//
//    public Cities(Integer id, String name) {
//        this.id = id;
//        this.name = name;
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
    
    @Column (name = "name", unique = true, nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "cities")
    public Set<Zones> getZones() {
        return zones;
    }

    public void setZones(Set<Zones> zones) {
        this.zones = zones;
    }
    
    
}
