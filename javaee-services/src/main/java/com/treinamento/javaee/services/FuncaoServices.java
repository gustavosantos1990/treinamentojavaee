/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treinamento.javaee.services;

import com.treinamento.javaee.lib.Funcao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gustavo Santos
 */
@Stateless
public class FuncaoServices {
    
    @Inject
    FuncaoDAO funcaoDAO;
    
    public void save(Funcao funcao){
        funcaoDAO.save(funcao);
    }
    
    public void update(Funcao funcao){
        funcaoDAO.update(funcao);
    }
    
    public void delete(Long id){
        funcaoDAO.delete(id);
    }
    
    public Funcao find(Long id){
        return funcaoDAO.find(id);
    }
    
    public List<Funcao> loadAll(){
        return funcaoDAO.loadAll();
    }
}
