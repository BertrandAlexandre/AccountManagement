package fr.alexandrebertrand.am.controller;

import fr.alexandrebertrand.am.config.Urls;
import fr.alexandrebertrand.am.model.User;
import fr.alexandrebertrand.am.dto.UserCreationDto;
import fr.alexandrebertrand.am.dto.UserUpdateDto;
import fr.alexandrebertrand.am.service.UserService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User resource
 */
@RestController
@RequestMapping(Urls.API_USERS)
public class UserResource {

    /** User management service */
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }
    
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.findOne(id);
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody @Valid UserCreationDto dto) throws URISyntaxException {
        Long id = userService.create(dto);
        return ResponseEntity.created(new URI(Urls.API_USERS + "/" + id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid UserUpdateDto dto) {
        userService.update(id, dto);
        return ResponseEntity.noContent().build();
    }
    
}
