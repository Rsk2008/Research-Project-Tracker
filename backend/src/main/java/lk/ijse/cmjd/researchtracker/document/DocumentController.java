package lk.ijse.cmjd.researchtracker.document;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DocumentController {
    private final DocumentService service;
    public DocumentController(DocumentService service){this.service=service;}

    @GetMapping("/projects/{id}/documents")
    public List<Document> list(@PathVariable String id){ return service.forProject(id); }

    @PostMapping("/projects/{id}/documents")
    public Document create(@PathVariable String id, @RequestBody Document d){
        return service.create(d);
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
