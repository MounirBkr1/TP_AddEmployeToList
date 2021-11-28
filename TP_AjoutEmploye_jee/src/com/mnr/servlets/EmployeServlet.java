package com.mnr.servlets;

import com.mnr.beans.Employe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeServlet")
public class EmployeServlet extends HttpServlet {

    private List<Employe> employees;
    private Employe employe;
    @Override
    public void init() throws ServletException {
        employees = new ArrayList<Employe>();

        //initialiser 3 objets
        employees.add(new Employe("adnani","amine","adnani@gmail.com"));
        employees.add(new Employe("akabli","ilias","akabli@gail.com"));
        employees.add(new Employe("asrari","hamid","asrari@gmail.com"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recupere list du serveur et l'envoia jsp
         request.setAttribute("employees",employees);
        request.getRequestDispatcher("/listEmployees.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //instancier un nouveau objet
        Employe emp= new Employe();

        //recuperer valeurs
        emp.setNom(request.getParameter("nom"));
        emp.setPrenom(request.getParameter("prenom"));
        emp.setEmail(request.getParameter("email"));
        employees.add(emp);

        //modifier liste au niveau serveur
        request.setAttribute("employees",employees);

        //rediriger vers page listEmployees
        request.getRequestDispatcher("/listEmployees.jsp").forward(request, response);
    }


}
