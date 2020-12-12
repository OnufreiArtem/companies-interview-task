package model;

/** class Company
 *  Represents the company class. Contains the parent company and employee count
 *  @version : 1.0
 *  @author Artem Onufrei
 */

public class Company {
    private Company parent;
    private long employeesCount;

    public Company() {
    }

    public Company(Company parent, long employeesCount) {
        this.parent = parent;
        this.employeesCount = employeesCount;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }
}
