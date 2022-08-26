package me.pedroeugenio.hrpayroll.services;

import me.pedroeugenio.hrpayroll.entities.Payment;
import me.pedroeugenio.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayments(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());
        Optional<Worker> workerOptional = Optional.ofNullable(restTemplate.getForObject(workerHost + "/workers/{id}",
                Worker.class, uriVariables));
        if (workerOptional.isPresent())
            return new Payment(workerOptional.get().getName(), workerOptional.get().getDailyIncome(), 10);
        else
            throw new IllegalArgumentException("Worker not found " +workerId.toString());

    }
}
