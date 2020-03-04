package ru.suslov.hr.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.suslov.hr.repository.security.RoleAppRepository;

@Service
public class RoleAppService {

    @Autowired
    RoleAppRepository roleAppRepository;
}
