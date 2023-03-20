package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	@Autowired
	ItemRepository repository;

	public Item saveItem(Item item) {
		return repository.save(item);
	}

	public Item updateItem(Item item) {
		return repository.save(item);
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

	public Optional<Item> getItem(int id) {
		return repository.findById(id);
	}

	public List<Item> getAll() {
		return repository.findAll();
	}

}
