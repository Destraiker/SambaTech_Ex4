/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Midias;
import java.util.ArrayList;
import javafx.scene.media.Media;



/**
 *
 * @author Home
 */
public class MidiasControl extends Midias{
    
    public String NovaMidia(String Nome,String URL,String Duracao){
        Integer Duracao_int=Integer.parseInt(Duracao);
        Midias midia=new Midias(Nome,URL,Duracao_int);
        
        String retorno=midia.insert();
        return retorno;
    }
    public ArrayList<Midias> ListarMidias(){
        Midias midia=new Midias();
        return midia.findAll();
    }
    public Midias ListarMidia(Integer id){
        Midias midia=new Midias(id);
        
        return midia.find();
    }
}
