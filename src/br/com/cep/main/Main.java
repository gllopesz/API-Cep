package br.com.cep.main;

import br.com.cep.model.Address;
import br.com.cep.service.CepService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CEP para busca: ");
        String cep = scanner.nextLine();

        try {
            CepService consulta = new CepService();
            Address novoEndereco = consulta.CheckCep(cep);
            System.out.println(novoEndereco.formatted());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
