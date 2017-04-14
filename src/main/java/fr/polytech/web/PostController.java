package fr.polytech.web;

import fr.polytech.business.data.Comment;
import fr.polytech.business.data.Post;
import fr.polytech.business.data.User;
import fr.polytech.business.services.interfaces.CommentService;
import fr.polytech.business.services.interfaces.PublicationService;
import fr.polytech.business.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private UserService authorService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String publishPost(Post post) {
        this.publicationService.post(post);

        return "redirect:/feed";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String publishComment(@RequestParam String content, @RequestParam long postId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails    user = (UserDetails) auth.getPrincipal();


        Post    post    = this.publicationService.getById(postId);
        User    author  = this.authorService.findByUsername(user.getUsername());
        Comment comment = new Comment(author, post, content);

        this.commentService.post(comment);

        return "redirect:/feed";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String fetchAllFeeds(Model model) {
        List<Post> posts = this.publicationService.fetchAll();
        model.addAttribute("posts", posts);

        return "feed";
    }
}
