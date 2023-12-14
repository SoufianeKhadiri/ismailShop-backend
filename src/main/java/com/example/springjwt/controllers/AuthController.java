package com.example.springjwt.controllers;

import com.example.springjwt.auth.JwtUtil;
import com.example.springjwt.model.User;
import com.example.springjwt.model.request.LoginReq;
import com.example.springjwt.model.response.ErrorRes;
import com.example.springjwt.model.response.LoginRes;
import com.example.springjwt.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {


    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Bean
        private PasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();

        }

    private final AuthenticationManager authenticationManager;


    private CustomUserDetailsService customUserDetailsService;

    private JwtUtil jwtUtil;

   /* public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }*/

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginReq loginReq) {



        try {
                final Authentication authentication = authenticationManager.authenticate(
                              new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword())
                      );

                   SecurityContextHolder.getContext().setAuthentication(authentication);
                   UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginReq.getEmail());
                   String token = jwtUtil.generateToken(userDetails);
                   LoginRes loginRes = new LoginRes(loginReq.getEmail(), token) ;
                   return ResponseEntity.ok(loginRes);

          /*  Authentication authentication =*/
          /*  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));*/
/**/
          /*  SecurityContextHolder.getContext().setAuthentication(authentication);*/
/**/
          /*  String email = authentication.getName();*/
          /* // User user = new User(email, "", "");*/
          /*   User user = (User) customUserDetailsService.loadUserByUsername("test@example.com");*/
          /*  String token = jwtUtil.createToken(user);*/
          /*  LoginRes loginRes = new LoginRes(email, token);*/
/**/
          /*  return ResponseEntity.ok(loginRes);*/

        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User usr) {
        customUserDetailsService.save(usr);
    }

    @ResponseBody
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User> findAll() {
        return customUserDetailsService.findAll();
    }
}