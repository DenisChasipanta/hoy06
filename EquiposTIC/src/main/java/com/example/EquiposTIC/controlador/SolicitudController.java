package com.example.EquiposTIC.controlador;

import com.example.EquiposTIC.entidad.Persona;
import com.example.EquiposTIC.entidad.Solicitud;
import com.example.EquiposTIC.repositorio.PersonaRepository;
import com.example.EquiposTIC.repositorio.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SolicitudController {
    @Autowired
    SolicitudRepository solicitudRepository;
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/solicitudes")
    public String solicitud(Model model){
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        model.addAttribute("solicitudes",solicitudes);
        return "solicitud/solicitudes";
    }
    @GetMapping("/solicitud/form")
    public  String form(Model model){
        model.addAttribute("solicitudes", new Solicitud());
        List<Persona> personas = personaRepository.findAll();
        model.addAttribute("personas",personas);
        return "solicitud/formulario";
    }
    @PostMapping("/solicitud/form")
    public String crear(Solicitud solicitud){
        solicitudRepository.save(solicitud);
        return "redirect:/solicitudes";
    }
    //EDITAR
    @GetMapping("/solicitud/editar/{numeroCodigo}")
    public String editar(@PathVariable Integer numeroCodigo, Model model){
        Optional<Solicitud> solicitudes = solicitudRepository.findById(numeroCodigo);
        model.addAttribute("solicitudes",solicitudes);
        return "/solicitud/formulario";
    }
    //ELIMINAR
    @GetMapping("/solicitud/eliminar/{numeroCodigo}")
    public String eliminar(@PathVariable Integer numeroCodigo){
        solicitudRepository.deleteById(numeroCodigo);
        return "redirect:/solicitudes";
    }

}
