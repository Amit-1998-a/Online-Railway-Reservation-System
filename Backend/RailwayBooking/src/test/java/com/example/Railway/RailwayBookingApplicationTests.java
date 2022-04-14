package com.example.Railway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Railway.Controller.RailwayController;
import com.example.Railway.Repository.RailwayBookingRepository;
import com.example.Railway.model.RailwayBooking;

@SpringBootTest
class RailwayBookingApplicationTests {
	
	@Autowired
	private RailwayController controller;
	
	@MockBean
	private RailwayBookingRepository bookingRepository;

	@Test
	public void saveBooktest() {
		RailwayBooking book = new RailwayBooking("4","metro","nagpur","mumbai","adi","23","male","xyz","5","20 march","amit@gmail.com");
		when(bookingRepository.save(book)).thenReturn(book);
		RailwayBooking result=controller.saveBook(book);
		assertEquals(book.getId(), result.getId());
	}
	@Test
	public void getbookingtest() {
		when (bookingRepository.findAll()).thenReturn
		(Stream.of(new RailwayBooking( "4","metro","nagpur","mumbai","adi","23","male","xyz","5","20 march","amit@gmail.com"))
				.collect(Collectors.toList()));
		assertEquals(1, controller.getAllbookings().size());
	}
	@Test
	public void getbookingbyIdTest() {
		String id = "4";
		controller.getBook(id);
		verify(bookingRepository).findById(id);
	}
	
	@Test()
	public void deletebookingbyIdTest() {
		String book=RailwayBooking("4","metro","nagpur","mumbai","adi","23","male","xyz","5","20 march","amit@gmail.com");
		controller.deleteOrder(book);
		verify(bookingRepository, times(1)).deleteById(book);
		
		
	}
	private String RailwayBooking(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
