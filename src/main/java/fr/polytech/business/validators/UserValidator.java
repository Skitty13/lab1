package fr.polytech.business.validators;

import fr.polytech.business.data.User;
import fr.polytech.business.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@PropertySource("classpath:/validation.properties")
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Ne doit pas être vide");
        if (user.getUsername().length() < 2 || user.getUsername().length() > 10)
            errors.rejectValue("username", "Size.userForm.username", "Veuillez utilisez entre 2 et 10 caracteres.");

        if (userService.findByUsername(user.getUsername()) != null)
            errors.rejectValue("username", "Duplicate.userForm.username", "Ce nom d'utilisateur n\\'est pas disponible.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Ne doit pas être vide");
        if (user.getPassword().length() < 5 || user.getPassword().length() > 32)
            errors.rejectValue("password", "Size.userForm.password", "Mot de passe trop petit (5 caracteres)");

        if (!user.getPasswordConfirm().equals(user.getPassword()))
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm", "Les mots de passe ne sont pas identiques.");
    }
}