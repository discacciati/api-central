package cadastro;

import lombok.RequiredArgsConstructor;
import neves.cristiano.comum.exceptions.EntidadeDuplicadaException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastroService {
    private final CrudRepository<Cadastro, String> repository;

    public Optional<Cadastro> getById(String id) {
        return repository.findById(id);
    }

    public void adicionar(Cadastro entity) throws EntidadeDuplicadaException {
        if (repository.existsById(entity.getCpf())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}
