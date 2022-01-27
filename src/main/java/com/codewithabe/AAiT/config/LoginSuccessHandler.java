package com.codewithabe.AAiT.config;

import com.codewithabe.AAiT.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @Component
    public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws ServletException , IOException {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String redirectURl = request.getContextPath();

            if (userDetails.hasRole("ROLE_USER")){
                redirectURl +="/home";
            }
            else if(userDetails.hasRole("ROLE_ADMIN")){
                redirectURl += "/admindashboard";
            }
            response.sendRedirect(redirectURl);
        }
    }

