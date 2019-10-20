package hello;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "First name must be not empty")
    @Size(min=3, message = "First name must be not less then 3 characters")
    private String firstName;
    @NotNull(message = "Last name must be not empty")
    @Size(min=3, message = "Last name must be not less then 3 characters")
    private String lastName;
    @NotNull(message = "Email name must be not empty")
    @Email
    private String email;
    @NotNull(message = "Password name must be not empty")
    @Size(min=3, max = 8, message = "Password must be between 3 and 8 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
