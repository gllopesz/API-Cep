package br.com.cep.model;

public record Address(String logradouro, String bairro, String localidade, String uf, String cep) {
    public String formatted(){
        return
                """
                Rua: %s
                Bairro: %s
                Cidade: %s
                Uf: %s
                Cep: %s     
                """.formatted(logradouro, bairro, localidade, uf, cep);

    }
}
