import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;

public class PageHelperTest {
    /*
    * limit index,pageSize
    * index:当前页的起始索引
    * pageSize：每页显示的条数
    * pageNumL:当前页的页码
    * index=(pageNum-1)*pageSize*/

    /*
    * 使用Mybatis的分页插件实现分页功能
    * 1.需要在查询功能之前开启分页： PageHelper.startPage(1,4);
    * 2.在查询功能之后获取分页相关的信息
    * PageInfo<Emp> page = new PageInfo<>(emps,3);
    * */
    @Test
    public void pagetest() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(1,4);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(emps,3);
        emps.forEach(emp-> System.out.println(emp));
        System.out.println(page);
    }
}
