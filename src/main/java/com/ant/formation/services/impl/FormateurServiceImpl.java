package com.ant.formation.services.impl;

import com.ant.formation.dto.FormateurThemeRequest;
import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.FormateurTheme;
import com.ant.formation.entities.FormateurThemeId;
import com.ant.formation.entities.Theme;
import com.ant.formation.repositories.FormateurRepository;
import com.ant.formation.repositories.FormateurThemeRepository;
import com.ant.formation.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private FormateurThemeRepository formateurThemeRepository;

    @Transactional
    @Override
    public MessageResponse save(FormateurThemeRequest formateurThemeRequest) {


        boolean exist = formateurRepository.existsByEmail(formateurThemeRequest.getFormateur().getEmail());
        if (exist) {
            return new MessageResponse(false, "Attention", "Email existe déjà");
        }

        formateurRepository.save(formateurThemeRequest.getFormateur());


        for (Theme theme : formateurThemeRequest.getThemes()) {
            FormateurTheme ft = new FormateurTheme();
            FormateurThemeId id = new FormateurThemeId();
            id.setIdFormateur(formateurThemeRequest.getFormateur().getId());
            id.setIdTheme(theme.getId());
            ft.setId(id);
            formateurThemeRepository.save(ft);
        }


        return new MessageResponse(true, "Succès", "Opération effectuée");
    }
@Transactional
    @Override
    public MessageResponse update(FormateurThemeRequest formateurThemeRequest) {


        boolean exist = formateurRepository.existsByEmailAndId(formateurThemeRequest.getFormateur().getEmail(), formateurThemeRequest.getFormateur().getId());
        if (!exist) {
            exist = formateurRepository.existsByEmail(formateurThemeRequest.getFormateur().getEmail());
            if (exist) {
                return new MessageResponse(false, "Attention", "Email existe déjà");
            }
        }

        formateurThemeRepository.deleteByFormateur(formateurThemeRequest.getFormateur());
        formateurRepository.save(formateurThemeRequest.getFormateur());


        for (Theme theme : formateurThemeRequest.getThemes()) {
            FormateurTheme ft = new FormateurTheme();
            FormateurThemeId id = new FormateurThemeId();
            id.setIdFormateur(formateurThemeRequest.getFormateur().getId());
            id.setIdTheme(theme.getId());
            ft.setId(id);
            formateurThemeRepository.save(ft);
        }


        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Transactional
    @Override
    public MessageResponse delete(Integer id) {
        boolean exist = formateurRepository.existsByIdAndFormationsIsNotNull(id);
        if (exist) {
            return new MessageResponse(false, "Attention",
                    "Formateur affecté a un ou plusieurs formations");
        }
        Formateur formateur = new Formateur();
        formateur.setId(id);
        formateurThemeRepository.deleteByFormateur(formateur);
        formateurRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Override
    public List<Formateur> findByTheme(Integer id) {
        Theme theme = new Theme();
        theme.setId(id);
        return formateurRepository.findByFormateurThemes_Theme(theme);
    }

    @Override
    public Formateur findByID(Integer id) {
        return formateurRepository.findById(id).orElse(null);
    }


}
