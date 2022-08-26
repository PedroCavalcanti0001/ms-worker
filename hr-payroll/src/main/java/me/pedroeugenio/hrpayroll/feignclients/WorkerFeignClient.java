package me.pedroeugenio.hrpayroll.feignclients;

import me.pedroeugenio.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping
    ResponseEntity<List<Worker>> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
