package br.com.onsave.casamento.pessoa;

import br.com.onsave.casamento.arquitetura.Modelable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Contato implements Serializable, Modelable {

    public Contato(String contato, TipoContatoEnum tipoContato, Pessoa pessoa) {
        this.contato = contato;
        this.tipoContato = tipoContato;
        this.pessoa = pessoa;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String contato;
    
    @Enumerated(EnumType.STRING)
    private TipoContatoEnum tipoContato;
    
    @ManyToOne
    private Pessoa pessoa;
}