SELECT
    hId as rId,
    hColA as rColA,
    hColB as rColB
FROM src
WHERE hId >= $startRange AND hId < $endRange

-- EXCEPT SELECT DISTINCT ... (already prepared)
-- OR/ WHERE come_meta_key NOT IN (already prepared)
