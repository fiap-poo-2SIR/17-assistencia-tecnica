package br.fiap.assistencia_tecnica.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String email;
    private String senha;
}
