package me.pedroeugenio.hrpayroll.services;

import me.pedroeugenio.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayments(Long workerId, int days){
        return new Payment("nome", 100.4, 10);
    }
}
