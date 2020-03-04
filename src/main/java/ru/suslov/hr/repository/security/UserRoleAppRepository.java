package ru.suslov.hr.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suslov.hr.entity.security.UserRoleApp;

@Repository
public interface UserRoleAppRepository extends JpaRepository<UserRoleApp, Long> {
}
