package jp.co.ccube.ss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.entity.EmployeeExample;

public interface EmployeeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int deleteByPrimaryKey(Integer employeeNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    Employee selectByPrimaryKey(Integer employeeNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Fri May 25 10:36:37 JST 2018
     */
    int updateByPrimaryKey(Employee record);

	Integer countByPrimaryKey(Integer employeeNo);

	List<Employee> selectByEmployee(Employee recprd);
}