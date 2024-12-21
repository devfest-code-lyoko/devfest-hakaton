package com.example.backend.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.ServiceRepo;
import com.example.backend.models.Service;
import com.example.backend.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
    @GetMapping("/getAllServices")
    public ArrayList<Service> getAllServices() {
        return new ServiceRepo().getAllServices();
    }

    @PostMapping("/getService")
    public Service getService(@RequestParam String name) {
        return new ServiceRepo().getService(name);
    }
    
    @PostMapping("/createService")
    public int createService(@RequestBody Service service) {
        return new ServiceRepo().createService(service);
    }

    @PostMapping("/removeService")
    public int removeService(@RequestBody Service service) {
        return new ServiceRepo().removeService(service);
    }

    @PostMapping("/pickService")
    public int pickService(@RequestBody User user, @RequestBody Service service) {
        return new ServiceRepo().pickService(user, service);
    }
    
}
