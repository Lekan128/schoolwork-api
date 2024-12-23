package com.lekan.schoolwork.config;

import com.lekan.schoolwork.temp.user.TemporaryUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Order
@Component
@AllArgsConstructor
public class AllowEntityEditFilter extends OncePerRequestFilter {
    private final TemporaryUserRepository temporaryUserRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String name = request.getHeader("NAME");
        temporaryUserRepository.findByName(name).orElseThrow(() -> new BadRequestException("You shall not pass"));
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getMethod().equals("GET");
    }
}
