package com.example.java20.week4.orm;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *  Hibernate : session : save() / saveOrUpdate() ..
 *  Jpa       : entity manager: persist() / merge() ..
 *  Class Configuration
 *      1. data source
 *      2. entity classes
 *
 *          @Entity
 *          @Table("")
 *          class XX {
 *              @Id
 *              GeneratedType ,  Identity
 *              private String id;
 *              @Column("stu_name")
 *              private String name;
 *          }
 *      3. create relations
 *
 *          class A {
 *              @OneToMany(mappedBy = "a123", fetchType.LAZY)
 *              private List<B> bList = new ArrayList<>();
 *          }
 *
 *          class B {
 *              @ManyToOne
 *              @JoinColumn(foreign key, fetchType.LAZY)
 *              private A a123;
 *          }
 *     4. session / entity manager
 *     5. transaction
 *
 *      List<Student> stuList = em.createQuery(Select..);
 *     *      *      *      *      *      *      *      *      *      *      *      *      *
 *  1. why orm / hibernate
 *  ..
 *  2. diff lazy loading and eager loading
 *  ..
 *  3. what is N + 1 problem
 *      student 1 - m student_teacher lazy loading
 *      List<Student> list = em.createQuery(..);  1
 *      for(Student stu: list) {
 *          stu.getStudentTeacher();    N
 *      }
 *      return list;
 *  4. how to solve N + 1 problem
 *      fetch join -> convert lazy loading query to eager loading query
 *      entity graph
 *  5. status / stage of instance in ORM
 *      transient : new instance()
 *      proxied / attached : proxy instance
 *      un-proxied / detached :
 *  6. lazy initialization exception
 *  7. data source
 *
 *
 *  coding question
 *  1. write entity classes on white board
 *  2. write sql query
 *  3. write spring data jpa
 *
 *
 *
 *  TODO
 *      1. create package under the jdbc homework
 *      2. use ORM Config to connect to your database
 *
 *
 *
 *
 */
public class ORMConfig {

    private DataSource getDataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setDatabaseName("OrmDemo");
        dataSource.setUser("postgres");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/university");
        return dataSource;
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com/example/java20/week4/orm");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties);
        em.setPersistenceUnitName("demo-unit");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }

    public static void main(String[] args) {
        ORMConfig ormConfig = new ORMConfig();
        DataSource dataSource = ormConfig.getDataSource();
        Properties properties = ormConfig.getProperties();
        EntityManagerFactory entityManagerFactory = ormConfig.entityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();
        PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();
        //..

//        em.getTransaction().begin();
        Student s = new Student();
        s.setAge(11);
        s.setFirst("tj");
        s.setLast("kim");

        em.persist(s);
//        em.flush();


    }


    private static void insertToStudent(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = new Student();
        s.setAge(12);
        s.setFirst("insert_tj");
        s.setLast("insert_kim");
        s.setId("17");

        em.merge(s);
        tx.commit();
    }

    private static void getStudentById(EntityManager em) {
        Query query = em.createQuery("select s from Teacher s left join fetch s.id ts where s.id = ?1");
        query.setParameter(1, "17");
        Student s = (Student)query.getSingleResult();
        System.out.println(s);
    }

    private static void addToJunctionTable1(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = new Student();
        s.setAge(13);
        s.setFirst("tj");
        s.setLast("kim");

        Teacher t = new Teacher();
        //persist t first to get new id
        em.persist(t);
        t.setAge(31);
        t.setFirst("addJunc_tj_teacher");
        t.setLast("addJunc_kim_teacher");

        //build connection between t and s
        Teacher_Student ts = new Teacher_Student();
        ts.setS_id(s.getId());
        ts.setT_id(t.getId());
        t.addTeacher_students(ts);
        em.persist(s);
        tx.commit();
    }

    private static void addToJunctionTable2(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createNativeQuery("INSERT INTO TEACHER_STUDENT (S_ID, T_ID) VALUES (?, ?)");
        query.setParameter(1, 4);
        query.setParameter(2, 4);
        query.executeUpdate();
        tx.commit();
    }

    private static void addToJunctionTable3(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, "14");
        Teacher t = em.find(Teacher.class, "9");

        Teacher_Student ts = new Teacher_Student();
        ts.setS_id(s.getId());
        ts.setT_id(t.getId());

        em.persist(ts);
        tx.commit();
    }

    private static void notOrphanRemoveBiRelation(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Teacher s join fetch s.id ts where s.id = ?1");
        query.setParameter(1, "5");
        Student s = (Student) query.getSingleResult();
        Teacher t = em.find(Teacher.class, "3");
        List<Teacher_Student> teacher_students = new ArrayList<>();
        for(Teacher_Student ts: s.getTeacherForStu()) {
            if(ts.getT_id().equals(t.getId())) {
                teacher_students.add(ts);
                em.remove(ts);
            }
        }
        s.getTeacherForStu().removeAll(teacher_students);
        t.getStudentsForTea().removeAll(teacher_students);

        tx.commit();
    }

    private static void notOrphanRemoveSingleRelation(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Teacher s join fetch s.id ts where s.id = ?1");
        query.setParameter(1, "5");
        Student s = (Student) query.getSingleResult();
        for(Teacher_Student ts: s.getTeacherForStu()) {
            em.remove(ts);
        }
        s.setTeacherForStu(new ArrayList<>());
        tx.commit();
    }

    private static void orphanRemove(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Teacher s join s.id ts where s.id = ?1");
        query.setParameter(1, "14");
        Student s = (Student) query.getSingleResult();
        Iterator<Teacher_Student> itr = s.getTeacherForStu().iterator();
        while(itr.hasNext()) {
            Teacher_Student ts = itr.next();
            if(ts.getT_id().equals("9")) {
                itr.remove();
            }
        }
        tx.commit();
    }


    private static void withoutOrphanRemove(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Teacher s join fetch s.id ts where s.id = ?1");
        query.setParameter(1, "14");
        Student s = (Student) query.getSingleResult();
        Iterator<Teacher_Student> itr = s.getTeacherForStu().iterator();
        while(itr.hasNext()) {
            Teacher_Student ts = itr.next();
            if(ts.getT_id().equals("9")) {
                itr.remove();
                em.remove(ts);
            }
        }
        tx.commit();
    }
}

/**
 *  spring transaction
 * @Transactional
 * public void xx() {
 *
 * }
 *  **************
 *  begin
 *      insert
 *  rollback
 *  commit
 *  **************
 *  create / drop table => ddl
 *  **************
 *  database session exit / disconnect => auto commit
 */