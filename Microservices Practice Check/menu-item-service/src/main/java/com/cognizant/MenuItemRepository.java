package com.cognizant;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	public List<MenuItem> findByActiveTrueAndDateOfLaunchBefore(Date dateOfLaunch);
}
