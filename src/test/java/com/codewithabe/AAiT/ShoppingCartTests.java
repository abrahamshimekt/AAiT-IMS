//package com.EthioPharmacy.EthioPharmacy;
//
//import com.EthioPharmacy.EthioPharmacy.models.CartItem;
//import com.EthioPharmacy.EthioPharmacy.models.Medicine;
//import com.EthioPharmacy.EthioPharmacy.models.Student;
//import com.EthioPharmacy.EthioPharmacy.repository.CartItemRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJdbcTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class ShoppingCartTests {
//    @Autowired
//    private CartItemRepository cartItemRepository;
//    @Autowired
//    private TestEntityManager entityManager;
//    @Test
//    public void testAddOneCartItem(){
//       Medicine medicine=  entityManager.find(Medicine.class,3);
//       Student user = entityManager.find(Student.class,4);
//        CartItem newItem = new CartItem();
//        newItem.setUser(user);
//        newItem.setMedicine(medicine);
//        newItem.setQuantity(1);
//        CartItem savedCartItem = cartItemRepository.save(newItem);
//       assert(savedCartItem.getId()>0);
//
//    }
//
//}
