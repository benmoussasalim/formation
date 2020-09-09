package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.dto.PasswordDto;
import com.ant.formation.entities.Users;

import java.util.List;

public interface UserService {
    public MessageResponse save(Users user);
    public MessageResponse update(Users user);
    public MessageResponse delete(Integer id);
    public List<Users> findAll();
    public Users findByID(Integer id);
    public MessageResponse changePassword(PasswordDto passwordDto);
    public MessageResponse changeState(Integer id);


}
