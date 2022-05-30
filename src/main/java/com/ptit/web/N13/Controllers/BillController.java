package com.ptit.web.N13.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ptit.web.N13.Service.*;
import com.ptit.web.N13.Models.*;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
	private BillService billService;
    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private ClientService clientService;

    @GetMapping()
	public String bill() {
		return "statistic";
	}	

	@PostMapping("/")
	public String clientBill(@RequestParam("payment-date") String paymentDate) {
        int id = 5;
		System.out.println(paymentDate);
        List<Booking> booking = bookingService.findByClientID(id);
		System.out.println(booking.get(0).getBookingDate().toString());
        Integer booking_id = booking.get(0).getID();
        List<Bill> bill = billService.findByBookingID(booking_id);
        System.out.print(bill.get(0).getAmount());
        return "statistic";
       
	}
}