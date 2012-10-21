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
@Table(name = "garden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garden.findAll", query = "SELECT g FROM Garden g"),
    @NamedQuery(name = "Garden.findById", query = "SELECT g FROM Garden g WHERE g.id = :id"),
    @NamedQuery(name = "Garden.findByName", query = "SELECT g FROM Garden g WHERE g.name = :name")})
public class Garden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gardenID")
    private Collection<Sprinklerset> sprinklersetsCollection;

    public Garden() {
    }

    public Garden(Integer id) {
        this.id = id;
    }

    public Garden(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Sprinklerset> getSprinklersetsCollection() {
        return sprinklersetsCollection;
    }

    public void setSprinklersetsCollection(Collection<Sprinklerset> sprinklersetsCollection) {
        this.sprinklersetsCollection = sprinklersetsCollection;
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
        if (!(object instanceof Garden)) {
            return false;
        }
        Garden other = (Garden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.tintuna.domain.Garden[ id=" + id + " ]";
        return getName();
    }
    
}
