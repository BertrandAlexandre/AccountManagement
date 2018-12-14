package fr.alexandrebertrand.am.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.alexandrebertrand.am.model.User;
import fr.alexandrebertrand.am.dto.UserCreationDto;
import fr.alexandrebertrand.am.dto.UserUpdateDto;
import fr.alexandrebertrand.am.exception.ResourceNotFoundException;
import fr.alexandrebertrand.am.repository.UserRepository;

/**
 * Implementation of the user management service
 */
@Service
public class UserServiceImpl implements UserService {

    /** Deposit of users */
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllBy();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Long create(UserCreationDto dto) {
        User u = new User();
        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setBornDate(dto.getBornDate());
        u.setGender(dto.getGender());
        u.setProfession(dto.getProfession());
        userRepository.save(u);
        return u.getId();
    }

    @Override
    public void update(Long id, UserUpdateDto dto) {
        User u = userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        if (dto.getFirstName() != null)
            u.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null)
            u.setLastName(dto.getLastName());
        if (dto.getBornDate() != null)
            u.setBornDate(dto.getBornDate());
        if (dto.getGender() != null)
            u.setGender(dto.getGender());
        if (dto.getProfession() != null)
            u.setProfession(dto.getProfession());
        userRepository.save(u);
    }

}
