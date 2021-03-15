package SystemTest.StepClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import System.Address;
import System.Book;
import System.ErrorMessageHolder;
import System.LibraryApp;
import System.OperationNotAllowedException;
import System.User;
import SystemTest.HelperClasses.UserHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {
    
    
    private LibraryApp libraryApp;
    private Book book;
    private ErrorMessageHolder errorMessageHolder;
    private UserHelper userHelper;
    private User user;
    private List<Book> books = new ArrayList<>();


    public UserSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessageHolder, UserHelper helper) {
        this.libraryApp = libraryApp;
        this.errorMessageHolder = errorMessageHolder;
        this.userHelper = helper;
    }
    
    @Given("there is a user with CPR {string}, name {string}, e-mail {string}")
    public void thereIsAUserWithCPRNameEMail(String CPR, String name, String email) {
    user = new User(CPR,name,email);
    assertEquals(user.getCPR(), CPR);
    assertEquals(user.getName(),name);
    assertEquals(user.getEmail(), email);
    
    }
    @Given("the user has address street {string}, post code {int}, and city {string}")
    public void theUserHasAddressStreetPostCodeAndCity(String street, Integer postcode, String city) {
        Address address = new Address(street,postcode,city);
        user.setAddress(address);
        assertEquals(user.getAddress(), address);
    }

    @When("the administrator registers the user")
    public void theAdministratorRegistersTheUser() throws OperationNotAllowedException {
        
        try {
            libraryApp.registerUser(userHelper.getUser());
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("the user is a registered user of the library")
    public void theUserIsARegisteredUserOfTheLibrary() throws OperationNotAllowedException {
        libraryApp.registerUser(user);
        assertTrue(libraryApp.isRegistered(user));
    }

    @Given("a user is registered with the library")
    public void aUserIsRegisteredWithTheLibrary() throws OperationNotAllowedException {
        

        libraryApp.adminLogin("adminadmin");

        try {
            libraryApp.registerUser(userHelper.getUser());
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
        
        libraryApp.registerUser(user);
        
        assertTrue(libraryApp.isRegistered(user));
    
    }

    @When("the administrator registers the user again")
    public void theAdministratorRegistersTheUserAgain() throws OperationNotAllowedException {
        // Write code here that turns the phrase above into concrete actions
        theAdministratorRegistersTheUser();  
        
    }

}



