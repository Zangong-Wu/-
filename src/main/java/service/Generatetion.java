package service;

import entity.Framanage;
import entity.Stroage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generatetion {

    
    public static Stroage generateFormula(int bound,List<List<String>> resultList){

        String expression = "";
        Random random = new Random();
        String[] operator ={"+","-","*","��"};
        //������������������ó���3
        int operatorNum = random.nextInt(3);
        //�ü������ڴ����ʽ���������
        List list = new ArrayList();

        switch (operatorNum){
            //һ�������
            case 0:{
                int operand = random.nextInt(3);
                //��һ������
                if (operand == 0){
                    Framanage Framanage = new Framanage(true,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString();
                }else if(operand == 1){
                    Framanage Framanage = new Framanage(true,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString();
                }
                else if(operand == 2){   //�޷���
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString();
                }
                break;
            }
            //���������
            case 1:{
                int operand = random.nextInt(4);
                //һ������
                if(operand == 0){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString();
                }
                //��������
                else if(operand == 1){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString();
                }
                //��������
                else if(operand == 2){
                    Framanage Framanage = new Framanage(true,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString();
                }
                //�޷���
                else if(operand == 3){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    Framanage Framanage2 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString();
                }
                break;
            }
            //���������
            case 2:{
                int operand = random.nextInt(4);
                //һ������
                if(operand == 0){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    Framanage Framanage3 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    String symbol2 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    list.add(symbol2);
                    list.add(Framanage3);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString()
                                +" "+symbol2+" "+Framanage3.toString();
                }
                //��������
                else if(operand == 1){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    Framanage Framanage3 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    String symbol2 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    list.add(symbol2);
                    list.add(Framanage3);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString()
                            +" "+symbol2+" "+Framanage3.toString();
                }
                //��������
                else if(operand == 2){
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    Framanage Framanage3 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    String symbol2 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    list.add(symbol2);
                    list.add(Framanage3);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString()
                            +" "+symbol2+" "+Framanage3.toString();
                }
                //�ĸ�����
                else if(operand == 3){
                    Framanage Framanage = new Framanage(true,bound);
                    Framanage Framanage1 = new Framanage(true,bound);
                    Framanage Framanage2 = new Framanage(true,bound);
                    Framanage Framanage3 = new Framanage(true,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    String symbol2 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    list.add(symbol2);
                    list.add(Framanage3);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString()
                            +" "+symbol2+" "+Framanage3.toString();
                }else {     //û�з���
                    Framanage Framanage = new Framanage(false,bound);
                    Framanage Framanage1 = new Framanage(false,bound);
                    Framanage Framanage2 = new Framanage(false,bound);
                    Framanage Framanage3 = new Framanage(false,bound);
                    String symbol = operator[random.nextInt(4)];
                    String symbol1 = operator[random.nextInt(4)];
                    String symbol2 = operator[random.nextInt(4)];
                    list.add(Framanage);
                    list.add(symbol);
                    list.add(Framanage1);
                    list.add(symbol1);
                    list.add(Framanage2);
                    list.add(symbol2);
                    list.add(Framanage3);
                    expression = ""+Framanage.toString()+" "+symbol+" "+Framanage1.toString()+" "+symbol1+" "+Framanage2.toString()
                            +" "+symbol2+" "+Framanage3.toString();
                }
            }
            break;
        }
        //��������ʽ��
        List list1 = new ArrayList();
        for (int i= 0;i<list.size();i++)
             list1.add(list.get(i));
        //������
        Framanage resultFramanage = Calculate.calculate(list);
        if(resultFramanage == null)
            return null;
        //�������ʽ��ת����List<String>
        List<String> stringList = Calculate.operationsOrder(list1);
        //ȥ��
        boolean flag = Comparison.verificationRepeat(stringList,resultList);
        if(flag)
            return null;
        else
            return new Stroage(expression,resultFramanage.toString());
    }
}
