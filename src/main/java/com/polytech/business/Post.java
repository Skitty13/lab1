package com.polytech.business;

import javax.persistence.*;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 10/04/2017.
 */

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content")
    private String content;

    private Post() {}

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }
}