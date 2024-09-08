package ru.itmentor.spring.boot_security.demo.repository;
import ru.itmentor.spring.boot_security.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {


}
