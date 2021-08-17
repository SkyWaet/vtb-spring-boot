package services;

import employees.AbstractEmployee;

import java.util.List;

public interface HRService {
    List<AbstractEmployee> getStaff();

    void hire(AbstractEmployee e);

    void fire(AbstractEmployee e);

    void raiseSalary(AbstractEmployee e, double sum);
}
