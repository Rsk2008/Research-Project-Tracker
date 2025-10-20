package lk.ijse.cmjd.researchtracker.document;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {
    private final DocumentRepository repo;
    public DocumentService(DocumentRepository repo){this.repo=repo;}
    public List<Document> forProject(String projectId){ return repo.findByProject_Id(projectId); }
    public Document create(Document d){
        if (d.getId()==null || d.getId().isBlank()) d.setId(UUID.randomUUID().toString());
        return repo.save(d);
    }
    public void delete(String id){ repo.deleteById(id); }
}
