package lk.ijse.cmjd.researchtracker.document;

import jakarta.persistence.*;
import lk.ijse.cmjd.researchtracker.project.Project;
import lk.ijse.cmjd.researchtracker.user.User;
import java.time.LocalDateTime;

@Entity
public class Document {
    @Id
    private String id;
    @ManyToOne
    private Project project;
    private String title;
    @Column(length=2000)
    private String description;
    private String urlOrPath;
    @ManyToOne
    private User uploadedBy;
    private LocalDateTime uploadedAt;

    @PrePersist
    public void prePersist(){ uploadedAt = LocalDateTime.now(); }

    // getters and setters
    // ...
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public Project getProject(){return project;}
    public void setProject(Project p){this.project=p;}
    public String getTitle(){return title;}
    public void setTitle(String t){this.title=t;}
    public String getDescription(){return description;}
    public void setDescription(String d){this.description=d;}
    public String getUrlOrPath(){return urlOrPath;}
    public void setUrlOrPath(String u){this.urlOrPath=u;}
    public User getUploadedBy(){return uploadedBy;}
    public void setUploadedBy(User u){this.uploadedBy=u;}
    public LocalDateTime getUploadedAt(){return uploadedAt;}
    public void setUploadedAt(LocalDateTime u){this.uploadedAt=u;}
}
