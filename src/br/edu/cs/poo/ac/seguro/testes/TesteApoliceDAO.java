package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;
import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();

    @Override
    protected Class getClasse() {
        return Apolice.class;
    }

    @Test
    public void teste01() {
        String numero = "AP01";
        Veiculo v = new Veiculo("PL01", 2020, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("100.00"));
        ap.setValorPremio(new BigDecimal("200.00"));
        ap.setValorMaximoSegurado(new BigDecimal("1000.00"));

        cadastro.incluir(ap, numero);

        Apolice buscada = dao.buscar(numero);
        Assertions.assertNotNull(buscada);
    }

    @Test
    public void teste02() {
        String numero = "AP02";
        Veiculo v = new Veiculo("PL02", 2021, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("150.00"));
        ap.setValorPremio(new BigDecimal("250.00"));
        ap.setValorMaximoSegurado(new BigDecimal("1250.00"));

        cadastro.incluir(ap, numero);

        Apolice naoExiste = dao.buscar("AP99");
        Assertions.assertNull(naoExiste);
    }

    @Test
    public void teste03() {
        String numero = "AP03";
        Veiculo v = new Veiculo("PL03", 2022, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("200.00"));
        ap.setValorPremio(new BigDecimal("300.00"));
        ap.setValorMaximoSegurado(new BigDecimal("1500.00"));

        cadastro.incluir(ap, numero);

        boolean excluiu = dao.excluir(numero);
        Assertions.assertTrue(excluiu);
    }

    @Test
    public void teste04() {
        String numero = "AP04";
        Veiculo v = new Veiculo("PL04", 2023, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("250.00"));
        ap.setValorPremio(new BigDecimal("350.00"));
        ap.setValorMaximoSegurado(new BigDecimal("1750.00"));

        cadastro.incluir(ap, numero);

        boolean naoExcluiu = dao.excluir("AP99");
        Assertions.assertFalse(naoExcluiu);
    }

    @Test
    public void teste05() {
        String numero = "AP05";
        Veiculo v = new Veiculo("PL05", 2024, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("300.00"));
        ap.setValorPremio(new BigDecimal("400.00"));
        ap.setValorMaximoSegurado(new BigDecimal("2000.00"));

        boolean incluiu = dao.incluir(ap);
        Assertions.assertTrue(incluiu);

        Apolice buscada = dao.buscar(numero);
        Assertions.assertNotNull(buscada);
    }

    @Test
    public void teste06() {
        String numero = "AP06";
        Veiculo v = new Veiculo("PL06", 2025, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("350.00"));
        ap.setValorPremio(new BigDecimal("450.00"));
        ap.setValorMaximoSegurado(new BigDecimal("2250.00"));

        cadastro.incluir(ap, numero);
        boolean repetido = dao.incluir(ap);
        Assertions.assertFalse(repetido);
    }

    @Test
    public void teste07() {
        String numero = "AP07";
        Veiculo v = new Veiculo("PL07", 2026, null, null, CategoriaVeiculo.BASICO);

        Apolice ap = new Apolice();
        ap.setNumero(numero);
        ap.setVeiculo(v);
        ap.setValorFranquia(new BigDecimal("400.00"));
        ap.setValorPremio(new BigDecimal("500.00"));
        ap.setValorMaximoSegurado(new BigDecimal("2500.00"));

        boolean alterou = dao.alterar(ap);
        Assertions.assertFalse(alterou);
        Assertions.assertNull(dao.buscar(numero));
    }

    @Test
    public void teste08() {
        String numero = "AP08";
        Veiculo v1 = new Veiculo("PL08", 2027, null, null, CategoriaVeiculo.BASICO);

        Apolice ap1 = new Apolice();
        ap1.setNumero(numero);
        ap1.setVeiculo(v1);
        ap1.setValorFranquia(new BigDecimal("450.00"));
        ap1.setValorPremio(new BigDecimal("550.00"));
        ap1.setValorMaximoSegurado(new BigDecimal("2750.00"));

        cadastro.incluir(ap1, numero);

        // altera algum valor
        ap1.setValorPremio(new BigDecimal("600.00"));
        boolean alterou = dao.alterar(ap1);
        Assertions.assertTrue(alterou);
    }
}
