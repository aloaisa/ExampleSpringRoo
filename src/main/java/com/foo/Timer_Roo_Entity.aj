// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.foo;

import com.foo.Timer;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Timer_Roo_Entity {
    
    declare @type: Timer: @Entity;
    
    @PersistenceContext
    transient EntityManager Timer.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Timer.id;
    
    @Version
    @Column(name = "version")
    private Integer Timer.version;
    
    public Long Timer.getId() {
        return this.id;
    }
    
    public void Timer.setId(Long id) {
        this.id = id;
    }
    
    public Integer Timer.getVersion() {
        return this.version;
    }
    
    public void Timer.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Timer.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Timer.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Timer attached = Timer.findTimer(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Timer.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Timer.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Timer Timer.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Timer merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Timer.entityManager() {
        EntityManager em = new Timer().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Timer.countTimers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Timer o", Long.class).getSingleResult();
    }
    
    public static List<Timer> Timer.findAllTimers() {
        return entityManager().createQuery("SELECT o FROM Timer o", Timer.class).getResultList();
    }
    
    public static Timer Timer.findTimer(Long id) {
        if (id == null) return null;
        return entityManager().find(Timer.class, id);
    }
    
    public static List<Timer> Timer.findTimerEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Timer o", Timer.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
