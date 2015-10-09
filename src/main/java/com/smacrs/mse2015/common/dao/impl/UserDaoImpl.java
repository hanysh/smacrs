package com.smacrs.mse2015.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.LutUserType;
import java.math.BigInteger;
//import com.smacrs.mse2015.common.entity.User;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

@PersistenceContext 
private EntityManager em;
        
//	public User getUser(User user) { 
//		javax.persistence.Query query=em.createNamedQuery("User.findByUserNameAndPassword");
//		query.setParameter("userName",user.getUserName() );
//		query.setParameter("password", user.getPassword());
//		User updatedUser=(User) query.getSingleResult();
//		return  updatedUser;
//	}

    public List<LutUserType> getAllType() {
        javax.persistence.Query query=em.createNamedQuery("LutUserType.findAll");
		List<LutUserType> usertypes=(List<LutUserType>) query.getResultList();
		return  usertypes;
    }

   
    public boolean insertMessage(CommonMessage message) {
      em.persist(message);
      return true;
    }

    public boolean insertObject(Object o) {
        em.persist(o);
        return true;
    }

    public int getUserId(String code ,String table ) {
        javax.persistence.Query query=em.createNativeQuery("Select user_id from "+table+" o where o.code ="+code);
         Integer userId= (Integer) query.getSingleResult();
        System.out.println("userid  :::  "+userId);
//        Integer grandChildCount = ((BigInteger) count).intValue();
        return userId;
    }
    
    public List<CommonMessage> findMessage(Map<String,Object> filter,int from,int to){
        String q="Select o from CommonMessage o ";
        javax.persistence.Query query=em.createNativeQuery("SELECT * FROM common_message c ",(Class)CommonMessage.class);
//        query.setFirstResult(from);
//        query.setMaxResults(to);
        List<CommonMessage> messages=query.getResultList();
        if(filter != null && filter.size() > 0){
//            q+=" Where ";
//            for(Map.Entry<String, String> entry:filter.entrySet()){
//                q +=entry.getKey()+"="
//            }
        }
//        Query query = this.em.createNativeQuery(q, (Class)Candidatedata.class);
//        query.setFirstResult(start);
//        query.setMaxResults(rows);
//        List list = query.getResultList();
        return messages;
    }

    public int getMessageCount(Map<String, Object> filter) {
       String q="Select o from CommonMessage o ";
        javax.persistence.Query query=em.createNativeQuery("SELECT count(*) FROM common_message c ");

        BigInteger count=(BigInteger) query.getSingleResult();
        System.out.println("ccccccccccc  :::  "+count);
        if(filter != null && filter.size() > 0){
//            q+=" Where ";
//            for(Map.Entry<String, String> entry:filter.entrySet()){
//                q +=entry.getKey()+"="
//            }
        }
        Integer grandChildCount = ((BigInteger) count).intValue();
        return grandChildCount;
    }
}
