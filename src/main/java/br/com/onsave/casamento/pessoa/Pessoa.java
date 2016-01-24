package br.com.onsave.casamento.pessoa;

import br.com.onsave.casamento.arquitetura.Modelable;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa implements Serializable, Modelable {

    public Pessoa(String nome, String login, String senha, Boolean hospede) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.hospede = hospede;
    }
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    
    private String nome;

    @Column(unique = true)
    private String login;
    
    private String senha;
    
    private Boolean hospede;
    
}