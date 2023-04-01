package com.example.demo.Dao;

import com.example.demo.Beans.Company;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface CompaniesRepository {

    void deleteCustomerPurchaseHistory(int id) throws SQLException; // This method is when we delete a company.
    void deleteCompanyCoupons(int id) throws SQLException; // This method is when we delete a company.
    boolean isCompanyExistByName_Email(String name, String email) throws CompanyExistsException, SQLException; //This method is for the AdminFacade check.

    int isCompanyExists(String email, String password) throws SQLException;
    void addCompany(Company company) throws SQLException;
    void updateCompanyAdminFacade(Company company) throws SQLException, CompanyExistsException;

    void updateCompany(Company company) throws SQLException;

    void deleteCompany(int companyId) throws SQLException;
    Company getOneCompany(int companyId) throws SQLException;
    List<Company> getAllCompanies() throws SQLException;
}
