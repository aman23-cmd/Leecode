# Write your MySQL query statement below
select(
    select salary as SecondHighestSalary
from(
    select salary ,DENSE_RANK() over (order by salary desc)as rnk
    from employee
)ranked
where rnk=2
limit 1
) as SecondHighestSalary