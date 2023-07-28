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
@Table (name = "categories", catalog = "store_java", uniqueConstraints = @UniqueConstraint (columnNames = "name"))
public class Categories implements Serializable{
    private Integer id;
    private String name;
    private String description;
    private Set<Products> products = new HashSet<>(0);

    public Categories() {
    }
    
    
//    public Categories(String name) {
//        this.name = name;
//    }
//
//    public Categories(Integer id) {
//        this.id = id;
//    }
//
//    public Categories(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Categories(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
    
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
    
    @Column (name = "description", length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "categories")
    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
    
}
