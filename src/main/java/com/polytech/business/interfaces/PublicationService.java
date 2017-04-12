package com.polytech.business.interfaces;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by Utilisateur on 13/03/2017.
 */
public interface PublicationService {

    void post(Post post);

    List<Post> fetchAll();
}
