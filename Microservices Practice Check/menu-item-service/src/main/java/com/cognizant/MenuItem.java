package com.cognizant;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "menuitems")
@Data
public class MenuItem {
	@Id
	private long id;
	@Column
	private String name;
	@Column
	private float price;
	@Column
	private boolean active;
	@Column
	private Date dateOfLaunch;
	@Column
	private String category;
	@Column
	private boolean freeDelivery;
}
