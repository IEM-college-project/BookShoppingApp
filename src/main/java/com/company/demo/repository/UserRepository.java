package com.company.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD:src/main/java/com/company/demo/repository/OrderDetailsRepository.java
import com.company.demo.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
=======
import com.company.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
>>>>>>> bugfix:src/main/java/com/company/demo/repository/UserRepository.java

}
