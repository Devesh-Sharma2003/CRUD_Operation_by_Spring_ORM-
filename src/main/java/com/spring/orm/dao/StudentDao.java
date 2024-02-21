package com.spring.orm.dao;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entity.Student;

import java.util.List;

import javax.transaction.Transactional;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public int insert(Student student) {
        Integer result = (Integer) this.hibernateTemplate.save(student);
        return result;
    }
    
    public Student get(int id)
    {
    	Student s = this.hibernateTemplate.get(Student.class, id);
    	return s;
    }
    
    public List<Student> getAll()
    {				
    	List<Student> li = this.hibernateTemplate.loadAll(Student.class);
    	return li;
    }
    	
    @Transactional
    public void Delete (int id)
    {
    	Student st = this.hibernateTemplate.get(Student.class, id);
    	this.hibernateTemplate.delete(st);
    }
    @Transactional
    public void Update (Student s)
    {
    	this.hibernateTemplate.update(s);
    }
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    
}