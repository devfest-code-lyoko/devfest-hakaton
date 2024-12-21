package com.example.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.backend.models.Service;
import com.example.backend.models.User;

public class ServiceRepo implements ServiceRepoInterface {

    @Override
    public ArrayList<Service> getAllServices() {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stmt = con.prepareStatement("select * from services");) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Service> allServices = new ArrayList<>();
            while(rs.next()){
                Service b = new Service(
                    rs.getInt("id"),
                    rs.getString("senior_username"),
                    rs.getString("description"),
                    rs.getString("address"),
                    rs.getInt("price"),
                    rs.getString("name"));
                allServices.add(b);
            }
            return allServices;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Service getService(String name) {
        try (Connection con = DB.source().getConnection();
        PreparedStatement stmt = con.prepareStatement("select * from services where name = ?")){
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Service ser = new Service(
                    rs.getInt("id"),
                    rs.getString("senior_username"),
                    rs.getString("description"),
                    rs.getString("address"),
                    rs.getInt("price"),
                    rs.getString("name"));

                return ser;
            }      
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int createService(Service service) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO services (id, senior_username, address, price, name) VALUES (?, ?, ?, ?, ?")){

                stm.setInt(1, service.getId());
                stm.setString(2, service.getSenior_username());
                stm.setString(3, service.getAddress());
                stm.setInt(4, service.getPrice());
                stm.setString(5, service.getName());

            return stm.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int removeService(Service service) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM services WHERE id = ?")){
                stm.setInt(1, service.getId());

                return stm.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int pickService(User user, Service service) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT FROM services where id = ? and helper_username = ?")){
                stm.setInt(1, service.getId());
                stm.setString(2, null);
                
                ResultSet res = stm.executeQuery();
                if(res.next()){
                    try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO services (helper_username) VALUES (?)")) {
                            stmt.setString(1, user.getUsername());
                            return stm.executeUpdate();
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch(SQLException e) {
                e.printStackTrace();
            }
            return -1;
    }

}
