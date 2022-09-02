import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testgetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "张三", null, "", ""));
        System.out.println(empByCondition);
    }

    @Test
    public void testgetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByChoose(new Emp(null, "张三", 23, "", ""));
        System.out.println(empByCondition);
    }
    @Test
    public void testdeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] a ={6,7,8};
        int i = mapper.deleteMoreByArray(a);
        System.out.println(i);

    }

    @Test
    public void testinsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "a1", 23, "男", "124");
        Emp emp1 = new Emp(null, "a1", 23, "男", "124");
        Emp emp2 = new Emp(null, "a1", 23, "男", "124");
        List<Emp> emps = Arrays.asList(emp, emp1, emp2);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }
}
