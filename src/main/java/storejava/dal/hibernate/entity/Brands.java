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
@Table (name = "brands", schema = "store_java", uniqueConstraints = @UniqueConstraint (columnNames = "name"))
public class Brands implements Serializable{
    private Integer id;
    private String name;
    private String logoPath;
    private Set<Products> products = new HashSet<>(0);

    public Brands() {
    }
    
//    public Brands(String name) {
//        this.name = name;
//    }
//
//    public Brands(Integer id, String name) {
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

    @Column (name = "logo_path", length = 100)
    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "brands")
    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
    
}
