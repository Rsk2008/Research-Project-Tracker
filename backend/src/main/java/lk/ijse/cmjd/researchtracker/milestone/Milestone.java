package lk.ijse.cmjd.researchtracker.milestone;

import jakarta.persistence.*;
import lk.ijse.cmjd.researchtracker.project.Project;
import lk.ijse.cmjd.researchtracker.user.User;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Milestone {
    @Id
    private String id;
    @ManyToOne
    private Project project;
    private String title;
    @Column(length=2000)
    private String description;
    private LocalDate dueDate;
    private Boolean isCompleted=false;
    @ManyToOne
    private User createdBy;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){ createdAt = LocalDateTime.now(); }

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
    public LocalDate getDueDate(){return dueDate;}
    public void setDueDate(LocalDate d){this.dueDate=d;}
    public Boolean getIsCompleted(){return isCompleted;}
    public void setIsCompleted(Boolean c){this.isCompleted=c;}
    public User getCreatedBy(){return createdBy;}
    public void setCreatedBy(User u){this.createdBy=u;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime c){this.createdAt=c;}
}
