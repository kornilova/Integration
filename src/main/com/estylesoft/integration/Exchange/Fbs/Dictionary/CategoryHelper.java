package com.estylesoft.integration.Exchange.Fbs.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Fbs.Dictionary.CategoryDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.CategoryModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class CategoryHelper {

    private CategoryDAO categoryDAO;

    public CategoryHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.categoryDAO=new CategoryDAO(CategoryModel.class, sqlSessionFactory);
    }

    public CheckResult create(CategoryModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        categoryDAO.insert(obj);
        obj.setId(categoryDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: FBS_CATEGORY is not inserted.");
                }
        return res;
    }

    public CheckResult delete(CategoryModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        categoryDAO.delete(obj.getId());

        if (categoryDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: FBS_CATEGORY is not deleted.");
        }

        return res;
    }

    public CategoryModel getByCode(String code) throws IntegrationException {
        return categoryDAO.getByCode(code);
    }
}
