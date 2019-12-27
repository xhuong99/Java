/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.treatment;

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
public class TreatmentDAO implements Serializable{
    private List<TreatmentDTO> listTreatment;

    public List<TreatmentDTO> getListTreatment() {
        return listTreatment;
    }
    
    public void getAllTreatment() throws SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Select id, treatment, info, price, service from Treatment";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String treatment = rs.getString("treatment");
                    String info = rs.getString("info");
                    float price = rs.getFloat("price");
                    int service = rs.getInt("service");
                    
                    TreatmentDTO dto = new TreatmentDTO(id, treatment, info, price, service);
                    if (this.listTreatment == null) {
                        this.listTreatment = new ArrayList<>();
                    }
                    this.listTreatment.add(dto);
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
