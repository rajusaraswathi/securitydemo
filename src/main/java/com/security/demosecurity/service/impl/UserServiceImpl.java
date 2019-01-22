package com.security.demosecurity.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl  {
  /*  @Autowired
    private UserRepository userRepository;

    @Override
    public Employee findByUsername( String username ) throws UsernameNotFoundException {
        Employee u = userRepository.findByUsername( username );
        return u;
    }

    public Employee findById( Long id ) throws AccessDeniedException {
        Employee u = userRepository.findOne( id );
        return u;
    }

    public List<Employee> findAll() throws AccessDeniedException {
        List<Employee> result = userRepository.findAll();
        return result;
    }*/
}
