
package com.mycompany.sistemaloginjsf;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", nullable=false, unique=true)
      private int id;
       
      @Column(name="userName", nullable=false, unique=true)
      private String nomeUsuario;
       
      @Column(name="senha", nullable=false, unique=false)
      private String senha;
      
      @Column(name="email", nullable=false, unique=false)
      private String email;
      
      @Column(name="cidade", nullable=false, unique=false)
      private String cidade;
      
      @Column(name="telefone", nullable=false, unique=false)
      private String telefone;
      
      @Column(name="cpf", nullable=false, unique=false)
      private String cpf;
       
      public String getNomeUsuario() {
            return nomeUsuario;
      }
       
      public void setNomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
      }
       
      public String getSenha() {
            return senha;
      }
       
      public void setSenha(String senha) {
            this.senha = senha;
      }

 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
       
   
       
  
    
}
