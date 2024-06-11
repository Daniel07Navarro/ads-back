package com.ads.adsback.model.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Integer idUser;

    @Size(min = 5, max = 50)
    private String name;

    @Size(min = 5, max = 50)
    private String lastName;

    @Size(min = 5, max = 50)
    private String maternalLastName;

    @Email
    @Size(min = 5, max = 60)
    private String email;

    @Size(min = 2, max = 150)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private RoleDTO role;

    private List<TokenDTO> tokens;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean enabled = true;

}
