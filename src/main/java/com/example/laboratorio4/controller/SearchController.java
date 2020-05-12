package com.example.laboratorio4.controller;


import com.example.laboratorio4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    LocationsRepository locationsRepository;

    @GetMapping(value = {"", "/"})
    public String indice() {
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalrio(Model model) {
        model.addAttribute("listaEmpleadosMayorSalario",employeesRepository.empleadoMayorSalario());

        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar() {

        //COMPLETAR
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais() {

        //COMPLETAR
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep() {
        //COMPLETAR
        return "/Search/lista3";

    }


}
