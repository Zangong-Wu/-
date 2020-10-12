package service;

import entity.Framanage;

import java.util.ArrayList;
import java.util.List;

public class Calculate {

    //���õݹ�ķ�ʽ������
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

    //������˳����ӵ�������
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

    //�жϼ������Ƿ��г˳������س˳���λ��
    private static int whetherMulDiv(List list){
        for (int i=0;i<list.size();i++){
            if(list.get(i).equals("*")||list.get(i).equals("��"))
                return i;
        }
        return -1;
    }

    //һ�μӷ�������˷��������㣬0Ϊ�Ӽ���1Ϊ�˳�
    private static String addSubMulDiv(List list , int place,int flag){

        String operator1 = null;
        String operator2 = null;
        if (flag == 0){ //ʵ�ּӷ����߼���
            operator1 = "+";
            operator2 = "-";
        }else if(flag == 1){
            operator1 = "*";
            operator2 = "��";
        }
        //��ȡ����ǰ�����
        Framanage Framanage1 = (Framanage) list.get(place-1);
        Framanage Framanage2 = (Framanage) list.get(place+1);
        String symbol = (String) list.remove(place);
        //�Ƴ���һ����
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
            if(operator2.equals("��")){
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

    //�ӷ��ͼ�������,ֱ��������
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
