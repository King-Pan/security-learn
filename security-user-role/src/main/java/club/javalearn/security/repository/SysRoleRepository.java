package club.javalearn.security.repository;

import club.javalearn.security.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

    @Override
    List<SysRole> findAll();
}
