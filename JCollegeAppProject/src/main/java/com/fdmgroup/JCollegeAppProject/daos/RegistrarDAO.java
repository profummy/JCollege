package com.fdmgroup.JCollegeAppProject.daos;

import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public interface RegistrarDAO {

	public Registrar getRegistrar(String username);
	
	public void updateRegistrar(Registrar registrar);

	public void addRegistrar(Registrar registrar);

	public void removeRegistrar(String username);

}
