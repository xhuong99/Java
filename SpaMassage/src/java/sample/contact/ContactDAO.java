/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.contact;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import sample.util.DBUtil;

/**
 *
 * @author leehe
 */
public class ContactDAO implements Serializable{
    public ContactDTO getContact() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select shop, address, city, country, phone, email from Contact";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    String shop = rs.getString("shop");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    String country = rs.getString("country");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    
                    ContactDTO dto = new ContactDTO(shop, address, city, country, phone, email);
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
