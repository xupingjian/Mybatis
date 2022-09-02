import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testgetEmpByEid() throws IOException {
/*
//        同一个sqlsession下查询相同的数据会自动一级缓存
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(3);
        System.out.println(empByEid);
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid1 = mapper2.getEmpByEid(3);
        System.out.println(empByEid1);
*/

        //        不同的sqlsession下查询相同的数据
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(3);
        System.out.println(empByEid);
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp empByEid1 = mapper2.getEmpByEid(3);
        System.out.println(empByEid1);

        }
    @Test
    public  void testTwoCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession1 = build.openSession(true);

        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        Emp empByEid = mapper.getEmpByEid(1);
        System.out.println(empByEid);
        sqlSession.close();

        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);

        Emp empByEid1 = mapper1.getEmpByEid(1);
        System.out.println(empByEid1);
        sqlSession1.close();
    }

}
