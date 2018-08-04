-- Function for calculating the are of a circle
-- Header Section
CREATE OR REPLACE FUNCTION circle_area (radius NUMBER)
RETURN NUMBER IS

pi CONSTANT NUMBER (7,3) := 3.141;
area NUMBER(7,3);
-- Execution Section

BEGIN -- Area of a circle pi * r * r;
area := pi * (radius * radius);
    RETURN area;
END;
/


--IN A SEPARATE DOCUMENT YOU CAN CALL THE FUNCTION

SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE(circle_area (25));
END;
/
