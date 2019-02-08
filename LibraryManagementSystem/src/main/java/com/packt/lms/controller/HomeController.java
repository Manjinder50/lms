package com.packt.lms.controller;

import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.packt.lms.dto.BookDetailsDTO;
import com.packt.lms.entity.BookDetails;
import com.packt.lms.service.BookService;

@RestController
@EnableWebMvc
public class HomeController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to the Library!");
		model.addAttribute("tagline", "The one and only amazing Reader's Den");
		return "welcome";
	}
	
	@RequestMapping(path="/addBook",headers = {"Accept=application/json"},method=RequestMethod.POST,produces="applocation/json")
	public ResponseEntity<BookDetails> createEmployee(@RequestBody BookDetailsDTO bookDetailsDTO) throws ParseException{
		HttpHeaders headers = new HttpHeaders();
		BookDetails bookDetails = convertToEntity(bookDetailsDTO);
		bookService.saveBooks(bookDetails);
		return new ResponseEntity<BookDetails>(bookDetails,headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allBooks")
	public ResponseEntity<List<BookDetails>> getAllBooks(){
		
		List<BookDetails> books = bookService.getAllBooks();
		return ResponseEntity.ok().body(books);
		
	}
	private BookDetails convertToEntity(BookDetailsDTO bookDetailsDTO) throws ParseException {
		
		BookDetails bookDetails = modelMapper.map(bookDetailsDTO, BookDetails.class);
		bookDetails.setBookTitle(bookDetailsDTO.getBookTitle());
		bookDetails.setNoOfActualCopies(bookDetailsDTO.getQuantity());
		bookDetails.setNoOfCurrentCopies(bookDetailsDTO.getQuantity());

		return bookDetails;
}
}
