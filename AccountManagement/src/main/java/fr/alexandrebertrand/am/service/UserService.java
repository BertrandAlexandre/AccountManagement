package fr.alexandrebertrand.am.service;

import java.util.List;

import fr.alexandrebertrand.am.model.User;
import fr.alexandrebertrand.am.dto.UserCreationDto;
import fr.alexandrebertrand.am.dto.UserUpdateDto;

/**
 * User management service
 */
public interface UserService {

  /**
   * Get list of users
   * 
   * @return List of users
   */
  List<User> findAll();

  /**
   * Get data from an user
   * 
   * @param id Identifier of the user
   * @return Searched user
   */
  User findOne(Long id);

  /**
   * Create a new user
   * 
   * @param dto DTO of the user
   * @return Identifier of the created user
   */
  Long create(UserCreationDto dto);

  /**
   * Update an user
   * 
   * @param id  Identifier of the user
   * @param dto DTO of the user
   */
  void update(Long id, UserUpdateDto dto);

}
