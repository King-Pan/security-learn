package club.javalearn.security.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
@Entity
@Table(name = "t_resource")
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;//资源名称

    @ManyToMany(mappedBy = "resources",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();//一个资源可以被多个角色调用
}