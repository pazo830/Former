package com.mycompany.mywebapp.com.mycompany.mywebapp.user.Repository;

import com.mycompany.mywebapp.com.mycompany.mywebapp.user.model.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<Userss, Long> {

        Userss findByEmail(String email);

    }

