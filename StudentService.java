package com.biet_sm.StudentManagementSystem;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){
        this.repo = repo;
    }
    public List<Student> getAll(){
        return repo.findAll();
    }
    public Student getByID(Long id){
        return repo.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found.")
        );
    }
    public void save(Student student){
        repo.save(student);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

}
