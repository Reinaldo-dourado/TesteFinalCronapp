
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
* Classe que representa a tabela PRODUTO
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"PRODUTO\"")
@XmlRootElement
@CronappSecurity(post = "Administrators")
@JsonFilter("app.entity.Produto")
@CronappTable(role=CronappTableRole.CLASS)
public class Produto implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="{{'NomeProduto' | translate}}")
    @Column(name = "nomeProduto", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nomeProduto;


    /**
    * @generated
    */
    @CronappColumn(attributeType="INTEGER", label="{{'Estoque' | translate}}")
    @Column(name = "estoque", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer estoque;


    /**
    * Construtor
    * @generated
    */
    public Produto(){
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
    public Produto setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nomeProduto
    * return nomeProduto
    * @generated
    */
    public java.lang.String getNomeProduto() {
        return this.nomeProduto;
    }

    /**
    * Define nomeProduto
    * @param nomeProduto nomeProduto
    * @generated
    */
    public Produto setNomeProduto(java.lang.String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }
    /**
    * Obtém estoque
    * return estoque
    * @generated
    */
    public java.lang.Integer getEstoque() {
        return this.estoque;
    }

    /**
    * Define estoque
    * @param estoque estoque
    * @generated
    */
    public Produto setEstoque(java.lang.Integer estoque) {
        this.estoque = estoque;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Produto object = (Produto)obj;
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
