package com.project.Bootcamp.controller;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDate;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Bootcamp.model.dto.StockDTO;
import com.project.Bootcamp.repository.StockRepository;
import com.project.Bootcamp.service.StockService;

@RestController
@CrossOrigin             // para o front 
@RequestMapping("/stock")
public class StockController {
	
	
	@Autowired
	private StockService stockService;
	
	@PostMapping
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(stockService.save(dto));
		
	}
	
	@PutMapping
	public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(stockService.update(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<StockDTO>>findAllAll(){
		
		return ResponseEntity.ok(stockService.findall());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StockDTO> getById(@PathVariable Long id){
		return ResponseEntity.ok(stockService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<StockDTO>delete(@PathVariable Long id){
		return ResponseEntity.ok(stockService.delete(id));
	}
	
	@GetMapping("/today")
	public ResponseEntity<List<StockDTO>> getByToday(){
		return ResponseEntity.ok(stockService.findByToday()); 
	}
	
	
	
	
}
