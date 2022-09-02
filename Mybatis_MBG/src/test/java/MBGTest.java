import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        查询所有数据
/*        List<Emp> emps = mapper.selectByExample(null);
        System.out.println(emps);*/
//        根据条件查询
/*        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三");//查询条件
        empExample.or().andAgeGreaterThanOrEqualTo(20);
        List<Emp> emps = mapper.selectByExample(empExample);
        System.out.println(emps);*/
//        修改方法（选择性修改不会把字段值为null的值赋给字段的属性的，一般的修改方法会）
    }
}
