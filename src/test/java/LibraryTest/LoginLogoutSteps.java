package LibraryTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Library.LibraryApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps {

	private LibraryApp libraryApp;
	private String password;


    public LoginLogoutSteps(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}

	@Given("that the administrator is not logged in")
	public void thatTheAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(libraryApp.adminLoggedIn());
	}

	@Given("the password is {string}")
	public void thePasswordIs(String password) throws Exception {
		this.password = password;
	}

	@Then("the administrator login succeeds")
	public void theAdministratorLoginSucceeds() throws Exception {
		assertTrue(libraryApp.adminLogin(password));
	}

	@Then("the adminstrator is logged in")
	public void theAdminstratorIsLoggedIn() throws Exception {
		assertTrue(libraryApp.adminLoggedIn());
	}

	@Then("the administrator login fails")
	public void theAdministratorLoginFails() throws Exception {
		assertFalse(libraryApp.adminLogin(password));
	}

	@Then("the administrator is not logged in")
	public void theAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(libraryApp.adminLoggedIn());
	}

	@Then("the administrator logs in successfully")
	public void theAdministratorLoginsSuccessfully() throws Exception {
	}

	@Given("that the administrator is logged in")
	public void thatTheAdministratorIsLoggedIn() throws Exception {
		assertTrue(libraryApp.adminLogin("adminadmin"));
	}

	@When("the administrator logs out")
	public void theAdministratorLogsOut() throws Exception {
		libraryApp.adminLogout();
	}

}

