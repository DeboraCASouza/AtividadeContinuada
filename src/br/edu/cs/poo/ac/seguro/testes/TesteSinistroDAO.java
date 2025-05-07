package br.edu.cs.poo.ac.seguro.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;

public class TesteSinistroDAO extends TesteDAO {
    private SinistroDAO dao = new SinistroDAO();

    @Override
    protected Class getClasse() {
        return Sinistro.class;
    }

    @Test
    public void teste01() {
        String numero = "0001";
        Sinistro s = new Sinistro();
        s.setNumero(numero);
        cadastro.incluir(s, numero);

        Sinistro encontrado = dao.buscar(numero);
        Assertions.assertNotNull(encontrado);
    }

    @Test
    public void teste02() {
        String numero = "0002";
        Sinistro s = new Sinistro();
        s.setNumero(numero);
        cadastro.incluir(s, numero);

        Sinistro naoExiste = dao.buscar("9999");
        Assertions.assertNull(naoExiste);
    }

    @Test
    public void teste03() {
        String numero = "0003";
        Sinistro s = new Sinistro();
        s.setNumero(numero);
        cadastro.incluir(s, numero);

        boolean excluiu = dao.excluir(numero);
        Assertions.assertTrue(excluiu);
    }

    @Test
    public void teste04() {
        String numero = "0004";
        Sinistro s = new Sinistro();
        s.setNumero(numero);
        cadastro.incluir(s, numero);

        boolean naoExcluiu = dao.excluir("9998");
        Assertions.assertFalse(naoExcluiu);
    }

    @Test
    public void teste05() {
        String numero = "0005";
        Sinistro s = new Sinistro();
        s.setNumero(numero);

        boolean incluiu = dao.incluir(s);
        Assertions.assertTrue(incluiu);

        Sinistro buscou = dao.buscar(numero);
        Assertions.assertNotNull(buscou);
    }

    @Test
    public void teste06() {
        String numero = "0006";
        Sinistro s = new Sinistro();
        s.setNumero(numero);
        cadastro.incluir(s, numero);

        boolean repetido = dao.incluir(s);
        Assertions.assertFalse(repetido);
    }

    @Test
    public void teste07() {
        String numero = "0007";
        Sinistro s = new Sinistro();
        s.setNumero(numero);

        boolean alterou = dao.alterar(s);
        Assertions.assertFalse(alterou);

        Assertions.assertNull(dao.buscar(numero));
    }

    @Test
    public void teste08() {
        String numero = "0008";
        Sinistro s1 = new Sinistro();
        s1.setNumero(numero);
        cadastro.incluir(s1, numero);

        Sinistro s2 = new Sinistro();
        s2.setNumero(numero);
        boolean alterou = dao.alterar(s2);
        Assertions.assertTrue(alterou);
    }
}
