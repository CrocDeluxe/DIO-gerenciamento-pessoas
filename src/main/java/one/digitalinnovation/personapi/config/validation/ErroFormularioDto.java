package one.digitalinnovation.personapi.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErroFormularioDto {
    private String campo;
    private String mensagemDeErro;

//    public ErroDeFormularioDto(String mensagemDeErro) {
//        this.mensagemDeErro = mensagemDeErro;
//    }
}
