package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 10/04/2017.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
