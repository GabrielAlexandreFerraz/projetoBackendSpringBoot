package ProjetoFullstackSpringBoot.ApiVendasAtualizado.restProdutos;

import ProjetoFullstackSpringBoot.ApiVendasAtualizado.model.Produto;
import ProjetoFullstackSpringBoot.ApiVendasAtualizado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<ProdutoFormRequest> getLista(){
        return repository.findAll().stream()
                .map(produt -> ProdutoFormRequest.fromModel(produt) ).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public  ResponseEntity<ProdutoFormRequest> getById(@PathVariable Long id){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        ProdutoFormRequest produto = produtoExistente.map(ProdutoFormRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto){
        Produto entidadeProduto = produto.toModel();
        repository.save(entidadeProduto);
        return ProdutoFormRequest.fromModel(entidadeProduto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Produto entidade = produto.toModel();
        entidade.setId(id);
        repository.save(entidade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(produtoExistente.get());
        return ResponseEntity.noContent().build();
    }

}
