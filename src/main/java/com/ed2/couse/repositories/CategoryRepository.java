package com.ed2.couse.repositories;

import com.ed2.couse.entities.Category;
import com.ed2.couse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
