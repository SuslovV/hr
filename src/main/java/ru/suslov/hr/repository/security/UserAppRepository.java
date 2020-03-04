package ru.suslov.hr.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suslov.hr.entity.security.UserApp;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    UserApp findByName(String name);
}
