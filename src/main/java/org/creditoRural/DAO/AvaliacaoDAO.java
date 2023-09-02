package org.creditoRural.DAO;

import org.creditoRural.domain.Agente;
import org.creditoRural.domain.Avaliacao;
import org.creditoRural.domain.AvaliacaoId;
import org.creditoRural.domain.DTO.AvaliacaoDTO;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.Projeto;

public class AvaliacaoDAO extends DAO<Avaliacao> {

    private AgenteDAO agenteDAO;
    private ProjetoDAO projetoDAO;

    public AvaliacaoDAO(){
        super(Avaliacao.class);
    }


    @Override
    protected Avaliacao map(Avaliacao entityToMap, DTO entityDTO) {

        AvaliacaoDTO dto = (AvaliacaoDTO) entityDTO;

        AvaliacaoId novoId = entityToMap.getId();

        Long agenteId = dto.getAgenteId();
        Long projetoId = dto.getProjetoId();

        if(agenteId != null){

            agenteDAO = new AgenteDAO();
            Agente theAgente = agenteDAO.findById(agenteId);

            entityToMap.setAgente(theAgente);
            novoId.setAgenteId(agenteId);

        }

        if(projetoId != null){

            projetoDAO = new ProjetoDAO();
            Projeto theProjeto = projetoDAO.findById(projetoId);

            entityToMap.setProjeto(theProjeto);
            novoId.setProjetoId(projetoId);
            theProjeto.setAvaliacao(entityToMap);
        }

        novoId.setProjetoId(dto.getProjetoId());


        return entityToMap;
    }

    public Avaliacao findById(AvaliacaoId id){
        return entityManager.find(Avaliacao.class, id);
    }

    /**
     * Serão feitos 2 testes:
     *
     * 1° Mudar apenas a chave primária. - testando - erro => duplicate key value
     * 2 ° Mudar chave primaria Embedded tbm, e os objetos agente e projeto - pass
     *
     *  @param avaliacaoId
     * @param avaliacaoIdDTO
     * @return
     */
    public DAO<Avaliacao> updateById(AvaliacaoId avaliacaoId, AvaliacaoDTO avaliacaoIdDTO) {

        Avaliacao av = findById(avaliacaoId);
        System.out.println(av);
//        Avaliacao novoId = map(av, avaliacaoIdDTO);
            this.map(av, avaliacaoIdDTO);
        System.out.println(av);
        super.update(av);

        return this;

    }


}
