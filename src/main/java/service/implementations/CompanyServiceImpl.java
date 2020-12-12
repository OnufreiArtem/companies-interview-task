package service.implementations;

import model.Company;
import service.interfaces.ICompanyService;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceImpl implements ICompanyService {

    public Company getTopLevelParent(Company child) {
        return (child.getParent() == null) ? child : getTopLevelParent(child.getParent());
    }

    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long employeeCount = company.getEmployeesCount();

        List<Company> nCompanies = new ArrayList<>(companies);
        nCompanies.remove(company);

        employeeCount += companies.stream()
                .filter(child -> child.getParent() == company)
                .mapToLong(child -> getEmployeeCountForCompanyAndChildren(child, nCompanies))
                .sum();

        return employeeCount;
    }
}
