package com.miratech.servlets;

import com.miratech.cof.URIMappings;
import com.miratech.dao.StudentDao;
import com.miratech.entity.Student;
import com.miratech.other_beans.CounterBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.miratech.cof.URIMappings.GLOBAL_COUNTER;
import static com.miratech.cof.URIMappings.INDEX_JSP;
import static com.miratech.cof.URIMappings.URI_ROOT;

@WebServlet(URI_ROOT)
public class StudentsServlet extends HttpServlet {
    @EJB
    private StudentDao studentDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentDao.getAllStudents();

        req.setAttribute(URIMappings.ATTRIBUTE_STUDENTS, students);
        req.setAttribute(URIMappings.ATTRIBUTE_COUNTER, getCounterData(req));
        req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
    }

    private Integer getCounterData(HttpServletRequest req) {
        CounterBean counterBean = (CounterBean) req.getSession().getAttribute(GLOBAL_COUNTER);

        return (!Objects.isNull(counterBean)) ? counterBean.getCounter() : 0;
    }
}
