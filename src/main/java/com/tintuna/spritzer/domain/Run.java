/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bsmith
 */
@Entity
@Table(name = "run")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Run.findAll", query = "SELECT r FROM Run r"),
    @NamedQuery(name = "Run.findById", query = "SELECT r FROM Run r WHERE r.id = :id"),
    @NamedQuery(name = "Run.findByDateOn", query = "SELECT r FROM Run r WHERE r.dateOn = :dateOn"),
    @NamedQuery(name = "Run.findByDateOff", query = "SELECT r FROM Run r WHERE r.dateOff = :dateOff")})
public class Run extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOn", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOn;
    @Column(name = "dateOff")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOff;
    @JoinColumn(name = "sprinklers_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sprinkler sprinklersID;

    public Run() {
    }

    public Run(Integer id) {
        this.id = id;
    }

    public Run(Integer id, Date dateOn) {
        this.id = id;
        this.dateOn = dateOn;
    }

    public Date getDateOn() {
        return dateOn;
    }

    public void setDateOn(Date dateOn) {
        this.dateOn = dateOn;
    }

    public Date getDateOff() {
        return dateOff;
    }

    public void setDateOff(Date dateOff) {
        this.dateOff = dateOff;
    }

    public Sprinkler getSprinklersID() {
        return sprinklersID;
    }

    public void setSprinklersID(Sprinkler sprinklersID) {
        this.sprinklersID = sprinklersID;
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
        if (!(object instanceof Run)) {
            return false;
        }
        Run other = (Run) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Run[ id=" + id + " ]";
    }
    
}
