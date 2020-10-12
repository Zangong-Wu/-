package main;

import entity.Stroage;
import service.Comparison;
import service.Counter;
import service.Generatetion;

import java.io.*;
import java.util.*;
import java.util.Scanner;

import javax.script.ScriptException;
/**
 * @author Red Date.
 * @date 2020/3/23 20:13
 */
public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
    if(args[0].equals("-t")) {
        String result;
        System.out.print("�������������ʽ");
          Scanner sc=new Scanner(System.in);
		     String s=sc.next();
		  result=Counter.counter(s);
		}
   else {
        if(args.length!=4){
            System.out.println("�������������������롿");
            return;
        }
        Set<String> argsSet = new HashSet<String>();
        argsSet.add(args[0]);
        argsSet.add(args[2]);
        String[] all = {"-n","-r","-e","-a"};
        Set<String> allSet = new HashSet<String>(Arrays.asList(all));
        argsSet.removeAll(allSet);
        if(argsSet.size()>0){
            System.out.println("������������������ȷ�Ĳ�����");
        }
        int num   = 0;
        int bound = 0;
        int index = 0;
        List<String> list = Arrays.asList(args);
        //����ÿһ�����������˳��
        List<List<String>> resultList = new ArrayList<List<String>>();
        if(list.contains("-n") && list.contains("-r")){
            if(args[0].equals("-n"))
                num = Integer.parseInt(args[1]);
            else if (args[2].equals("-n")){
                num = Integer.parseInt(args[3]);
            }
            if(args[0].equals("-r")){
                bound = Integer.parseInt(args[1]);
            }else if(args[2].equals("-r")){
                bound = Integer.parseInt(args[3]);
            }
            File exercises = new File("Exercises.txt");
            File answers = new File("Answers.txt");
            FileOutputStream exercisesStream = new FileOutputStream(exercises);
            FileOutputStream answersStream = new FileOutputStream(answers);
            OutputStreamWriter exercisesWriter = new OutputStreamWriter(exercisesStream, "UTF-8");
            OutputStreamWriter answersWriter = new OutputStreamWriter(answersStream, "UTF-8");
            while (index<num){
                Stroage Stroage = Generatetion.generateFormula(bound,resultList);
                if(Stroage!=null){
                    index++;
                    exercisesWriter.append(index+"."+Stroage.getExpression()+" "+"=");
                    exercisesWriter.append("\n");
                    answersWriter.append(index+"."+Stroage.getResult());
                    answersWriter.append("\n");
                }
            }
            exercisesWriter.close();
            answersWriter.close();
        }else if(args[0].equals("-e")&&args[2].equals("-a")){
            Comparison.verification(args[1],args[3]);
        }
        else{
            System.out.println("����������������������ȷ�Ĳ�����");
          }
        }
    }
}
