package org.creditoRural.DAO;

import org.creditoRural.domain.*;
import org.creditoRural.domain.DTO.*;
import org.creditoRural.domain.enums.TipoAtividade;
import org.creditoRural.domain.enums.TipoBem;

import java.time.LocalDate;
import java.util.List;

public class TestesEntidadesDAO {

    public static void main(String[] args) {

//        criarPessoas();
//        criarPropriedades();
//        criarProjetos();
//        criarAtividades();
//        criarAgentes();
//        criarAvaliacoes();

//
//        lerPessoas();
//        lerPessoaPeloCpf(); // FIXME using JPQL
//        lerPropriedades();
//        lerPropriedadesPeloCPF();
//        lerPropriedadeComProjetosPeloTipoAtividade();
//        lerProjetos();
//        lerAtividades();
//        lerAgentes();
//        lerAvaliacoes(); // FIXME using JPQL
//        lerBensDeUmaPropriedade(); // TODO - DONE
//
//
//        atualizarPessoa();
//        atualizarPropriedade();
//        atualizarProjetos();
//        atualizarBem();
//        atualizarAvaliacao();
//
//        deletarBens();    //TODO - DONE
//        deletarAgentes(); TODO - DONE
//        deletarProjeto(); TODO - DONE
//        deletarPessoa();  // TODO - DONE
//        deletarPropriedade();

    }

    private static void deletarPropriedade() {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();

        propriedadeDAO.deleteById(3L).closeConnexion();


    }

    private static void atualizarAvaliacao() {

        AvaliacaoDAO avDAO = new AvaliacaoDAO();
        avDAO.openConnexion();

        AvaliacaoDTO dto = new AvaliacaoDTO.Builder()
                .setDeferido(true)
                .setValor(50000.0)
                .build();

        avDAO.updateById(1L, 2L, dto);

        avDAO.closeConnexion();


    }

    private static void lerProjetos() {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO.openConnexion();

        List<Projeto> projetos = projetoDAO.findAll();
        projetos.forEach(System.out::println);

        projetoDAO.closeConnexion();


    }

    private static void lerPropriedadesPeloCPF() {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();

        List<Propriedade> p = propriedadeDAO.findPropriedadesByPessoaCPF("20301504");
        p.forEach(System.out::println);
        propriedadeDAO.closeConnexion();

    }

    /**
     * Legal seria ler bens de uma propriedade...
     */
    private static void lerBensDeUmaPropriedade() {

        BemDAO bemDAO = new BemDAO();
        bemDAO.openConnexion();

        List<Bem> bens = bemDAO.findByPropriedadeId(3L);
        bens.forEach(System.out::println);
        bemDAO.closeConnexion();

    }

    private static void lerAvaliacoes() {
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        avaliacaoDAO.openConnexion();

        List<Avaliacao> avs = avaliacaoDAO.findAll();
        avs.forEach(System.out::println);
        avaliacaoDAO.closeConnexion();




    }

    private static void lerAgentes() {

        AgenteDAO agenteDAO = new AgenteDAO();
        agenteDAO.openConnexion();
        List<Agente> agentes = agenteDAO.findAll();
        agenteDAO.closeConnexion();
    }

    private static void lerAtividades() {
        AtividadeDAO atvDAO = new AtividadeDAO();
        atvDAO.openConnexion();
        List<Atividade> atvs = atvDAO.findAll();
    }

