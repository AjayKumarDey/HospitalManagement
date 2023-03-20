package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	@Autowired
	ItemService itemService;

	@PostMapping("/item")
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	@PutMapping("/item")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@RequestBody Item item) {

		return itemService.updateItem(item);
	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItem(@PathVariable int id) {
		return itemService.deleteItem(id);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<Item>> getItem(@PathVariable int id) {
		return itemService.getItem(id);
	}

	@GetMapping("/item/all")
	public ResponseEntity<ResponseStructure<List<Item>>> getAll() {
		return itemService.getAll();
	}
}
