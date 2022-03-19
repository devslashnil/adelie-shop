package com.devslashnil.adelie.security;

import com.devslashnil.adelie.dto.UserDTO;
import com.devslashnil.adelie.service.AccountService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Реализация сервиса извлечения аккаунта пользователя из БД.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException
    {
        Optional<? extends UserDTO.BaseInfo> userDto = accountService.findByEmail(login);
        return buildUser(userDto.orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    private User buildUser(UserDTO.BaseInfo account) {
        String login = account.getEmail();
        String password = account.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (UserDTO.Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getValue()));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(login, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
