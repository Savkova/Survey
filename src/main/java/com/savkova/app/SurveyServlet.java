package com.savkova.app;

import com.savkova.app.entities.Answer;
import com.savkova.app.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@WebServlet(name = "Survey", urlPatterns = "/form")
public class SurveyServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final int year = Integer.parseInt(request.getParameter("year"));

        final Person person = new Person(name, surname, year);

        final int q1 = Integer.parseInt(request.getParameter("q1"));
        final int q2 = Integer.parseInt(request.getParameter("q2"));
        final int q3 = Integer.parseInt(request.getParameter("q3"));

        Answer[] answers = {new Answer(1, q1), new Answer(2, q2), new Answer(3, q3)};

        Map<Person, Answer[]> answerMap = SurveyStorage.getInstance().getAnswerMap();
        answerMap.put(person, answers);

        countRating(person, answers);

        request.setAttribute("totalVoted", answerMap.size());
        request.setAttribute("statistics", AgeGroup.values());

        request.getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/survey.jsp").forward(request, response);
    }

    private void countRating(Person person, Answer[] answers)
    {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - person.getYearOfBirth();

        int totalRate = 0;
        for (Answer answer : answers)
        {
            totalRate += answer.getRate();
        }

        double averageRate = (double) totalRate / answers.length;

        for (AgeGroup group : AgeGroup.values())
        {
            if (age > group.getMinAge() && age <= group.getMaxAge())
            {
                group.updateRating(averageRate);
                return;
            }
        }
    }

}
