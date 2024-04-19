package com.girly.schtick.springsecuritydemo.filter;

import com.girly.schtick.springsecuritydemo.service.JWTService;
import com.girly.schtick.springsecuritydemo.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Objects;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

  @Autowired
  private JWTService jwtService;

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain)
      throws IOException, ServletException {
    String token = null;
    String userName = null;
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer")) {
      token = authHeader.substring(7);
      userName = jwtService.extractUsername(token);
    }

    if (Objects.nonNull(userName)
        && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails user = userDetailsServiceImpl.loadUserByUsername(userName);
      if (jwtService.validateToken(token)) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
