package edu.cibertec.i202222124.conca_chavarria_jheremy.controller;

import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> users = manageService.getAllCars();
            model.addAttribute("cars", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos.");

        }
        return "home";

    }

}
