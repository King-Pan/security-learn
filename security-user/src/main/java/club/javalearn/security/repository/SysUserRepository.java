package club.javalearn.security.repository;

import club.javalearn.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * security-learn
 *
 * @author king-pan
 * @date 2018-03-30
 **/
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
