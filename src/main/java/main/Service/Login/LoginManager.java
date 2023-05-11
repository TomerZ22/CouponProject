package main.Service.Login;

import main.Enums.ClientType;
import main.Exceptions.IncorrectCredentialsException;
import main.Exceptions.LoginErrorException;
import main.Exceptions.NotFoundException;
import main.Service.AdminService;
import main.Service.ClientService;
import main.Service.CompanyService;
import main.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {
    @Autowired
    AdminService adminService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CustomerService customerService;

    public LoginManager() {
    }

    /**checks client type and tries to log in with it and given email and password
     * @param email email of the requested user
     * @param password password of the requested user
     * @param clientType client type of the requested user (Administrator/Company/CUSTOMER)
     * @return a service of the requested Administrator/Company/CUSTOMER
     * @throws IncorrectCredentialsException incorrect email or password
     * @throws NotFoundException unknown client type
     */
    public ClientService Login(String email, String password, ClientType clientType)
            throws IncorrectCredentialsException, NotFoundException, LoginErrorException {
        switch (clientType){

            case Administrator:
                AdminService adminService = new AdminService();
                if (email.equals("admin@admin.com")  && password.equals("admin")) {
                    return adminService;
                }
                else
                    throw new LoginErrorException("Your email or password isn't valid");

            case Company:
                if(companyService.login(email, password) > 0) {
                    return companyService;
                }
                else throw new IncorrectCredentialsException();

            case Customer:
                if(customerService.login(email, password) > 0){
                    return customerService;
                }
                else throw new IncorrectCredentialsException();
        }
        throw new NotFoundException("Unknown Client Type");
    }
}