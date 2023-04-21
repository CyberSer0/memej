package dev.cyberser.memej;

import java.util.List;

import org.springframework.format.annotation.NumberFormat;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Meme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String image;

    @NumberFormat
    @Column(name = "pluses", columnDefinition = "int default 0", nullable = false)
    private Long pluses;

    @NumberFormat
    @Column(name = "minuses", columnDefinition = "int default 0", nullable = false)
    private Long minuses;

    @OneToMany(fetch = FetchType.LAZY)
    @Nullable
    private List<Comment> comments;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @Nullable
    private List<Tag> tags;

    @NotBlank
    private String url;
    
    // ID METHODS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // TITLE METHODS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // IMAGE METHODS
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    // UPVOTE METHODS
    public Long getPluses() {
        return pluses;
    }

    public void addPlus() {
        pluses++;
    }

    public void removePlus() {
        pluses--;
    }

    // DOWNVOTE METHODS
    public Long getMinuses() {
        return minuses;
    }

    public void addMinus() {
        minuses++;
    }

    public void removeMinus() {
        minuses--;
    }

    // AUTHOR METHODS
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }

    public void setPluses(Long pluses) {
        this.pluses = pluses;
    }

    public void setMinuses(Long minuses) {
        this.minuses = minuses;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    // URL METHODS
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
}
