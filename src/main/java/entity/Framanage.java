package entity;

import java.util.Random;


public class Framanage {

    private int numerator;      //����
    private int denominator;    //��ĸ

    public Framanage(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Framanage(int numerator){
     this.numerator = numerator;
     this.denominator = 1;
     }

    //�ڸ�����Χ������һ�����������
    public Framanage(boolean isFramanage,int bound){
        Random random = new Random();
        int numerator = random.nextInt(bound);
        while (numerator==0 ){               //���Ӳ���Ϊ0
            numerator = random.nextInt(bound);
        }
        //����һ������
        if(isFramanage){
            int denominator = random.nextInt(bound);
            //��ĸ����Ϊ0
            while (denominator==0 ){
                denominator = random.nextInt(bound);
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }else{                                  //��������
            this.numerator = numerator;
            this.denominator = 1;
        }
    }

    public Framanage(){

    }

    //�ӷ�����
    public Framanage addition(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //���ӳ˷ֱ�˷�ĸ�����
        int newNumerator =  this.denominator * numerator+this.numerator * denominator ;
        //��ĸ���
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    //��������
    public Framanage subtraction(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //�µķ���
        int newNumerator = this.numerator * denominator - this.denominator * numerator;
        //�µķ�ĸ
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    //��������
    public Framanage division(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //�µķ���
        int newNumerator = this.numerator * denominator ;
        //�µķ�ĸ
        int newDenominator = this.denominator * numerator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    public Framanage multiplication(Framanage Framanage){
        int numerator = Framanage.getNumerator();
        int denominator = Framanage.getDenominator();
        //�µķ���
        int newNumerator = this.numerator * numerator ;
        //�µķ�ĸ
        int newDenominator = this.denominator * denominator;
        Framanage result = new Framanage(newNumerator,newDenominator);
        return result;
    }

    // ��շת����������Լ��
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // �Է�������Լ��
    public void appointment() {
        // ���������0���ĸ��1�Ͳ���Լ����
        if (numerator == 0 || denominator == 1)
            return;
        int gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    //�жϸ����Ƿ�Ϊ����
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
    //TODO û�п���ȫ�����
    //��дtoString������Լ����Ľ��
    @Override
    public String toString(){
        appointment();
        //����Ϊ0
        if(numerator == 0)
            return ""+ numerator;
        //�����
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
