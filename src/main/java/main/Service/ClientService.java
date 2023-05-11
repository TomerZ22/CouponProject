package main.Service;

import main.Exceptions.IncorrectCredentialsException;
import main.Repository.CompanyRepository;
import main.Repository.CouponRepository;
import main.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CustomerRepository customerRepo;
    @Autowired
    protected CompanyRepository companyRepo;
    @Autowired
    protected CouponRepository couponRepo;

    public ClientService() {

    }

    public abstract int login(String email, String password) throws IncorrectCredentialsException;
}