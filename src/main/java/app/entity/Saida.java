
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela SAIDA
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"SAIDA\"")
@XmlRootElement
@CronappSecurity(post = "Funcionario", delete = "Administrators;Funcionario", put = "Funcionario")
@JsonFilter("app.entity.Saida")
@CronappTable(role=CronappTableRole.ASSOCIATION_CLASS)
public class Saida implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User fk_user;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_produto", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Produto fk_produto;


    /**
    * @generated
    */
    @CronappColumn(attributeType="INTEGER", label="Qtd Saida")
    @Column(name = "qtdSaida", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer qtdSaida;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @CronappColumn(attributeType="DATE", label="Data")
    @Column(name = "data", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data;


    /**
    * Construtor
    * @generated
    */
    public Saida(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Saida setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém fk_user
    * return fk_user
    * @generated
    */
    public User getFk_user() {
        return this.fk_user;
    }

    /**
    * Define fk_user
    * @param fk_user fk_user
    * @generated
    */
    public Saida setFk_user(User fk_user) {
        this.fk_user = fk_user;
        return this;
    }
    /**
    * Obtém fk_produto
    * return fk_produto
    * @generated
    */
    public Produto getFk_produto() {
        return this.fk_produto;
    }

    /**
    * Define fk_produto
    * @param fk_produto fk_produto
    * @generated
    */
    public Saida setFk_produto(Produto fk_produto) {
        this.fk_produto = fk_produto;
        return this;
    }
    /**
    * Obtém qtdSaida
    * return qtdSaida
    * @generated
    */
    public java.lang.Integer getQtdSaida() {
        return this.qtdSaida;
    }

    /**
    * Define qtdSaida
    * @param qtdSaida qtdSaida
    * @generated
    */
    public Saida setQtdSaida(java.lang.Integer qtdSaida) {
        this.qtdSaida = qtdSaida;
        return this;
    }
    /**
    * Obtém data
    * return data
    * @generated
    */
    public java.util.Date getData() {
        return this.data;
    }

    /**
    * Define data
    * @param data data
    * @generated
    */
    public Saida setData(java.util.Date data) {
        this.data = data;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Saida object = (Saida)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
