package br.com.onsave.casamento.pessoa;

import br.com.onsave.casamento.arquitetura.Modelable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
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
@EqualsAndHashCode(of = {"id"})
public class Pessoa implements Serializable, Modelable {

    public Pessoa(String nome, String login, String senha, Date ultimoAcesso, Boolean hospede) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ultimoAcesso = ultimoAcesso;
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
    
    @Enumerated(EnumType.STRING)
    private TipoPessoaEnum tipoPessoa;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultimoAcesso;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Contato> contatos;
    
}