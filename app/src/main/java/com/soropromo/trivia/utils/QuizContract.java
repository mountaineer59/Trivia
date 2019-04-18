package com.soropromo.trivia.utils;

import android.provider.BaseColumns;

//making final, we cant subclass
public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionTable implements BaseColumns {
        public static final String TABLE_NAME = "trivia_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";

    }

}
