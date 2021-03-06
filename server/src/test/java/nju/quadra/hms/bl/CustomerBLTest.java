package nju.quadra.hms.bl;

import nju.quadra.hms.blservice.CustomerBLService;
import nju.quadra.hms.blservice.UserBLService;
import nju.quadra.hms.model.MemberType;
import nju.quadra.hms.model.ResultMessage;
import nju.quadra.hms.model.UserType;
import nju.quadra.hms.vo.MemberVO;
import nju.quadra.hms.vo.UserVO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.time.LocalDate;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerBLTest {
    private CustomerBLService customerBLService;
    private UserBLService userBLService;

    @Before
    public void init() {
        customerBLService = new CustomerBL();
        userBLService = new UserBL();
        UserVO vo = new UserVO("TEST|username1", "TEST|passwordEncrypted1", "TEST|name1", "TEST|contact1", UserType.CUSTOMER);
        userBLService.add(vo);
    }

    @Test
    public void test1_GetMemberInfo() {
        String username = "TEST|username1";
        assertNotNull(customerBLService.getMemberInfo(username));
    }

    @Test
    public void test2_Enroll() {
        MemberVO vo = new MemberVO("TEST|username1", MemberType.PERSONAL, LocalDate.parse("1987-02-03"), null);
        assertEquals(ResultMessage.RESULT_SUCCESS, customerBLService.enroll(vo).result);
    }

    @After
    public void clean() {
        userBLService.delete("TEST|username1");
    }
}
