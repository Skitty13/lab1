package fr.polytech.business.services.interfaces;

import fr.polytech.business.data.Post;

import java.util.List;

public interface PublicationService {
    void post(Post toPost);

    Post getById(long id);

    List<Post> fetchAll();
}
