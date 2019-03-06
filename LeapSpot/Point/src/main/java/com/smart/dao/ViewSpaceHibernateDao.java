package com.smart.dao;

import com.smart.domain.ViewSpace;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ViewSpaceHibernateDao extends BaseDao {
    public void addViewSpace(ViewSpace viewSpace) {
        getHibernateTemplate().save(viewSpace);
    }

    public void updateViewSpace(ViewSpace viewSpace) {
        getHibernateTemplate().saveOrUpdate(viewSpace);
    }
    @Transactional(readOnly = true)
    public ViewSpace getViewSpace(int spaceId) {
        return getHibernateTemplate().get(ViewSpace.class, spaceId);
    }

    public List<ViewSpace> findViewSpaceByName(String spaceName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ViewSpace.class);
        criteria.add(Restrictions.eq("spaceName", spaceName));
        List<ViewSpace> list = (List<ViewSpace>)getHibernateTemplate().findByCriteria(criteria);

        return list;
    }

//    public long getViewSpaceNum() {
//        Object obj = getHibernateTemplate().iterate
//    }
}
