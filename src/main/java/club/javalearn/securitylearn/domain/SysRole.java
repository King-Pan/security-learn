package club.javalearn.securitylearn.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}