package fr.polytech.business.services.interfaces;

import fr.polytech.business.data.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
}
