package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.EmployeeSearchDto.EmployeeSearchRequest;
import com.mitrahsoft.company_management.dto.EmployeeSearchDto.FilterWrapper;
import com.mitrahsoft.company_management.dto.EmployeeSearchDto.SearchCondition;
import com.mitrahsoft.company_management.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {

    public static Specification<Employee> getSearchSpecification(EmployeeSearchRequest request) {
        return (root, query, criteriaBuilder) -> {
            if (request.getFilters() == null || request.getFilters().getConditions() == null) {
                return criteriaBuilder.conjunction();
            }

            List<Predicate> predicates = new ArrayList<>();
            FilterWrapper filterWrapper = request.getFilters();

            for (SearchCondition condition : filterWrapper.getConditions()) {
                // Map incoming json fields like "empName" safely to entity fields like "name"
                String column = condition.getColumnName();
//                if ("empName".equals(column)) {
//                    column = "name";
//                }

                String operator = condition.getOperator();
                String value = condition.getValue();

                switch (operator) {
                    case "equals":
                        predicates.add(criteriaBuilder.equal(root.get(column), value));
                        break;
                    case "greaterThan":
                        predicates.add(criteriaBuilder.greaterThan(root.get(column), Double.valueOf(value)));
                        break;
                    case "lessThan":
                        predicates.add(criteriaBuilder.lessThan(root.get(column), Double.valueOf(value)));
                        break;
                    case "like":
                        predicates.add(criteriaBuilder.like(
                                criteriaBuilder.lower(root.get(column)),
                                "%" + value.toLowerCase() + "%"
                        ));
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + operator);
                }
            }

            if ("or".equalsIgnoreCase(filterWrapper.getOperator())) {
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            } else {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
