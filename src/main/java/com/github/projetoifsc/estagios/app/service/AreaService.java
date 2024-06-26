package com.github.projetoifsc.estagios.app.service;

import com.github.projetoifsc.estagios.app.model.response.Area;
import com.github.projetoifsc.estagios.app.security.auth.UserPrincipal;
import com.github.projetoifsc.estagios.core.IAreaUseCases;
import com.github.projetoifsc.estagios.app.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    private final IAreaUseCases areaUseCases;
    private final Mapper mapper;

    public AreaService(IAreaUseCases areaUseCases, Mapper mapper) {
        this.areaUseCases = areaUseCases;
        this.mapper = mapper;
    }

    public List<Area> getAll(UserPrincipal userPrincipal) {
        var areas = areaUseCases.getAll();
        return areas.stream()
                .map(area -> mapper.map(area, Area.class))
                .toList();
    }

    public Area getById(UserPrincipal userPrincipal, String id) {
        var area= areaUseCases.getById(id);
        return mapper.map(area, Area.class);
    }


}
