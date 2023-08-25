package org.creditoRural.customConstraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CepValidator implements ConstraintValidator<Cep, String> {

    private static final String END_POINT_VIACEP = "https://viacep.com.br/ws/%s/json/" ;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String URI = String.format(END_POINT_VIACEP, value);

        return obterRequisicao(URI);

    }

    private boolean obterRequisicao(String stringURI) {

        HttpClient clienteHttp = criarClienteHttp();
        HttpRequest requisicao = criarRequisicao(stringURI);
        HttpResponse<String> resposta;

        try {

            resposta = clienteHttp.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return resposta.statusCode() == 200;

        }
        catch (Exception e){

            e.printStackTrace();
            return false;

        }

    }


    private HttpRequest criarRequisicao(String stringURI){

        URI endPoint = URI.create(stringURI);

        return HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(11))
                .uri(endPoint)
                .build();

    }

    private HttpClient criarClienteHttp() {
        return HttpClient.newHttpClient();
    }


}
