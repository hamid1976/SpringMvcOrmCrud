package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.EmpDao;
import springmvc.model.Emp;

@Service
public class EmpService {
    
    @Autowired
    private EmpDao empDao;

    public int createEmp(Emp emp) {
        return this.empDao.saveEmp(emp);
    }

    public int updateEmp(Emp emp) {
        return this.empDao.update(emp);
    }
    
    public void deleteEmp(int id) {
        this.empDao.delete(id);
    }

    public Emp getById(int id) {
        return this.empDao.getById(id);
    }
}
