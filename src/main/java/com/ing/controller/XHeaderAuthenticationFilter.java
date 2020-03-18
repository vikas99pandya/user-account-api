package com.ing.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Filter to check authentication of the user, user should provide id token in http request for authentication
 */
public class XHeaderAuthenticationFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

            String auth = request.getHeader("Authorization");

            User user = findByToken(auth);

            if (user == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalid");
            } else {
                final UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

                filterChain.doFilter(request, response);
            }
        }

       //need to implement db user validation...and also token validation here
       // For now everthing will go through
        private User findByToken(String token) {

            final User user = new User(
                    "test1",
                    "test1",
                    true,
                    true,
                    true,
                    true,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

            return user;
        }
    }
