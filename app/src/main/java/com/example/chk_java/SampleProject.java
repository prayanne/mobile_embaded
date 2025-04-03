package com.example.chk_java;

import java.util.Arrays;

public class SampleProject{
    public static void main(String[] args){

        //static, value type
        final double PI = 3.14;
        byte val1 = 127;
        int[] list = new int[10];

        //for
        for(int i =0; i<10; i++){
            list[i] = i;
            System.out.println(list[i]);
        }

        // while
        int n = 0;
        while(n<10){
            list[n] = n;
            System.out.println(list[n]);
            n++;
        }

        //class, object, override
        test obj = new test();
        obj.test(1);
        obj.test(1.13f);
        obj.test(1.13d);

        // override2
        Rectangle obj2 = new Rectangle(0,0,1,1);

        // SafeArray
        SafeArray arr = new SafeArray(5);

        System.out.println(arr.get(0));
        arr.put(1, 123);
        System.out.println(arr.get(1));
        arr.getList();

        //
    }
}

// overloading
class test{
    int test(int i) {
        System.out.println("int");
        return 0;
    }
    double test(double i){
        System.out.println("double");
        return 0;
    }
    float test(float i){
        System.out.println("flaot");
        return 0;
    }
}

class SafeArray{
    private int a[];
    public int length;
    public SafeArray(int size){
        a = new int[size];
        length = size;
    }
    public int get(int index){
    if(index >= 0 && index < length){
            return a[index];
        }
        return -1;
    }
    public void put(int index, int value){
        if(index >= 0 && index < length){
            a[index] = value;
        } else {
            System.out.println("Wrong Index: " + index);
        }
    }
    public void getList(){
        System.out.println("\n\n" + this.get(0) + this.get(1) + this.get(2));
    }
}

class Rectangle{
    private int x, y, width, height;
    Rectangle(){
        this(0,0,1,1);
    }
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}