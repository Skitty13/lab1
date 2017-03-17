package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 15/03/2017.
 */

@Controller
public class PostController {

    @Autowired
    private PublicationService publicationService;

    @RequestMapping(value = "/feed",method = RequestMethod.GET )
    public String feed(Model model){
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts", posts);
        return "feed";
    }

    @RequestMapping(value = "/share",method = RequestMethod.POST )
    public String post(Post post, Principal principal){
        String username= principal.getName();
        publicationService.post(post);
        return "redirect:feed";
    }
}