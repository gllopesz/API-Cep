package br.com.cep.service;

import br.com.cep.model.Address;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {
    public Address CheckCep(String cep){
        URI adress = URI.create("https://viacep.com.br/ws/" + cep  +"/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(adress)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Address.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel obter o endereço a partir desse CEP");
        }
    }
}
