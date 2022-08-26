package me.pedroeugenio.hrworker.services;

import me.pedroeugenio.hrworker.entities.Worker;
import me.pedroeugenio.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public Optional<Worker> findById(Long id) {
        return workerRepository.findById(id);
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }
}
