package br.com.principal.utils;

import org.springframework.http.HttpStatus;

/**
 *
 * @author davidson ferreira
 */
public class MensagemResposta {

    private String mensagem;
    private boolean statusRequisicao;
    private HttpStatus httpStatus;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(boolean statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }   
   
}
