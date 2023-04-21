package dev.cyberser.memej;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @NotBlank
    private User author;
    
    @NotBlank
    private String content;

    @OneToMany
    @Nullable
    private List<Comment> comments;

    @NotBlank
    private Long pluses;
    
    @NotBlank
    private Long minuses;
    
    // METHODS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getPluses() {
        return pluses;
    }

    public void setPluses(Long pluses) {
        this.pluses = pluses;
    }

    public Long getMinuses() {
        return minuses;
    }

    public void setMinuses(Long minuses) {
        this.minuses = minuses;
    }

}