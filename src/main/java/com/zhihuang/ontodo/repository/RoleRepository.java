package com.zhihuang.ontodo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zhihuang.ontodo.entity.ERole;
import com.zhihuang.ontodo.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByRoleName(ERole roleName);
}
