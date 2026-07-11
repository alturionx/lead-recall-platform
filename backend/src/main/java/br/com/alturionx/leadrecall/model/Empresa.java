package br.com.alturionx.leadrecall.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Define que  classe empresa será uma tabela no banco de dados
@Table(name = "tb_empresas") //Define um nome pra tabela
@Data //Gera os métodos getters e setters automaticamente
@NoArgsConstructor //Gera um construtor sem argumentos
public class Empresa {

    @Id //Ele define o atributo como chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define o método de geração de chave primária
    private Long id;

    @Column(nullable = false, unique = true) //Define regra para a coluna do banco de dados
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;

}
