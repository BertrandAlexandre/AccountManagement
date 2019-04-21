package fr.alexandrebertrand.am.config.seeds;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import fr.alexandrebertrand.am.model.Account;
import fr.alexandrebertrand.am.model.User;
import fr.alexandrebertrand.am.repository.AccountRepository;
import fr.alexandrebertrand.am.repository.UserRepository;

/**
 * Initializes a dataset for the application in development mode
 */
@Component
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSeeder.class);

  /** Deposit of accounts */
  private AccountRepository accountRepository;

  /** Deposit of users */
  private UserRepository userRepository;

  public DatabaseSeeder(AccountRepository accountRepository,
                        UserRepository userRepository) {
    this.accountRepository = accountRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws IOException  {
    List<User> users = loadData("users.json", new TypeReference<List<User>>() {});
    users.forEach((s) -> {
      // Create new user
      User u = new User();
      u.setFirstName(s.getFirstName());
      u.setLastName(s.getLastName());
      long minDay = LocalDate.now().minusYears(70).toEpochDay();
      long maxDay = LocalDate.now().minusYears(20).toEpochDay();
      long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
      u.setBornDate(LocalDate.ofEpochDay(randomDay));
      u.setGender(s.getGender());
      u.setProfession(s.getProfession());
      userRepository.save(u);
      // Create main account
      String username = u.getLastName().substring(0, 3).toLowerCase();
      Account a = new Account();
      a.setUsername(username);
      a.setDescription("Main account");
      a.setUser(u);
      accountRepository.save(a);
      // Create admin account
      boolean isAdmin = ((int) (Math.random() * 4 + 1)) == 1;
      if (isAdmin) {
        Account admin = new Account();
        admin.setUsername(username + "_admin");
        admin.setDescription("Admin account");
        admin.setUser(u);
        accountRepository.save(admin);
      }
      userRepository.save(u); // persistence
    });
  }

  /**
   * Load data from a file present in resources/data/
   *
   * @throws IOException Error linked to the data file
   * @param path Relative path to the .json file containing the data
   * @param tr   Type of data to recover
   * @param <T>  Type of data contained in the file
   * @return The loaded data
   */
  public static <T> T loadData(String path, TypeReference tr) throws IOException {
    try {
      File file = new ClassPathResource("data/" + path).getFile();
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(file, tr);
    } catch (IOException e) {
      LOGGER.error("Unable to load data from " + path);
      throw new IOException("Unable to load data from " + path, e);
    }
  }

}
