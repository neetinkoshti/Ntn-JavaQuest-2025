package org.ntn.com.javaconcepts.comparator;

import java.util.Comparator;
import java.util.List;

public class CustomSortingOfEmployee {



    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(101,"ntn",10000.0,"Pune") ,
                new Employee(125,"ram",12000.0,"mumbai") ,
                new Employee(79,"catty",8000.0,"indore") ,
                new Employee(79,"catty",9000.0,"mumbai") ,
                new Employee(105,"john",5000.0,"surat") );

        sortedByNamesInReverseOrder(employees);
        sortedBySalaryInReverseOrder(employees);
        sortByLocationAndSalary(employees);


    }

    private static void sortByLocationAndSalary(List<Employee> employees) {
        Comparator<Employee> sortByLocationInReverseOrder = (e1 , e2) -> e2.getLocation().compareTo(e1.getLocation());
        Comparator<Employee> sortedBySalaryInReverseOrder = ( e1 , e2) -> Double.compare(e2.getSalary() , e1.getSalary());

        System.out.println("Before Sorting : "+ employees);

        List<Employee> sortByLocationAndSalaryInReverseOrder = employees.stream()
                .sorted(sortByLocationInReverseOrder)
                .sorted(sortedBySalaryInReverseOrder)
                .toList();

        System.out.println("After Sorting in reverse :" +sortByLocationAndSalaryInReverseOrder);

        List<Employee> sortByLocationAndSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getLocation)
                        .thenComparing(Employee::getSalary))
                .toList();

        System.out.println("After Sorting :" +sortByLocationAndSalary);
    }

    private static void sortedBySalaryInReverseOrder(List<Employee> employees) {

        Comparator<Employee> sortBySalaryInReverseOrder = (e1 , e2) ->
                e2.getSalary() > e1.getSalary() ? 1 : (e2.getSalary() < e1.getSalary() ? -1 : 0 ) ;

        Comparator<Employee> sortedBySalary = ( e1 , e2) -> Double.compare(e2.getSalary() , e1.getSalary());

        System.out.println("Before Sorting : "+ employees);

        List<Employee> sortedBySalaryEmployees = employees.stream().sorted(sortedBySalary).toList();
        System.out.println("After Sorting : "+ sortedBySalaryEmployees);
    }

    private static void sortedByNamesInReverseOrder(List<Employee> employees) {
        Comparator<Employee> sortByNameInReverseOrder = (e1 , e2) -> e2.getName().compareTo(e1.getName());

        System.out.println("Before Sorting : "+ employees);

        List<Employee> sortedByNamesEmployees = employees.stream()
                .sorted(sortByNameInReverseOrder)
                .toList();

        System.out.println("After Sorting by Name : "+sortedByNamesEmployees);
    }

}
