package lk.ijse.cmjd.researchtracker.milestone;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class MilestoneService {
    private final MilestoneRepository repo;
    public MilestoneService(MilestoneRepository repo){this.repo=repo;}
    public List<Milestone> forProject(String projectId){ return repo.findByProject_Id(projectId); }
    public Milestone create(Milestone m){
        if (m.getId()==null || m.getId().isBlank()) m.setId(UUID.randomUUID().toString());
        return repo.save(m);
    }
    public Milestone update(String id, Milestone m){
        Milestone ex = repo.findById(id).orElseThrow();
        m.setId(ex.getId());
        return repo.save(m);
    }
    public void delete(String id){ repo.deleteById(id); }
}
