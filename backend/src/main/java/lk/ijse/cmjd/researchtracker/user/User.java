package lk.ijse.cmjd.researchtracker.user;

import jakarta.persistence.*;
import lk.ijse.cmjd.researchtracker.common.UserRole;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User {
    @Id
    private String id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        if (role == null) role = UserRole.MEMBER;
    }

    // getters/setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}
    public String getPassword(){return password;}
    public void setPassword(String p){this.password=p;}
    public String getFullName(){return fullName;}
    public void setFullName(String f){this.fullName=f;}
    public UserRole getRole(){return role;}
    public void setRole(UserRole r){this.role=r;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime c){this.createdAt=c;}
}
