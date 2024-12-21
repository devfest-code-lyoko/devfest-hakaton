package com.example.backend.db;

import java.util.ArrayList;

import com.example.backend.models.Service;
import com.example.backend.models.User;

public interface ServiceRepoInterface {

    public ArrayList<Service> getAllServices();
    public Service getService(int id);
    public int createService(Service service);
    public int removeService(Service service);
    public int pickService(User user, Service service);
}
