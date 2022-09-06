package mx.com.semarnat.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.semarnat.users.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
