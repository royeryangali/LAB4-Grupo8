package com.example.laboratorio4.controller;

import com.example.laboratorio4.repository.DepartmentsRepository;
import com.example.laboratorio4.repository.EmployeesRepository;
import com.example.laboratorio4.repository.HistoryRepository;
import com.example.laboratorio4.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    public String historialEmpleado(Model model){

        model.addAttribute("historialEmpleado", historyRepository.historialEmpleados());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());
        model.addAttribute("listaEmployees", employeesRepository.findAll());
        model.addAttribute("listaJefes",employeesRepository.findAll());
        return "history/lista";
    }
}
