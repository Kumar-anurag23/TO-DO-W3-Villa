package org.crcketiplmatch.restapi.todo.Repositry;



import org.crcketiplmatch.restapi.todo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
