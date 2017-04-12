package com.polytech.business;

import com.polytech.business.interfaces.PublicationService;
import com.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 10/04/2017.
 */
@Service
public class PublicationServiceImpl implements PublicationService {
    private PostRepository repository;

    @Autowired
    public PublicationServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    public void post(Post toPost) {
        this.repository.save(toPost);
    }

    public List<Post> fetchAll() {
        return this.repository.findAll();
    }
}

