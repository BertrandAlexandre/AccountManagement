package fr.alexandrebertrand.am.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.alexandrebertrand.am.model.User;

/**
 * Deposit of users
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Get all users
     * 
     * @return List all users
     */
    List<User> findAllBy();

}
