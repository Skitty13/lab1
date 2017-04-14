package fr.polytech.business.data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "content")
    private String content;

    //////////////////////
    // Constructor
    /////////////

    private Comment() {}

    public Comment(User author, Post post, String content) {
        this.author  = author;
        this.post    = post;
        this.content = content;
    }

    //////////////////////
    // Public
    /////////////

    public User getAuthor() {
        return this.author;
    }

    public Post getPost() {
        return this.post;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
