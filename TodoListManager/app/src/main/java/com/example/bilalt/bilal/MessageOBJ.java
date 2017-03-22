package com.example.bilalt.bilal;

public class MessageOBJ {


    public String message;
    public boolean color;
    public int num ;

    public MessageOBJ(int num, String message) {
        super();
        this.num = num;
        this.color = num%2==0;
        this.message = message;
        }

}
