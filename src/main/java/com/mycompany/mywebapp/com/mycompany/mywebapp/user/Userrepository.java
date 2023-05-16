package com.mycompany.mywebapp.com.mycompany.mywebapp.user;

import org.springframework.data.repository.CrudRepository;

public interface Userrepository extends CrudRepository<User ,Integer> {
public Long countById(Integer id);








}
