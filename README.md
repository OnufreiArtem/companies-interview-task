This is the implementation of task that was recently asked by one tech company.

Given class and interface:

```
public class Company {
    private Company parent;
    private long employeesCount;
    
    //Constructors
    
    //Getters & setters
}

///////////////////////////////////////////


public interface ICompanyService {

    Company getTopLevelParent(Company child);

    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);

}


```

You need to figure out what you need to do by your own :D

So, that is my resolve.
