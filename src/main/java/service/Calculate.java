package service;

import entity.Framanage;

import java.util.ArrayList;
import java.util.List;

public class Calculate {

    //采用递归的方式计算结果
    public static Framanage calculate(List list){

        int place = whetherMulDiv(list);
        String flag = null;
        if(place != -1){
            flag = addSubMulDiv(list,place,1);

        }else {
             flag = addSub(list);
        }
        if(flag.equals("error")){
            return null;
        }
        if(list.size() == 1)
            return (Framanage)list.get(0);
        return calculate(list);
    }

    //将运算顺序添加到集合中
    public static List<String> operationsOrder(List list){
        List<String> result = new ArrayList<String>();
        String flag = null;
        while (list.size()!=1){
            int place = whetherMulDiv(list);
            if(place != -1){
                result.add(list.get(place-1).toString());
                result.add((String) list.get(place));
                result.add(list.get(place+1).toString());
                flag = addSubMulDiv(list,place,1);
            }else {
                int place1 = 0;
                for (int i=0;i<list.size();i++){
                    if(list.get(i).equals("+")||list.get(i).equals("-")){
                        place1 = i;
                        break;
                    }

                }
                result.add(list.get(place1-1).toString());
                result.add((String) list.get(place1));
                result.add(list.get(place1+1).toString());
                flag = addSubMulDiv(list,place1,0);
            }
        }
        if("error".equals(flag))
            return null;
        return result;
    }

    //判断集合中是否有乘除，返回乘除的位置
    private static int whetherMulDiv(List list){
        for (int i=0;i<list.size();i++){
            if(list.get(i).equals("*")||list.get(i).equals("÷"))
                return i;
        }
        return -1;
    }

    //一次加法减法或乘法除法运算，0为加减，1为乘除
    private static String addSubMulDiv(List list , int place,int flag){

        String operator1 = null;
        String operator2 = null;
        if (flag == 0){ //实现加法或者减法
            operator1 = "+";
            operator2 = "-";
        }else if(flag == 1){
            operator1 = "*";
            operator2 = "÷";
        }
        //获取运算前后的数
        Framanage Framanage1 = (Framanage) list.get(place-1);
        Framanage Framanage2 = (Framanage) list.get(place+1);
        String symbol = (String) list.remove(place);
        //移除后一个数
        list.remove(place);
        if(symbol.equals(operator1)){
            Framanage result = new Framanage();
            if(operator1.equals("*")){
                result = Framanage1.multiplication(Framanage2);
            }else
                result  = Framanage1.addition(Framanage2);
            if(result.isNegative()){
                return "error";
            }
            list.set(place-1,result);
        }else if(symbol.equals(operator2)){
            Framanage result = new Framanage();
            if(operator2.equals("÷")){
                result = Framanage1.division(Framanage2);
            }else
                result = Framanage1.subtraction(Framanage2);
            if(result.isNegative()){
                return "error";
            }
            list.set(place-1,result);
        }
        return "right";
    }

    //加法和减法运算,直接算出结果
    private static String addSub(List list){

        for (int i =0;i<list.size();i++){
            if(list.get(i).equals("+")){
                Framanage Framanage1 = (Framanage)list.get(i-1);
                list.remove(i);
                Framanage Framanage2 = (Framanage)list.get(i);
                list.remove(i);
                Framanage result =  Framanage1.addition(Framanage2);
                if(result.isNegative()){
                    return "error";
                }
                list.set(i-1,result);
                i--;
            }else if(list.get(i).equals("-")){
                Framanage Framanage1 = (Framanage)list.get(i-1);
                list.remove(i);
                Framanage Framanage2 = (Framanage)list.get(i);
                list.remove(i);
                Framanage result =  Framanage1.subtraction(Framanage2);
                if(result.isNegative()){
                    return "error";
                }
                list.set(i-1,result);
                i--;
            }
        }
        return "right";
    }
}
