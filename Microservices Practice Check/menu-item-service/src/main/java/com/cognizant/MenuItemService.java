package com.cognizant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
	@Autowired
	MenuItemRepository repository;
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return repository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		 return repository.findByActiveTrueAndDateOfLaunchBefore(new Date());
	}

	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		Optional<MenuItem> m = repository.findById(menuItemId);
		if(m.isPresent())
			return m.get();
		return null;
	}
	@Transactional
	public String modifyMenuItem(MenuItem menuItem) {
		Optional<MenuItem> m = repository.findById(menuItem.getId());
		if(m.isPresent()) {
			repository.save(menuItem);
			return "SuccessFully Updated";
		}
		return "MenuItem not present.";
	}
}