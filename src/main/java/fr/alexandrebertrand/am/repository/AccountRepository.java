package fr.alexandrebertrand.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.model.User;

/**
 * Deposit of accounts.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    /**
     * Get all accounts.
     * 
     * @return List of accounts.
     */
    List<Account> findAllBy();

    /**
     * Get list of accounts of an user.
     *
     * @param user User of the application.
     * @return List of accounts of the user.
     */
    List<Account> findByUser(User user);

    /**
     * Get an account of an user.
     *
     * @param id   Identifier of the account
     * @param user User of the application.
     * @return Searched account.
     */
    Optional<Account> findByIdAndUser(Long id, User user);

}
