package com.system.xianbozhan.service;

import java.util.List;

import com.system.xianbozhan.entity.Department;
import com.system.xianbozhan.entity.Role;
import com.system.xianbozhan.entity.Search;

public interface SystemService {

	public List<Department> getDepartmentName();
	
	
	public List<Role> getRoleName();
	
	
	public List<Search> getSearchList();
}