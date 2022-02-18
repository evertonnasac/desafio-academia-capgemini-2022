package com.company;

public class Escada {

    private int height;

    public void getStep (int step){
        this.height = step;
        if(step <= 0){
            System.out.println("Teste apenas com numeros inteiros e maiores que 0");
        }
        else {
            print(step);
        }
    }

    private int print(int steps){

        for(int i = 1; i < steps; i++){
            System.out.print(" ");
        }
        for(int i = steps; i <= this.height; i++){
            System.out.print("*");
        }

        System.out.print("\n");

        return (steps == 1 ) ?  0 : print(steps - 1);
    }
}
