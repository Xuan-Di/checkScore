package com.wzxlq.score.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Excel {
    private String studentNum;

    private String studentName;

    private String className;

    private String term;

    private Integer courseNum;

    private Integer flunkNum;

    private Float avgScore;

    private Float allScore;

    private Float allCreditScore;

    private Float avgCredit;

    private Float avgCreditPoint;

    private Integer majorRank;

    private ArrayList<String> scores;

    private ArrayList<String> courseName;
}
