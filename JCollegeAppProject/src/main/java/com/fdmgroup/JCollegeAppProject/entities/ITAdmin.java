package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ITAdmin")
public class ITAdmin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public ITAdmin() {
		super();
	}

}