package mx.com.semarnat.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.semarnat.users.entities.Address;



@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {



}
