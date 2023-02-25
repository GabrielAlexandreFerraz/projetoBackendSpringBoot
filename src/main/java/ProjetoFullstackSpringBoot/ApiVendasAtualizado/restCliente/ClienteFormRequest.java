package ProjetoFullstackSpringBoot.ApiVendasAtualizado.restCliente;


import ProjetoFullstackSpringBoot.ApiVendasAtualizado.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ClienteFormRequest {

    private Long id;

    private String nome;
    private String cpf;

    private LocalDate nascimento;

    private String endereco;

    private String email;

    private String telefone;

    private LocalDate cadastro;

    public ClienteFormRequest() {
        super();
    }

    public ClienteFormRequest(Long id, String nome, String cpf, LocalDate nascimento, String endereco, String email, String telefone, LocalDate cadastro) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cadastro = cadastro;
    }

    public Cliente toModel(){
        return new Cliente(id, nascimento, cpf, nome, endereco, telefone, email, cadastro );
    }
    public  static ClienteFormRequest fromModel(Cliente cliente){
        return new ClienteFormRequest(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getNascimento(), cliente.getEndereco(), cliente.getEmail(), cliente.getTelefone(),cliente.getDataCadastro());
    }

//    id bigserial not null primary key,
//    nascimento date not null,
//    nome varchar(100) not null,
//    endereco varchar (255) not null,
//    cpf varchar (14) not null,
//    telefone varchar(14),
//    email varchar(100),
//    data_cadastro date

}
