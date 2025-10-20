package lk.ijse.cmjd.researchtracker.project;

import lk.ijse.cmjd.researchtracker.common.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service){ this.service = service; }

    @GetMapping
    public List<Project> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Project one(@PathVariable String id){ return service.findById(id); }

    @PostMapping
    public Project create(@RequestBody Project p){ return service.create(p); }

    @PutMapping("/{id}")
    public Project update(@PathVariable String id, @RequestBody Project p){ return service.update(id, p); }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Project> updateStatus(@PathVariable String id, @RequestParam Status status){
        Project proj = service.findById(id);
        proj.setStatus(status);
        return ResponseEntity.ok(service.update(id, proj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
