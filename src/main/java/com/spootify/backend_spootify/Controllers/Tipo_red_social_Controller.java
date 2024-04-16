package com.spootify.backend_spootify.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spootify.backend_spootify.Models.Tipo_red_social;
import com.spootify.backend_spootify.Models.red_social;
import com.spootify.backend_spootify.Services.Impl.Tipo_red_social_Service_Impl;

@Controller
@RequestMapping("/tipo_red")
public class Tipo_red_social_Controller {
    
    @Autowired 
    private Tipo_red_social_Service_Impl tipo_red_social_Service_Impl;

    @GetMapping("/obtener")
    @ResponseBody
    public Map<String, String> obtenerRed_socials(){
        return this.tipo_red_social_Service_Impl.obtenerRedesSociales();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public Map<String, String> buscarRed_social(@RequestParam(name = "id") int id){
        return this.tipo_red_social_Service_Impl.obtenerRedSocial(id);
    }

    @PostMapping("/insertar")
    @ResponseBody
    public void insertarRedSocial(@RequestBody com.spootify.backend_spootify.Models.red_social red_social){
        this.tipo_red_social_Service_Impl.insertarRedSocial(red_social);
    }

    @PutMapping("/actualizar")
    @ResponseBody
    public void actualizarRedSocial(@RequestParam(name = "id") int id,@RequestBody red_social red_social){
        this.tipo_red_social_Service_Impl.actualizarRedSocial(id, red_social);
    }

    @DeleteMapping("/eliminar")
    @ResponseBody
    public void eliminarRedSocial(@RequestParam(name = "id") int id){
        this.tipo_red_social_Service_Impl.eliminarRedSocial(id);
    }

}
