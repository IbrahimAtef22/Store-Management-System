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
@Table(name = "products", schema = "store_java")
public class Products implements Serializable{

    private Integer id;
    private Categories categories;
    private Brands brands;
    private String name;
    private String description;
    private String picturePath;
    private Set<ProductsSizes> productsSizes = new HashSet<>(0);

    public Products() {
    }

//    public Products(Integer id) {
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
    @JoinColumn (name = "category_id", nullable = false)
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "brand_id", nullable = false)
    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }
    
    @Column (name = "name", nullable = false, length = 100)
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
    
    @Column (name = "picture_path", length = 100)
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "products")
    public Set<ProductsSizes> getProductsSizes() {
        return productsSizes;
    }

    public void setProductsSizes(Set<ProductsSizes> productsSizes) {
        this.productsSizes = productsSizes;
    }

}
