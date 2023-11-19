package ru.itmentor.spring_boot.restTemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring_boot.restTemplate.model.Role;
import ru.itmentor.spring_boot.restTemplate.repositories.RoleRepository;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) { this.roleRepository = roleRepository; }

    @Override
    @Transactional
    public void add(Role role) { this.roleRepository.save(role); }

    @Override
    @Transactional
    public List<Role> listRoles() {return this.roleRepository.findAll(); }
}
