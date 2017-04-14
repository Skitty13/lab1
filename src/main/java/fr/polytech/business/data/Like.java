package fr.polytech.business.data;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=true)
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    //////////////////////
    // Constructor
    /////////////

    private Like() {}

    public Like(User author, Post post) {
        this.author = author;
        this.post   = post;
    }

    //////////////////////
    // Public
    /////////////

    public User getAuthor() {
        return this.author;
    }
}
