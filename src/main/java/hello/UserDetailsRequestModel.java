package hello;


import javax.validation.constraints.NotNull;

public class UserDetailsRequestModel {

    @NotNull(message = "First name must be not empty")
    private String firstName;
    @NotNull(message = "Last name must be not empty")
    private String lastName;
    @NotNull(message = "Email name must be not empty")
    private String email;
    @NotNull(message = "Id name must be not empty")
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
