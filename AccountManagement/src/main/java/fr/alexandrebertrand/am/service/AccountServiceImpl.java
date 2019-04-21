package fr.alexandrebertrand.am.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.model.User;
import fr.alexandrebertrand.am.dto.AccountCreationDto;
import fr.alexandrebertrand.am.dto.AccountUpdateDto;
import fr.alexandrebertrand.am.exception.ResourceNotFoundException;
import fr.alexandrebertrand.am.repository.AccountRepository;
import fr.alexandrebertrand.am.repository.UserRepository;

/**
 * Implementation of the account management service
 */
@Service
public class AccountServiceImpl implements AccountService {

  /** Deposit of accounts */
  private AccountRepository accountRepository;

  /** Deposit of users */
  private UserRepository userRepository;

  /** User management service */
  private final UserService userService;

  public AccountServiceImpl(AccountRepository accountRepository,
                            UserRepository userRepository,
                            UserService userService) {
    this.accountRepository = accountRepository;
    this.userRepository = userRepository;
    this.userService = userService;
  }

  @Override
  public List<Account> findAll() {
    return accountRepository.findAllBy();
  }

  @Override
  public List<Account> findAllByUser(Long userId) {
    return accountRepository.findByUser(userService.findOne(userId));
  }

  @Override
  public Account findOne(Long id) {
    return accountRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Account findOneByUser(Long id, Long userId) {
    return accountRepository.findByIdAndUser(id, userService.findOne(userId))
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Long create(AccountCreationDto dto) {
    User u = userRepository.findById(dto.getUserId())
        .orElseThrow(ResourceNotFoundException::new);
    Account a = new Account(dto.getUsername(), dto.getDescription(), u);
    accountRepository.save(a);
    userRepository.save(u); // persistence
    return a.getId();
  }

  @Override
  public void update(Long id, AccountUpdateDto dto) {
    Account a = accountRepository.findById(id)
        .orElseThrow(ResourceNotFoundException::new);
    if (dto.getUsername() != null)
      a.setUsername(dto.getUsername());
    if (dto.getDescription() != null)
      a.setDescription(dto.getDescription());
    accountRepository.save(a);
  }

}
