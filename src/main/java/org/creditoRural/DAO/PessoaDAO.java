package org.creditoRural.DAO;

import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.DTO.PessoaDTO;
import org.creditoRural.domain.Pessoa;
import org.creditoRural.domain.Propriedade;

public class PessoaDAO extends DAO<Pessoa>{

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public DAO<Pessoa> updateById(Long id, DTO<Pessoa> anotherEntity) {

        Pessoa pessoa = super.findById(id);
        detach(pessoa);
        Pessoa pessoaUpdated = this.map(pessoa, anotherEntity);
        update(pessoaUpdated);

        return this;

    }

    @Override
    protected Pessoa map(Pessoa entityToMap, DTO entityDTO) {

        PessoaDTO dto = (PessoaDTO) entityDTO;

        entityToMap.setNome(dto.getNome());
        entityToMap.setCpf(dto.getCpf());
        entityToMap.setNomeConjugue(dto.getNomeConjugue());
        entityToMap.setDataNascimento(dto.getDataNascimento());
        entityToMap.setProfissao(dto.getProfissao());
        entityToMap.setCelular(dto.getCelular());

        System.out.println("MAPEANDO");
        return entityToMap;

    }


}
