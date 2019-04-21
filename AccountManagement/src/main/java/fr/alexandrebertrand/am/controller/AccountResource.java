package fr.alexandrebertrand.am.controller;

import fr.alexandrebertrand.am.config.Urls;
import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.dto.AccountCreationDto;
import fr.alexandrebertrand.am.dto.AccountUpdateDto;
import fr.alexandrebertrand.am.service.AccountService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Account resource
 */
@RestController
@RequestMapping(Urls.API_ACCOUNTS)
public class AccountResource {

  /** Account management service */
  private AccountService accountService;

  public AccountResource(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public List<Account> list() {
    return accountService.findAll();
  }

  @GetMapping("/{id}")
  public Account get(@PathVariable Long id) {
    return accountService.findOne(id);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody @Valid AccountCreationDto dto) throws URISyntaxException {
    Long id = accountService.create(dto);
    return ResponseEntity.created(new URI(Urls.API_ACCOUNTS + "/" + id)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid AccountUpdateDto dto) {
    accountService.update(id, dto);
    return ResponseEntity.noContent().build();
  }
  
}
