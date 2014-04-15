package com.estylesoft.integration.Exchange.Fbs;


import com.estylesoft.integration.Database.mybatis.Fbs.BaseDepartmentDAO;
import com.estylesoft.integration.Model.Fbs.BaseDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class BaseDepartmentHelper {

    private BaseDepartmentDAO boDAO;

    public BaseDepartmentHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.boDAO=new BaseDepartmentDAO(BaseDepartmentModel.class, sqlSessionFactory);
    }

    public List<BaseDepartmentModel> getAll()
    {
        return boDAO.getAll();
    }
}
