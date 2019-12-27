/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.service;

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
public class ServiceDAO implements Serializable{
    private List<ServiceDTO> listService;

    public List<ServiceDTO> getListService() {
        return listService;
    }
    
    public void getAllService() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, title, intro, img from Service";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {                    
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String intro = rs.getString("intro");
                    String img = rs.getString("img");
                    
                    ServiceDTO dto = new ServiceDTO(id, title, intro, img);
                    if (this.listService == null) {
                        this.listService = new ArrayList<>();
                    }
                    this.listService.add(dto);
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
}
