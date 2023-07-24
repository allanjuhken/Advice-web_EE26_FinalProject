package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
