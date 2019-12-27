/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.employee;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.util.DBUtil;

/**
 *
 * @author leehe
 */
public class EmployeeDAO implements Serializable{
    private List<EmployeeDTO> listEmployee;

    public List<EmployeeDTO> getListEmployee() {
        return listEmployee;
    }
    
    public void getAllEmployee() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, name, job, introduction, phone, email, img, isManager from Employee";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String job = rs.getString("job");
                    String introduction = rs.getString("introduction");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String img = rs.getString("img");
                    boolean isManager = rs.getBoolean("isManager");
                    
                    EmployeeDTO dto = new EmployeeDTO(id, name, job, introduction, phone, email, img, isManager);
                    if (this.listEmployee == null) {
                        this.listEmployee = new ArrayList<>();
                    }
                    this.listEmployee.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public EmployeeDTO getManager() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, name, job, introduction, phone, email, img, isManager from Employee where isManager = 1";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String job = rs.getString("job");
                    String introduction = rs.getString("introduction");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String img = rs.getString("img");
                    boolean isManager = rs.getBoolean("isManager");
                    
                    EmployeeDTO dto = new EmployeeDTO(id, name, job, introduction, phone, email, img, isManager);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
