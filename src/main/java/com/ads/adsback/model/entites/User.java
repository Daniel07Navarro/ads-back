package com.ads.adsback.model.entites;

import com.ads.adsback.token.Token;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(unique = true,length = 20)
    private String username;

    @Column(unique = true,length = 30)
    private String email;

    @Column(length = 150)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role",foreignKey = @ForeignKey(name = "FK_User_Role"))
    private Role role;

    private String securityQuestion;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Token> tokens;

    /*MUCHOS USUARIOS VAN A TENER UN ROL
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_Role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;
    */



}
