package com.company;



public class Senha {

    private char [] symbles = {'!','@','#','$','%','&','*','(',')','-','+','/','?','=','<','>','.',',','[',']'};
    private boolean securePass = true;
    private int  minLength = 6;



    /*
    Recebe a senha informada
    Chama o metodo VerifyPass para validar a senha
    Imprime no console um feedback sobre a senha
    */
    public void VerifyPassword(String password){

        String newPass = this.ValidatePass(password);
        int length = password.length();
        if(length < this.minLength){
            System.out.println(length+ " caracteres. Voce precisa adicionar, no mínimo, mais "
                    +(this.minLength-length)+" caracteres. Sugestão de uma senha segura: " +newPass);

        }else if(!securePass) {
            System.out.println(length + " caracteres. Mas sua senha não é segura. Sugestão: "+ newPass+" ");

        }else {
            System.out.println(length + " caracteres. Sua senha é segura");
        }
    }


    /*Recebe uma senha para verificação
      Se a senha tiver dentro dos padrões, retorna a propria senha recebida sem alterações
      se não, completa e retorna uma nova senha, de acordo com os padrões de segurança
     */
    private String ValidatePass(String password){

        char [] caracter = password.toCharArray();
        boolean setSymble = true, setNumber = true, setMax = true, setMin = true;

        for( char c : caracter){

            if(setSymble){
                for (char symble : this.symbles){
                    if(c == symble){
                        setSymble = false;
                        break;
                    }
                }
            }
            String subPass = String.valueOf(c);
            if(subPass.matches("[0-9]")) setNumber = false;
            if(subPass.matches("[A-Z]")) setMax = false;
            if(subPass.matches("[a-z]")) setMin = false;

        }

        if(setNumber){
            password = password.concat("1");
            this.securePass= false;
        }
        if(setMax) {
            password = password.concat("A");
            this.securePass = false;
        }
        if(setMin){
            password = password.concat("b");
            this.securePass = false;
        }
        if(setSymble) {
            password = password.concat("@");
            this.securePass = false;
        }

        if(password.length() < this.minLength){
            this.securePass = false;
            String newPass = this.FullPassword(password);
            return newPass;
        }

        return  password;
    }


    private String FullPassword (String password) {

        for (int i = password.length(); i < 6; i++) {
            password = password + (char) (i + 97);
        }
        return password;
    }
}
