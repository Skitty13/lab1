package fr.polytech.business.services;

import fr.polytech.business.data.Post;
import fr.polytech.business.services.interfaces.PublicationService;
import fr.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Post getById(long id) {
        return this.repository.findOne(id);
    }

    public List<Post> fetchAll() {
        return this.repository.findAll();
    }
}
