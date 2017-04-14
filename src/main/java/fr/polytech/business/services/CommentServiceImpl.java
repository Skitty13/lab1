package fr.polytech.business.services;

import fr.polytech.business.data.Comment;
import fr.polytech.business.services.interfaces.CommentService;
import fr.polytech.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    public void post(Comment toPost) {
        this.repository.save(toPost);
    }
}
