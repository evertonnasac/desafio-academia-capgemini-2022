package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Anagrama {

    //Contador de pares de anagramas da palavra recebida
    private int countAnagrama = 0;

    //Recebe  uma string e separa em pares de substrings.
    // Depois chama método "Matches" passando as substrings para checar se são iguais.
    public void SearchAnagrama(String word){

        //Guarda o par de substrings que são anagramas
        ArrayList <String> anagramas = new ArrayList<>();

        word = word.toUpperCase();

        int length = word.length();
        boolean match;
        String sub1 = "", sub2 = "";


        for(int l = 0; l < length; l++){
            //Cria a primeira substring com os apontadores l  para o inicio e i para o final da substring
            for(int i = l+1; i <= length; i ++){

                sub1 = word.substring(l, i);

                int nextBegin = l;

               //Cria a segunda substring com os apontadores "nextBegin" para o inicio se a substring for maior que 1
                // e j para o início e final se o tamanho da substring for igual a 1
                for (int j = i ; j <length; j++ ){

                    nextBegin +=1;

                    //Verifica se a primeira substring tem tamanho 1
                    //Obs.: i e l apontam para o inicio e final de sub1
                    if(i-l <= 1 ){

                        sub2 = word.substring(j, j+1);

                        //chama o metodo Match passando as duas substring, que retorna true se forem iguais, ou false se não forem
                        match = this.Macth(sub1, sub2);

                        if(match){
                            this.countAnagrama +=1;
                            anagramas.add(new String("["+sub1+"."+sub2+"]"));
                        }
                    }
                    //Verifica se a primeira substring é maior que 1
                    else{
                        sub2 = word.substring(nextBegin, j+1);
                        match = this.Macth(sub1,sub2);

                        if(match) {
                            countAnagrama += 1;
                            anagramas.add(new String("["+sub1+"."+sub2+"]"));

                        }


                    }
                }
            }
        }
        System.out.println(this.countAnagrama+" pares de anagramas a palavra possui: " + anagramas.toString());
    }

    //Recebe duas substring e retorna true se forem iguais ou false se não forem
    protected boolean Macth(String sub1, String sub2){

        char[] str1, str2;

        str1 = sub1.toCharArray();
        str2 = sub2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        String sub1Sorted = new String(str1);
        String sub2Sorted = new String(str2);

        return sub1Sorted.equals(sub2Sorted);


    }
}
