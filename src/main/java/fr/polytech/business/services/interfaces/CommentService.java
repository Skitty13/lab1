package fr.polytech.business.services.interfaces;

import fr.polytech.business.data.Comment;

public interface CommentService {
    void post(Comment toPost);
}
