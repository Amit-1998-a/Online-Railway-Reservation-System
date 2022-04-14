package com.example.Railway.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Railway.Repository.RailwayBookingRepository;
import com.example.Railway.model.RailwayBooking;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/book")
public class RailwayController {
	
	
	@Autowired
	private RailwayBookingRepository bookingRepository;
	
	@GetMapping("/")
	public String Check(){
		return("checked");
	}
	
	@PostMapping("/booking/add")
	public RailwayBooking saveBook(@RequestBody RailwayBooking book) {
		return  bookingRepository.save(book);
	    }
	
	
	@GetMapping("/bookings")
	public List<RailwayBooking> getAllbookings(){
		return bookingRepository.findAll();
	}
	
	@GetMapping("/bookings/{id}")
	public Optional<RailwayBooking> getBook(@PathVariable String id){
		return 	bookingRepository.findById(id);
	}

	@PutMapping("/bookings/update/{id}")
	public RailwayBooking updateOrder(@PathVariable("id") String id,@RequestBody RailwayBooking books ) {
		bookingRepository.save(books);
		return books;
	}
	
	@DeleteMapping("/bookings/delete/{id}")
	 public String deleteOrder (@PathVariable String id) {
	  bookingRepository.deleteById(id);
		return "Deleted SuccessFully !";
		}
	
}
