package ProjetoFullstackSpringBoot.ApiVendasAtualizado.restProdutos;


import ProjetoFullstackSpringBoot.ApiVendasAtualizado.model.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProdutoFormRequest {

    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;


    public ProdutoFormRequest(){
        super();
    }

    public ProdutoFormRequest(Long id, String descricao, String nome,
                              BigDecimal preco, String sku, LocalDate cadastro) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
        this.cadastro = cadastro;
    }
    public Produto toModel(){
        return new Produto(id, nome, descricao, preco, sku);
    }
    public static ProdutoFormRequest fromModel(Produto produto){
        return new ProdutoFormRequest(
                produto.getId(),
                produto.getDescricao(),
                produto.getNome(),
                produto.getPreco(),
                produto.getSku(),
                produto.getDataCadastro());
    }

    @Override
    public String toString() {
        return "ProdutoFormRequest{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", sku='" + sku + '\'' +
                '}';
    }
}