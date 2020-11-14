package com.ant.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Theme;
import com.ant.formation.repositories.ThemeRepository;
import com.ant.formation.services.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService {

     @Autowired
     private ThemeRepository themeRepository;

    @Override
    public MessageResponse save(Theme theme) {

        boolean exist = themeRepository.existsByLibelle(theme.getLibelle());
        if(exist){
            return  new MessageResponse(false, "Attention", "Théme existe déjà");
        }

        themeRepository.save(theme);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Theme theme) {
    boolean exist = themeRepository.existsByLibelle(theme.getLibelle());
    if(exist) {

            return  new MessageResponse(false, "Attention", "Théme existe déjà");

    }




        themeRepository.save(theme);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {


            boolean exist = themeRepository.existsByIdAndFormateurThemesIsNotNullOrFormationsIsNotNull(id);
            if(exist){
                return  new MessageResponse(false, "Attention",
                        "Theme affecté a un ou plusieurs formateurs ou formations");
            }


        themeRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme findByLibelle(String libelle) {
        return themeRepository.findByLibelle(libelle);
    }

	@Override
	public List<Theme> findByFormateur(Integer id) {
		Formateur formateur = new Formateur();
		formateur.setId(id);
		return themeRepository.findByFormateurThemes_Formateur(formateur);
	}
}
