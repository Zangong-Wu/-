package service;

import java.io.*;
import java.util.List;

/**
 * 用于检查生成的式子是否重复，检查传入的答案是否正确
 *
 * @author Red Date.
 * @date 2020/3/23 20:16
 */
public class Comparison {

   //判断是否有重复算式
    public static boolean verificationRepeat(List<String> list, List<List<String>> expressionList) {
        for (List<String> expression : expressionList) {
            if (expression.size() == list.size()) {
                int length = list.size();
                int num = -2;    //用于累计符合条件的运算符
                int index1 = 0;
                //运算符和数字一致，判断运算顺序是否一致
                for (int index = 1; index < length; index += 3) {
                    if (expression.get(index).equals(list.get(index))) {
                        //运算符相同时，前后数字是否一致
                        if ((expression.get(index - 1).equals(list.get(index - 1))
                                && expression.get(index + 1).equals(list.get(index + 1)))
                                || (expression.get(index - 1).equals(list.get(index + 1))
                                && expression.get(index + 1).equals(list.get(index - 1)))) {
                            num += 3;
                        }

                    }
                    index1 = index;
                }
                if (num == index1) {
                    return true;
                } else {
                    expressionList.add(list);
                    return false;
                }
            }
        }
        expressionList.add(list);
        return false;
    }

    //
    public static void verification(String verificationFile ,String answersFile) throws IOException {
        BufferedReader readerverification = new BufferedReader(new InputStreamReader(new FileInputStream(verificationFile)));
        BufferedReader answerverification = new BufferedReader(new InputStreamReader(new FileInputStream(answersFile)));
        String verificationLine ="";
        String answerLine ="";
        String correct = "";
        String wrong = "";
        int correctNum = 0;
        int wrongNum = 0;
        while ((verificationLine = readerverification.readLine()) != null && (answerLine = answerverification.readLine()) != null){
            String[] verificationString = verificationLine.split("\\.");
            String[] answerString = answerLine.split("\\.");
            if(verificationString[1].equals(answerString[1])){
                if (correct.equals("")){
                    correct = answerString[0];
                    correctNum++;
                }
                else{
                    correct = correct+","+answerString[0];
                    correctNum++;
                }
            }else{
                if (wrong.equals("")){
                    wrong = answerString[0];
                    wrongNum++;
                }
                else{
                    wrong = wrong+","+answerString[0];
                    wrongNum++;
                }
            }
        }
        readerverification.close();
        answerverification.close();
        OutputStreamWriter resultWriter = new OutputStreamWriter(new FileOutputStream(new File("Grade.txt")), "UTF-8");
        resultWriter.append("Correct:"+correctNum+"("+correct+")");
        resultWriter.append("\n");
        resultWriter.append("Wrong:"+wrongNum+"("+wrong+")");
        resultWriter.close();
        System.out.println("Correct:"+correctNum+"("+correct+")");
        System.out.println("Wrong:"+wrongNum+"("+wrong+")");
    }
}
