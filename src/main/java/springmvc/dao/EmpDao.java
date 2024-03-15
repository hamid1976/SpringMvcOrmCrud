////package springmvc.dao;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.orm.hibernate5.HibernateTemplate;
////import org.springframework.stereotype.Repository;
////import org.springframework.transaction.annotation.Transactional;
////
////import springmvc.model.Emp;
////
////@Repository
////public class EmpDao {
////
////    private final HibernateTemplate hibernateTemplate;
////
////    @Autowired
////    public EmpDao(HibernateTemplate hibernateTemplate) {
////        this.hibernateTemplate = hibernateTemplate;
////    }
////
////    @Transactional
////    public int saveEmp(Emp emp) {
////        int id = (Integer) this.hibernateTemplate.save(emp);
////        return id;
////    }
////
////    public List<Emp> getAll() {
////        return hibernateTemplate.loadAll(Emp.class);
////    }
////    
////    
////    
////    public int update(Emp employee) {
////        try {
////            String sql = "UPDATE employee SET name=?, cnic=?, email=?, mobileNo=?, address=? WHERE employeeNo=?";
////            return template.update(sql, employee.getName(), employee.getCnic(), employee.getEmail(),
////                    employee.getMobileNo(), employee.getAddress(), employee.getEmployeeNo());
////        } catch (DataAccessException e) {
////            // Handle database-related exceptions
////            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
////        }
////    }
////}
//package springmvc.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import springmvc.model.Emp;
//
//@Repository
//public class EmpDao {
//
//    private final HibernateTemplate hibernateTemplate;
//
//    @Autowired
//    public EmpDao(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    @Transactional
//    public int saveEmp(Emp emp) {
//        int id = (Integer) this.hibernateTemplate.save(emp);
//        return id;
//    }
//
//    public List<Emp> getAll() {
//        return hibernateTemplate.loadAll(Emp.class);
//    }
//
//    @Transactional
//    public void update(Emp employee) {
//        try {
//            // Merge the detached employee object into the persistent context
//            hibernateTemplate.merge(employee);
//        } catch (Exception e) {
//            // Handle exceptions appropriately
//            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
//        }
//    }
//
//}




//package springmvc.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import springmvc.model.Emp;
//
//@Repository
//public class EmpDao {
//
//    private final HibernateTemplate hibernateTemplate;
//
//    @Autowired
//    public EmpDao(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    @Transactional
//    public int saveEmp(Emp emp) {
//        int id = (Integer) this.hibernateTemplate.save(emp);
//        return id;
//    }
//
//    public List<Emp> getAll() {
//        return hibernateTemplate.loadAll(Emp.class);
//    }
//
//    @Transactional
//    public void update(int id) {
//        try {
//            // Merge the detached employee object into the persistent context
//            hibernateTemplate.merge(id);
//        } catch (Exception e) {
//            // Handle exceptions appropriately
//            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
//        }
//    }
//
//    public Emp getById(int id) {
//        return hibernateTemplate.get(Emp.class, id);
//    }
//}










package springmvc.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.Emp;

@Repository
public class EmpDao {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public EmpDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int saveEmp(Emp emp) {
        int id = (Integer) this.hibernateTemplate.save(emp);
        return id;
    }

    public List<Emp> getAll() {
        return hibernateTemplate.loadAll(Emp.class);
    }

    @Transactional
    public int update(Emp employee) {
        try {
            // Merge the detached employee object into the persistent context
            hibernateTemplate.update(employee);
            return 1; // or the number of entities updated, depending on your needs
        } catch (Exception e) {
            // Handle exceptions appropriately
            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
        }
    }
    
    @Transactional
    public void delete(int id) {
        try {
            Emp emp = hibernateTemplate.load(Emp.class, id);
            hibernateTemplate.delete(emp);
        } catch (Exception e) {
            // Handle exceptions appropriately
            throw new RuntimeException("Error deleting employee: " + e.getMessage(), e);
        }
    }
    

    public Emp getById(int id) {
        return hibernateTemplate.get(Emp.class, id);
    }
}

