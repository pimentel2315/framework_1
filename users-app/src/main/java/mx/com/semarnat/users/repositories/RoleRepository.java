package mx.com.semarnat.users.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.semarnat.users.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
