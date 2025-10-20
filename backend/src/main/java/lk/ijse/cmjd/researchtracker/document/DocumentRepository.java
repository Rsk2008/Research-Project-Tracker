package lk.ijse.cmjd.researchtracker.document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface DocumentRepository extends JpaRepository<Document, String> {
    java.util.List<Document> findByProject_Id(String projectId);
}
