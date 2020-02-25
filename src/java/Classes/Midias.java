/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class Midias extends ConexaoMySQL {

    private Integer Id;
    private String Nome;
    private String URL;
    private Integer Duracao;

    public Midias(Integer Id, String Nome, String URL, Integer Duracao) {
        this.Id = Id;
        this.Nome = Nome;
        this.URL = URL;
        this.Duracao = Duracao;
    }
    
    
    public Midias(String Nome, String URL, Integer Duracao) {
        this.Nome = Nome;
        this.URL = URL;
        this.Duracao = Duracao;
    }

    public Midias() {
    }

    public Midias(Integer Id) {
        this.Id = Id;
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getDuracao() {
        return Duracao;
    }

    public void setDuracao(Integer Duracao) {
        this.Duracao = Duracao;
    }

    public String insert() {
        String sql = "insert into midias(Nome,URL,Duracao) values (?,?,?)";

        try {
            Connection con = new ConexaoMySQL().getConexaoMySQL();

            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, this.Nome);
            stmt.setString(2, this.URL);
            stmt.setInt(3, this.Duracao);

            // executa
            stmt.execute();
            stmt.close();

            return "Midia cadastrada com suscesso!";
        } catch (SQLException e) {
            return e.toString();
        }
    }

    public ArrayList<Midias> findAll() {
        try {
            Connection con = new ConexaoMySQL().getConexaoMySQL();

            String sql = "SELECT * FROM Midias";
            PreparedStatement stmt = con.prepareStatement(sql);

            //Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
            //Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while 
            ResultSet rs = stmt.executeQuery();
            //Faz a verificação de enquanto conter registros, percorre e resgata os valores
            ArrayList<Midias> lista=new ArrayList();
            Midias media;
            while (rs.next()) {
                media=new Midias(rs.getInt("Id"),rs.getString("Nome"),rs.getString("URL"),rs.getInt("Duracao"));
                lista.add(media);
            }
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Midias find() {
         try {
            Connection con = new ConexaoMySQL().getConexaoMySQL();

            String sql = "SELECT * FROM Midias WHERE Id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, this.Id);
            
            ResultSet rs = stmt.executeQuery();
            
            Midias midia = null;
            while (rs.next()) {
                midia=new Midias(rs.getInt("Id"),rs.getString("Nome"),rs.getString("URL"),rs.getInt("Duracao"));
            }
             System.err.println("Procurou");
            stmt.close();
            return midia;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
