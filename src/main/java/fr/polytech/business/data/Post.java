package fr.polytech.business.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;


    //////////////////////
    // Constructor
    /////////////

    private Post() {}

    public Post(String content) {
        this.content = content;
    }

    //////////////////////
    // Getters / Setters
    /////////////

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public List<Like> getLikes() {
        return this.likes;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    //////////////////////
    // Others
    /////////////

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }
}
