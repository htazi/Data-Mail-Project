package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.repository.AppUserRepository;
import edu.ccsu.datamail.jobtracker.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    private final AppUserRepository appUserRepository;

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepository appUserRepository, UserRoleRepository userRoleRepository)
    {
        this.appUserRepository = appUserRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        Optional<AppUser> appUserContainer = this.appUserRepository.findByUserName(userName); // attempt to pull a user
        AppUser appUser;
        if (!appUserContainer.isPresent()) { // throw an exception if no user was found
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        else { // get the app user if one was found
            appUser = appUserContainer.get();
        }
        System.out.println("Found User: " + appUser);
        List<String> roleNames = userRoleRepository.getRoleNames(appUser.getUserId()); // [ROLE_USER, ROLE_ADMIN,..]

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),
                appUser.getEncryptedPassword(), grantList);

        return userDetails;
    }

}