package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.ItemDao;
import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item) {
		ResponseStructure<Item> structure = new ResponseStructure<Item>();
		structure.setBody(itemDao.saveItem(item));
		structure.setMessage("Item saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item) {
		ResponseStructure<Item> structure = new ResponseStructure<Item>();
		structure.setBody(itemDao.updateItem(item));
		structure.setMessage("Item Updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteItem(int id) {
		Optional<Item> recItem = itemDao.getItem(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recItem.isPresent()) {
			itemDao.deleteById(id);
			structure.setBody("Item found");
			structure.setMessage("Item found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			throw new IdNotFoundException();
		}

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Item>> getItem(int id) {
		Optional<Item> recItem = itemDao.getItem(id);
		ResponseStructure<Item> structure = new ResponseStructure<Item>();
		if (recItem.isPresent()) {
			structure.setBody(recItem.get());
			structure.setMessage("Item found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			throw new IdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Item>>> getAll() {
		ResponseStructure<List<Item>> structure = new ResponseStructure<List<Item>>();
		structure.setBody(itemDao.getAll());
		structure.setMessage("List of Item ");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Item>>>(structure, HttpStatus.FOUND);
	}
}
