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
@Table (name = "sizes", schema = "store_java", uniqueConstraints = @UniqueConstraint (columnNames = "name"))
public class Sizes implements Serializable{
    private Integer id;
    private String name;
    private Set<ProductsSizes> productsSizes = new HashSet<>(0);

    public Sizes() {
    }

//    public Sizes(Integer id) {
//        this.id = id;
//    }
//
//    public Sizes(String name) {
//        this.name = name;
//    }
//
//    public Sizes(Integer id, String name) {
//        this.id = id;
//        this.name = name;
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
    
    @Column (name = "name", unique = true, nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "sizes")
    public Set<ProductsSizes> getProductsSizes() {
        return productsSizes;
    }

    public void setProductsSizes(Set<ProductsSizes> productsSizes) {
        this.productsSizes = productsSizes;
    }
    
    
}
