package ProjetoFullstackSpringBoot.ApiVendasAtualizado.repository;

import ProjetoFullstackSpringBoot.ApiVendasAtualizado.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
