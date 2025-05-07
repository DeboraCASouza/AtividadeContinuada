package br.edu.cs.poo.ac.seguro.entidades;

public enum TipoSinistro {
    COLISAO(1, "Colisão"),
    INCENDIO(2, "Incêndio"),
    FURTO(3, "Furto"),
    ENCHENTE(4, "Enchente"),
    DEPREDACAO(5, "Depredação");

    private int codigo;
    private String nome;

    private TipoSinistro(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static TipoSinistro getTipoSinistro(int codigo) {
        TipoSinistro tipo[] = TipoSinistro.values();
        for (int i = 0; i < tipo.length; i++) {
            if (tipo[i].getCodigo() == codigo) {
                return tipo[i];
            }
        }
        return null;
    }
}
