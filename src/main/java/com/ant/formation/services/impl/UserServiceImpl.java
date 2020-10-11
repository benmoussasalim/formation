package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.dto.PasswordDto;
import com.ant.formation.entities.Users;
import com.ant.formation.enums.Role;
import com.ant.formation.repositories.UsersRepository;
import com.ant.formation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MessageResponse save(Users user) {

        boolean exist = userRepository.existsByUsername(user.getUsername());
        if (exist) {
            return new MessageResponse(false, "Attention", "Nom d'utilisateur existe déjà");
        }
        exist = userRepository.existsByEmail(user.getEmail());
        if (exist) {
            return new MessageResponse(false, "Attention", "Email existe déjà");
        }

        String cryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(cryptedPassword);
        user.setEnabled(true);
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Users user) {
        boolean exist = userRepository.existsByUsernameAndId(user.getUsername(), user.getId());
        if (!exist) {
            exist = userRepository.existsByUsername(user.getUsername());
            if (exist) {
                return new MessageResponse(false, "Attention", "Nom d'utilisateur existe déjà");
            }
        }


        exist = userRepository.existsByEmailAndId(user.getEmail(), user.getId());
        if (!exist) {
            exist = userRepository.existsByEmail(user.getEmail());
            if (exist) {
                return new MessageResponse(false, "Attention", "Email existe déjà");
            }
        }


        userRepository.save(user);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {


        boolean exist = userRepository.existsByIdAndPaimentsNotNull(id);
        if (exist) {
            return new MessageResponse(false, "Attention",
                    "Users affecté a plusieurs opérations");
        }


        userRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findByRole(Role.ROLE_USER);
    }

    @Override
    public Users findByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public MessageResponse changePassword(PasswordDto passwordDto) {

        Users user = findByID(passwordDto.getId());
        if(user ==null) {
            return new MessageResponse(false, "Attention", "Utilisateur n'existe pas");
        }
        boolean matched = passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword());
        if(!matched) {
            return new MessageResponse(false, "Attention", "Ancien mot de passe incorrect");
        }


        String cryptedPassword = passwordEncoder.encode(passwordDto.getNewPassword());

        user.setPassword(cryptedPassword);

        userRepository.save(user);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse changeState(Integer id) {
        Users user = findByID(id);
        if(user ==null) {
            return new MessageResponse(false, "Attention", "Utilisateur n'existe pas");
        }

        user.setEnabled(!user.isEnabled());

        userRepository.save(user);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }
}
