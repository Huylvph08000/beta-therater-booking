package com.acazia.betatheater.repository;


import com.acazia.betatheater.models.ERole;
import com.acazia.betatheater.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
