package storejava.dal.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "branches", schema = "store_java")
public class Branches implements Serializable{
    private Integer id;
    private Zones zones;
    private String name;
    private String building;
    private String streetName;
    private String telephone;
    private Date workingStart;
    private Date workingEnd;

    public Branches() {
    }

//    public Branches(Integer id) {
//        this.id = id;
//    }
    
    
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
    @JoinColumn (name = "zone_id", nullable = false)
    public Zones getZones() {
        return zones;
    }

    public void setZones(Zones zones) {
        this.zones = zones;
    }
    
    @Column (name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "building", nullable = false, length = 50)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column (name = "street_name", nullable = false, length = 100)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Column (name = "telephone", nullable = false, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Temporal (TemporalType.TIME)
    @Column (name = "working_start", nullable = false, length = 8)
    public Date getWorkingStart() {
        return workingStart;
    }

    public void setWorkingStart(Date workingStart) {
        this.workingStart = workingStart;
    }

    @Temporal (TemporalType.TIME)
    @Column (name = "working_end", nullable = false, length = 8)
    public Date getWorkingEnd() {
        return workingEnd;
    }

    public void setWorkingEnd(Date workingEnd) {
        this.workingEnd = workingEnd;
    }
    
    
}
