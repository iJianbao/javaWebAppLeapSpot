package com.smart.dao;

import com.smart.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserHibernateDao extends BaseDao {
    public User findUserByName(String userName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        List<User> users = (List<User>)getHibernateTemplate().findByCriteria(criteria);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public void save(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }
}
