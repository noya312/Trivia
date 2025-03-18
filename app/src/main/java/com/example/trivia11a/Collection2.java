package com.example.trivia11a;

import java.util.ArrayList;

public class Collection2  {


        private ArrayList<Question> arr;
        private int index; // מספר השאלה הבאה בתור

        public Collection2()
        {
            Question q1 = new Question("צהוב + אדום=","ורוד", "כתום", "צהוב","לבן", 2);
            Question q2 = new Question("אדום + לבן=", "ירוק", "שחור", "ורוד","סגול", 3);
            Question q3 = new Question("לבן + שחור=", "תכלת", "חום", "אפור","אדום", 3);
            Question q4 = new Question("כחול + אדום=", "סגול", "תכלת", "כתום","טורקיז", 1);
            Question q5 = new Question("כחול + צהוב=", "ירוק", "חום", "כחול","לבן", 1);

            arr = new ArrayList<>();
            arr.add (q1);
            arr.add (q2);
            arr.add (q3);
            arr.add (q4);
            arr.add (q5);
        }

        public void initQuestions()
        {
            index = 0;
        }

        public Question getNextQuestion()
        {
            // הפעולה מחזירה הפניה לשאלה הבאה
            Question q = arr.get(index);
            index++;
            return q;
        }

        public boolean isNotLastQuestion() {
            // הפעולה מחזירה אמת אם אנו בשאלה האחרונה
            return (index < arr.size()); // if not at the end of the ArrayList
            // }
        }

        public int getIndex() {
            return index;
        }
    }




