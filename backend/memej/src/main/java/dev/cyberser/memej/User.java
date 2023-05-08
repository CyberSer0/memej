package dev.cyberser.memej;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id                                                                                             // - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                             // - generates new numbers based on the ones that came before
    private Long id;
    
    @NotBlank
    private String name;

    @Transient                                                                                      // - this cannot be held in the DB as is
    private String password;

    @Column(name = "password")                                                                      // - this will be held in the "password" column
    private String passwordHash;

    @NotBlank
    private String image;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)                // - one user can be an author to many meme instances
    @Nullable                                                                                       // - this parameter can be null (new user - no memes)
    private List<Meme> memes = new ArrayList<>();

    // METHODS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
}
