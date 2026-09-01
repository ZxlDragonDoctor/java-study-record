package 乐信圣文;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 纸牌接龙
public class CardContinue {
    Map<String, List<Card>> answer = new HashMap<>();

    String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public void init(){
        answer.put("梅花",new ArrayList<>());
        answer.put("方块",new ArrayList<>());
        answer.put("黑桃",new ArrayList<>());
        answer.put("红桃",new ArrayList<>());

    }

    public void RankCard(Card[] cards){
        for(Card card:cards){
            List<Card> answerCard = answer.get(card.type);
            if(answerCard.isEmpty())  {
                answerCard.add(card);
                continue;
            }
            int idx = 0;
            while (idx < answerCard.size() && findValueIndex(answerCard.get(idx))>findValueIndex(card)){
                idx++;
            }
            answerCard.add(idx,card);
//            if(findValueIndex(answerCard.get(0))<findValueIndex(card)){
//                answerCard.add(0,card);
//                continue;
//            }
//            for(int i=0;i<answerCard.size();i++){
//                if(findValueIndex(answerCard.get(i))-findValueIndex(card)<0){
//                     answerCard.add(i,card);
//                     break;
//                }
//                if(i==answerCard.size()-1) answerCard.add(card);
//            }
        }
        System.out.println(answer);
    }

    public int findValueIndex(Card card){
        for(int i = 0;i<values.length;i++){
            if(card.value.equals(values[i])) return i;
        }
        return -1;
    }
}


 class  Card{
    String type; //花色
    String value; // 值
}

