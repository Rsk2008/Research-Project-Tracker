package lk.ijse.cmjd.researchtracker.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private final UserRepository repo;
    public UserController(UserRepository repo){this.repo=repo;}

    @GetMapping
    public List<User> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public User one(@PathVariable String id){ return repo.findById(id).orElseThrow(); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
