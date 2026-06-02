# Write your MySQL query statement below
WITH RECURSIVE TreeHierarchy AS
(
    SELECT
        id,
        p_id,
        1 AS level
    FROM Tree
    WHERE p_id IS NULL

    UNION ALL

    SELECT
        t.id,
        t.p_id,
        th.level + 1
    FROM Tree t
    JOIN TreeHierarchy th
        ON t.p_id = th.id
)

SELECT
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN
        (
            SELECT DISTINCT p_id
            FROM Tree
            WHERE p_id IS NOT NULL
        ) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM TreeHierarchy
ORDER BY id;