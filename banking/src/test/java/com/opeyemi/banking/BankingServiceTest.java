package com.opeyemi.banking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;

import com.opeyemi.banking.entity.Transactions;
import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.repository.TransactionRepository;
import com.opeyemi.banking.services.UserService;
import com.opeyemi.banking.services.UserServiceImp;


@RunWith(MockitoJUnitRunner.class)
public class BankingServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private UserService userService = new UserServiceImp(null, transactionRepository, null);

    @Test
    public void getUserTransactionHistoryTest(){
        String username = "Opeyemi";
        User user = userService.fetchUser(Long.parseLong("1"));

        assertEquals(username, user.getUsername());
    }
    
}
