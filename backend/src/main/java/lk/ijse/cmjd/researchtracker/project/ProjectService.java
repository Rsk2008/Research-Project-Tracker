package lk.ijse.cmjd.researchtracker.project;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepository repo;
    public ProjectService(ProjectRepository repo){this.repo = repo;}
    public List<Project> findAll(){ return repo.findAll(); }
    public Project findById(String id){ return repo.findById(id).orElseThrow(); }
    public Project create(Project p){
        if (p.getId()==null || p.getId().isBlank()) p.setId(UUID.randomUUID().toString());
        return repo.save(p);
    }
    public Project update(String id, Project p){
        Project ex = findById(id);
        p.setId(ex.getId());
        return repo.save(p);
    }
    public void delete(String id){ repo.deleteById(id); }
}
