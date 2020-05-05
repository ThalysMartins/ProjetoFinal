package thalysmartins.filmesbancoh2.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


/**
 * @Author Thalys Figueira Martins
 * @Since 24/04/2020
 * @version 1.0
 */

@Component
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "filmes")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filme")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "duração")
    private String duracao;

    @Column(name = "nota")
    private float nota;

    @Column(name = "genero")
    private String genero;

    @Column(name = "diretor")
    private String diretor;
}
