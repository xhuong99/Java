/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.course;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class CourseDAO implements Serializable{
    private List<CourseDTO> listCourse;

    public List<CourseDTO> getListCourse() {
        return listCourse;
    }
    
    public void getAllCourse() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, title, info, intro, date, price from Course";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String info = rs.getString("info");
                    String intro = rs.getString("intro");
                    String date = rs.getString("date");
                    float price = rs.getFloat("price");
                    
                    CourseDTO dto = new CourseDTO(id, title, info, intro, date, price);
                    if (this.listCourse == null) {
                        this.listCourse = new ArrayList<>();
                    }
                    this.listCourse.add(dto);
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
    
    public String getDate(String date) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select convert(varchar, cast(? as date), 107)";
                ps = con.prepareStatement(sql);
                ps.setString(1, date);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public void getCourseSortByDate() throws NamingException, SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, title, info, intro, date, price from Course order by date";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String info = rs.getString("info");
                    String intro = rs.getString("intro");
                    String date = getDate(rs.getString("date"));
                    float price = rs.getFloat("price");
                    
                    CourseDTO dto = new CourseDTO(id, title, info, intro, date, price);
                    if (this.listCourse == null) {
                        this.listCourse = new ArrayList<>();
                    }
                    this.listCourse.add(dto);
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
