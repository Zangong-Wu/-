package entity;

import java.util.Random;


public class Framanage {

    private int numerator;      //分子
    private int denominator;    //分母

    public Framanage(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Framanage(int numerator){
     this.numerator = numerator;
     this.denominator = 1;
     }

    //在给定范围内生成一个整数或分数
    public Framanage(boolean isFramanage,int bound){
        Random random = new Random();
        int numerator = random.nextInt(bound);
        while (numerator==0 ){               //分子不能为0
            numerator = random.nextInt(bound);
        }
        //生成一个分数
        if(isFramanage){
            int denominator = random.nextInt(bound);
            //分母不能为0
            while (denominator==0 ){
                denominator = random.nextInt(bound);
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }else{                                  //生成整数
            this.numerator = numerator;
            this.denominator = 1;
        }
    }

    public Framanage(){

    }

    //加法运算
    public Framanage addition(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //分子乘分别乘分母再相加
        int newNumerator =  this.denominator * numerator+this.numerator * denominator ;
        //分母相乘
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    //减法运算
    public Framanage subtraction(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //新的分子
        int newNumerator = this.numerator * denominator - this.denominator * numerator;
        //新的分母
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    //除法运算
    public Framanage division(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //新的分子
        int newNumerator = this.numerator * denominator ;
        //新的分母
        int newDenominator = this.denominator * numerator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    public Framanage multiplication(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //新的分子
        int newNumerator = this.numerator * numerator ;
        //新的分母
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    // 用辗转相除法求最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 对分数进行约分
    public void appointment() {
        // 如果分子是0或分母是1就不用约分了
        if (numerator == 0 || denominator == 1)
            return;
        int gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    //判断该数是否为负数
    public boolean isNegative(){
        return  (this.getDenominator()<0 || this.getNumerator()<0);
    }

    
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    //TODO 没有考虑全部情况
    //重写toString，返回约分完的结果
    @Override
    public String toString(){
        appointment();
        //分子为0
        if(numerator == 0)
            return ""+ numerator;
        //真分数
        else if(numerator > denominator){
            if(numerator % denominator == 0)
                return "" + numerator/denominator;
            return "" + numerator/denominator + "'" + numerator%denominator +"/" + denominator;
        }else if(numerator == denominator){
            return "" + numerator;
        }
            return "" + numerator + "/" + denominator;
    }

   
}
