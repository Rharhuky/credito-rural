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

    /**
     * Meio diferenciado
     * @param agenteId projetoId
     * @return DAO
     */
    public DAO<Avaliacao> persist(Long agenteId, Long projetoId) {

        this.agenteDAO = new AgenteDAO();
        this.projetoDAO = new ProjetoDAO();

        Agente agente = agenteDAO.findById(agenteId);
        Projeto projeto = projetoDAO.findById(projetoId);

        AvaliacaoId id = new AvaliacaoId();
        id.setProjetoId(projetoId);
        id.setProjetoId(agenteId);

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setProjeto(projeto);
        avaliacao.setAgente(agente);
        avaliacao.setId(id);

        super.persist(avaliacao);

        return this;

    }

    //    @Override
//    protected Avaliacao map(Avaliacao entityToMap, DTO entityDTO) {
//
//        AvaliacaoDTO dto = (AvaliacaoDTO) entityDTO;
//
//        AvaliacaoId novoId = entityToMap.getId();
//
//        Long agenteId = dto.getAgenteId();
//        Long projetoId = dto.getProjetoId();
//
//        if(agenteId != null){
//
//            agenteDAO = new AgenteDAO();
//            Agente theAgente = agenteDAO.findById(agenteId);
//
//            entityToMap.setAgente(theAgente);
//            novoId.setAgenteId(agenteId);
//
//        }
//
//        if(projetoId != null){
//
//            projetoDAO = new ProjetoDAO();
//            Projeto theProjeto = projetoDAO.findById(projetoId);
//
//            entityToMap.setProjeto(theProjeto);
//            novoId.setProjetoId(projetoId);
//            theProjeto.setAvaliacao(entityToMap);
//        }
//
//        novoId.setProjetoId(dto.getProjetoId());
//
//
//        return entityToMap;
//    }

    public Avaliacao findById(AvaliacaoId id){
        return entityManager.find(Avaliacao.class, id);
    }

    /**
     * testes:
     *
     * 1 ° change pk. - failed erro => duplicate key value
     * 2 ° change pk Embedded as well agente object and others...- pass - not modifict cause JPA
     *
     *  @param //avaliacaoId
     * @param //avaliacaoIdDTO
     * @return
     */
//    public DAO<Avaliacao> updateById(AvaliacaoId avaliacaoId, AvaliacaoDTO avaliacaoIdDTO) {
//
//        Avaliacao av = findById(avaliacaoId);
//        System.out.println(av);
////        Avaliacao novoId = map(av, avaliacaoIdDTO);
//            this.map(av, avaliacaoIdDTO);
//        System.out.println(av);
//        super.update(av);
//
//        return this;
//
//    }

    public DAO<Avaliacao> updateById(Long agenteId, Long projetoId, DTO<Avaliacao> avaliacaoDTO){

        AvaliacaoId id = new AvaliacaoId();
        id.setProjetoId(projetoId);
        id.setAgenteId(agenteId);

        Avaliacao avaliacao = findById(id);
        Avaliacao updatedAvaliacao = this.map(avaliacao, avaliacaoDTO);

        openTransaction();
        super.update(updatedAvaliacao);

        return this;

    }

    @Override
    protected Avaliacao map(Avaliacao entityToMap, DTO entityDTO) {

        AvaliacaoDTO dto = (AvaliacaoDTO) entityDTO;
        entityToMap.setDeferido(dto.getDeferido());
        entityToMap.setValor(dto.getValor());

        return entityToMap;

    }
}
