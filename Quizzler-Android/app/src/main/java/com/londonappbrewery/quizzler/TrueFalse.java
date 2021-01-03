package com.londonappbrewery.quizzler;


import lombok.Data;

@Data
public class TrueFalse {
    private int questionId;
    private boolean answer;

    public TrueFalse(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
    }
}
