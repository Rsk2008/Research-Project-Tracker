package lk.ijse.cmjd.researchtracker.project;

import jakarta.persistence.*;
import lk.ijse.cmjd.researchtracker.common.Status;
import lk.ijse.cmjd.researchtracker.user.User;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Project {
    @Id
    private String id;
    private String title;
    @Column(length=2000)
    private String summary;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private User pi;
    private String tags;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        if (status == null) status = Status.PLANNING;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // getters and setters
    // ...
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String t){this.title=t;}
    public String getSummary(){return summary;}
    public void setSummary(String s){this.summary=s;}
    public Status getStatus(){return status;}
    public void setStatus(Status s){this.status=s;}
    public User getPi(){return pi;}
    public void setPi(User u){this.pi=u;}
    public String getTags(){return tags;}
    public void setTags(String t){this.tags=t;}
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate d){this.startDate=d;}
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate d){this.endDate=d;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime d){this.createdAt=d;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public void setUpdatedAt(LocalDateTime d){this.updatedAt=d;}
}
