import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.peanut.MySqlServerMain;
import com.peanut.entity.po.*;
import com.peanut.entity.vo.HeroDetailVO;
import com.peanut.mapper.*;
import com.peanut.service.OrderHeroService;
import com.peanut.service.TestConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = MySqlServerMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TestConnection testConnection;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private AreaPOMapper areaPOMapper;
    @Autowired
    private MemberPOMapper memberPOMapper;
    @Autowired
    private PlanPOMapper planPOMapper;
    @Autowired
    private HeroPOMapper heroPOMapper;
    @Autowired
    private OrderHeroPOMapper orderHeroPOMapper;
    /**
     * 测试连接
     * @throws SQLException
     */
    @Test
    public void testConnection() throws SQLException {
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsert(){
        testConnection.insert(1,"张三",18);
    }

    @Test
    public void testEncoder(){
        String preEncode = "123";
        String AfterEncode = encoder.encode(preEncode);
        System.out.println(AfterEncode);
    }

    @Test
    public void testSelectAllArea(){
        List<AreaPO> areaPOS = areaPOMapper.selectAll();
        for(AreaPO areaPO : areaPOS){
            System.out.println(areaPO);
        }
    }

    @Test
    public void testSelectMemberPOByUserName(){
        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo("Jack");
        List<MemberPO> memberPOS = memberPOMapper.selectByExample(example);
        MemberPO memberPO = memberPOS.get(0);
        System.out.println(memberPO);
    }

    @Test
    public void testSelectPageUp(){
        PageHelper.startPage(1,5);
        List<AreaPO> areaPOS = areaPOMapper.selectAll();
        PageInfo page = new PageInfo(areaPOS);
        for(AreaPO areaPO : areaPOS){
            System.out.println(areaPO);
        }
    }

    @Test
    public void testSelectPlanPage(){
        PageHelper.startPage(1,4);
        PlanPOExample example = new PlanPOExample();
        PlanPOExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(1);
        List<PlanPO> planPOS = planPOMapper.selectByExample(example);
        for(PlanPO planPO : planPOS){
            System.out.println(planPO);
        }
    }

    @Test
    public void testSelectImgBig(){
        PageHelper.startPage(1,5);
        List<HeroPO> heroPOList =  heroPOMapper.selectBigImgDesc();
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testGetAllHero(){
        List<HeroPO> heroPOList = heroPOMapper.selectAll();
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testNameLike(){
        List<HeroPO> heroPOList = heroPOMapper.selectByName("之");
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testGetDetailHero(){
        HeroDetailVO heroDetail = heroPOMapper.getHeroDetail(1);
        System.out.println(heroDetail);
    }

    @Test
    public void testGetScotHero(){
        PageHelper.startPage(1,10);
        List<HeroPO> heroPOList = heroPOMapper.selectScotHero();
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testGetAllScotHero(){
        PageHelper.startPage(1,0);
        List<HeroPO> heroPOList = heroPOMapper.selectAllStickHero();
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testGetStickHeroCondition(){
        PageHelper.startPage(1,8);
        List<HeroPO> heroPOList = heroPOMapper.selectStickHeroByConition("之", 10, 30);
        for(HeroPO heroPO : heroPOList){
            System.out.println(heroPO);
        }
    }

    @Test
    public void testSortDeleteOrderHero(){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(9);
        objects.add(7);
        orderHeroPOMapper.deleteOrderByList(objects,2);
    }
}
