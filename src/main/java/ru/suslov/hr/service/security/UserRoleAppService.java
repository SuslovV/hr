package ru.suslov.hr.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import ru.suslov.hr.repository.security.UserRoleAppRepository;

public class UserRoleAppService {

    @Autowired
    UserRoleAppRepository userRoleAppRepository;
}
