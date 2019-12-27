/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.introduction;

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
public class IntroductionDAO implements Serializable {
    private List<IntroductionDTO> listIntro;
    public List<IntroductionDTO> getListIntro() {
        return listIntro;
    }
    
    public void getAllIntro() throws NamingException, SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select top 3 id, title, intro, img from Introduction order by id desc";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String intro = rs.getString("intro");
                    String img = rs.getString("img");
                    
                    IntroductionDTO dto = new IntroductionDTO(id, title, intro, img);
                    if (this.listIntro == null) {
                        this.listIntro = new ArrayList<>();
                    }
                    this.listIntro.add(dto);
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
    
    public List<ImageDTO> getImage() throws NamingException, SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        
        List<ImageDTO> list = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, img from Image";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String img = rs.getString("img");
                    
                    ImageDTO dto = new ImageDTO(id, img);
                    list.add(dto);
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
        return list;
    }
}
