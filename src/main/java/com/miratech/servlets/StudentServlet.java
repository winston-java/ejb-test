package com.miratech.servlets;

import com.miratech.cof.URIMappings;
import com.miratech.dao.StudentDao;
import com.miratech.entity.Student;
import com.miratech.other_beans.CounterBean;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.miratech.cof.URIMappings.*;

@WebServlet(URI_ENTITY)
public class StudentServlet extends HttpServlet {
    @EJB
    private StudentDao studentDao;

    @EJB
    private CounterBean counterBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(URIMappings.PARAM_ID);
        Student student = null;
        if (StringUtils.isNumeric(id)) {
            try {
                student = studentDao.getStudentById(Integer.valueOf(id));
            } catch (NotFoundException e) {
                //place for log
                resp.sendRedirect(URI_CONTEXT_ROOT);
                return;
            }
        } else {
            //place for log
            resp.sendRedirect(URI_CONTEXT_ROOT);
            return;
        }

        req.setAttribute(URIMappings.ATTRIBUTE_STUDENT, student);
        req.getRequestDispatcher(ENTITY_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(URIMappings.PARAM_FIRST_NAME);
        String lastName = req.getParameter(URIMappings.PARAM_LAST_NAME);

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);

        try {
            studentDao.insertStudent(student);
        } catch (Exception e) {
            //place for logging
        }

        if (Objects.isNull(req.getSession().getAttribute(GLOBAL_COUNTER))) {
            req.getSession().setAttribute(GLOBAL_COUNTER, counterBean);
        }

        counterBean.inc();
        resp.sendRedirect(URI_CONTEXT_ROOT);
    }
}
