package com.thoughtworks.capacity.gtb.mvc.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDao {
    @NotNull(message = "id must not be null")
    private int id;
    @NotBlank(message = "name must not be blank")
    @Size(min = 5,max = 12,message = "Invalid UserName")
    private String username;
    @NotBlank(message = "password not be blank")
    @Pattern(regexp = "^[0-9a-zA-Z_]{5,12}$", message = "Invalid Password")
    private String password;
    @NotBlank(message = "email not be blank")
    @Email(message = "Invalid email")
    private String email;
}
