package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.EmpleadoPorSearch;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(value ="SELECT e.first_name as Nombre, e.last_name as Apellido, e.email as Correo, e.password as Contrasena, j.job_title as Cargo, e.salary as Salario, h.first_name as Jefe, d.department_name as Departamento\n" +
            "FROM employees e INNER JOIN jobs j on (e.job_id=j.job_id)\n" +
            "INNER JOIN employees h on (e.manager_id=h.employee_id)\n" +
            "INNER JOIN departments d on (e.department_id=d.department_id) \n" +
            "INNER JOIN locations l on (d.location_id=l.location_id)\n" +
            "INNER JOIN countries c on (l.country_id=c.country_id)\n" +
            "INNER JOIN regions r on (r.region_id=c.region_id)\n" +
            "WHERE e.first_name = ?1 OR e.last_name= ?1 OR j.job_title = ?1 OR d.department_name = ?1 OR l.city=?1;",nativeQuery=true)
    List<EmpleadoPorSearch> empleadoporSearch (String busqueda);



}
