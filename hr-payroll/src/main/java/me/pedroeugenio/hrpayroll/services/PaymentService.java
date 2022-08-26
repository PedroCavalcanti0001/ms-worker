package me.pedroeugenio.hrpayroll.services;

import me.pedroeugenio.hrpayroll.entities.Payment;
import me.pedroeugenio.hrpayroll.entities.Worker;
import me.pedroeugenio.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayments(Long workerId, int days) {
        Worker workerOptional = workerFeignClient.findById(workerId).getBody();
        return new Payment(workerOptional.getName(), workerOptional.getDailyIncome(), 10);

    }
}
