package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.EmployeeDto.ConditionDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.FilterRequestDto;
import com.mitrahsoft.company_management.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {

    public static Specification<Employee> getSpecification(FilterRequestDto filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (ConditionDto condition : filter.getConditions()) {
                switch (condition.getOperator()) {

                    case "equals":
                        predicates.add(cb.equal(root.get(condition.getColumnName()), condition.getValue()));
                        break;

                    case "greaterThan":
                        predicates.add(cb.greaterThan(root.get(condition.getColumnName()), condition.getValue()));
                        break;

                    case "lessThan":
                        predicates.add(cb.lessThan(root.get(condition.getColumnName()), condition.getValue()));
                        break;

                    case "like":
                        predicates.add(cb.like(root.get(condition.getColumnName()), "%" + condition.getValue() + "%"));
                        break;
                }
            }

            if ("or".equalsIgnoreCase(filter.getOperator())) {
                return cb.or(predicates.toArray(new Predicate[0]));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}