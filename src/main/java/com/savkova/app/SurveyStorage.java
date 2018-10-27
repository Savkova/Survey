package com.savkova.app;

import com.savkova.app.entities.Answer;
import com.savkova.app.entities.Person;

import java.util.concurrent.ConcurrentHashMap;

public class SurveyStorage
{
    private static volatile SurveyStorage instance;
    private ConcurrentHashMap<Person, Answer[]> answerMap = new ConcurrentHashMap<>();

    private SurveyStorage() {}

    public static SurveyStorage getInstance() {
        SurveyStorage storage = instance;
        if (storage == null) {
            synchronized (SurveyStorage.class) {
                storage = instance;
                if (storage == null) {
                    instance = storage = new SurveyStorage();
                }
            }
        }
        return storage;
    }

    public ConcurrentHashMap<Person, Answer[]> getAnswerMap()
    {
        return answerMap;
    }
}
