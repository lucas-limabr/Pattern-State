package com.designPattern.state.core;

public class Documento {

    private DocumentoEstado estado;
    private String texto;

    public Documento()
    {
        this.estado = DocumentoEmRascunho.getInstance();
    }

    public void setEstado(DocumentoEstado estado) {
        this.estado = estado;
    }

    public DocumentoEstado getEstado() {
        return estado;
    }

    public boolean escreverRascunho(String rascunho)
    {
       this.texto = rascunho;
        return estado.escreverRascunho(this);
    }

    public boolean revisarDocumento()
    {
        return estado.revisarDocumento(this);
    }

    public boolean aprovarDocumento()
    {
        return estado.aprovarDocumento(this);
    }

    public boolean publicarDocumento()
    {
        return estado.publicarDocumento(this);
    }
}
