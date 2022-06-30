package inventory.products.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class BrandEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date createAt;
}
