package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.repositories.FormateurRepository;
import com.ant.formation.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    @Override
    public MessageResponse save(Formateur formateur) {


        boolean exist = formateurRepository.existsByEmail(formateur.getEmail());
        if (exist) {
            return new MessageResponse(false, "Attention", "Email existe déjà");
        }


        formateurRepository.save(formateur);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Formateur formateur) {


        boolean exist = formateurRepository.existsByEmailAndId(formateur.getEmail(), formateur.getId());
        if (!exist) {
            exist = formateurRepository.existsByEmail(formateur.getEmail());
            if (exist) {
                return new MessageResponse(false, "Attention", "Email existe déjà");
            }
        }


        formateurRepository.save(formateur);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {
        boolean exist = formateurRepository.existsByIdAndFormationsIsNotNull(id);
        if (exist) {
            return new MessageResponse(false, "Attention",
                    "Formateur affecté a un ou plusieurs formations");
        }


        formateurRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur findByID(Integer id) {
        return formateurRepository.findById(id).orElse(null);
    }
}
