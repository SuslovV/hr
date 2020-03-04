package ru.suslov.hr.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.suslov.hr.entity.security.RoleApp;

import java.util.List;

@Repository
public interface RoleAppRepository extends JpaRepository<RoleApp, Long> {
    @Query("select roleApp.name from UserRoleApp where userApp.id = ?1")
    public List<String> getRoleNames(Long userAppId);

    RoleApp findByName(String name);
}
