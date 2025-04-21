package com.example.duancanhan.service.implement;



import com.example.duancanhan.model.Role;
import com.example.duancanhan.repository.RoleRepository;
import com.example.duancanhan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
