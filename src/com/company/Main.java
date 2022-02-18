package com.company;

import java.util.Scanner;

public class Main {

    public  static int teste (String s){
        return s.matches("[0-9]{1,}") ? Integer.parseInt(s) : 0 ;
    }

    public static <err> void main(String[] args) {

        Anagrama anagrama;
        Escada ladder ;
        Senha password;
        Scanner scanner = new Scanner(System.in);

        int option;
        String teste;

        System.out.println("\n"+
                " Hello dev, para testar as respostas do desafio, escolha as opções abaixo:\n");
        do{
            System.out.println( "1 - Desafio Escada\n2 - Desafio Senha\n3 - Desafio Anagrama\n"+
                    "4 - Para encerrar");


           teste = scanner.nextLine();
           option = Main.teste(teste);

           switch (option){

               case 1 : {
                   int repeat = 0;
                   do{
                       repeat = 0;
                       System.out.println("Digite o número de degraus da escada (base e altura)");
                       teste = scanner.nextLine();
                       int step = Main.teste(teste);
                       ladder = new Escada();
                       ladder.getStep(step);
                       System.out.println("\nQuer testar essa questão novamente? Digite 1 se SIM ou qualquer número para voltar ao menu");
                       teste = scanner.nextLine();
                       repeat = Main.teste(teste);
                       System.out.println(repeat);
                   } while (repeat == 1);
                   break;

               }
               case 2 : {
                   int repeat = 0;
                   do{
                       repeat = 0;
                       System.out.println("Digite uma senha");
                       String pass = scanner.nextLine();
                       password = new Senha();
                       password.VerifyPassword(pass);
                       System.out.println("\nQuer testar essa questão novamente? Digite 1 se SIM ou qualquer número para voltar ao menu");
                       teste = scanner.nextLine();
                       repeat = Main.teste(teste);
                   }while (repeat == 1);
                   break;
               }
               case 3 : {
                   int repeat = 0;
                   do{
                       repeat = 0;
                       System.out.println("Digite uma palavra");
                       String word = scanner.nextLine();
                       anagrama = new Anagrama();
                       anagrama.SearchAnagrama(word);
                       System.out.println("\nQuer testar essa questão novamente? Digite 1 se SIM ou qualquer número para voltar ao menu");
                       teste = scanner.nextLine();
                       repeat = Main.teste(teste);
                   }while (repeat == 1);
                   break;

               }
               case 4 : {
                   System.out.println("VLW, FLW, TMJ");
                   break;
               }
               default : {
                   System.out.println("Please! Escolha entre 1 e 3 ou 4 para sair");
                   break;
               }
           }

        }while (option != 4);


    }
}
