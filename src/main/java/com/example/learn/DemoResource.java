package com.example.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@Validated
public class DemoResource {

    @Autowired
    DataDao dataDao;

    @GetMapping(path="/book")
    public ResponseEntity getData(){
        List<Employee> employeeList = dataDao.findAll();

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(path="/books", method = RequestMethod.GET)
    public ResponseEntity getData1(){
        List<Employee> employeeList = dataDao.findAll();

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(path="/book")
    public ResponseEntity insertData(@NotNull @RequestBody Employee employee){
        Employee emp = dataDao.save(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping(path="/books/{id}")
    public ResponseEntity insertData(@PathVariable long id, @NotNull @RequestBody Employee employee) throws Exception {
        Optional<Employee> emp = dataDao.findById(id);
        Employee emp1 = null;
        if(emp.isPresent()){
            emp.get().setName(employee.getName());
            emp1 = dataDao.save(emp.get());
        } else{
            throw new Exception("not found");
        }
        return new ResponseEntity<>(emp1, HttpStatus.ACCEPTED);
    }
}
