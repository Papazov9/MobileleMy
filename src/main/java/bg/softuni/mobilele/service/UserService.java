package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entities.User;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        User newUser =
                new User()
                        .setActive(true)
                        .setEmail(userRegisterDTO.getEmail())
                        .setFirstName(userRegisterDTO.getFirstName())
                        .setLastName(userRegisterDTO.getLastName())
                        .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean login(UserLoginDTO loginDTO){
        Optional<User> userOpt = userRepository.findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            return false;
        }

        var rawPassword = loginDTO.getPassword();
        var encodedPassword = userOpt.get().getPassword();
        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);
        if (success) {
            login(userOpt.get());
        }else {
            logout();
        }

        return success;
    }

    public void login(User user) {
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
