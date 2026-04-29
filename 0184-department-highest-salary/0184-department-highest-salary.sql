# Write your MySQL query statement below
Select d.name as Department , e.name as Employee,e.salary as Salary
from Employee e
join Department d
on d.id=e.departmentId
where e.salary=(select max(salary)from employee where 
departmentId=e.departmentId)
#group by e.departmentId