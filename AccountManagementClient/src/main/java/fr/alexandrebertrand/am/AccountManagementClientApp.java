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
    
    public static void main( String[] args ) {
        
        userService = new UserService();
        accountService = new AccountService();
        
        /* User management */
        
        System.out.println("### User management");
        
        // Create first user
        
        User firstUser = new User();
        firstUser.setFirstName("John");
        firstUser.setLastName("Smith");
        firstUser.setBornDate(LocalDate.of(1986, 6, 23));
        firstUser.setGender(Gender.MASCULINE);
        firstUser.setProfession("Digital Technology Engineer");
        userService.create(firstUser);
        
        // Create an user
        
        User newUser = new User();
        newUser.setFirstName("Miranda");
        newUser.setLastName("Oliver");
        newUser.setBornDate(LocalDate.of(1978, 9, 5));
        newUser.setGender(Gender.FEMININE);
        newUser.setProfession("Chief Technology Officer");
        userService.create(newUser);
        System.out.println("\nA new user has been created!");
        
        // Get an user
        
        System.out.println("\nFirst user created :");
        User outFirstUser = userService.get(1l);
        System.out.println(outFirstUser.toString());
        
        // List users
        
        System.out.println("\nList of users :");
        List<User> users = userService.list();
        for (User user : users) {
            System.out.println(user.toString());
        }
        
        // Update an user
        
        System.out.println("\nAn user has been updated!");
        Random r = new Random();
        User userToUpdate = users.get(r.nextInt(users.size()));
        System.out.println("Before: " + userToUpdate.toString());
        userToUpdate.setProfession("In transition");
        userService.update(userToUpdate);
        User updatedUser = userService.get(userToUpdate.getId());
        System.out.println("After:  " + updatedUser.toString());
        
        /* Account management */
        
        System.out.println("\n\n### Account management");
        
        // Create first account
        
        Account firstAccount = new Account();
        firstAccount.setUsername("fst");
        firstAccount.setDescription("First account");
        accountService.create(firstAccount);
        
        // Create an account
        
        Account newAccount = new Account();
        newAccount.setUsername("olm");
        newAccount.setDescription("Main account of Miranda");
        accountService.create(newAccount);
        System.out.println("\nA new account has been created!");
        
        // Get an account
        
        System.out.println("\nFirst account created :");
        Account outFirstAccount = accountService.get(1l);
        System.out.println(outFirstAccount.toString());
        
        // List accounts
        
        System.out.println("\nList of accounts :");
        List<Account> accounts = accountService.list();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        
        // Update an account
        
        System.out.println("\nAn account has been updated!");
        Account accountToUpdate = accounts.get(r.nextInt(accounts.size()));
        System.out.println("Before: " + accountToUpdate.toString());
        accountToUpdate.setDescription("This account has been modified");
        accountService.update(accountToUpdate);
        Account updatedAccount = accountService.get(accountToUpdate.getId());
        System.out.println("After:  " + updatedAccount.toString());
        
    }

}
