/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treinamento.javaee.services;

import com.treinamento.javaee.lib.Funcao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gustavo Santos
 */
@Stateless
public class FuncaoDAO {

    @PersistenceContext(name = "javaeePU")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Funcao funcao) {
        getEntityManager().persist(getEntityManager().merge(funcao));
    }

    public void update(Funcao funcao) {
        getEntityManager().merge(funcao);
    }

    public void delete(Long id) {
        Funcao funcao = find(id);
        getEntityManager().remove(funcao);
    }

    public Funcao find(Long id) {
        return getEntityManager().find(Funcao.class, id);
    }

    public List<Funcao> loadAll() {
        return getEntityManager()
                .createQuery("SELECT f FROM Funcao f", Funcao.class)
                .getResultList();
    }

}
