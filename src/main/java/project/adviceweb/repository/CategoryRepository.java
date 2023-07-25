package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}