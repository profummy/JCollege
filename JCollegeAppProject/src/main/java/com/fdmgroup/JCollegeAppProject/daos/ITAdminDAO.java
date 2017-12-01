package com.fdmgroup.JCollegeAppProject.daos;

import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;

public interface ITAdminDAO {

	public ITAdmin getITAdmin(String username);
	
	public void updateITAdmin(ITAdmin itAdmin);
	
	public void addITAdmin (ITAdmin itAdmin);
	
	public void removeITAdmin (String username);

}
