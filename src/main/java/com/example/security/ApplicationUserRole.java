package com.example.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(new HashSet<>(Arrays.asList(USER_READ)))),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE,USER_READ,USER_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,COURSE_READ,USER_WRITE)),
    STRANGER(new HashSet<>()),
    USER(new HashSet<>()),
    INSPECTOR(new HashSet<>());

    private final Set<ApplicationUserPermission> permissions;

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
         Set<SimpleGrantedAuthority> authorities = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.toString()));
        return authorities;
    }

}
