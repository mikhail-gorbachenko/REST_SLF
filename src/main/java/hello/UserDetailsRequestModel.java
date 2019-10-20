package hello;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "First name must be not empty")
    private String firstName;
    @NotNull(message = "Last name must be not empty")
    private String lastName;
    @NotNull(message = "Email name must be not empty")
    @Email
    private String email;
    @NotNull(message = "Id name must be not empty")
    @Size(min=3, max = 8, message = "id must be between 3 and 8 characters")
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
