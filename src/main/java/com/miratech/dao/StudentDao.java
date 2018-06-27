package com.miratech.dao;

import com.miratech.entity.Student;
import javassist.NotFoundException;
import org.hibernate.internal.util.collections.CollectionHelper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Stateless
public class StudentDao {
    @PersistenceContext(unitName = "student_unit")
    private EntityManager em;

    /**
     * Insert new student into Database
     *
     * @param student student's object without id, which will be generated automatically
     * @throws Exception
     */
    public void insertStudent(Student student) throws Exception {
        if (!(Objects.nonNull(student) && Objects.isNull(student.getId()))) {
            throw new Exception("Entity is incorrect!");
        }

        try {
            em.persist(student);
            em.flush();
        } catch (Exception e) {
            throw new Exception("Entity was not added!");
        }
    }

    /**
     * Getting of the all students in DB
     *
     * @return list of the student objects
     */
    public List<Student> getAllStudents() {
        Query query = em.createNamedQuery("getAllStudents");
        List<Student> students = query.getResultList();

        return students;
    }

    /**
     * Getting unique student object by his (her) id
     *
     * @param id identifier of the student
     * @return student's object
     * @throws NotFoundException
     */
    public Student getStudentById(Integer id) throws NotFoundException {
        Query query = em.createNamedQuery("getStudentById");
        query.setParameter("id", id);
        List result = query.getResultList();

        if (CollectionHelper.isNotEmpty(result)) {
            if (result.size() > 1) {
                throw new NonUniqueResultException("It was found more than one entity!");
            }
        } else {
            throw new NotFoundException("Entity was not found!");
        }

        return (Student) result.get(0);
    }
}