    private static void deletarPessoa() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.openConnexion();
        pessoaDAO.deleteById(2L);
        pessoaDAO.closeConnexion();


    }

    private static void deletarProjeto() {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO
                .openConnexion()
                .deleteById(2L)
                .closeConnexion();

    }

    private static void deletarAgentes() {

        AgenteDAO agenteDAO = new AgenteDAO();
        agenteDAO.openConnexion();
        agenteDAO.deleteAll().closeConnexion();

    }

    private static void deletarBens() {

        BemDAO bemDAO = new BemDAO();
        bemDAO.openConnexion();
        bemDAO.deleteById(2L).closeConnexion();


    }

    private static void lerPessoas() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.openConnexion();

        List<Pessoa> pessoas = pessoaDAO.findAll();

    }
    private static void lerPessoaPeloCpf() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.openConnexion();

        Pessoa p = pessoaDAO.findPessoaByCPF("20301504");
        System.out.println(p);

        pessoaDAO.closeConnexion();

    }
    private static void lerPropriedades() {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();

        List<Propriedade> propriedades = propriedadeDAO.findAll();

        propriedadeDAO.closeConnexion();
    }

    private static void lerPropriedadeComProjetosPeloTipoAtividade() {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();

        List<Propriedade> propriedades = propriedadeDAO.findPropriedadesByAtividade(TipoAtividade.INVESTIMENTO);
        propriedades.forEach(System.out::println);
        propriedadeDAO.closeConnexion();
    }

    private static void atualizarBem() {

        BemDAO bemDAO = new BemDAO();
        bemDAO.openConnexion();
        BemDTO bemDTO = new BemDTO.Builder()
                .setPreco(15333d)
                .build();

        bemDAO.updateById(1L, bemDTO);
        bemDAO.closeConnexion();

    }

    private static void atualizarProjetos() {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO.openConnexion();

        ProjetoDTO dto = new ProjetoDTO.Builder()
                .setPropriedadeId(1L)
                .setAtividadeId(2L)
                .build();

        projetoDAO
                .updateById(2L, dto)
                .closeConnexion();

    }

    private static void atualizarPropriedade() {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();
        PropriedadeDTO dto = new PropriedadeDTO.Builder()
                .setPessoaId(2L)
                .setRegiao("Donatelo")
                .build();

        propriedadeDAO.updateById(3L, dto);

    }

    private static void atualizarPessoa() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        PessoaDTO dto = new PessoaDTO
                .Builder()
                .setNome("Jovem do anjiquinho")
                .build();

        pessoaDAO
                .openConnexion()
                .updateById(1L, dto)
                .closeConnexion();

    }

    private static void criarProjetos() {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO.openConnexion();

        Atividade atv = new Atividade();
        atv.setObjetivo("Manutencao de pasto");
        atv.setTipoAtividade(TipoAtividade.CUSTEIO);

        Projeto projetoA = new Projeto();
        projetoA.setAtividade(atv);

        Projeto projetoB = new Projeto();

        projetoDAO.persist(projetoA)
                .persist(projetoB);

        projetoDAO.closeConnexion();


    }


    /**
     * Criar bens e propriedades
     */
    private static void criarPropriedades() {


        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();
        Propriedade propriedadeA = new Propriedade();

        Bem bemA = new Bem();
        bemA.setPreco(300000.1);
        bemA.setTipo(TipoBem.CORPO_DAGUA);

        propriedadeA.setCep("58500000");
        propriedadeA.setRegiao("Serrote");
        propriedadeA.setNome("Santa Luzia");
        propriedadeA.adicionarBem(bemA);
        bemA.setPropriedade(propriedadeA);


        Propriedade propriedadeB = new Propriedade();
        propriedadeB.setNome("Maria das Dores");
        propriedadeB.setRegiao("Camcimba de Carambolas");
        propriedadeB.setCep("56800000");



        Bem bemB = new Bem();
        bemB.setTipo(TipoBem.MAQUINARIO);

        Propriedade propriedadeC = new Propriedade();
        propriedadeC.setRegiao("Monteiro");
        propriedadeC.setNome("Bom Jesus");
        propriedadeC.setCep("58500000");
        propriedadeC.adicionarBem(bemB);
        bemB.setPropriedade(propriedadeC);

        //erro
        Propriedade propriedadeD = new Propriedade();
        propriedadeD.setCep("10");
        propriedadeD.setNome("Lancer 2.0 Manual");
        propriedadeD.setRegiao("Serrote");
        //



        propriedadeDAO
                .persist(propriedadeA)
                .persist(propriedadeB)
                .persist(propriedadeC)
                .persist(propriedadeD);

        propriedadeDAO.closeConnexion();


    }

    private static void criarAtividades() {

        Atividade atv = new Atividade(TipoAtividade.INVESTIMENTO, "Abrir poço em área cristalina");

        AtividadeDAO atvDAO = new AtividadeDAO();
        atvDAO.openConnexion();

        atvDAO
                .persist(atv)
                .closeConnexion();

    }

    private static void criarAvaliacoes() {

        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        avaliacaoDAO.openConnexion();

        avaliacaoDAO.persist(1L, 2L);
        avaliacaoDAO.closeConnexion();

    }

    private static void criarAgentes() {

        AgenteDAO agenteDAO = new AgenteDAO();
        agenteDAO.openConnexion();

        Agente agenteA = new Agente("Colorado");
        Agente agenteB = new Agente("Silvio");

        agenteDAO.persist(agenteA)
                .persist(agenteB)
                .closeConnexion();

    }

    static void criarPessoas(){

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.openConnexion();

        Pessoa pessoaA = new Pessoa();
        pessoaA.setCpf("20301504");
        pessoaA.setProfissao("Agricultor");
        pessoaA.setDataNascimento(LocalDate.now());

        Pessoa pessoaB = new Pessoa();
        pessoaB.setCpf("107894");
        pessoaB.setProfissao("Jogadô");
        pessoaB.setNome("José Maria nóbrega");
        pessoaB.setDataNascimento(LocalDate.now());

        pessoaDAO
                .persist(pessoaA)
                .persist(pessoaB);

        pessoaDAO.closeConnexion();

    }

}
