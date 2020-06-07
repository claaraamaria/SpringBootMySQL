package rest.repository;

import org.springframework.data.jpa.domain.Specification;
import rest.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification {//implements Specification<User> {

    public static Specification<User> isUserName(String userName) {
        return (Specification<User>) (user, query, criteriaBuilder) -> criteriaBuilder.equal(user.get("userName"), userName);
    }

    public static Specification<User> isPassword(String password) {
        return (user, query, criteriaBuilder) -> criteriaBuilder.equal(user.get("password"), password);
    }
}
