package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formation;
import java.util.List;

public interface FormationService {
    public MessageResponse save(Formation formation);
    public MessageResponse update(Formation formation);
    public MessageResponse delete(Integer id);
    public List<Formation> findAll();
}
