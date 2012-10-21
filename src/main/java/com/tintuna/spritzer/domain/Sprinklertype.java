/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsmith
 */
@Entity
@Table(name = "sprinklertype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprinklertype.findAll", query = "SELECT s FROM Sprinklertype s"),
    @NamedQuery(name = "Sprinklertype.findById", query = "SELECT s FROM Sprinklertype s WHERE s.id = :id"),
    @NamedQuery(name = "Sprinklertype.findByType", query = "SELECT s FROM Sprinklertype s WHERE s.type = :type")})
public class Sprinklertype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 122)
    @Column(name = "type", nullable = false, length = 122)
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprinklerTypeID")
    private Collection<Sprinklerdevice> sprinklerdeviceCollection;

    public Sprinklertype() {
    }

    public Sprinklertype(Integer id) {
        this.id = id;
    }

    public Sprinklertype(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Sprinklerdevice> getSprinklerdeviceCollection() {
        return sprinklerdeviceCollection;
    }

    public void setSprinklerdeviceCollection(Collection<Sprinklerdevice> sprinklerdeviceCollection) {
        this.sprinklerdeviceCollection = sprinklerdeviceCollection;
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
        if (!(object instanceof Sprinklertype)) {
            return false;
        }
        Sprinklertype other = (Sprinklertype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Sprinklertype[ id=" + id + " ]";
    }
    
}
