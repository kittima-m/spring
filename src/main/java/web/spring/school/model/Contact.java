package web.spring.school.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name must not be blank")
    @Size(min=3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile Number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @Email
    @NotBlank(message = "Please fill in an E-mail")
    private String email;

    @NotBlank(message = "Please fill in a Subject")
    private String subject;

    @NotBlank(message = "Please describe more on message")
    private String message;

}
