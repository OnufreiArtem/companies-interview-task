package service.interfaces;

import model.Company;

import java.util.List;

public interface ICompanyService {

    Company getTopLevelParent(Company child);

    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);

}
