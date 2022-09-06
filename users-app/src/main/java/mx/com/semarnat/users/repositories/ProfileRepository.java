package mx.com.semarnat.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.semarnat.users.entities.Profile;


@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
