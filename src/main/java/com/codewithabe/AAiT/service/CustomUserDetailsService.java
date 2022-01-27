package com.codewithabe.AAiT.service;

import com.codewithabe.AAiT.models.Role;
import com.codewithabe.AAiT.models.Student;
import com.codewithabe.AAiT.repository.UserRepository;
import com.codewithabe.AAiT.web.dto.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
       @Autowired
       private UserRepository userRepository;
       @Autowired
       private BCryptPasswordEncoder passwordEncoder;

       public CustomUserDetailsService(UserRepository userRepository) {
           super();
           this.userRepository = userRepository;
       }

       public Student save(RegistrationForm form) {
           Student student = new Student(form.getFirstName(),
                   form.getLastName(), form.getUgr(),
                   passwordEncoder.encode(form.getPassword()), Set.of(new Role("ROLE_USER")));

           return userRepository.save(student);
       }

       @Override
       public UserDetails loadUserByUsername(String ugr) throws UsernameNotFoundException {

           Student student = userRepository.findByUgr(ugr);
           if(student != null) {
               return new CustomUserDetails(student);
           }
           throw new UsernameNotFoundException("Invalid user email or password");
       }

       private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
           return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
       }
}


