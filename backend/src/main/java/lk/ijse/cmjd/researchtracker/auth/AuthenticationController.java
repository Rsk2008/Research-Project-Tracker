package lk.ijse.cmjd.researchtracker.auth;

import lk.ijse.cmjd.researchtracker.auth.dto.LoginRequest;
import lk.ijse.cmjd.researchtracker.auth.dto.AuthResponse;
import lk.ijse.cmjd.researchtracker.common.UserRole;
import lk.ijse.cmjd.researchtracker.config.JwtUtil;
import lk.ijse.cmjd.researchtracker.user.User;
import lk.ijse.cmjd.researchtracker.user.UserRepository;
import lk.ijse.cmjd.researchtracker.user.dto.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthenticationController(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil){
        this.userRepo = userRepo; this.encoder = encoder; this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req){
        if (userRepo.findByUsername(req.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setUsername(req.getUsername());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setFullName(req.getFullName());
        u.setRole(UserRole.MEMBER);
        userRepo.save(u);
        String token = jwtUtil.generateToken(u.getUsername(), u.getRole().name());
        return ResponseEntity.ok(new AuthResponse(token, u.getRole().name()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        return userRepo.findByUsername(req.getUsername())
                .filter(u -> encoder.matches(req.getPassword(), u.getPassword()))
                .<ResponseEntity<?>>map(u -> ResponseEntity.ok(new AuthResponse(
                        jwtUtil.generateToken(u.getUsername(), u.getRole().name()), u.getRole().name())))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}
