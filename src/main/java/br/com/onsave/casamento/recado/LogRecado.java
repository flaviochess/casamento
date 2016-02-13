package br.com.onsave.casamento.recado;

import br.com.onsave.casamento.arquitetura.Modelable;
import br.com.onsave.casamento.pessoa.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
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
public class LogRecado implements Serializable, Modelable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataVisualizacao;
    
    @ManyToOne
    private Pessoa pessoa;
    
    @ManyToOne
    private Recado recado;
}
