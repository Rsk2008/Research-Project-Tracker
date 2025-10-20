package lk.ijse.cmjd.researchtracker.milestone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MilestoneController {
    private final MilestoneService service;
    public MilestoneController(MilestoneService service){this.service=service;}

    @GetMapping("/projects/{id}/milestones")
    public List<Milestone> list(@PathVariable String id){ return service.forProject(id); }

    @PostMapping("/projects/{id}/milestones")
    public Milestone add(@PathVariable String id, @RequestBody Milestone m){
        // rely on incoming m.project.id == id or client sets it
        return service.create(m);
    }

    @PutMapping("/milestones/{id}")
    public Milestone update(@PathVariable String id, @RequestBody Milestone m){ return service.update(id, m); }

    @DeleteMapping("/milestones/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
