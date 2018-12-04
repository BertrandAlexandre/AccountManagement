package fr.alexandrebertrand.am.service;

import java.util.List;

import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.dto.AccountCreationDto;
import fr.alexandrebertrand.am.dto.AccountUpdateDto;

/**
 * Account management service.
 */
public interface AccountService {

    /**
     * Get list of accounts.
     * 
     * @return List of accounts.
     */
    List<Account> findAll();

    /**
     * Get list of accounts of an user.
     * 
     * @param userId Identifier of the user.
     * @return List of accounts.
     */
    List<Account> findAllByUser(Long userId);

    /**
     * Get data from an account.
     * 
     * @param id Identifier of the account.
     * @return Searched account.
     */
    Account findOne(Long id);

    /**
     * Get data from an account of an user.
     * 
     * @param id     Identifier of the account.
     * @param userId Identifier of the user.
     * @return List of account.
     */
    Account findOneByUser(Long id, Long userId);

    /**
     * Create a new account.
     * 
     * @param dto DTO of the account.
     * @return Identifier of the created account.
     */
    Long create(AccountCreationDto dto);

    /**
     * Update an account.
     * 
     * @param id  Identifier of the account.
     * @param dto DTO of the account.
     */
    void update(Long id, AccountUpdateDto dto);

}
