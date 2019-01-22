package com.security.demosecurity.service.impl;

import com.security.demosecurity.model.Employee;
import com.security.demosecurity.model.User;
import com.security.demosecurity.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    protected final Log LOGGER = LogFactory.getLog(getClass());
    @Autowired
    UserRepository userRepository;

    /*@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;*/

    /*@Autowired
    private AuthenticationManager authenticationManager;
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<Employee> user= userRepository.findAll().stream().
                  filter(x->x.getUserId().equals(username)).findAny();

        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            User user1=new User();
            user1.setUsername(user.get().getUserId());
            user1.setPassword(user.get().getPassword());
            user1.setRole("Admin");

            return user1;
        }
    }

   /* public void changePassword(String oldPassword, String newPassword) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();

        if (authenticationManager != null) {
            LOGGER.debug("Re-authenticating user '"+ username + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            LOGGER.debug("No authentication manager set. can't change Password!");

            return;
        }

        LOGGER.debug("Changing password for user '"+ username + "'");

        Employee user = (Employee) loadUserByUsername(username);

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

    }*/
}
