package com.bolsadeideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	private List<Role> roleList;
	
	

	public RoleServiceImpl() {
		roleList = new ArrayList<>();
		roleList.add(new Role(1,"user","user_role"));
		roleList.add(new Role(2,"moderator","moderator_role"));
		roleList.add(new Role(3,"admin","admin_role"));
	}

	@Override
	public List<Role> getRoleList() {
		return roleList;
	}

	@Override
	public Role getRoleById(Integer id) {
		Role result = null;
		for (Role role : roleList) {
			if (id == role.getId()) {
				result = role;
				break;
			}
		}
		return result;
	}

}
