package me.ktpark;

import me.ktpark.websvc.base.controller.TransactionController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.swing.tree.TreeNode;

@SpringBootTest
public class RestControllerTest {

    @Autowired
    private TransactionController transactionController;

    @Test
    @DisplayName("JSON 요청")
    void callRestController() {

    }

}
