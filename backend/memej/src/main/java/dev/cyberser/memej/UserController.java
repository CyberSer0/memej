package dev.cyberser.memej;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    // USERS ENDPOINTS
    @GetMapping("/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // USER ENDPOINTS
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    
    @PostMapping(value = "/post", consumes = {"application/json"})
    public User createUser(@Valid @RequestBody User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @PutMapping("/put/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setImage(userDetails.getImage());
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}   
