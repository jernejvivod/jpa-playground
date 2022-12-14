package si.jernej.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import si.jernej.entity.enums.EmployeeEntityGenderEnum;

@Entity
@Table(name = "employees", schema = "employees")
public class EmployeeEntity implements Serializable
{
    @Id
    @Column(name = "emp_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Convert(converter = EmployeeEntityGenderEnum.JPAConverter.class)
    @Column(name = "gender")
    private EmployeeEntityGenderEnum gender;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    public Long getEmpNo()
    {
        return empNo;
    }

    public void setEmpNo(Long empNo)
    {
        this.empNo = empNo;
    }

    public LocalDateTime getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public EmployeeEntityGenderEnum getGender()
    {
        return gender;
    }

    public void setGender(EmployeeEntityGenderEnum gender)
    {
        this.gender = gender;
    }

    public LocalDateTime getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate)
    {
        this.hireDate = hireDate;
    }
}
