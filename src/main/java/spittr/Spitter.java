package spittr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;

    @NotEmpty(message = "{email.empty}")
    @Email(message = "{email.valid}")
    private String email;

    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;



    public Spitter() {
    }

    public Spitter(Long id, String username, String password, String email, String firstName, String lastName) {
        this(username, password, email, firstName, lastName);
    }

    public Spitter(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username: " + username +
                " password: " + password +
                " first name: " + firstName +
                " last name: " + lastName;

    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "username", "password");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "username", "password");
    }
}
