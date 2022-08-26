package me.pedroeugenio.hrworker.resources;

import me.pedroeugenio.hrworker.entities.Worker;
import me.pedroeugenio.hrworker.repositories.WorkerRepository;
import me.pedroeugenio.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> optionalWorker = workerService.findById(id);
        return optionalWorker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
