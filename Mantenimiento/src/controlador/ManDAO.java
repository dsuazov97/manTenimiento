/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author ziNk
 */
public class ManDAO {
    
    public boolean ingresarCelular(Celular celu){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="insert into pdcelular (codigo,marca,modelo,cantDias,precioBase,cPantalla,cBateria,cPlaca,cCamara,cImei) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, celu.getCodigo());
            ps.setString(2, celu.getMarca());
            ps.setString(3, celu.getModelo());
            ps.setInt(4, celu.getCantDias());
            ps.setInt(5, celu.getPrecioBase());
            ps.setBoolean(6, celu.iscPantalla());
            ps.setBoolean(7, celu.iscBateria());
            ps.setBoolean(8, celu.iscPlaca());
            ps.setBoolean(9, celu.iscCamara());
            ps.setBoolean(10, celu.isDesbloqueoImei());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return resultado;
    }
    
    public boolean ingresarComputador(Computador compu){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="insert into pdcomputador (codigo,marca,modelo,cantDias,precioBase,"
                        + "limpieza,formateo) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, compu.getCodigo());
            ps.setString(2, compu.getMarca());
            ps.setString(3, compu.getModelo());
            ps.setInt(4, compu.getCantDias());
            ps.setInt(5, compu.getPrecioBase());
            ps.setBoolean(6, compu.isLimpieza());
            ps.setBoolean(7, compu.isFormateo());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return resultado;
    }
    
    public boolean modificarCelular(Celular celu){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="update pdcelular set marca=?,modelo=?,cantDias=?,"
                    + "precioBase=?,cPantalla=?,cBateria=?,cPlaca=?,cCamara=?,cImei=? where codigo=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, celu.getMarca());
            ps.setString(2, celu.getModelo());
            ps.setInt(3, celu.getCantDias());
            ps.setInt(4, celu.getPrecioBase());
            ps.setBoolean(5, celu.iscPantalla());
            ps.setBoolean(6, celu.iscBateria());
            ps.setBoolean(7, celu.iscPlaca());
            ps.setBoolean(8, celu.iscCamara());
            ps.setBoolean(9, celu.isDesbloqueoImei());
            ps.setString(10, celu.getCodigo());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return resultado;
    }
    
    public boolean modificarComputador(Computador compu){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="update pdcomputador set marca=?,modelo=?,cantDias=?,precioBase=?,"
                        + "limpieza=?,formateo=? where codigo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, compu.getMarca());
            ps.setString(2, compu.getModelo());
            ps.setInt(3, compu.getCantDias());
            ps.setInt(4, compu.getPrecioBase());
            ps.setBoolean(5, compu.isLimpieza());
            ps.setBoolean(6, compu.isFormateo());
            ps.setString(7, compu.getCodigo());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return resultado;
    }
    
    public boolean eliminarCelular(String codigo){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="delete from pdcelular where codigo='"+codigo+"'";
            PreparedStatement ps = con.prepareStatement(query);
            
            // ps.setString(1,rut);
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return resultado;
    }
    
    public boolean eliminarComputador(String codigo){
        boolean resultado=false;
        try{
            Connection con = Conexion.getConexion();
            String query="delete from pdcomputador where codigo='"+codigo+"'";
            PreparedStatement ps = con.prepareStatement(query);
            
            // ps.setString(1,rut);
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return resultado;
    }
    
    public ArrayList<Celular> obtenerCelulares(){
        
        ArrayList<Celular> celus= new ArrayList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="Select * from pdcelular";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Celular celu;
            while(rs.next()){
                celu= new Celular(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10));
                celus.add(celu);
            }
            ps.close();
            
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return celus;
    }
    
    public ArrayList<Computador> obtenerComputadores(){
        
        ArrayList<Computador> compus= new ArrayList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="Select * from pdcomputador";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Computador compu;
            while(rs.next()){
                compu = new Computador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getBoolean(6), rs.getBoolean(7));
                compus.add(compu);
            }
            ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return compus;
    }
    
    public Celular buscarCelu(String codigo){
        
        Celular celu=null;
        try{
            Connection con = Conexion.getConexion();
            String query="select * from pdcelular where codigo='"+codigo+"'";
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setString(1,rut);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                celu = new Celular(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9),
                        rs.getBoolean(10));
            }
            ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return celu;
    }
    
    public Computador buscarCompu(String codigo){
        
        Computador compu=null;
        try{
            Connection con = Conexion.getConexion();
            String query="select * from pdcomputador where codigo='"+codigo+"'";
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setString(1,rut);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                compu = new Computador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getBoolean(6), rs.getBoolean(7));
            }
            ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return compu;
    }
    
    public int contarCompus(){
        int cant=0;
        try{
        Connection con = Conexion.getConexion();
        String query="Select count(codigo) from pdcomputador";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cant= rs.getInt(1);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return cant;
    }
    
    public int contarCelus(){
        int cant=0;
        try{
        Connection con = Conexion.getConexion();
        String query="Select count(codigo) from pdcelular";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cant= rs.getInt(1);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return cant;
    }
    
    public ArrayList<Producto> todito(){
        ArrayList<Producto> prod = new ArrayList<>();
        try{
        Connection con = Conexion.getConexion();
        String query=   "select codigo,marca,modelo,cantDias,precioBase from pdcomputador\n" +
                        "UNION\n" +
                        "select codigo,marca,modelo,cantDias,precioBase from pdcelular";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Producto pro;
        while(rs.next()){
            pro= new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)) {
                @Override
                public int costoServicios() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public int valorFinal() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            prod.add(pro);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return prod;
    
    }
    
    public int contarProd(){
        int cant=0;
        try{
        Connection con = Conexion.getConexion();
        String query="select (select count(codigo) from pdcomputador)+(select count(codigo) from pdcelular)";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cant= rs.getInt(1);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return cant;
    }
    
    public ArrayList<Producto> mostMarcas(String marca){
        ArrayList<Producto> prod = new ArrayList<>();
        try{
        Connection con = Conexion.getConexion();
        String query=   "select codigo,marca,modelo,cantdias,precioBase from pdcomputador where lower(marca)='"+marca+"'\n"
                        +"UNION\n"+
                        "select codigo,marca,modelo,cantdias,precioBase from pdcelular where lower(marca)='"+marca+"'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Producto pro;
        while(rs.next()){
            pro = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)) {
                @Override
                public int costoServicios() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public int valorFinal() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            prod.add(pro);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return prod;
    }
    public int promDias(){
        int cant=0;
        try{
        Connection con = Conexion.getConexion();
        String query="SELECT(select round(avg(cantdias)) from pdcomputador)+(select round(avg(cantdias)) from pdcelular)";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cant= rs.getInt(1);
        }
        ps.close();
        }catch (SQLException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ManDAO.class.getName()).log(Level.SEVERE,null,ex);
        }return cant;
    }
    
}        


    
    

