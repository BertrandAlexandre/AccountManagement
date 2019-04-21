package fr.alexandrebertrand.am;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import fr.alexandrebertrand.am.model.*;
import fr.alexandrebertrand.am.web.service.*;

/**
 * Entry point of the application
 */
public class AccountManagementClientApp {

  /** User service of the application */
  private static UserService userService;

  /** Account service of the application */
  private static AccountService accountService;

  /** User account service of the application */
  private static UserAccountService userAccountService;

  public static void main( String[] args ) {
    userService = new UserService();
    accountService = new AccountService();
    userAccountService = new UserAccountService();

    manageUsers();
    manageAccounts();
    manageUserAccount();
  }

  private static void manageUsers() {
    System.out.println("### User management");

    // Create first user

    User newUserA = new User();
    newUserA.setFirstName("John");
    newUserA.setLastName("Smith");
    newUserA.setBornDate(LocalDate.of(1986, 6, 23));
    newUserA.setGender(Gender.MASCULINE);
    newUserA.setProfession("Digital Technology Engineer");
    userService.create(newUserA);

    // Create an user

    User newUserB = new User();
    newUserB.setFirstName("Miranda");
    newUserB.setLastName("Oliver");
    newUserB.setBornDate(LocalDate.of(1978, 9, 5));
    newUserB.setGender(Gender.FEMININE);
    newUserB.setProfession("Chief Technology Officer");
    userService.create(newUserB);
    System.out.println("\nNew users have been created!");

    // List users

    List<User> users = userService.list();
    System.out.println("\nList of users:");
    for (User user : users) {
      System.out.println(user.toString());
    }

    // Get an user

    int pos = new Random().nextInt(users.size());
    User user = userService.get(users.get(pos).getId());
    System.out.println("\nAn user:");
    System.out.println(user.toString());

    // Update an user

    user.setProfession("In transition");
    userService.update(user);
    User updatedUser = userService.get(user.getId());
    System.out.println("\nUser \"" + updatedUser.getFirstName() +
        "\" has been updated:");
    System.out.println(updatedUser.toString());
  }

  private static void manageAccounts() {
    System.out.println("\n\n### Account management");
    List<User> users = userService.list();
    User user = users.get(new Random().nextInt(users.size()));

    // Create first account

    Account newAccountA = new Account();
    newAccountA.setUsername("fst");
    newAccountA.setDescription("An account");
    newAccountA.setUserId(user.getId());
    accountService.create(newAccountA);

    // Create an account

    Account newAccountB = new Account();
    newAccountB.setUsername("olm");
    newAccountB.setDescription("Sub account of " + user.getFirstName());
    newAccountB.setUserId(user.getId());
    accountService.create(newAccountB);
    System.out.println("\nNew accounts have been created!");

    // List accounts

    List<Account> accounts = accountService.list();
    System.out.println("\nList of accounts:");
    for (Account account : accounts) {
      System.out.println(account.toString());
    }

    // Get an account

    int pos = new Random().nextInt(accounts.size());
    Account account = accountService.get(accounts.get(pos).getId());
    System.out.println("\nAn account:");
    System.out.println(account.toString());

    // Update an account

    account.setDescription("This account has been modified");
    account.setUserId(user.getId());
    accountService.update(account);
    Account updatedAccount = accountService.get(account.getId());
    System.out.println("\nAccount \"" + updatedAccount.getUsername() +
        "\" has been updated:");
    System.out.println(updatedAccount.toString());
  }

  private static void manageUserAccount() {
    System.out.println("\n\n### User account management");
    List<User> users = userService.list();
    User user = users.get(new Random().nextInt(users.size()));

    // Create an user account

    Account newAccountA = new Account();
    newAccountA.setUsername("uas");
    newAccountA.setDescription("New account for " + user.getFirstName());
    newAccountA.setUserId(user.getId());
    userAccountService.create(newAccountA);

    // Create an user account

    Account newAccountB = new Account();
    newAccountB.setUsername("uat");
    newAccountB.setDescription("Another account for " + user.getFirstName());
    newAccountB.setUserId(user.getId());
    userAccountService.create(newAccountB);
    System.out.println("\nNew accounts has been created for " +
        user.getFirstName() + "!");

    // List user accounts

    System.out.println("\nList of " + user.getFirstName() + " accounts:");
    List<Account> accounts = userAccountService.list(user.getId());
    for (Account account : accounts) {
      System.out.println(account.toString());
    }

    // Get an user account

    int pos = new Random().nextInt(user.getAccounts().size());
    Long id = user.getAccounts().get(pos).getId();
    Account outAccount = userAccountService.get(id, user.getId());
    System.out.println("\nAn account of " + user.getFirstName() + ":");
    System.out.println(outAccount.toString());
  }

}
