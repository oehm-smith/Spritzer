/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsmith
 */
@Entity
@Table(name = "programmes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p"),
    @NamedQuery(name = "Programme.findById", query = "SELECT p FROM Programme p WHERE p.id = :id"),
    @NamedQuery(name = "Programme.findByOnTime", query = "SELECT p FROM Programme p WHERE p.onTime = :onTime"),
    @NamedQuery(name = "Programme.findByDuration", query = "SELECT p FROM Programme p WHERE p.duration = :duration")})
public class Programme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "on_Time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date onTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration", nullable = false)
    private double duration;
    @JoinTable(name = "programmes_to_sprinklers", joinColumns = {
        @JoinColumn(name = "programme_ID", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "sprinkler_ID", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Sprinkler> sprinklersCollection;
    @JoinTable(name = "schedule_to_programmes", joinColumns = {
        @JoinColumn(name = "programme_ID", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "schedule_ID", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "dayOfWeek_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Weekday dayOfWeekID;

    public Programme() {
    }

    public Programme(Integer id) {
        this.id = id;
    }

    public Programme(Integer id, Date onTime, double duration) {
        this.id = id;
        this.onTime = onTime;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @XmlTransient
    public Collection<Sprinkler> getSprinklersCollection() {
        return sprinklersCollection;
    }

    public void setSprinklersCollection(Collection<Sprinkler> sprinklersCollection) {
        this.sprinklersCollection = sprinklersCollection;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    public Weekday getDayOfWeekID() {
        return dayOfWeekID;
    }

    public void setDayOfWeekID(Weekday dayOfWeekID) {
        this.dayOfWeekID = dayOfWeekID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Programmes[ id=" + id + " ]";
    }
    
}
