/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

/**
 *
 * @author adammenker
 */
public class TestClass {
    public int myNum;
    public float myFloat;
    
    static int x;
    
    public static void check(){
        int x = check2();
        //this.x = 1;
    }
    
    public static int check2(){
        return 1;
    }
    
    public int check3(){
        check();
        return 1;
    }
}
