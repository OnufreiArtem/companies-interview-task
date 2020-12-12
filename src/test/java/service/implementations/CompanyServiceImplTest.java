package service.implementations;

import model.Company;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompanyServiceImplTest {

    Company companyA = new Company(null, 10);
    Company companyB = new Company(companyA, 30);
    Company companyC = new Company(companyA, 5);
    Company companyD = new Company(companyA, 13);
    Company companyE = new Company(companyB, 22);
    Company companyF = new Company(companyB, 4);
    Company companyG = new Company(companyC, 10);
    Company companyH = new Company(companyG, 20);
    Company companyI = new Company(companyC, 6);
    Company companyJ = new Company(companyD, 14);
    Company companyK = new Company(companyG, 18);

    /*
                         A
                       / | \
                      B  C  D
                    / |  | \ \
                   F  E  G  I J
                        / \
                       H   K
    */

    CompanyServiceImpl companyService = new CompanyServiceImpl();

    List<Company> allCompanyList = Arrays.asList(
            companyA,
            companyB,
            companyC,
            companyD,
            companyE,
            companyF,
            companyG,
            companyH,
            companyI,
            companyJ,
            companyK
    );


    @Test
    public void whenLeafCompanyKThenTopCompanyA() {
        Assert.assertEquals(companyA, companyService.getTopLevelParent(companyK));
    }

    @Test
    public void whenLeafCompanyGThenTopCompanyA() {
        Assert.assertEquals(companyA, companyService.getTopLevelParent(companyG));
    }

    @Test
    public void whenLeafCompanyAThenTopCompanyA() {
        Assert.assertEquals(companyA, companyService.getTopLevelParent(companyA));
    }

    @Test
    public void whenChooseCompanyAThenEmployeeCount152() {
        Assert.assertEquals(152L, companyService.getEmployeeCountForCompanyAndChildren(
                companyA,
                allCompanyList
        ));
    }

    @Test
    public void whenChooseCompanyCThenEmployeeCount59() {
        Assert.assertEquals(59L, companyService.getEmployeeCountForCompanyAndChildren(
                companyC,
                allCompanyList
        ));
    }

    @Test
    public void whenChooseCompanyKThenEmployeeCount18() {
        Assert.assertEquals(18L, companyService.getEmployeeCountForCompanyAndChildren(
                companyK,
                allCompanyList
        ));
    }

    @Test
    public void whenChooseCompanyCFromSingleElementListThenEmployeeCount5() {
        Assert.assertEquals(5L, companyService.getEmployeeCountForCompanyAndChildren(
                companyC,
                Collections.singletonList(companyA)
        ));
    }
}