package fr.alexandrebertrand.am.controller;

import fr.alexandrebertrand.am.config.Urls;
import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.dto.AccountCreationDto;
import fr.alexandrebertrand.am.exception.ResourceNotFoundException;
import fr.alexandrebertrand.am.service.AccountService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account resource
 */
@RestController
@RequestMapping(Urls.API_USERS + "/{userId}/accounts")
public class UserAccountResource {

    /** Account management service */
    private AccountService accountService;

    public UserAccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> list(@PathVariable Long userId) {
        return accountService.findAllByUser(userId);
    }
    
    @GetMapping("/{id}")
    public Account get(@PathVariable Long userId, @PathVariable Long id) {
        return accountService.findOneByUser(id, userId);
    }

    @PostMapping
    public ResponseEntity create(@PathVariable Long userId, @RequestBody @Valid AccountCreationDto dto) throws URISyntaxException {
        if (dto.getUserId() != userId)
            throw new ResourceNotFoundException();
        Long id = accountService.create(dto);
        return ResponseEntity.created(new URI(Urls.API_USERS + "/" + userId + "/accounts/" + id)).build();
    }

}
