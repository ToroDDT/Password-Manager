package com.example.SecurityAPI.Service;
import com.example.SecurityAPI.Entity.User;
import com.example.SecurityAPI.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new  UsernameNotFoundException(username);
        }
        return new MyUser(user);
    }
}
