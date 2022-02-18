package com.company;



public class Senha {

    private boolean securityPass = true;
    private int  minLength = 6;


    public void VerifyPassword(String password){

        String newPass = this.ValidatePass(password);
        int length = password.length();
        if(length < this.minLength){
            System.out.println(length+ " caracteres. Voce precisa adicionar pelo menos mais "
                    +(this.minLength-length)+" caracteres para uma senha segura. Exmeplo de uma senha: " +newPass);

        }else if(!securityPass) {
            System.out.println(length + " caracteres. Mas sua senha não é segura. Sugestão: "+ newPass+" ");

        }else {
            System.out.println(length + " caracteres. Sua senha é segura");
        }
    }

    private String ValidatePass(String password){

        char [] caracter = password.toCharArray();
        char [] symbles = {'!','@','#','$','%','&','*','(',')','-','+','/','?','=','<','>','.',',','[',']'};
        boolean setSymble = true, setNumber = true, setMax = true, setMin = true;

        for( char c : caracter){

            if(setSymble){
                for (char symble : symbles){
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
            this.securityPass = false;
        }
        if(setMax) {
            password = password.concat("A");
            this.securityPass = false;
        }
        if(setMin){
            password = password.concat("b");
            this.securityPass = false;
        }
        if(setSymble) {
            password = password.concat("@");
            this.securityPass = false;
        }

        if(password.length() < this.minLength){
            this.securityPass = false;
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
