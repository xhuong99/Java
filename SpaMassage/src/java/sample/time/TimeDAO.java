/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.time;

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
public class TimeDAO implements Serializable{
    private List<TimeDTO> listDay;

    public List<TimeDTO> getListDay() {
        return listDay;
    }
    
    public void getTimeOpen() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, day, time from Time";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String id = rs.getString("id");
                    String day = rs.getString("day");
                    String time = rs.getString("time");
                    
                    TimeDTO dto = new TimeDTO(id, day, time);
                    if (this.listDay == null) {
                        this.listDay = new ArrayList<>();
                    }
                    this.listDay.add(dto);
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
