package com.spootify.backend_spootify.Service;

import com.spootify.backend_spootify.Dtos.homeDto;
import com.spootify.backend_spootify.Dtos.homeViewDto;

public interface Home_Service {
    
    public homeDto traerHome(int id);

    public homeViewDto getHome(int id);

}
