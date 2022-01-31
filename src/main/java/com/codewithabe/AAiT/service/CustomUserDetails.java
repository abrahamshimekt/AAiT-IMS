package com.codewithabe.AAiT.service;

import com.codewithabe.AAiT.models.Role;
import com.codewithabe.AAiT.models.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
   private final Student student;
   public CustomUserDetails(Student student){
       this.student = student;
   }
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       Set<Role> roles = student.getRoles();
       List<SimpleGrantedAuthority> authorities  = new ArrayList<>();
       for(Role role:roles){
           authorities.add(new SimpleGrantedAuthority(role.getName()));
       }
       return authorities;
   }
   public boolean hasRole(String roleName){
       return this.student.hasRole(roleName);
   }

   @Override
   public String getPassword() {
       return this.student.getPassword();
   }

   @Override
   public String getUsername() {
       return this.student.getUgr();
   }

   @Override
   public boolean isAccountNonExpired() {
       return true;
   }

   @Override
   public boolean isAccountNonLocked() {
       return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
       return true;
   }

   @Override
   public boolean isEnabled() {
       return true;
   }

}
